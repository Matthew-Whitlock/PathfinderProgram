package test;

import src.classes.AbyssalBloodline;
import src.races.Dwarf;
import src.*;
import src.stats.AbilityScoreEnum;

import javax.swing.*;
import java.util.HashMap;

public class Test{
	public static void main(String[] args){
		HashMap<AbilityScoreEnum, Integer> abilityPoints = new HashMap<>();
		for(AbilityScoreEnum ability : AbilityScoreEnum.values()) abilityPoints.put(ability, 10);
		JFrame frame = new JFrame("Test");
		src.Character me = new src.Character("Testing", new Dwarf(), abilityPoints, new String[]{"Sorceror","Wizard"});
		frame.add(new CharacterDisplay(me));
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}