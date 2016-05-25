package src.classes;

import src.Character;
import src.Spell;
import src.feats.Feat;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class CharacterClass implements Serializable{
	public String name;
	public boolean[] classSkills = new boolean[Character.skillNames.length];
	public ArrayList<Feat> newFeats = new ArrayList<>();
	public ArrayList<Spell> newSpells = new ArrayList<>();
	public ArrayList<String> newNotes = new ArrayList<>();
	public int baseFortSave = 0;
	public int baseRefSave = 0;
	public int baseWillSave = 0;
	public int[] spellsPerDay = new int[10];
	public String hitDiePerLevel;
	public int level = 0;
	public abstract void levelUp(Character me);
	public abstract int skillRanksAvailable(Character me);
	public abstract String getClassSkillsAsString();
	
	public String toString(){
		return name;
	}
}