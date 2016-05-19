import java.util.*;
import java.io.*;

public abstract class CharacterClass implements Serializable{
	public String name;
	public boolean[] classSkills = new boolean[Character.skillNames.length];
	public ArrayList<Feat> newFeats = new ArrayList<Feat>();
	public ArrayList<Spell> newSpells = new ArrayList<Spell>();
	public ArrayList<String> newNotes = new ArrayList<String>();
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