package src.classes;

import src.Character;
import src.Pathfinder;
import src.spells.Spell;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;
import src.stats.SkillEnum;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class CharacterClass implements Serializable{
	public String name;
	public String hitDiePerLevel;
	public int level = 0;
	public boolean isCaster = false;
	public int[] spellsCastToday = new int[9];
	public String bloodline;
	public Character me;
	public int skillRanksMod;

	public int[] modifiedSpellsPerDay = new int[9];

	public CharacterClass(Character me){
		this.me = me;
	}

	public CharacterClass(){

	}
	
	public abstract void levelUp();
	
	public String toString(){
		return name;
	}

	public abstract int[] getBAB();
	public abstract int getBaseFortSave();
	public abstract int getBaseRefSave();
	public abstract int getBaseWillSave();

	public ArrayList<Spell> knownSpells = new ArrayList<>();
	public HashMap<Spell, Integer> preppedSpells = new HashMap<>();

	public int getSpellLevel(Spell spell){
		return Spells.spellLevelFor(name, spell);
	}

	public int[] getSpellsPerDay(){
		return new int[]{0,0,0,0,0,0,0,0,0};
	}

	public void modifySpellsPerDay(int level, int newValue){
		modifiedSpellsPerDay[level - 1] += newValue - getSpellsPerDay()[level - 1];
	}

	public static String[] getClassNames(){
		return new String[]{"Sorcerer"};
	}

	public static String[] getSubclassesOf(String className){
		if(className.equals("Sorcerer")) return new String[]{"Abyssal Sorcerer"};

		return new String[0];
	}

	public static CharacterClass getClassInstanceOf(String className, Character me){

		if(className.equals("Sorcerer")){
			for(CharacterClass charClass : me.classes){
				if(charClass instanceof Sorcerer) return charClass;
			}
			return null;
		}

		if(className.equals("Abyssal Sorcerer")) {
			for(CharacterClass charClass : me.classes){
				if(charClass instanceof AbyssalBloodline) return charClass;
			}
			return new AbyssalBloodline(me);
		}

		return null;
	}

}