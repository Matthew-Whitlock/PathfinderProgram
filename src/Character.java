package src;

import src.classes.CharacterClass;
import src.feats.Feat;
import src.races.Race;
import src.spells.Spell;

import javax.swing.*;
import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Character implements Serializable{

	public static final String DEX = "Dex";
	public static final String STR = "Str";
	public static final String CON = "Con";
	public static final String INT = "Int";
	public static final String WIS = "Wis";
	public static final String CHA = "Cha";
	public static final String ALC = "Alchemist";
	public static final String BBN = "Barbarian";
	public static final String BRD = "Bard";
	public static final String CAV = "Cavalier";
	public static final String CLR = "Cleric";
	public static final String DRD = "Druid";
	public static final String FTR = "Fighter";
	public static final String GUN = "Gunslinger";
	public static final String INQ = "Inquisitor";
	public static final String MAG = "Magus";
	public static final String MNK = "Monk";
	public static final String ORA = "Oracle";
	public static final String PAL = "Paladin";
	public static final String RGR = "Ranger";
	public static final String ROG = "Rogue";
	public static final String SOR = "Sorceror";
	public static final String SUM = "Summoner";
	public static final String WIT = "Witch";
	public static final String WIZ = "Wizard";
	
	public CharacterClass charClass;
	public Race charRace;
	public ArrayList<String> notes = new ArrayList<>();
	public String name;
	public ArrayList<Spell> knownSpells = new ArrayList<>();
	public ArrayList<Spell> preppedSpells = new ArrayList<>();
	public ArrayList<Feat> currentFeats = new ArrayList<>();
	public String job = null;
	public String alignment = null;
	public HashMap<Skill,int[]> skills = new HashMap<Skill,int[]>();
	public ArrayList<Skill> flippedClassSkills = new ArrayList<Skill>();
	public int[] playerAddedCombatSkillBoosts = new int[7];
	public String physDesc = null;
	public String background = null;
	public ArrayList<Item> inventory = new ArrayList<>();
	public ArrayList<Item> equipped = new ArrayList<>();
	public int[] spellsCastToday = new int[9];
	public int[] spellsPerDay = new int[9];
	public int totalHP = 0;
	public int currentHP = 0;
	public int armorACModifier = 0;
	public int armorMaxDexMod = 20;
	public int level = 0;
	public int str;
	public int dex;
	public int con;
	public int intel;
	public int wis;
	public int cha;
	public int babMod = 0;
	public int copper = 0;
	public int silver = 0;
	public int gold = 0;
	public int platinum = 0;
	
	public Character(String name, Race race, CharacterClass charClass, int[] baseStats){
		this.name = name;
		charRace = race;
		this.charClass = charClass;
		str = baseStats[0] + race.str;
		dex = baseStats[1] + race.dex;
		con = baseStats[2] + race.con;
		intel = baseStats[3] + race.intel;
		wis = baseStats[4] + race.wis;
		cha = baseStats[5] + race.cha;
		notes.addAll(race.notes.stream().collect(Collectors.toList()));
		for(Skill skill : Skill.values()) skills.put(skill, new int[2]);
	}
	
	public void levelUp(){
		level++;
		String hitDie = charClass.hitDiePerLevel + " + " + ((con - 10)/2);
		Pathfinder.popupDialog("Roll for your HP", hitDie);
		charClass.levelUp(this);
		//Skill ranks! int charClass.skillRanksAvailable(this)
	}
	
	public String getClassName(){
		return charClass.toString();
	}
	
	public String getRaceName(){
		return charRace.toString();
	}
	
	public int getAC(){
		return 10 + ((dex - 10)/2 > armorMaxDexMod ? armorMaxDexMod : (dex - 10)/2) + armorACModifier + playerAddedCombatSkillBoosts[0];
	}
	
	public int getArmorMaxDex(){
		return 100;
	}
	
	public int getTouchAC(){
		return 10 + ((dex - 10)/2 > armorMaxDexMod ? armorMaxDexMod : (dex - 10)/2) + playerAddedCombatSkillBoosts[1];
	}
	
	public int getFortSave(){
		return charClass.baseFortSave + (con - 10)/2 + playerAddedCombatSkillBoosts[2];
	}
	
	public int getRefSave(){
		return charClass.baseRefSave + (dex - 10)/2 + playerAddedCombatSkillBoosts[4];
	}
	
	public int getWillSave(){
		return charClass.baseWillSave + (wis - 10)/2 + playerAddedCombatSkillBoosts[3];
	}
	
	public int getMeleeModifier(){
		return getBAB() + (str - 10)/2 + playerAddedCombatSkillBoosts[5];
	}
	
	public int getRangedModifier(){
		return getBAB() + (dex - 10)/2 + playerAddedCombatSkillBoosts[6];
	}
	
	public int getBAB(){
		return charClass.bab + babMod;
	}
	
	public void setBAB(int newValue){
		babMod += newValue - getBAB();
	}
	
	public void equip(Item item){
		inventory.remove(inventory.indexOf(item));
		equipped.add(item);
	}
	
	public void unequip(Equipable item){
		inventory.add(item);
		equipped.remove(equipped.indexOf(item));
	}
	
	public int getTotalSkillModifier(Skill skill){
		int ranks = skills.get(skill)[0];
		boolean isClassSkill = flippedClassSkills.contains(skill) ? !skill.skillOfClass(charClass.name) : skill.skillOfClass(charClass.name);
		return (ranks > 0 && isClassSkill) ? 3 + ranks + getSkillMod(skill) + skills.get(skill)[1] : ranks + getSkillMod(skill) + skills.get(skill)[1];
	}
	
	public void setClassSkillValue(Skill skill, boolean value){
		if(value == skill.skillOfClass(charClass.name) && flippedClassSkills.contains(skill)){
			flippedClassSkills.remove(flippedClassSkills.indexOf(skill));
		} else if(value != skill.skillOfClass(charClass.name) && !flippedClassSkills.contains(skill)){
			flippedClassSkills.add(skill);
		}
	}
	
	public void modifySkillValue(Skill skill, int toValue){
		skills.get(skill)[1] += toValue - getTotalSkillModifier(skill);
	}
	
	public int getSkillMod(Skill skill){
		String modifyingStat = skill.getAbilityMod();
		if(modifyingStat.equals(CON)){
			return (con - 10)/2;
		}
		if(modifyingStat.equals(WIS)){
			return (wis - 10)/2;
		}
		if(modifyingStat.equals(INT)|| modifyingStat.equalsIgnoreCase("intel")){
			return (intel - 10)/2;
		}
		if(modifyingStat.equals(STR)){
			return (str - 10)/2;
		}
		if(modifyingStat.equals(DEX)){
			return (dex - 10)/2;
		}
		if(modifyingStat.equals(CHA)){
			return (cha - 10)/2;
		}
		return -1000;
	}
	
	public ImageIcon getRaceImageIcon(){
		return charRace.getRaceImage();
	}
	
	public void forceNewFeat(){
		//Put something in here -----------------------------------------------------------!
	}
	
	public void forceNewSpell(){
		//And here ------------------------------------------------------------------------!
	}
	
	public void equipItems(int[] indexes){
		for(int i = indexes.length - 1; i >= 0; i++){
			equip(inventory.get(indexes[i]));
		}
	}
	
	public void unequipItems(int[] indexes){
		for(int i = indexes.length - 1; i >= 0; i++){
			equip(inventory.get(indexes[i]));
		}
	}
	
	public boolean hasClassSkill(Skill skill){
		if(flippedClassSkills.contains(skill)) return !skill.skillOfClass(charClass.name);
		else return skill.skillOfClass(charClass.name);
	}
}