package src.spells;

import java.io.Serializable;
import java.util.Arrays;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Spell spell = (Spell) o;

		if (dismissible != spell.dismissible) return false;
		if (shapeable != spell.shapeable) return false;
		if (hasSavingThrow != spell.hasSavingThrow) return false;
		if (hasSpellResistance != spell.hasSpellResistance) return false;
		if (slaLevel != spell.slaLevel) return false;
		if (hasDomain != spell.hasDomain) return false;
		if (materialCost != spell.materialCost) return false;
		if (hasBloodline != spell.hasBloodline) return false;
		if (hasMythic != spell.hasMythic) return false;
		if (hasDeity != spell.hasDeity) return false;
		if (hasAugment != spell.hasAugment) return false;
		if (name != null ? !name.equals(spell.name) : spell.name != null) return false;
		if (school != null ? !school.equals(spell.school) : spell.school != null) return false;
		if (subschool != null ? !subschool.equals(spell.subschool) : spell.subschool != null) return false;
		if (descriptor != null ? !descriptor.equals(spell.descriptor) : spell.descriptor != null) return false;
		if (!Arrays.equals(levelRequirements, spell.levelRequirements)) return false;
		if (levelReqAsString != null ? !levelReqAsString.equals(spell.levelReqAsString) : spell.levelReqAsString != null)
			return false;
		if (castingTime != null ? !castingTime.equals(spell.castingTime) : spell.castingTime != null) return false;
		if (!Arrays.equals(componentsRequired, spell.componentsRequired)) return false;
		if (componentsRequiredAsString != null ? !componentsRequiredAsString.equals(spell.componentsRequiredAsString) : spell.componentsRequiredAsString != null)
			return false;
		if (!Arrays.equals(spellTypes, spell.spellTypes)) return false;
		if (range != null ? !range.equals(spell.range) : spell.range != null) return false;
		if (area != null ? !area.equals(spell.area) : spell.area != null) return false;
		if (effect != null ? !effect.equals(spell.effect) : spell.effect != null) return false;
		if (targets != null ? !targets.equals(spell.targets) : spell.targets != null) return false;
		if (duration != null ? !duration.equals(spell.duration) : spell.duration != null) return false;
		if (savingThrow != null ? !savingThrow.equals(spell.savingThrow) : spell.savingThrow != null) return false;
		if (spellResistance != null ? !spellResistance.equals(spell.spellResistance) : spell.spellResistance != null)
			return false;
		if (formattedDescription != null ? !formattedDescription.equals(spell.formattedDescription) : spell.formattedDescription != null)
			return false;
		if (source != null ? !source.equals(spell.source) : spell.source != null) return false;
		if (domain != null ? !domain.equals(spell.domain) : spell.domain != null) return false;
		if (mythicText != null ? !mythicText.equals(spell.mythicText) : spell.mythicText != null) return false;
		if (deity != null ? !deity.equals(spell.deity) : spell.deity != null) return false;
		if (shortDescription != null ? !shortDescription.equals(spell.shortDescription) : spell.shortDescription != null)
			return false;
		if (augmentText != null ? !augmentText.equals(spell.augmentText) : spell.augmentText != null) return false;
		if (bloodlineLevels != null ? !bloodlineLevels.equals(spell.bloodlineLevels) : spell.bloodlineLevels != null)
			return false;
		return basicDescription != null ? basicDescription.equals(spell.basicDescription) : spell.basicDescription == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (school != null ? school.hashCode() : 0);
		result = 31 * result + (subschool != null ? subschool.hashCode() : 0);
		result = 31 * result + (descriptor != null ? descriptor.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(levelRequirements);
		result = 31 * result + (levelReqAsString != null ? levelReqAsString.hashCode() : 0);
		result = 31 * result + (castingTime != null ? castingTime.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(componentsRequired);
		result = 31 * result + (componentsRequiredAsString != null ? componentsRequiredAsString.hashCode() : 0);
		result = 31 * result + Arrays.hashCode(spellTypes);
		result = 31 * result + (range != null ? range.hashCode() : 0);
		result = 31 * result + (area != null ? area.hashCode() : 0);
		result = 31 * result + (effect != null ? effect.hashCode() : 0);
		result = 31 * result + (targets != null ? targets.hashCode() : 0);
		result = 31 * result + (duration != null ? duration.hashCode() : 0);
		result = 31 * result + (dismissible ? 1 : 0);
		result = 31 * result + (shapeable ? 1 : 0);
		result = 31 * result + (hasSavingThrow ? 1 : 0);
		result = 31 * result + (savingThrow != null ? savingThrow.hashCode() : 0);
		result = 31 * result + (hasSpellResistance ? 1 : 0);
		result = 31 * result + (spellResistance != null ? spellResistance.hashCode() : 0);
		result = 31 * result + (formattedDescription != null ? formattedDescription.hashCode() : 0);
		result = 31 * result + (source != null ? source.hashCode() : 0);
		result = 31 * result + slaLevel;
		result = 31 * result + (hasDomain ? 1 : 0);
		result = 31 * result + (domain != null ? domain.hashCode() : 0);
		result = 31 * result + materialCost;
		result = 31 * result + (hasBloodline ? 1 : 0);
		result = 31 * result + (hasMythic ? 1 : 0);
		result = 31 * result + (mythicText != null ? mythicText.hashCode() : 0);
		result = 31 * result + (hasDeity ? 1 : 0);
		result = 31 * result + (deity != null ? deity.hashCode() : 0);
		result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
		result = 31 * result + (hasAugment ? 1 : 0);
		result = 31 * result + (augmentText != null ? augmentText.hashCode() : 0);
		result = 31 * result + (bloodlineLevels != null ? bloodlineLevels.hashCode() : 0);
		result = 31 * result + (basicDescription != null ? basicDescription.hashCode() : 0);
		return result;
	}
}