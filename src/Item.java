package src;

		import java.io.Serializable;

public abstract class Item implements Serializable{
	public String name;
	public int copperValue = 0;
	public int silverValue = 0;
	public int goldValue = 0;
	public int platinumValue = 0;

	public String toString(){
		return name;
	}
}