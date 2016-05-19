import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class Pathfinder{
	private static final String startPanelName = "startPanel";
	private static final String characterChooserName = "characterChooser";
	private CardLayout cl = new CardLayout();
	private JPanel panel = new JPanel(cl);
	private boolean alreadyMade = false;
	public static void main(String[] args){
		new Pathfinder();
	}
	
	public Pathfinder(){
		JFrame frame = new JFrame("Pathfinder Helper");
		frame.setSize(700,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		JPanel startPanel = new JPanel(new GridBagLayout());
		panel.add(startPanel, startPanelName);
		JButton newCharacter = new JButton("New Character");
		JButton loadCharacter = new JButton("Load Character");
		startPanel.add(newCharacter);
		startPanel.add(loadCharacter);
		newCharacter.addActionListener(e -> makeNewCharacter());
		loadCharacter.addActionListener(e -> loadExistingCharacter());
		CardLayout cl = (CardLayout)(panel.getLayout());
		cl.show(panel,startPanelName);
		
		frame.setVisible(true);
	}
	
	private void makeNewCharacter(){
		if(!alreadyMade){
			panel.add(new CharacterChooser(), characterChooserName);
			cl.show(panel,characterChooserName);
		}
		else cl.show(panel,characterChooserName);
		alreadyMade = true;
	}
	
	private void loadExistingCharacter(){
		
	}
	
	private class CharacterChooser extends JPanel{
		public CharacterChooser(){
			//Do things.
		}
	}
	
	public static boolean askYesNo(String question){
		return JOptionPane.showConfirmDialog(null,question,"Message!",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ? true : false;
	}
	
	public static void popupDialog(String title, String message){
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
	}
	
	/*public static Spell chooseSpellFromList(Spell[] spellChoices, Spell[] spellsWithoutPreReqs, Feat[] alreadyLearned){
		
	}
	
	public static Feat chooseFeatFromList(Feat[] featChoices, Feat[] featsWithoutPreReqs, Feat[] alreadyLearned){
		
	}*/
}