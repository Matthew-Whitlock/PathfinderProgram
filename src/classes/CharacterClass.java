package src.classes;

import src.Character;
import src.spells.Spell;
import src.stats.AbilityScoreEnum;
import src.stats.SkillEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class CharacterClass implements Serializable{
	public String name;
	public String hitDiePerLevel;
	public int level = 0;
	public boolean isCaster = false;
	public int[] spellsCastToday = new int[9];
	public String bloodline;
	public Character me;

	public CharacterClass(Character me){
		this.me = me;
	}
	
	public abstract void levelUp();
	public abstract int skillRanksAvailable();
	
	public String toString(){
		return name;
	}

	public abstract int[] getBAB();
	public abstract int getBaseFortSave();
	public abstract int getBaseRefSave();
	public abstract int getBaseWillSave();

	public ArrayList<Spell> knownSpells = new ArrayList<>();
	public HashMap<Spell, Integer> preppedSpells = new HashMap<>();
}