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

import src.Character;
import src.Pathfinder;
import src.classes.CharacterClass;
import src.classes.SpellCaster;

import javax.swing.*;

public class Spells implements Comparator<Spell>{
	public static String[] classTypes = new String[]{"Sorcerer","Wizard","Cleric","Druid","Ranger","Bard","Paladin","Alchemist","Summoner",
		"Witch","Inquisitor","Oracle","AntiPaladin","Magus","Adept","Deity","Bloodrager","Shaman","Psychic","Medium","Mesmerist",
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
			if(spell.levelRequirements[Spells.getClassIndex(charClass.name)] == spellLevelToGet){
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
		FileReader fileIn;
		BufferedReader input = null;
		
		try{
			File file = getFilePath();

			if (file != null) {
				fileIn = new FileReader(getFilePath());
				input = new BufferedReader(fileIn);
			}
		}catch(IOException e){
			Pathfinder.showError("Error: Cannot access spells","The spell file is either not in the location expected, or I don't have permissions to access it.");
			return Collections.emptyList();
		}catch(Exception e){
			Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
			e.printStackTrace();
			return Collections.emptyList();
		}
		
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
	
	public static File getFilePath(){
		URL url = Spells.class.getResource("Spells.class");
		File file;
		try{
			if(url.getProtocol().equals("jar")){
				url = new URL(url.getPath());
			}

			file = new File(url.getPath().split("!")[0].replace("%20", " "));
		}catch(Exception e){
			Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nCannot get correct path to Spells.");
			e.printStackTrace();
			return null;
		}
		
		if(file.toString().contains("src\\spells\\Spells.class")){
			file = new File(file.toString().substring(0,file.toString().indexOf("src\\spells\\Spells.class")) + "Resources\\Spells.txt");
		}else{
			file = new File(file.toString().substring(0, file.toString().lastIndexOf("\\")) + "\\Resources\\Spells.txt");
		}
		return file;
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
			if(spellTypeNames[i].equalsIgnoreCase(type)){
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
				Pathfinder.showError("Not enough details","You must write a spell name and description.");
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
		spellCreator.setVisible(true);

		while(!spellMade.get()){}

		spellCreator.dispose();

		if(closed.get()) return null;
		return new Spell(name.getText(), description.getText());
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

	public static void spellAddedAutomatically(Spell spell){
		Spells.showSpellDetails(spell, spell.name + " was added automatically!");
	}

	public static URL getIcon(){
		//I need to find something better than spellbooks for this - they won't represent the schools well.
		//The spell related icons I have focus on elements (earth, fire), not schools (divination, conjuration).
		return Spells.class.getResource("/src/pictures/SpellIcons/W_Book04");
	}

}