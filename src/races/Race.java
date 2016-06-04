package src.races;

import src.feats.Feat;
import src.stats.AbilityScoreEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Race implements Serializable{
	public String name;
	public ArrayList<String> notes = new ArrayList<>();
	public HashMap<AbilityScoreEnum, Integer> abilityScoreChanges = new HashMap<AbilityScoreEnum, Integer>();
	public Feat[] bonusFeats;
	
	public String toString(){
		return name;
	}

	public abstract String getDefaultRaceImageLocation();
}