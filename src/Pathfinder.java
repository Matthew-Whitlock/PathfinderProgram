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
	
	public static Spell chooseSpellFromList(ArrayList<Spell> spellChoices, String title){
		String[] choices = new String[spellChoices.size()];
		for(int i = 0; i < choices.length; i++) choices[i] = spellChoices.get(i).toString();
		JFrame spellChooseFrame = new JFrame(title);
		JPanel panel = new JPanel(new BorderLayout());
		spellChooseFrame.add(panel);
		JList<String> list = new JList<String>(choices);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() > 1) {
					int index = list.locationToIndex(evt.getPoint());
					showSpellDetails(spellChoices.get(index));
				}
			}
		});
		
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
		
		spellChooseFrame.setSize(300, ((20+spellChoices.size()*10) < 600 ? (20+spellChoices.size()*15) : 600));
		spellChooseFrame.setVisible(true);
		
		while(!indexSet.get()){}
		indexSet.set(false);
		spellChooseFrame.dispose();
		return spellChoices.get(index);
	}
	
	public static Feat chooseFeatFromList(ArrayList<Feat> featChoices){
		return null; //Implement
	}
	
	public static void showSpellDetails(Spell spell){
		JFrame detailsFrame = new JFrame(spell.name);
		detailsFrame.setSize(450,550);
		JPanel detailsPanel = new JPanel(new BorderLayout());
		JEditorPane text = new JEditorPane("text/html","<html>" + spell.formattedDescription + "</html>");
		text.setEditable(false);
		JScrollPane scrollingText = new JScrollPane(text);
		scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		detailsFrame.add(detailsPanel);
		detailsPanel.add(scrollingText);
		detailsFrame.setVisible(true);
	}

	public static void showFeatDetails(Feat feat){
		JFrame detailsFrame = new JFrame(feat.name);
		detailsFrame.setSize(450,550);
		JPanel detailsPanel = new JPanel(new BorderLayout());
		JEditorPane text = new JEditorPane("text/html","<html>" + feat.fullText + "</html>");
		text.setEditable(false);
		JScrollPane scrollingText = new JScrollPane(text);
		scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		detailsFrame.add(detailsPanel);
		detailsPanel.add(scrollingText);
		detailsFrame.setVisible(true);
	}
	
	
	//Needs work, doesn't display Skill details webpage properly. Doesn't scroll properly, either.
	public static void showWebPage(String url){
		JFrame pageFrame = new JFrame(url);
		try{
			JPanel topPanel = new JPanel();
			JEditorPane display = new JEditorPane(url);
			display.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(display);
			pageFrame.add(topPanel);
			topPanel.add(scrollPane);
			pageFrame.setSize(800,800);
			pageFrame.setVisible(true);
			pageFrame.repaint();
		} catch(Exception e){
			showError("Could not load page","Run this in command for more details");
			e.printStackTrace();
			pageFrame.dispose();
		}
	}
}