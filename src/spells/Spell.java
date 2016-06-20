package src.spells;

import java.io.Serializable;
import java.util.HashMap;
import src.spells.Spells;

public class Spell implements Serializable{
	public String name;
	public String school;
	public String subschool;
	public String descriptor;
	public int[] levelRequirements = new int[Spells.classTypes.length];
	public String levelReqAsString;
	public String castingTime;
	public boolean[] componentsRequired = new boolean[Spells.componentTypes.length];
	public String componentsRequiredAsString;
	public boolean[] spellTypes = new boolean[Spells.spellTypeNames.length];
	public String range;
	public String area;
	public String effect;
	public String targets;
	public String duration;
	public boolean dismissible;
	public boolean shapeable;
	public boolean hasSavingThrow;
	public String savingThrow;
	public boolean hasSpellResistance;
	public String spellResistance;
	public String formattedDescription;
	public String source;
	public int slaLevel;
	public boolean hasDomain;
	public String domain;
	public int materialCost;
	public boolean hasBloodline;
	public boolean hasMythic;
	public String mythicText;
	public boolean hasDeity;
	public String deity;
	public String shortDescription;
	public boolean hasAugment;
	public String augmentText;
	public HashMap<String, Integer> bloodlineLevels = new HashMap<>();
	public String basicDescription;
	
	//This expects the spell's details in the format provided by PathfinderCommunity.net's Spell database.
	Spell(String detailsLine){
		String[] details = detailsLine.split("\\t");
		name = details[0];
		school = details[1];
		subschool = details[2];
		descriptor = details[3];
		
		for(int i = 0; i < 15; i++){
			int startIndex = 26;
			if(details[startIndex + i].equalsIgnoreCase("Null")){
				levelRequirements[i] = -1;
				continue;
			}
			levelRequirements[i] = Integer.parseInt(details[startIndex + i]);
		}
		for(int i = 0; i < 8; i++){
			int startIndexOfDetails = 78;
			int startIndexOfLevels = 15;
			if(details[startIndexOfDetails + i].equalsIgnoreCase("Null")){
				levelRequirements[startIndexOfLevels + i] = -1;
				continue;
			}
			levelRequirements[startIndexOfLevels + i] = Integer.parseInt(details[startIndexOfDetails + i]);
		}
		
		levelReqAsString = details[4];
		
		for(int i = 0; i < componentsRequired.length - 1; i++){
			int startIndex = 21;
			componentsRequired[i] = details[startIndex + i].equals("1");
		}
		componentsRequired[5] = details[7].equals("1");
		if(componentsRequired[5]) materialCost = Integer.parseInt(details[details.length - 14]);
		componentsRequiredAsString = details[6];
		
		castingTime = details[5];
		range = details[8];
		area = details[9];
		effect = details[10];
		targets = details[11];
		duration = details[12];
		dismissible = details[13].equals("1");
		shapeable = details[14].equals("1");
		hasSavingThrow = !(details[15].equals("") || details[15].equals("none"));
		if(hasSavingThrow) savingThrow = details[15];
		hasSpellResistance = !(details[16].equals("") || details[16].equals("no"));
		if(hasSpellResistance) spellResistance = details[16];
		basicDescription = details[18];
		source = details[19];
		formattedDescription = details[20];
		deity = details[41];
		try{
			slaLevel = details[42].equalsIgnoreCase("NULL") ? -1 : Integer.parseInt(details[42]);
		} catch(Exception e){
			System.out.println("SLA level error on spell: " + name + "| Error is " + e.getClass().getSimpleName());
			System.out.println("\"" + details[42] + "\"");
		}
		hasDomain = !details[43].equals("");
		if(hasDomain) domain = details[43];
		shortDescription = details[44].trim().equals("") ? details[17].substring(0,40) + "..." : details[44];
		hasMythic = details[77].equals("1");
		if(hasMythic) mythicText = details[77];
		hasAugment = !details[76].equals("");
		if(hasAugment) augmentText = details[76];
		
		if(!details[73].equals("")){
			if(details[73].contains(", ")){
				String[] bloodlines =  details[73].split(", ");
				for(String s : bloodlines){
					String name = s.substring(0,s.indexOf("(") - 1);
					int level = Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
					bloodlineLevels.put(name, level);
				}
			} else {
				String s = details[73];
				String name = s.substring(0,s.indexOf("(") - 1);
				int level = Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
				bloodlineLevels.put(name, level);
			}
		}
		
	}

	public Spell(String name, String formattedDescription){
		this.name = name;
		this.formattedDescription = formattedDescription;

		//The rest is just for being certain that searching etc. doesn't throw an error if it somehow manages to pull up a custom made spell.
		//Generally, though, it won't ever find custom spells made like this - as they'll be saved as a file or directly added, not added to the tsv list of spells.
		//Exception: Spell level requirements could actually be useful to set, so that they spell sits in the right place within the spell list.

		school = "";
		subschool = "";
		descriptor = "";
		basicDescription = "";
		shortDescription = "";
		levelReqAsString = "";
		castingTime = "";
		componentsRequiredAsString = "";
		range = "";
		area = "";
		effect = "";
		targets = "";
		duration = "";
		savingThrow = "";
		spellResistance = "";
		source = "";
		slaLevel = -1;
		domain = "";
		materialCost = 0;
		mythicText = "";
		deity = "";
		augmentText = "";

		for(int i = 0; i < levelRequirements.length; i++){
			levelRequirements[i] = -1;
		}
	}
	
	public String toString(){
		return name + ": " + shortDescription;
	}
}