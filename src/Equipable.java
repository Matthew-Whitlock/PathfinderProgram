package src;

import java.io.Serializable;

public abstract class Equipable extends Item implements Serializable{
	public int armorACModifier = 0;
	public String attackRoll = null;
	public int maxDex = 20;
}