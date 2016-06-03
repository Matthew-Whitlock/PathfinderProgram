package src;

import java.io.Serializable;

public abstract class Equipable extends Item implements Serializable{
	public int acBoost = 0;
	public int acPenalty = 0;
	public String attackRoll = null;
	public int maxDex = 100;
}