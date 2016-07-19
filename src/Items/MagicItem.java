package src.items;

import src.feats.Feats;

import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;

//Needs a way to parse base items and find the appropriate one, for proper max dex, etc.
public class MagicItem implements Serializable, Item{
	public String name;
	public String aura;
	public int casterLevel;
	public String slot;
	public int price;
	public double weight;
	public String basicDescription;
	public String craftingRequirements;
	public int craftingCost;
	public String group;
	public String source;
	public String magicItemRequirements;
	public String htmlText;
	public String auraStrength;
	public String[] baseItems;

	public boolean hasScaling;
	public String scaling;

	public boolean isLiving;
	public String alignment;
	public int intel;
	public int wis;
	public int cha;
	public int ego;
	public String communication;
	public String senses;
	public String powers;
	public String languages;

	public boolean mythic;
	public boolean legendaryWeapon;
	public boolean illusion;
	public boolean universal;
	public boolean minorArtifact;
	public boolean majorArtifact;
	public boolean abjuration;
	public boolean conjuration;
	public boolean divination;
	public boolean enchantment;
	public boolean evocation;
	public boolean necromancy;
	public boolean transmutation;


	public MagicItem(String detailsLine){
		String[] details = detailsLine.split("\t");
		name = details[0];
		aura = details[1];
		casterLevel = !(details[2].equalsIgnoreCase("NULL") || details[2].equals("")) ? Feats.getNumberFromString(details[2]) : -1;

		slot = details[3];
		price = details[34].equalsIgnoreCase("null") ? 0 : Integer.parseInt(details[34]);
		weight = details[32].equalsIgnoreCase("null") ? 0 : Double.parseDouble(details[32]);
		basicDescription = details[6];
		craftingRequirements = details[7];
		craftingCost = details[34].equalsIgnoreCase("null") ? 0 : Integer.parseInt(details[34]);
		group = details[9];
		source = details[10];
		if(!(details[11].equals("") && details[12].equals("") && details[13].equals("") && details[14].equals("") && details[15].equals(""))) isLiving = true;
		alignment = details[11];
		intel = isLiving && !details[12].equals("")? Integer.parseInt(details[12]) : 0;
		wis = isLiving && !details[13].equals("") ? Integer.parseInt(details[13]) : 0;
		cha = isLiving && !details[14].equals("") ? Integer.parseInt(details[14]) : 0;
		ego = isLiving && !details[15].equals("") ? Integer.parseInt(details[15]) : 0;
		communication = details[16];
		senses = details[17];
		powers = details[18];
		magicItemRequirements = details[19];
		htmlText = details[20];
		minorArtifact = details[22].equals("1");
		majorArtifact = details[23].equals("1");
		abjuration = details[24].equals("1");
		conjuration = details[25].equals("1");
		divination = details[26].equals("1");
		enchantment = details[27].equals("1");
		evocation = details[28].equals("1");
		necromancy = details[29].equals("1");
		transmutation = details[30].equals("1");
		auraStrength = details[31];
		languages = details[35];
		baseItems = details[36].split(", ");
		mythic = details[39].equals("1");
		legendaryWeapon = details[40].equals("1");
		illusion = details[41].equals("1");
		universal = details[42].equals("1");
		hasScaling = details.length > 42;
		scaling = hasScaling ? "" : details[43];

	}

	public String toString(){
		return name;
	}

	public int getMaxDex(){
		return -1;
	}

	public int getACPen(){
		return 0;
	}

	public int getACBoost(){
		return 0;
	}

	public int[] cost(){
		return new int[]{0, price, 0, 0};
	}

	public double weight(){
		return weight;
	}

	public int speedChange(int initialSpeed){
		return initialSpeed;
	}

	public String getFormattedDetails(){
		return htmlText;
	}

	public String getInventoryLine(){
		return toString();
	}

	public int getPurchaseAmount(){
		return 1;
	}

	public boolean equals(MagicItem toCompare){
		if(toCompare == null) return false;

		return name.equals(toCompare.name) && aura.equals(toCompare.aura) && casterLevel == toCompare.casterLevel && slot.equals(toCompare.slot) && price == toCompare.price && weight == toCompare.weight &&
				basicDescription.equals(toCompare.basicDescription) && craftingRequirements.equals(toCompare.craftingRequirements) && craftingCost == toCompare.craftingCost && group.equals(toCompare.group) &&
				source.equals(toCompare.source) && isLiving == toCompare.isLiving && alignment.equals(toCompare.alignment) && intel == toCompare.intel && wis == toCompare.wis && cha == toCompare.cha &&
				ego == toCompare.ego && communication.equals(toCompare.communication) && senses.equals(toCompare.senses) && powers.equals(toCompare.powers) && magicItemRequirements.equals(toCompare.magicItemRequirements) &&
				htmlText.equals(toCompare.htmlText) && minorArtifact == toCompare.minorArtifact && majorArtifact == toCompare.majorArtifact && abjuration == toCompare.abjuration && conjuration == toCompare.conjuration &&
				divination == toCompare.divination && enchantment == toCompare.enchantment && evocation == toCompare.evocation && necromancy == toCompare.necromancy && transmutation == toCompare.transmutation &&
				auraStrength.equals(toCompare.auraStrength) && languages.equals(toCompare.languages) && Arrays.equals(baseItems, toCompare.baseItems) && mythic == toCompare.mythic && legendaryWeapon == toCompare.legendaryWeapon &&
				illusion == toCompare.illusion && universal == toCompare.universal && hasScaling == toCompare.hasScaling && scaling.equals(toCompare.scaling);
	}

	public int hashCode(){
		int hash = 58013;

		hash += name.hashCode();
		hash += aura.hashCode();
		hash += casterLevel;
		hash += slot.hashCode();
		hash += price;
		hash += weight;
		hash += basicDescription.hashCode();
		hash += craftingRequirements.hashCode();
		hash += craftingCost;
		hash += group.hashCode();
		hash += source.hashCode();
		hash += alignment.hashCode();
		hash += intel;
		hash += wis;
		hash += cha;
		hash += ego;
		hash += communication.hashCode();
		hash += senses.hashCode();
		hash += powers.hashCode();
		hash += magicItemRequirements.hashCode();
		hash += htmlText.hashCode();
		hash += auraStrength.hashCode();
		hash += languages.hashCode();
		for(String s : baseItems) hash += s.hashCode();
		hash += scaling.hashCode();

		hash += isLiving ? 1 : 0;
		hash += minorArtifact ? 3 : 0;
		hash += majorArtifact ? 5 : 0;
		hash += abjuration ? 7 : 0;
		hash += conjuration ? 11 : 0;
		hash += divination ? 37 : 0;
		hash += enchantment ? 41 : 0;
		hash += evocation ? 43 : 0;
		hash += necromancy ? 47 : 0;
		hash += transmutation ? 53 : 0;
		hash += mythic ? 59 : 0;
		hash += legendaryWeapon ? 61 : 0;
		hash += illusion ? 67 : 0;
		hash += universal ? 71 : 0;
		hash += hasScaling ? 73 : 0;

		return hash;
	}

	public String getItemName(){
		return name;
	}

	public URL getIcon(){
		if(slot.contains("feet")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/A_Shoes06.png");
		}
		if(slot.contains("eye") || slot.contains("face")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/Monocle.png");
		}
		if(slot.contains("body")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/Robes.png");
		}
		if(slot.contains("neck") || slot.contains("amulet")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/Ac_Necklace01.png");
		}
		if(slot.contains("armor")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/MagicArmor.png");
		}
		if(slot.contains("shield")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/MagicShield.png");
		}
		if(slot.contains("head")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/TopHat.png");
		}
		if(slot.contains("ring")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/MagicRing.png");
		}
		if(slot.contains("shoulder")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/MagicShoulder.png");
		}
		if(slot.contains("chest") || slot.contains("cloak")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/MagicChest.png");
		}
		if(slot.contains("hand") || slot.contains("wrist")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/MagicGauntlet.png");
		}
		if(slot.contains("weapon")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/MagicWeapon.png");
		}
		if(slot.contains("rod") || name.toLowerCase().contains("voidstick") || name.equals("Krune's Rune-Carved Rod")){
			return MagicItem.class.getResource("/src/pictures/ItemIcons/MagicRod.png");
		}


		//Waiting to hear back on belt/waist sprites
		//Need to find something for genie seals.

		return MagicItem.class.getResource("/src/pictures/ItemIcons/S_Sword10.png"); //A terrible generic magic item sprite.
	}
}