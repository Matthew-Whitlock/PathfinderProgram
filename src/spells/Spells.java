package src.spells;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import src.Pathfinder;
import src.classes.SpellCaster;

import javax.swing.*;

public class Spells implements Comparator<Spell>{
	public static String[] classTypes = new String[]{"Sorcerer","Wizard","Cleric","Druid","Ranger","Bard","Paladin","Alchemist","Summoner",
		"Witch","Inquisitor","Oracle","AntiPaladin","Magus","Adept","Bloodrager","Shaman","Psychic","Medium","Mesmerist",
		"Occultist","Spiritualist","Skald"};
	public static String[] componentTypes = new String[]{"Verbal", "Somatic", "Material", "Focus", "Divine Focus","Costly Components"};
	public static String[] spellTypeNames = new String[]{"Acid", "Air", "Chaotic", "Cold", "Curse", "Darkness", "Death", "Disease", "Earth", "Electricity",
		"Emotion", "Evil", "Fear", "Fire", "Force", "Good", "Language Dependent", "Lawful", "Light", "Mind Affecting", "Pain", "Poison",
		"Shadow", "Sonic", "Water"};
	
	private int indexOfClass;
	
	public static Spell searchByName(String spellName){
		for(Spell spell : getSpells()){
			if(spell.name.equalsIgnoreCase(spellName)){
				return spell;
			}
		}
		return null;
	}
	
	public static List<Spell> search(SpellCaster charClass, int spellLevelToGet){
		ArrayList<Spell> spells = new ArrayList<>();
		for(Spell spell : getSpells()){
			if(spell.levelRequirements[Spells.getClassIndex(charClass.overrideLevelClass == null ? charClass.name : charClass.overrideLevelClass)] == spellLevelToGet){
				boolean alreadyKnown = false;
				for(Spell knownSpell : charClass.knownSpells){
					if(spell.toString().equals(knownSpell.toString()))
						alreadyKnown = true;
				}
				if(alreadyKnown)
					continue;
				spells.add(spell);
			}
		}
		return spells;
	}
	
	public static Spell getBloodLineSpell(String bloodline, int level){
		for(Spell spell : getSpells()){
			if(spell.hasBloodline && spell.bloodlineLevels.containsKey(bloodline) && spell.bloodlineLevels.get(bloodline) == level){
				return spell;
			}
		}
		return null;
	}
	
	public static List<Spell> searchByPartialName(String name){
		ArrayList<Spell> spells = new ArrayList<>();
		name = name.toLowerCase();
		for(Spell spell : getSpells()){
			if(spell.name.toLowerCase().contains(name)){
				spells.add(spell);
			}
		}
		return spells;
	}
	
	public static List<Spell> searchByBloodline(String bloodline){
		List<Spell> spells = getSpells().stream().filter(spell -> spell.bloodlineLevels.containsKey(bloodline))
				.collect(Collectors.toCollection(ArrayList::new));

		Collections.sort(spells, new Spells(bloodline));

		return spells;
	}
	
	public Spells(String className){
		for(int i = 0; i < classTypes.length; i++){
			if(classTypes[i].equalsIgnoreCase(className)){
				indexOfClass = i;
				break;
			}
		}
	}
	
	public static List<Spell> getSpells(){
		BufferedReader input = new BufferedReader(new InputStreamReader(Spells.class.getResourceAsStream("/src/databases/Spells.txt")));
		
		List<Spell> spells = new ArrayList<>();

		if (input == null) {
			return spells;
		}

		Spell spell;
		
		try{
			String spellInputString = input.readLine();
			
			while((spellInputString = input.readLine()) != null){
				try{
					spell = new Spell(spellInputString);
					spells.add(spell);
				} catch(Exception e){
					Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
					e.printStackTrace();
					System.out.println(Arrays.asList(spellInputString.split("\t")));
				}
			}
		}catch(Exception e){
			Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nSome valid spells may not be shown.");
			e.printStackTrace();
			return Collections.emptyList();
		}
		return spells;
	}
	
	public int compare(Spell spell1, Spell spell2){
		if(spell1.levelRequirements[indexOfClass] > spell2.levelRequirements[indexOfClass])
			return 1;
		else if(spell1.levelRequirements[indexOfClass] < spell2.levelRequirements[indexOfClass])
			return -1;
		return spell1.name.compareTo(spell2.name);
	}
	
	public static int getClassIndex(String className){
		for(int i = 0; i < classTypes.length; i++){
			if(classTypes[i].equalsIgnoreCase(className)) return i;
		}
		return -1;
	}

	public static boolean spellHasType(String type, Spell spell){
		int index = -1;

		for(int i = 0; i < spellTypeNames.length; i++){
			if(spellTypeNames[i].trim().equalsIgnoreCase(type.trim())){
				index = i;
				break;
			}
		}

		if(index == -1) return false;

		return spell.spellTypes[index];
	}

	public static int spellLevelFor(String className, Spell spell){
		int index = -1;

		for(int i = 0; i < classTypes.length; i++){
			if(classTypes[i].equalsIgnoreCase(className)){
				index = i;
				break;
			}
		}

		if(index == -1) {
			return -1;
		}
		return spell.levelRequirements[index];
	}

	//GUI
	public static Spell createNewSpell(Window parent){
		AtomicBoolean spellMade = new AtomicBoolean(false);
		AtomicBoolean closed = new AtomicBoolean(false);
		JDialog spellCreator = new JDialog(parent, "Create a new spell");
		JPanel panel = new JPanel(new BorderLayout());
		JPanel top = new JPanel(new GridBagLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new BorderLayout());
		spellCreator.add(panel);
		panel.add(top, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		panel.add(middle, BorderLayout.CENTER);
		middle.add(new JLabel("Spell details (supports HTML formatting): "), BorderLayout.NORTH);

		JTextField name = new JTextField();

		JPanel levels = new JPanel(new GridBagLayout());
		JScrollPane levelsScroll = new JScrollPane(levels);
		List<JTextField> levelValues = new ArrayList<>();

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;

		for(int i = 0; i < Spells.classTypes.length; i++){
			JLabel className = new JLabel(Spells.classTypes[i]);
			JTextField classLevel = new JTextField("-1");
			levelValues.add(classLevel);
			c.gridx = 0;
			c.weightx = 0.25;
			levels.add(className, c);
			c.gridx = 1;
			c.weightx = 1;
			levels.add(classLevel, c);
			c.gridy++;
		}

		levelsScroll.setPreferredSize(new Dimension((int)levelsScroll.getPreferredSize().getHeight(), 100));
		levelsScroll.setMinimumSize(new Dimension((int)levelsScroll.getMinimumSize().getHeight(), 100));

		c.gridy = 0;
		c.gridx = 0;
		top.add(new JLabel("Spell name: "), c);
		c.gridx = 1;
		top.add(name, c);
		c.gridy++;
		c.gridwidth = 2;
		c.gridx = 0;
		top.add(levelsScroll, c);


		JTextArea description = new JTextArea();
		JScrollPane descScroll = new JScrollPane(description);
		middle.add(descScroll, BorderLayout.CENTER);

		JButton add = new JButton("Add this spell");
		JButton addAndSave = new JButton("Add and save this spell");

		bottom.add(addAndSave, BorderLayout.EAST);
		bottom.add(add, BorderLayout.CENTER);

		add.addActionListener(e -> {
			if(!(name.getText().equals("")||description.getText().equals(""))){
				for(int i = 0; i < levelValues.size(); i++){
					try{
						if(Integer.parseInt(levelValues.get(i).getText()) < -1){
							Pathfinder.showError("Error", "Invalid level entered for " + Spells.classTypes[i] + "\nEnter -1 for classes unable to cast the spell.");
							return;
						}
					} catch(NumberFormatException ex){
						Pathfinder.showError("Number Format Exception", "Value entered for " + Spells.classTypes[i] + " level is not an integer.");
					}
				}
				spellMade.set(true);
			} else {
				Pathfinder.showError("Not enough details","You must write a spell name and description.");
			}
		});

		addAndSave.addActionListener(e -> {
			if(!(name.getText().equals("")||description.getText().equals(""))){
				int[] classLevels = new int[Spells.classTypes.length];
				for(int i = 0; i < levelValues.size(); i++){
					try{
						if(Integer.parseInt(levelValues.get(i).getText()) < -1){
							Pathfinder.showError("Error", "Invalid level entered for " + Spells.classTypes[i] + "\nEnter -1 for classes unable to cast the spell.");
							return;
						} else {
							classLevels[i] = Integer.parseInt(levelValues.get(i).getText());
						}
					} catch(NumberFormatException ex){
						Pathfinder.showError("Number Format Exception", "Value entered for " + Spells.classTypes[i] + " level is not an integer.");
					}
				}

				Spell spell = new Spell(name.getText(), description.getText(), classLevels);

				JFileChooser saver = new JFileChooser();
				int returned = saver.showSaveDialog(spellCreator);
				if(returned == JFileChooser.APPROVE_OPTION){
					try{
						FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
						ObjectOutputStream out= new ObjectOutputStream(fileOut);
						out.writeObject(spell);
						spellMade.set(true);
					} catch (FileNotFoundException ex){
						Pathfinder.showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
						ex.printStackTrace();
					} catch (IOException ex){
						Pathfinder.showError("Unknown Exception","The file could not be saved.\nRun this in command for more information.");
						ex.printStackTrace();
					}
				}
			} else {
				Pathfinder.showError("Not enough details","You must write a spell name and description.");
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
		spellCreator.setLocationRelativeTo(parent);
		spellCreator.setVisible(true);

		while(!spellMade.get()){}

		spellCreator.dispose();

		if(closed.get()) return null;

		int[] spellLevels = new int[Spells.classTypes.length];
		for(int i = 0; i < spellLevels.length; i++){
			spellLevels[i] = Integer.parseInt(levelValues.get(i).getText());
		}

		return new Spell(name.getText(), description.getText(), spellLevels);
	}

	public static Spell editSpell(Window parent, Spell base){
		AtomicBoolean spellMade = new AtomicBoolean(false);
		AtomicBoolean closed = new AtomicBoolean(false);
		JDialog spellCreator = new JDialog(parent, "Edit Spell");
		JPanel panel = new JPanel(new BorderLayout());
		JPanel top = new JPanel(new GridBagLayout());
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel middle = new JPanel(new BorderLayout());
		spellCreator.add(panel);
		panel.add(top, BorderLayout.NORTH);
		panel.add(bottom, BorderLayout.SOUTH);
		panel.add(middle, BorderLayout.CENTER);
		middle.add(new JLabel("Spell details (supports HTML formatting): "), BorderLayout.NORTH);

		JTextField name = new JTextField(base.name);

		JPanel levels = new JPanel(new GridBagLayout());
		JScrollPane levelsScroll = new JScrollPane(levels);
		List<JTextField> levelValues = new ArrayList<>();

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;

		for(int i = 0; i < Spells.classTypes.length; i++){
			JLabel className = new JLabel(Spells.classTypes[i]);
			JTextField classLevel = new JTextField(Integer.toString(base.levelRequirements[i]));
			levelValues.add(classLevel);
			c.gridx = 0;
			c.weightx = 0.25;
			levels.add(className, c);
			c.gridx = 1;
			c.weightx = 1;
			levels.add(classLevel, c);
			c.gridy++;
		}

		levelsScroll.setPreferredSize(new Dimension((int)levelsScroll.getPreferredSize().getHeight(), 100));
		levelsScroll.setMinimumSize(new Dimension((int)levelsScroll.getMinimumSize().getHeight(), 100));

		c.gridy = 0;
		c.gridx = 0;
		top.add(new JLabel("Spell name: "), c);
		c.gridx = 1;
		top.add(name, c);
		c.gridy++;
		c.gridwidth = 2;
		c.gridx = 0;
		top.add(levelsScroll, c);



		JEditorPane description = new JEditorPane();
		description.setContentType("text/html");
		description.setText(base.formattedDescription);
		description.setCaretPosition(0);
		String current = description.getText();
		description.setContentType("text/plain");
		description.setText(current);

		JScrollPane descScroll = new JScrollPane(description);
		middle.add(descScroll, BorderLayout.CENTER);

		JButton add = new JButton("Save");
		JButton addAndSave = new JButton("Save and save to file");

		bottom.add(addAndSave, BorderLayout.EAST);
		bottom.add(add, BorderLayout.CENTER);

		add.addActionListener(e -> {
			if(!(name.getText().equals("")||description.getText().equals(""))){
				for(int i = 0; i < levelValues.size(); i++){
					try{
						if(Integer.parseInt(levelValues.get(i).getText()) < -1){
							Pathfinder.showError("Error", "Invalid level entered for " + Spells.classTypes[i] + "\nEnter -1 for classes unable to cast the spell.");
							return;
						}
					} catch(NumberFormatException ex){
						Pathfinder.showError("Number Format Exception", "Value entered for " + Spells.classTypes[i] + " level is not an integer.");
					}
				}
				spellMade.set(true);
			} else {
				Pathfinder.showError("Not enough details","You must write a spell name and description.");
			}
		});

		addAndSave.addActionListener(e -> {
			if(!(name.getText().equals("")||description.getText().equals(""))){
				int[] classLevels = new int[Spells.classTypes.length];
				for(int i = 0; i < levelValues.size(); i++){
					try{
						if(Integer.parseInt(levelValues.get(i).getText()) < -1){
							Pathfinder.showError("Error", "Invalid level entered for " + Spells.classTypes[i] + "\nEnter -1 for classes unable to cast the spell.");
							return;
						} else {
							classLevels[i] = Integer.parseInt(levelValues.get(i).getText());
						}
					} catch(NumberFormatException ex){
						Pathfinder.showError("Number Format Exception", "Value entered for " + Spells.classTypes[i] + " level is not an integer.");
					}
				}

				Spell spell = new Spell(base, name.getText(), description.getText(), classLevels);

				JFileChooser saver = new JFileChooser();
				int returned = saver.showSaveDialog(spellCreator);
				if(returned == JFileChooser.APPROVE_OPTION){
					try{
						FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
						ObjectOutputStream out= new ObjectOutputStream(fileOut);
						out.writeObject(spell);
						spellMade.set(true);
					} catch (FileNotFoundException ex){
						Pathfinder.showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
						ex.printStackTrace();
					} catch (IOException ex){
						Pathfinder.showError("Unknown Exception","The file could not be saved.\nRun this in command for more information.");
						ex.printStackTrace();
					}
				}
			} else {
				Pathfinder.showError("Not enough details","You must write a spell name and description.");
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
		spellCreator.setLocationRelativeTo(parent);
		spellCreator.setVisible(true);

		while(!spellMade.get()){}

		spellCreator.dispose();

		if(closed.get()) return null;

		int[] spellLevels = new int[Spells.classTypes.length];
		for(int i = 0; i < spellLevels.length; i++){
			spellLevels[i] = Integer.parseInt(levelValues.get(i).getText());
		}

		return new Spell(base, name.getText(), description.getText(), spellLevels);
	}

	public static void showSpellDetails(Spell spell, List<Spell> collection, JComponent toRepaint){
		showSpellDetails(spell, spell.name, collection, toRepaint);
	}

	public static void showSpellDetails(Spell spell, String title, List<Spell> collection, JComponent toRepaint){
		showSpellDetails(spell, title, collection, null, toRepaint);
	}

	public static void showSpellDetails(Spell spell, String title, List<Spell> collection1, List<Spell> collection2, JComponent toRepaint){
		JFrame detailsFrame = new JFrame(title);
		detailsFrame.setSize(450,550);
		detailsFrame.setLocationRelativeTo(Pathfinder.FRAME);
		JPanel detailsPanel = new JPanel(new BorderLayout());

		JEditorPane text = new JEditorPane();
		text.setContentType("text/html");
		text.setText(spell.formattedDescription);
		text.setEditable(false);
		text.setCaretPosition(0);

		JScrollPane scrollingText = new JScrollPane(text);
		scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JButton toggleEdit = new JButton("Edit");
		toggleEdit.addActionListener(e ->{
			new Thread(){
				public void run(){
					Spell edited = editSpell(detailsFrame, spell);
					if(edited != null && edited != spell && collection1 != null){
						collection1.set(collection1.indexOf(spell), edited);
						if(collection2 != null) collection2.set(collection2.indexOf(spell), edited);

						if(toRepaint != null) toRepaint.repaint();

						detailsFrame.dispose();
						showSpellDetails(edited, edited.name, collection1, collection2, toRepaint);
					}
				}
			}.start();
		});

		detailsFrame.add(detailsPanel);
		detailsPanel.add(scrollingText, BorderLayout.CENTER);
		detailsPanel.add(toggleEdit, BorderLayout.SOUTH);
		detailsFrame.setVisible(true);
	}

	public static void spellAddedAutomatically(Spell spell, List<Spell> spells){
		Spells.showSpellDetails(spell, spell.name + " was added automatically!", spells, null);
	}

	public static URL getIcon(Spell spell){
		//I need to find something better than spellbooks for this - they won't represent the schools well.
		//The spell related icons I have focus on elements (earth, fire), not schools (divination, conjuration).
		return Spells.class.getResource("/src/pictures/SpellIcons/W_Book04.png");
	}
}