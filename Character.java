import java.util.*;
import java.io.*;
import javax.swing.*;

public class Character implements Serializable{
	public CharacterClass charClass;
	public Race charRace;
	public ArrayList<String> notes = new ArrayList<String>();
	public String name;
	public ArrayList<Spell> knownSpells = new ArrayList<Spell>();
	public ArrayList<Spell> preppedSpells = new ArrayList<Spell>();
	public ArrayList<Feat> currentFeats = new ArrayList<Feat>();
	public String job = null;
	public String alignment = null;
	public static String[] skillNames = new String[]{"Acrobatics","Appraise","Bluff","Climb","Diplomacy","Disable Device",
	"Disguise","Escape Artist","Fly","Handle Animal","Heal","Intimidate","Linguistics","Perception","Perform","Profession",
	"Ride","Sense Motive","Sleight of Hand","Spellcraft","Stealth","Survival","Swim","Use Magic Device","KN:Arcana",
	"KN:Dungeoneering","KN:Engineering","KN:Geography","KN:History","KN:Local","KN:Nature","KN:Nobility","KN:Planes","KN:Religion",
	"Craft Alchemy","Craft Armor","Craft Bows","Craft Traps","Craft Weapons","Craft Generic"};
	public static String[] skillModifiers = new String[]{"dex","intel","cha","str","cha","dex","cha","dex","dex","cha","wis",
	"cha","int","wis","cha","wis","dex","wis","dex","int","dex","wis","str","cha","int","int","int","int","int","int","int","int",
	"int","int","int","int","int","int","int","int"};
	public int[] skillPoints = new int[skillNames.length];
	public int[] playerAddedSkillBoosts = new int[skillPoints.length];
	public int[] playerAddedCombatSkillBoosts = new int[7];
	public boolean[] classSkills;
	public String physDesc = null;
	public String background = null;
	public ArrayList<Item> inventory = new ArrayList<Item>();
	public ArrayList<Equipable> equipped = new ArrayList<Equipable>();
	public int[] spellsCastToday = new int[10];
	public int[] spellsPerDay;
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
	public int bab = 0;
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
		classSkills = charClass.classSkills;
		for(String note : race.notes){
			notes.add(note);
		}
		levelUp();
	}
	
	public void levelUp(){
		level++;
		charClass.levelUp(this);
		for(Spell spell : charClass.newSpells){
			knownSpells.add(spell);
		}
		for(Feat feat : charClass.newFeats){
			currentFeats.add(feat);
		}
		for(String note : charClass.newNotes){
			notes.add(note);
		}
		spellsPerDay = charClass.spellsPerDay;
		String hitDie = charClass.hitDiePerLevel + " + " + ((con - 10)/2); 
		Pathfinder.popupDialog("Roll for your HP", hitDie);
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
		return bab + (str - 10)/2 + playerAddedCombatSkillBoosts[5];
	}
	
	public int getRangedModifier(){
		return bab + (dex - 10)/2 + playerAddedCombatSkillBoosts[6];
	}
	
	public void equip(Equipable item){
		inventory.remove(inventory.indexOf(item));
		equipped.add(item);
		armorACModifier += item.armorACModifier;
	}
	
	public void unequip(Equipable item){
		inventory.add(item);
		equipped.remove(equipped.indexOf(item));
		armorACModifier -= item.armorACModifier;
		if(equipped.size() > 0){
			armorMaxDexMod = equipped.get(0).maxDex;
			for(Equipable thing : equipped){
				if(armorMaxDexMod > thing.maxDex) armorMaxDexMod = thing.maxDex;
			}
		} else armorMaxDexMod = 20;
	}
	
	public int getTotalSkillModifier(String skillName){
		int ranks = skillPoints[indexOfSkill(skillName)];
		return (ranks > 0 && classSkills[indexOfSkill(skillName)]) ? 3 + ranks + getSkillMod(skillName) + playerAddedSkillBoosts[indexOfSkill(skillName)] : ranks + getSkillMod(skillName) + playerAddedSkillBoosts[indexOfSkill(skillName)];
	}
	
	public int getTotalSkillModifier(int i){
		int ranks = skillPoints[i];
		return (ranks > 0 && classSkills[i]) ? 3 + ranks + getSkillMod(skillNames[i]) + playerAddedSkillBoosts[i] : ranks + getSkillMod(skillNames[i]) + playerAddedSkillBoosts[i];
	}
	
	public int getSkillMod(String skillName){
		String modifyingStat = skillModifiers[indexOfSkill(skillName)];
		if(modifyingStat.equalsIgnoreCase("con")){
			return (con - 10)/2;
		}
		if(modifyingStat.equalsIgnoreCase("wis")){
			return (wis - 10)/2;
		}
		if(modifyingStat.equalsIgnoreCase("int")|| modifyingStat.equalsIgnoreCase("intel")){
			return (intel - 10)/2;
		}
		if(modifyingStat.equalsIgnoreCase("str")){
			return (str - 10)/2;
		}
		if(modifyingStat.equalsIgnoreCase("dex")){
			return (dex - 10)/2;
		}
		if(modifyingStat.equalsIgnoreCase("cha")){
			return (cha - 10)/2;
		}
		return -1000;
	}
	
	public static int indexOfSkill(String skill){
		int index = -1;
		for(int i = 0; i < skillNames.length; i++){
			if(skillNames[i].equalsIgnoreCase(skill)) index = i;
		}
		return index;
	}
	
	public ImageIcon getRaceImageIcon(){
		return charRace.getRaceImage();
	}
	
	public void forceNewFeat(){
		//Put something in here -----------------------------------------------------------!
	}
}