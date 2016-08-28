package src.classes;

import src.Character;
import src.Pathfinder;
import src.gui.SelectionUtils;
import src.feats.Feats;
import src.stats.Skill;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;
import src.stats.SkillEnum;
import src.stats.SkillUtils;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Sorcerer extends SpellCaster implements Serializable{

	public String bloodline;

	public Sorcerer(Character me){
		super(me, "Sorcerer");
		hitDiePerLevel = "1d6";
		skillRanksMod = 2;
	}

	public void levelUp(){
		super.levelUp();

		if(level%2 == 1){
			me.currentFeats.addAll(SelectionUtils.chooseFeatFromList(Feats.getAvailableFeats(me), "Choose a feat!", 1));
		}

		if(level == 1){
			if(Feats.getFeatByName("Eschew Materials") != null && !Feats.characterHasFeat("Eschew Materials", me)) {
				me.currentFeats.add(Feats.getFeatByName("Eschew Materials"));
			}

			Skill[] classSkills = new Skill[]{new Skill(me,SkillEnum.APPRAISE),new Skill(me,SkillEnum.BLUFF), new Skill(me,SkillEnum.FLY),
					new Skill(me,SkillEnum.INTIMIDATE), new Skill(me,SkillEnum.KNOWLEDGE, "Arcana"), new Skill(me,SkillEnum.SPELLCRAFT),
					new Skill(me,SkillEnum.USE_MAGIC_DEVICE)};

			SkillUtils.applyClassSkills(classSkills, me);
		}
		if(level%4 == 0){
			Pathfinder.popupDialog("Ability Score increases!","Choose two different ability scores and give both of them a +1!\n" +
			"If the ability is Int, and your modifier goes up, add skill ranks to skills equal to your current level.\n" +
			"If the ability is Con, and your modifier goes up, add your current level value to your total health.");
		}
		levelUpBloodline();
		learnNewSpells();
	}
	
	public int[] getSpellsPerDay(){
		int[][] defaultSpellsPerDayByLevel = new int[][]{{0,0,0,0,0,0,0,0,0,0},{-1,3,0,0,0,0,0,0,0,0},{-1,4,0,0,0,0,0,0,0,0},{-1,5,0,0,0,0,0,0,0,0},
			{-1,6,3,0,0,0,0,0,0,0},{-1,6,4,0,0,0,0,0,0,0},{-1,6,5,3,0,0,0,0,0,0},{-1,6,6,4,0,0,0,0,0,0},{-1,6,6,5,3,0,0,0,0,0},
			{-1,6,6,6,4,0,0,0,0,0},{-1,6,6,6,5,3,0,0,0,0},{-1,6,6,6,6,4,0,0,0,0},{-1,6,6,6,6,5,3,0,0,0},{-1,6,6,6,6,6,4,0,0,0},
			{-1,6,6,6,6,6,5,3,0,0},{-1,6,6,6,6,6,6,4,0,0},{-1,6,6,6,6,6,6,5,3,0},{-1,6,6,6,6,6,6,6,4,0},{-1,6,6,6,6,6,6,6,5,3},
			{-1,6,6,6,6,6,6,6,6,4},{-1,6,6,6,6,6,6,6,6,6}};
			
		ArrayList<Integer> bonusSpells = new ArrayList<>();
		for(int i = 0; i < me.getAbilityMod(AbilityScoreEnum.CHA); i++){
			bonusSpells.add(0, i/4 + 1);
		}
		bonusSpells.add(0,0);
		
		int[] toReturn = defaultSpellsPerDayByLevel[level < 20 ? level : 20];
		for(int i = 0; i < bonusSpells.size() && i < toReturn.length; i++){
			toReturn[i] += bonusSpells.get(i);
		}
		for(int i = 0; i < modifiedSpellsPerDay.length && i < toReturn.length; i++){
			toReturn[i] += modifiedSpellsPerDay[i];
		}
		
		return toReturn;
	}
	
	public void learnNewSpells(){
		int[][] newSpellsByLevel = new int[][]{{0},{4,2},{1},{0,1},{1,0,1},{0,1,1},{1,0,0,1},{0,1,1,1},{1,0,0,0,1},{0,0,1,1,1},
			{1,0,0,0,0,1},{0,0,1,1,1,1},{0,0,0,0,0,0,1},{0,0,0,0,1,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,0,1,1,1},{0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,0,0,1}};
		for(int spellLevel = 0; spellLevel < newSpellsByLevel[level].length; spellLevel++){
			if(spellLevel > me.getAbilityMod(AbilityScoreEnum.CHA)) {
				Pathfinder.showError("Cannot learn spell level " + spellLevel,"You do not have a high enough Charisma modifier to learn spells of level " + spellLevel + " and higher.");
				break;
			}else if(newSpellsByLevel[level][spellLevel] > 0){
				knownSpells.addAll(SelectionUtils.chooseSpellFromList(Spells.search(this,spellLevel),"Choose " + newSpellsByLevel[level][spellLevel] + " level " + spellLevel + " spells", newSpellsByLevel[level][spellLevel]));
			}
		}
	}
	
	public abstract void levelUpBloodline();
	
	public String toString(){
		return bloodline + " " + name;
	}

	public int[] getBAB(){
		int[][] bab = new int[][]{{0},{0},{1},{1},{2},{2},{3},{3},{4},{4},{5},{5},{6,1},{6,1},{7,2},{7,2},{8,3},{8,3},{9,4},{9,4},{10,5}};
		return bab[level];
	}

	public int getBaseFortSave(){
		return (level - 1)/2;
	}

	public int getBaseRefSave(){
		return (level - 1)/2;
	}

	public int getBaseWillSave(){
		return (level/2)+2;
	}
}