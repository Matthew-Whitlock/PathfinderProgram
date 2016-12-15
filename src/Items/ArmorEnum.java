package src.items;

import java.io.Serializable;
import java.net.URL;

public enum ArmorEnum implements Serializable, Item{

	ARMORED_KILT("Armored Kilt", "Light Armor", 20,1,6,0,0,30,20,10,"When you add an armored kilt to a suit of light armor, the set counts as medium armor. Likewise, a kilt and medium armor counts as heavy armor. Adding an armored kilt to heavy armor has no effect."),
	PADDED("Padded","Light Armor",5,1,8,0,5,30,20,10,"Little more than heavy, quilted cloth, this armor provides only the most basic protection."),
	QUILTED_CLOTH("Quilted Cloth","Light Armor",100,1,8,0,10,30,20,15,"This enhanced form of padded armor has internal layers specifically designed to trap arrows, bolts, darts, shuriken, thrown daggers, and other small ranged piercing weapons. When these kinds of weapons strike you, they tend to become snagged in these layers and fail to harm you.<br>Benefit: You gain DR 3/— against attacks of this kind (small piercing weapons). The special layers of the armor have no effect on other kinds of weapons."),
	LEATHER("Leather","Light Armor",10,2,6,0,10,30,20,15,"Leather armor is made up of pieces of hard boiled leather carefully sewn together."),
	ROSEWOOD_ARMOR("Rosewood Armor","Light Armor",10,2,6,0,10,30,20,15,"This suit of leather armor is wrapped in special rose vines.<br>Benefit: Treat this as leather armor with armor spikes. The vines must be watered with at least 1 gallon of water each day or they wither and die, turning the armor into normal leather armor."),
	HIDE_SHIRT("Hide Shirt","Light Armor",20,3,4,-1,15,30,20,18,"Made from animal hide and giant lizard scales over a shirt of interwoven cords, these chest and shoulder coverings protect without restricting mobility.<br>The wearer of a hide shirt can make a DC 15 Strength check as a standard action. If he succeeds, the armor gains the broken condition and drops to the ground rather than requiring the usual 1 minute it would take to remove it. The armor must be repaired as though it had taken 8 points of damage before it can be used again; a broken hide shirt grants no bonus to Armor Class."),
	LEAF_ARMOR("Leaf Armor","Light Armor",500,3,5,0,15,30,20,20,"Druidic elves use alchemical compounds to treat special leaves used in crafting armor for their warriors.<br>Benefit: Leaf armor is always of masterwork quality and has the same game statistics as masterwork studded leather, except it contains no metal."),
	PARADE_ARMOR("Parade Armor","Light Armor",25,3,5,-1,15,30,20,20,"Most wealthy countries with standing armies have a different uniform for use in showy noncombat situations such as parades, coronation ceremonies, and so on. The appearance of this armor varies by the country of origin and the branch of the military, but still provides some protection in case the soldier needs to fight while in parade dress.<br>Benefit: If you’re wearing a country’s parade armor, you gain a +2 circumstance bonus to Diplomacy and Intimidate checks to influence a person from that country."),
	STUDDED_LEATHER("Studded Leather","Light Armor",25,3,5,-1,15,30,20,20,"Similar to leather armor, this suit is reinforced with small metal studs."),
	WOODEN("Wooden","Light Armor",20,3,3,-1,15,30,20,25,"This suit of leather armor has plates of fire-treated wood sewn over vital areas. Though not as effective as metal armor, it offers better protection than leather alone. Unlike metal armor, the wood is slightly buoyant.<br>Benefit: The armor check penalty for swimming in this armor is 0."),
	CHAIN_SHIRT("Chain Shirt","Light Armor",100,4,4,-2,20,30,20,25,"Covering the torso, this shirt is made up of thousands of interlocking metal rings."),
	ARMORED_COAT("Armored Coat","Medium Armor",50,4,3,-2,20,20,15,20,"This sturdy leather coat is reinforced with metal plates sewn into the lining.<br>Benefit: More cumbersome than light armor but less effective than most medium armors, the advantage of an armored coat is that a person can don it or remove it as a move action (there is no “don hastily” option for an armored coat). If worn over other armor, use the better AC bonus and worse value in all other categories; an armored coat has no effect if worn with heavy armor. The only magic effects that apply are those worn on top."),
	HIDE("Hide","Medium Armor",15,4,4,-3,20,20,15,25,"Hide armor is made up of the tanned and preserved skin of any thick-hided beast."),
	SCALE_MAIL("Scale Mail","Medium Armor",50,5,3,-4,25,20,15,30,"Scale mail is made up of dozens of small overlapping metal plates. The suit includes gauntlets."),
	CHAIN_MAIL("Chainmail","Medium Armor",150,6,2,-5,30,20,15,40,"Unlike a chain shirt, chainmail covers the legs and arms of the wearer. The suit includes gauntlets."),
	BREASTPLATE("Breastplate","Medium Armor",200,6,3,-4,25,20,15,30,"Covering only the torso, a breastplate is made up of a single piece of sculpted metal."),
	BREASTPLATE_AGILE("Breastplate (Agile)","Medium Armor",400,6,3,-4,25,20,15,25,"This breastplate is specially crafted in a manner that allows extra maneuverability for some physical activities.<br>Benefit: The armor check penalty for Climb checks and Acrobatics checks made to jump is only –1 (masterwork and mithral versions of this armor reduce this penalty as well as the normal penalty)."),
	SPLINT_MAIL("Splint Mail","Heavy Armor",200,7,0,-7,40,20,15,45,"Splint mail is made up of metal strips, like banded mail. The suit includes gauntlets."),
	BANDED_MAIL("Banded Mail","Heavy Armor",250,7,1,-6,35,20,15,35,"Banded mail is made up of overlapping strips of metal, fastened to a leather backing. The suit includes gauntlets."),
	FIELD_PLATE("Field Plate","Heavy Armor",1200,7,1,-5,35,20,15,50,"This heavy armor is similar to full plate but lighter in construction, sacrificing a bit of protection for greater flexibility and mobility.<br>Benefit: Field plate is effectively the same as masterwork banded mail. You can purchase masterwork field plate."),
	HALF_PLATE("Half-Plate","Heavy Armor",600,8,0,-7,40,20,15,50,"Combining elements of full plate and chainmail, half-plate includes gauntlets and a helm."),
	HALF_PLATE_AGILE("Half-Plate (Agile)","Heavy Armor",850,8,0,-7,40,20,15,55,"This style of half-plate is specially crafted in a manner that allows extra maneuverability for some physical activities.<br>Benefit: The armor check penalty for Climb checks and jump checks is only –4 (masterwork and mithral versions of this armor reduce this penalty as well as the normal penalty). In addition, unlike most heavy armors, the wearer can still run at quadruple speed instead of triple speed."),
	FULL_PLATE("Full Plate","Heavy Armor",1500,9,1,-6,35,20,15,50,"This metal suit includes gauntlets, heavy leather boots, a visored helmet, and a thick layer of padding that is worn underneath the armor. Each suit of full plate must be individually fitted to its owner by a master armorsmith, although a captured suit can be resized to fit a new owner at a cost of 200 to 800 (2d4 × 100) gold pieces."),
	HELLKNIGHT_PLATE("Hellknight Plate","Heavy Armor",200,9,1,-5,35,20,15,50,"These distinctive suits of armor are a special type of masterwork full plate that, when worn by a character with levels in the Hell Knight Commander prestige class, grants additional effects."),
	STONEPLATE("Stoneplate","Heavy Armor",1800,9,1,-6,35,15,10,75,"Crafted by dwarven stonesmiths from alchemically strengthened plates of basalt primarily for use by dwarven druids, stoneplate is heavy and unwieldy, but offers incredible protection to its wearer."),
	BUCKLER("Buckler","Shield",5,1,-1,-1,5,-1,-1,5,"Benefit: This small metal shield is worn strapped to your forearm. You can use a bow or crossbow without penalty while carrying it. You can also use your shield arm to wield a weapon (whether you are using an offhand weapon or using your off hand to help wield a two-handed weapon), but you take a –1 penalty on attack rolls while doing so. This penalty stacks with those that may apply for fighting with your off hand and for fighting with two weapons. In any case, if you use a weapon in your off hand, you lose the buckler’s Armor Class bonus until your next turn. You can cast a spell with somatic components using your shield arm, but you lose the buckler’s Armor Class bonus until your next turn. You can’t make a shield bash with a buckler."),
	KLAR("Klar","Shield",12,1,-1,-1,5,-1,-1,6,"The traditional form of this tribal weapon is a short blade bound to the skull of a large horned lizard but but a skill smith can craft one entirely out of metal.<br>Benefit: A traditional klar counts as a light wooden shield with armor spikes. A metal klar counts as a light steel shield with armor spikes."),
	MADU_LEATHER("Madu, Leather","Shield",30,1,-1,-2,5,-1,-1,5,"The madu is a round, light shield with four spikes extending from the sides.<br>Benefit: If you are proficient with the madu, you may wield it and fight defensively with a –2 penalty instead of the normal–4 penalty for fighting defensively, and your attack penalty for using Combat Expertise improves by +1 (minimum –1 penalty). You cannot hold anything else in the hand that bears a madu. If you are not proficient in madu, treat it as a light spiked shield."),
	MADU_STEEL("Madu, Steel","Shield",40,1,-1,-2,5,-1,-1,6,"The madu is a round, light shield with four spikes extending from the sides.<br>Benefit: If you are proficient with the madu, you may wield it and fight defensively with a –2 penalty instead of the normal–4 penalty for fighting defensively, and your attack penalty for using Combat Expertise improves by +1 (minimum –1 penalty). You cannot hold anything else in the hand that bears a madu. If you are not proficient in madu, treat it as a light spiked shield."),
	LIGHT_WOODEN("Light Wooden","Shield",3,1,-1,-1,5,-1,-1,5,"You strap a shield to your forearm and grip it with your hand. A light shield's weight lets you carry other items in that hand, although you cannot use weapons with it<br>Benefit: Wooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to some spells and effects.<br>Shield Bash Attacks: You can bash an opponent with a light shield. See “shield, light” on Table: Weapons for the damage dealt by a shield bash. Used this way, a light shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a light shield as a light weapon. If you use your shield as a weapon, you lose its Armor Class bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right."),
	LIGHT_WOODEN_QUICKDRAW("Light Wooden (Quickdraw)","Shield",53,1,-1,-2,5,-1,-1,6,"This light shield is specially crafted with a series of straps to allow a character proficient in shields to ready or stow it on his or her back quickly and easily.<br>" +
			"<br>" +
			"Benefit: If you have a base attack bonus of +1 or higher, you may don or put away a quickdraw shield as a swift action combined with a regular move. If you have the Two-Weapon Fighting feat, you can draw a light or one-handed weapon with one hand and a quickdraw shield with the other in the time it would normally take you to draw one weapon. If you have the Quick Draw feat, you may don or put away a quickdraw shield as a free action."),
	LIGHT_STEEL("Light Steel","Shield",9,1,-1,-1,5,-1,-1,7,"You strap a shield to your forearm and grip it with your hand. A light shield's weight lets you carry other items in that hand, although you cannot use weapons with it.<br>" +
			"<br>" +
			"Benefit:<br>" +
			"<br>" +
			"Wooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to some spells and effects.<br>" +
			"<br>" +
			"Shield Bash Attacks: You can bash an opponent with a light shield. See “shield, light” on Table: Weapons for the damage dealt by a shield bash. Used this way, a light shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a light shield as a light weapon. If you use your shield as a weapon, you lose its Armor Class bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right."),
	LIGHT_STEEL_QUICKDRAW("Light Steel (Quickdraw)","Shield",59,1,-1,-2,5,-1,-1,7,"This light shield is specially crafted with a series of straps to allow a character proficient in shields to ready or stow it on his or her back quickly and easily.<br>" +
			"<br>" +
			"Benefit: If you have a base attack bonus of +1 or higher, you may don or put away a quickdraw shield as a swift action combined with a regular move. If you have the Two-Weapon Fighting feat, you can draw a light or one-handed weapon with one hand and a quickdraw shield with the other in the time it would normally take you to draw one weapon. If you have the Quick Draw feat, you may don or put away a quickdraw shield as a free action."),
	HEAVY_WOODEN("Heavy Wooden","Shield",7,2,-1,-2,15,-1,-1,10,"You strap a shield to your forearm and grip it with your hand. A heavy shield is so heavy that you can't use your shield hand for anything else.<br>" +
			"<br>" +
			"Benefit:<br>" +
			"<br>" +
			"Wooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to spells and effects.<br>" +
			"<br>" +
			"Shield Bash Attacks: You can bash an opponent with a heavy shield. See “shield, heavy” on Table: Weapons for the damage dealt by a shield bash. Used this way, a heavy shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon. If you use your shield as a weapon, you lose its Armor Class bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right."),
	HEAVY_STEEL("Heavy Steel","Shield",20,2,-1,-2,15,-1,-1,15,"You strap a shield to your forearm and grip it with your hand. A heavy shield is so heavy that you can't use your shield hand for anything else.<br>" +
			"<br>" +
			"Benefit:<br>" +
			"<br>" +
			"Wooden or Steel: Wooden and steel shields offer the same basic protection, though they respond differently to spells and effects.<br>" +
			"<br>" +
			"Shield Bash Attacks: You can bash an opponent with a heavy shield. See “shield, heavy” on Table: Weapons for the damage dealt by a shield bash. Used this way, a heavy shield is a martial bludgeoning weapon. For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon. If you use your shield as a weapon, you lose its Armor Class bonus until your next turn. An enhancement bonus on a shield does not improve the effectiveness of a shield bash made with it, but the shield can be made into a magic weapon in its own right."),
	TOWER("Tower","Shield",30,4,2,-1,50,-1,-1,45,"This massive wooden shield is nearly as tall as you are.<br>" +
			"<br>" +
			"Benefit: In most situations, a tower shield provides the indicated shield bonus to your Armor Class. As a standard action, however, you can use a tower shield to grant you total cover until the beginning of your next turn. When using a tower shield in this way, you must choose one edge of your space. That edge is treated as a solid wall for attacks targeting you only. You gain total cover for attacks that pass through this edge and no cover for attacks that do not pass through this edge (see Combat). The shield does not, however, provide cover against targeted spells; a spellcaster can cast a spell on you by targeting the shield you are holding. You cannot bash with a tower shield, nor can you use your shield hand for anything else.<br>" +
			"<br>" +
			"When employing a tower shield in combat, you take a –2 penalty on attack rolls because of the shield's encumbrance."),
	ARMOR_SPIKES("Armor Spikes","Extra",50,0,-1,0,0,-1,-1,10,"Armor spikes deal extra piercing damage (see “spiked armor” on Table: Weapons) on a successful grapple attack. The spikes count as a martial weapon. If you are not proficient with them, you take a –4 penalty on grapple checks when you try to use them. You can also make a regular melee attack (or off-hand attack) with the spikes, and they count as a light weapon in this case. (You can't also make an attack with armor spikes if you have already made an attack with another off-hand weapon, and vice versa.) An enhancement bonus to a suit of armor does not improve the spikes' effectiveness, but the spikes can be made into magic weapons in their own right."),
	LOCKED_GUAUTLET("Locked Gauntlet","Extra",8,0,-1,0,0,-1,-1,5,"This armored gauntlet has small chains and braces that allow the wearer to attach a weapon to the gauntlet so that it cannot be dropped easily.<br>" +
			"<br>" +
			"It provides a +10 bonus to your Combat Maneuver Defense to keep from being disarmed in combat. Removing a weapon from a locked gauntlet or attaching a weapon to a locked gauntlet is a full-round action that provokes attacks of opportunity.<br>" +
			"<br>" +
			"The price given is for a single locked gauntlet. The weight given applies only if you're wearing a breastplate, light armor, or no armor. Otherwise, the locked gauntlet replaces a gauntlet you already have as part of the armor.<br>" +
			"<br>" +
			"While the gauntlet is locked, you can't use the hand wearing it for casting spells or employing skills. (You can still cast spells with somatic components, provided that your other hand is free.)<br>" +
			"<br>" +
			"Like a normal gauntlet, a locked gauntlet lets you deal lethal damage rather than nonlethal damage with an unarmed strike."),
	SHIELD_BOSS_BREAKAWAY("Shield Boss, Breakaway","Extra",120,0,-1,0,0,-1,-1,10,"A shield boss is a sturdy steel device that fastens to the front of a shield, providing metal support struts that radiate outward from the center of the shield, reinforcing its structure. A shield boss can be added to a buckler, light steel or wooden shield, or heavy steel or wooden shield. Tower shields are too large for a typical shield boss, though one can be crafted to fit a tower shield for an additional 300 gp. Attaching or removing a shield boss requires 10 minutes of work and a successful DC 15 Craft (armor) check; on a failure, the shield boss is not successfully attached or removed and the shield takes 1d6 points of damage that bypasses any hardness.<br>Breakaway Boss: The metal stud at the center of the reinforcing boss holds a compartment large enough to insert a single splash weapon, such as a vial of acid or alchemist's fire, as a full-round action. On a successful shield bash attack, the weapon vial breaks and deals damage to the target as though it were directly hit by the splash weapon. The shield takes the normal amount of splash damage for being adjacent to the target, but no other creatures adjacent to the target take splash damage from this effect. A new splash weapon must be inserted into the breakaway boss for it to be used again."),
	SHIELD_BOSS_HOOKED("Shield Boss, Hooked","Extra",80,0,-1,0,0,-1,-1,10,"A shield boss is a sturdy steel device that fastens to the front of a shield, providing metal support struts that radiate outward from the center of the shield, reinforcing its structure. A shield boss can be added to a buckler, light steel or wooden shield, or heavy steel or wooden shield. Tower shields are too large for a typical shield boss, though one can be crafted to fit a tower shield for an additional 300 gp. Attaching or removing a shield boss requires 10 minutes of work and a successful DC 15 Craft (armor) check; on a failure, the shield boss is not successfully attached or removed and the shield takes 1d6 points of damage that bypasses any hardness.<br>Hooked Boss: The struts on this reinforcing boss bear large, sturdy hooks, which can be used to snag an opponent's clothing or armor, causing it to stumble. You can attempt trip combat maneuver checks with this shield. If the combat maneuver check is successful, the opponent does not fall prone, but is considered flat-footed until the beginning of its next turn."),
	SHIELD_BOSS_ILLUMINATING("Shield Boss, Illuminating","Extra",35,0,-1,0,0,-1,-1,10,"A shield boss is a sturdy steel device that fastens to the front of a shield, providing metal support struts that radiate outward from the center of the shield, reinforcing its structure. A shield boss can be added to a buckler, light steel or wooden shield, or heavy steel or wooden shield. Tower shields are too large for a typical shield boss, though one can be crafted to fit a tower shield for an additional 300 gp. Attaching or removing a shield boss requires 10 minutes of work and a successful DC 15 Craft (armor) check; on a failure, the shield boss is not successfully attached or removed and the shield takes 1d6 points of damage that bypasses any hardness.<br>Illuminating Boss: The stud at the center of this reinforcing boss contains a covered slot large enough to insert a sunrod. Installing a lit sunrod into an illuminating boss is a full-round action. If you shake the shield firmly as a move action, you can flip a metal flap fitted over the slot to conceal or reveal the sunrod's glow."),
	SHIELD_BOSS_MASTERWORK("Shield Boss, Masterwork","Extra",50,0,-1,0,0,-1,-1,0,"A shield boss is a sturdy steel device that fastens to the front of a shield, providing metal support struts that radiate outward from the center of the shield, reinforcing its structure. A shield boss can be added to a buckler, light steel or wooden shield, or heavy steel or wooden shield. Tower shields are too large for a typical shield boss, though one can be crafted to fit a tower shield for an additional 300 gp. Attaching or removing a shield boss requires 10 minutes of work and a successful DC 15 Craft (armor) check; on a failure, the shield boss is not successfully attached or removed and the shield takes 1d6 points of damage that bypasses any hardness.<br>Masterwork Boss: Any of the bosses listed above, including the basic reinforcing boss, can be masterwork. A masterwork reinforcing boss increases the shield's current and maximum hit points by 15 instead of 10 and doesn't increase the attack roll penalty."),
	SHIELD_BOSS_REINFORCING("Shield Boss, Reinforcing","Extra",30,0,-1,0,0,-1,-1,10,"A shield boss is a sturdy steel device that fastens to the front of a shield, providing metal support struts that radiate outward from the center of the shield, reinforcing its structure. A shield boss can be added to a buckler, light steel or wooden shield, or heavy steel or wooden shield. Tower shields are too large for a typical shield boss, though one can be crafted to fit a tower shield for an additional 300 gp. Attaching or removing a shield boss requires 10 minutes of work and a successful DC 15 Craft (armor) check; on a failure, the shield boss is not successfully attached or removed and the shield takes 1d6 points of damage that bypasses any hardness.<br>" +
			"<br>" +
			"A reinforcing boss provides extra protection to a shield, increasing the shield's current and maximum hit points by 10. The boss makes the shield 10 pounds heavier and more unwieldy—if the shield imposes a penalty on attack rolls, as do bucklers and tower shields, the penalty increases by 1. Common improvements to the basic reinforcing boss include the following."),
	SHIELD_SPIKES("Shield Spikes","Extra",10,0,-1,0,0,-1,-1,5,"Benefit: These spikes turn a shield into a martial piercing weapon and increase the damage dealt by a shield bash as if the shield were designed for a creature one size category larger than you (see “spiked shields” on Table: Weapons). You can't put spikes on a buckler or a tower shield. Otherwise, attacking with a spiked shield is like making a shield bash attack.<br>" +
			"<br>" +
			"An enhancement bonus on a spiked shield does not improve the effectiveness of a shield bash made with it, but a spiked shield can be made into a magic weapon in its own right."),
	SHIELD_THROWING("Throwing Shield","Extra",50,0,-1,0,0,-1,-1,0,"Benefit: This shield is designed for throwing and has specially designed straps allowing you to unclasp and throw it as a free action. Tower shields cannot be throwing shields. Neither a shield’s enhancement bonus to AC nor its shield spikes apply on your attack or damage rolls.");

	private final String name;
	private final String type;
	private final int cost;
	private final int acBonus;
	private final int maxDex;
	private final int spellFail;
	private final int acPen;
	private final int speedFromThirty;
	private final int speedFromTwenty;
	private final double weight;
	private final String description;

	ArmorEnum(String name,String type, int cost, int acBonus, int maxDex, int acPen, int spellFail, int speedFromThirty, int speedFromTwenty, double weight, String description){
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.acBonus = acBonus;
		this.maxDex = maxDex;
		this.acPen = acPen;
		this.spellFail = spellFail;
		this.speedFromThirty = speedFromThirty;
		this.speedFromTwenty = speedFromTwenty;
		this.weight = weight;
		this.description = description;
	}

	public String toString(){
		return name;
	}

	public int getMaxDex(){
		return maxDex;
	}

	public int getACPen(){
		return acPen;
	}

	public int getACBoost(){
		return acBonus;
	}

	public int[] cost(){
		return new int[]{0, cost, 0, 0};
	}

	public double weight(){
		return weight;
	}

	public int speedChange(int initialSpeed){
		if(initialSpeed == 20) return speedFromTwenty;
		if(initialSpeed == 30) return speedFromThirty;

		return (int)(((30.0/speedFromThirty + 20.0/speedFromTwenty)/2) * initialSpeed);
	}

	public String getFormattedDetails(){
		String toReturn = toString() + "<br>";
		toReturn += "Armor/Shield bonus: " + acBonus + "<br>";
		toReturn += "AC Penalty: " + acPen + " &nbsp; &nbsp; &nbsp; &nbsp; Max Dex Bonus: " + maxDex + " &nbsp; &nbsp; &nbsp; &nbsp; Spell Failure: " + spellFail + "%<br>";
		toReturn += "Speed from 30ft: " + speedFromThirty + "ft &nbsp; &nbsp; &nbsp; &nbsp; Speed from 20ft: " + speedFromTwenty + "ft<br>";
		toReturn += "Cost: " + cost + " gold &nbsp; &nbsp; &nbsp; &nbsp; Weight: " + weight + "lbs<br>";
		toReturn += "<br><br>";
		toReturn += description;
		return toReturn;
	}

	public String getInventoryLine(){
		return toString();
	}

	public int getPurchaseAmount(){
		return 1;
	}

	public String getItemName(){
		return name;
	}

	public String type(){
		return type;
	}

	public int spellFail(){
		return spellFail;
	}

	public URL getIcon(){
		//Light, Medium, Heavy, Shield, Extra
		if(type.equals("Light Armor")){
			return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/A_Clothing02.png");
		}
		if(type.equals("Medium Armor")){
			return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/A_Armor04.png");
		}
		if(type.equals("Heavy Armor")){
			return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/A_Armour02.png");
		}
		if(type.equals("Shield")){
			return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/E_Wood03.png");
		}
		return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/SwordShieldImageIcon.png");
	}
}