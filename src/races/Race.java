package src.races;

import src.feats.Feat;
import src.stats.AbilityScoreEnum;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public abstract class Race implements Serializable{
	public String name;

	public Map<AbilityScoreEnum, Integer> abilityScoreChanges;

	public ArrayList<String> notes = new ArrayList<>();
	public Feat[] bonusFeats;
	
	public String toString(){
		return name;
	}

	public abstract ImageIcon getRaceImage();
}