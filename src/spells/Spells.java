package src.spells;

import java.util.*;
import java.io.*;
import java.net.URL;
import src.Character;
import src.Pathfinder;
import src.spells.Spell;

public class Spells implements Comparator<Spell>{
	public static String[] classTypes = new String[]{"Sorceror","Wizard","Cleric","Druid","Ranger","Bard","Paladin","Alchemist","Summoner",
		"Witch","Inquisitor","Oracle","AntiPaladin","Magus","Adept","Deity","Bloodrager","Shaman","Psychic","Medium","Mesmerist",
		"Occultist","Spiritualist","Skald"};
	public static String[] componentTypes = new String[]{"Verbal", "Somatic", "Material", "Focus", "Divine Focus","Costly Components"};
	public static String[] spellTypeNames = new String[]{"Acid", "Air", "Chaotic", "Cold", "Curse", "Darkness", "Death", "Disease", "Earth", "Electricity",
		"Emotion", "Evil", "Fear", "Fire", "Force", "Good", "Language Dependent", "Lawful", "Light", "Mind Affecting", "Pain", "Poison",
		"Shadow", "Sonic", "Water"};
	
	private int indexOfClass;
	
	public static String getFileName(Spell spell){
		return spell.name.replace("/","_");
	}
	
	public static Spell searchByName(String spellName){
		for(Spell spell : getSpells()){
			if(spell.name.equalsIgnoreCase(spellName)){
				return spell;
			}
		}
		return null;
	}
	
	public static ArrayList<Spell> search(Character me, int spellLevelToGet){
		ArrayList<Spell> spells = new ArrayList<Spell>();
		for(Spell spell : getSpells()){
			if(spell.levelRequirements[Spells.getClassIndex(me.charClass.name)] == spellLevelToGet){
				boolean alreadyKnown = false;
				for(Spell knownSpell : me.knownSpells){
					if(spell.toString().equals(knownSpell.toString())) alreadyKnown = true;
				}
				if(alreadyKnown) continue;
				spells.add(spell);
			}
		}
		return spells;
	}
	
	public static Spell getBloodLineSpell(String bloodline, int level){
		for(Spell spell : getSpells()){
			if(spell.bloodlineLevels.containsKey(bloodline) && spell.bloodlineLevels.get(bloodline) == level){
				return spell;
			}
		}
		return null;
	}
	
	public static ArrayList<Spell> searchByPartialName(String name){
		ArrayList<Spell> spells = new ArrayList<Spell>();
		name = name.toLowerCase();
		for(Spell spell : getSpells()){
			if(spell.name.toLowerCase().contains(name)){
				spells.add(spell);
			}
		}
		return spells;
	}
	
	public static ArrayList<Spell> searchByBloodline(String bloodline){
		ArrayList<Spell> spells = new ArrayList<Spell>();
		for(Spell spell : getSpells()){
			if(spell.bloodlineLevels.containsKey(bloodline)){
				spells.add(spell);
			}
		}
		Collections.sort(spells, new Spells(bloodline));
		return spells;
	}
	
	public Spells(String bloodline){
		for(int i = 0; i < classTypes.length; i++){
			if(classTypes[i].equalsIgnoreCase(bloodline)){
				indexOfClass = i;
				break;
			}
		}
	}
	
	public static ArrayList<Spell> getSpells(){
		FileReader fileIn;
		BufferedReader input;
		
		try{
			fileIn = new FileReader(getFilePath());
			input = new BufferedReader(fileIn);
		}catch(IOException e){
			Pathfinder.showError("Error: Cannot access spells","The spell file is either not in the location expected, or I don't have permissions to access it.");
			return null;
		}catch(Exception e){
			Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
			e.printStackTrace();
			return null;
		}
		
		ArrayList<Spell> spells = new ArrayList<Spell>();
		Spell spell = null;
		
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
			return null;
		}
		return spells;
	}
	
	public static File getFilePath(){
		URL url = Spells.class.getResource("Spells.class");
		File file = null;
		try{
			file = new File(url.toURI());
		}catch(Exception e){
			Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nCannot get correct path to Spells.");
			return null;
		}
		
		if(file.toString().contains("src\\spells\\Spells.class")){
			file = new File(file.toString().substring(0,file.toString().indexOf("src\\spells\\Spells.class")) + "Resources\\Spells.txt");
		}else{
			file = new File(file.toString().substring(0,file.toString().indexOf("Pathfinder.jar")) + "Resources\\Spells.txt");
		}
		return file;
	}
	
	public int compare(Spell spell1, Spell spell2){
		if(spell1.levelRequirements[indexOfClass] > spell2.levelRequirements[indexOfClass]) return -1;
		else if(spell1.levelRequirements[indexOfClass] < spell2.levelRequirements[indexOfClass]) return 1;
		return spell1.name.compareTo(spell2.name);
	}
	
	public static int getClassIndex(String className){
		for(int i = 0; i < classTypes.length; i++){
			if(classTypes[i].equalsIgnoreCase(className)) return i;
		}
		return -1;
	}
}