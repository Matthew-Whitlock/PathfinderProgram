package src.feats;

import java.io.Serializable;

public abstract class Feat implements Serializable{
	public String name;
	public String oneLiner;
	public String inDepthDescription;
	public String toString(){
		return name + ": " + oneLiner;
	}
	public abstract String attackModifier();
}