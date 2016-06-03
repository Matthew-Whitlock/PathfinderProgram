package src.classes;

import src.Character;
import src.spells.Spell;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;
import src.stats.Skill;
import src.stats.SkillEnum;
import src.Pathfinder;
import src.stats.Skill;
import java.util.ArrayList;

public class AbyssalBloodline extends Sorceror{
	public String[] bonusSpells = new String[]{"","Cause Fear","Bull's Strength","Rage","Stoneskin","Dismissal",
		"Transformation","Great Teleport","Unholy Aura","Summon Monster"};
	public String[] bonusFeats = new String[]{"Augment Summoning","Cleave","Empower Spell","Great Fortitude",
		"Improved Bull Rush","Improved Sunder","Power Attack","Skill Focus (Knowledge [planes])"};
	public AbyssalBloodline(){
		bloodline = "Abyssal";
	}
	public void levelUpBloodline(Character me){
		if(me.level == 1){
			me.notes.add("Whenever you cast a spell of the summoning subschool, the creatures summoned gain DR/good equal to 1/2 your sorcerer level (minimum 1). This does not stack with any DR the creature might have.");
			me.notes.add("Claws (Su): At 1st level, you can grow claws as a free action. These claws are treated as natural weapons, allowing you to make two claw attacks as a full attack action using your full base attack bonus. These attacks deal 1d4 points of damage each (1d3 if you are Small) plus your Strength modifier. At 5th level, these claws are considered magic weapons for the purpose of overcoming DR. At 7th level, the damage increases by one step to 1d6 points of damage (1d4 if you are Small). At 11th level, these claws become f laming weapons, each dealing an additional 1d6 points of fire damage on a successful hit. You can use your claws for a number of rounds per day equal to 3 + your Charisma modifier. These rounds do not need to be consecutive.");
			Skill knowledgePlanes = me.getSkill(SkillEnum.KNOWLEDGE, "Planes");
			if(knowledgePlanes != null){
				knowledgePlanes.setClassSkill(true);
			} else {
				me.skillsList.add(new Skill(me, SkillEnum.KNOWLEDGE, true, "Planes"));
			}
		}else if(me.level%2 == 1 && me.level < 20){
			Spell toAdd = Spells.searchByName(bonusSpells[me.level/2]);
			me.knownSpells.add(toAdd);
			Pathfinder.spellAddedAutomatically(toAdd);
		}
		
		if(me.level == 3){
			me.notes.add("Demon Resistances (Ex): At 3rd level, you gain resist electricity 5 and a +2 bonus on saving throws made against poison. At 9th level, your resistance to electricity increases to 10 and your bonus on poison saving throws increases to +4.");
		} else if(me.level == 9){
			me.notes.add("Strength of the Abyss (Ex): At 9th level, you gain a +2 inherent bonus to your Strength. This bonus increases to +4 at 13th level, and to +6 at 17th level.");
			me.abilities.put(AbilityScoreEnum.STR, me.abilities.get(AbilityScoreEnum.STR) + 2);
		} else if(me.level == 13 || me.level == 19){
			me.abilities.put(AbilityScoreEnum.STR, me.abilities.get(AbilityScoreEnum.STR) + 2);
		}
		
		for(int i = 1; (me.level - (i * 7)) >= 0; i++){
			if((me.level - (i * 7))%6 == 0){
				//me.currentFeats.add(Pathfinder.chooseFeatFromList(    Put things in here once the feats are ready.    ));
			}
		}
	}
}