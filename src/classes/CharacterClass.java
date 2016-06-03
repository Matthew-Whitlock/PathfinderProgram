package src.classes;

import src.Character;
import src.spells.Spell;
import src.feats.Feat;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class CharacterClass implements Serializable{
	public String name;
	public int baseFortSave = 0;
	public int baseRefSave = 0;
	public int baseWillSave = 0;
	public int bab = 0;
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