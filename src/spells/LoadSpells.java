package src.spells;

import java.io.*;
import java.util.*;
import src.spells.Spell;

public class LoadSpells{
	public static void main(String[] args) throws FileNotFoundException, IOException{
		FileReader fileIn = new FileReader(args[0]);
		BufferedReader input = new BufferedReader(fileIn);
		Spell spell = null;
		String spellInputString = input.readLine();
		while((spellInputString = input.readLine()) != null){
			try{
				spell = new Spell(spellInputString);
			} catch(Exception e){
				e.printStackTrace();
				System.out.println(Arrays.asList(spellInputString.split("\t")));
				System.out.println(spellInputString);
			}
			try{
				FileOutputStream fileOut = new FileOutputStream("Spells\\" + Spells.getFileName(spell));
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
				objectOut.writeObject(spell);
				objectOut.flush();
			} catch (Exception e){
				System.out.println("Error saving spell: " + spell.name);
			}
		}
	}
}