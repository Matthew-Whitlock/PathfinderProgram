package src.feats;

import src.Pathfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import src.Character;

/**
 * Created by Matthew on 6/4/2016.
 */
public class Feats {

    public static Feat getFeatByName(String name){
        for(Feat feat : getFeats()){
            if(feat.name.equalsIgnoreCase(name)) return feat;
        }
        return null;
    }

    public static ArrayList<Feat> getFeats(){
        FileReader fileIn;
        BufferedReader input;

        try{
            fileIn = new FileReader(getFilePath());
            input = new BufferedReader(fileIn);
        }catch(IOException e){
            Pathfinder.showError("Error: Cannot access feats","The feat file is either not in the location expected, or I don't have permissions to access it.");
            return null;
        }catch(Exception e){
            Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
            e.printStackTrace();
            return null;
        }

        ArrayList<Feat> feats = new ArrayList<Feat>();
        Feat feat = null;

        try{
            String spellInputString = input.readLine();

            while((spellInputString = input.readLine()) != null){
                try{
                    feat = new Feat(spellInputString);
                    feats.add(feat);
                } catch(Exception e){
                    Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
                    e.printStackTrace();
                    System.out.println(Arrays.asList(spellInputString.split("\t")));
                }
            }
        }catch(Exception e){
            Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nSome valid feats may not be shown.");
            e.printStackTrace();
            return null;
        }
        return feats;
    }

    private static File getFilePath(){
        URL url = Feats.class.getResource("Feats.class");
        File file = null;
        try{
            file = new File(url.toURI());
        }catch(Exception e){
            Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nCannot get correct path to Feats.txt");
            return null;
        }

        if(file.toString().contains("src\\feats\\Feats.class"))
            file = new File(file.toString().substring(0, file.toString().indexOf("src\\feats\\Feats.class")) + "Resources\\Feats.txt");
        else
            file = new File(file.toString().substring(0, file.toString().indexOf("Pathfinder.jar")) + "Resources\\Feats.txt");
        return file;
    }

    public static boolean checkReqsAsFeats(Feat feat, Character me){
        return checkReqsAsFeats(feat.prereqFeatsAsString, me);
    }

    public static boolean checkReqsAsFeats(String featReqs, Character me){
        if(featReqs == null || featReqs.equals("")) return true;

        featReqs = featReqs.trim();

        if(featReqs.contains(", ")){
            String[] parts = fixParenthesisIssues(featReqs.split(", "), ", ");
            if(parts.length > 1){
                if(parts[parts.length - 1].substring(0,3).equals("or ")){
                    for(String preReq : parts) if(checkReqsAsFeats(preReq, me)) return true;
                    return false;
                }
                for(String preReq : parts) if(!checkReqsAsFeats(preReq, me)) return false;
                return true;
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

        if(featReqs.contains("|")){
            String[] parts = fixParenthesisIssues(featReqs.split("\\|"),"|");

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
            String[] parts = fixParenthesisIssues(featReqs.split(" or "), " or ");

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

    public static boolean characterHasFeatSubTypes(String toCheck, Character me){

        if(!(toCheck.contains("(") && toCheck.contains(")"))) return characterHasFeat(toCheck, me);

        String baseFeat = toCheck.substring(0,toCheck.indexOf("(")).trim();
        toCheck = toCheck.substring(toCheck.indexOf("(") + 1, toCheck.lastIndexOf(")"));
        if(toCheck.contains(", ")){
            String[] parts = fixParenthesisIssues(toCheck.split(", "), ", ");
            if(parts.length > 1){
                if(parts[parts.length - 1].substring(0,3).equals("or ")){
                    for(String preReq : parts) if(characterHasFeatSubTypes(toCheck, baseFeat, me)) return true;
                    return false;
                }
                for(String preReq : parts) if(!characterHasFeatSubTypes(toCheck,baseFeat, me)) return false;
                return true;
            }

            if(parts[0].charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside)))
                    return characterHasFeatSubTypes(parts[0].substring(1,parts[0].length() - 1), baseFeat,  me);
            }
        }

        if(toCheck.contains("|")){
            String[] parts = fixParenthesisIssues(toCheck.split("\\|"),"|");

            if(parts.length > 1){
                for(String preReq : parts) if(characterHasFeatSubTypes(preReq, baseFeat, me)) return true;
                return false;
            }

            if(parts[0].charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside)))
                    return characterHasFeatSubTypes(parts[0].substring(1,parts[0].length() - 1), baseFeat,  me);
            }
        }

        if(toCheck.contains(" or ")) {
            String[] parts = fixParenthesisIssues(toCheck.split(" or "), " or ");

            if(parts.length > 1){
                for(String preReq : parts) if(characterHasFeatSubTypes(preReq, baseFeat, me)) return true;
                return false;
            }

            if(parts[0].charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')'){
                String inside = parts[0].substring(1,parts[0].length() - 1);
                if(!(netOpens(inside) || netCloses(inside)))
                    return characterHasFeatSubTypes(parts[0].substring(1,parts[0].length() - 1), baseFeat,  me);
            }
        }

        return characterHasFeat(baseFeat + " (" + toCheck + ")", me);
    }

    private static boolean characterHasFeatSubTypes(String toCheck, String baseFeat, Character me){
        if(toCheck.contains(", ")){
            String[] parts = fixParenthesisIssues(toCheck.split(", "), ", ");
            if(parts.length > 1){
                if(parts[parts.length - 1].substring(0,3).equals("or ")){
                    for(String preReq : parts) if(characterHasFeatSubTypes(preReq, baseFeat, me)) return true;
                    return false;
                }
                for(String preReq : parts) if(!characterHasFeatSubTypes(preReq,baseFeat, me)) return false;
                return true;
            }

            if(parts[0].trim().charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')') return characterHasFeatSubTypes(parts[0].trim().substring(1,parts[0].trim().length() - 1), baseFeat,  me);
        }

        if(toCheck.contains("|")){
            String[] parts = fixParenthesisIssues(toCheck.split("\\|"),"|");

            if(parts.length > 1){
                for(String preReq : parts) if(characterHasFeatSubTypes(preReq, baseFeat, me)) return true;
                return false;
            }

            if(parts[0].trim().charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')') return characterHasFeatSubTypes(parts[0].trim().substring(1,parts[0].trim().length() - 1), baseFeat,  me);
        }

        if(toCheck.contains(" or ")) {
            String[] parts = fixParenthesisIssues(toCheck.split(" or "), " or ");

            if(parts.length > 1){
                for(String preReq : parts) if(characterHasFeatSubTypes(preReq, baseFeat, me)) return true;
                return false;
            }

            if(parts[0].trim().charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')') return characterHasFeatSubTypes(parts[0].trim().substring(1,parts[0].trim().length() - 1), baseFeat,  me);
        }

        return characterHasFeat(baseFeat + " (" + toCheck + ")", me);
    }

    public static boolean characterHasFeat(String name, Character me){

        boolean hasSubType = name.contains("(") && name.contains(")");

        if(hasSubType){
            String baseFeat = name.substring(0,name.indexOf("(")).trim();
            String subFeat = name.substring(name.indexOf("(") + 1,name.indexOf(")")).trim();
            if(!subFeat.equalsIgnoreCase("any")) {
                for (Feat charFeat : me.currentFeats)
                    if (charFeat.name.equalsIgnoreCase(baseFeat) && charFeat.subType != null && charFeat.subType.equalsIgnoreCase(subFeat))
                        return true;
                return false;
            }
            name = baseFeat;
        }

        for(Feat charFeat : me.currentFeats) if(charFeat.name.equalsIgnoreCase(name)) return true;

        return false;
    }

    private static String[] fixParenthesisIssues(String[] parts, String seperatedBy){
        for (int i = 0; i < parts.length - 1; i++) {
            if(netOpens(parts[i])){
                for(int j = i + 1; j < parts.length; j++){
                    if(netCloses(parts[j])){
                        String[] partiallyFixed = new String[parts.length - (j - i)];
                        for(int k = 0; k < i; k++){
                            partiallyFixed[k] = parts[k];
                        }
                        partiallyFixed[i] = "";
                        for(int k = i; k <= j; k++){
                            partiallyFixed[i] += parts[k] + seperatedBy;
                        }
                        partiallyFixed[i] = partiallyFixed[i].substring(0,partiallyFixed[i].length() - seperatedBy.length());
                        for(int k = j + 1; k < parts.length; k++){
                            partiallyFixed[k - (j - i)] = parts[k];
                        }
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


}
