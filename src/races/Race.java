package src.races;

import src.feats.Feat;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Race implements Serializable{
	public String name;
	public int str = 0;
	public int dex = 0;
	public int con = 0;
	public int intel = 0;
	public int wis = 0;
	public int cha = 0;
	public ArrayList<String> notes = new ArrayList<>();
	public Feat[] bonusFeats;
	
	public String toString(){
		return name;
	}

	public abstract ImageIcon getRaceImage();
}