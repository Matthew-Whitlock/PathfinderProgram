package test;

import src.classes.AbyssalBloodline;
import src.races.Dwarf;
import src.*;

import javax.swing.*;

public class Test{
	public static void main(String[] args){
		JFrame frame = new JFrame("Test");
		frame.add(new CharacterDisplay(new src.Character("Testing", new Dwarf(), new AbyssalBloodline(), new int[]{10,10,10,10,10,10})));
		frame.setSize(700,500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Pathfinder.showWebPage("http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-craft");
	}
}