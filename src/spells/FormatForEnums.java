package src.spells;

import java.io.*;
import java.util.*;

public class FormatForEnums{
	public static void main(String[] args) throws FileNotFoundException, IOException{
		FileReader fileIn = new FileReader(args[0] + args[1]);
		BufferedReader input = new BufferedReader(fileIn);
		String spellInputString = input.readLine();
		FileWriter fileOut = new FileWriter(new File(args[0] + "enums_" + args[1]));
		BufferedWriter output = new BufferedWriter(fileOut);
		while((spellInputString = input.readLine()) != null){
			String[] data = spellInputString.split("\t");
			if(!data[19].trim().equalsIgnoreCase("PFRPG Core")) continue;
			String formatted = "\t" + data[0].toUpperCase().replace(" ","_").replace("/","_").replace("-","_").replace("\'","").replace(",","") + "\t(\"" + spellInputString.replace("\\","\\\\").replace("\"","\\\"").replace("\'","\\\'") + "\"),\n";
			output.write(formatted);
		}
	}
}