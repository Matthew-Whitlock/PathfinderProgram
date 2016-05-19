import java.util.*;
import java.io.*;
import javax.swing.*;

public abstract class Race implements Serializable{
	public String name;
	public int str = 0;
	public int dex = 0;
	public int con = 0;
	public int intel = 0;
	public int wis = 0;
	public int cha = 0;
	public ArrayList<String> notes = new ArrayList<String>();
	
	public String toString(){
		return name;
	}
	public Feat[] bonusFeats;
	public abstract ImageIcon getRaceImage();
}