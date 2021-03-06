package src.feats;

import src.Pathfinder;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import src.Character;
import src.stats.AbilityScoreEnum;
import src.stats.SkillUtils;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

/**
 * Created by Matthew on 6/4/2016.
 */
public class Feats {

    //Searching for/getting feats

    public static Feat getFeatByName(String name){
        for(Feat feat : getFeats()){
            if(feat.name.equalsIgnoreCase(name))
                return feat;
        }
        return null;
    }

    public static Feat createNewFeat(Window parent){
        AtomicBoolean featMade = new AtomicBoolean(false);
        AtomicBoolean closed = new AtomicBoolean(false);
        JDialog featCreator = new JDialog(parent, "Create a new Feat");
        JPanel panel = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new BorderLayout());
        JPanel bottom = new JPanel(new BorderLayout());
        JPanel middle = new JPanel(new BorderLayout());
        featCreator.add(panel);
        panel.add(top, BorderLayout.NORTH);
        panel.add(bottom, BorderLayout.SOUTH);
        panel.add(middle, BorderLayout.CENTER);
        top.add(new JLabel("Name: "), BorderLayout.WEST);
        middle.add(new JLabel("Feat details (supports HTML formatting): "), BorderLayout.NORTH);

        JTextField name = new JTextField();
        top.add(name, BorderLayout.CENTER);

        JTextArea description = new JTextArea();
        JScrollPane descScroll = new JScrollPane(description);
        middle.add(descScroll, BorderLayout.CENTER);

        JButton add = new JButton("Add this feat");
        JButton addAndSave = new JButton("Add and save this feat");

        bottom.add(addAndSave, BorderLayout.EAST);
        bottom.add(add, BorderLayout.CENTER);

        add.addActionListener(e -> {
            if(!(name.getText().equals("")||description.getText().equals("")))
                featMade.set(true);
            else
                Pathfinder.showError("Not enough details","You must write a feat name and description.");
        });

        addAndSave.addActionListener(e -> {
            if(!(name.getText().equals("")||description.getText().equals(""))){
                Feat feat = new Feat(name.getText(), description.getText());
                JFileChooser saver = new JFileChooser();
                int returned = saver.showSaveDialog(featCreator);
                if(returned == JFileChooser.APPROVE_OPTION){
                    try{
                        FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
                        ObjectOutputStream out= new ObjectOutputStream(fileOut);
                        out.writeObject(feat);
                        featMade.set(true);
                    } catch (FileNotFoundException ex){
                        Pathfinder.showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
                        ex.printStackTrace();
                    } catch (IOException ex){
                        Pathfinder.showError("Unknown Exception","The file could not be saved.\nRun this in command for more information.");
                        ex.printStackTrace();
                    }
                }
            } else {
                Pathfinder.showError("Not enough details","You must write a feat name and description.");
            }
        });

        featCreator.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed.set(true);
                featMade.set(true);
            }
        });

        featCreator.setSize(350,400);
        featCreator.setVisible(true);
        featCreator.setLocationRelativeTo(parent);

        while(!featMade.get()){}

        featCreator.dispose();

        if(closed.get()) return null;
        return new Feat(name.getText(), description.getText());
    }

    public static void showFeatDetails(Feat feat, List<Feat> collection1, JComponent toRepaint){
        showFeatDetails(feat, feat.name, collection1, null, toRepaint);
    }

    public static void showFeatDetails(Feat feat, String title, List<Feat> collection1, List<Feat> collection2, JComponent toRepaint){
        JFrame detailsFrame = new JFrame(title);
        detailsFrame.setSize(450,550);
        detailsFrame.setLocationRelativeTo(Pathfinder.FRAME);
        JPanel detailsPanel = new JPanel(new BorderLayout());

        JEditorPane text = new JEditorPane();
        text.setEditorKit(new HTMLEditorKit());
        text.setText(feat.fullText);
        text.setEditable(false);
        text.setCaretPosition(0);

        JScrollPane scrollingText = new JScrollPane(text);
        scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton toggleEdit = new JButton("Edit");
        toggleEdit.addActionListener(e ->{
            new Thread(){
                public void run(){
                    Feat edited = editFeat(detailsFrame, feat);
                    if(edited != null && edited != feat && collection1 != null){
                        collection1.set(collection1.indexOf(feat), edited);
                        if(collection2 != null) collection2.set(collection2.indexOf(feat), edited);

                        if(toRepaint != null) toRepaint.repaint();

                        detailsFrame.dispose();
                        showFeatDetails(edited, edited.name, collection1, collection2, toRepaint);
                    }
                }
            }.start();
        });

        detailsFrame.add(detailsPanel);
        detailsPanel.add(scrollingText, BorderLayout.CENTER);
        detailsPanel.add(toggleEdit, BorderLayout.SOUTH);
        detailsFrame.setVisible(true);
    }

    public static Feat editFeat(Window parent, Feat feat){
        JDialog featEditor = new JDialog(parent, feat.name);
        JPanel panel = new JPanel(new BorderLayout());
        featEditor.add(panel);
        AtomicBoolean set = new AtomicBoolean(false);
        AtomicBoolean closed = new AtomicBoolean(false);

        JPanel top = new JPanel(new GridBagLayout());
        JTextField name = new JTextField(feat.name);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        top.add(new JLabel("Name: "), c);
        c.weightx = 1;
        c.gridx = 1;
        top.add(name, c);
        panel.add(top, BorderLayout.NORTH);


        JPanel middle = new JPanel(new BorderLayout());

        JEditorPane text = new JEditorPane();
        text.setContentType("text/html");
        text.setText(feat.fullText);
        text.setEditable(false);
        String current = text.getText();
        text.setContentType("text/plain");
        text.setText(current);
        text.setCaretPosition(0);

        JScrollPane textScroll = new JScrollPane(text);
        middle.add(new JLabel("Feat details (supports HTML formatting): "), BorderLayout.NORTH);
        middle.add(textScroll, BorderLayout.CENTER);
        panel.add(middle, BorderLayout.CENTER);


        JPanel bottom = new JPanel(new GridBagLayout());
        JButton save = new JButton("Save");
        JButton saveToFile = new JButton("Save and save to file");
        c.gridx = 0;
        bottom.add(save, c);
        c.gridx = 1;
        bottom.add(saveToFile, c);
        panel.add(bottom, BorderLayout.SOUTH);

        save.addActionListener(e -> {
            if(!(name.getText().equals("") || text.getText().equals(""))) set.set(true);
            else Pathfinder.showError("Insufficient Details", "You must provide a name and a description.");
        });

        saveToFile.addActionListener(e -> {
            if(name.getText().equals("") || text.getText().equals("")){
                Pathfinder.showError("Insufficient Details", "You must provide a name and a description.");
                return;
            }

            Feat edited = new Feat(feat, name.getText(), text.getText());

            JFileChooser saver = new JFileChooser();
            int returned = saver.showSaveDialog(featEditor);
            if(returned == JFileChooser.APPROVE_OPTION){
                try{
                    FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
                    ObjectOutputStream out= new ObjectOutputStream(fileOut);
                    out.writeObject(edited);
                    set.set(true);
                } catch (FileNotFoundException ex){
                    Pathfinder.showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
                    ex.printStackTrace();
                } catch (IOException ex){
                    Pathfinder.showError("Unknown Exception","The file could not be saved.\nRun this in command for more information.");
                    ex.printStackTrace();
                }
            }
        });

        featEditor.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed.set(true);
                set.set(true);
            }
        });

        featEditor.setSize(350,400);
        featEditor.setVisible(true);
        featEditor.setLocationRelativeTo(parent);

        while(!set.get()){}

        if(closed.get()) return null;
        return new Feat(feat, name.getText(), text.getText());
    }

    public static void featAddedAutomatically(Feat feat, List<Feat> collection1){
        Feats.showFeatDetails(feat, feat.name + " was added automatically", collection1, null, null);
    }

    public static List<Feat> getFeats(){
        BufferedReader input = new BufferedReader(new InputStreamReader(Feats.class.getResourceAsStream("/src/databases/Feats.txt")));

        List<Feat> feats = new ArrayList<>();

        if (input == null) {
            return feats;
        }

        Feat feat;

        try{
            String featInputString = input.readLine();

            while((featInputString = input.readLine()) != null){
                try{
                    feat = new Feat(featInputString);
                    feats.add(feat);
                } catch(Exception e){
                    Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
                    e.printStackTrace();
                    System.out.println(Arrays.asList(featInputString.split("\t")));
                }
            }
        }catch(Exception e){
            Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nSome valid feats may not be shown.");
            e.printStackTrace();
            return Collections.emptyList();
        }
        return feats;
    }

    public static List<Feat> getAvailableFeats(Character me){
        ArrayList<Feat> feats = new ArrayList<>();
        feats.addAll(getFeats().stream().filter(feat -> characterMeetsAllPrereqs(feat, me)).filter(feat -> !characterHasFeat(feat.toString(), me) || feat.canDoMultiple).collect(Collectors.toList()));
        return feats;
    }

    public static URL getIcon(Feat feat){
        if(feat.type.equals("Combat")){
            return Feats.class.getResource("/src/pictures/FeatIcons/S_Buff02.png");
        }
        if(feat.type.equals("Item Creation")){
            return Feats.class.getResource("/src/pictures/FeatIcons/S_Buff03.png");
        }
        if(feat.type.equals("Metamagic")){
            return Feats.class.getResource("/src/pictures/FeatIcons/S_Buff06.png");
        }
        if(feat.type.equals("Mythic")){
            return Feats.class.getResource("/src/pictures/FeatIcons/S_Buff14.png");
        }
        if(feat.type.equals("Achievement") || feat.type.equals("Story")){
            return Feats.class.getResource("/src/pictures/FeatIcons/S_Buff08.png");
        }

        return Feats.class.getResource("/src/pictures/FeatIcons/S_Buff01.png");
        //Definitely needs more.
    }

    //Checking for requirements.

    public static boolean characterMeetsAllPrereqs(Feat feat, Character me){
        return checkGeneralReqs(feat.prereqsAsString, me) && checkReqsAsFeats(feat.prereqFeatsAsString, me) && characterMeetsSkillSpecificPrereqs(feat.prereqsSkillsAsString, me);
    }

    private static boolean checkGeneralReqs(String prereqs, Character me){
        if(prereqs == null || prereqs.trim().equals("")) return true;

        prereqs = prereqs.trim();

        if(prereqs.charAt(prereqs.length() - 1) == '.')
            prereqs = prereqs.substring(0,prereqs.length() - 1);

        prereqs = prereqs.replace("; ",", ");

        if(prereqs.contains(", ")){

            String[] parts = fixParenthesisIssues(fixQuotationIssues(prereqs.split(", "), ", "), ", ");

            if(parts.length > 1){
                if(parts[parts.length - 1].substring(0,3).equals("or ")){
                    return Arrays.stream(parts).anyMatch(part -> checkGeneralReqs(part, me));

                }

                return !Arrays.stream(parts).anyMatch(part -> !checkGeneralReqs(part, me));
            }

            //First part is used a lot, so let's pull it out
            String firstPart = parts[0];

            firstPart = firstPart.trim();

            if(firstPart.charAt(0) == '(' && firstPart.charAt(firstPart.length() - 1) == ')'){
                String inside = firstPart.substring(1, firstPart.length() - 1);
                if(!(netOpens(inside) || netCloses(inside))) {
                    return checkGeneralReqs(inside, me);
                }
            }

            if(firstPart.charAt(0) == '\"' && firstPart.charAt(firstPart.length() - 1) == '\"' && firstPart.length() - firstPart.replace("\"","").length() == 2){
                return characterMeetsThisGeneralPrereq(parts[0], me);
            }
        }

        if(prereqs.contains("|")) {
            String[] parts = fixParenthesisIssues(fixQuotationIssues(prereqs.split("\\|"), "|"), "|");
            String firstPart = parts[0];

            if (parts.length > 1) {
                return Arrays.stream(parts).anyMatch(part -> checkGeneralReqs(part, me));
            }

            firstPart = firstPart.trim();

            if (firstPart.charAt(0) == '(' && firstPart.charAt(firstPart.length() - 1) == ')') {
                String inside = firstPart.substring(1, firstPart.length() - 1);
                if (!(netOpens(inside) || netCloses(inside))) {
                    return checkGeneralReqs(inside, me);
                }
            }

            if(firstPart.charAt(0) == '\"' && firstPart.charAt(firstPart.length() - 1) == '\"' && firstPart.length() - firstPart.replace("\"","").length() == 2){
                return characterMeetsThisGeneralPrereq(firstPart, me);
            }
        }

        if(prereqs.contains(" or ")) {
            String[] parts = fixParenthesisIssues(fixQuotationIssues(prereqs.split(" or "), " or ")," or ");

            if(parts.length > 1){
                for(String preReq : parts) if(checkGeneralReqs(preReq, me)) return true;
                return false;
            }

            parts[0] = parts[0].trim();

            if(parts[0].charAt(0) == '(' && parts[0].charAt(parts[0].length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside))) {
                    return checkGeneralReqs(inside, me);
                }
            }

            if(parts[0].charAt(0) == '\"' && parts[0].charAt(parts[0].length() - 1) == '\"' && parts[0].length() - parts[0].replace("\"","").length() == 2){
                return characterMeetsThisGeneralPrereq(parts[0], me);
            }
        }

        return characterMeetsThisGeneralPrereq(prereqs, me);
    }

    private static boolean characterMeetsSkillSpecificPrereqs(String prereqs, Character me){
        if(prereqs == null || prereqs.trim().equals("")) return true;

        prereqs = prereqs.trim();

        if(prereqs.contains(", ")){

            String[] parts = fixParenthesisIssues(fixQuotationIssues(prereqs.split(", "), ", "), ", ");

            if(parts.length > 1){
                if(parts[parts.length - 1].substring(0,3).equals("or ")){
                    for(String requirement : parts) if(characterMeetsSkillSpecificPrereqs(requirement, me)) return true;
                    return false;
                }
                for(String requirement : parts) if(!characterMeetsSkillSpecificPrereqs(requirement, me)) return false;
                return true;
            }

            parts[0] = parts[0].trim();

            if(parts[0].charAt(0) == '(' && parts[0].charAt(parts[0].length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside))) {
                    return characterMeetsSkillSpecificPrereqs(inside, me);
                }
            }

            if(parts[0].charAt(0) == '\"' && parts[0].charAt(parts[0].length() - 1) == '\"' && parts[0].length() - parts[0].replace("\"","").length() == 2){
                return characterMeetsThisSkillPrereq(parts[0], me);
            }

        }

        if(prereqs.contains("|")) {
            String[] parts = fixParenthesisIssues(fixQuotationIssues(prereqs.split("\\|"), "|"), "|");

            if (parts.length > 1) {
                for (String requirement : parts) if (characterMeetsSkillSpecificPrereqs(requirement, me)) return true;
                return false;
            }

            parts[0] = parts[0].trim();

            if (parts[0].charAt(0) == '(' && parts[0].charAt(parts[0].length() - 1) == ')') {
                String inside = parts[0].substring(1, parts[0].length() - 1);
                if (!(netOpens(inside) || netCloses(inside))) {
                    return characterMeetsSkillSpecificPrereqs(inside, me);
                }
            }

            if(parts[0].charAt(0) == '\"' && parts[0].charAt(parts[0].length() - 1) == '\"' && parts[0].length() - parts[0].replace("\"","").length() == 2){
                return characterMeetsThisSkillPrereq(parts[0], me);
            }
        }

        if(prereqs.contains(" or ")) {
            String[] parts = fixParenthesisIssues(fixQuotationIssues(prereqs.split(" or "), " or ")," or ");

            if(parts.length > 1){
                for(String preReq : parts) if(characterMeetsSkillSpecificPrereqs(preReq, me)) return true;
                return false;
            }

            parts[0] = parts[0].trim();

            if(parts[0].charAt(0) == '(' && parts[0].charAt(parts[0].length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside))) {
                    return characterMeetsSkillSpecificPrereqs(inside, me);
                }
            }

            if(parts[0].charAt(0) == '\"' && parts[0].charAt(parts[0].length() - 1) == '\"' && parts[0].length() - parts[0].replace("\"","").length() == 2){
                return characterMeetsThisSkillPrereq(parts[0], me);
            }
        }

        return characterMeetsThisSkillPrereq(prereqs, me);
    }

    private static boolean checkReqsAsFeats(String featReqs, Character me){
        if(featReqs == null || featReqs.equals("")) return true;

        featReqs = featReqs.trim();

        if(featReqs.contains(", ")){
            String[] parts = fixParenthesisIssues(fixQuotationIssues(featReqs.split(", "), ", "), ", ");
            if(parts.length > 1){
                if(parts[parts.length - 1].substring(0,3).equals("or ")){
                    for(String preReq : parts) if(checkReqsAsFeats(preReq, me)) return true;
                    return false;
                }
                for(String preReq : parts) if(!checkReqsAsFeats(preReq, me)) return false;
                return true;
            }

            parts[0] = parts[0].trim();

            if(parts[0].charAt(0) == '(' && parts[0].charAt(parts[0].length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside))) {
                    return checkReqsAsFeats(inside, me);
                }
            }

            if(parts[0].trim().charAt(parts[0].trim().length() - 1) == ')' && !(parts[0].trim().charAt(0) == '(')){
                String reqWithoutParenthesis = parts[0].trim().substring(0,parts[0].indexOf("("));
                if(!(reqWithoutParenthesis.contains(", ") || reqWithoutParenthesis.contains(" or ") || reqWithoutParenthesis.contains("|"))) return characterHasFeatSubTypes(parts[0], me);
            }
        }

        if(featReqs.contains("|")){
            String[] parts = fixParenthesisIssues(fixQuotationIssues(featReqs.split("\\|"), "|"), "|");

            if(parts.length > 1){
                for(String preReq : parts) if(checkReqsAsFeats(preReq, me)) return true;
                return false;
            }

            if(parts[0].charAt(0) == '(' && parts[0].charAt(parts[0].length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside))) {
                    return checkReqsAsFeats(inside, me);
                }
            }

            if(parts[0].trim().charAt(parts[0].trim().length() - 1) == ')' && !(parts[0].trim().charAt(0) == '(')){
                String reqWithoutParenthesis = parts[0].trim().substring(0,parts[0].indexOf("("));
                if(!(reqWithoutParenthesis.contains(", ") || reqWithoutParenthesis.contains(" or ") || reqWithoutParenthesis.contains("|"))) return characterHasFeatSubTypes(parts[0], me);
            }
        }

        if(featReqs.contains(" or ")) {
            String[] parts = fixParenthesisIssues(fixQuotationIssues(featReqs.split(" or "), " or "), " or ");

            if(parts.length > 1){
                for(String preReq : parts) if(checkReqsAsFeats(preReq, me)) return true;
                return false;
            }

            if(parts[0].charAt(0) == '(' && parts[0].charAt(parts[0].length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside))) {
                    return checkReqsAsFeats(inside, me);
                }
            }

            if(parts[0].trim().charAt(parts[0].trim().length() - 1) == ')' && !(parts[0].trim().charAt(0) == '(')){
                String reqWithoutParenthesis = parts[0].trim().substring(0,parts[0].indexOf("("));
                if(!(reqWithoutParenthesis.contains(", ") || reqWithoutParenthesis.contains(" or ") || reqWithoutParenthesis.contains("|"))) return characterHasFeatSubTypes(parts[0], me);
            }
        }

        return characterHasFeat(featReqs, me);
    }

    private static boolean characterHasFeatSubTypes(String toCheck, Character me){

        if(!(toCheck.contains("(") && toCheck.contains(")"))) return characterHasFeat(toCheck, me);

        String baseFeat = toCheck.substring(0,toCheck.indexOf("(")).trim();
        toCheck = toCheck.substring(toCheck.indexOf("(") + 1, toCheck.lastIndexOf(")"));

        return characterHasFeatSubTypes(toCheck, baseFeat, me);
    }

    private static boolean characterHasFeatSubTypes(String toCheck, String baseFeat, Character me){
        if(toCheck.contains(", ")){
            String[] parts = fixParenthesisIssues(fixQuotationIssues(toCheck.split(", "), ", "), ", ");
            if(parts.length > 1){
                if(parts[parts.length - 1].substring(0,3).equals("or ")){
                    for(String preReq : parts)
                        if(characterHasFeatSubTypes(preReq, baseFeat, me))
                            return true;
                    return false;
                }
                for(String preReq : parts)
                    if(!characterHasFeatSubTypes(preReq,baseFeat, me))
                        return false;
                return true;
            }

            if(parts[0].trim().charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')')
                return characterHasFeatSubTypes(parts[0].trim().substring(1,parts[0].trim().length() - 1), baseFeat,  me);
        }

        if(toCheck.contains("|")){
            String[] parts = fixParenthesisIssues(fixQuotationIssues(toCheck.split("\\|"), "|"), "|");

            if(parts.length > 1){
                for(String preReq : parts)
                    if(characterHasFeatSubTypes(preReq, baseFeat, me))
                        return true;
                return false;
            }

            if(parts[0].trim().charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')')
                return characterHasFeatSubTypes(parts[0].trim().substring(1,parts[0].trim().length() - 1), baseFeat,  me);
        }

        if(toCheck.contains(" or ")) {
            String[] parts = fixParenthesisIssues(fixQuotationIssues(toCheck.split(" or "), " or "), " or ");

            if(parts.length > 1){
                for(String preReq : parts)
                    if(characterHasFeatSubTypes(preReq, baseFeat, me))
                        return true;
                return false;
            }

            if(parts[0].trim().charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')')
                return characterHasFeatSubTypes(parts[0].trim().substring(1,parts[0].trim().length() - 1), baseFeat,  me);
        }

        return characterHasFeat(baseFeat + " (" + toCheck + ")", me);
    }

    //Final level checks.

    public static boolean characterHasFeat(String name, Character me){

        boolean hasSubType = name.contains("(") && name.contains(")");

        if(hasSubType){
            String baseFeat = name.substring(0,name.indexOf("(")).trim();
            String subFeat = name.substring(name.indexOf("(") + 1,name.indexOf(")")).trim();
            if(subFeat.charAt(0) == '\"' && subFeat.charAt(subFeat.length() - 1) == '\"') subFeat = subFeat.substring(1,subFeat.length() - 1);
            if(baseFeat.charAt(0) == '\"' && baseFeat.charAt(baseFeat.length() - 1) == '\"') baseFeat = baseFeat.substring(1,baseFeat.length() - 1);
            if(!subFeat.equalsIgnoreCase("any")) {
                for (Feat charFeat : me.currentFeats)
                    if (charFeat.name.equalsIgnoreCase(baseFeat) && charFeat.subType != null && charFeat.subType.equalsIgnoreCase(subFeat))
                        return true;
                return false;
            }
            name = baseFeat;
        }

        if(name.charAt(0) == '\"' && name.charAt(name.length() - 1) == '\"') name = name.substring(1,name.length() - 1);

        for(Feat charFeat : me.currentFeats) if(charFeat.name.equalsIgnoreCase(name)) return true;

        return false;
    }

    private static boolean characterMeetsThisSkillPrereq(String prereq, Character me){
        prereq = prereq.trim();
        if(prereq.charAt(0) == '\"' && prereq.charAt(prereq.length() - 1) == '\"') prereq = prereq.substring(1,prereq.length() - 1);

        int i = 0;
        while(!java.lang.Character.isDigit(prereq.charAt(i))) i++;

        String skillName = prereq.substring(0,i).trim();
        int minRanks;
        try {
            minRanks = Integer.parseInt(prereq.substring(i).trim());
        } catch(NumberFormatException e){
            Pathfinder.showError("Error Parsing Skill Prereqs","A Feat's Skill prereq is formatted incorrectly, I couldn't get the minimum ranks in the skill.\nI'll say that you meet this part of the prereq, but take a look at any feats you've added.");
            return true;
        }

        if(skillName.contains("(") && skillName.contains(")")){
            String subSkill = skillName.substring(skillName.indexOf("(") + 1, skillName.length() - 1).trim();
            skillName = skillName.substring(0,skillName.indexOf("(")).trim();

            return SkillUtils.characterHasSkill(SkillUtils.getSkillEnum(skillName), subSkill, me)
                    && SkillUtils.getSkill(SkillUtils.getSkillEnum(skillName), me, subSkill).getnRanks() >= minRanks;
        }

        if(skillName.charAt(0) == '@'){
            skillName = skillName.substring(1).trim();

            return SkillUtils.maxRanksIn(SkillUtils.getSkillEnum(skillName), me) >= minRanks;
        }

        return SkillUtils.characterHasSkill(SkillUtils.getSkillEnum(skillName), me)
                && SkillUtils.getSkill(SkillUtils.getSkillEnum(skillName), me).getnRanks() >= minRanks;
    }

    //Returns true very often, as the general prereqs aren't in a format that can be parsed as easily. Could modify this to greater complexity, or modify database. Would have to constantly update database with updates from website, though.
    private static boolean characterMeetsThisGeneralPrereq(String prereq, Character me){

        prereq = prereq.trim().toLowerCase();

        //Issue with prereqs like "Con, Dex, or Wis 13" - this just gets "Con", then "Dex", then "Wis 13". Since it doesn't understand the first two, it always returns true
        for(AbilityScoreEnum ability : AbilityScoreEnum.values()){
            if(prereq.length() > 3 && ability.getShortName().equalsIgnoreCase(prereq.substring(0,3))){
                return me.abilities.get(ability) >= getNumberFromString(prereq.substring(3));
            }
        }

        if(prereq.contains(" level ")){
            String[] parts = prereq.split(" level ");
            parts[0] = parts[0].trim();
            if(parts[0].equals("character")){
                return me.getTotalLevel() >= getNumberFromString(parts[1]);
            }
            if(parts[0].equals("caster")){
                return me.highestCasterLevel() >= getNumberFromString(parts[1]);
            }
            return me.getLevelOfClass(parts[0]) >= getNumberFromString(parts[1]);
        }

        if(prereq.contains("base attack bonus +")){
            return me.getBAB()[0] >= Integer.parseInt(prereq.substring("base attack bonus +".length()));
        }

        //Guarantee that if the prereq is not understood, assume it is met.
        return true;
    }

    //Generic parsing tools.

    private static String[] fixParenthesisIssues(String[] parts, String seperatedBy){
        for (int i = 0; i < parts.length - 1; i++) {
            if(netOpens(parts[i])){
                for(int j = i + 1; j < parts.length; j++){
                    if(netCloses(parts[j])){
                        String[] partiallyFixed = new String[parts.length - (j - i)];
                        System.arraycopy(parts, 0, partiallyFixed, 0, i);
                        partiallyFixed[i] = "";

                        for(int k = i; k <= j; k++){
                            partiallyFixed[i] += parts[k] + seperatedBy;
                        }

                        partiallyFixed[i] = partiallyFixed[i].substring(0,partiallyFixed[i].length() - seperatedBy.length());
                        System.arraycopy(parts, j + 1, partiallyFixed, j + 1 - (j - i), parts.length - (j + 1));
                        return fixParenthesisIssues(partiallyFixed, seperatedBy);
                    }
                }
                Pathfinder.showError("Error parsing Feat Prereqs","A feat seems to have a set of parenthesis that opens but doesn't close.\nI'll try to continue, but it'll probably have an error.\n" + Arrays.asList(parts));
                return parts;
            }
        }
        return parts;
    }

    public static boolean netOpens(String toCheck){
        if(!toCheck.contains("(")) return false;
        if(!toCheck.contains(")")) return true;
        if(toCheck.lastIndexOf("(") > toCheck.lastIndexOf(")")) return true;

        String oneRemoved = toCheck.substring(0,toCheck.lastIndexOf("(")) + toCheck.substring(toCheck.indexOf(")", toCheck.lastIndexOf("(")) + 1);

        return netOpens(oneRemoved);
    }

    public static boolean netCloses(String toCheck){
        if(!toCheck.contains(")")) return false;
        if(!toCheck.contains("(")) return true;
        if(toCheck.indexOf(")") < toCheck.indexOf("(")) return true;

        int indexOfClosestOpener = 0;
        while(toCheck.substring(indexOfClosestOpener + 1, toCheck.indexOf(")")).contains("(")){
            indexOfClosestOpener = toCheck.indexOf("(",indexOfClosestOpener + 1);
        }

        String oneRemoved = toCheck.substring(0,indexOfClosestOpener) + ((toCheck.indexOf(")") == toCheck.length() - 1)  ? "" : toCheck.substring(toCheck.indexOf(")") + 1));

        return netCloses(oneRemoved);
    }

    public static String[] fixQuotationIssues(String[] parts, String separatedBy){
        for(int i = 0; i < parts.length - 1; i++){
            if((parts[0].length() - parts[0].replace("\"", "").length())%2 == 1){

                for(int j = i; j < parts.length; j++){

                    if((parts[0].length() - parts[0].replace("\"", "").length())%2 == 1){
                        String newParts[] = new String[parts.length - (j - i)];
                        System.arraycopy(parts, 0, newParts, 0, i);
                        parts[i] = "";
                        for(int k = i; k <= j; k++) newParts[i] += parts[k] + separatedBy;
                        newParts[i] = newParts[i].substring(0,newParts[i].length() - separatedBy.length());
                        System.arraycopy(parts, j, newParts, j - (j - i), parts.length - j);
                        return fixQuotationIssues(newParts, separatedBy);
                    }

                }

                Pathfinder.showError("Error parsing Feat Prereqs","A feat seems to have a set of quoation marks that opens but doesn't close.\nI'll continue parsing, but it'll probably have an error.");
            }
        }

        return parts;
    }

    //Used for getting a number from things like "3rd", which is used in the database.
    public static int getNumberFromString(String number){
        number = number.trim();
        int i = 0;
        while(i < number.length() && java.lang.Character.isDigit(number.charAt(i))) i++;
        try{
            return Integer.parseInt(number.substring(0,i));
        } catch(NumberFormatException e){
            //This generally means the parser caught something not actually specifying a class/character level, so return 0 so that it doesn't give a "false" when it can't find that class, and gets a class level 0;
            return 0;
        }
    }

}