package src;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import src.feats.Feat;
import src.feats.Feats;
import src.gui.CharacterDisplay;
import src.gui.SelectionUtils;
import src.items.ItemUtil;
import src.races.GenericRace;
import src.races.Race;
import src.races.RaceEnum;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pathfinder{
	private static final String START_PANEL = "startPanel";
	private static final String RACE_CHOOSER = "raceChooser";
	private static final String CHARACTER_DISPLAY = "characterDisplay";
	private static final String ABILITY_POINT_FRAME = "abilityPointFrame";
	private static final String FINALIZE_PANEL = "finalizePanel";
	private static final String UNGUIDED_PANEL = "unguidedPanel";
	private static final CardLayout CARD_LAYOUT = new CardLayout();
	private static final JPanel PANEL = new JPanel(CARD_LAYOUT);

	public static final JFrame FRAME = new JFrame("Pathfinder Character Sheet");

	public static void main(String[] args){
		FRAME.setSize(523,200);
		FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		/*JLabel background = new JLabel();
		try {
			background.setIcon(new ImageIcon(ImageIO.read(Pathfinder.class.getResource("/src/pictures/Gear_icon.svg.png"))));
		} catch(IOException e){
			showError("ImageIO Error", "Unable to load background image.\nRun this in cmd for more details.");
			e.printStackTrace();
		}
		FRAME.setContentPane(background);*/
		FRAME.add(PANEL);

		JPanel startPanel = new JPanel(new GridBagLayout());
		PANEL.add(startPanel, START_PANEL);
		JButton newCharacter = new JButton("<html> New Character <br><center>(guided)</center></html>");
		JButton loadCharacter = new JButton("Load Character");
		JButton searchFeats = new JButton("Search Feats");
		try {
			searchFeats.setIcon(new ImageIcon(ImageIO.read(Pathfinder.class.getResource("/src/pictures/FeatIcons/S_Buff01.png")).getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		} catch(IOException e){
			showError("Image not found", "I couldn't load the image for the Search Feats button. I don't know why.\nRun this in command for more details.");
			e.printStackTrace();
		}
		JButton searchSpells = new JButton("Search Spells");
		try {
			searchSpells.setIcon(new ImageIcon(ImageIO.read(Pathfinder.class.getResource("/src/pictures/SpellIcons/W_Book04.png")).getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		} catch(IOException e){
			showError("Image not found", "I couldn't load the image for the Search Spells button. I don't know why.\nRun this in command for more details.");
			e.printStackTrace();
		}
		JButton unguidedNew = new JButton("<html> New Character <br><center>(unguided)</center></html>");
		JButton itemSearch = new JButton("Search Items");
		try {
			itemSearch.setIcon(new ImageIcon(ImageIO.read(Pathfinder.class.getResource("/src/pictures/ItemIcons/SwordShieldImage.png")).getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		} catch(IOException e){
			showError("Image not found", "I couldn't load the image for the Search Items button. I don't know why.\nRun this in command for more details.");
			e.printStackTrace();
		}

		unguidedNew.addActionListener(e -> makeNewUnguided());
		newCharacter.addActionListener(e -> makeNewCharacter());
		loadCharacter.addActionListener(e -> loadExistingCharacter());
		searchFeats.addActionListener(e -> new Thread() {
			public void run(){
				SelectionUtils.searchFeats(Feats.getFeats(), "Search all Feats", -1, FRAME);
			}
		}.start());
		searchSpells.addActionListener(e -> new Thread() {
			public void run(){
				SelectionUtils.searchSpells(Spells.getSpells(),FRAME, "Search Spells", -1);
			}
		}.start());
		itemSearch.addActionListener(e -> new Thread() {
			public void run(){
				SelectionUtils.searchItems(ItemUtil.getItems(),FRAME, "Search All Items");
			}
		}.start());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,10,10,10);
		c.weightx = 1;
		c.weighty = 1;
		startPanel.add(newCharacter, c);
		c.gridx = 1;
		startPanel.add(loadCharacter, c);
		c.gridx = 2;
		startPanel.add(unguidedNew, c);
		c.gridy = 1;
		startPanel.add(itemSearch, c);
		c.gridx = 1;
		startPanel.add(searchFeats, c);
		c.gridx = 0;
		startPanel.add(searchSpells, c);

		CARD_LAYOUT.show(PANEL, START_PANEL);

		FRAME.setLocationRelativeTo(null);
		FRAME.setVisible(true);
	}

	private static void makeNewCharacter(){
		JPanel characterMaker = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		JPanel inside = new JPanel(new GridBagLayout());
		JScrollPane scrolling = new JScrollPane(inside);
		characterMaker.add(scrolling, c);

		int numberOfRaces = RaceEnum.values().length + 1;
		int width = 1;
		int height = 1;

		for(int i = numberOfRaces/2; i > 0; i--){
			if(numberOfRaces%i == 0){
				width = i;
				height = numberOfRaces / i;
				break;
			}
		}

		if(width == 1){
			height = 1;
			width = numberOfRaces;
		}

		int y;
		int x = 0;
		for(y = 0; y < height; y++){
			for(x = 0; x < width; x++){
				if(y*width + x == RaceEnum.values().length) break;

				RaceEnum currentRace = RaceEnum.values()[y*width + x];
				c.gridx = x;
				c.gridy = y;
				inside.add(getRaceDisplayPanel(currentRace), c);
			}
		}

		c.gridx = x;
		c.gridy = y - 1;
		inside.add(getGenericRaceDisplayPanel(), c);

		PANEL.add(characterMaker, RACE_CHOOSER);
		CARD_LAYOUT.show(PANEL, RACE_CHOOSER);

		FRAME.setSize(new Dimension(width * 255 + 20, height * 255 + 43));
		FRAME.setLocationRelativeTo(null);
	}

	private static void makeNewUnguided(){
		JLabel strMod = new JLabel("0");
		JLabel dexMod = new JLabel("0");
		JLabel conMod = new JLabel("0");
		JLabel chaMod = new JLabel("0");
		JLabel intMod = new JLabel("0");
		JLabel wisMod = new JLabel("0");
		//This process for updating the points used is convoluted and needs to be reworked.
		JTextField strField = new JTextField("10"){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				getParent().repaint();
			}
		};
		JTextField dexField = new JTextField("10"){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				getParent().repaint();
			}
		};
		JTextField conField = new JTextField("10"){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				getParent().repaint();
			}
		};
		JTextField chaField = new JTextField("10"){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				getParent().repaint();
			}
		};
		JTextField intField = new JTextField("10"){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				getParent().repaint();
			}
		};
		JTextField wisField = new JTextField("10"){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				getParent().repaint();
			}
		};
		JLabel raceImage = new JLabel();
		JTextField nameField = new JTextField();
		JTextField favoredClassesField = new JTextField();

		JLabel pointValue = new JLabel(){
			public void setText(String fillerForOverride){
				try{
					int pointsUsed = 0;
					pointsUsed+= getPointCost(Integer.parseInt(strField.getText()));
					pointsUsed+= getPointCost(Integer.parseInt(dexField.getText()));
					pointsUsed+= getPointCost(Integer.parseInt(conField.getText()));
					pointsUsed+= getPointCost(Integer.parseInt(chaField.getText()));
					pointsUsed+= getPointCost(Integer.parseInt(intField.getText()));
					pointsUsed+= getPointCost(Integer.parseInt(wisField.getText()));
					super.setText(Integer.toString(pointsUsed));
				} catch(NumberFormatException e){
					//Do Nothing.
				}
			}
			private int getPointCost(int value){
				int[] cost = new int[]{-4,-4,-4,-4,-4,-4,-4,-4,-2,-1,0,1,2,3,5,7,10,13,17,17,17};
				if(value <= 7) return -4;
				else if (value >= 18) return 17;
				else return cost[value];
			}
		};
		final JPanel UNGUIDED = new JPanel(new GridBagLayout()){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				pointValue.setText("FillerForOverride");
			}
		};
		final GenericRace CUSTOM_INDICATOR = new GenericRace("Custom Race");


		JComboBox<Race> dropdown = new JComboBox<>(RaceEnum.values());
		dropdown.addItem(CUSTOM_INDICATOR);
		dropdown.addActionListener(e -> {
			if(dropdown.getSelectedItem().equals(CUSTOM_INDICATOR)){
				(new Thread(){ public void run(){
						GenericRace newRace = chooseGenericRace();
						if (newRace != null) {
							dropdown.addItem(newRace);
							dropdown.setSelectedItem(newRace);
						}
				}}).start();
			} else {
				Race currentlySelected = (Race)dropdown.getSelectedItem();
				if(currentlySelected.abilityScoreChanges().containsKey(AbilityScoreEnum.STR)){
					strMod.setText(Integer.toString(currentlySelected.abilityScoreChanges().get(AbilityScoreEnum.STR)));
				} else {
					strMod.setText("0");
				}
				if(currentlySelected.abilityScoreChanges().containsKey(AbilityScoreEnum.DEX)){
					dexMod.setText(Integer.toString(currentlySelected.abilityScoreChanges().get(AbilityScoreEnum.DEX)));
				} else {
					dexMod.setText("0");
				}
				if(currentlySelected.abilityScoreChanges().containsKey(AbilityScoreEnum.CON)){
					conMod.setText(Integer.toString(currentlySelected.abilityScoreChanges().get(AbilityScoreEnum.CON)));
				} else {
					conMod.setText("0");
				}
				if(currentlySelected.abilityScoreChanges().containsKey(AbilityScoreEnum.CHA)){
					chaMod.setText(Integer.toString(currentlySelected.abilityScoreChanges().get(AbilityScoreEnum.CHA)));
				} else {
					chaMod.setText("0");
				}
				if(currentlySelected.abilityScoreChanges().containsKey(AbilityScoreEnum.INT)){
					intMod.setText(Integer.toString(currentlySelected.abilityScoreChanges().get(AbilityScoreEnum.INT)));
				} else {
					intMod.setText("0");
				}
				if(currentlySelected.abilityScoreChanges().containsKey(AbilityScoreEnum.WIS)){
					wisMod.setText(Integer.toString(currentlySelected.abilityScoreChanges().get(AbilityScoreEnum.WIS)));
				} else {
					wisMod.setText("0");
				}
				try{
					raceImage.setIcon(new ImageIcon(ImageIO.read(currentlySelected.getDefaultRaceImageLocation()).getScaledInstance(150,150,Image.SCALE_SMOOTH)));
				} catch(IOException ex){
					showError("IOException", "I couldn't load the image for this race. I'm unsure why.\nRun this in cmd for more details.");
					ex.printStackTrace();
				}catch(Exception ex){
					showError("Unknown Error", "I couldn't load the image for this race. I'm unsure why.\nRun this in cmd for more details.");
					ex.printStackTrace();
				}
			}
		});
		dropdown.setSelectedIndex(0);

		GridBagConstraints c = new GridBagConstraints();
		c.weighty = 1;
		c.weightx = 0;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 3;

		UNGUIDED.add(dropdown, c);

		c.gridheight = 9;
		c.gridy = 1;
		UNGUIDED.add(raceImage, c);

		c.gridwidth = 1;
		c.gridy = 0;
		c.gridx = 3;
		c.gridheight = 1;
		c.ipadx = 10;
		c.weightx = 0;
		UNGUIDED.add(new JLabel("Name: "), c);
		c.gridy++;
		UNGUIDED.add(new JLabel("Strength: "), c);
		c.gridy++;
		UNGUIDED.add(new JLabel("Dexterity: "), c);
		c.gridy++;
		UNGUIDED.add(new JLabel("Constitution: "), c);
		c.gridy++;
		UNGUIDED.add(new JLabel("Charisma: "), c);
		c.gridy++;
		UNGUIDED.add(new JLabel("Intelligence: "), c);
		c.gridy++;
		UNGUIDED.add(new JLabel("Wisdom: "), c);
		c.gridy++;
		c.gridwidth = 2;
		UNGUIDED.add(new JLabel("Points Used: "), c);
		c.gridy++;
		c.gridwidth = 3;
		UNGUIDED.add(new JLabel("List your favored class(es) separated by commas:"), c);

		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weightx = 1;
		UNGUIDED.add(nameField, c);
		c.gridwidth = 1;
		c.gridy++;
		UNGUIDED.add(strField, c);
		c.gridy++;
		UNGUIDED.add(dexField, c);
		c.gridy++;
		UNGUIDED.add(conField, c);
		c.gridy++;
		UNGUIDED.add(chaField, c);
		c.gridy++;
		UNGUIDED.add(intField, c);
		c.gridy++;
		UNGUIDED.add(wisField, c);
		c.gridy = 1;
		c.gridx = 5;
		c.fill = GridBagConstraints.NONE;
		UNGUIDED.add(strMod, c);
		c.gridy++;
		UNGUIDED.add(dexMod, c);
		c.gridy++;
		UNGUIDED.add(conMod, c);
		c.gridy++;
		UNGUIDED.add(chaMod, c);
		c.gridy++;
		UNGUIDED.add(intMod, c);
		c.gridy++;
		UNGUIDED.add(wisMod, c);
		c.gridy++;
		c.fill = GridBagConstraints.BOTH;
		UNGUIDED.add(pointValue, c);

		c.gridy+=2;
		c.gridx = 3;
		c.gridwidth = 3;
		UNGUIDED.add(favoredClassesField, c);

		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(e -> {
			try{
				HashMap<AbilityScoreEnum, Integer> abilities = new HashMap<>();
				abilities.put(AbilityScoreEnum.STR, Integer.parseInt(strField.getText()));
				abilities.put(AbilityScoreEnum.DEX, Integer.parseInt(dexField.getText()));
				abilities.put(AbilityScoreEnum.CON, Integer.parseInt(conField.getText()));
				abilities.put(AbilityScoreEnum.CHA, Integer.parseInt(chaField.getText()));
				abilities.put(AbilityScoreEnum.INT, Integer.parseInt(intField.getText()));
				abilities.put(AbilityScoreEnum.WIS, Integer.parseInt(wisField.getText()));
				String[] favoredClasses = favoredClassesField.getText().split(",");
				for(int i = 0; i < favoredClasses.length; i++) favoredClasses[i] = favoredClasses[i].trim();
				Character newChar = new Character(nameField.getText(), (Race)dropdown.getSelectedItem(), abilities, favoredClasses);
				showCharacter(newChar);
			} catch(NumberFormatException ex){
				showError("Number format exception","Each ability must have an integer value.");
			}
		});

		c.gridy++;
		c.gridx = 0;
		c.gridwidth = 6;
		UNGUIDED.add(confirm, c);

		PANEL.add(UNGUIDED, UNGUIDED_PANEL);
		CARD_LAYOUT.show(PANEL, UNGUIDED_PANEL);
		FRAME.setSize(455, 250);
	}

	private static void loadExistingCharacter() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(FRAME);
		File characterFile = null;

		if(returnVal == JFileChooser.APPROVE_OPTION) {
			characterFile = chooser.getSelectedFile();
		}
		else return;

		try {
			FileInputStream fileIn = new FileInputStream(characterFile);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);

			Character me = (Character) objIn.readObject();

			CharacterDisplay display = new CharacterDisplay(me);

			PANEL.add(display, CHARACTER_DISPLAY);
			FRAME.setSize(600,500);
			CARD_LAYOUT.show(PANEL, CHARACTER_DISPLAY);
		} catch (FileNotFoundException e) {
			showError("Could not find the file", "You may not have permission to access the character file you selected.\nRun this in command for more details.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			showError("Is this a character file?", "This doesn't seem to contain a Character. The file may be corrupted.\nRun this in command for more details.");
			e.printStackTrace();
		} catch(ClassCastException e){
			showError("Is this a character file?","This seems to hold SOME kind of Java object, but it doesn't appear to be a Character.\nRun this in command for more details.");
			e.printStackTrace();
		}catch(IOException e){
			showError("Unknown IO Error","There was an error reading this file, for reasons I do not know.\nRun this in command for more details.");
			e.printStackTrace();
		}
	}

	public static JPanel getRaceDisplayPanel(Race currentRace){

		JPanel toReturn = new JPanel();
		toReturn.setPreferredSize(new Dimension(255,255));


		JPanel topLevelScroll = new JPanel();

		JScrollPane scrollPane = new JScrollPane(topLevelScroll);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(255,255));
		toReturn.add(scrollPane);

		topLevelScroll.setLayout(new OverlayLayout(topLevelScroll));

		JPanel glassPanel = new JPanel();
		glassPanel.setOpaque(false);


		JPanel bottom = new JPanel(new CardLayout(){
			public Dimension preferredLayoutSize(Container parent) {
				Component current = findCurrentComponent(parent);
				if (current != null) {
					Insets insets = parent.getInsets();
					Dimension pref = current.getPreferredSize();
					pref.width += insets.left + insets.right;
					pref.height += insets.top + insets.bottom;
					return pref;
				}
				return super.preferredLayoutSize(parent);
			}

			public Component findCurrentComponent(Container parent) {
				for (Component comp : parent.getComponents()) {
					if (comp.isVisible()) {
						return comp;
					}
				}
				return null;
			}
		});
		final String IMAGE_CARD = "ImageCard";
		final String INFO_CARD = "InfoCard";

		JPanel imagePanel = new JPanel(new GridBagLayout());
		GridBagConstraints temp = new GridBagConstraints();
		JLabel image = new JLabel();
		try{
			image.setIcon(new ImageIcon(ImageIO.read(currentRace.getDefaultRaceImageLocation()).getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		} catch(IOException e){
			showError("Unspecified Error","The image for " + currentRace + " can't be loaded at this time.\nRun this in command for more information.");
			e.printStackTrace();
		} catch(Exception e){
			showError("Unknown Error", "The image for " + currentRace + " could not be loaded.\nRun this in command for more information.");
		}
		temp.weightx = 1;
		temp.weighty = 1;
		imagePanel.add(image, temp);

		bottom.add(imagePanel, IMAGE_CARD);
		((CardLayout)bottom.getLayout()).show(bottom, IMAGE_CARD);



		JPanel raceDetails = new JPanel(new GridBagLayout()){
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(0, super.getPreferredSize().height);
			}
		};
		bottom.add(raceDetails, INFO_CARD);

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.gridy = 0;

		raceDetails.add(new JLabel(currentRace.toString()), c);

		c.weightx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.BOTH;
		JTextArea desc = new JTextArea(currentRace.getDescription() + "\n");
		desc.setEditable(false);
		desc.setWrapStyleWord(true);
		desc.setLineWrap(true);
		raceDetails.add(desc, c);

		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		raceDetails.add(new JLabel("Traits"), c);
		c.fill = GridBagConstraints.BOTH;

		String notes = "\n";
		for(int i = 0; i < currentRace.notes().length - 1; i += 2){
			notes += currentRace.notes()[i] + ": " + currentRace.notes()[i+1] + (i == currentRace.notes().length - 2 ? "\n" : "\n\n");
		}
		c.gridy++;
		JTextArea notesArea = new JTextArea(notes);
		notesArea.setEditable(false);
		notesArea.setWrapStyleWord(true);
		notesArea.setLineWrap(true);
		raceDetails.add(notesArea, c);

		c.gridy++;
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		raceDetails.add(new JLabel("Ability Score Changes"), c);
		c.fill = GridBagConstraints.BOTH;

		c.gridy++;
		c.weightx = 1;
		String abilityScoreChanges = "\n";
		for(AbilityScoreEnum ability : currentRace.abilityScoreChanges().keySet()){
			abilityScoreChanges += ability.toString() + " " + (currentRace.abilityScoreChanges().get(ability) < 0 ? currentRace.abilityScoreChanges().get(ability) : "+" + currentRace.abilityScoreChanges().get(ability)) + "\n";
		}
		JTextArea abilityScoreArea = new JTextArea(abilityScoreChanges);
		abilityScoreArea.setEditable(false);
		abilityScoreArea.setWrapStyleWord(true);
		abilityScoreArea.setLineWrap(true);
		raceDetails.add(abilityScoreArea, c);

		if(currentRace.bonusFeats().length > 0){
			c.gridy++;
			c.weightx = 0;
			c.fill = GridBagConstraints.NONE;
			raceDetails.add(new JLabel("Bonus Feats"), c);
			c.fill = GridBagConstraints.BOTH;
			String bonusFeats = "\n";
			for(Feat feat : currentRace.bonusFeats()){
				bonusFeats += feat.toString() + ": " + feat.description + "\n";
			}

			c.gridy++;
			c.weightx = 1;
			JTextArea featsArea = new JTextArea(bonusFeats);
			featsArea.setEditable(false);
			featsArea.setWrapStyleWord(true);
			featsArea.setLineWrap(true);
			raceDetails.add(featsArea, c);
		}

		JButton choose = new JButton("Choose this race");
		c.gridy++;
		raceDetails.add(choose, c);

		glassPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rectangle actualBounds = new Rectangle(choose.getLocationOnScreen().x,choose.getLocationOnScreen().y, choose.getVisibleRect().width, choose.getVisibleRect().height);
				if(actualBounds.contains(e.getLocationOnScreen())){
					chooseAbilityPoints(currentRace);
				} //Just forward clicks to items beneath, not only to button. Look at coding for non-working inventory list.
			}
		});

		glassPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((CardLayout)bottom.getLayout()).show(bottom, IMAGE_CARD);
			}
		});

		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((CardLayout)bottom.getLayout()).show(bottom, IMAGE_CARD);
			}
		});
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
			@Override
			protected void installListeners() {
				super.installListeners();
				if (incrButton != null) {
					incrButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							super.mouseEntered(e);
							((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
						}
					});
				}
				if (decrButton != null) {
					decrButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							super.mouseEntered(e);
							((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
						}
					});
				}
			}
		});
		scrollPane.getVerticalScrollBar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((CardLayout)bottom.getLayout()).show(bottom, IMAGE_CARD);
			}
		});

		topLevelScroll.add(glassPanel);
		topLevelScroll.add(bottom);

		return toReturn;
	}

	public static JPanel getGenericRaceDisplayPanel(){

		JPanel toReturn = new JPanel();
		toReturn.setPreferredSize(new Dimension(255,255));


		JPanel topLevelScroll = new JPanel();

		JScrollPane scrollPane = new JScrollPane(topLevelScroll);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(255,255));
		toReturn.add(scrollPane);

		topLevelScroll.setLayout(new OverlayLayout(topLevelScroll));

		JPanel glassPanel = new JPanel();
		glassPanel.setOpaque(false);


		JPanel bottom = new JPanel(new CardLayout(){
			public Dimension preferredLayoutSize(Container parent) {
				Component current = findCurrentComponent(parent);
				if (current != null) {
					Insets insets = parent.getInsets();
					Dimension pref = current.getPreferredSize();
					pref.width += insets.left + insets.right;
					pref.height += insets.top + insets.bottom;
					return pref;
				}
				return super.preferredLayoutSize(parent);
			}

			public Component findCurrentComponent(Container parent) {
				for (Component comp : parent.getComponents()) {
					if (comp.isVisible()) {
						return comp;
					}
				}
				return null;
			}
		});
		final String IMAGE_CARD = "ImageCard";
		final String INFO_CARD = "InfoCard";

		JPanel imagePanel = new JPanel(new GridBagLayout());
		GridBagConstraints temp = new GridBagConstraints();

		JLabel image = new JLabel();
		try{
			image.setIcon(new ImageIcon(ImageIO.read(Pathfinder.class.getResource("/src/pictures/RaceImages/Default.png")).getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		} catch(IOException e){
			showError("Unspecified Error","The image for a generic race can't be loaded at this time.\nRun this in command for more information.");
			e.printStackTrace();
		} catch(Exception e){
			showError("Unknown Error", "The image for a generic race could not be loaded.\nRun this in command for more information.");
		}

		temp.weightx = 1;
		temp.weighty = 1;
		imagePanel.add(image, temp);

		bottom.add(imagePanel, IMAGE_CARD);
		((CardLayout)bottom.getLayout()).show(bottom, IMAGE_CARD);



		JPanel raceDetails = new JPanel(new GridBagLayout()){
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(0, super.getPreferredSize().height);
			}
		};
		bottom.add(raceDetails, INFO_CARD);

		JButton choose = new JButton("Use a race not shown here");
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.gridy = 0;
		raceDetails.add(choose, c);

		glassPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rectangle actualBounds = new Rectangle(choose.getLocationOnScreen().x,choose.getLocationOnScreen().y, choose.getVisibleRect().width, choose.getVisibleRect().height);
				if(actualBounds.contains(e.getLocationOnScreen())){
					new Thread(){
						public void run(){
							Race genRace = chooseGenericRace();
							if(genRace != null) chooseAbilityPoints(genRace);
						}
					}.start();
				}
			}
		});

		glassPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((CardLayout)bottom.getLayout()).show(bottom, IMAGE_CARD);
			}
		});

		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((CardLayout)bottom.getLayout()).show(bottom, IMAGE_CARD);
			}
		});
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
			@Override
			protected void installListeners() {
				super.installListeners();
				if (incrButton != null) {
					incrButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							super.mouseEntered(e);
							((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
						}
					});
				}
				if (decrButton != null) {
					decrButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							super.mouseEntered(e);
							((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
						}
					});
				}
			}
		});
		scrollPane.getVerticalScrollBar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				((CardLayout)bottom.getLayout()).show(bottom, INFO_CARD);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				((CardLayout)bottom.getLayout()).show(bottom, IMAGE_CARD);
			}
		});

		topLevelScroll.add(glassPanel);
		topLevelScroll.add(bottom);

		return toReturn;
	}

	public static void chooseAbilityPoints(Race chosenRace){
		JPanel abilityPointPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridy = 0;
		c.gridx = 1;
		c.gridheight = 9;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(0,0,0,30);

		JLabel raceImage = new JLabel();
		try{
			raceImage.setIcon(new ImageIcon(ImageIO.read(chosenRace.getDefaultRaceImageLocation()).getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		} catch(IOException e){
			showError("Unspecified Error","The image for " + chosenRace + " can't be loaded at this time.\nRun this in command for more information.");
			e.printStackTrace();
		}
		abilityPointPanel.add(raceImage, c);

		c.insets = new Insets(0,0,10,0);
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 5;
		c.gridx = 2;
		JLabel title = new JLabel("Choose your ability points!");
		title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), title.getFont().getSize() + 5));
		abilityPointPanel.add(title, c);
		c.gridwidth = 1;
		c.gridy = 1;
		c.gridx = 3;
		c.insets = new Insets(0,15,0,15);
		abilityPointPanel.add(new JLabel("Score"), c);
		c.gridx = 4;
		abilityPointPanel.add(new JLabel("Racial Modifiers"), c);
		c.gridx = 5;
		abilityPointPanel.add(new JLabel("Ability Mod"), c);
		c.gridx = 6;
		abilityPointPanel.add(new JLabel("Points Used"), c);
		c.insets = new Insets(4,0,4,0);

		JLabel totalPointsUsedLabel = new JLabel("0");

		HashMap<AbilityScoreEnum, Integer> abilityScores = new HashMap<>();

		for(AbilityScoreEnum ability : AbilityScoreEnum.values()){
			c.gridy++;
			c.gridx = 2;
			c.fill = GridBagConstraints.BOTH;
			c.ipadx = 15;
			JLabel temp = new JLabel(ability.getFullName());
			abilityPointPanel.add(temp, c);
			c.ipadx = 0;
			c.fill = GridBagConstraints.NONE;

			c.gridx = 4;
			JLabel modifier = new JLabel(chosenRace.abilityScoreChanges().containsKey(ability) ? Integer.toString(chosenRace.abilityScoreChanges().get(ability)) : "");
			abilityPointPanel.add(modifier, c);
			JLabel abilityMod = new JLabel("0");
			c.gridx = 5;
			abilityPointPanel.add(abilityMod, c);
			c.gridx = 6;
			JLabel pointsUsed = new JLabel("0");
			abilityPointPanel.add(pointsUsed, c);

			c.gridx = 3;
			c.fill = GridBagConstraints.BOTH;
			JTextField score = new JTextField("10"){
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					int myNumber = 0;
					try{
						myNumber = getText().equals("") ? 0 : Integer.parseInt(getText());
					} catch(NumberFormatException e){
						//leave myNumber = 0
					}
					abilityMod.setText(Integer.toString(((myNumber + Integer.parseInt(modifier.getText().equals("") ? "0" : modifier.getText()))-10)/2));
					int[] cost = new int[]{-4,-4,-4,-4,-4,-4,-4,-4,-2,-1,0,1,2,3,5,7,10,13,17,17,17};
					int oldPointsUsedByThis = Integer.parseInt(pointsUsed.getText());
					int newPointsUsed;
					if(myNumber <= 7) newPointsUsed = -4;
					else if (myNumber >= 18) newPointsUsed = 17;
					else newPointsUsed = cost[myNumber];
					pointsUsed.setText(Integer.toString(newPointsUsed));
					int totalPointsUsed = Integer.parseInt(totalPointsUsedLabel.getText());
					totalPointsUsed += newPointsUsed - oldPointsUsedByThis;
					totalPointsUsedLabel.setText(Integer.toString(totalPointsUsed));

					abilityScores.put(ability, myNumber);
				}
			};
			abilityPointPanel.add(score, c);
			c.fill = GridBagConstraints.NONE;
		}

		c.insets = new Insets(0,0,0,0);

		c.gridx = 2;
		c.gridwidth = 2;
		c.gridy++;
		c.anchor = GridBagConstraints.SOUTH;
		JButton confirm = new JButton("Confirm these choices");
		abilityPointPanel.add(confirm, c);
		c.gridx = 4;
		abilityPointPanel.add(new JLabel("Total Points Used: "), c);
		c.gridx = 6;
		c.gridwidth = 1;
		abilityPointPanel.add(totalPointsUsedLabel, c);
		c.anchor = GridBagConstraints.CENTER;

		c.gridwidth = 1;
		c.gridx = 0;
		c.weightx = 1;
		abilityPointPanel.add(new JLabel(), c);
		c.gridx = 7;
		abilityPointPanel.add(new JLabel(), c);
		c.weighty = 1;
		c.gridx = 0;
		c.gridwidth = 9;
		c.gridy++;
		c.fill = GridBagConstraints.BOTH;
		JEditorPane descriptionPane = new JEditorPane("text/html", getAbilityInformationString());
		descriptionPane.setEditable(false);
		for(MouseListener ml : descriptionPane.getMouseListeners()) descriptionPane.removeMouseListener(ml);
		for(MouseMotionListener mml : descriptionPane.getMouseMotionListeners()) descriptionPane.removeMouseMotionListener(mml);
		JScrollPane descScroll = new JScrollPane(descriptionPane);
		abilityPointPanel.add(descScroll, c);
		descriptionPane.setCaretPosition(0);

		confirm.addActionListener(e -> finalizeCharacter(chosenRace, abilityScores));

		PANEL.add(abilityPointPanel, ABILITY_POINT_FRAME);
		CARD_LAYOUT.show(PANEL, ABILITY_POINT_FRAME);
		FRAME.setSize(770, 610);
		FRAME.setLocationRelativeTo(null);
	}

	public static void finalizeCharacter(Race chosenRace, HashMap<AbilityScoreEnum, Integer> abilityScores){
		JTextField nameField = new JTextField();
		JTextField classesField = new JTextField();
		JButton finish = new JButton("Finalize your character");

		JEditorPane details = new JEditorPane("text/html",getFavoredClassInfoString());
		details.setEditable(false);
		details.setCaretPosition(0);
		for(MouseListener ml : details.getMouseListeners()) details.removeMouseListener(ml);
		for(MouseMotionListener mml : details.getMouseMotionListeners()) details.removeMouseMotionListener(mml);
		JScrollPane detailsScroll = new JScrollPane(details);

		finish.addActionListener(e -> {
			Character me = new Character(nameField.getText(), chosenRace, abilityScores, classesField.getText().split(","));
			showCharacter(me);
		});

		JPanel finalizePanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		JLabel raceImage = new JLabel();
		try {
			raceImage.setIcon(new ImageIcon(ImageIO.read(chosenRace.getDefaultRaceImageLocation()).getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
		}catch (IOException e){
			showError("Error", "Could not find the image for the chosen race.\nRun in cmd for more details");
		}
		c.gridwidth = 2;
		c.gridheight = 6;
		finalizePanel.add(raceImage, c);

		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 0;
		c.ipadx = 50;
		c.ipady = 10;

		for(AbilityScoreEnum ability : abilityScores.keySet()){
			JLabel abilityLabel = new JLabel(ability + ": "  + (ability == AbilityScoreEnum.INT ? " " : "") + ((chosenRace.abilityScoreChanges().containsKey(ability) ? chosenRace.abilityScoreChanges().get(ability) : 0) + abilityScores.get(ability)));
			finalizePanel.add(abilityLabel, c);
			if(c.gridy == 2) c.gridx++;
			c.gridy = (c.gridy + 1)%3;
		}

		c.ipady = 0;
		c.gridx = 2;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		finalizePanel.add(new JLabel("Name your character: "), c);

		c.ipadx = 0;
		c.gridx = 3;
		c.weightx = 1;
		finalizePanel.add(nameField, c);

		c.weightx = 0;
		c.gridx = 2;
		c.gridy++;
		c.gridwidth = 2;
		finalizePanel.add(new JLabel("Next, write in your favored class(es) seperated by commas."), c);

		c.gridy++;
		finalizePanel.add(classesField, c);

		c.gridy++;
		c.gridx = 0;
		c.gridwidth = 4;
		c.gridheight = 6;
		c.weighty = 1;
		c.weightx = 1;
		finalizePanel.add(detailsScroll, c);

		c.gridheight = 1;
		c.weighty = 0;
		c.gridy += 6;
		finalizePanel.add(finish, c);

		PANEL.add(finalizePanel, FINALIZE_PANEL);
		CARD_LAYOUT.show(PANEL, FINALIZE_PANEL);
		FRAME.setSize(500, 450);
		FRAME.setLocationRelativeTo(null);
	}

	public static String getAbilityInformationString(){

		ArrayList<String> sections = new ArrayList<>();

		sections.add("<head>\n" +
				"<style>\n" +
				"a {color: black; text-decoration: none;}\n" +
				"</style>\n" +
				"</head>");
		sections.add("Each character has six ability scores that represent his character's most basic attributes. They are his raw talent and prowess. While a character rarely rolls a check using just an ability score, these scores, and the modifiers they create, affect nearly every aspect of a character's skills and abilities. Each ability score generally ranges from 3 to 18, although racial bonuses and penalties can alter this; an average ability score is 10.");
		sections.add("<br>" + "<br>" + "<b>Generating Ability Scores</b>");
		sections.add("<br>" + "There are a number of different methods used to generate ability scores. Each of these methods gives a different level of flexibility and randomness to character generation.");
		sections.add("<br>" +  "Racial modifiers (adjustments made to your ability scores due to your character's race—see Races) are applied after the scores are generated.");
		sections.add("<br>" + "<br>" + "<b>Standard</b>: Roll 4d6, discard the lowest die result, and add the three remaining results together. Record this total and repeat the process until six numbers are generated. Assign these totals to your ability scores as you see fit. This method is less random than Classic and tends to create characters with above-average ability scores.");
		sections.add("<br>" + "<br>" + "<b>Classic</b>: Roll 3d6 and add the dice together. Record this total and repeat the process until you generate six numbers. Assign these results to your ability scores as you see fit. This method is quite random, and some characters will have clearly superior abilities. This randomness can be taken one step further, with the totals applied to specific ability scores in the order they are rolled. Characters generated using this method are difficult to fit to predetermined concepts, as their scores might not support given classes or personalities, and instead are best designed around their ability scores.");
		sections.add("<br>" + "<br>" + "<b>Heroic</b>: Roll 2d6 and add 6 to the sum of the dice. Record this total and repeat the process until six numbers are generated. Assign these totals to your ability scores as you see fit. This is less random than the Standard method and generates characters with mostly above-average scores.");
		sections.add("<br>" + "<br>" + "<b>Dice Pool</b>: Each character has a pool of 24d6 to assign to his statistics. Before the dice are rolled, the player selects the number of dice to roll for each score, with a minimum of 3d6 for each ability. Once the dice have been assigned, the player rolls each group and totals the result of the three highest dice. For more high-powered games, the GM should increase the total number of dice to 28. This method generates characters of a similar power to the Standard method.");
		sections.add("<br>" + "<br>" + "<b>Purchase</b>: Each character receives a number of points to spend on increasing his basic attributes. In this method, all attributes start at a base of 10. A character can increase an individual score by spending some of his points. Likewise, he can gain more points to spend on other scores by decreasing one or more of his ability scores. No score can be reduced below 7 or raised above 18 using this method. See Table: Ability Score Costs for the costs of each score. After all the points are spent, apply any racial modifiers the character might have.");
		sections.add("<br>" + "<br>" + "The number of points you have to spend using the purchase method depends on the type of campaign you are playing. The standard value for a character is 15 points. Average nonplayer characters (NPCs) are typically built using as few as 3 points. See Table: Ability Score Points for a number of possible point values depending on the style of campaign. The purchase method emphasizes player choice and creates equally balanced characters.");
		sections.add("<br>" + "<br>" + "<caption style=\"text-align:left;font-weight:bold;padding:10px 0px\">Table: Ability Score Costs</caption>\n" +
				"<thead>\n" +
				"<tr style=\"background-color:rgb(207,226,243)\">\n" +
				"<th style=\"text-align:center\">Score</th>\n" +
				"<th style=\"text-align:center\">Points</th>\n" +
				"</tr>\n" +
				"</thead>\n" +
				"<tbody>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>7</td>\n" +
				"<td>–4</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>8</td>\n" +
				"<td>–2</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>9</td>\n" +
				"<td>–1</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>10</td>\n" +
				"<td>0</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>11</td>\n" +
				"<td>1</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>12</td>\n" +
				"<td>2</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>13</td>\n" +
				"<td>3</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>14</td>\n" +
				"<td>5</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>15</td>\n" +
				"<td>7</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>16</td>\n" +
				"<td>10</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>17</td>\n" +
				"<td>13</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>18</td>\n" +
				"<td>17</td>\n" +
				"</tr>\n" +
				"</tbody>\n" +
				"</table>\n" +
				"<caption style=\"text-align:left;font-weight:bold;padding:10px 0px\">Table: Ability Score Points</caption>\n" +
				"<thead>\n" +
				"<tr style=\"background-color:rgb(207,226,243)\">\n" +
				"<th style=\"text-align:center\">Campaign Type</th>\n" +
				"<th style=\"text-align:center\">Points</th>\n" +
				"</tr>\n" +
				"</thead>\n" +
				"<tbody>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>Low Fantasy</td>\n" +
				"<td>10</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>Standard Fantasy</td>\n" +
				"<td>15</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>High Fantasy</td>\n" +
				"<td>20</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>Epic Fantasy</td>\n" +
				"<td>25</td>\n" +
				"</tr>\n" +
				"</tbody>\n" +
				"</table>");
		sections.add("<br>" + "<b>Determine Bonuses (or Penalties)</b>");
		sections.add("<br>" + "Each ability, after changes made because of race, has a modifier ranging from –5 to +5. Table: Ability Modifiers and Bonus Spells shows the modifier for each score. The modifier is the number you apply to the die roll when your character tries to do something related to that ability. You also use the modifier with some numbers that aren't die rolls. A positive modifier is called a bonus, and a negative modifier is called a penalty. The table also shows bonus spells, which you'll need to know about if your character is a spellcaster.");
		sections.add("<br>" + "<br>" + "<b>Abilities and Spellcasters</b>");
		sections.add("<br>" + "The ability that governs bonus spells depends on what type of spellcaster your character is: Intelligence for wizards; Wisdom for clerics, druids, and rangers; and Charisma for bards, paladins, and sorcerers. In addition to having a high ability score, a spellcaster must be of a high enough class level to be able to cast spells of a given spell level. See individual class descriptions for additional details.");
		sections.add("<br>" + "<br>" + "<table border=\"1\" bordercolor=\"#35888888\" cellpadding=\"5\" style=\"border-color:rgb(136,136,136);border-width:1px;border-collapse:collapse\">\n" +
				"<caption style=\"text-align:left;font-weight:bold;padding:10px 0px\">Table: Ability Modifiers and Bonus Spells</caption>\n" +
				"<thead>\n" +
				"<tr style=\"background-color:rgb(207,226,243)\">\n" +
				"<th rowspan=\"2\" style=\"text-align:center\">Ability Score</th>\n" +
				"<th colspan=\"11\" style=\"text-align:center\">Bonus Spells per Day (by Spell Level)</th>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center;background-color:rgb(207,226,243)\">\n" +
				"<th style=\"text-align:center\">Modifier</th>\n" +
				"<th style=\"text-align:center\">0th</th>\n" +
				"<th style=\"text-align:center\">1st</th>\n" +
				"<th style=\"text-align:center\">2nd</th>\n" +
				"<th style=\"text-align:center\">3rd</th>\n" +
				"<th style=\"text-align:center\">4th</th>\n" +
				"<th style=\"text-align:center\">5th</th>\n" +
				"<th style=\"text-align:center\">6th</th>\n" +
				"<th style=\"text-align:center\">7th</th>\n" +
				"<th style=\"text-align:center\">8th</th>\n" +
				"<th style=\"text-align:center\">9th</th>\n" +
				"</tr>\n" +
				"</thead>\n" +
				"<tbody>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>1</td>\n" +
				"<td>–5</td>\n" +
				"<td colspan=\"10\" style=\"text-align:center\">Can't cast spells tied to this ability</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>2–3</td>\n" +
				"<td>–4</td>\n" +
				"<td colspan=\"10\">Can't cast spells tied to this ability</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>4–5</td>\n" +
				"<td>–3</td>\n" +
				"<td colspan=\"10\" style=\"text-align:center\">Can't cast spells tied to this ability</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>6–7</td>\n" +
				"<td>–2</td>\n" +
				"<td colspan=\"10\">Can't cast spells tied to this ability</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>8–9</td>\n" +
				"<td>–1</td>\n" +
				"<td colspan=\"10\" style=\"text-align:center\">Can't cast spells tied to this ability</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>10–11</td>\n" +
				"<td>0</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>12–13</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>14–15</td>\n" +
				"<td>2</td>\n" +
				"<td>—</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>16–17</td>\n" +
				"<td>3</td>\n" +
				"<td>—</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>18–19</td>\n" +
				"<td>4</td>\n" +
				"<td>—</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>20–21</td>\n" +
				"<td>5</td>\n" +
				"<td>—</td>\n" +
				"<td>2</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>22–23</td>\n" +
				"<td>6</td>\n" +
				"<td>—</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>24–25</td>\n" +
				"<td>7</td>\n" +
				"<td>—</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>26–27</td>\n" +
				"<td>8</td>\n" +
				"<td>—</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>—</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>28–29</td>\n" +
				"<td>9</td>\n" +
				"<td>—</td>\n" +
				"<td>3</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>30–31</td>\n" +
				"<td>10</td>\n" +
				"<td>—</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>32–33</td>\n" +
				"<td>11</td>\n" +
				"<td>—</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>1</td>\n" +
				"<td>1</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>34–35</td>\n" +
				"<td>12</td>\n" +
				"<td>—</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>1</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>36–37</td>\n" +
				"<td>13</td>\n" +
				"<td>—</td>\n" +
				"<td>4</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>38–39</td>\n" +
				"<td>14</td>\n" +
				"<td>—</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>40–41</td>\n" +
				"<td>15</td>\n" +
				"<td>—</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>2</td>\n" +
				"<td>2</td>\n" +
				"</tr>\n" +
				"<tr style=\"background-color:rgb(243,243,243);text-align:center\">\n" +
				"<td>42–43</td>\n" +
				"<td>16</td>\n" +
				"<td>—</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>2</td>\n" +
				"</tr>\n" +
				"<tr style=\"text-align:center\">\n" +
				"<td>44–45</td>\n" +
				"<td>17</td>\n" +
				"<td>—</td>\n" +
				"<td>5</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>4</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"<td>3</td>\n" +
				"</tr>\n" +
				"</tbody>\n" +
				"</table>");
		sections.add("<h2 style=\"font-size:22px;margin-top:35px\"><a name=\"TOC-The-Abilities\"></a>The Abilities</h2>\n" +
				"<p>Each ability partially describes your character and affects some of his actions.</p>\n" +
				"<h3><a name=\"TOC-Strength-Str-\"></a>Strength (Str)</h3>\n" +
				"<p>See <a href=\"http://www.d20pfsrd.com/alignment-description/carrying-capacity\">Carrying Capacity</a> for details on lifting and dragging.</p>\n" +
				"<p>Strength measures muscle and physical power. This ability is important for those who engage in hand-to-hand (or “melee”) combat, such as <a href=\"http://www.d20pfsrd.com/classes/core-classes/fighter\">fighters</a>, <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk\">monks</a>, <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin\">paladins</a>, and some <a href=\"http://www.d20pfsrd.com/classes/core-classes/ranger\">rangers</a>. Strength also sets the maximum amount of weight your character can carry.</p>\n" +
				"<p>A character with a Strength score of 0 is too weak to move in any way and is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Unconscious\">unconscious</a>. Some creatures (such as <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creatures) do not possess a Strength score and have no modifier at all to Strength-based skills or checks.</p>\n" +
				"<p>You apply your character's Strength modifier to:</p>\n" +
				"<ul>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Standard-Actions\">Melee attack</a> rolls.</li>\n" +
				"<li>Damage rolls when using a melee weapon or a thrown weapon, including a <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/sling\">sling</a>. (<b>Exceptions</b>: Off-hand attacks receive only half the character's Strength bonus, while two-handed attacks receive 1–1/2 times the Strength bonus. A Strength penalty, but not a bonus, applies to attacks made with a bow that is not a composite bow.)</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/skills/climb\">Climb</a> and <a href=\"http://www.d20pfsrd.com/skills/swim\">Swim</a> checks.</li>\n" +
				"<li>Strength checks (for <a href=\"http://www.d20pfsrd.com/equipment---final/damaging-objects#TOC-Damaged-Objects\">breaking down doors</a> and the like).</li>\n" +
				"</ul>\n" +
				"<p>Your Strength score determines your characters <a href=\"http://www.d20pfsrd.com/gamemastering/exploration-movement#TOC-Carrying-Capacity\">carrying capacity</a>.</p>\n" +
				"<div style=\"margin-left:40px\">\n" +
				"<p><b>Temporary Bonuses</b>: Temporary increases to your Strength score give you a bonus on Strength-based skill checks, melee <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attack-Roll\">attack rolls</a>, and weapon damage rolls (if they rely on Strength). The bonus also applies to your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Bonus\">Combat Maneuver Bonus</a> (if you are Small or larger) and to your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">Combat Maneuver Defense</a>.</p>\n" +
				"<p><b>Permanent Bonuses</b>: Ability bonuses with a duration greater than 1 day actually increase the relevant ability score after 24 hours. Modify all skills and statistics as appropriate. This might cause you to gain skill points, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>, and other bonuses. These bonuses should be noted separately in case they are removed.</p>\n" +
				"<p><b>Ability Damage</b>: Damage to your Strength score causes you to take penalties on Strength-based skill checks, melee <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attack-Roll\">attack rolls</a>, and weapon damage rolls (if they rely on Strength). The Ability Damage penalty also applies to your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Bonus\">Combat Maneuver Bonus</a> (if you are Small or larger) and your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">Combat Maneuver Defense</a>. See Ability Score Damage below.</p>\n" +
				"</div>\n" +
				"<a name=\"TOC-Table:-Carrying-Capacity\"></a>\n" +
				"<h3><a name=\"TOC-Dexterity-Dex-\"></a>Dexterity (Dex)</h3>\n" +
				"<p>Dexterity measures agility, reflexes, and balance. This ability is the most important one for <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue\">rogues</a>, but it's also useful for characters who wear light or medium armor or no armor at all. This ability is vital for characters seeking to excel with ranged weapons, such as the bow or <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/sling\">sling</a>. A character with a Dexterity score of 0 is incapable of moving and is effectively immobile (but not <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Unconscious\">unconscious</a>).</p>\n" +
				"<p>You apply your character's Dexterity modifier to:</p>\n" +
				"<ul>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/gamemastering/combat#ranged-attacks\">Ranged attack</a> rolls, including those for attacks made with bows, crossbows, throwing axes, and many ranged spell attacks like <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/scorching-ray\" style=\"font-style:italic\">scorching ray</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/searing-light\" style=\"font-style:italic\">searing light</a>.</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Armor-Class\">Armor Class</a> (<a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Armor-Class\">AC</a>), provided that the character can react to the attack.</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reflex\">Reflex saving throws</a>, for avoiding <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fireball\" style=\"font-style:italic\">fireballs</a> and other attacks that you can escape by moving quickly.</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/skills/acrobatics\">Acrobatics</a>, <a href=\"http://www.d20pfsrd.com/skills/disable-device\">Disable Device</a>, <a href=\"http://www.d20pfsrd.com/skills/escape-artist\">Escape Artist</a>, <a href=\"http://www.d20pfsrd.com/skills/fly\">Fly</a>, <a href=\"http://www.d20pfsrd.com/skills/ride\">Ride</a>, <a href=\"http://www.d20pfsrd.com/skills/sleight-of-hand\">Sleight of Hand</a>, and <a href=\"http://www.d20pfsrd.com/skills/stealth\">Stealth</a> checks.</li>\n" +
				"</ul>\n" +
				"<div style=\"margin-left:40px\">\n" +
				"<p><b>Temporary Bonuses</b>: Temporary increases to your Dexterity score give you a bonus on Dexterity-based skill checks,  <a href=\"http://www.d20pfsrd.com/gamemastering/combat#ranged-attacks\">Ranged attack</a> rolls, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Initiative\">initiative</a> checks, and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reflex\">Reflex</a> saving throws. The bonus also applies to your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Armor-Class\">Armor Class</a>, your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Bonus\">Combat Maneuver Bonus</a> (if you are Tiny or smaller), and your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">Combat Maneuver Defense</a>.</p>\n" +
				"<p><b>Permanent Bonuses</b>: Ability bonuses with a duration greater than 1 day actually increase the relevant ability score after 24 hours. Modify all skills and statistics as appropriate. This might cause you to gain skill points, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>, and other bonuses. These bonuses should be noted separately in case they are removed.</p>\n" +
				"<p><b>Ability Damage</b>: Damage to your Dexterity score causes you to take penalties on Dexterity-based skill checks, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#ranged-attacks\">ranged attack</a> rolls, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Initiative\">initiative</a> checks, and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reflex\">Reflex</a> saving throws. The Ability Damage penalty also applies to your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Armor-Class\">Armor Class</a>, your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Bonus\">Combat Maneuver Bonus</a> (if you are Tiny or smaller), and to your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">Combat Maneuver Defense</a>.  See Ability Score Damage below.</p>\n" +
				"</div>\n" +
				"<h3><a name=\"TOC-Constitution-Con-\"></a>Constitution (Con)</h3>\n" +
				"<p>Constitution represents your character's health and stamina. A Constitution bonus increases a character's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>, so the ability is important for all classes. Some creatures, such as <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Construct\">constructs</a>, do not have a Constitution score. Their modifier is +0 for any Constitution-based checks. A character with a Constitution score of 0 is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Dead\">dead</a>.</p>\n" +
				"<p>You apply your character's Constitution modifier to:</p>\n" +
				"<ul>\n" +
				"<li>Each roll of a <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-dice\">Hit Die</a> (though a penalty can never drop a result below 1—that is, a character always gains at least 1 hit point each time he advances in level).</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude saving throws</a>, for resisting <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/poison\">poison</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/diseases\">disease</a>, and similar threats.</li>\n" +
				"</ul>\n" +
				"<p>If a character's Constitution score changes enough to alter his or her Constitution modifier, the character's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a> also increase or decrease accordingly.</p>\n" +
				"<div style=\"margin-left:40px\">\n" +
				"<p><b>Temporary Bonuses</b>: Temporary increases to your Constitution score give you a bonus on your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> saving throws. In addition, multiply your total <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Hit-Dice-HD-\">Hit Dice</a> by this bonus and add that amount to your current and total <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>. When the bonus ends, remove this total from your current and total <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>.</p>\n" +
				"<p><b>Permanent Bonuses</b>: Ability bonuses with a duration greater than 1 day actually increase the relevant ability score after 24 hours. Modify all skills and statistics as appropriate. This might cause you to gain skill points, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>, and other bonuses. These bonuses should be noted separately in case they are removed.</p>\n" +
				"<p><b>Ability Damage</b>: Damage to your Constitution score causes you to take penalties on your <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> saving throws. In addition, multiply your total <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Hit-Dice-HD-\">Hit Dice</a> by the Ability Damage penalty and subtract that amount from your current and total <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>. Lost <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a> are restored when the damage to your Constitution is healed.  See Ability Score Damage below.</p>\n" +
				"</div>\n" +
				"<h4><a name=\"TOC-Notes:\"></a>Notes:</h4>\n" +
				"<ul>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Construct\">Constructs</a> do not have a Constitution score. Any DCs or other Statistics that rely on a Constitution score treat a <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Construct\">construct</a> as having a score of 10 (no bonus or penalty).</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">Undead</a> creatures do not have a Constitution score. <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">Undead</a> use their <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Charisma-Cha-\">Charisma</a> score in place of their Constitution score when calculating <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> saves, and any special ability that relies on Constitution(such as when calculating a <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Breath-Weapon-Su-\">breath weapon’s</a> DC).</li>\n" +
				"</ul>\n" +
				"<h3><a name=\"TOC-Intelligence-Int-\"></a>Intelligence (Int)</h3>\n" +
				"<p>Intelligence determines how well your character learns and reasons. This ability is important for <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard\">wizards</a> because it affects their spellcasting ability in many ways. Creatures of <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a>-level instinct have Intelligence scores of 1 or 2. Any creature capable of understanding speech has a score of at least 3. A character with an Intelligence score of 0 is comatose. Some creatures do not possess an Intelligence score. Their modifier is +0 for any Intelligence-based skills or checks.</p>\n" +
				"<p>You apply your character's Intelligence modifier to:</p>\n" +
				"<ul>\n" +
				"<li>The number of bonus <a href=\"http://www.d20pfsrd.com/skills/linguistics\">languages</a> your character knows at the start of the game. These are in addition to any starting racial languages and Common. If you have a penalty, you can still read and speak your racial languages unless your Intelligence is lower than 3.</li>\n" +
				"<li>The number of skill points gained each level, though your character always gets at least 1 skill point per level.</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/skills/appraise\">Appraise</a>, <a href=\"http://www.d20pfsrd.com/skills/craft\">Craft</a>, <a href=\"http://www.d20pfsrd.com/skills/knowledge\">Knowledge</a>, <a href=\"http://www.d20pfsrd.com/skills/linguistics\">Linguistics</a>, and <a href=\"http://www.d20pfsrd.com/skills/spellcraft\">Spellcraft</a> checks.</li>\n" +
				"</ul>\n" +
				"<p>A <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard\">wizard</a> gains bonus spells based on his Intelligence score. The minimum Intelligence score needed to cast a <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard\">wizard</a> spell is 10 + the spell's level.</p>\n" +
				"<div style=\"margin-left:40px\">\n" +
				"<p><b>Temporary Bonuses</b>: Temporary increases to your Intelligence score give you a bonus on Intelligence-based skill checks. This bonus also applies to any spell DCs based on Intelligence.</p>\n" +
				"<p><b>Permanent Bonuses</b>: Ability bonuses with a duration greater than 1 day actually increase the relevant ability score after 24 hours. Modify all skills and statistics as appropriate. This might cause you to gain skill points, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>, and other bonuses. These bonuses should be noted separately in case they are removed.</p>\n" +
				"<p><b>Ability Damage</b>: Damage to your Intelligence score causes you to take penalties on Intelligence-based skill checks. The Ability Damage penalty also applies to any spell DCs based on Intelligence.  See Ability Score Damage below.</p>\n" +
				"</div>\n" +
				"<h4><a name=\"TOC-Notes:1\"></a>Notes:</h4>\n" +
				"<ul>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">Animals</a> have Intelligence scores of 1 or 2 (no creature with an Intelligence score of 3 or higher can be an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a>).</li>\n" +
				"<li>Oozes do not have an Intelligence score, and as such they have <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Immunity-Ex-or-Su-\">immunity</a> to all <a href=\"http://www.d20pfsrd.com/magic#TOC-Magic-Descriptor-Mind-Affecting\">mind-affecting</a> effects (charms, compulsions, phantasms, patterns, and morale effects). An <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Ooze\">ooze</a> with an Intelligence score loses this trait.</li>\n" +
				"<li>Regular plants, such as one finds growing in gardens and fields, lack Intelligence, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Wisdom-Wis-\">Wisdom</a>, and <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Charisma-Cha-\">Charisma</a> scores; even though plants are alive, they are objects, not creatures.</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Vermin\">Vermin</a> do not have an Intelligence score, and as such they have <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Immunity-Ex-or-Su-\">immunity</a> to all <a href=\"http://www.d20pfsrd.com/magic#TOC-Magic-Descriptor-Mind-Affecting\">mind-affecting</a> effects (charms, compulsions, morale effects, patterns, and phantasms). Mindless creatures have no feats or skills. A <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Vermin\">vermin</a>-like creature with an Intelligence score is usually either an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> or a <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Magical-Beast\">magical beast</a>, depending on its other abilities.</li>\n" +
				"</ul>\n" +
				"<h3><a name=\"TOC-Wisdom-Wis-\"></a>Wisdom (Wis)</h3>\n" +
				"<p>Wisdom describes a character's willpower, common sense, awareness, and intuition. Wisdom is the most important ability for <a href=\"http://www.d20pfsrd.com/classes/core-classes/cleric\">clerics</a> and <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid\">druids</a>, and it is also important for <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk\">monks</a> and <a href=\"http://www.d20pfsrd.com/classes/core-classes/ranger\">rangers</a>. If you want your character to have acute senses, put a high score in Wisdom. Every creature has a Wisdom score. A character with a Wisdom score of 0 is incapable of rational thought and is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Unconscious\">unconscious</a>.</p>\n" +
				"<p>You apply your character's Wisdom modifier to:</p>\n" +
				"<ul>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Will\">Will saving throws</a> (for negating the effects of <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/charm-person\" style=\"font-style:italic\">charm person</a> and other spells).</li>\n" +
				"<li><a href=\"http://www.d20pfsrd.com/skills/heal\">Heal</a>, <a href=\"http://www.d20pfsrd.com/skills/perception\">Perception</a>, <a href=\"http://www.d20pfsrd.com/skills/profession\">Profession</a>, <a href=\"http://www.d20pfsrd.com/skills/sense-motive\">Sense Motive</a>, and <a href=\"http://www.d20pfsrd.com/skills/survival\">Survival</a> checks.</li>\n" +
				"</ul>\n" +
				"<p><a href=\"http://www.d20pfsrd.com/classes/core-classes/cleric\">Clerics</a>, <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid\">druids</a>, and <a href=\"http://www.d20pfsrd.com/classes/core-classes/ranger\">rangers</a> get bonus spells based on their Wisdom scores. The minimum Wisdom score needed to cast a <a href=\"http://www.d20pfsrd.com/classes/core-classes/cleric\">cleric</a>, <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid\">druid</a>, or <a href=\"http://www.d20pfsrd.com/classes/core-classes/ranger\">ranger</a> spell is 10 + the spell's level.</p>\n" +
				"<div style=\"margin-left:40px\">\n" +
				"<p><b>Temporary Bonuses</b>: Temporary increases to your Wisdom score give you a bonus on Wisdom-based skill checks and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Will\">Will</a> saving throws. This bonus also applies to any spell DCs based on Wisdom.</p>\n" +
				"<p><b>Permanent Bonuses</b>: Ability bonuses with a duration greater than 1 day actually increase the relevant ability score after 24 hours. Modify all skills and statistics as appropriate. This might cause you to gain skill points, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#hit-points\">hit points</a>, and other bonuses. These bonuses should be noted separately in case they are removed.</p>\n" +
				"<p><b>Ability Damage</b>: Damage to your Wisdom score causes you to take penalties on Wisdom-based skill checks and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Will\">Will</a> saving throws. The Ability Damage penalty also applies to any spell DCs based on Wisdom.  See Ability Score Damage below.</p>\n" +
				"</div>\n" +
				"<h4><a name=\"TOC-Notes:2\"></a>Notes:</h4>\n" +
				"<ul>\n" +
				"<li>Regular plants, such as one finds growing in gardens and fields, lack <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Intelligence-Int-\">Intelligence</a>, Wisdom, and <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Charisma-Cha-\">Charisma</a> scores; even though plants are alive, they are objects, not creatures.</li>\n" +
				"</ul>\n" +
				"</div>\n" +
				"</div>\n" +
				"</div>");
		/*
		sections.add("<br>" + "<br>" + "<b>The Abilities</b>");
		sections.add("<br>" + "Each ability partially describes your character and affects some of his actions.");
		sections.add("<br>" + "<br>" + "<b>Strength (Str)</b>");
		sections.add("<br>" + "See Carrying Capacity for details on lifting and dragging.");
		sections.add("<br>" + "Strength measures muscle and physical power. This ability is important for those who engage in hand-to-hand (or “melee”) combat, such as fighters, monks, paladins, and some rangers. Strength also sets the maximum amount of weight your character can carry.");
		sections.add("<br>" + "A character with a Strength score of 0 is too weak to move in any way and is unconscious. Some creatures (such as incorporeal creatures) do not possess a Strength score and have no modifier at all to Strength-based skills or checks.");
		sections.add("<br>" + "<br>" + "You apply your character's Strength modifier to:");
		sections.add("<br>" + "Melee attack rolls.");
		sections.add("<br>" + "Damage rolls when using a melee weapon or a thrown weapon, including a sling. (Exceptions: Off-hand attacks receive only half the character's Strength bonus, while two-handed attacks receive 1–1/2 times the Strength bonus. A Strength penalty, but not a bonus, applies to attacks made with a bow that is not a composite bow.)");
		sections.add("<br>" + "Climb and Swim checks.");
		sections.add("<br>" + "Strength checks (for breaking down doors and the like).");
		sections.add("<br>" + "Your Strength score determines your characters carrying capacity.");
		sections.add("<br>" + "<br>" + "Dexterity (Dex)");*/

		String toReturn = "<html>";
		for(int i = 0; i < sections.size(); i++){
			toReturn += sections.get(i);
		}
		return toReturn + "</html>";
	}

	public static String getFavoredClassInfoString(){
		return "<head>\n" +
				"<style>\n" +
				"a {color: black; text-decoration: none;}\n" +
				"</style>\n" +
				"</head>" +
				"<h2 style=\"font-size:20px\"><a name=\"TOC-Favored-Class\"></a>Favored Class</h2>\n" +
				"\n" +
				"<p>Each character begins play with a single favored class of his choosing—typically, this is the same class as the one he chooses at 1st level. Whenever a character gains a level in his favored class, he receives either + 1 hit point or + 1 skill rank. The choice of favored class cannot be changed once the character is created, and the choice of gaining a hit point or a skill rank each time a character gains a level (including his first level) cannot be changed once made for a particular level. Prestige classes (see <a href=\"http://www.d20pfsrd.com/classes/prestige-classes\">Prestige Classes</a>) can never be a favored class.</p>\n" +
				"\n" +
				"<a name=\"TOC-Racial-Favored-Class-Benefits\"></a>\n" +
				"\n" +
				"<h4><a name=\"TOC-Racial-Favored-Class-Benefits-Advanced-Player-s-Guide-\"></a>Racial Favored Class Benefits</h4>\n" +
				"\n" +
				"<div>\n" +
				"<p style=\"font-size:12px\"><b>Source</b>: <a href=\"http://www.amazon.com/gp/product/1601252463/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&amp;camp=1789&amp;creative=9325&amp;creativeASIN=1601252463&amp;linkCode=as2&amp;tag=httpwwwd20pfs-20\" target=\"_blank\">APG</a></p>\n" +
				"<p>The normal benefit of having a favored class is simple and effective: your character gains one extra hit point or one extra skill rank each time she gains a level in that class (or in either of two classes, if she is a <a href=\"http://www.d20pfsrd.com/races/core-races/half-elf\">half-elf</a>*). The alternate favored class abilities listed here may not have as broad an appeal as the standard choices. They are designed to reflect flavorful options that might be less useful in general but prove handy in the right situations or for a character with the right focus. Most of them play off racial archetypes, like a <a href=\"http://www.d20pfsrd.com/races/core-races/half-orc\">half-orc</a>’s <a href=\"http://www.d20pfsrd.com/feats/general-feats/toughness---final\">toughness</a> and proclivity for breaking things or elven grace and finesse.</p>\n" +
				"<p>In most cases, these benefits are gained on a level-by level basis—your character gains the specified incremental benefit each time she gains a level. Unless otherwise noted, these benefits always stack with themselves. For example, a <a href=\"http://www.d20pfsrd.com/races/core-races/human\">human</a> with <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin\">paladin</a> as a favored class may choose to gain 1 point of <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Resistance\">energy resistance</a> each time she gains a level; choosing this benefit twice increases this <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Resistance-Bonus\">resistance bonus</a> to 2 per level, 10 times raises it to 10 per level, and so on.</p>\n" +
				"<p>In some cases this benefit may eventually hit a fixed numerical limit, after which selecting that favored class benefit has no effect. Of course, you can still select the bonus hit point or skill rank as your favored class benefit, so there is always a reward for sticking with a favored class.</p>\n" +
				"<p>Finally, some of these alternate favored class benefits only add +1/2, +1/3, +1/4, or +1/6 to a roll (rather than +1) each time the benefit is selected; when applying this result to the die roll, round down (minimum 0). For example, a <a href=\"http://www.d20pfsrd.com/races/core-races/dwarf\">dwarf</a> with <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue\">Rogue</a> as his favored class adds +1/2 to his <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Trap-Sense-Ex-\">trap sense</a> ability regarding stone traps each time he selects the alternate <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue\">Rogue</a> favored class benefit; though this means the net effect is +0 after selecting it once (because +1/2 rounds down to +0), after 20 levels this benefit gives the <a href=\"http://www.d20pfsrd.com/races/core-races/dwarf\">dwarf</a> a +10 bonus to his <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Trap-Sense-Ex-\">trap sense</a> (in addition to the base value from being a 20th-level <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue\">Rogue</a>).</p>\n" +
				"<p>Each race page includes a set of alternative benefits that characters of that race may choose instead of the normal benefits for their favored class. Thus, rather than taking an extra hit point or an extra skill rank, players may choose for their characters to gain the benefit listed here. This is not a permanent or irrevocable choice; just as characters could alternate between taking skill ranks and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a> when they gain levels in their favored class, these benefits provide a third option, and characters may freely alternate between them.</p>\n" +
				"<p>As with any alternate or optional rule, consult with your <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Game-Master-GM-\">GM</a> to determine whether exchanging normal favored class benefits for those in this chapter will be allowed.</p>\n" +
				"</div>";
	}

	public static GenericRace chooseGenericRace(){
		JDialog genRaceChooser = new JDialog(FRAME, "Generic Race");
		JPanel genRacePanel = new JPanel(new GridBagLayout());
		genRaceChooser.add(genRacePanel);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		genRacePanel.add(new JLabel("Race name: "), c);

		JTextField nameField = new JTextField();
		c.gridx = 1;
		c.weightx = 1;
		genRacePanel.add(nameField, c);

		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 2;
		genRacePanel.add(new JSeparator(SwingConstants.HORIZONTAL));

		c.gridy = 2;
		c.gridwidth = 1;
		c.weightx = 0;
		genRacePanel.add(new JLabel("Strength Mod: "), c);
		c.gridy++;
		genRacePanel.add(new JLabel("Dexterity Mod: "), c);
		c.gridy++;
		genRacePanel.add(new JLabel("Constitution Mod: "), c);
		c.gridy++;
		genRacePanel.add(new JLabel("Charisma Mod: "), c);
		c.gridy++;
		genRacePanel.add(new JLabel("Intelligence Mod: "), c);
		c.gridy++;
		genRacePanel.add(new JLabel("Wisdom Mod: "), c);

		JTextField strMod = new JTextField("0");
		JTextField dexMod = new JTextField("0");
		JTextField conMod = new JTextField("0");
		JTextField chaMod = new JTextField("0");
		JTextField intMod = new JTextField("0");
		JTextField wisMod = new JTextField("0");

		c.gridy = 2;
		c.gridx = 1;
		c.weightx = 1;
		genRacePanel.add(strMod, c);
		c.gridy++;
		genRacePanel.add(dexMod, c);
		c.gridy++;
		genRacePanel.add(conMod, c);
		c.gridy++;
		genRacePanel.add(chaMod, c);
		c.gridy++;
		genRacePanel.add(intMod, c);
		c.gridy++;
		genRacePanel.add(wisMod, c);

		c.gridy++;
		c.gridx = 0;
		c.gridwidth = 2;
		genRacePanel.add(new JSeparator(SwingConstants.HORIZONTAL));

		AtomicBoolean confirmed = new AtomicBoolean(false);
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(e ->{
			try{
				Integer.parseInt(strMod.getText());
				Integer.parseInt(dexMod.getText());
				Integer.parseInt(conMod.getText());
				Integer.parseInt(chaMod.getText());
				Integer.parseInt(intMod.getText());
				Integer.parseInt(wisMod.getText());
				confirmed.set(true);
			}catch(NumberFormatException ex){
				showError("Number Format Exception", "Each ability modifier must have an integer modifier.");
			}
		});
		c.gridy++;
		genRacePanel.add(confirm, c);

		genRaceChooser.setSize(200,200);
		genRaceChooser.setLocationRelativeTo(FRAME);
		genRaceChooser.setVisible(true);

		AtomicBoolean closed = new AtomicBoolean(false);
		genRaceChooser.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				FRAME.setEnabled(true);
				closed.set(true);
			}
		});

		FRAME.setEnabled(false);

		while(!confirmed.get()){
			if(closed.get()) return null;
		}

		HashMap<AbilityScoreEnum, Integer> abilityMods = new HashMap<>();

		if(Integer.parseInt(strMod.getText()) != 0){
			abilityMods.put(AbilityScoreEnum.STR, Integer.parseInt(strMod.getText()));
		}
		if(Integer.parseInt(dexMod.getText()) != 0){
			abilityMods.put(AbilityScoreEnum.DEX, Integer.parseInt(dexMod.getText()));
		}
		if(Integer.parseInt(conMod.getText()) != 0){
			abilityMods.put(AbilityScoreEnum.CON, Integer.parseInt(conMod.getText()));
		}
		if(Integer.parseInt(chaMod.getText()) != 0){
			abilityMods.put(AbilityScoreEnum.CHA, Integer.parseInt(chaMod.getText()));
		}
		if(Integer.parseInt(intMod.getText()) != 0){
			abilityMods.put(AbilityScoreEnum.INT, Integer.parseInt(intMod.getText()));
		}
		if(Integer.parseInt(wisMod.getText()) != 0){
			abilityMods.put(AbilityScoreEnum.WIS, Integer.parseInt(wisMod.getText()));
		}

		FRAME.setEnabled(true);
		genRaceChooser.dispose();

		return new GenericRace(nameField.getText(), abilityMods);
	}

	public static void showCharacter(Character me){
		CharacterDisplay display = new CharacterDisplay(me);
		PANEL.add(display, CHARACTER_DISPLAY);
		CARD_LAYOUT.show(PANEL, CHARACTER_DISPLAY);
		FRAME.setSize(600,500);
		FRAME.setLocationRelativeTo(null);
	}

	//General utility.
	
	public static boolean askYesNo(String question){
		return JOptionPane.showConfirmDialog(null, question, "Message!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
	
	public static void popupDialog(String title, String message){
		JDialog messageDialog = new JDialog(FRAME, title);
		JPanel panel = new JPanel(new BorderLayout());
		messageDialog.add(panel);

		JTextPane text = new JTextPane();
		text.setText(message);
		text.setEditable(false);
		text.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
		JButton done = new JButton("OK");
		done.addActionListener(e -> messageDialog.dispose());

		panel.add(text, BorderLayout.CENTER);
		panel.add(done, BorderLayout.SOUTH);


		messageDialog.pack();
		int minimumTitleSize = 100 + messageDialog.getGraphics().getFontMetrics(messageDialog.getGraphics().getFont()).charsWidth(title.toCharArray(), 0, title.length());
		if(messageDialog.getSize().getWidth() < minimumTitleSize) messageDialog.setSize(new Dimension(minimumTitleSize, messageDialog.getSize().height));
		messageDialog.setLocationRelativeTo(FRAME);
		messageDialog.setVisible(true);
	}
	
	public static void showError(String title, String message){
		(new Thread() {
			public void run() {
				JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
			}
		}).start();
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

	public static String getImageOverrideLocation(){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Supported Image Types", "jpg", "gif", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(FRAME);

		if(returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().toString();
		}

		return "";
	}

	public static void showNoteDetails(String title, Map<String, String> dataSet){
		JDialog detailsFrame = new JDialog(FRAME, title);
		detailsFrame.setSize(450,550);
		detailsFrame.setLocationRelativeTo(FRAME);
		JPanel detailsPanel = new JPanel(new BorderLayout());

		JEditorPane text = new JEditorPane("text/html", "<html>" + dataSet.get(title) + "</html>");
		text.setEditable(false);
		text.setCaretPosition(0);

		JScrollPane scrollingText = new JScrollPane(text);
		scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JButton toggleEdit = new JButton("Edit");
		toggleEdit.addActionListener(e ->{
			text.setEditable(!text.isEditable());
			if(text.isEditable()){
				String current = text.getText();
				text.setContentType("text/plain");
				text.setText(current);
				toggleEdit.setText("Save");
			} else {
				String current = text.getText();
				text.setContentType("text/html");
				text.setText(current);
				dataSet.put(title, text.getText());
				toggleEdit.setText("Edit");
			}
			detailsFrame.repaint();
		});

		detailsFrame.add(detailsPanel);
		detailsPanel.add(scrollingText, BorderLayout.CENTER);
		detailsPanel.add(toggleEdit, BorderLayout.SOUTH);
		detailsFrame.setVisible(true);
	}

	public static void saveCharacter(Character me){
		JFileChooser chooser = new JFileChooser(me.lastSavedLocation);
		if(JFileChooser.APPROVE_OPTION != chooser.showSaveDialog(FRAME)) return;

		try{
			FileOutputStream fileOut = new FileOutputStream(chooser.getSelectedFile());
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(me);
			objOut.close();
			fileOut.close();
			me.lastSavedLocation = chooser.getSelectedFile();
		} catch(FileNotFoundException e) {
			showError("Unable to save", "I couldn't save to the specified location. You may not have permission to save here.");
		} catch (IOException e){
			showError("Error saving", "I couldn't finish saving. I'm unsure why.\nRun this in cmd for more details.");
			e.printStackTrace();
		}
	}
}