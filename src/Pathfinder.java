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
import src.items.ItemUtil;
import src.races.RaceEnum;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pathfinder{
	private static final String START_PANEL = "startPanel";
	private static final String RACE_CHOOSER = "raceChooser";
	private static final String CHARACTER_DISPLAY = "characterDisplay";
	private static final String ABILITY_POINT_FRAME = "abilityPointFrame";
	private static final String FINALIZE_PANEL = "finalizePanel";
	private static final CardLayout CARD_LAYOUT = new CardLayout();
	private static final JPanel PANEL = new JPanel(CARD_LAYOUT);

	public static final JFrame FRAME = new JFrame("Pathfinder Character Sheet");

	public static void main(String[] args){
		FRAME.setSize(500,200);
		FRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		FRAME.add(PANEL);

		JPanel startPanel = new JPanel(new GridBagLayout());
		PANEL.add(startPanel, START_PANEL);
		JButton newCharacter = new JButton("<html> New Character <br><center>(guided)</center></html>");
		JButton loadCharacter = new JButton("Load Character");
		JButton searchFeats = new JButton("Search Feats");
		JButton searchSpells = new JButton("Search Spells");
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
				SelectionUtils.searchFeats(Feats.getFeats(),FRAME);
			}
		}.start());
		searchSpells.addActionListener(e -> new Thread() {
			public void run(){
				SelectionUtils.searchSpells(Spells.getSpells(),FRAME);
			}
		}.start());
		itemSearch.addActionListener(e -> new Thread() {
			public void run(){
				SelectionUtils.searchItems(ItemUtil.getItems(),FRAME);
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

		int numberOfRaces = RaceEnum.values().length;
		int width = 1;
		int height = 1;

		if(numberOfRaces < 4){
			width = numberOfRaces;
		} else{
			for(int i = numberOfRaces/2; i > 0; i--){
				if(numberOfRaces%i == 0){
					width = i;
					height = numberOfRaces / i;
					break;
				}
			}
		}

		if(width == 1){
			int temp = width;
			width = height;
			height = temp;
		}

		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				RaceEnum currentRace = RaceEnum.values()[y*width + x];
				c.gridx = x;
				c.gridy = y;
				inside.add(getRaceDisplayPanel(currentRace), c);
			}
		}

		PANEL.add(characterMaker, RACE_CHOOSER);
		CARD_LAYOUT.show(PANEL, RACE_CHOOSER);

		FRAME.setSize(new Dimension(width * 255 + 20, height * 255 + 43));
		FRAME.setLocationRelativeTo(null);
	}

	private static void makeNewUnguided(){

	}
	
	private static void loadExistingCharacter() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(FRAME);
		File characterFile = null;
		if (returnVal == JFileChooser.APPROVE_OPTION)
			characterFile = chooser.getSelectedFile();
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

	public static JPanel getRaceDisplayPanel(RaceEnum currentRace){

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

	public static void chooseAbilityPoints(RaceEnum chosenRace){
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
		JScrollPane descScroll = new JScrollPane(descriptionPane);
		abilityPointPanel.add(descScroll, c);

		confirm.addActionListener(e -> finalizeCharacter(chosenRace, abilityScores));

		PANEL.add(abilityPointPanel, ABILITY_POINT_FRAME);
		CARD_LAYOUT.show(PANEL, ABILITY_POINT_FRAME);
		FRAME.setSize(770, 610);
		FRAME.setLocationRelativeTo(null);
	}

	public static void finalizeCharacter(RaceEnum chosenRace, HashMap<AbilityScoreEnum, Integer> abilityScores){
		JPanel finalizePanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		finalizePanel.add(new JLabel("Next, choose your character's name! "), c);
		c.gridx = 1;
		c.weightx = 1;
		JTextField nameField = new JTextField();
		finalizePanel.add(nameField, c);

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		finalizePanel.add(new JLabel("Next, write in your favored class(es). If there are multiple separate them by commas"), c);
		c.gridy = 2;
		JTextField classesField = new JTextField();
		finalizePanel.add(classesField, c);

		JButton finish = new JButton("Finalize your character");
		c.gridy = 3;
		finalizePanel.add(finish, c);

		JTextArea details = new JTextArea(getFavoredClassInfoString());
		details.setEditable(false);
		details.setLineWrap(true);
		details.setWrapStyleWord(true);
		c.gridy = 4;
		c.weighty = 1;
		finalizePanel.add(details, c);

		finish.addActionListener(e -> {
			Character me = new Character(nameField.getText(), chosenRace, abilityScores, classesField.getText().split(","));
			CharacterDisplay display = new CharacterDisplay(me);
			PANEL.add(display, CHARACTER_DISPLAY);
			CARD_LAYOUT.show(PANEL, CHARACTER_DISPLAY);
			FRAME.setSize(600,500);
			FRAME.setLocationRelativeTo(null);
		});

		PANEL.add(finalizePanel, FINALIZE_PANEL);
		CARD_LAYOUT.show(PANEL, FINALIZE_PANEL);
		FRAME.setSize(600, 500);
		FRAME.setLocationRelativeTo(null);
	}

	public static String getAbilityInformationString(){

		ArrayList<String> sections = new ArrayList<>();

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
		sections.add("<br>" + "<br>" + "Dexterity (Dex)");

		String toReturn = "<html>";
		for(int i = 0; i < sections.size(); i++){
			toReturn += sections.get(i);
		}
		return toReturn + "</html>";
	}

	public static String getFavoredClassInfoString(){
		return "Favored Class\n" +
				"\n" +
				"Each character begins play with a single favored class of his choosing—typically, this is the same class as the one he chooses at 1st level. Whenever a character gains a level in his favored class, he receives either + 1 hit point or + 1 skill rank. The choice of favored class cannot be changed once the character is created, and the choice of gaining a hit point or a skill rank each time a character gains a level (including his first level) cannot be changed once made for a particular level. Prestige classes (see Prestige Classes) can never be a favored class.\n" +
				"\n" +
				"Racial Favored Class Benefits\n" +
				"\n" +
				"Source: APG\n" +
				"\n" +
				"The normal benefit of having a favored class is simple and effective: your character gains one extra hit point or one extra skill rank each time she gains a level in that class (or in either of two classes, if she is a half-elf*). The alternate favored class abilities listed here may not have as broad an appeal as the standard choices. They are designed to reflect flavorful options that might be less useful in general but prove handy in the right situations or for a character with the right focus. Most of them play off racial archetypes, like a half-orc’s toughness and proclivity for breaking things or elven grace and finesse.\n" +
				"\n" +
				"In most cases, these benefits are gained on a level-by level basis—your character gains the specified incremental benefit each time she gains a level. Unless otherwise noted, these benefits always stack with themselves. For example, a human with paladin as a favored class may choose to gain 1 point of energy resistance each time she gains a level; choosing this benefit twice increases this resistance bonus to 2 per level, 10 times raises it to 10 per level, and so on.\n" +
				"\n" +
				"In some cases this benefit may eventually hit a fixed numerical limit, after which selecting that favored class benefit has no effect. Of course, you can still select the bonus hit point or skill rank as your favored class benefit, so there is always a reward for sticking with a favored class.\n" +
				"\n" +
				"Finally, some of these alternate favored class benefits only add +1/2, +1/3, +1/4, or +1/6 to a roll (rather than +1) each time the benefit is selected; when applying this result to the die roll, round down (minimum 0). For example, a dwarf with Rogue as his favored class adds +1/2 to his trap sense ability regarding stone traps each time he selects the alternate Rogue favored class benefit; though this means the net effect is +0 after selecting it once (because +1/2 rounds down to +0), after 20 levels this benefit gives the dwarf a +10 bonus to his trap sense (in addition to the base value from being a 20th-level Rogue).\n" +
				"\n" +
				"Each race page includes a set of alternative benefits that characters of that race may choose instead of the normal benefits for their favored class. Thus, rather than taking an extra hit point or an extra skill rank, players may choose for their characters to gain the benefit listed here. This is not a permanent or irrevocable choice; just as characters could alternate between taking skill ranks and hit points when they gain levels in their favored class, these benefits provide a third option, and characters may freely alternate between them.\n" +
				"\n" +
				"As with any alternate or optional rule, consult with your GM to determine whether exchanging normal favored class benefits for those in this chapter will be allowed.";
	}

	//General utility.
	
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
		JFrame noteDisplayFrame = new JFrame(title);
		JPanel noteDisplayPanel = new JPanel(new BorderLayout());
		JEditorPane text = new JEditorPane("text/html","<html>" + dataSet.get(title) + "</html>");
		JScrollPane textScroll = new JScrollPane(text);
		noteDisplayFrame.add(noteDisplayPanel);
		noteDisplayPanel.add(textScroll, BorderLayout.CENTER);
		JButton saveChanges = new JButton("Save your changes?");
		saveChanges.addActionListener(e -> dataSet.put(title, text.getText()));
		noteDisplayPanel.add(saveChanges, BorderLayout.SOUTH);

		noteDisplayFrame.setSize(400,500);
		noteDisplayFrame.setVisible(true);
	}
}