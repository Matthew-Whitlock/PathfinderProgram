package src.feats;

import java.io.Serializable;

public class Feat implements Serializable{
	public String name;
	public String type;
	public String description;
	public String prereqsAsString;
	public String prereqFeatsAsString;
	public String benefit;
	public String normal;
	public String special;
	public String source;
	public String fullText;
	public String raceName;
	public String prereqsSkillsAsString;
	public boolean teamwork;
	public boolean critical;
	public boolean grit;
	public boolean style;
	public boolean performance;
	public boolean racial;
	public boolean companionOrFamiliar;
	public boolean canDoMultiple;
	public boolean panache;
	public boolean betrayal;
	public boolean targeting;
	public boolean esoteric;
	public boolean stare;
	public boolean weaponMastery;
	public boolean itemMastery;
	public boolean armorMastery;
	public boolean shieldMastery;
	public String subType = "";

	public Feat(String detailString){
		String[] details = detailString.split("\t");
		name = details[1];
		type = details[2];
		description = details[3];
		prereqsAsString = details[4];
		prereqFeatsAsString = details[5];
		benefit = details[6];
		normal = details[7];
		special = details[8];
		source = details[9];
		fullText = details[10];
		teamwork = details[11].equals("1");
		critical = details[12].equals("1");
		grit = details[13].equals("1");
		style = details[14].equals("1");
		performance = details[15].equals("1");
		racial = details[16].equals("1");
		companionOrFamiliar = details[17].equals("1");
		raceName = details[18];
		canDoMultiple = details[22].equals("1");
		prereqsSkillsAsString = details[24];
		panache = details[25].equals("1");
		betrayal = details[26].equals("1");
		targeting = details[27].equals("1");
		esoteric = details[28].equals("1");
		stare = details[29].equals("1");
		weaponMastery = details[30].equals("1");
		itemMastery = details[31].equals("1");
		armorMastery = details[32].equals("1");
		shieldMastery = details[33].equals("1");
	}

	public Feat(Feat base, String subType){
		name = base.name;
		type = base.type;
		description = base.description;
		prereqsAsString = base.prereqsAsString;
		prereqFeatsAsString = base.prereqFeatsAsString;
		benefit = base.benefit;
		normal = base.normal;
		special = base.special;
		source = base.source;
		fullText = base.fullText;
		teamwork = base.teamwork;
		critical = base.critical;
		grit = base.grit;
		style = base.style;
		performance = base.performance;
		racial = base.racial;
		companionOrFamiliar = base.companionOrFamiliar;
		raceName = base.raceName;
		canDoMultiple = base.canDoMultiple;
		prereqsSkillsAsString = base.prereqsSkillsAsString;
		panache = base.panache;
		betrayal = base.betrayal;
		targeting = base.targeting;
		esoteric = base.esoteric;
		stare = base.stare;
		weaponMastery = base.weaponMastery;
		itemMastery = base.itemMastery;
		armorMastery = base.armorMastery;
		shieldMastery = base.shieldMastery;
		this.subType = subType;
	}

	public Feat(String name, String details){
		this.name = name;
		type = "";
		description = "";
		prereqsAsString = "";
		prereqFeatsAsString = "";
		benefit = "";
		normal = "";
		special = "";
		source = "";
		fullText = details;
		raceName = "";
		prereqsSkillsAsString = "";
	}


	public String toString(){
		return name + " (" + type + ")";
	}
}