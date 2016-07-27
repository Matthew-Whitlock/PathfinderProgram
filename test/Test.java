package test;

import src.*;
import src.classes.AbyssalBloodline;
import src.feats.Feat;
import src.feats.Feats;
import src.items.ItemUtil;
import src.items.MagicItem;
import src.races.RaceEnum;
import src.spells.Spell;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Test{
	public static void main(String[] args){
		HashMap<AbilityScoreEnum, Integer> abilityPoints = new HashMap<>();
		for(AbilityScoreEnum ability : AbilityScoreEnum.values()) abilityPoints.put(ability, 10);
		JFrame frame = new JFrame("Test");
		src.Character me = new src.Character("Testing", RaceEnum.AASIMAR, abilityPoints, new String[]{"Sorceror","Wizard"});
		frame.add(new CharacterDisplay(me));
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		/*ArrayList<String> printed = new ArrayList<>();
		for(Spell spell : Spells.getSpells()){
			if(!printed.contains(spell.school)){
				System.out.println(spell.school);
				printed.add(spell.school);
			}
		}*/

		/*for(Feat feat : Feats.getFeats()){
			if(feat.type.equals("Grit")) System.out.println(feat + ": " + feat.description);
		}*/
	}
}