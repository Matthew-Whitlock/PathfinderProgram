package src.feats;

import java.io.Serializable;

public class EschewMaterials extends Feat implements Serializable{
	public EschewMaterials(){
		name = "Eschew Materials";
		oneLiner = "Cast Spells without material components";
		inDepthDescription = "You can cast ant spell with a material component costing 1 gp or less without needing that component. \nThe casting of the spell still provokes attacks of opportunity as normal. \nIf the spell requires a material component that costs more than 1 gp you must have the material component on hand to cast the spell, as normal.";
	}
	public String attackModifier(){
		return null;
	}
}