package src;

import java.io.Serializable;

public abstract class Spell implements Serializable{
	public String name;
	public String vagueDesc;
	public String PreReqs;
	public String verboseDesc;
	public String castingTime;
	public String Components;
	public String range;
	public String target;
	public String attackRoll = null;
	public static Spell[] allSpells;
	public abstract boolean arePreReqsMetBy(Character me);
	public abstract int getRoundsOfEffect(Character me);
}