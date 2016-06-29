package src.races;

import src.feats.Feat;
import src.stats.AbilityScoreEnum;

import java.io.Serializable;
import java.net.URL;

public class Dwarf extends Race implements Serializable{
	public Dwarf(){
		abilityScoreChanges.put(AbilityScoreEnum.CON, 2);
		abilityScoreChanges.put(AbilityScoreEnum.WIS, 2);
		abilityScoreChanges.put(AbilityScoreEnum.CHA, -2);
		notes.add("+4 dodge for giant monsters");
		notes.add("Good with appraising metals/jewels");
		notes.add("+1 attacking Orks and Goblins");
		notes.add("+4 resisting being knocked down or tripped");
		notes.add("+2 perception for perceiving weird stone. (Traps etc.)");
		notes.add("Good at seeing in the dark");
		name = "Dwarf";
		bonusFeats = new Feat[0];
	}
	
	public static String[] getInfo(){
		return new String[]{"+4 dodge for giant monsters","Good at appraising metals/jewels",
			"+1 attacking Orks and Goblins","+4 resisting being knocked down or tripped","+2 Perception for stone things",
			"Good at seeing in the dark"};
	}
	
	public static String getDescription(){
		return "Dwarves are a stoic but stern race, ensconced in cities"+
				"carved from the hearts of mountains and fiercely"+
				"determined to repel the depredations of savage races like"+
				"orcs and goblins. More than any other race, the dwarves"+
				"have acquired a reputation as dour and humorless"+
				"craftsmen of the earth. It could be said that dwarven"+
				"history shapes the dark disposition of many dwarves,"+
				"for they reside in high mountains and dangerous realms"+
				"below the earth, constantly at war with giants, goblins,"+
				"and other such horrors.";
	}
	
	public URL getDefaultRaceImageLocation(){
		return Dwarf.class.getResource("/src/pictures/Dwarf.jpg");
	}
}