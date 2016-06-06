package src.feats;

import com.sun.org.apache.xpath.internal.operations.Number;
import src.Pathfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import src.Character;
import src.stats.AbilityScoreEnum;
import src.stats.SkillUtils;

/**
 * Created by Matthew on 6/4/2016.
 */
public class Feats {

    //Searching for/getting feats

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

    //Checking for requirements.

    public static boolean characterMeetsAllPrereqs(Feat feat, Character me){
        if(checkGeneralReqs(feat.prereqsAsString, me) && checkReqsAsFeats(feat.prereqFeatsAsString, me) && characterMeetsSkillSpecificPrereqs(feat.prereqsSkillsAsString, me)) return true;
        return false;
    }

    private static boolean checkGeneralReqs(String prereqs, Character me){
        if(prereqs == null || prereqs.trim().equals("")) return true;

        prereqs = prereqs.trim();

        if(prereqs.charAt(prereqs.length() - 1) == '.') prereqs = prereqs.substring(0,prereqs.length() - 1);

        prereqs = prereqs.replace("; ",", ");

        if(prereqs.contains(", ")){

            String[] parts = fixParenthesisIssues(fixQuotationIssues(prereqs.split(", "), ", "), ", ");

            if(parts.length > 1){
                if(parts[parts.length - 1].substring(0,3).equals("or ")){
                    for(String requirement : parts) if(checkGeneralReqs(requirement, me)) return true;
                    return false;
                }
                for(String requirement : parts) if(!checkGeneralReqs(requirement, me)) return false;
                return true;
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

        if(prereqs.contains("|")) {
            String[] parts = fixParenthesisIssues(fixQuotationIssues(prereqs.split("\\|"), "|"), "|");

            if (parts.length > 1) {
                for (String requirement : parts) if (checkGeneralReqs(requirement, me)) return true;
                return false;
            }

            parts[0] = parts[0].trim();

            if (parts[0].charAt(0) == '(' && parts[0].charAt(parts[0].length() - 1) == ')') {
                String inside = parts[0].substring(1, parts[0].length() - 1);
                if (!(netOpens(inside) || netCloses(inside))) {
                    return checkGeneralReqs(inside, me);
                }
            }

            if(parts[0].charAt(0) == '\"' && parts[0].charAt(parts[0].length() - 1) == '\"' && parts[0].length() - parts[0].replace("\"","").length() == 2){
                return characterMeetsThisGeneralPrereq(parts[0], me);
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

        /*if(toCheck.contains(", ")){
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

        return characterHasFeat(baseFeat + " (" + toCheck + ")", me);*/
    }

    private static boolean characterHasFeatSubTypes(String toCheck, String baseFeat, Character me){
        if(toCheck.contains(", ")){
            String[] parts = fixParenthesisIssues(fixQuotationIssues(toCheck.split(", "), ", "), ", ");
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
            String[] parts = fixParenthesisIssues(fixQuotationIssues(toCheck.split("\\|"), "|"), "|");

            if(parts.length > 1){
                for(String preReq : parts) if(characterHasFeatSubTypes(preReq, baseFeat, me)) return true;
                return false;
            }

            if(parts[0].trim().charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')') return characterHasFeatSubTypes(parts[0].trim().substring(1,parts[0].trim().length() - 1), baseFeat,  me);
        }

        if(toCheck.contains(" or ")) {
            String[] parts = fixParenthesisIssues(fixQuotationIssues(toCheck.split(" or "), " or "), " or ");

            if(parts.length > 1){
                for(String preReq : parts) if(characterHasFeatSubTypes(preReq, baseFeat, me)) return true;
                return false;
            }

            if(parts[0].trim().charAt(0) == '(' && parts[0].trim().charAt(parts[0].trim().length() - 1) == ')') return characterHasFeatSubTypes(parts[0].trim().substring(1,parts[0].trim().length() - 1), baseFeat,  me);
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
        int minRanks = 0;
        try {
            minRanks = Integer.parseInt(prereq.substring(i).trim());
        } catch(NumberFormatException e){
            Pathfinder.showError("Error Parsing Skill Prereqs","A Feat's Skill prereq is formatted incorrectly, I couldn't get the minimum ranks in the skill.\nI'll say that you meet this part of the prereq, but take a look at any feats you've added.");
            return true;
        }

        if(skillName.contains("(") && skillName.contains(")")){
            String subSkill = skillName.substring(skillName.indexOf("(") + 1, skillName.length() - 1).trim();
            skillName = skillName.substring(0,skillName.indexOf("(")).trim();

            if(SkillUtils.characterHasSkill(SkillUtils.getSkillEnum(skillName), subSkill, me) && SkillUtils.getSkill(SkillUtils.getSkillEnum(skillName),me,subSkill).getnRanks() >= minRanks) return true;

            return false;
        }

        if(skillName.charAt(0) == '@'){
            skillName = skillName.substring(1).trim();

            if(SkillUtils.maxRanksIn(SkillUtils.getSkillEnum(skillName), me) >= minRanks) return true;

            return false;
        }

        if(SkillUtils.characterHasSkill(SkillUtils.getSkillEnum(skillName), me) && SkillUtils.getSkill(SkillUtils.getSkillEnum(skillName),me).getnRanks() >= minRanks) return true;

        return false;
    }

    //Returns true very often, as the general prereqs aren't in a format that can be parsed as easily. Could modify this to greater complexity, or modify database. Would have to constantly update database with updates from website, though.
    private static boolean characterMeetsThisGeneralPrereq(String prereq, Character me){

        prereq = prereq.trim().toLowerCase();


        //Issue with prereqs like "Con, Dex, or Wis 13" - this just gets "Con", then "Dex", then "Wis 13". Since it doesn't understand the first two, it always returns true
        for(AbilityScoreEnum ability : AbilityScoreEnum.values()){
            if(prereq.length() > 3 && ability.getShortName().equalsIgnoreCase(prereq.substring(0,3))){
                if(me.abilities.get(ability) >= getNumberFromString(prereq.substring(3))) return true;
                return false;
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
            return me.getBAB() >= Integer.parseInt(prereq.substring("base attack bonus +".length()));
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

    public static String[] fixQuotationIssues(String[] parts, String separatedBy){
        for(int i = 0; i < parts.length - 1; i++){
            if((parts[0].length() - parts[0].replace("\"", "").length())%2 == 1){

                for(int j = i; j < parts.length; j++){

                    if((parts[0].length() - parts[0].replace("\"", "").length())%2 == 1){
                        String newParts[] = new String[parts.length - (j - i)];
                        for(int k = 0; k < i; k++) newParts[k] = parts[k];
                        parts[i] = "";
                        for(int k = i; k <= j; k++) newParts[i] += parts[k] + separatedBy;
                        newParts[i] = newParts[i].substring(0,newParts[i].length() - separatedBy.length());
                        for(int k = j; k < parts.length; k++) newParts[k - (j - i)] = parts[k];
                        return fixQuotationIssues(newParts, separatedBy);
                    }

                }

                Pathfinder.showError("Error parsing Feat Prereqs","A feat seems to have a set of quoation marks that opens but doesn't close.\nI'll continue parsing, but it'll probably have an error.");
            }
        }

        return parts;
    }

    //Used for getting a number from things like "3rd", which is used in the database.
    private static int getNumberFromString(String number){
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
