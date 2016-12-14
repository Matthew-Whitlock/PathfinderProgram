package src.classes;

import src.Character;
import src.Pathfinder;
import src.gui.SelectionUtils;
import src.feats.Feat;
import src.feats.Feats;
import src.spells.Spell;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;
import src.stats.Skill;
import src.stats.SkillEnum;
import src.stats.SkillUtils;

import java.io.Serializable;
import java.util.ArrayList;

public class AbyssalBloodline extends Sorcerer implements Serializable{

	public String[] bonusSpells = new String[]{"","Cause Fear","Bull's Strength","Rage","Stoneskin","Dismissal",
		"Transformation","Great Teleport","Unholy Aura","Summon Monster"};

	public String[] bonusFeats = new String[]{"Augment Summoning","Cleave","Empower Spell","Great Fortitude",
		"Improved Bull Rush","Improved Sunder","Power Attack","Skill Focus (Knowledge [planes])"};

	public AbyssalBloodline(Character me){
		super(me);
		bloodline = "Abyssal";
	}

	public void levelUpBloodline(){
		if(level == 1){
			me.miscAbilities.put("Bloodline Arcana", "Whenever you cast a spell of the summoning subschool, the creatures summoned gain DR/good equal to 1/2 your sorcerer level (minimum 1). This does not stack with any DR the creature might have.");
			me.miscAbilities.put("Claws (Su)", "At 1st level, you can grow claws as a free action. These claws are treated as natural weapons, allowing you to make two claw attacks as a full attack action using your full base attack bonus. These attacks deal 1d4 points of damage each (1d3 if you are Small) plus your Strength modifier. At 5th level, these claws are considered magic weapons for the purpose of overcoming DR. At 7th level, the damage increases by one step to 1d6 points of damage (1d4 if you are Small). At 11th level, these claws become f laming weapons, each dealing an additional 1d6 points of fire damage on a successful hit. You can use your claws for a number of rounds per day equal to 3 + your Charisma modifier. These rounds do not need to be consecutive.");
			Skill knowledgePlanes = SkillUtils.getSkill(SkillEnum.KNOWLEDGE,me, "Planes");
			if(knowledgePlanes != null){
				knowledgePlanes.setClassSkill(true);
			} else {
				me.skillsList.add(new Skill(me, SkillEnum.KNOWLEDGE, true, "Planes"));
			}
		} else if(level%2 == 1 && level < 20) {
			Spell toAdd = Spells.searchByName(bonusSpells[level/2]);
			knownSpells.add(toAdd);
			Spells.spellAddedAutomatically(toAdd, knownSpells);
		}
		
		if(level == 3){
			me.miscAbilities.put("Demon Resistances (Ex)", "At 3rd level, you gain resist electricity 5 and a +2 bonus on saving throws made against poison. At 9th level, your resistance to electricity increases to 10 and your bonus on poison saving throws increases to +4.");
		} else if(level == 9){
			me.miscAbilities.put("Strength of the Abyss (Ex)", "At 9th level, you gain a +2 inherent bonus to your Strength. This bonus increases to +4 at 13th level, and to +6 at 17th level.");
			me.abilities.put(AbilityScoreEnum.STR, me.abilities.get(AbilityScoreEnum.STR) + 2);
		} else if(level == 13 || level == 19){
			me.abilities.put(AbilityScoreEnum.STR, me.abilities.get(AbilityScoreEnum.STR) + 2);
		}
		
		for(int i = 1; (level - (i * 7)) >= 0; i++){
			if((level - (i * 7))%6 == 0){
				ArrayList<Feat> bonusFeatsList = new ArrayList<Feat>();
				for(String s : bonusFeats) bonusFeatsList.add(Feats.getFeatByName(s));
				me.currentFeats.addAll(SelectionUtils.searchFeats(bonusFeatsList, "Choose an Abyssal Bloodline bonus feat.", 1, Pathfinder.FRAME));
			}
		}
	}
}