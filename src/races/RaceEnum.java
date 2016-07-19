package src.races;

import src.feats.Feat;
import src.feats.Feats;
import src.stats.AbilityScoreEnum;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public enum RaceEnum implements Serializable, Race{

	FETCHLING("Fetchling", new String[]{"Shadow Blending (Su)","Attacks against a fetchling in dim light have a 50% chance to miss instead of the normal 20% miss chance. This does not grant total concealment.", "Shadowy Resistance","Fetchlings have cold resistance 5 and electricity resistance 5.", "Skilled","Fetchlings have a +2 racial bonus on Knowledge (planes) and Stealth checks.", "Spell-Like Abilities (Sp)", "A fetchling can use disguise self once per day as a spell-like ability. He can assume the form of any humanoid creature. A fetchling's caster level is equal to his total Hit Dice. When a fetchling reaches 9th level in any combination of classes, he gains shadow walk (self only) as a spell-like ability usable once per day as a spell-like ability. A fetchling's caster level is equal to his total Hit Dice. When a fetchling reaches 13th level in any combination of classes, he gains plane shift (self only, to the Shadow Plane or the Material Plane only) usable once per day as a spell-like ability. A fetchling's caster level is equal to his total Hit Dice.","Darkvision","Darkvision: Fetchlings can see perfectly in the dark up to 60 feet.","Low-Light Vision","In addition to their ability to see perfectly in the dark up to 60 ft, fetchlings have low-light vision, allowing them to see twice as far as humans in conditions of dim light."}, "Descended from humans trapped on the Shadow Plane, fetchlings are creatures of darkness and light intertwined. Generations of contact with that strange plane and its denizens have made fetchlings a race apart from humanity. While fetchlings acknowledge their origins, they exhibit little physical or cultural resemblance to their ancestors on the Material Plane, and are often insulted when compared to humans.", new String[0], new AbilityScoreEnum[]{AbilityScoreEnum.DEX,AbilityScoreEnum.WIS,AbilityScoreEnum.CHA},new int[]{2,-2,2}, "/src/pictures/RaceImages/Default.png"),
	AASIMAR("Aasimar", new String[]{"Celestial Resistance", "Aasimars have acid resistance 5, cold resistance 5, and electricity resistance 5.","Skilled", "Aasimar have a +2 racial bonus on Diplomacy and Perception checks.","Spell-Like Ability (Sp)", "Aasimars can use daylight once per day as a spell-like ability (caster level equal to the aasimar's class level).","Darkvision", "Aasimar have darkvision 60 ft. (they can see perfectly in the dark up to 60 feet.)"},"Aasimars are humans with a significant amount of celestial or other good outsider blood in their ancestry. While not always benevolent, aasimars are more inclined toward acts of kindness rather than evil, and they gravitate toward faiths or organizations associated with celestials. Aasimar heritage can lie dormant for generations, only to appear suddenly in the child of two apparently human parents. Most societies interpret aasimar births as good omens, though it must be acknowledged that some aasimars take advantage of the reputation of their kind, brutally subverting the expectations of others with acts of terrifying cruelty or abject venality.",new String[0], new AbilityScoreEnum[]{AbilityScoreEnum.WIS,AbilityScoreEnum.CHA},new int[]{2,2}, "/src/pictures/RaceImages/Aasimar.png"),
	DWARF("Dwarf", new String[]{"Greed","Dwarves gain a +2 racial bonus on Appraise checks made to determine the price of non-magical goods that contain precious metals or gemstones.","Hatred","Dwarves gain a +1 racial bonus on attack rolls against humanoid creatures of the orc and goblinoid subtypes because of their special training against these hated foes.","Stability","Dwarves gain a +4 racial bonus to their Combat Maneuver Defense when resisting a bull rush or trip attempt while standing on the ground.","Stonecutting","Dwarves gain a +2 bonus on Perception checks to notice unusual stonework, such as traps and hidden doors located in stone walls or floors. They receive a check to notice such features whenever they pass within 10 feet of them, whether or not they are actively looking.", "Darkvision","Dwarves can see perfectly in the dark up to 60 feet.","Weapon Familiarity","Weapon Familiarity: Dwarves are proficient with battleaxes, heavy picks, and warhammers, and treat any weapon with the word “dwarven” in its name as a martial weapon.","Hardy","Dwarves gain a +2 racial bonus on saving throws against poison, spells, and spell-like abilities.","Defensive Training","Dwarves gain a +4 dodge bonus to AC against monsters of the giant subtype."},"Dwarves are a stoic but stern race, ensconced in cities carved from the hearts of mountains and fiercely determined to repel the depredations of savage races like orcs and goblins. More than any other race, the dwarves have acquired a reputation as dour and humorless craftsmen of the earth. It could be said that dwarven history shapes the dark disposition of many dwarves, for they reside in high mountains and dangerous realms below the earth, constantly at war with giants, goblins, and other such horrors.",new String[0],new AbilityScoreEnum[]{AbilityScoreEnum.CON,AbilityScoreEnum.WIS,AbilityScoreEnum.CHA},new int[]{2,2,-2}, "/src/pictures/RaceImages/Dwarf.jpg");


	private final String name;
	private final String[] notes;
	private final String description;
	private final String[] bonusFeatNames;
	private final AbilityScoreEnum[] modifiedAbilities;
	private final int[] abilityModifiers;
	private final String imageResourceLocation;

	RaceEnum(String name, String[] notes, String description, String[] bonusFeatNames, AbilityScoreEnum[] modifiedAbilities, int[] abilityModifiers, String imageResourceLocation){
		this.name = name;
		this.notes = notes;
		this.description = description;
		this.bonusFeatNames = bonusFeatNames;
		this.modifiedAbilities = modifiedAbilities;
		this.abilityModifiers = abilityModifiers;
		this.imageResourceLocation = imageResourceLocation;
	}

	public String[] notes(){
		return notes;
	}
	
	public String getDescription(){
		return description;
	}

	public Feat[] bonusFeats(){
		Feat[] toReturn = new Feat[bonusFeatNames.length];
		for(int i = 0; i < toReturn.length; i++){
			toReturn[i] = Feats.getFeatByName(bonusFeatNames[i]);
		}
		return toReturn;
	}

	public Map<AbilityScoreEnum, Integer>  abilityScoreChanges(){
		Map<AbilityScoreEnum, Integer> toReturn = new HashMap<>();
		for(int i = 0; i < abilityModifiers.length; i++){
			toReturn.put(modifiedAbilities[i], abilityModifiers[i]);
		}
		return toReturn;
	}
	
	public URL getDefaultRaceImageLocation(){
		return this.getClass().getResource(imageResourceLocation);
	}

	public String getName(){
		return name;
	}

	public String toString(){
		return name;
	}
}