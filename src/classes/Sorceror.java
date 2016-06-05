package src.classes;

import src.Character;
import src.Pathfinder;
import src.feats.Feats;
import src.stats.Skill;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;
import src.stats.SkillEnum;
import src.stats.SkillUtils;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Sorceror extends CharacterClass implements Serializable{
	public String bloodline;
	
	public Sorceror(){
		name = "Sorceror";
		hitDiePerLevel = "1d6";
	}
	
	public void levelUp(Character me){
		me.spellsPerDay = getSpellsPerDay(me);
		if(me.level == 1){
			if(Feats.getFeatByName("Eschew Materials") != null) {
				me.currentFeats.add(Feats.getFeatByName("Eschew Materials"));
			}

			Skill[] classSkills = new Skill[]{new Skill(me,SkillEnum.APPRAISE),new Skill(me,SkillEnum.BLUFF), new Skill(me,SkillEnum.FLY),
					new Skill(me,SkillEnum.INTIMIDATE), new Skill(me,SkillEnum.KNOWLEDGE, "Arcana"), new Skill(me,SkillEnum.SPELLCRAFT),
					new Skill(me,SkillEnum.USE_MAGIC_DEVICE)};

			SkillUtils.applyClassSkills(classSkills, me);
		}
		levelUpBloodline(me);
		learnNewSpells(me);
	}
	
	public int[] getSpellsPerDay(Character me){
		int[][] defaultSpellsPerDayByLevel = new int[][]{{0,0,0,0,0,0,0,0,0},{3,0,0,0,0,0,0,0,0},{4,0,0,0,0,0,0,0,0},{5,0,0,0,0,0,0,0,0},
			{6,3,0,0,0,0,0,0,0},{6,4,0,0,0,0,0,0,0},{6,5,3,0,0,0,0,0,0},{6,6,4,0,0,0,0,0,0},{6,6,5,3,0,0,0,0,0},
			{6,6,6,4,0,0,0,0,0},{6,6,6,5,3,0,0,0,0},{6,6,6,6,4,0,0,0,0},{6,6,6,6,5,3,0,0,0},{6,6,6,6,6,4,0,0,0},
			{6,6,6,6,6,5,3,0,0},{6,6,6,6,6,6,4,0,0},{6,6,6,6,6,6,5,3,0},{6,6,6,6,6,6,6,4,0},{6,6,6,6,6,6,6,5,3},
			{6,6,6,6,6,6,6,6,4},{6,6,6,6,6,6,6,6,6}};
			
		ArrayList<Integer> bonusSpells = new ArrayList<Integer>();
		for(int i = 0; i < (me.abilities.get(AbilityScoreEnum.CHA) - 10)/2; i++){
			bonusSpells.add(0, i/4);
		}
		
		int[] toReturn = defaultSpellsPerDayByLevel[me.level < 20 ? me.level : 20];
		for(int i = 0; i < bonusSpells.size() && 1 < defaultSpellsPerDayByLevel.length; i++){
			toReturn[i] += bonusSpells.get(i);
		}
		
		return toReturn;
	}
	
	public void learnNewSpells(Character me){
		int[][] newSpellsByLevel = new int[][]{{0},{4,2},{1},{0,1},{1,0,1},{0,1,1},{1,0,0,1},{0,1,1,1},{1,0,0,0,1},{0,0,1,1,1},//9 before this.
			{1,0,0,0,0,1},{0,0,1,1,1,1},{0,0,0,0,0,0,1},{0,0,0,0,1,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,0,1,1,1},{0,0,0,0,0,0,0,0,1},//16
			{0,0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,0,0,1}};
		for(int spellLevel = 0; spellLevel < newSpellsByLevel[me.level].length; spellLevel++){
			for(int i = 0; i < newSpellsByLevel[me.level][spellLevel]; i++){
				me.knownSpells.add(Pathfinder.chooseSpellFromList(Spells.search(me,spellLevel),"Spell "+ (i + 1) + " of " + newSpellsByLevel[me.level][spellLevel] + " level " + spellLevel + " spells"));
			}
		}
	}
	
	public String getClassSkillsAsString(){
		return "Temporary - fix this at getClassSkillsAsString() within Sorceror class file";
	}
	
	public int skillRanksAvailable(Character me){
		return 2 + (me.abilities.get(AbilityScoreEnum.INT) - 10)/2;
	}
	
	public abstract void levelUpBloodline(Character me);
	
	public String toString(){
		return bloodline + " " + name;
	}
}