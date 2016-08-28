package src;

import src.classes.SpellCaster;
import src.gui.SelectionUtils;
import src.items.*;
import src.classes.CharacterClass;
import src.feats.Feat;
import src.races.Race;
import src.stats.*;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Character implements Serializable{

	public Race race;

	public ArrayList<CharacterClass> classes = new ArrayList<>();
	public String[] favoredClassNames;

	public Map<String, String> notes = new HashMap<>();
	public Map<String, String> miscAbilities = new HashMap<>();

	public String name;
	public String profession = null;
	public String alignment = null;
	public String physDesc = null;
	public String background = null;
	public String imageOverrideLocation = null;

	public HashMap<String, Integer> effects = new HashMap<>();

	public ArrayList<Feat> currentFeats = new ArrayList<>();

	public ArrayList<Skill> skillsList = new ArrayList<>();

	public HashMap<AbilityScoreEnum, Integer> abilities;
	public HashMap<AbilityScoreEnum, Integer> tempAbilities = new HashMap<>();
	
	public HashMap<GenItem, Integer> inventory = new HashMap<>();
	public HashMap<GenItem, Integer> equipped = new HashMap<>();
	
	public int[] playerAddedCombatSkillBoosts = new int[9];
	public AbilityScoreEnum cmdMod = AbilityScoreEnum.STR;

	public int totalHP = 0;
	public int currentHP = 0;
	public int tempHP = 0;
	public int nonlethalDamage = 0;

	public int[] babMod = new int[30];
	public int copper = 0;
	public int silver = 0;
	public int gold = 0;
	public int platinum = 0;
	public double sellMod = 0.7;

	public boolean showIconsInDisplay = true; //Used for saving settings for GUI.
	public File lastSavedLocation = null;
	
	public Character(String name, Race race, HashMap<AbilityScoreEnum, Integer> abilities, String[] favoredClassNames){
		this.name = name;
		this.race = race;
		for(int i = 0; i < race.notes().length - 1; i += 2){
			miscAbilities.put(race.notes()[i], race.notes()[i+1]);
		}
		this.abilities = abilities;
		this.favoredClassNames = favoredClassNames;

		for(AbilityScoreEnum abilityMod : race.abilityScoreChanges().keySet())
			abilities.put(abilityMod, abilities.get(abilityMod) + race.abilityScoreChanges().get(abilityMod));

		for(AbilityScoreEnum ability : AbilityScoreEnum.values())
			tempAbilities.put(ability, 0);

		skillsList = SkillUtils.createInitialSkillList(this);
	}

	public void levelUp(CharacterClass charClass){

		if(!classes.contains(charClass)) classes.add(charClass);
		charClass.levelUp();

		String hitDie = "1" + charClass.hitDiePerLevel + " + " + getAbilityMod(AbilityScoreEnum.CON);
		Pathfinder.popupDialog("Roll for your HP", hitDie);
		SelectionUtils.chooseSkillRanks(this, charClass.skillRanksMod + getAbilityMod(AbilityScoreEnum.INT));
		for(String s : favoredClassNames){
			if(!s.equals("") && charClass.toString().toLowerCase().contains(s.toLowerCase())){
				Pathfinder.popupDialog("Favored Class Bonus","Since this is a favored class, you get to choose to either add one more skill rank, or add one more health point.");
				break;
			}
		}
	}
	
	public int getAC(){
		return 10 + (getAbilityMod(AbilityScoreEnum.DEX) > getArmorMaxDex() ? getArmorMaxDex() : getAbilityMod(AbilityScoreEnum.DEX)) + getArmorACBoost() + playerAddedCombatSkillBoosts[0];
	}

	public void setAC(int newValue){
		playerAddedCombatSkillBoosts[0] += newValue - getAC();
	}
	
	public int getArmorMaxDex(){
		int toReturn = 100;
		for(GenItem item : equipped.keySet()){
			if(item.getMaxDex() != -1){
				if(toReturn > item.getMaxDex()) toReturn = item.getMaxDex();
			}
		}
		return toReturn;
	}
	
	public int getTouchAC(){
		return 10 + (getAbilityMod(AbilityScoreEnum.DEX) > getArmorMaxDex() ? getArmorMaxDex() : getAbilityMod(AbilityScoreEnum.DEX)) + playerAddedCombatSkillBoosts[1];
	}

	public void setTouchAC(int newValue){
		playerAddedCombatSkillBoosts[1] += newValue - getTouchAC();
	}
	
	public int getFortSave(){
		int toReturn = getAbilityMod(AbilityScoreEnum.CON) + playerAddedCombatSkillBoosts[2];

		for(CharacterClass charClass : classes)
			toReturn += charClass.getBaseFortSave();

		return toReturn;
	}

	public void setFortSave(int newValue){
		playerAddedCombatSkillBoosts[2] += newValue - getFortSave();
	}
	
	public int getRefSave(){
		int toReturn = getAbilityMod(AbilityScoreEnum.DEX) + playerAddedCombatSkillBoosts[4];

		for(CharacterClass charClass : classes)
			toReturn += charClass.getBaseRefSave();

		return toReturn;
	}

	public void setRefSave(int newValue){
		playerAddedCombatSkillBoosts[4] += newValue - getRefSave();
	}
	
	public int getWillSave(){
		int toReturn = getAbilityMod(AbilityScoreEnum.WIS) + playerAddedCombatSkillBoosts[3];

		for(CharacterClass charClass : classes)
			toReturn += charClass.getBaseWillSave();

		return toReturn;
	}

	public void setWillSave(int newValue){
		playerAddedCombatSkillBoosts[3] += newValue - getWillSave();
	}
	
	public int getMeleeModifier(){
		return getBAB()[0] + getAbilityMod(AbilityScoreEnum.STR) + playerAddedCombatSkillBoosts[5];
	}

	public void setMeleeModifier(int newValue){
		playerAddedCombatSkillBoosts[5] += newValue - getMeleeModifier();
	}
	
	public int getRangedModifier(){
		return getBAB()[0] + getAbilityMod(AbilityScoreEnum.DEX) + playerAddedCombatSkillBoosts[6];
	}

	public void setRangedModifier(int newValue){
		playerAddedCombatSkillBoosts[6] += newValue - getRangedModifier();
	}

	public int getCMB(){
		return getAbilityMod(cmdMod) + playerAddedCombatSkillBoosts[7] + getBAB()[0];
	}

	public void setCMB(int newValue){
		playerAddedCombatSkillBoosts[0] += newValue - getCMB();
	}

	public int getCMD(){
		return 10 + getBAB()[0] + getAbilityMod(AbilityScoreEnum.STR) + getAbilityMod(AbilityScoreEnum.DEX) + playerAddedCombatSkillBoosts[8];
	}

	public void setCMD(int newValue){
		playerAddedCombatSkillBoosts[8] += newValue - getCMD();
	}
	
	public String getBABAsString(){
		String toReturn = "";

		int[] bab = getBAB();

		for(CharacterClass charClass : classes) {

			int[] toAdd = charClass.getBAB();

			for(int i = 0; i < charClass.getBAB().length; i++){
				bab[i] += toAdd[i];
			}

		}

		if(bab[0] == 0) return "0";

		for(int i = 0; i < bab.length; i++){
			if(bab[i] > 0){
				toReturn += bab[i] + "/";
			}
		}

		toReturn = toReturn.substring(0, toReturn.length() > 0 ? toReturn.length() - 1 : 0);

		return toReturn;
	}

	public int[] getBAB(){
		int[] bab = Arrays.copyOf(babMod, babMod.length);

		for(CharacterClass charClass : classes){
			int[] toAdd = charClass.getBAB();

			for(int i = 0; i < toAdd.length; i++){
				bab[i] += toAdd[i];
			}

		}

		return bab;
	}
	
	public void setBAB(String newValue){

		if(newValue.equals("")){
			babMod = new int[30];
		}

		String[] values = newValue.split("/");

		for(int i = 0; i < values.length; i++){
			if(values[i].contains("+")){
				values[i] = values[i].substring(1);
			}

			babMod[i] += Integer.parseInt(values[i]) - getBAB()[i];
		}

		for(int i = values.length; i < babMod.length; i++){
			babMod[i] += 0 - getBAB()[i];
		}

	}
	
	public URL getImageLocation(){
		if (imageOverrideLocation == null || imageOverrideLocation.equals("")) return race.getDefaultRaceImageLocation();
		try {
			return new URL("file:" + imageOverrideLocation);
		} catch(Exception e){
			Pathfinder.showError("Unspecified error", "Run this in command for more details");
			e.printStackTrace();
		}
		return null;
	}

	public int getAbilityMod(AbilityScoreEnum ability){
		return (abilities.get(ability) + tempAbilities.get(ability) - 10)/2;
	}

	public int getArmorACBoost(){
		int toReturn = 0;
		for(GenItem item : equipped.keySet()){
			toReturn += item.getACBoost();
		}
		return toReturn;
	}

	public int getACPen(){
		int toReturn = 0;
		for(Item item : equipped.keySet()){
			toReturn += item.getACPen();
		}
		return toReturn;
	}

	public int getTotalLevel(){
		int level = 0;

		for(CharacterClass charClass : classes) level += charClass.level;

		return level;
	}

	public int getLevelOfClass(String classToGet){

		for(CharacterClass charClass : classes) if(charClass.name.equalsIgnoreCase(classToGet)) return charClass.level;

		return 0;
	}

	public int highestCasterLevel(){
		int toReturn = 0;

		for(CharacterClass charClass : classes) if(charClass instanceof SpellCaster && charClass.level > toReturn) toReturn = charClass.level;

		return toReturn;
	}

	public String getCharacterClassesAsString(){
		String toReturn = "";

		for(CharacterClass charClass : classes)
			toReturn += charClass.toString() + ", ";

		if(toReturn.length() > 2)
			toReturn = toReturn.substring(0,toReturn.length() - 2);

		return toReturn;
	}

}