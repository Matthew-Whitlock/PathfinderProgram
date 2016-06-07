package test;

import src.classes.AbyssalBloodline;
import src.races.Dwarf;
import src.*;
import src.stats.AbilityScoreEnum;

import javax.swing.*;
import java.util.HashMap;

public class Test{
	public static void main(String[] args){
		HashMap<AbilityScoreEnum, Integer> abilityPoints = new HashMap<AbilityScoreEnum, Integer>();
		for(AbilityScoreEnum ability : AbilityScoreEnum.values()) abilityPoints.put(ability, 10);
		JFrame frame = new JFrame("Test");
		frame.add(new CharacterDisplay(new src.Character("Testing", new Dwarf(), new AbyssalBloodline(), abilityPoints)));
		frame.setSize(700,500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Pathfinder.showWebPage("http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-craft");
	}
}