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

public class CharacterClass implements Serializable{
	public String name;
	public String hitDiePerLevel;
	public int level = 0;
	public Character me;
	public int skillRanksMod;

	public CharacterClass(Character me, String name){
		this.me = me;
		this.name = name;
	}

	public void levelUp(){
		level++;
	}

	public int[] getBAB(){
		return new int[]{0};
	}

	public int getBaseFortSave(){
		return 0;
	}

	public int getBaseRefSave(){
		return 0;
	}

	public int getBaseWillSave(){
		return 0;
	}

	public String toString(){
		return name;
	}

	public static String[] getClassNames(){
		return new String[]{"Sorcerer", "Magus", "Unchained Rogue"};
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

		if(className.equals("Magus")){
			for(CharacterClass charClass : me.classes){
				if(charClass instanceof Magus) return charClass;
			}
			return new Magus(me);
		}

		if(className.equals("Unchained Rogue")){
			for(CharacterClass charClass : me.classes)
				if(charClass instanceof UnchainedRogue) return charClass;
			return new UnchainedRogue(me);
		}

		return null;
	}

}