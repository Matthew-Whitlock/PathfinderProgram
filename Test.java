import java.awt.*;
import javax.swing.*;
public class Test{
	public static void main(String[] args){
		JFrame frame = new JFrame("Test");
		frame.add(new CharacterDisplay(new Character("Testing", new Dwarf(), new Sorceror(), new int[]{10,10,10,10,10,10})));
		frame.setSize(700,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}