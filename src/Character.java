package src;

import src.classes.CharacterClass;
import src.feats.Feat;
import src.races.Race;
import src.spells.Spell;
import src.stats.Skill;
import src.stats.SkillEnum;
import src.stats.SkillUtils;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Character implements Serializable{

	public CharacterClass charClass;
	public Race charRace;
	public ArrayList<String> notes = new ArrayList<>();
	public String name;
	public ArrayList<Spell> knownSpells = new ArrayList<>();
	public ArrayList<Spell> preppedSpells = new ArrayList<>();
	public ArrayList<Feat> currentFeats = new ArrayList<>();
	public String job = null;
	public String alignment = null;

	private Map<SkillEnum, Skill> skillMap;

	public int[] playerAddedCombatSkillBoosts = new int[7];

	public String physDesc = null;
	public String background = null;
	public ArrayList<Item> inventory = new ArrayList<>();
	public ArrayList<Equipable> equipped = new ArrayList<>();
	public int[] spellsCastToday = new int[9];
	public int[] spellsPerDay = new int[9];
	public int totalHP = 0;
	public int currentHP = 0;
	public int armorACModifier = 0;
	public int armorMaxDexMod = 20;
	public int level = 0;

	//TODO: Change these to a map of Ability objects like the skills
	public int str;
	public int dex;
	public int con;
	public int intel;
	public int wis;
	public int cha;

	public int copper = 0;
	public int silver = 0;
	public int gold = 0;
	public int platinum = 0;
	
	public Character(String name, Race race, CharacterClass charClass, int[] baseStats){
		this.name = name;
		charRace = race;
		this.charClass = charClass;

		skillMap = SkillUtils.createInitialSkillMap();
		SkillUtils.applyClassSkills(charClass.getClassSkills(), skillMap);

		//TODO: Change the ability scores as necessary from the chosen class
		//Possibly with a call to a AbilityScoreUtils class?

		notes.addAll(race.notes.stream().collect(Collectors.toList()));
	}
	
	public void levelUp(JFrame mainFrame){
		level++;
		String hitDie = charClass.hitDiePerLevel + " + " + ((con - 10)/2);
		Pathfinder.popupDialog("Roll for your HP", hitDie);
		charClass.levelUp(this);
		//Skill ranks! int charClass.skillRanksAvailable(this)
		
		mainFrame.repaint();
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
		return charClass.bab + (str - 10)/2 + playerAddedCombatSkillBoosts[5];
	}
	
	public int getRangedModifier(){
		return charClass.bab + (dex - 10)/2 + playerAddedCombatSkillBoosts[6];
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
			equipped.stream().filter(thing -> armorMaxDexMod > thing.maxDex).forEach(thing -> armorMaxDexMod = thing.maxDex);
		} else armorMaxDexMod = 20;
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

	//Getters

	public Map<SkillEnum, Skill> getSkillMap() {
		return skillMap;
	}
}