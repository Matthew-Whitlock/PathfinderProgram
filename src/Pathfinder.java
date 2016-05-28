package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import src.spells.Spell;
import src.feats.Feat;

public class Pathfinder{
	private static final String startPanelName = "startPanel";
	private static final String characterChooserName = "characterChooser";
	private CardLayout cl = new CardLayout();
	private JPanel panel = new JPanel(cl);
	private boolean alreadyMade = false;
	private static final JFrame frame = new JFrame("Pathfinder Helper");
	private static int index = -1;
	private static AtomicBoolean indexSet = new AtomicBoolean();

	public static void main(String[] args){
		new Pathfinder();
	}
	
	public Pathfinder(){
		frame.setSize(700,500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
		return JOptionPane.showConfirmDialog(null, question, "Message!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
	
	public static void popupDialog(String title, String message){
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
	}
	
	public static void showError(String title, String message){
		(new Thread() {
			public void run() {
				JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
			}
		}).start();
	}
	
	public static void spellAddedAutomatically(Spell spell){
		//Put something here to describe the spell!
	}
	
	public static void featAddedAutomatically(Feat feat){
		//Put something here too. Just like the spell version.
	}
	
	public static Spell chooseSpellFromList(ArrayList<Spell> spellChoices, int numberOfSpellCurrentlyChoosing, int totalSpellsOfThisLevelToChoose, int levelOfSpells){
		String[] choices = new String[spellChoices.size()];
		for(int i = 0; i < choices.length; i++) choices[i] = spellChoices.get(i).toString();;
		Spell spell = null;
		JDialog spellChooseFrame = new JDialog((JDialog)null,"Spell "+ numberOfSpellCurrentlyChoosing + " of " + totalSpellsOfThisLevelToChoose + " level " + levelOfSpells + " spells");
		JPanel panel = new JPanel(new BorderLayout());
		spellChooseFrame.add(panel);
		JList<String> list = new JList<String>(choices);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollList = new JScrollPane(list);
		panel.add(scrollList,BorderLayout.CENTER);
		JButton choose = new JButton("Learn selected spell");
		choose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(list.getSelectedIndex() > -1){
					index = list.getSelectedIndex();
					indexSet.set(true);
				}
			}});
		panel.add(choose, BorderLayout.SOUTH);
		
		spellChooseFrame.setSize(300, ((20+spellChoices.size()*10) < 600 ? (20+spellChoices.size()*10) : 600));
		//frame.setEnabled(false);
		spellChooseFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		spellChooseFrame.setVisible(true);
		
		while(!indexSet.get()){}
		indexSet.set(false);
		spellChooseFrame.dispose();
		return spellChoices.get(index);
	}
	
	public static Feat chooseFeatFromList(ArrayList<Feat> featChoices){
		return null; //Implement
	}
}