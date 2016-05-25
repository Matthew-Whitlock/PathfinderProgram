package src.spells;

import java.util.*;
import java.io.*;
import src.Character;

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
		File dir = new File(System.getProperty("user.dir")+"/Spells");
		File[] spellFiles = dir.listFiles();
		Spell spell = null;
		for(File spellFile : spellFiles){
			try{
				FileInputStream fileIn = new FileInputStream(spellFile);
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				spell = (Spell)(objIn.readObject());
			} catch(IOException e){
				System.out.println("You don't seem to have permission to access file: \"" + spellFile + "\"");
			} catch(ClassNotFoundException e){
				System.out.println("The file \"" + spellFile + "\" doesn't seem to be a spell file.");
			}
			if(spell.name.equalsIgnoreCase(spellName)){
				return spell;
			}
		}
		return null;
	}
	
	public static ArrayList<Spell> search(Character me, int spellLevelToGet){
		File dir = new File(System.getProperty("user.dir")+"/Spells");
		File[] spellFiles = dir.listFiles();
		ArrayList<Spell> spells = new ArrayList<Spell>();
		Spell spell = null;
		for(File spellFile : spellFiles){
			try{
				FileInputStream fileIn = new FileInputStream(spellFile);
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				spell = (Spell)(objIn.readObject());
			} catch(IOException e){
				System.out.println("You don't seem to have permission to access file: \"" + spellFile + "\"");
			} catch(ClassNotFoundException e){
				System.out.println("The file \"" + spellFile + "\" doesn't seem to be a spell file.");
			}
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
		File dir = new File(System.getProperty("user.dir")+"/Spells");
		File[] spellFiles = dir.listFiles();
		Spell spell = null;
		for(File spellFile : spellFiles){
			try{
				FileInputStream fileIn = new FileInputStream(spellFile);
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				spell = (Spell)(objIn.readObject());
			} catch(IOException e){
				System.out.println("You don't seem to have permission to access file: \"" + spellFile + "\"");
			} catch(ClassNotFoundException e){
				System.out.println("The file \"" + spellFile + "\" doesn't seem to be a spell file.");
			}
			if(spell.bloodlineLevels.containsKey(bloodline) && spell.bloodlineLevels.get(bloodline) == level){
				return spell;
			}
		}
		return null;
	}
	
	public static ArrayList<Spell> searchByPartialName(String name){
		File dir = new File(System.getProperty("user.dir")+"/Spells");
		File[] spellFiles = dir.listFiles();
		ArrayList<Spell> spells = new ArrayList<Spell>();
		name = name.toLowerCase();
		Spell spell = null;
		for(File spellFile : spellFiles){
			try{
				FileInputStream fileIn = new FileInputStream(spellFile);
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				spell = (Spell)(objIn.readObject());
			} catch(IOException e){
				System.out.println("You don't seem to have permission to access file: \"" + spellFile + "\"");
			} catch(ClassNotFoundException e){
				System.out.println("The file \"" + spellFile + "\" doesn't seem to be a spell file.");
			}
			if(spell.name.toLowerCase().contains(name)){
				spells.add(spell);
			}
		}
		return spells;
	}
	
	public static ArrayList<Spell> searchByBloodline(String bloodline){
		File dir = new File(System.getProperty("user.dir")+"/Spells");
		File[] spellFiles = dir.listFiles();
		ArrayList<Spell> spells = new ArrayList<Spell>();
		Spell spell = null;
		for(File spellFile : spellFiles){
			try{
				FileInputStream fileIn = new FileInputStream(spellFile);
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				spell = (Spell)(objIn.readObject());
			} catch(IOException e){
				System.out.println("You don't seem to have permission to access file: \"" + spellFile + "\"");
			} catch(ClassNotFoundException e){
				System.out.println("The file \"" + spellFile + "\" doesn't seem to be a spell file.");
			}
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