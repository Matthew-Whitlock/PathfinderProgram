package src;

import src.classes.CharacterClass;
import src.feats.Feat;
import src.races.Race;
import src.spells.Spell;
import src.stats.*;

import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Character implements Serializable{
	
	public CharacterClass charClass;
	public Race charRace;
	
	public ArrayList<String> notes = new ArrayList<>();
	public String name;
	public String job = null;
	public String alignment = null;
	public String physDesc = null;
	public String background = null;
	public String imageOverrideLocation = null;
	
	public ArrayList<Spell> knownSpells = new ArrayList<>();
	public ArrayList<Spell> preppedSpells = new ArrayList<>();
	public int[] spellsCastToday = new int[9];
	public int[] spellsPerDay = new int[9];
	
	public ArrayList<Feat> currentFeats = new ArrayList<Feat>();

	public ArrayList<Skill> skillsList = new ArrayList<Skill>();
	
	public HashMap<AbilityScoreEnum, Integer> abilities;
	
	public ArrayList<Item> inventory = new ArrayList<>();
	public ArrayList<Item> equipped = new ArrayList<>();
	
	public int[] playerAddedCombatSkillBoosts = new int[7];
	public int totalHP = 0;
	public int currentHP = 0;
	public int level = 0;
	private int babMod = 0;
	public int copper = 0;
	public int silver = 0;
	public int gold = 0;
	public int platinum = 0;
	
	public Character(String name, Race race, CharacterClass charClass, HashMap<AbilityScoreEnum, Integer> abilities){
		this.name = name;
		charRace = race;
		this.charClass = charClass;
		notes.addAll(race.notes.stream().collect(Collectors.toList()));
		this.abilities = abilities;
		for(AbilityScoreEnum abilityMod : race.abilityScoreChanges.keySet()) abilities.put(abilityMod, abilities.get(abilityMod) + race.abilityScoreChanges.get(abilityMod));
		skillsList = SkillUtils.createInitialSkillList(this);
		
	}
	
	//Eventually refactor this for multiple classes. For now, put as much logic as possible inside individual classes, to minimize changes needed here.
	public void levelUp(){
		level++;
		String hitDie = charClass.hitDiePerLevel + " + " + getAbilityMod(AbilityScoreEnum.CON);
		Pathfinder.popupDialog("Roll for your HP", hitDie);
		charClass.levelUp(this);
		//Skill ranks! int charClass.skillRanksAvailable(this)
	}
	
	public int getAC(){
		return 10 + (getAbilityMod(AbilityScoreEnum.DEX) > getArmorMaxDex() ? getArmorMaxDex() : getAbilityMod(AbilityScoreEnum.DEX)) + getArmorACBoost() + playerAddedCombatSkillBoosts[0];
	}
	
	public int getArmorMaxDex(){
		int toReturn = 100;
		for(Item item : equipped){
			if(item instanceof Equipable){
				if(toReturn > ((Equipable)item).maxDex) toReturn = ((Equipable)item).maxDex;
			}
		}
		return toReturn;
	}
	
	public int getTouchAC(){
		return 10 + (getAbilityMod(AbilityScoreEnum.DEX) > getArmorMaxDex() ? getArmorMaxDex() : getAbilityMod(AbilityScoreEnum.DEX)) + playerAddedCombatSkillBoosts[1];
	}
	
	public int getFortSave(){
		return charClass.baseFortSave + getAbilityMod(AbilityScoreEnum.CON) + playerAddedCombatSkillBoosts[2];
	}
	
	public int getRefSave(){
		return charClass.baseRefSave + getAbilityMod(AbilityScoreEnum.DEX) + playerAddedCombatSkillBoosts[4];
	}
	
	public int getWillSave(){
		return charClass.baseWillSave + getAbilityMod(AbilityScoreEnum.WIS) + playerAddedCombatSkillBoosts[3];
	}
	
	public int getMeleeModifier(){
		return getBAB() + getAbilityMod(AbilityScoreEnum.STR) + playerAddedCombatSkillBoosts[5];
	}
	
	public int getRangedModifier(){
		return getBAB() + getAbilityMod(AbilityScoreEnum.DEX) + playerAddedCombatSkillBoosts[6];
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
	
	public String getImageLocation(){
		if(imageOverrideLocation == null) return charRace.getDefaultRaceImageLocation();
		return imageOverrideLocation;
	}
	
	public int getAbilityMod(AbilityScoreEnum ability){
		return (10 - abilities.get(ability))/2;
	}
	
	public int getArmorACBoost(){
		return 0; //////////////////////////////////Do this.
	}
	
	public int getACPen(){
		return 0; //////////////////////////////////Do this.
	}
}