package src.classes;

import src.Character;
import src.stats.SkillEnum;

import java.io.Serializable;
import java.util.Set;

public abstract class CharacterClass implements Serializable{
	public String name;

	protected Set<SkillEnum> classSkills;

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

	public Set<SkillEnum> getClassSkills() {
		return classSkills;
	}
	
	public String toString(){
		return name;
	}
}