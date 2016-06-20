package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import src.classes.CharacterClass;
import src.spells.Spell;
import src.feats.Feat;
import src.spells.Spells;
import src.items.*;

public class Pathfinder{
	private static final String startPanelName = "startPanel";
	private static final String characterChooserName = "characterChooser";
	private CardLayout cl = new CardLayout();
	private JPanel panel = new JPanel(cl);
	private boolean alreadyMade = false;
	private static final JFrame frame = new JFrame("Pathfinder Character Sheet");
	private static int[] indices;

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
		showSpellDetails(spell, spell.name + " was added automatically!");
	}
	
	public static void featAddedAutomatically(Feat feat){
		showFeatDetails(feat, feat.name + " was added automatically");
	}
	
	public static List<Spell> chooseSpellFromList(List<Spell> spellChoices, String title, int maxPicks){
		AtomicBoolean indexSet = new AtomicBoolean(false);
		String[] choices = new String[spellChoices.size()];
		for(int i = 0; i < choices.length; i++) choices[i] = spellChoices.get(i).toString();
		JFrame spellChooseFrame = new JFrame(title);
		JPanel panel = new JPanel(new BorderLayout());
		spellChooseFrame.add(panel);
		JList<String> list = new JList<>(choices);
		
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
		JButton choose = new JButton("Learn selected spell(s)");
		choose.addActionListener(e -> {
            if(list.getSelectedIndex() > -1){
				if(maxPicks == -1 || list.getSelectedIndices().length == maxPicks || (list.getSelectedIndices().length < maxPicks && askYesNo("You have only selected " + list.getSelectedIndices().length + " of " + maxPicks + " spells. Continue?")) || (list.getSelectedIndices().length > maxPicks && Pathfinder.askYesNo("You have selected too many spells. Continue anyway?"))) {
					indices = list.getSelectedIndices();
					indexSet.set(true);
				}
            }
        });
		panel.add(choose, BorderLayout.SOUTH);

		JButton searchButton = new JButton("Search these spells");
		searchButton.addActionListener(e ->{
			(new Thread(){
				public void run(){
					int[] indexes = searchSpells(spellChoices, spellChooseFrame);
					int[] current = list.getSelectedIndices();
					int[] newSet;
					if(current.length > 0) {
						newSet = new int[indexes.length + current.length];
						for (int i = 0; i < current.length; i++) newSet[i] += current[i];
						for (int i = current.length; i < newSet.length; i++) {
							newSet[i] = indexes[i - current.length];
						}
					} else newSet = indexes;

					list.setSelectedIndices(newSet);
				}
			}).start();
		});

		JButton customSpell = new JButton("Choose custom spell");
		customSpell.addActionListener(e -> {
			JDialog customFeatDialog = new JDialog(spellChooseFrame, "Choose a custom spell");
			customFeatDialog.setSize(340,80);
			JPanel customFeatPanel = new JPanel();
			customFeatDialog.add(customFeatPanel);
			JButton create = new JButton("Create a new spell");
			JButton load = new JButton("Load an existing spell");
			customFeatPanel.add(create);
			customFeatPanel.add(load);
			create.addActionListener(evt -> {
				customFeatDialog.dispose();
				(new Thread(){
					public void run(){
						Spell spell = createNewSpell(spellChooseFrame);
						if(spell != null){
							spellChoices.add(spell);
							String[] newChoices = new String[spellChoices.size()];
							for(int i = 0; i < newChoices.length; i++) newChoices[i] = spellChoices.get(i).toString();
							int[] current = list.getSelectedIndices();
							int[] newIndices = new int[current.length + 1];
							for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
							newIndices[newIndices.length - 1] = newChoices.length - 1;
							list.setListData(newChoices);
							list.setSelectedIndices(newIndices);
						}
					}
				}).start();
			});

			load.addActionListener(evt -> {
				customFeatDialog.dispose();
				JFileChooser loadChooser = new JFileChooser();
				int returned = loadChooser.showOpenDialog(spellChooseFrame);
				if(returned == JFileChooser.APPROVE_OPTION){
					Spell spell = null;
					try{
						FileInputStream fileIn = new FileInputStream(loadChooser.getSelectedFile());
						ObjectInputStream objIn = new ObjectInputStream(fileIn);
						spell = (Spell)(objIn.readObject());

					} catch (FileNotFoundException ex){
						showError("Could not load file","You may not have permissions to access the file.\nRun this in command for more details.");
						ex.printStackTrace();
					} catch (IOException ex){
						showError("Unknown IO Exception","Run this in command for more details.");
						ex.printStackTrace();
					} catch (ClassNotFoundException ex){
						showError("Not a spell","It doesn't seem that there's a spell saved in that file.\nThe file may be corrupt.");
					} catch (ClassCastException ex){
						showError("Not a spell", "It appears this is some other kind of Java object.");
					}
					if(spell != null){
						spellChoices.add(spell);
						String[] newChoices = new String[spellChoices.size()];
						for(int i = 0; i < newChoices.length; i++) newChoices[i] = spellChoices.get(i).toString();
						int[] current = list.getSelectedIndices();
						int[] newIndices = new int[current.length + 1];
						for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
						newIndices[newIndices.length - 1] = newChoices.length - 1;
						list.setListData(newChoices);
						list.setSelectedIndices(newIndices);
					}
				}
			});
			customFeatDialog.setVisible(true);
		});
		JPanel top = new JPanel(new BorderLayout());
		top.add(searchButton, BorderLayout.CENTER);
		top.add(customSpell, BorderLayout.WEST);
		panel.add(top, BorderLayout.NORTH);
		
		spellChooseFrame.setSize(340, ((20+spellChoices.size()*10) < 600 ? (20+spellChoices.size()*15) : 600));
		spellChooseFrame.setVisible(true);
		
		while(!indexSet.get()){}
		spellChooseFrame.dispose();
		ArrayList<Spell> toReturn = new ArrayList<>();
		for(int i : indices) toReturn.add(spellChoices.get(i));
		return toReturn;
	}

	public static List<Feat> chooseFeatFromList(List<Feat> featChoices, String title, int maxPicks){
		AtomicBoolean indexSet = new AtomicBoolean(false);
		String[] choices = new String[featChoices.size()];
		for(int i = 0; i < choices.length; i++) choices[i] = featChoices.get(i).toString();
		JFrame featChooseFrame = new JFrame(title);
		JPanel panel = new JPanel(new BorderLayout());
		featChooseFrame.add(panel);
		JList<String> list = new JList<>(choices);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() > 1) {
					int index = list.locationToIndex(evt.getPoint());
					showFeatDetails(featChoices.get(index));
				}
			}
		});

		JScrollPane scrollList = new JScrollPane(list);
		panel.add(scrollList,BorderLayout.CENTER);
		JButton choose = new JButton("Learn selected feat");
		choose.addActionListener(e -> {
			if(list.getSelectedIndices().length > 0){
				if(maxPicks == -1 || list.getSelectedIndices().length == maxPicks || (list.getSelectedIndices().length < maxPicks && askYesNo("You have only selected " + list.getSelectedIndices().length + " of " + maxPicks + " spells. Continue?")) || (list.getSelectedIndices().length > maxPicks && Pathfinder.askYesNo("You have selected too many spells. Continue anyway?"))) {
					indices = list.getSelectedIndices();
					indexSet.set(true);
				}
			}
		});
		panel.add(choose, BorderLayout.SOUTH);


		JButton searchButton = new JButton("Search these feats");
		searchButton.addActionListener(e ->{
			(new Thread(){
				public void run(){
					int[] indexes = searchFeats(featChoices, featChooseFrame);
					int[] current = list.getSelectedIndices();
					int[] newSet;
					if(current.length > 0) {
						newSet = new int[indexes.length + current.length];
						for (int i = 0; i < current.length; i++) newSet[i] += current[i];
						for (int i = current.length; i < newSet.length; i++) {
							newSet[i] = indexes[i - current.length];
						}
					} else newSet = indexes;

					list.setSelectedIndices(newSet);
				}
			}).start();
		});

		JButton customFeat = new JButton("Choose custom feat");
		customFeat.addActionListener(e -> {
			JDialog customFeatDialog = new JDialog(featChooseFrame, "Choose a custom feat");
			customFeatDialog.setSize(320,80);
			JPanel customFeatPanel = new JPanel();
			customFeatDialog.add(customFeatPanel);
			JButton create = new JButton("Create a new feat");
			JButton load = new JButton("Load an existing feat");
			customFeatPanel.add(create);
			customFeatPanel.add(load);
			create.addActionListener(evt -> {
				customFeatDialog.dispose();
				(new Thread(){
					public void run(){
						Feat feat = createNewFeat(featChooseFrame);
						if(feat != null){
							featChoices.add(feat);
							String[] newChoices = new String[featChoices.size()];
							for(int i = 0; i < newChoices.length; i++) newChoices[i] = featChoices.get(i).toString();
							int[] current = list.getSelectedIndices();
							int[] newIndices = new int[current.length + 1];
							for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
							newIndices[newIndices.length - 1] = newChoices.length - 1;
							list.setListData(newChoices);
							list.setSelectedIndices(newIndices);
						}
					}
				}).start();
			});

			load.addActionListener(evt -> {
				customFeatDialog.dispose();
				JFileChooser loadChooser = new JFileChooser();
				int returned = loadChooser.showOpenDialog(featChooseFrame);
				if(returned == JFileChooser.APPROVE_OPTION){
					Feat feat = null;
					try{
						FileInputStream fileIn = new FileInputStream(loadChooser.getSelectedFile());
						ObjectInputStream objIn = new ObjectInputStream(fileIn);
						feat = (Feat)(objIn.readObject());

					} catch (FileNotFoundException ex){
						showError("Could not load file","You may not have permissions to access the file.\nRun this in command for more details.");
						ex.printStackTrace();
					} catch (IOException ex){
						showError("Unknown IO Exception","Run this in command for more details.");
						ex.printStackTrace();
					} catch (ClassNotFoundException ex){
						showError("Not a feat","It doesn't seem that there's a feat saved in that file.\nThe file may be corrupt.");
					} catch (ClassCastException ex){
						showError("Not a feat","It seems this is some other type of Java object.");
					}
					if(feat != null){
						featChoices.add(feat);
						String[] newChoices = new String[featChoices.size()];
						for(int i = 0; i < newChoices.length; i++) newChoices[i] = featChoices.get(i).toString();
						int[] current = list.getSelectedIndices();
						int[] newIndices = new int[current.length + 1];
						for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
						newIndices[newIndices.length - 1] = newChoices.length - 1;
						list.setListData(newChoices);
						list.setSelectedIndices(newIndices);
					}
				}
			});
			customFeatDialog.setVisible(true);
		});
		JPanel top = new JPanel(new BorderLayout());
		top.add(searchButton, BorderLayout.CENTER);
		top.add(customFeat, BorderLayout.WEST);
		panel.add(top, BorderLayout.NORTH);


		featChooseFrame.setSize(320, ((60+featChoices.size()*20) < 600 ? (20+featChoices.size()*15) : 600));
		featChooseFrame.setVisible(true);

		while(!indexSet.get()){}
		indexSet.set(false);
		featChooseFrame.dispose();
		ArrayList<Feat> toReturn = new ArrayList<>();
		for(int i : indices) toReturn.add(featChoices.get(i));
		return toReturn;
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

	public static void showSpellDetails(Spell spell, String title){
		JFrame detailsFrame = new JFrame(title);
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

	public static void showFeatDetails(Feat feat, String title){
		JFrame detailsFrame = new JFrame(title);
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

	public static void showWebPage(String url, String title){
		JFrame pageFrame = new JFrame(title);
		try{
			JFXPanel topPanel = new JFXPanel();

			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					WebView browser = new WebView();
					WebEngine webEngine = browser.getEngine();
					webEngine.load(url);
					pageFrame.add(topPanel);
					topPanel.setScene(new Scene(browser));
				}
			});
			pageFrame.setSize(800,800);
			pageFrame.setVisible(true);
			pageFrame.repaint();
		} catch(Exception e){
			showError("Could not load page","Run this in command for more details");
			e.printStackTrace();
			pageFrame.dispose();
		}
	}

	public static int[] searchSpells(List<Spell> spells, JFrame parent){
		JDialog searchDialog = new JDialog(parent, "Spell Search");
		AtomicBoolean selected = new AtomicBoolean(false);
		AtomicBoolean needsMythic = new AtomicBoolean(false);
		AtomicBoolean needsAugment = new AtomicBoolean(false);

		ArrayList<Spell> results = new ArrayList<>();
		results.addAll(spells);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel name = new JLabel("Name: ");
		name.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel subschool = new JLabel("Subschool: ");
		subschool.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel descriptor = new JLabel("Descriptor: ");
		descriptor.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel classLabel = new JLabel("Class: ");
		classLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel level = new JLabel("Level: ");
		level.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel bloodline = new JLabel("Bloodline");
		bloodline.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel bloodlineLevel = new JLabel("Level: ");
		bloodlineLevel.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel domain = new JLabel("Domain: ");
		domain.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel hasMythic = new JLabel("Has Mythic: ");
		hasMythic.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel deity = new JLabel("Deity: ");
		deity.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel hasAugment = new JLabel("Has Augment: ");
		hasAugment.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel descriptionContains = new JLabel("Description contains: ");
		descriptionContains.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel spellType = new JLabel("Spell type");
		spellType.setBorder(BorderFactory.createLineBorder(Color.black));

		JTextField nameField = new JTextField();
		JTextField subschoolField = new JTextField();
		JTextField descriptorField = new JTextField();
		JTextField classField = new JTextField();
		JTextField levelField = new JTextField();
		JTextField bloodlineField = new JTextField();
		JTextField bloodlineLevelField = new JTextField();
		JTextField domainField = new JTextField();
		JCheckBox hasMythicBox = new JCheckBox();
		JTextField deityField = new JTextField();
		JCheckBox hasAugmentBox = new JCheckBox();
		JTextField descriptionContainsField = new JTextField();
		JTextField typeField = new JTextField();

		c.weighty = 0;
		c.weightx = 0;
		c.fill = GridBagConstraints.BOTH;
		panel.add(name, c);
		c.gridy = 1;
		panel.add(subschool, c);
		c.gridy = 2;
		panel.add(descriptor, c);
		c.gridy = 3;
		panel.add(classLabel, c);
		c.gridy = 4;
		panel.add(bloodline, c);
		c.gridy = 5;
		panel.add(spellType, c);
		c.gridy = 6;
		panel.add(descriptionContains, c);

		c.gridy = 0;
		c.gridx = 2;
		panel.add(deity, c);
		c.gridy = 1;
		panel.add(domain, c);
		c.gridy = 2;
		panel.add(hasAugment, c);
		c.gridy = 3;
		panel.add(level, c);
		c.gridy = 4;
		panel.add(bloodlineLevel, c);
		c.gridy = 5;
		panel.add(hasMythic, c);

		c.gridy = 0;
		c.gridx = 1;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		panel.add(nameField, c);
		c.gridy = 1;
		panel.add(subschoolField, c);
		c.gridy = 2;
		panel.add(descriptorField, c);
		c.gridy = 3;
		panel.add(classField, c);
		c.gridy = 4;
		panel.add(bloodlineField, c);
		c.gridy = 5;
		panel.add(typeField, c);
		c.gridy = 6;
		c.gridwidth = 3;
		panel.add(descriptionContainsField, c);

		c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 0;
		panel.add(deityField, c);
		c.gridy = 1;
		panel.add(domainField, c);
		c.gridy = 2;
		panel.add(hasAugmentBox, c);
		c.gridy = 3;
		panel.add(levelField, c);
		c.gridy = 4;
		panel.add(bloodlineLevelField, c);
		c.gridy = 5;
		panel.add(hasMythicBox, c);

		JButton searchButton = new JButton("Search with these values");
		c.gridy = 7;
		c.gridx = 0;
		c.gridwidth = 4;
		panel.add(searchButton, c);


		JList<String> resultsList = new JList<>();

		resultsList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() > 1) {
					int index = list.locationToIndex(evt.getPoint());
					showSpellDetails(results.get(index));
				}
			}
		});

		JScrollPane resultsScroll = new JScrollPane(resultsList){
			public void paintComponent(Graphics g){
				String[] model = new String[results.size()];
				for(int i = 0; i < model.length; i++) model[i] = results.get(i).toString();
				resultsList.setListData(model);
			}
		};
		c.gridy++;
		c.weightx = 1;
		c.weighty = 1;
		panel.add(resultsScroll, c);

		JButton select = new JButton("Select chosen spell(s)");
		c.gridy++;
		c.weighty = 0;
		panel.add(select, c);

		select.addActionListener(e -> selected.set(true));

		searchDialog.add(panel);
		searchDialog.setSize(500,600);
		searchDialog.setVisible(true);

		hasAugmentBox.addActionListener(e -> needsAugment.set(!needsAugment.get()));
		hasMythicBox.addActionListener(e -> needsMythic.set(!needsMythic.get()));


		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				results.clear();
				results.addAll(spells);

				ArrayList<Spell> intermediary = new ArrayList<>();

				if(!nameField.getText().equals("")){
					intermediary.addAll(results.stream().filter(spell -> spell.name.toLowerCase().contains(nameField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
					System.out.println(nameField.getText());
				}
				if(!subschoolField.getText().equals("")){
					intermediary.addAll(results.stream().filter(spell -> spell.subschool.toLowerCase().contains(subschoolField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(!descriptorField.getText().equals("")){
					intermediary.addAll(results.stream().filter(spell -> spell.descriptor.toLowerCase().contains(descriptorField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(!classField.getText().equals("")){
					intermediary.addAll(results.stream().filter(spell -> Spells.spellLevelFor(classField.getText(), spell) != -1).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
					if(!levelField.getText().trim().equals("")){
						intermediary.addAll(results.stream().filter(spell -> Spells.spellLevelFor(classField.getText(), spell) == Integer.parseInt(levelField.getText())).collect(Collectors.toList()));
						results.clear();
						results.addAll(intermediary);
						intermediary.clear();
					}
				}
				if(!bloodlineField.getText().equals("")){
					intermediary.addAll(results.stream().filter(spell -> {
						for(String key : spell.bloodlineLevels.keySet()){
							if(bloodlineField.getText().equalsIgnoreCase(key))
								return true;
						}
						return false;
					}).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
					if(!bloodlineLevelField.getText().trim().equals("")) {
						intermediary.addAll(results.stream().filter(spell -> spell.bloodlineLevels.get(bloodlineField.getText()) == Integer.parseInt(bloodlineLevelField.getText())).collect(Collectors.toList()));
						results.clear();
						results.addAll(intermediary);
						intermediary.clear();
					}
				}
				if(!domainField.getText().equals("")) {
					intermediary.addAll(results.stream().filter(spell -> spell.domain.toLowerCase().contains(domainField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsAugment.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.hasAugment).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsMythic.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.hasMythic).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(!deityField.getText().equals("")) {
					intermediary.addAll(results.stream().filter(spell -> spell.hasDeity && spell.deity.toLowerCase().contains(deityField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(!typeField.getText().equals("")) {
					intermediary.addAll(results.stream().filter(spell -> Spells.spellHasType(typeField.getText(), spell)).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(!descriptionContainsField.getText().equals("")) {
					intermediary.addAll(results.stream().filter(spell -> spell.basicDescription.toLowerCase().contains(descriptionContainsField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}

				resultsScroll.repaint();
			}
		});


		while(!selected.get()){}

		ArrayList<Spell> spellsSelected = new ArrayList<>();
		int[] indices = resultsList.getSelectedIndices();
		for(int i : indices) spellsSelected.add(results.get(i));
		int[] toReturn = new int[spellsSelected.size()];
		int index = 0;
		for(int i = 0; i < spells.size(); i++){
			if(spellsSelected.contains(spells.get(i))){
				toReturn[index] = i;
				index++;
			}
		}

		searchDialog.dispose();

		return toReturn;
	}

	public static int[] searchFeats(List<Feat> feats, JFrame parent){
		JDialog searchDialog = new JDialog(parent, "Feat Search");

		AtomicBoolean selected = new AtomicBoolean(false);
		AtomicBoolean needsTeamwork = new AtomicBoolean(false);
		AtomicBoolean needsCritical = new AtomicBoolean(false);
		AtomicBoolean needsGrit = new AtomicBoolean(false);
		AtomicBoolean needsStyle = new AtomicBoolean(false);
		AtomicBoolean needsPerformance = new AtomicBoolean(false);
		AtomicBoolean needsRacial = new AtomicBoolean(false);
		AtomicBoolean needsCompanionFamiliar = new AtomicBoolean(false);
		AtomicBoolean needsCanDoMultiple = new AtomicBoolean(false);
		AtomicBoolean needsPanache = new AtomicBoolean(false);
		AtomicBoolean needsBetrayal = new AtomicBoolean(false);
		AtomicBoolean needsTargeting = new AtomicBoolean(false);
		AtomicBoolean needsEsoteric = new AtomicBoolean(false);
		AtomicBoolean needsStare = new AtomicBoolean(false);
		AtomicBoolean needsWeaponMastery = new AtomicBoolean(false);
		AtomicBoolean needsItemMastery = new AtomicBoolean(false);
		AtomicBoolean needsArmorMastery = new AtomicBoolean(false);
		AtomicBoolean needsShieldMastery = new AtomicBoolean(false);

		ArrayList<Feat> results = new ArrayList<>();
		results.addAll(feats);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel name = new JLabel("Name: ");
		name.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel type = new JLabel("Type: ");
		type.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel subType = new JLabel("Sub-type: ");
		subType.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel racial = new JLabel("Racial: ");
		racial.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel raceName = new JLabel("Race Name: ");
		raceName.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel teamwork = new JLabel("Teamwork: ");
		teamwork.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel critical = new JLabel("Critical: ");
		critical.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel grit = new JLabel("Grit: ");
		grit.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel style = new JLabel("Style: ");
		style.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel performance = new JLabel("Performance: ");
		performance.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel containsText = new JLabel("Contains text: ");
		containsText.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel companionFamiliar = new JLabel("Companion/Familiar: ");
		companionFamiliar.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel canDoMultiple = new JLabel("Can take multiple: ");
		canDoMultiple.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel panache = new JLabel("Panache: ");
		panache.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel betrayal = new JLabel("Betrayal: ");
		betrayal.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel targeting = new JLabel("Targeting: ");
		targeting.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel esoteric = new JLabel("Esoteric: ");
		esoteric.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel stare = new JLabel("Stare: ");
		stare.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel weaponMastery = new JLabel("Weapon mastery: ");
		weaponMastery.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel itemMastery = new JLabel("Item mastery: ");
		itemMastery.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel armorMastery = new JLabel("Armor mastery: ");
		armorMastery.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel shieldMastery = new JLabel("Shield mastery: ");
		shieldMastery.setBorder(BorderFactory.createLineBorder(Color.black));

		JTextField nameField = new JTextField();
		JTextField subtypeField = new JTextField();
		JTextField typeField = new JTextField();
		JTextField fullTextField = new JTextField();
		JTextField raceNameField = new JTextField();

		JCheckBox racialBox = new JCheckBox();
		JCheckBox teamworkBox = new JCheckBox();
		JCheckBox criticalBox = new JCheckBox();
		JCheckBox gritBox = new JCheckBox();
		JCheckBox styleBox = new JCheckBox();
		JCheckBox performanceBox = new JCheckBox();
		JCheckBox companionFamiliarBox = new JCheckBox();
		JCheckBox canDoMultipleBox = new JCheckBox();
		JCheckBox panacheBox = new JCheckBox();
		JCheckBox betrayalBox = new JCheckBox();
		JCheckBox targetingBox = new JCheckBox();
		JCheckBox esotericBox = new JCheckBox();
		JCheckBox stareBox = new JCheckBox();
		JCheckBox weaponMasteryBox = new JCheckBox();
		JCheckBox itemMasteryBox = new JCheckBox();
		JCheckBox armorMasteryBox = new JCheckBox();
		JCheckBox shieldMasteryBox = new JCheckBox();

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0;
		c.gridy = 0;
		c.gridx = 0;
		panel.add(name, c);
		c.gridy = 1;
		panel.add(type,c);
		c.gridy = 2;
		panel.add(subType, c);
		c.gridy = 3;
		panel.add(containsText, c);
		c.gridy = 4;
		panel.add(racial, c);
		c.gridx = 2;
		panel.add(raceName, c);
		c.weightx = 1;
		c.gridy = 0;
		c.gridx = 1;
		panel.add(nameField, c);
		c.gridy = 1;
		panel.add(typeField, c);
		c.gridy = 2;
		panel.add(subtypeField, c);
		c.gridy = 3;
		panel.add(fullTextField, c);
		c.gridy = 4;
		panel.add(racialBox, c);
		c.gridx = 3;
		panel.add(raceNameField, c);

		JPanel inner = new JPanel(new GridBagLayout());
		JScrollPane scroll = new JScrollPane(inner);
		scroll.setPreferredSize(new Dimension(0,0));
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 4;
		c.weightx = 1;
		c.weighty = 0;
		panel.add(scroll, c);
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		inner.add(teamwork, c);
		c.gridy = 1;
		inner.add(critical,c );
		c.gridy++;
		inner.add(grit, c);
		c.gridy++;
		inner.add(style, c);
		c.gridy++;
		inner.add(performance, c);
		c.gridy++;
		inner.add(companionFamiliar, c);
		c.gridy++;
		inner.add(canDoMultiple, c);
		c.gridy++;
		inner.add(panache, c);
		c.gridy++;
		inner.add(betrayal, c);
		c.gridy++;
		inner.add(targeting, c);
		c.gridy++;
		inner.add(esoteric, c);
		c.gridy++;
		inner.add(stare, c);
		c.gridy++;
		inner.add(weaponMastery, c);
		c.gridy++;
		inner.add(itemMastery, c);
		c.gridy++;
		inner.add(armorMastery, c);
		c.gridy++;
		inner.add(shieldMastery, c);
		c.gridy = 0;
		c.gridx = 1;
		c.weightx = 1;
		inner.add(teamworkBox, c);
		c.gridy++;
		inner.add(criticalBox, c);
		c.gridy++;
		inner.add(gritBox, c);
		c.gridy++;
		inner.add(styleBox, c);
		c.gridy++;
		inner.add(performanceBox, c);
		c.gridy++;
		inner.add(companionFamiliarBox, c);
		c.gridy++;
		inner.add(canDoMultipleBox, c);
		c.gridy++;
		inner.add(panacheBox, c);
		c.gridy++;
		inner.add(betrayalBox, c);
		c.gridy++;
		inner.add(targetingBox, c);
		c.gridy++;
		inner.add(esotericBox, c);
		c.gridy++;
		inner.add(stareBox, c);
		c.gridy++;
		inner.add(weaponMasteryBox, c);
		c.gridy++;
		inner.add(itemMasteryBox, c);
		c.gridy++;
		inner.add(armorMasteryBox, c);
		c.gridy++;
		inner.add(shieldMasteryBox, c);

		racialBox.addActionListener(e -> needsRacial.set(!needsRacial.get()));
		teamworkBox.addActionListener(e -> needsTeamwork.set(!needsTeamwork.get()));
		criticalBox.addActionListener(e -> needsCritical.set(!needsCritical.get()));
		gritBox.addActionListener(e -> needsGrit.set(!needsGrit.get()));
		styleBox.addActionListener(e -> needsStyle.set(!needsStyle.get()));
		performanceBox.addActionListener(e -> needsPerformance.set(!needsPerformance.get()));
		companionFamiliarBox.addActionListener(e -> needsCompanionFamiliar.set(!needsCompanionFamiliar.get()));
		canDoMultipleBox.addActionListener(e -> needsCanDoMultiple.set(!needsCanDoMultiple.get()));
		panacheBox.addActionListener(e -> needsPanache.set(!needsPanache.get()));
		betrayalBox.addActionListener(e -> needsBetrayal.set(!needsBetrayal.get()));
		targetingBox.addActionListener(e -> needsTargeting.set(!needsTargeting.get()));
		esotericBox.addActionListener(e -> needsEsoteric.set(!needsEsoteric.get()));
		stareBox.addActionListener(e -> needsStare.set(!needsStare.get()));
		weaponMasteryBox.addActionListener(e -> needsWeaponMastery.set(!needsWeaponMastery.get()));
		itemMasteryBox.addActionListener(e -> needsItemMastery.set(!needsItemMastery.get()));
		armorMasteryBox.addActionListener(e -> needsArmorMastery.set(!needsArmorMastery.get()));
		shieldMasteryBox.addActionListener(e -> needsShieldMastery.set(!needsShieldMastery.get()));


		JButton searchButton = new JButton("Search with these values");
		c.gridy = 7;
		c.gridx = 0;
		c.gridwidth = 4;
		panel.add(searchButton, c);


		JList<String> resultsList = new JList<>();

		resultsList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() > 1) {
					int index = list.locationToIndex(evt.getPoint());
					showFeatDetails(results.get(index));
				}
			}
		});

		JScrollPane resultsScroll = new JScrollPane(resultsList){
			public void paintComponent(Graphics g){
				String[] model = new String[results.size()];
				for(int i = 0; i < model.length; i++) model[i] = results.get(i).toString();
				resultsList.setListData(model);
			}
		};
		c.gridy++;
		c.weightx = 1;
		c.weighty = 1;
		panel.add(resultsScroll, c);

		JButton select = new JButton("Select chosen feat(s)");
		c.gridy++;
		c.weighty = 0;
		panel.add(select, c);

		select.addActionListener(e -> selected.set(true));


		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				results.clear();
				results.addAll(feats);

				ArrayList<Feat> intermediary = new ArrayList<>();

				if(!nameField.getText().equals("")){
					intermediary.addAll(results.stream().filter(feat -> feat.name.toLowerCase().contains(nameField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
					System.out.println(nameField.getText());
				}
				if(!typeField.getText().equals("")){
					intermediary.addAll(results.stream().filter(spell -> spell.type.toLowerCase().contains(typeField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(!subtypeField.getText().equals("")){
					intermediary.addAll(results.stream().filter(spell -> spell.subType.toLowerCase().contains(subtypeField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(!fullTextField.getText().equals("")){
					intermediary.addAll(results.stream().filter(spell -> spell.fullText.toLowerCase().contains(fullTextField.getText().toLowerCase())).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsRacial.get()){
					intermediary.addAll(results.stream().filter(spell -> spell.racial).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
					if(!raceName.getText().trim().equals("")) {
						intermediary.addAll(results.stream().filter(spell -> spell.raceName.toLowerCase().contains(raceNameField.getText().toLowerCase())).collect(Collectors.toList()));
						results.clear();
						results.addAll(intermediary);
						intermediary.clear();
					}
				}

				if(needsTeamwork.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.teamwork).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsCritical.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.critical).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsGrit.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.grit).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsStyle.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.style).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsPerformance.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.performance).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsCompanionFamiliar.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.companionOrFamiliar).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsCanDoMultiple.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.canDoMultiple).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsPanache.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.panache).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsBetrayal.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.betrayal).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsTargeting.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.targeting).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsEsoteric.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.esoteric).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsStare.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.stare).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsWeaponMastery.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.weaponMastery).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsItemMastery.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.itemMastery).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsArmorMastery.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.armorMastery).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}
				if(needsShieldMastery.get()) {
					intermediary.addAll(results.stream().filter(spell -> spell.shieldMastery).collect(Collectors.toList()));
					results.clear();
					results.addAll(intermediary);
					intermediary.clear();
				}


				resultsScroll.repaint();
			}
		});

		searchDialog.add(panel);
		searchDialog.setSize(500,600);
		searchDialog.setVisible(true);

		while(!selected.get()){}

		ArrayList<Feat> spellsSelected = new ArrayList<>();
		int[] indices = resultsList.getSelectedIndices();
		for(int i : indices) spellsSelected.add(results.get(i));
		int[] toReturn = new int[spellsSelected.size()];
		int index = 0;
		for(int i = 0; i < feats.size(); i++){
			if(spellsSelected.contains(feats.get(i))){
				toReturn[index] = i;
				index++;
			}
		}

		searchDialog.dispose();

		return toReturn;
	}

	public static String getImageOverrideLocation(){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Supported Image Types", "jpg", "gif", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(frame);

		if(returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().toString();
		}

		return "";
	}

	public static Feat createNewFeat(JFrame parent){
		AtomicBoolean featMade = new AtomicBoolean(false);
		AtomicBoolean closed = new AtomicBoolean(false);
		JDialog featCreator = new JDialog(parent, "Create a new Feat");
		JPanel panel = new JPanel(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new BorderLayout());
		featCreator.add(panel);
		panel.add(top, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		panel.add(middle, BorderLayout.CENTER);
		top.add(new JLabel("Name: "), BorderLayout.WEST);
		middle.add(new JLabel("Feat details (supports HTML formatting): "), BorderLayout.NORTH);

		JTextField name = new JTextField();
		top.add(name, BorderLayout.CENTER);

		JTextArea description = new JTextArea();
		JScrollPane descScroll = new JScrollPane(description);
		middle.add(descScroll, BorderLayout.CENTER);

		JButton add = new JButton("Add this feat");
		JButton addAndSave = new JButton("Add and save this feat");

		bottom.add(addAndSave, BorderLayout.EAST);
		bottom.add(add, BorderLayout.CENTER);

		add.addActionListener(e -> {
			if(!(name.getText().equals("")||description.getText().equals(""))){
				featMade.set(true);
			} else {
				showError("Not enough details","You must write a feat name and description.");
			}
		});

		addAndSave.addActionListener(e -> {
			if(!(name.getText().equals("")||description.getText().equals(""))){
				Feat feat = new Feat(name.getText(), description.getText());
				JFileChooser saver = new JFileChooser();
				int returned = saver.showSaveDialog(featCreator);
				if(returned == JFileChooser.APPROVE_OPTION){
					try{
						FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
						ObjectOutputStream out= new ObjectOutputStream(fileOut);
						out.writeObject(feat);
						featMade.set(true);
					} catch (FileNotFoundException ex){
						showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
						ex.printStackTrace();
					} catch (IOException ex){
						showError("Uknown Exception","The file could not be saved.\nRun this in command for more information.");
						ex.printStackTrace();
					}
				}
			} else {
				showError("Not enough details","You must write a feat name and description.");
			}
		});

		featCreator.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closed.set(true);
				featMade.set(true);
			}
		});

		featCreator.setSize(350,400);
		featCreator.setVisible(true);

		while(!featMade.get()){}

		featCreator.dispose();

		if(closed.get()) return null;
		return new Feat(name.getText(), description.getText());
	}

	public static Spell createNewSpell(JFrame parent){
		AtomicBoolean spellMade = new AtomicBoolean(false);
		AtomicBoolean closed = new AtomicBoolean(false);
		JDialog spellCreator = new JDialog(parent, "Create a new spell");
		JPanel panel = new JPanel(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new BorderLayout());
		spellCreator.add(panel);
		panel.add(top, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		panel.add(middle, BorderLayout.CENTER);
		top.add(new JLabel("Name: "), BorderLayout.WEST);
		middle.add(new JLabel("Spell details (supports HTML formatting): "), BorderLayout.NORTH);

		JTextField name = new JTextField();
		top.add(name, BorderLayout.CENTER);

		JTextArea description = new JTextArea();
		JScrollPane descScroll = new JScrollPane(description);
		middle.add(descScroll, BorderLayout.CENTER);

		JButton add = new JButton("Add this spell");
		JButton addAndSave = new JButton("Add and save this spell");

		bottom.add(addAndSave, BorderLayout.EAST);
		bottom.add(add, BorderLayout.CENTER);

		add.addActionListener(e -> {
			if(!(name.getText().equals("")||description.getText().equals(""))){
				spellMade.set(true);
			} else {
				showError("Not enough details","You must write a spell name and description.");
			}
		});

		addAndSave.addActionListener(e -> {
			if(!(name.getText().equals("")||description.getText().equals(""))){
				Spell spell = new Spell(name.getText(), description.getText());
				JFileChooser saver = new JFileChooser();
				int returned = saver.showSaveDialog(spellCreator);
				if(returned == JFileChooser.APPROVE_OPTION){
					try{
						FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
						ObjectOutputStream out= new ObjectOutputStream(fileOut);
						out.writeObject(spell);
						spellMade.set(true);
					} catch (FileNotFoundException ex){
						showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
						ex.printStackTrace();
					} catch (IOException ex){
						showError("Uknown Exception","The file could not be saved.\nRun this in command for more information.");
						ex.printStackTrace();
					}
				}
			} else {
				showError("Not enough details","You must write a spell name and description.");
			}
		});

		spellCreator.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closed.set(true);
				spellMade.set(true);
			}
		});

		spellCreator.setSize(350,400);
		spellCreator.setVisible(true);

		while(!spellMade.get()){}

		spellCreator.dispose();

		if(closed.get()) return null;
		return new Spell(name.getText(), description.getText());
	}

	public static void chooseClassToLevel(Character me, Component characterDisplay){

		String[] classNames = CharacterClass.getClassNames();
		for(int j = 0; j < classNames.length; j++){
			for(int i = 0; i < me.classes.size(); i++) {
				if (me.classes.get(i).toString().contains(classNames[j])) {
					classNames[j] = me.classes.get(i).toString() + " Level " + me.classes.get(i).level;
					break;
				}
			}
		}

		for(CharacterClass charClass : me.classes){
			boolean containsClass = false;
			for(String name : classNames){
				if(charClass.name.contains(name)) containsClass = true;
				break;
			}
			if(!containsClass){
				classNames = Arrays.copyOf(classNames, classNames.length + 1);
				classNames[classNames.length - 1] = charClass.name + " Level " + charClass.level;
			}
		}

		JFrame classChooserFrame = new JFrame("Choose the class to level");
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JComboBox<String> options = new JComboBox<>(classNames);
		JButton confirm = new JButton("Confirm");
		classChooserFrame.add(panel);

		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		panel.add(new JLabel("Level up the class "),c);
		c.gridx = 1;
		c.weightx = 1;
		panel.add(options);
		c.gridx = 2;
		c.weightx = 0;
		panel.add(new JLabel("? "), c);
		c.gridx = 3;
		c.weightx = 0;
		panel.add(confirm, c);

		confirm.addActionListener(e -> {

			String chosenClass = (String)(options.getSelectedItem());
			if(chosenClass.contains(" Level ")) chosenClass = chosenClass.substring(0,chosenClass.indexOf(" Level "));

			if(CharacterClass.getClassInstanceOf(chosenClass,me) != null){
				new Thread(() -> me.levelUp(CharacterClass.getClassInstanceOf(((String)(options.getSelectedItem())).contains(" Level ") ? ((String)(options.getSelectedItem())).substring(0, ((String)(options.getSelectedItem())).indexOf(" Level ")) : ((String)(options.getSelectedItem())),me))).start();
				classChooserFrame.dispose();
				characterDisplay.repaint();
			} else {
				options.setModel(new DefaultComboBoxModel<String>(CharacterClass.getSubclassesOf(chosenClass)));
			}

		});

		classChooserFrame.setSize(400,60);
		classChooserFrame.setVisible(true);
	}

	public static void showItemDetails(Item item){
		JFrame detailsFrame = new JFrame(item.toString());
		detailsFrame.setSize(450,550);
		JPanel detailsPanel = new JPanel(new BorderLayout());
		JEditorPane text = new JEditorPane("text/html","<html>" + item.getFormattedDetails() + "</html>");
		text.setEditable(false);
		JScrollPane scrollingText = new JScrollPane(text);
		scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		detailsFrame.add(detailsPanel);
		detailsPanel.add(scrollingText);
		detailsFrame.setVisible(true);
	}

	public static List<GenItem> chooseItemFromList(List<Item> itemChoices, String title){
		AtomicBoolean indexSet = new AtomicBoolean(false);
		String[] choices = new String[itemChoices.size()];
		for(int i = 0; i < choices.length; i++) choices[i] = itemChoices.get(i).toString();
		JFrame itemChooseFrame = new JFrame(title);
		JPanel panel = new JPanel(new BorderLayout());
		itemChooseFrame.add(panel);
		JList<String> list = new JList<>(choices);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() > 1) {
					int index = list.locationToIndex(evt.getPoint());
					showItemDetails(itemChoices.get(index));
				}
			}
		});

		JScrollPane scrollList = new JScrollPane(list);
		panel.add(scrollList,BorderLayout.CENTER);
		JButton choose = new JButton("Choose selected item(s)");
		choose.addActionListener(e -> {
			if(list.getSelectedIndex() > -1){
				indices = list.getSelectedIndices();
				indexSet.set(true);
			}
		});
		panel.add(choose, BorderLayout.SOUTH);

		JButton searchButton = new JButton("Search these items");
		searchButton.addActionListener(e ->{
			(new Thread(){
				public void run(){
					int[] indexes = searchItems(itemChoices, itemChooseFrame);
					int[] current = list.getSelectedIndices();
					int[] newSet;
					if(current.length > 0) {
						newSet = new int[indexes.length + current.length];
						for (int i = 0; i < current.length; i++) newSet[i] += current[i];
						for (int i = current.length; i < newSet.length; i++) {
							newSet[i] = indexes[i - current.length];
						}
					} else newSet = indexes;

					list.setSelectedIndices(newSet);
				}
			}).start();
		});

		JButton customItem = new JButton("Choose custom item");
		customItem.addActionListener(e -> {
			JDialog customItemDialog = new JDialog(itemChooseFrame, "Choose a custom item");
			customItemDialog.setSize(340,80);
			JPanel customFeatPanel = new JPanel();
			customItemDialog.add(customFeatPanel);
			JButton create = new JButton("Create a new item");
			JButton load = new JButton("Load an existing item");
			customFeatPanel.add(create);
			customFeatPanel.add(load);
			create.addActionListener(evt -> {
				customItemDialog.dispose();
				(new Thread(){
					public void run(){
						Item item = createNewItem(itemChooseFrame);
						if(item != null){
							itemChoices.add(item);
							String[] newChoices = new String[itemChoices.size()];
							for(int i = 0; i < newChoices.length; i++) newChoices[i] = itemChoices.get(i).toString();
							int[] current = list.getSelectedIndices();
							int[] newIndices = new int[current.length + 1];
							for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
							newIndices[newIndices.length - 1] = newChoices.length - 1;
							list.setListData(newChoices);
							list.setSelectedIndices(newIndices);
						}
					}
				}).start();
			});

			load.addActionListener(evt -> {
				customItemDialog.dispose();
				JFileChooser loadChooser = new JFileChooser();
				int returned = loadChooser.showOpenDialog(itemChooseFrame);
				if(returned == JFileChooser.APPROVE_OPTION){
					Item item = null;
					try{
						FileInputStream fileIn = new FileInputStream(loadChooser.getSelectedFile());
						ObjectInputStream objIn = new ObjectInputStream(fileIn);
						item = (Item)(objIn.readObject());

					} catch (FileNotFoundException ex){
						showError("Could not load file","You may not have permissions to access the file.\nRun this in command for more details.");
						ex.printStackTrace();
					} catch (IOException ex){
						showError("Unknown IO Exception","Run this in command for more details.");
						ex.printStackTrace();
					} catch (ClassNotFoundException ex){
						showError("Not an item","It doesn't seem that there's an item saved in that file.\nThe file may be corrupt.");
					} catch (ClassCastException ex){
						showError("Not an item", "It appears this is some other kind of Java object.");
					}
					if(item != null){
						itemChoices.add(item);
						String[] newChoices = new String[itemChoices.size()];
						for(int i = 0; i < newChoices.length; i++) newChoices[i] = itemChoices.get(i).toString();
						int[] current = list.getSelectedIndices();
						int[] newIndices = new int[current.length + 1];
						for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
						newIndices[newIndices.length - 1] = newChoices.length - 1;
						list.setListData(newChoices);
						list.setSelectedIndices(newIndices);
					}
				}
			});
			customItemDialog.setVisible(true);
		});
		JPanel top = new JPanel(new BorderLayout());
		top.add(searchButton, BorderLayout.CENTER);
		top.add(customItem, BorderLayout.WEST);
		panel.add(top, BorderLayout.NORTH);

		itemChooseFrame.setSize(340, ((20+itemChoices.size()*10) < 600 ? (20+itemChoices.size()*15) : 600));
		itemChooseFrame.setVisible(true);

		while(!indexSet.get()){}
		itemChooseFrame.dispose();
		ArrayList<GenItem> toReturn = new ArrayList<>();
		for(int i : indices) toReturn.add( itemChoices.get(i) instanceof GenItem ? (GenItem)itemChoices.get(i) : new GenItem(itemChoices.get(i)) );
		return toReturn;
	}

	public static GenItem createNewItem(JFrame parent){
		AtomicBoolean itemMade = new AtomicBoolean(false);
		AtomicBoolean closed = new AtomicBoolean(false);
		JDialog itemCreator = new JDialog(parent, "Create a new Item");
		JPanel panel = new JPanel(new BorderLayout());
		JPanel top = new JPanel(new GridBagLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new BorderLayout());
		itemCreator.add(panel);
		panel.add(top, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		panel.add(middle, BorderLayout.CENTER);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.weighty = 0;
		top.add(new JLabel("Name: "), c);
		JTextField name = new JTextField();
		c.gridx = 1;
		c.weightx = 1;
		c.gridwidth = 3;
		top.add(name, c);

		c.gridwidth = 1;
		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0;
		top.add(new JLabel("Platinum: "), c);
		c.gridy = 2;
		top.add(new JLabel("Gold"), c);
		c.gridx = 2;
		top.add(new JLabel("Copper: "), c);
		c.gridy = 1;
		top.add(new JLabel("Silver: "), c);
		c.weightx = 1;
		c.gridx = 1;
		JTextField platinum = new JTextField("0");
		JTextField gold = new JTextField("0");
		JTextField silver = new JTextField("0");
		JTextField copper = new JTextField("0");
		top.add(platinum, c);
		c.gridy = 2;
		top.add(gold, c);
		c.gridx = 3;
		top.add(copper, c);
		c.gridx = 1;
		top.add(silver, c);

		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0;
		top.add(new JLabel("Amount per purchase: "));

		JLabel amount = new JLabel("1");
		c.weightx = 1;
		c.gridx = 1;
		top.add(amount, c);

		c.gridx = 2;
		c.weightx = 0;
		top.add(new JLabel(" Weight: "), c);

		JTextField weight = new JTextField("0.0");
		c.gridx = 3;
		c.weightx = 1;
		top.add(weight, c);

		middle.add(new JLabel("Item details (supports HTML formatting): "), BorderLayout.NORTH);


		JTextArea description = new JTextArea();
		JScrollPane descScroll = new JScrollPane(description);
		middle.add(descScroll, BorderLayout.CENTER);

		JButton add = new JButton("Add this item");
		JButton addAndSave = new JButton("Add and save this item");

		bottom.add(addAndSave, BorderLayout.EAST);
		bottom.add(add, BorderLayout.CENTER);

		add.addActionListener(e -> {
			if(!(name.getText().equals(""))){
				itemMade.set(true);
			} else {
				showError("Not enough details","You must write an item name.");
			}
		});

		addAndSave.addActionListener(e -> {
			if(!(name.getText().equals(""))){
				Item item = new GenItem(name.getText(), description.getText(), new int[]{Integer.parseInt(platinum.getText()),Integer.parseInt(gold.getText()),Integer.parseInt(silver.getText()),Integer.parseInt(copper.getText())}, Integer.parseInt(amount.getText()), Double.parseDouble(weight.getText()));
				JFileChooser saver = new JFileChooser();
				int returned = saver.showSaveDialog(itemCreator);
				if(returned == JFileChooser.APPROVE_OPTION){
					try{
						FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
						ObjectOutputStream out= new ObjectOutputStream(fileOut);
						out.writeObject(item);
						itemMade.set(true);
					} catch (FileNotFoundException ex){
						showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
						ex.printStackTrace();
					} catch (IOException ex){
						showError("Uknown Exception","The file could not be saved.\nRun this in command for more information.");
						ex.printStackTrace();
					}
				}
			} else {
				showError("Not enough details","You must write an item name.");
			}
		});

		itemCreator.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closed.set(true);
				itemMade.set(true);
			}
		});

		itemCreator.setSize(350,400);
		itemCreator.setVisible(true);

		while(!itemMade.get()){}

		itemCreator.dispose();

		if(closed.get()) return null;
		return new GenItem(name.getText(), description.getText(), new int[]{Integer.parseInt(platinum.getText()),Integer.parseInt(gold.getText()),Integer.parseInt(silver.getText()),Integer.parseInt(copper.getText())}, Integer.parseInt(amount.getText()), Double.parseDouble(weight.getText()));
	}

	public static int[] searchItems(List<Item> items, JFrame parent){
		JDialog searchDialog = new JDialog(parent, "Item Search");
		JPanel parentPanel = new JPanel(new GridBagLayout());

		AtomicBoolean selected = new AtomicBoolean(false);

		ArrayList<Item> results = new ArrayList<>();
		results.addAll(items);

		CardLayout searchConstraintsLayout = new CardLayout();
		JPanel searchConstraintsParent = new JPanel(searchConstraintsLayout);
		JPanel genItemSearch = new JPanel(new GridBagLayout());
		JPanel weaponSearch = new JPanel(new GridBagLayout());
		JPanel armorSearch = new JPanel(new GridBagLayout());
		JPanel adventureItemSearch = new JPanel(new GridBagLayout());
		JPanel magicItemSearch = new JPanel(new GridBagLayout());
		final String MAGIC_PANEL = "Magic Items";
		final String GEN_PANEL = "All Items";
		final String WEAPON_PANEL = "Base Weapons";
		final String ARMOR_PANEL = "Base Armor/Shields";
		final String ADVENTURE_PANEL = "Adventure Gear";
		final String[] PANEL_NAMES = new String[]{GEN_PANEL, WEAPON_PANEL, ARMOR_PANEL, MAGIC_PANEL, ADVENTURE_PANEL};
		searchConstraintsParent.add(genItemSearch, GEN_PANEL);
		searchConstraintsParent.add(weaponSearch, WEAPON_PANEL);
		searchConstraintsParent.add(armorSearch, ARMOR_PANEL);
		searchConstraintsParent.add(adventureItemSearch, ADVENTURE_PANEL);
		searchConstraintsParent.add(magicItemSearch, MAGIC_PANEL);

		//Set up parent panel
		JComboBox<String> searchType = new JComboBox<>(PANEL_NAMES);
		searchType.addActionListener(e -> searchConstraintsLayout.show(searchConstraintsParent, (String) searchType.getSelectedItem()));
		searchType.setSelectedIndex(0);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		parentPanel.add(new JLabel("Search these items as: "));
		c.gridx = 1;
		c.weightx = 1;
		parentPanel.add(searchType, c);

		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		parentPanel.add(searchConstraintsParent, c);

		JList<String> resultsList = new JList<>();

		resultsList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() > 1) {
					int index = list.locationToIndex(evt.getPoint());
					showItemDetails(results.get(index));
				}
			}
		});

		JScrollPane resultsScroll = new JScrollPane(resultsList){
			public void paintComponent(Graphics g){
				String[] model = new String[results.size()];
				for(int i = 0; i < model.length; i++) model[i] = results.get(i).toString();
				resultsList.setListData(model);
			}
		};

		c.gridy = 2;
		parentPanel.add(resultsScroll, c);

		JButton select = new JButton("Select chosen spell(s)");
		select.addActionListener(e -> selected.set(true));
		c.weighty = 0;
		c.gridy = 3;
		parentPanel.add(select, c);


		while(!selected.get()){}

		ArrayList<Item> itemsSelected = new ArrayList<>();
		int[] indices = resultsList.getSelectedIndices();
		for(int i : indices) itemsSelected.add(results.get(i));
		int[] toReturn = new int[itemsSelected.size()];
		int index = 0;
		for(int i = 0; i < items.size(); i++){
			if(itemsSelected.contains(items.get(i))){
				toReturn[index] = i;
				index++;
			}
		}

		searchDialog.dispose();

		return toReturn;
	}
}