package src.items;

import java.io.Serializable;
import java.net.URL;

/**
 * Created by Matthew on 6/17/2016.
 */
public enum WeaponEnum implements Serializable, Item {
    GAUNTLET("Gauntlet","Simple","Unarmed",2,"1d2","1d3", 20,new int[]{2},0,1, "Bludgeoning", "","CRB", "Benefit: This metal glove lets you deal lethal damage rather than nonlethal damage with unarmed strikes. A strike with a gauntlet is otherwise considered an unarmed attack. Your opponent cannot use a disarm action to disarm you of gauntlets.<br>" +
            "<br>" +
            "Note: The cost and weight given are for a single gauntlet. Medium and heavy armors (except breastplate) come with gauntlets. <br>" +
            "<br>" +
            "Weapon Feature(s): cannot be disarmed", 1),
    BATTLE_ASPERGILLUM("Battle aspergillum","Simple","Light",5,"1d4","1d6", 20,new int[]{2},0,4, "Bludgeoning", "see text","APG", "Named for the common aspergillum, a mace-like tool used by priests to sprinkle holy water, this light mace has a hollow head and a metal plug to fit the hollow’s neck. <br>" +
            "<br>" +
            "Benefit: When the mace strikes a creature, holy water sprinkles out through tiny holes throughout the weapon’s head; creatures subject to damage from holy water take 1 point of damage in addition to the normal effect of being struck by the mace (a nonmagical aspergillum can deal holy water damage to an incorporeal creature in this manner, even if the mace itself deals no damage). After 5 hits, the battle aspergillum is empty and needs to be refilled.<br>" +
            "<br>" +
            "Filling it with holy water is a standard action that provokes an attack of opportunity (like drinking a potion). A filled aspergillum is normally carried upright, otherwise the holy water leaks out as the weapon moves.", 1),
    BRASS_KNIFE("Brass Knife", "Simple", "Light", 2, "1d3", "1d4", 19, new int[]{2},10,1,"Piercing or Bludgeoning","fragile","PPC","Pirates often carry long brass knives for working aboard a ship. Though brass doesn’t hold as sharp an edge as steel, it isn’t vulnerable to rust like steel is. In a pinch, a pirate can use his brass knife as a weapon. Mostly, though, they are used for cutting ropes, cleaning fish, and other sundry tasks.<br>" +
            "<br>" +
            "A brass knife has the fragile quality. A fragile weapon gains the broken condition if the wielder rolls a natural 1 on an attack roll with the weapon. If a fragile weapon is already broken, rolling a natural 1 destroys it instead.",1),
    BRASS_KNUCKLES("Brass knuckles","Simple","Light",1,"1d2","1d3", 20,new int[]{2},0,1, "Bludgeoning", "monk, see text","AA", "These close combat weapons are designed to fit comfortably around the knuckles, narrowing the contact area and therefore magnifying the amount of force delivered by a punch.<br>" +
            "<br>" +
            "Benefit: Brass knuckles allow you to deal lethal damage.<br>" +
            "<br>" +
            "Drawback: You may hold, but not wield, a weapon or other object in a hand wearing brass knuckles. You may cast a spell with a somatic component while wearing brass knuckles if you make a concentration check (DC 10 + the level of the spell you’re casting).<br>" +
            "<br>" +
            "Note: Monks are proficient with brass knuckles.", 1),
    CESTUS("Cestus","Simple","Light",5,"1d3","1d4", 19,new int[]{2},0,1, "Bludgeoning or Piercing", "monk","APG", "The cestus is a glove of leather or thick cloth that covers the wielder from mid-finger to mid-forearm. The close combat weapon is reinforced with metal plates over the fingers and often lined with wicked spikes along the backs of the hands and wrists.<br>" +
            "<br>" +
            "Benefit: While wearing a cestus, you are considered armed and your unarmed attacks deal normal damage. If you are proficient with a cestus, your unarmed strikes may deal bludgeoning or piercing damage. Monks are proficient with the cestus.<br>" +
            "<br>" +
            "Drawback: When using a cestus, your fingers are mostly exposed, allowing you to wield or carry items in that hand, but the constriction of the weapon at your knuckles gives you a –2 penalty on all precision-based tasks involving that hand (such as opening locks).<br>" +
            "<br>" +
            "Weapon Feature(s): monk", 1),
    DAGGER("Dagger","Simple","Light",2,"1d3","1d4", 19,new int[]{2},10,1, "Piercing or Slashing", "","CRB", "A dagger has a blade that is about 1 foot in length.<br>" +
            "<br>" +
            "Benefit: You get a +2 bonus on Sleight of Hand skill checks made to conceal a dagger on your body (see Using Skills).", 1),
    DAGGER_PUNCHING("Dagger, punching","Simple","Light",2,"1d3","1d4", 20,new int[]{3},0,1, "Piercing", "","CRB","A punching dagger's blade is attached to a horizontal handle that projects out from the fist when held.", 1),
    GAUNTLET_SPIKED("Gauntlet, spiked","Simple","Light",5,"1d3","1d4", 20,new int[]{2},0,1, "Piercing", "","CRB", "Benefit: An attack with a spiked gauntlet is considered an armed attack. Your opponent cannot use a disarm action to disarm you of spiked gauntlets.<br>" +
            "<br>" +
            "Note: The cost and weight given are for a single gauntlet.<br>" +
            "<br>" +
            "Weapon Feature(s): cannot be disarmed", 1),
    HANBO("Hanbo","Simple","Light",1,"1d4","1d6", 20,new int[]{2},0,2, "Bludgeoning", "monk, trip","AA", "The hanbo is a staff less than a yard long, often carved to look like a walking stick.<br>" +
            "<br>" +
            "Weapon Feature(s): monk, trip", 1),
    HOOK_HAND("Hook Hand", "Simple", "Light", 10, "1d3", "1d4", 20, new int[]{2}, 0, 1, "Slashing", "disarm", "PPC", "Pirates who lose a hand in the course of their adventures sometimes attach hooks to their wrists.<br>" +
            "<br>" +
            "Your opponent cannot use a disarm action to disarm you of a hook hand. Hook hands generally do not interfere with routine activities, but you cannot use another weapon two-handed if you have a hook hand attached. You cannot use any type of weapon if both your hands are hook hands, and you may have trouble with routine activities.<br>" +
            "<br>" +
            "Hook hands presume that the wrist joint is intact. If the wrist joint is not intact, use the prosthesis statistics instead. It takes 1 minute to attach or detach a hook hand.", 1),
    KUNAI("Kunai","Simple","Light",2,"1d3","1d4",20,new int[]{2},10,2,"Bludgeoning or Piercing", "", "PPC", "Crafted from a single piece of iron, a kunai has a leaf-shaped blade and a ring for a pommel. Adapted from the common trowel, the kunai has a thick blade that is sharpened only near the tip.<br>" +
            "<br>" +
            "Benefit(s) Unlike finer weapons, the kunai can readily substitute for a crowbar or piton without being damaged in the process.", 1),
    MACE_LIGHT("Mace, light","Simple","Light",5,"1d4","1d6", 20,new int[]{2},0,4, "Bludgeoning", "","CRB", "A light mace is made up of an ornate metal head attached to a simple wooden or metal shaft.", 1),
    SICKLE("Sickle","Simple","Light",6,"1d4","1d6", 20,new int[]{2},0,2, "Slashing", "trip","CRB", "Weapon Feature(s): trip", 1),
    SPRING_BLADE("Spring blade", "Simple", "Light", 70, "1d3", "1d4", 20, new int[]{2}, 10, 1, "Piercing or Slashing", "", "PRG:UI", "Price 70 gp; Weight 1 lb.<br>" +
            "<br>" +
            "This 4-inch blade is attached via a hinge to a wooden handle with a slot in the center, into which the blade can be folded. With a click of a switch, a spring thrusts the blade outward, where it locks into place until it is reset. Releasing the blade is a free action, and resetting it is a move action. The handle must be in your hand for the blade to be released; placing it in your hand requires the same type of action as drawing a weapon. A spring blade is easy to conceal: an observer must succeed at a DC 20 Perception check to notice the blade hidden within the wooden handle, and you gain a +4 bonus on Sleight of Hand checks to conceal a spring blade on your body.", 1),
    WOODEN_STAKE("Wooden stake","Simple","Light",0,"1d3","1d4", 20,new int[]{2},10,1, "Piercing", "","APG", "This close combat weapon is just a sharpened piece of wood.<br>" +
            "<br>" +
            "Note: Iron spikes used as weapons deal damage as wooden stakes.", 1),
    CLUB("Club","Simple","One-Handed",0,"1d4","1d6", 20,new int[]{2},10,3, "Bludgeoning", "","CRB", "This weapon is usually just a shaped piece of wood, sometimes with a few nails or studs embedded in it.", 1),
    CLUB_MERE("Club, mere","Simple","One-Handed",2,"1d3","1d4", 20,new int[]{2},0,2, "Bludgeoning or Piercing", "fragile","AA", "Traditionally made of carved stone, the mere (MEH-reh) is a short, flat-sided, sharp-pointed club.", 1),
    COMBAT_SCABBARD("Combat scabbard","Simple","One-Handed",1,"1d4","1d6", 20,new int[]{2},0,1, "Bludgeoning", "improvised, see text","AA", "Benefit: This combat scabbard has a sharp blade on the outer edge, allowing you to use it as a weapon.", 1),
    MACE_HEAVY("Mace, heavy","Simple","One-Handed",12,"1d6","1d8", 20,new int[]{2},0,8, "Bludgeoning", "","CRB", "A heavy mace has a larger head and a longer handle than a normal (light) mace.", 1),
    MORNINGSTAR("Morningstar","Simple","One-Handed",8,"1d6","1d8", 20,new int[]{2},0,6, "Bludgeoning and Piercing", "","CRB", "A morningstar is a spiked metal ball, affixed to the top of a long handle.", 1),
    SHORTSPEAR("Shortspear","Simple","One-Handed",1,"1d4","1d6", 20,new int[]{2},20,3, "Piercing", "","CRB", "A shortspear is about 3 feet in length, making it a suitable thrown weapon.", 1),
    BAYONET("Bayonet","Simple","Two-Handed",5,"1d4","1d6", 20,new int[]{2},0,1, "Piercing", "","APG", "Bayonets are close combat weapons designed to fit into the grooves or muzzles of crossbows and firearms.<br>" +
            "<br>" +
            "Benefit: Bayonets allow you to make melee attacks with these weapons but render them temporarily useless as ranged weapons.<br>" +
            "<br>" +
            "Attach/Remove: Attaching or removing a bayonet is a move action.", 1),
    BOARDING_PIKE("Boarding pike", "Simple", "Two-Handed", 8, "1d6", "1d8", 20, new int[]{3}, 0, 9, "Piercing", "Brace, Reach", "PPC:Pirates", "A boarding pike is an 8-foot-long pole topped with a foot-long tapered metal tip. Boarding pikes look much like longspears, but the metal pike is designed to flow into the wooden haft, leaving no grooves, collars, or spikes that could trap salt water and cause rust. Boarding pikes are mainly used defensively, to repel boarding actions. The pikes are kept in brackets around the mast, so sailors can quickly grab pikes and brace them against the gunwale to repel boarders.", 1),
    KUMADE("Kumade", "Simple", "Two-Handed", 5, "1d4", "1d6", 20, new int[]{3}, 0, 4, "Piercing", "Grapple", "PPC:MTT", "Adapted from a garden rake, the kumade consists of a wood or bamboo pole topped with a metal claw. The rake head doubles as a grappling hook. When a kumade is secured to a surface, such as a rafter or window sill, its handle can be climbed as a 5-foot length of rope.", 1),
    KUMADE_COLLAPSIBLE("Kumade, collapsible", "Simple", "Two-Handed", 10, "1d4", "1d6", 20, new int[]{3}, 0, 4, "Piercing", "Grapple", "PPC:MTT","This weapon acts as a kumade, but the handle consists of bamboo sections held together by a taut rope running through the center. Releasing the rope is a standard action that provokes attacks of opportunity and causes the weapon to collapse into a bundle that fits into a backpack. Reassembling the collapsible kumade requires a full-round action that provokes attacks of opportunity.", 1),
    LONGSPEAR("Longspear","Simple","Two-Handed",5,"1d6","1d8", 20,new int[]{3},0,9, "Piercing", "brace, reach","CRB", "A longspear is about 8 feet in length.<br>" +
            "<br>" +
            "Weapon Feature(s): brace, reach", 1),
    QUARTERSTAFF("Quarterstaff","Simple","Two-Handed",0,"4/1d4","6/1d6", 20,new int[]{2},0,4, "Bludgeoning", "double, monk","CRB", "A quarterstaff is a simple piece of wood, about 5 feet in length.<br>" +
            "<br>" +
            "Weapon Feature(s): double, monk", 1),
    SPEAR("Spear","Simple","Two-Handed",2,"1d6","1d8", 20,new int[]{3},20,6, "Piercing", "brace","CRB", "A spear is 5 feet in length and can be thrown.", 1),
    SPEAR_BOAR("Spear, boar","Simple","Two-Handed",5,"1d6","1d8", 20,new int[]{2},0,8, "Piercing", "brace, see text","APG", "This spear with a spiraling blade has a metal crossbar approximately halfway down its length. <br>" +
            "<br>" +
            "Benefit:If you ready a boar spear against a charge and your attack hits, you get a +2 shield bonus to your AC against that creature until your next turn.", 1),
    SPEAR_WEIGHTED("Spear, weighted", "Simple", "Two-Handed", 10, "1d6/1d4","1d8/1d6",20, new int[]{3,2}, 0, 8, "Bludgeoning or Piercing", "Brace, Double", "PPC:MTT", "This pole has a spear head at one end and a mace head at the other. It can be wielded like a standard spear (though it isn't balanced for throwing), or it can be used as a double weapon, alternately thrusting and bashing.", 1),
    BLOWGUN("Blowgun","Simple","Ranged",2,"1","1d2", 20,new int[]{2},20,1, "Piercing", "","CRB", "Blowguns are generally used to deliver debilitating (but rarely fatal) poisons from a distance. They are nearly silent when fired.<br>" +
            "<br>" +
            "For a list of appropriate poisons, see Poison.", 1),
    CROSSBOW_HEAVY("Crossbow, heavy","Simple","Ranged",50,"1d8","1d10", 19,new int[]{2},120,8, "Piercing", "","CRB", "Load: Loading a heavy crossbow is a full-round action that provokes attacks of opportunity.<br>" +
            "<br>" +
            "Note: You draw a heavy crossbow back by turning a small winch. Normally, operating a heavy crossbow requires two hands. However, you can shoot, but not load, a heavy crossbow with one hand at a –4 penalty on attack rolls. You can shoot a heavy crossbow with each hand, but you take a penalty on attack rolls as if attacking with two one-handed weapons. This penalty is cumulative with the penalty for one-handed firing.", 1),
    CROSSBOW_HEAVY_UNDERWATER("Crossbow, heavy (underwater)","Simple","Ranged",100,"1d8","1d10", 19,new int[]{2},120,8, "Piercing", "","CRB", "Race Merfolk<br>" +
            "<br>" +
            "Benefit: An underwater crossbow functions like its normal counterpart above water, and can be used underwater. When fired underwater, the crossbow has a range increment of 20 feet. Anyone proficient with a normal crossbow can use an underwater crossbow.", 1),
    CROSSBOW_LIGHT("Crossbow, light","Simple","Ranged",35,"1d6","1d8", 19,new int[]{2},80,4, "Piercing", "","CRB", "Load: Loading a light crossbow is a move action that provokes attacks of opportunity.<br>" +
            "<br>" +
            "Note: You draw a light crossbow back by pulling a lever. Normally, operating a light crossbow requires two hands. However, you can shoot, but not load, a light crossbow with one hand at a –2 penalty on attack rolls. You can shoot a light crossbow with each hand, but you take a penalty on attack rolls as if attacking with two light weapons. This penalty is cumulative with the penalty for one-handed firing.", 1),
    CROSSBOW_LIGHT_UNDERWATER("Crossbow, light (underwater)","Simple","Ranged",70,"1d6","1d8", 19,new int[]{2},80,4, "Piercing", "","CRB", "Race Merfolk<br>" +
            "<br>" +
            "Benefit: An underwater crossbow functions like its normal counterpart above water, and can be used underwater. When fired underwater, the crossbow has a range increment of 20 feet. Anyone proficient with a normal crossbow can use an underwater crossbow.", 1),
    DART("Dart","Simple","Ranged",1,"1d3","1d4", 20,new int[]{2},20,0.5, "Piercing", "","CRB", "Darts are missile weapons, designed to fly such that a sharp, often weighted point will strike first. They can be distinguished from javelins by fletching (i.e., feathers on the tail) and a shaft that is shorter and/or more flexible, and from arrows by the fact that they are not of the right length to use with a normal bow.", 2),
    JAVELIN("Javelin","Simple","Ranged",1,"1d4","1d6", 20,new int[]{2},30,2, "Piercing", "","CRB", "A javelin is a thin throwing spear.<br>" +
            "<br>" +
            "Note: Since a javelin is not designed for melee, you are treated as non-proficient with it and take a –4 penalty on attack rolls if you use a javelin as a melee weapon.", 1),
    SLING("Sling","Simple","Ranged",0,"1d3","1d4", 20,new int[]{2},50,0, "Bludgeoning", "","CRB", "A sling is little more than a leather cup attached to a pair of strings.<br>" +
            "<br>" +
            "Description: Your Strength modifier applies to damage rolls when you use a sling, just as it does for thrown weapons. You can fire, but not load, a sling with one hand.<br>" +
            "<br>" +
            "Action: Loading a sling is a move action that requires two hands and provokes attacks of opportunity.<br>" +
            "<br>" +
            "You can hurl ordinary stones with a sling, but stones are not as dense or as round as bullets. Thus, such an attack deals damage as if the weapon were designed for a creature one size category smaller than you and you take a –1 penalty on attack rolls.", 1),
    STINGCHUCK("Stingchuck","Simple","Ranged",0,"1d3","1d4", 20,new int[]{2},10,9, "Bludgeoning", "see text","AA", "A stingchuck is a foul bag made of a humanoid’s head with the brain removed and the skull heavily scored so that it bursts open when thrown.<br>" +
            "<br>" +
            "Description: Normally filled with biting vermin, a stingchuck acts as a splash weapon. When it hits, the vermin bite and sting the target, dealing 1d6 points of damage and forcing a DC 11 Fortitude save to avoid being nauseated for 1d3 rounds. Each round a creature remains nauseated by a stingchuck, it takes 1 additional point of damage from the biting vermin. All creatures within the splash effect take 1 point of damage from the vermin but do not risk being nauseated.", 1),
    STONEBOW("Stonebow", "Simple", "Ranged", 35, "1d4", "1d6", 20, new int[]{2}, 50, 4, "Bludgeoning", "", "PPC:RTT", "A stonebow, or bullet crossbow, resembles a light crossbow except for the distinct U-shaped bend in the stock.<br>" +
            "<br>" +
            "Benefit(s) Instead of bolts, the stonebow shoots sling bullets. The bow has two strings with a leather pocket between them to hold the bullet. Loading a stonebow is a move action (a free action if you have the Rapid Reload feat) that provokes attacks of opportunity.<br>" +
            "<br>" +
            "You can shoot ordinary stones with a stonebow, but stones aren't as dense or as round as bullets. When using stones, you take a –1 penalty on attack rolls and deal damage as if the weapon were designed for a creature one size category smaller than you.<br>" +
            "<br>" +
            "You can shoot, but not load, a stonebow with one hand, but doing so imposes a –2 penalty on your attack rolls.<br>" +
            "<br>" +
            "You can shoot a stonebow with each hand, but you take a penalty on attack rolls as if attacking with two light weapons. This penalty is cumulative with the penalty for firing one-handed.", 1),
    BOLT_CROSSBOW("Bolt, crossbow","Simple","Ammunition",1," "," ", 20,new int[]{},0,1, "", "","CRB", "Benefit: Bolts come in a case or quiver that holds 10 bolts (or 5 for a repeating crossbow).<br>" +
            "<br>" +
            "Special: A crossbow bolt used as a melee weapon is treated as a light improvised weapon (–4 penalty on attack rolls) and deals damage as a dagger of its size (crit ×2).", 10),
    BOLT_ACID("Bolt, acid","Simple","Ammunition",40," "," ", 20,new int[]{},0,0., "", "see text","AP15", "These metal bolts have a glass section in the middle, filled with acid.<br>" +
            "<br>" +
            "Benefit: On a successful hit, acid bolts deal normal damage and 1d4 points of additional acid damage.<br>" +
            "<br>" +
            "Note: Acid bolts do not cause any splash damage.", 1),
    BOLT_DROW_POISON("Bolt, Drow poison","Simple","Ammunition",100," "," ", 20,new int[]{},0,0., "", "see text","AP15", "These iron bolts have small resin tips that break when the bolts strike their targets. Inside is a dose of drow poison.<br>" +
            "<br>" +
            "Benefit: Anyone struck by a drow poison bolt must make a DC 13 Fortitude save or become affected by drow poison. Those using drow poison bolts do not risk poisoning themselves.<br>" +
            "<br>" +
            "Drawback: The strange tip affects the bolts’ accuracy. Double the range penalties when using a drow poison bolt.", 1),
    BOLT_FIRE("Bolt, fire","Simple","Ammunition",50," "," ", 20,new int[]{},0,0., "", "see text","AP15", "These carefully crafted wooden bolts have a hollow core filled with alchemist’s fire.<br>" +
            "<br>" +
            "Benefit: On a successful hit, fire bolts deal normal damage plus 1d4 points of fire damage. <br>" +
            "<br>" +
            "Note: Alchemical fire bolts do not cause any splash damage, and the fire burst isn’t enough to ignite targets (unless they are particularly flammable).", 1),
    BULLET_GROANING("Bullet, groaning","Simple","Ammunition",2," "," ", 20,new int[]{},0,5, "", "see text","AA", "These sling bullets are honeycombed with overlapping perforations that cause them to emit an eerie moan audible within 500 feet of their flight path.", 10),
    BULLET_SLING("Bullet, sling","Simple","Ammunition",1," "," ", 20,new int[]{},0,5, "", "","CRB", "Sling bullets are shaped metal balls, designed to be used with a sling or halfling sling staff.<br>" +
            "<br>" +
            "Benefit: Bullets come in a leather pouch that holds 10 bullets.", 100),
    BULLET_SMOKE("Bullet, smoke","Simple","Ammunition",100," "," ", 20,new int[]{},0,5, "", "see text","PCS", "Benefit: Smoke bullets require only a successful touch attack to release the smoke. When they strike a target, they burst, releasing a cloud of noxious gas that requires the creature struck to attempt a DC 13 Fortitude save. If the save fails, the target is nauseated for 2 rounds.", 10),
    DART_BLOWGUN("Dart, blowgun","Simple","Ammunition",1," "," ", 20,new int[]{},0,1, "", "","CRB", "These light darts have tiny grooves behind the tips.<br>" +
            "<br>" +
            "Benefit: A character can apply poison to a blowgun dart without risk of poisoning himself.", 20),
    AXE_BOARDING("Axe, boarding", "Martial", "Light", 6, "1d4", "1d6", 20, new int[]{3}, 0, 3, "Piercing or Slashing", "", "PPC:Pirates", "Basically a hand axe with a backward-pointing spike, a boarding axe is used to chop through hatches or rigging, to drag burning debris off a ship, or as a weapon. A boarding axe is a one-handed martial weapon that uses the same statistics as a handaxe, except it deals slashing or piercing damage. In addition, the spike grants a +2 circumstance bonus on Climb checks on wooden surfaces.", 1),
    AXE_THROWING("Axe, throwing","Martial","Light",8,"1d4","1d6", 20,new int[]{2},10,2, "Slashing", "","CRB", "Benefit: This is a small axe balanced for throwing.", 1),
    BLADE_BOOT("Blade boot","Martial","Light",25,"1d3","1d4", 20,new int[]{2},0,2, "Piercing", "see text","AA", "Blade boots come with a spring-mounted knife that pops out when triggered with the right combination of toe presses.<br>" +
            "<br>" +
            "Benefit: You can use a blade boot as an off-hand weapon. <br>" +
            "<br>" +
            "Action: Releasing the knife is a swift action; rearming it is a full-round action. <br>" +
            "<br>" +
            "Drawback: When the blade is extended, you treat normal terrain as difficult and difficult terrain as impassable.", 1),
    BUTTERFLY_SWORD("Butterfly sword","Martial","Light",20,"1d3","1d4", 19,new int[]{2},0,1, "Slashing", "monk","UC", "These short matching swords come in pairs, cleverly nested together to appear as a single blade.<br>" +
            "<br>" +
            "Benefit: Both weapons can be drawn at the same time, and they can be separated as a free action and wielded in both hands to make wickedly effective chops and slashes. Their thin, broad blades extend just 1 foot in length. A butterfly sword has a hardwood grip covered with braided cord, and a metal D-shaped guard to protect the wielder’s hand.", 1),
    CAT_O_NINE_TAILS("Cat-o'-nine-tails", "Martial", "Light", 1, "1d3", "1d4", 20, new int[]{2}, 0, 1, "Slashing", "disarm, nonlethal", "PPC:Pirates", "A cat-o’-nine-tails, also known as the “captain’s daughter,” is a short whip made of nine knotted thongs about 3 feet in length, designed to lacerate and inflict great pain without doing serious permanent damage.<br>" +
            "<br>" +
            "A cat-o’-nine-tails deals no damage to any creature with an armor bonus of +1 or higher or a natural armor bonus of +3 or higher.", 1),
    DOGSLICER("Dogslicer","Martial","Light",8,"1d4","1d6", 19,new int[]{2},0,1, "Slashing", "","ISWG", "This short, curved sword is a favorite weapon of goblins, who show unusual cunning by drilling numerous holes in the blade to reduce the weapon's weight.<br>" +
            "<br>" +
            "Special: If a wielder rolls a natural 1 when attacking with a this weapon, the weapon gains the broken condition. Masterwork and magical versions do not have this flaw. Most are sized for Small creatures.", 1),
    GLADIUS("Gladius","Martial","Light",15,"1d4","1d6", 19,new int[]{2},0,3, "Piercing or Slashing", "performance","UC", "The gladius is the favorite short sword of gladiators, with a heavier blade than the standard short sword. It serves well as a slashing weapon.<br>" +
            "<br>" +
            "Benefit: Feats and abilities that affect short swords apply to the gladius.", 1),
    HAMMER_LIGHT("Hammer, light","Martial","Light",1,"1d3","1d4", 20,new int[]{2},20,2, "Bludgeoning", "","CRB", "Weapon Feature(s): melee & ranged", 1),
    HANDAXE("Handaxe","Martial","Light",6,"1d4","1d6", 20,new int[]{3},0,3, "Slashing", "","CRB", "", 1),
    IRON_BRUSH("Iron brush","Martial","Light",2,"1d2","1d3", 20,new int[]{2},10,0, "Piercing", "","UC", "This is an iron-handled version of a scholar’s brush with a sharpened handle.<br>" +
            "<br>" +
            "Benefit: Though it does little damage, it is easily concealed (the wielder gets a +2 bonus on Sleight of Hand skill checks made to conceal a iron brush on her body) and can be used as a jabbing weapon or thrown short distances.", 1),
    JUTTE("Jutte","Martial","Light",8,"1d4","1d6", 20,new int[]{2},0,1, "Bludgeoning", "disarm, monk","UC", "This batonlike weapon is fitted with a metal hook that can be used to block and pin an opponent’s weapon. Some variations are tipped with a sharpened metal spike or blade.", 1),
    KERAMBIT("Kerambit","Martial","Light",2,"1d2","1d3", 20,new int[]{3},0,0, "Slashing", "","UC", "This small, curved pull dagger has a metal loop at the base of its handle allowing it to be secured with a pinky or worn on a string tied in the hair. While relatively small, the curved blade can create brutal wounds.<br>" +
            "<br>" +
            "Benefit: Easily concealed (the wielder gets a +2 bonus on Sleight of Hand skill checks made to conceal a kerambit on her body), it is a favorite concealed weapon of ninja and assassins.", 1),
    KNIFE_SWITCHBLADE("Knife, switchblade","Martial","Light",5,"1d3","1d4", 19,new int[]{2},10,1, "Piercing", "","AA", "This knife has a spring-loaded blade hidden inside the handle.<br>" +
            "<br>" +
            "This weapon is treated as a dagger.<br>" +
            "<br>" +
            "Special: This knife can be designed to look like another type of object (a DC 15 Perception check reveals the deception). <br>" +
            "<br>" +
            "Action: If held in your hand, you can activate it as a free action.", 1),
    KUKRI("Kukri","Martial","Light",8,"1d3","1d4", 18,new int[]{2},0,2, "Slashing", "","CRB", "A kukri is a curved blade, about 1 foot in length.", 1),
    LUNGCHUAN_TAMO("Lungchuan tamo","Martial","Light",5,"1d3","1d4", 20,new int[]{2},10,1, "Piercing or Slashing", "monk","UC", "What appears to be an ordinary baton sheaths a pair of matching slender-bladed daggers, perfectly balanced throwing blades.", 1),
    PICK_LIGHT("Pick, light","Martial","Light",4,"1d3","1d4", 20,new int[]{4},0,3, "Piercing", "","CRB", "The pick is a type of war hammer with a very long spike on the reverse of the hammer head. Usually this spike is slightly curved downwards, much like a miner's pickaxe. The pick is excellent at piercing thick armor or chain mail which a sword would have difficulty penetrating.", 1),
    SAP("Sap","Martial","Light",1,"1d4","1d6", 20,new int[]{2},0,2, "Bludgeoning", "nonlethal","CRB", "The sap is a small, easily-concealed club consisting of a leather-wrapped lead weight attached to the end of a leather-wrapped coil spring or rigid shaft, with a lanyard or strap on the end opposite the weight. Materials other than lead and leather are sometimes used to construct these weapons, but the design of a soft covering over a dense weighted core remain.<br>" +
            "<br>" +
            "Weapon Feature(s): nonlethal", 1),
    SHANG_GOU("Shang gou","Martial","Light",6,"1d3","1d4", 20,new int[]{2},0,1, "Slashing", "disarm or trip (see text), monk","UC", "Forged in pairs, these solid metal blades end in curved hooks, while the hand guards are hammered into outward-facing spiked crescents.<br>" +
            "<br>" +
            "Benefit: Both the crescent and the tip of the hilt are sharpened for combat. They can be wielded as single weapons or with two-weapon fighting styles. The weapons gain the disarm special weapon feature when used individually. A pair of shang gou can also be formed into a single one-handed weapon to gain the trip special feature.", 1),
    SPIKED_ARMOR("Spiked armor","Martial","Light",0,"1d4","1d6", 20,new int[]{2},0,0, "Piercing", "","CRB", "Description: You can outfit your armor with spikes, which can deal damage in a grapple or as a separate attack.", 1),
    SPIKED_SHIELD_LIGHT("Spiked shield, light","Martial","Light",13,"1d3","1d4", 20,new int[]{2},0,0, "Piercing", "","CRB", "Description: You can bash with a spiked shield instead of using it for defense.<br>" +
            "<br>" +
            "Shield Bash Attacks<br>" +
            "<br>" +
            "You can bash an opponent with a shield, using it as an off-hand weapon. Used this way, a shield is a martial bludgeoning weapon.<br>" +
            "<br>" +
            "For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon and treat a light shield as a light weapon.", 1),
    STARKNIFE("Starknife","Martial","Light",24,"1d3","1d4", 20,new int[]{3},20,3, "Piercing", "","CRB", "From a central metal ring, four tapering metal blades extend like points on a compass rose.<br>" +
            "<br>" +
            "Description: A wielder can stab with the starknife or throw it.", 1),
    SWORD_SHORT("Sword, short","Martial","Light",10,"1d4","1d6", 19,new int[]{2},0,2, "Piercing", "","CRB", "A short sword is about 2 feet in length.", 1),
    TONFA("Tonfa","Martial","Light",1,"1d4","1d6", 20,new int[]{2},0,1, "Bludgeoning", "blocking, monk","UC", "These L-shaped fighting sticks are good for striking and blocking combinations. The wielder holds the handle and either spins the stick or strikes with the stick covering the forearm.", 1),
    WAR_RAZOR("War razor","Martial","Light",8,"1d3","1d4", 19,new int[]{2},0,1, "Slashing", "","ISWG", "To all appearances, a war razor is an oversized razor or flip knife. As the razor folds into the handle, no sheath is required, making the weapon easy to hide.<br>" +
            "<br>" +
            "Description: You gain a +2 bonus on Sleight of Hand checks made to conceal the weapon on your body.<br>" +
            "<br>" +
            "Weapon Feature(s): easily concealed", 1),
    WUSHU_DART("Wushu dart","Martial","Light",1,"1d2","1d3", 20,new int[]{2},10,0, "Piercing", "monk","UC", "Benefit: This sharpened wooden spike can be used as a punching weapon but it is perfectly balanced for throwing.", 5),
    BATTLEAXE("Battleaxe","Martial","One-Handed",10,"1d6","1d8", 20,new int[]{3},0,6, "Slashing", "","CRB", "A battle axe (also battle-axe or battle-ax) is an axe specifically designed for combat.<br>" +
            "<br>" +
            "Battle axes are specialized versions of utility axes. Many are suitable for use in one hand, while others are larger and used two-handed. Axes designed for warfare range in weight from just over 0.5 kg to 3 kg (1 to 6 pounds), and in length from just over 30 cm to upwards of 1.5 m (1 to 5 feet). Cleaving weapons longer than 1.5 m would arguably fall into the category of polearms.", 1),
    BROADSWORD_NINE_RING("Broadsword, nine ring","Martial","One-Handed",15,"1d6","1d8", 20,new int[]{3},0,4, "Slashing", "monk","UC", "This broad-bladed weapon has nine heavy rings threaded through its spine, providing additional weight to add to the force of its impressive chopping power.", 1),
    DOUBLE_CHICKEN_SABER("Double chicken saber","Martial","One-Handed",12,"1d4","1d6", 19,new int[]{2},0,3, "Slashing", "disarm, monk","UC", "The tip of this 3-foot-long, straight-bladed sword is bent into two staggered, opposing sharpened spurs that can be used to pull weapons from an opponent’s hands.", 1),
    FLAIL("Flail","Martial","One-Handed",8,"1d6","1d8", 20,new int[]{2},0,5, "Bludgeoning", "disarm, trip","CRB", "A flail consists of a spiked metal ball, connected to a handle by a sturdy chain.<br>" +
            "<br>" +
            "Weapon Feature(s): disarm, trip", 1),
    KLAR("Klar","Martial","One-Handed",12,"1d4","1d6", 20,new int[]{2},0,6, "Slashing", "","ISWG", "The traditional form of this tribal weapon is a short blade bound to the skull of a large horned lizard but but a skill smith can craft one entirely out of metal.<br>" +
            "<br>" +
            "Benefit: A traditional klar counts as a light wooden shield with armor spikes. A metal klar counts as a light steel shield with armor spikes.<br>" +
            "<br>" +
            "Weapon Feature(s): special", 1),
    LONGSWORD("Longsword","Martial","One-Handed",15,"1d6","1d8", 19,new int[]{2},0,4, "Slashing", "","CRB", "A longsword (also spelled long sword, long-sword) is a type of sword characterized as having a cruciform hilt with a grip for two handed use and a straight double-edged blade of around 100–122 cm (39–48 in).<br>" +
            "<br>" +
            "Eastern Version: Hwandudaedo This heavy sword consists of large straight blade with a thick back and wickedly sharpened edge. It is equivalent to a longsword.", 1),
    PICK_HEAVY("Pick, heavy","Martial","One-Handed",8,"1d4","1d6", 20,new int[]{4},0,6, "Piercing", "","CRB", "A larger and heavier form of a light pick.", 1),
    RAPIER("Rapier","Martial","One-Handed",20,"1d4","1d6", 18,new int[]{2},0,2, "Piercing", "","CRB", "Benefit: You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a rapier sized for you, even though it isn't a light weapon.<br>" +
            "<br>" +
            "Drawback: You can't wield a rapier in two hands in order to apply 1-1/2 times your Strength bonus to damage.<br>" +
            "<br>" +
            "Weapon Feature(s): finesse", 1),
    SCABBARD_COMBAT_SHARPENED("Scabbard, combat (sharpened)","Martial","One-Handed",10,"1d4","1d6", 18,new int[]{2},0,1, "Slashing", "see text","AA", "Benefit: This combat scabbard has a sharp blade on the outer edge, allowing you to use it as a weapon.", 1),
    SCIMITAR("Scimitar","Martial","One-Handed",15,"1d4","1d6", 18,new int[]{2},0,4, "Slashing", "","CRB", "A scimitar is a sword with a curved blade.", 1),
    SCIZORE("Scizore","Martial","One-Handed",20,"1d8","1d10", 20,new int[]{2},0,3, "Piercing", "","UC", "The scizore is a hardened tube that fits your forearm, ending in a semicircular blade used for devastating bladed punch attacks.<br>" +
            "<br>" +
            "Benefit: The scizore grants a +1 shield bonus to AC, but if you attack with the blade, you lose the AC bonus that round and take a –1 penalty on attack rolls with the scizore. While wearing a scizore, you cannot use that hand for anything else. A scizore provides a +10 bonus to your CMD against being disarmed of your scizore. Donning a scizore is a full-round action.", 1),
    SIBAT("Sibat","Martial","One-Handed",2,"1d4","1d6", 20,new int[]{3},10,2, "Piercing or Slashing", "see text","UC", "This weapon is similar to a shortspear with a flexible rattan or bamboo shaft and an elaborately barbed head.<br>" +
            "<br>" +
            "Benefit: On a critical hit, the spear grabs flesh or armor. The wielder can then attempt a combat maneuver check to attempt to grapple its opponent as a free action. This grapple attempt does not provoke an attack of opportunity from the creature you are attempting to grapple. While grappling the target with a sibat, the wielder can only move or damage the target on its turn. The wielder is still considered grappled, though it does not have to be adjacent to the target to continue the grapple. If you move far away to be out of the sibat’s reach, you end the grapple with that action.", 1),
    SPIKED_SHIELD_HEAVY("Spiked shield, heavy","Martial","One-Handed",19,"1d4","1d6", 20,new int[]{2},0,0, "Piercing", "","CRB", "Description: You can bash with a spiked shield instead of using it for defense.<br>" +
            "<br>" +
            "Shield Bash Attacks<br>" +
            "<br>" +
            "You can bash an opponent with a shield, using it as an off-hand weapon. Used this way, a shield is a martial bludgeoning weapon.<br>" +
            "<br>" +
            "For the purpose of penalties on attack rolls, treat a heavy shield as a one-handed weapon and treat a light shield as a light weapon.", 1),
    SWORD_CANE("Sword cane","Martial","One-Handed",45,"1d4","1d6", 20,new int[]{2},0,4, "Piercing", "see text","APG", "This slender light blade lies within a wooden container that serves as both its scabbard and hiding place.<br>" +
            "<br>" +
            "Benefit: You can draw the blade from the cane as a swift action (or a free action if you have the Quick Draw feat). An observer must make a DC 20 Perception check to realize an undrawn sword cane is a weapon rather than a walking stick; the DC decreases to 10 if the observer is able to handle the weapon. You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a sword cane sized for you, even though it isn't a light weapon. You can't wield a sword cane in two hands in order to apply 1-1/2 times your Strength modifier to damage.", 1),
    TERBUTJE("Terbutje","Martial","One-Handed",5,"1d6","1d8", 19,new int[]{2},0,2, "Slashing", "fragile","AA", "<br>" +
            "Features: fragile", 1),
    TERBUTJE_STEEL("Terbutje, steel","Martial","One-Handed",20,"1d6","1d8", 19,new int[]{2},0,4, "Slashing", "","AA", "This is a forged weapon built to look much like a common terbutje. It lacks the fragility of its non-metallic counterpart.", 1),
    TRIDENT("Trident","Martial","One-Handed",15,"1d6","1d8", 20,new int[]{2},10,4, "Piercing", "brace","CRB", "A trident has three metal prongs at end of a 4-foot-long shaft.<br>" +
            "<br>" +
            "Description: A trident can be thrown.", 1),
    WARHAMMER("Warhammer","Martial","One-Handed",12,"1d6","1d8", 20,new int[]{3},0,5, "Bludgeoning", "","CRB", "The war hammer consists of a handle and a head. The handle may be of different lengths, the longest being roughly equivalent to the halberd, and the shortest about the same as a mace. Long war hammers are pole weapons (polearms) meant for use against riders, whereas short ones are used in closer quarters and from horseback.", 1),
    BARDICHE("Bardiche","Martial","Two-Handed",13,"1d8","1d10", 19,new int[]{2},0,14, "Slashing", "brace, reach, see text","APG", "The crescent axeblade of this polearm is attached to the haft at two points: the center of the blade attaches to a socket at the top of the haft, and the lower point of the blade attaches to a secondary mount point. The blade is often very long, sometimes almost as long as the haft.<br>" +
            "<br>" +
            "Special: You gain a +2 bonus to your CMD to resist sunder attempts against a bardiche.<br>" +
            "<br>" +
            "<br>" +
            "Traits: brace, reach", 1),
    BEC_DE_CORBIN("Bec de corbin","Martial","Two-Handed",15,"1d8","1d10", 20,new int[]{3},0,12, "Bludgeoning or Piercing", "brace, reach, see text","APG", "The bec de corbin is a polearm very similar to the lucerne hammer, but the hammer head is blunt rather than spiked and the spike is stouter and more hooked. You primarily attack with the spike.<br>" +
            "<br>" +
            "Benefit: You gain a +2 bonus to your CMB to sunder medium or heavy armor with a bec de corbin.<br>" +
            "<br>" +
            "Features: brace, reach", 1),
    BILL("Bill","Martial","Two-Handed",11,"1d6","1d8", 20,new int[]{3},0,11, "Slashing", "brace, disarm, reach, see text","APG", "The blade of this polearm is a curved or hooked chopping blade with a spiked projection on the back of the blade. The spike is commonly used to block and parry.<br>" +
            "<br>" +
            "Benefit: When fighting defensively or with full defense, this weapon gives you a +1 shield bonus to AC. A mounted opponent hit by a bill takes a –1 penalty on his Ride checks to stay mounted.<br>" +
            "<br>" +
            "Weapon Feature(s): brace, disarm, reach", 1),
    EARTH_BREAKER("Earth breaker","Martial","Two-Handed",40,"1d10","2d6", 20,new int[]{3},0,14, "Bludgeoning", "","ISWG", "The crude metal of this massive hammer’s head ends in multiple blunt spikes that channel the momentum of a powerful swing.", 1),
    FALCHION("Falchion","Martial","Two-Handed",75,"1d6","2d4", 18,new int[]{2},0,8, "Slashing", "","CRB", "Wikipedia describes a falchion as \"a one-handed sword\" but by core rules a falchion is a two-handed weapon. Wikipedia goes on to describe it as \"a single-edged sword, whose design is reminiscent of the scimitar. It combines the weight and power of an axe with the versatility of a sword.\"", 1),
    FLAIL_HEAVY("Flail, heavy","Martial","Two-Handed",15,"1d8","1d10", 19,new int[]{2},0,10, "Bludgeoning", "disarm, trip","CRB", "A heavy flail is similar to a standard flail but has a larger metal ball and a longer handle.", 1),
    GLAIVE("Glaive","Martial","Two-Handed",8,"1d8","1d10", 20,new int[]{3},0,10, "Slashing", "reach","CRB", "A glaive is a simple blade, mounted to the end of a pole about 7 feet in length.<br>" +
            "<br>" +
            "Weapon Feature(s): reach", 1),
    GLAIVE_GUISARME("Glaive-guisarme","Martial","Two-Handed",12,"1d8","1d10", 20,new int[]{3},0,10, "Slashing", "brace, reach, see text","APG", "This polearm combines the blade of a glaive with a wicked hook.<br>" +
            "<br>" +
            "Benefit: A mounted opponent hit by a glaive-guisarme takes a –2 penalty on his Ride checks to stay mounted.<br>" +
            "<br>" +
            "Weapon Feature(s): brace, reach", 1),
    GREATAXE("Greataxe","Martial","Two-Handed",20,"1d10","1d12", 20,new int[]{3},0,12, "Slashing", "","CRB", "A very large axe, made for hurting things, badly.<br>" +
            "<br>" +
            "Benefit: You kill stuff well.", 1),
    GREATCLUB("Greatclub","Martial","Two-Handed",5,"1d8","1d10", 20,new int[]{2},0,8, "Bludgeoning", "","CRB", "This larger, bulkier version of the common club is heavy enough that you can’t wield it with one hand. It may be ornate and carved, reinforced with metal, or a simple branch from a tree. Like simple clubs, greatclubs have many names, such as cudgels, bludgeons, shillelaghs, and more.", 1),
    GREATSWORD("Greatsword","Martial","Two-Handed",50,"1d10","2d6", 19,new int[]{2},0,8, "Slashing", "","CRB", "This immense two-handed sword is about 5 feet in length.", 1),
    GUISARME("Guisarme","Martial","Two-Handed",9,"1d6","2d4", 20,new int[]{3},0,12, "Slashing", "reach, trip","CRB", "A guisarme is an 8-foot-long shaft with a blade and a hook mounted at the tip.<br>" +
            "<br>" +
            "Weapon Feature(s): reach, trip", 1),
    HALBERD("Halberd","Martial","Two-Handed",10,"1d8","1d10", 20,new int[]{3},0,12, "Piercing or Slashing", "brace, trip","CRB", "A halberd is similar to a 5-foot-long spear, but it also has a small, axe-like head mounted near the tip.", 1),
    HAMMER_LUCERNE("Hammer, lucerne","Martial","Two-Handed",15,"1d10","1d12", 20,new int[]{2},0,12, "Bludgeoning or Piercing", "brace, reach, see text","APG", "This polearm has both a pronged hammer head for crushing blows and a spiked head for piercing and peeling armor; most attacks are made with the hammer. The long haft allows the wielder to put amazing force behind the head of this weapon.<br>" +
            "<br>" +
            "Benefit: You gain a +2 bonus to your CMB to sunder medium or heavy armor with a lucerne hammer.<br>" +
            "<br>" +
            "Weapon Feature(s): brace, reach", 1),
    HOOKED_LANCE("Hooked lance","Martial","Two-Handed",3,"1d6","1d8", 20,new int[]{4},0,10, "Piercing", "reach, trip","UC", "This slender, 10-foot-long polearm has an added hook protruding from the head that is used to snag the clothing and armor of opponents.", 1),
    HORSECHOPPER("Horsechopper","Martial","Two-Handed",10,"1d8","1d10", 20,new int[]{3},0,12, "Piercing or Slashing", "reach, trip","ISWG", "Crafted by goblins to give themselves an advantage against horses, this weapon is essentially a halberd with an enlarged hook opposite the blade.", 1),
    LANCE("Lance","Martial","Two-Handed",10,"1d6","1d8", 20,new int[]{3},0,10, "Piercing", "reach","CRB", "Benefit: A lance deals double damage when used from the back of a charging mount. While mounted, you can wield a lance with one hand.<br>" +
            "<br>" +
            "Weapon Feature(s): reach", 1),
    MONKS_SPADE("Monk’s spade","Martial","Two-Handed",20,"4/1d4","6/1d6", 20,new int[]{2},0,12, "Bludgeoning or Piercing or Slashing", "double, monk","UC", "This weapon is a double weapon pole arm. One side is fitted with a broad, shovel-like sharpened blade while the opposite side is fitted with a crescent blade that juts out like a pair of bull’s horns.<br>" +
            "<br>" +
            "Benefit: The monk’s spade does many types of damage. What type of damage it deals depends on how it is wielded, with the spade side able to bludgeon or slash and the crescent side able to jab, slash, and pierce.", 1),
    NAGINATA("Naginata","Martial","Two-Handed",35,"1d6","1d8", 20,new int[]{4},0,9, "Slashing", "reach","UC", "The naginata consists of a 6-foot staff affixed to a 2-foot-long, swordlike slightly curved blade. The shaft is designed to keep the wielder out of reach from swords and shorter weapons.<br>" +
            "<br>" +
            "Feature(s): reach", 1),
    NODACHI("Nodachi","Martial","Two-Handed",60,"1d8","1d10", 18,new int[]{2},0,8, "Slashing or Piercing", "brace","UC", "This very long two-handed weapon has a slender but wickedly sharp 4-foot-long blade at one end and is predominantly used by ground troops to attack mounted warriors.<br>" +
            "<br>" +
            "Benefit: A nodachi can be used to hack riders from their mounts or set to receive a charge.<br>" +
            "<br>" +
            "Feature(s): brace", 1),
    OGRE_HOOK("Ogre hook","Martial","Two-Handed",24,"1d8","1d10", 20,new int[]{3},0,10, "Piercing", "trip","ISWG", "A huge, crude crook of sharpened metal, an ogre hook takes its name from the savages who most typically employ it. Usually created by ogres, these are often Large, and awkward for most humanoids to use.<br>" +
            "<br>" +
            "Benefit: You can use an ogre hook to make trip attacks. <br>" +
            "<br>" +
            "Weapon Feature(s): trip", 1),
    PICKAXE("Pickaxe","Martial","Two-Handed",14,"1d6","1d8", 20,new int[]{4},0,12, "Piercing", "","AP14", "A two-handed version of the heavy pick, the brutal pickaxe is equally effective at breaking up earth and stone as it is at sundering flesh and bone. Often a weapon of convenience for commoners, the pickaxe is also a favorite among brutes and thugs who value the intimidation factor afforded by the immense weapon.", 1),
    RANSEUR("Ranseur","Martial","Two-Handed",10,"1d6","2d4", 20,new int[]{3},0,12, "Piercing", "disarm, reach","CRB", "Similar in appearance to a trident, a ranseur has a single spear at its tip, flanked by a pair of short, curving blades.<br>" +
            "<br>" +
            "Weapon Feature(s): disarm, reach", 1),
    SANSETSUKON("Sansetsukon","Martial","Two-Handed",8,"1d8","1d10", 19,new int[]{2},0,3, "Bludgeoning", "blocking, disarm, monk","UC", "This staff is broken into three 2-foot-long segments that have been chained back together, allowing the wielder greater flexibility, and allows the weapon to be swung rapidly to create a defensive block.", 1),
    SCYTHE("Scythe","Martial","Two-Handed",18,"1d6","2d4", 20,new int[]{4},0,10, "Piercing or Slashing", "trip","CRB", "A scythe constructed for fighting (as opposed to a standard harvesting scythe) has had its blade transformed so that it extends upright from the staff, and is used much like a halberd.<br>" +
            "<br>" +
            "Weapon Feature(s): trip", 1),
    SPEAR_SYRINGE("Spear, syringe","Martial","Two-Handed",100,"1d6","1d8", 20,new int[]{3},20,6, "Piercing", "brace, see text","AA", "The blade of this weapon contains a thin tube or bore that connects to a hollow container just beneath the crosspiece.<br>" +
            "<br>" +
            "Description: A successful hit with the spear injects the liquid contents of the container (typically poison) into the target.<br>" +
            "<br>" +
            "Action: Refilling a syringe spear takes 1 minute.<br>" +
            "<br>" +
            "Weapon Feature(s): brace, special", 1),
    SWORD_TRI_POINT_DOUBLE_EDGED("Sword, tri-point double-edged","Martial","Two-Handed",12,"1d8","1d10", 20,new int[]{3},0,14, "Piercing", "reach","UC", "Topping the head of this 5-foot-long shaft are three long, backward-curved blades fashioned in the appearance of a blossoming lotus. The unusually large head is designed to land heavy blows and multiple wounds that open away from each other.", 1),
    TIGER_FORK("Tiger fork","Martial","Two-Handed",5,"1d6","1d8", 20,new int[]{2},0,8, "Piercing", "brace, monk","UC", "This long, tridentlike weapon consists of a three-pronged metal fork set upon an 8-foot-long shaft. It is wielded much like a staff, with the wielder grasping the shaft from the center and jabbing its forked end.<br>" +
            "<br>" +
            "Benefit: A Tiger fork can be set to receive a charge.<br>" +
            "<br>" +
            "Features: brace", 1),
    AMENTUM("Amentum","Martial","Ranged",0,"1d4","1d6", 20,new int[]{2},50,1, "Piercing", "performance","UC", "An amentum is a long leather thong that attaches to a javelin.<br>" +
            "<br>" +
            "Benefit: Before throwing, the amentum is wound about the javelin’s shaft. You then throw the javelin while gripping the amentum, imparting spin to the weapon and greatly improving its range. Attaching an amentum to a javelin is a move action, and winding it is a full-round action. Javelins can be stored with amenta already wound about them. A javelin wound with an amentum is considered a martial weapon.", 1),
    CHAKRAM("Chakram","Martial","Ranged",1,"1d6","1d8", 20,new int[]{2},30,1, "Slashing", "","APG", "The chakram is a simple, elegant, and highly portable thrown weapon. It is a flat, open-centered metal discus with a sharpened edge.<br>" +
            "<br>" +
            "Benefit: You can wield the chakram as a melee weapon, but it is not designed for such use; you take a –1 penalty on your attack roll with the weapon and must make a DC 15 Reflex save or cut yourself on the blade (half damage, no Strength modifier). You do not need to make this save if wearing heavy armor.", 1),
    HUNGA_MUNGA("Hunga munga","Martial","Ranged",4,"1d4","1d6", 20,new int[]{2},15,3, "Piercing", "","AA", "This three-bladed dagger is intended for throwing but can be used as a melee weapon.", 1),
    LONGBOW("Longbow","Martial","Ranged",75,"1d6","1d8", 20,new int[]{3},100,3, "Piercing", "","CRB", "At almost 5 feet in height, a longbow is made up of one solid piece of carefully curved wood.<br>" +
            "<br>" +
            "Description: You need two hands to use a bow, regardless of its size. A longbow is too unwieldy to use while you are mounted. If you have a penalty for low Strength, apply it to damage rolls when you use a longbow. If you have a Strength bonus, you can apply it to damage rolls when you use a composite longbow (see below), but not when you use a regular longbow.<br>" +
            "<br>" +
            "Eastern Version: Daikyu This long curved bow made of laminated bamboo or wood, and favored by many samurai, is equivalent to a longbow.", 1),
    LONGBOW_COMPOSITE("Longbow, composite","Martial","Ranged",100,"1d6","1d8", 20,new int[]{3},110,3, "Piercing", "","CRB", "Description: You need at least two hands to use a bow, regardless of its size. You can use a composite longbow while mounted. All composite bows are made with a particular Strength rating (that is, each requires a minimum Strength modifier to use with proficiency). If your Strength bonus is less than the strength rating of the composite bow, you can't effectively use it, so you take a –2 penalty on attacks with it. The default composite longbow requires a Strength modifier of +0 or higher to use with proficiency. A composite longbow can be made with a high strength rating to take advantage of an above-average Strength score; this feature allows you to add your Strength bonus to damage, up to the maximum bonus indicated for the bow. Each point of Strength bonus granted by the bow adds 100 gp to its cost. If you have a penalty for low Strength, apply it to damage rolls when you use a composite longbow.<br>" +
            "<br>" +
            "For purposes of Weapon Proficiency and similar feats, a composite longbow is treated as if it were a longbow.", 1),
    PILUM("Pilum","Martial","Ranged",5,"1d6","1d8", 20,new int[]{2},20,4, "Piercing", "see text","APG", "This tip of this heavy javelin is designed to break off and embed itself into a shield once it reaches its target.<br>" +
            "<br>" +
            "Benefit: Like ammunition, a thrown pilum that hits its target is destroyed. If you hit an shield-using opponent with a pilum, he loses the AC bonus from that shield until he takes a standard action to pry out the remnants of the pilum.", 1),
    POISONED_SAND_TUBE("Poisoned sand tube","Martial","Ranged",1," "," ", 20,new int[]{},0,1, "", "","UC", "This item resembles a slender bamboo or metal scroll case.<br>" +
            "<br>" +
            "Benefit: A poisoned sand tube is typically filled with fine sand that is soaked or coated with inhaled or contact poison.<br>" +
            "<br>" +
            "When loaded with 3 doses of these types of poison, the wielder blows into the tube, dispersing the poisoned sand into her enemies’ faces in a 15-foot cone. Each creature in the cone is affected as if afflicted with 1 dose of the poison. Even when loaded with unpoisoned sand, the tube lets loose a powerful irritant, and an opponent struck must succeed at a DC 12 Fortitude saving throw or be dazzled for 1 round. Once expended, the tube must be repacked before it can be used again. Repacking a tube requires a full-round action, or a standard action if the wielder has the Rapid Reload feat.", 1),
    SHORTBOW("Shortbow","Martial","Ranged",30,"1d4","1d6", 20,new int[]{3},60,2, "Piercing", "","CRB", "A shortbow is made up of one piece of wood, about 3 feet in length.<br>" +
            "<br>" +
            "Description: You need two hands to use a bow, regardless of its size. You can use a shortbow while mounted. If you have a penalty for low Strength, apply it to damage rolls when you use a shortbow. If you have a bonus for high Strength, you can apply it to damage rolls when you use a composite shortbow (see below), but not a regular shortbow.<br>" +
            "<br>" +
            "Eastern Version: Hankyu This shorter bow is similar to the diakyu in form and construction and is equivalent to a shortbow.", 1),
    SHORTBOW_COMPOSITE("Shortbow, composite","Martial","Ranged",75,"1d4","1d6", 20,new int[]{3},70,2, "Piercing", "","CRB", "Description: You need at least two hands to use a bow, regardless of its size. You can use a composite shortbow while mounted. All composite bows are made with a particular Strength rating (that is, each requires a minimum Strength modifier to use with proficiency). If your Strength bonus is lower than the strength rating of the composite bow, you can't effectively use it, so you take a –2 penalty on attacks with it. The default composite shortbow requires a Strength modifier of +0 or higher to use with proficiency. A composite shortbow can be made with a high strength rating to take advantage of an above-average Strength score; this feature allows you to add your Strength bonus to damage, up to the maximum bonus indicated for the bow. Each point of Strength bonus granted by the bow adds 75 gp to its cost. If you have a penalty for low Strength, apply it to damage rolls when you use a composite shortbow.<br>" +
            "<br>" +
            "For purposes of Weapon Proficiency, Weapon Focus, and similar feats, a composite shortbow is treated as if it were a shortbow.", 1),
    TUBE_ARROW_SHOOTER("Tube arrow shooter","Martial","Ranged",3,"1d3","1d4", 20,new int[]{2},40,0.5, "Piercing", "","UC", "This weapon consists of a small metal tube hidden within a sleeve; the tube holds a short, spring-loaded bamboo shaft.<br>" +
            "<br>" +
            "Benefit: The wielder gains a +2 bonus on Sleight of Hand skill checks made to conceal an arrow tube shooter on his body. Releasing the fastener allows the spring to force the arrow out. Once a shaft is fired, the tube must be reloaded before it can be used again. Reloading a tube is a full-round action, or a standard action if the wielder has the Rapid Reload feat.", 1),
    ARROW_BAMBOO_SHAFT("Arrow, Bamboo shaft","Martial","Ammunition",1," "," ", 20,new int[]{},0,0.5, "", "","UC", "These foot-long arrows are used as ammunition for arrow tubes.<br>" +
            "<br>" +
            "Benefit: As an improvised melee weapon, they deal damage equivalent to a spiked gauntlet. They come in a bamboo tube that holds 10 shafts.", 10),
    ARROW_IRON_TIPPED_DISTANCE("Arrow, iron-tipped distance","Martial","Ammunition",1," "," ", 20,new int[]{},0,4, "", "","UC", "Used tactically for long-range attacks on troops, these arrows are fitted with heavy iron heads. While these heads help them travel great distances, they make the arrows less effective at dealing damage.<br>" +
            "<br>" +
            "Benefit: Iron-tipped distance arrows increase their bow’s range increment by 10 feet but take a –1 penalty on damage dealt per range increment (minimum 1 point of damage). They are sold in leather quivers in quantities of 20.", 20),
    ARROW_WHISTLING("Arrow, whistling","Martial","Ammunition",2," "," ", 20,new int[]{},0,3, "", "","UC", "These arrows come with specially designed grooves and fletching that cause them to emit a loud keening sound.<br>" +
            "<br>" +
            "Benefit: The sound is audible within 500 feet of the flight path. They are sold in quantities of 20.", 20),
    ARROW_BLEEDING("Arrow, bleeding","Martial","Ammunition",360," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "This sharpened hollow tube looks like it was originally a narrow proboscis on some giant insect, but it actually comes from a strange carnivorous plant.<br>" +
            "<br>" +
            "Benefit: A bleeding arrow deals normal damage when it hits a creature. Each round thereafter, the creature bleeds for 1 point of damage until the bleeding is stopped by a DC 10 Heal check or the application of a cure spell or some other healing magic. A critical hit does not multiply the bleed damage. Creatures immune to critical hits (such as plants and constructs) are immune to the bleed damage dealt by this weapon." , 1),
    ARROW_BLUNT("Arrow, blunt","Martial","Ammunition",2," "," ", 20,new int[]{},0,3, "Bludgeoning", "see text","APG", "These arrows have rounded wooden tips. <br>" +
            "<br>" +
            "Benefit: Blunt Arrows deal bludgeoning damage rather than piercing damage. An archer can use a blunt arrow to deal nonlethal damage (at the normal –4 attack penalty for using a lethal weapon to deal nonlethal damage).", 20),
    ARROW_COMMON("Arrow, common","Martial","Ammunition",1," "," ", 20,new int[]{},0,3, "Piercing", "","CRB", "", 20),
    ARROW_DURABLE("Arrow, durable","Martial","Ammunition",1," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "These arrows are tightly wrapped in strands of some kind of alchemical glue.<br>" +
            "<br>" +
            "Benefit: Durable arrows don’t break due to normal use, whether or not they hit their target; unless the arrow goes missing, an archer can retrieve and reuse a durable arrow again and again. Durable arrows can be broken in other ways (such as deliberate snapping, hitting a fire elemental, and so on).<br>" +
            "<br>" +
            "Drawback: If crafted with magic (such as bane), the magic only lasts for one use of the arrow, but the nonmagical arrow can still be reused or imbued with magic again.", 1),
    ARROW_DYE("Arrow, dye","Martial","Ammunition",1,"","", 20,new int[]{},0,4, "", "see text","EoG", "Benefit: Firing a dye arrow is a ranged touch attack; a creature struck by a dye arrow takes no damage but is splashed with black, blue, green, or red marker dye (see Pathfinder Chronicles Campaign Setting 213) sufficient to coat about 1 square foot.", 1),
    ARROW_FLIGHT("Arrow, flight","Martial","Ammunition",2," "," ", 20,new int[]{},0,3, "Piercing", "see text","APG", "These arrows have light shafts and special fletchings to give them greater range.<br>" +
            "<br>" +
            "Benefit: A flight arrows range increment is 20 feet greater with longbows, 10 feet greater with shortbows. <br>" +
            "<br>" +
            "Drawback: Flight arrows deal damage as if one size category smaller.", 20),
    ARROW_LODESTONE("Arrow, lodestone","Martial","Ammunition",10," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "This heavy iron arrowhead is sealed with an alchemical resin; pulling a small string breaks the seal and activates the reaction in the arrowhead, greatly increasing its magnetic properties.<br>" +
            "<br>" +
            "Action: Pulling the string to break the seal and activate the reaction in the arrowhead is a move action.<br>" +
            "<br>" +
            "Benefit: You gain a +4 bonus on attack rolls when firing a lodestone arrow at a target wearing a significant amount of metal armor (at least chain mail or a metal shield) or made of metal. The increased magnetism fades 1 round after you activate it, after which time it is a normal arrow.<br>" +
            "<br>" +
            "Special: In areas with a lot of magnetic metal, the attack bonus may drop to 0 or even become a penalty as competing sources steer the arrow away from your intended target.<br>" +
            "<br>" +
            "Drawback: The magnetized arrow only deals half damage.", 1),
    ARROW_PHEROMONE("Arrow, pheromone","Martial","Ammunition",15," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "The arrowhead of this arrow is coated with potent substances that react to blood and sweat, releasing strong aromas that most predators recognize as tasty injured prey and other creatures perceive as merely unpleasant.<br>" +
            "<br>" +
            "Benefit: Any creature with the scent ability gains a +2 bonus on attack and damage rolls made against a target marked with a pheromone arrow. This effect lasts for 1 hour or until the target spends 1 minute washing.", 1),
    ARROW_RAINING("Arrow, raining","Martial","Ammunition",30," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "This thick-shafted arrow contains a reservoir of holy water and is designed to burst on impact, hitting the target and splashing nearby creatures.<br>" +
            "<br>" +
            "Benefit: The reservoir of holy water is designed to burst on impact, hitting the target and splashing nearby creatures as if you had thrown the vial.<br>" +
            "<br>" +
            "Drawback: A raining arrow has a –2 penalty on attack rolls due to its weight.", 1),
    ARROW_SLOW_BURN("Arrow, slow burn","Martial","Ammunition",150," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "Behind the head of this arrow is a small receptacle of alchemical material that heats up when exposed to air and eventually bursts into flame; barbs on the arrowhead pierce the pouch when it hits a target.<br>" +
            "<br>" +
            "Benefit: On your turn, 1 round after impact, the burst of flame deals 1d6 points of fire damage to the target.<br>" +
            "<br>" +
            "Drawback: The extra weight of this arrowhead gives you a –1 penalty on attack rolls with the arrow.", 1),
    ARROW_SMOKE("Arrow, smoke","Martial","Ammunition",10," "," ", 20,new int[]{},0,0, "Piercing", "see text","APG", "This arrow is actually a specially-shaped smokestick that can be fired from a bow.<br>" +
            "<br>" +
            "Benefit: A smoke arrow trails smoke as it flies, and creates a 5-foot cube of smoke where it strikes. It otherwise functions like a normal arrow in terms of damage, range, and so on.", 1),
    ARROW_SPLINTERCLOUD("Arrow, splintercloud","Martial","Ammunition",25," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "The shaft of this arrow is formed of numerous small bone fragments painstakingly glued together.<br>" +
            "<br>" +
            "Benefit: When fired, the numerous bone fragments tear themselves apart, forming a 5-foot burst of razor-sharp bones that deals 1d3 points of piercing damage (Reflex DC 18 negates).", 1),
    ARROW_TANGLEFOOT("Arrow, tanglefoot","Martial","Ammunition",20," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "This arrow is topped with a small bottle containing a small quantity of tanglefoot goo. Elves frequently use these arrows to slow or stop fleeing opponents or to capture animals without killing them.<br>" +
            "<br>" +
            "Benefit: You fire a tangleshot arrow as a ranged touch attack; the arrow deals no damage when it hits, but the target is splashed with the alchemical adhesive. The reduced amount of the glue means this arrow is less effective than an actual tanglefoot bag (DC 10 Reflex save, DC 12 Strength check to break, 10 points of slashing damage to cut through, DC 10 Concentration check).<br>" +
            "<br>" +
            "Drawback: The weight of a tangleshot arrow reduces its range increment to half normal.", 1),
    ARROW_THISTLE("Arrow, thistle","Martial","Ammunition",1," "," ", 20,new int[]{},0,0.1, "Piercing", "see text","AA", "These barbed arrows are crafted from the thistles of a poisonous plant, causing pain to persist beyond the initial injury.<br>" +
            "<br>" +
            "Benefit: Thistle arrows deal damage as a bleed effect for 1d6 rounds.", 1),
    ARROW_TRIP("Arrow, trip","Martial","Ammunition",25," "," ", 20,new int[]{},0,0, "see text", "see text","EoG", "This squat arrow has a large, bulbous, metal tip that expands and flattens in flight.<br>" +
            "<br>" +
            "Benefit: If the arrow hits, it makes a trip attack against the target with a CMB of +5; the target falls prone if it fails its check, but if it succeeds it cannot attempt to trip you in return.", 1),
    AKLYS("Aklys","Exotic","Light",5,"1d6","1d8", 20,new int[]{2},20,2, "Bludgeoning", "performance, trip","UC", "The aklys is a hooked throwing club with a 20-foot cord attached. Some aklys have holes drilled in them and whistle when thrown, making them ideal for throwing down long, dark tunnels.<br>" +
            "<br>" +
            "Benefit: An aklys has a maximum range of 20 feet, allowing the user to retrieve the thrown aklys as a move action. The hook allows you to make trip attacks at range. <br>" +
            "<br>" +
            "Features: trip", 1),
    AXE_KNUCKLE("Axe, knuckle","Exotic","Light",9,"1d4","1d6", 20,new int[]{3},0,2, "", "","No Source Listed", "Knuckle axes, usually used in pairs, resemble axe blades mounted on brass knuckles.<br>" +
            "<br>" +
            "Benefit: You may hold, but not wield, a weapon or other object in a hand wearing a knuckle axe. Unlike when wearing brass knuckles, you cannot use a hand wearing a knuckle axe for spellcasting.", 1),
    BARBAZU_BEARD("Barbazu beard","Exotic","Light",25,"1d3","1d4", 20,new int[]{2},0,5, "Slashing", "see text","Cheliax", "A barbazu beard is an intimidating helm with a full facemask wrought to look like a snarling barbazu's head. Extending from the chin area of the face guard is a razor-sharp blade much like an actual barbazu's beard, usually 8 inches long but sometimes longer.<br>" +
            "<br>" +
            "Description: A barbazu beard can be used as an off-hand weapon that requires no hands to use; thus, a warrior could combine use of a barbazu beard with a two-handed weapon.<br>" +
            "<br>" +
            "Attacking with a barbazu beard provokes an attack of opportunity. Because it is so close to the wearer's face, using a barbazu beard against creatures harmful to touch (such as fire elementals and acidic oozes) has the same risks as using a natural weapon or unarmed strike against these creatures.", 1),
    BATTLE_POI("Battle poi","Exotic","Light",5,"1d3 fire","1d4 fire", 20,new int[]{2},0,2, "Fire", "","AA", "This pair of arm-length chains has handles at one end and heavy fuel-soaked torch heads at the other.<br>" +
            "<br>" +
            "Benefit: The weight of the poi is insufficient to deal physical damage, but the burning fuel deals fire damage. If you are proficient in battle poi, you are treated as if you have the Two-Weapon Fighting feat for the purposes of making poi attacks.<br>" +
            "<br>" +
            "Special: Poi can be extinguished by spending a full round action smothering them in sand or submerging them in water.", 1),
    BICHHWA("Bich’hwa","Exotic","Light",5,"1d3","1d4", 19,new int[]{2},0,2, "Piercing or Slashing", "monk","?", "Also known as the waveblade or \"scorpion’s tail,\" this short, double-curved blade has no hilt but features a knuckle guard and can easily be used in either hand.<br>" +
            "<br>" +
            "<br>" +
            "<br>" +
            "Features: disarm, monk", 1),
    DAGGER_SWORDBREAKER("Dagger, swordbreaker","Exotic","Light",10,"1d3","1d4", 20,new int[]{2},0,3, "Slashing", "disarm, sunder","APG", "You can use this dagger to disarm or sunder enemy blades by catching them in the grooves on the back of the blade and using your weapon as a lever.<br>" +
            "<br>" +
            "Benefit: If you are proficient with this weapon, add +4 on your disarm or sunder attempts against bladed weapons.<br>" +
            "<br>" +
            "Weapon Feature(s): disarm, sunder", 1),
    DAN_BONG("Dan bong","Exotic","Light",1,"1d2","1d3", 19,new int[]{2},10,0, "Bludgeoning", "blocking, monk","UC", "These short, blunt sticks are held in the hands to enhance unarmed martial techniques.<br>" +
            "<br>" +
            "Benefit: They provide the wielder with the ability to lock an opponent and target pressure points that grant her a +2 bonus on her combat maneuver to grapple.", 10),
    EMEI_PIERCER("Emei piercer","Exotic","Light",3,"1d2","1d3", 19,new int[]{2},0,0, "Piercing", "monk, see text","UC", "This weapon is used to augment unarmed martial techniques. It consists of an 8- to 10-inch-long, dual-pointed steel spike set on swivels and mounted on a ring, so that it can be spun around at high speeds when slipped over the wielder’s ring finger.<br>" +
            "<br>" +
            "Benefit: The ring prevents the wielder from being disarmed and turns unarmed strikes into piercing attacks.", 1),
    FIGHTING_FAN("Fighting fan","Exotic","Light",5,"1d3","1d4", 20,new int[]{3},0,0, "Slashing or Piercing", "distracting, monk","UC", "Made to resemble a courtier’s fan, this device consists of silk paper stretched and folded over a folding frame of hardened steel. Folding fans are typically wielded in pairs using a technique that distracts the opponent. The fans sport sharp tips, which can be poisoned.", 1),
    KAMA("Kama","Exotic","Light",2,"1d4","1d6", 20,new int[]{2},0,2, "Slashing", "monk, trip","CRB", "Similar to a sickle, a kama is a short, curved blade attached to a simple handle.<br>" +
            "<br>" +
            "Weapon Feature(s): monk, trip", 1),
    KATAR_TRI_BLADED("Katar, tri-bladed","Exotic","Light",6,"1d3","1d4", 20,new int[]{4},0,2, "Piercing", "","PCS", "Although most punching daggers boast a single long, thick blade, the tri-bladed dagger features a fan of three splayed razor edges.", 1),
    KNIFE_BUTTERFLY("Knife, butterfly","Exotic","Light",5,"1d3","1d4", 19,new int[]{2},0,1, "Piercing or Slashing", "","AA", "A butterfly knife has a blade concealed between two halves of the handle that can be brought to bear quickly.<br>" +
            "<br>" +
            "Benefit: If you are proficient with the butterfly knife (or have the Quick Draw feat) and are holding it in your hand, you may open it as a free action; a nonproficient user must spend a move action to open it. Otherwise, treat this weapon as a dagger. When it’s closed, you gain a +2 bonus on Sleight of Hand checks made to conceal it on your body.", 1),
    MADU_LEATHER("Madu (leather)","Exotic","Light",40,"1d3","1d4", 20,new int[]{2},0,5, "Piercing", "performance","UC", "The madu is a round, light shield with four spikes extending from the sides. <br>" +
            "<br>" +
            "Benefit: If you are proficient with the madu, you may wield it and fight defensively with a –2 penalty instead of the normal–4 penalty for fighting defensively, and your attack penalty for using Combat Expertise improves by +1 (minimum –1 penalty). You cannot hold anything else in the hand that bears a madu. If you are not proficient in madu, treat it as a light spiked shield.", 1),
    MADU_STEEL("Madu (steel)","Exotic","Light",40,"1d3","1d4", 20,new int[]{2},0,6, "Piercing", "performance","UC", "The madu is a round, light shield with four spikes extending from the sides. <br>" +
            "<br>" +
            "Benefit: If you are proficient with the madu, you may wield it and fight defensively with a –2 penalty instead of the normal–4 penalty for fighting defensively, and your attack penalty for using Combat Expertise improves by +1 (minimum –1 penalty). You cannot hold anything else in the hand that bears a madu. If you are not proficient in madu, treat it as a light spiked shield.", 1),
    MAULAXE_DWARVEN("Maulaxe, dwarven","Exotic","Light",25,"1d4","1d6", 20,new int[]{3},10,5, "Bludgeoning or Slashing", "","AA", "This versatile weapon appears like a heavy-headed axe, but a skilled wielder can strike equally well with its chopping edge as with the forged sledge that backs the blade.<br>" +
            "<br>" +
            "Benefit: This weapon can be used to deliver bludgeoning or slashing damage as the wielder desires.<br>" +
            "<br>" +
            "Special: A dwarven maulaxe is a martial weapon for dwarves and an exotic weapon for members of other races. It is not a double weapon, and any enchantments applied to the weapon operate normally regardless of which part of the weapon’s head is used to deliver the blow, except for enhancements that apply only to blunt or sharp weapons. Such enhancements apply only to attacks dealing the appropriate type of damage.", 1),
    NUNCHAKU("Nunchaku","Exotic","Light",2,"1d4","1d6", 20,new int[]{2},0,2, "Bludgeoning", "disarm, monk","CRB", "A nunchaku is made up of two wooden or metal bars connected by a small length of rope or chain.<br>" +
            "<br>" +
            "Weapon Feature(s): disarm, monk", 1),
    PATA("Pata","Exotic","Light",14,"1d4","1d6", 20,new int[]{3},0,3, "Piercing", "performance","UC", "An evolution of the punching dagger, the pata is a short sword that ends in a full, fingerless gauntlet hilt.<br>" +
            "<br>" +
            "Benefit: You punch rather than stab with the weapon, allowing you to put more force behind each strike. While wearing a pata, you cannot use that hand for anything else. A pata provides a +10 bonus to your CMD against being disarmed.", 1),
    QUADRENS("Quadrens","Exotic","Light",8,"1d4","1d6", 19,new int[]{2},0,2, "Piercing", "performance","UC", "A quadrens looks like a dagger, but with four spikes mounted in a square pattern in place of a blade.<br>" +
            "<br>" +
            "Benefit: When you score a critical hit with a quadrens, the resulting gaping wound causes 1 point of bleed damage.", 1),
    ROPE_GAUNTLET("Rope gauntlet","Exotic","Light",1,"1d3","1d4", 20,new int[]{2},0,2, "Bludgeoning (or Slashing)", "","AA", "By wrapping your hands and forearms in thin but tough hemp ropes and then soaking the makeshift gloves in water for weight and expansion, you can transform your fists into rockhard weapons easily capable of killing in a fistfight.<br>" +
            "<br>" +
            "Description: Each rope gauntlet takes a full minute to wrap and another minute to soak, but once applied can be worn for a day; removing a rope gauntlet takes 1 full round.<br>" +
            "<br>" +
            "When wearing rope gauntlets, you are considered armed and your attacks deal normal damage. If you are proficient with rope gauntlets, you may use the rough edges of the ropes to deal slashing damage rather than bludgeoning damage.<br>" +
            "<br>" +
            "Your fingers are mostly exposed, allowing you to wield or carry items in your hands while wearing rope gauntlets, but the constriction of the weapon at your knuckles gives you a –2 penalty on all precision based tasks involving your hands (such as opening locks).", 5),
    SAI("Sai","Exotic","Light",1,"1d3","1d4", 20,new int[]{2},0,1, "Bludgeoning", "disarm, monk","CRB", "A sai is a metal spike flanked by a pair of prongs used to trap an enemy's weapon. Though pointed, a sai is used primarily to bludgeon foes and to disarm weapons.<br>" +
            "<br>" +
            "Description: With a sai, you get a +2 bonus on Combat Maneuver Checks to sunder an enemy's weapon.<br>" +
            "<br>" +
            "Weapon Feature(s): disarm, bonus to sunder attempts", 1),
    SIANGHAM("Siangham","Exotic","Light",3,"1d4","1d6", 20,new int[]{2},0,1, "Piercing", "monk","CRB", "This weapon is a handheld shaft fitted with a pointed tip for stabbing foes.", 1),
    SICA("Sica","Exotic","Light",10,"1d4","1d6", 20,new int[]{2},0,2, "Slashing", "performance","UC", "This blade is a smaller, lighter version of the shotel.<br>" +
            "<br>" +
            "Benefit: You gain a +1 bonus on attack rolls with a sica against opponents using bucklers, light shields, or heavy shields.", 1),
    TEKKO_KAGI_IRON_CLAW("Tekko-kagi (iron claw)","Exotic","Light",2,"1d2","1d3", 20,new int[]{2},0,0, "Piercing", "disarm, see text","UC", "Also known as the iron claw, this device consists of a fanlike structure of five 10-inch blades secured to a sturdy handle strapped to the forearm of the off-hand.<br>" +
            "<br>" +
            "Benefit: A tekko-kagi can be used an offensive weapon, defensively like a buckler, or to disarm an opponent’s weapon without provoking an attack of opportunity. It provides its owner with a +2 circumstance bonus on attempts to disarm or sunder swords or other slender-bladed weapons.", 1),
    THORN_BRACER("Thorn bracer","Exotic","Light",30,"1d4","1d6", 20,new int[]{2},0,3, "Piercing", "","PCS", "These sturdy leather bracers are studded with lacquered rose thorns that can be used to pierce foes.<br>" +
            "<br>" +
            "Description: A thorn bracer can be used to make an offhand attack if you aren’t wielding a weapon or shield in that hand. You can attack with these bracers even while holding objects in your hands.<br>" +
            "<br>" +
            "Drawback: When attacking with thorn bracers, you lose any shield bonus to AC gained from a readied shield until your next action.", 1),
    WAKIZASHI("Wakizashi","Exotic","Light",35,"1d4","1d6", 18,new int[]{2},0,2, "Piercing or Slashing", "deadly","UC", "These short, slender blades are between 1 to 2 feet long. They are primarily used as back-up weapons, to decapitate defeated enemies, or to commit seppuku (ritual suicide) as a matter of honor. These blades are specifically worn by samurai and are intended to be paired with a katana. Together, this set of blades is referred to as a daisho.", 1),
    WHIP_SCORPION("Whip, scorpion","Exotic","Light",5,"1d3","1d4", 20,new int[]{2},0,3, "Slashing", "disarm, reach, trip","UC", "This whip has a series of razorsharp blades and fangs inset along its tip.<br>" +
            "<br>" +
            "Benefit: It deals lethal damage, even to creatures with armor bonuses. If you are proficient with both scorpion whips and whips, you can use a scorpion whip in either the normal way, as a typical light performance weapon, or as a whip. <br>" +
            "<br>" +
            "If you are proficient with both the scorpion whip and whip, you can use a scorpion whip in either the normal way (as a light performance weapon) or as a whip. When you use a scorpion whip as a whip, it is equivalent to a whip, but deals lethal damage and can harm creatures regardless of their armor bonus.<br>" +
            "<br>" +
            "Weapon Feature(s): performance (plus disarm, reach, and trip if you are proficient with whip.)", 1),
    AXE_HOOKED("Axe, hooked","Exotic","One-Handed",20,"1d6","1d8", 20,new int[]{3},0,7, "Slashing", "disarm, performance, trip","UC", "Benefit: The hooked end of this axe’s blade can be used to disarm foes or pull them off balance. A hooked axe can be used as a martial weapon (in which case it functions like a battleaxe).", 1),
    FALCATA("Falcata","Exotic","One-Handed",18,"1d6","1d8", 19,new int[]{3},0,4, "Slashing", "","APG", "This heavy blade has a single sharp, concave edge and a hook-shaped hilt. Its shape distributes the weight to give it the momentum of an axe with the cutting edge of a sword.", 1),
    FLINDBAR("Flindbar","Exotic","One-Handed",9,"1d6","1d8", 20,new int[]{},0,0, "Bludgeoning", "disarm","CMR", "This one-handed weapon is similar to a nunchaku in that it consists of a pair of bars linked with heavy chain. However, a flindbar’s bars are made of iron and are capped with a ring of spikes or studs. Since it’s much heaver than a nunchaku, it is not a light weapon.<br>" +
            "<br>" +
            "Weapon Feature(s): disarm", 1),
    KATANA("Katana","Exotic","One-Handed",50,"1d6","1d8", 18,new int[]{2},0,6, "Slashing", "deadly","UC", "Specifically constructed for samurai, katanas employ multiple types of steel combined in a distinctive forging process. The result are swords noted for their wickedly sharp yet slender, gently curved blades, designed to make graceful hacking strokes capable of severing opponents’ heads and limbs. Though finely balanced, these blades are difficult to master.<br>" +
            "<br>" +
            "Benefit: Characters can use a katana two-handed as a martial weapon, but must take the Exotic Weapon Proficiency (katana) feat to use it one-handed.", 1),
    KHOPESH("Khopesh","Exotic","One-Handed",20,"1d6","1d8", 19,new int[]{2},0,8, "Slashing", "trip","APG", "This heavy blade has a convex curve near the end, making its overall shape similar to that of a battleaxe. A typical khopesh is 20 to 24 inches in length. Its curved shape allows the wielder to hook around defenses and trip foes. The elegant shape of a khopesh leads some artisans to cover them in ornate decorations.<br>" +
            "<br>" +
            "Weapon Feature(s): trip", 1),
    NINE_SECTION_WHIP("Nine-section whip","Exotic","One-Handed",8,"1d6","1d8", 19,new int[]{2},0,3, "Bludgeoning", "blocking, distracting, monk, trip","UC", "The nine-section whip consists of steel bars linked together. The final bar is a 6-inch weighted spike.<br>" +
            "<br>" +
            "Benefit: This weapon can be wielded as a single-handed weapon, a two-handed weapon, or in pairs.", 1),
    RHOKA("Rhoka","Exotic","One-Handed",5,"1d6","1d8", 18,new int[]{2},0,6, "Slashing", "","AA", "This sword is used almost exclusively by the urdefhan, life-hating quasi-daemonic underground dwelling creatures. The sword is the size of a longsword but consists of two serrated blades placed side by side, each ending in a cruel hook.", 1),
    SABRE_SAWTOOTH("Sabre, sawtooth","Exotic","One-Handed",35,"1d6","1d8", 19,new int[]{2},0,2, "Slashing", "","ISWG", "Sawtoothed sabres are cruelly efficient weapons. Their curved, serrated blades can cause deep wounds.<br>" +
            "<br>" +
            "Description: A sawtoothed sabre may be used as a Martial Weapon (in which case it functions as a longsword), but if you have the feat Exotic Weapon Proficiency (sawtoothed sabre), you treat the weapon as if it were a light weapon for the purpose of two-weapon fighting—the sabre remains classified as a one-handed melee weapon for all other purposes.", 1),
    SHOTEL("Shotel","Exotic","One-Handed",30,"1d6","1d8", 20,new int[]{3},0,3, "Piercing", "performance","UC", "The shotel is a downward-curving sword designed to reach over or around an opponent’s shield.<br>" +
            "<br>" +
            "Benefit: You gain a +1 bonus on attack rolls with a shotel against opponents using bucklers, light shields, or heavy shields.", 1),
    SWORD_ALDORI_DUELING("Sword, Aldori dueling","Exotic","One-Handed",20,"1d6","1d8", 19,new int[]{2},0,3, "Slashing", "","ISWG", "These swords are a bit over 3 feet long, very slightly curved, and sharp only along the outer edge.<br>" +
            "<br>" +
            "Benefit: A dueling sword may be used as a Martial Weapon (in which case it functions as a longsword), but if you have the feat Exotic Weapon Proficiency (dueling sword), you can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier on attack rolls with a dueling sword sized for you, even though it isn't a light weapon. You can also wield a dueling sword in two hands in order to apply 1-1/2 times your Strength bonus to damage.", 1),
    SWORD_BASTARD("Sword, bastard","Exotic","One-Handed",35,"1d8","1d10", 19,new int[]{2},0,6, "Slashing", "","CRB", "A bastard sword is about 4 feet in length, making it too large to use in one hand without special training; thus, it is an exotic weapon. A character can use a bastard sword two-handed as a martial weapon.", 1),
    SWORD_TEMPLE("Sword, temple","Exotic","One-Handed",30,"1d6","1d8", 19,new int[]{2},0,3, "Slashing", "monk, trip","APG", "Heavy blades typically used by guardians of religious sites, temple swords have distinctive crescent-shaped blades, appearing as an amalgam of a sickle and sword. Many have holes drilled into the blade or places on the pommel where charms, bells, or other holy trinkets might be attached.<br>" +
            "<br>" +
            "Monks are proficient with the temple sword.", 1),
    URUMI("Urumi","Exotic","One-Handed",30,"1d6","1d8", 18,new int[]{2},0,6, "Slashing", "","ISWG", "Commonly known as a whip sword, this deadly weapon is fashioned from one to four 5-foot-long, razor-sharp blades of flexible steel. The weapon is wielded by whipping the blades at one’s opponent. The coiled blade is fine and flexible enough to be worn as a belt.", 1),
    WARAXE_DWARVEN("Waraxe, dwarven","Exotic","One-Handed",30,"1d8","1d10", 20,new int[]{3},0,8, "", "","CRB", "A dwarven waraxe has a large, ornate head mounted to a thick handle, making it too large to use in one hand without special training.<br>" +
            "<br>" +
            "Description: Due to its size, a dwarven waraxe is an exotic weapon. A Medium character can use a dwarven waraxe two-handed as a martial weapon, or a Large creature can use it one-handed in the same way.<br>" +
            "<br>" +
            "Racial Affinity: A dwarf treats a dwarven waraxe as a martial weapon even when using it in one hand.", 1),
    WHIP("Whip","Exotic","One-Handed",1,"1d2","1d3", 20,new int[]{2},0,2, "Slashing", "disarm, nonlethal, reach, trip","CRB", "A whip deals no damage to any creature with an armor bonus of +1 or higher or a natural armor bonus of +3 or higher. The whip is treated as a melee weapon with 15-foot reach, though you don't threaten the area into which you can make an attack. In addition, unlike most other weapons with reach, you can use it against foes anywhere within your reach (including adjacent foes).<br>" +
            "<br>" +
            "Using a whip provokes an attack of opportunity, just as if you had used a ranged weapon.<br>" +
            "<br>" +
            "You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a whip sized for you, even though it isn't a light weapon.<br>" +
            "<br>" +
            "Weapon Feature(s): finesse, reach.", 1),
    AXE_ORC_DOUBLE("Axe, orc double","Exotic","Two-Handed",60,"1d6/1d6","1d8/1d8", 20,new int[]{3},0,15, "Slashing", "double","CRB", "A cruel weapon with blades placed at opposite ends of a long haft.<br>" +
            "<br>" +
            "Description: An orc double axe is a double weapon.<br>" +
            "<br>" +
            "Traits: double weapon", 1),
    BATTLE_LADDER("Battle Ladder","Exotic","Two-Handed",20,"1d4/1d4","1d6/1d6", 20,new int[]{2},0,8, "Bludgeoning", "trip","GoG", "Gnomes use these narrow, reinforced 4-foot ladders as weapons.<br>" +
            "<br>" +
            "Benefit: You fight with a battle ladder like you would with a regular quarterstaff, except that you also use the spaces in the ladder to entangle limbs, giving the ladder the trip weapon feature.<br>" +
            "<br>" +
            "Weapon Feature(s): trip", 1),
    BO_STAFF("Bo staff","Exotic","Two-Handed",1,"1d4","1d6", 20,new int[]{2},0,3, "Bludgeoning", "blocking, double, monk","UC", "Similar to a quarterstaff, only slightly more slender and tapered at one end, the bo staff is both a defensive device and a weapon.", 1),
    CHAIN_SPIKED("Chain, spiked","Exotic","Two-Handed",25,"1d6","2d4", 20,new int[]{2},0,10, "Piercing", "disarm, trip","CRB", "A spiked chain is about 4 feet in length, covered in wicked barbs.<br>" +
            "<br>" +
            "Benefit: You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with a spiked chain sized for you, even though it isn't a light weapon.<br>" +
            "<br>" +
            "Weapon Feature(s): finesse", 1),
    CURVE_BLADE_ELVEN("Curve blade, elven","Exotic","Two-Handed",80,"1d8","1d10", 18,new int[]{2},0,7, "Slashing", "","CRB", "Essentially a longer version of a scimitar, but with a thinner blade, the elven curve blade is exceptionally rare.<br>" +
            "<br>" +
            "Benefit: You receive a +2 circumstance bonus to your Combat Maneuver Defense whenever a foe attempts to sunder your elven curve blade due to its flexible metal.<br>" +
            "<br>" +
            "You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier to attack rolls with an elven curve blade sized for you, even though it isn't a light weapon.<br>" +
            "<br>" +
            "Weapon Feature(s): finesse", 1),
    DORN_DERGAR_DWARVEN("Dorn Dergar, dwarven","Exotic","Two-Handed",50,"1d8","1d10", 20,new int[]{2},0,15, "Bludgeoning", "reach","DoG", "This exotic weapon is a 10-foot-long, heavy metal chain weighted at the end by a round ball of solid iron about the size of a large fist. Though fallen into disuse over the spanning centuries, the dwarven chain-flail is still sometimes employed by dwarves who cling to the old ways.<br>" +
            "<br>" +
            "Benefit: By adjusting the slack of the chain, the weapon can be used either with or without reach.<br>" +
            "<br>" +
            "Action: Changing between using it as a normal weapon and a reach weapon is a move action.<br>" +
            "<br>" +
            "Weapon Feature(s): reach", 1),
    FAUCHARD("Fauchard","Exotic","Two-Handed",14,"1d8","1d10", 18,new int[]{2},0,10, "Slashing", "reach, trip","CHR", "This polearm is similar to a glaive, being a curved blade affixed to the end of a pole. Unlike a glaive, though, the cutting edge of a fauchard is along the concave side, causing the blade to resemble that of a sickle or scythe.<br>" +
            "<br>" +
            "Benefit: The fauchard is more awkward to utilize than a glaive (and as such is an exotic weapon), but its increased threat range over the glaive and the ability to trip foes make it a dangerous weapon in the hands of a skilled user.<br>" +
            "<br>" +
            "Weapon Feature(s): reach, trip", 1),
    FLAIL_DIRE("Flail, dire","Exotic","Two-Handed",90,"6/1d6","8/1d8", 20,new int[]{2},0,10, "Bludgeoning", "disarm, double, trip","CRB", "A dire flail consists of two spheres of spiked iron dangling from chains at opposite ends of a long haft.<br>" +
            "<br>" +
            "Weapon Feature(s): disarm, double, trip", 1),
    FLAILPOLE("Flailpole","Exotic","Two-Handed",15,"1d6","1d8", 20,new int[]{2},0,10, "Slashing", "reach, trip","GoG", "This is simply a heavy flail mounted on the end of a long polearm.<br>" +
            "<br>" +
            "Benefit: A flailpole has the reach and trip weapon qualities.<br>" +
            "<br>" +
            "Weapon Feature(s): reach, trip", 1),
    FLAMBARD("Flambard","Exotic","Two-Handed",50,"1d8","1d10", 19,new int[]{2},0,6, "Slashing", "sunder","AA", "This two-handed sword has a wavy blade that is especially useful for cutting through wooden weapons.<br>" +
            "<br>" +
            "Benefit: If you are proficient with this weapon, you gain a +4 bonus on any sunder attempts made against weapons with a wooden haft; otherwise you may use this sword as a bastard sword.<br>" +
            "<br>" +
            "Weapon Feature(s): +4 sunder bonus vs. wood", 1),
    FLYING_BLADE("Flying blade","Exotic","Two-Handed",40,"1d10","1d12", 20,new int[]{3},0,12, "Slashing", "performance, reach","UC", "A flying blade is a large, crescent-shaped blade anchored to a 10-foot chain.<br>" +
            "<br>" +
            "Benefit: You fight with a flying blade by spinning it about your head or by snapping it toward an opponent. The flying blade is a clumsy weapon and receives a –2 penalty on attack rolls, but when you make attacks of opportunity provoked by movement, you receive a +2 bonus on attack rolls instead of the penalty.", 1),
    GARROTE("Garrote","Exotic","Two-Handed",3,"1d4","1d6", 20,new int[]{2},0,1, "Slashing", "grapple, see text","AA", "A garrote is a length of wire or thin rope with wooden handles at both ends. The wire is placed across a victim's throat and crossed behind the neck; when the handles are pulled tight, the garrote strangles him.<br>" +
            "<br>" +
            "Description: In order for you to use a garrote, your opponent must be helpless or unaware of you. You must make a grapple check (though you avoid the –4 penalty for not having two hands free) to successfully begin garroting your opponent. Sneak attack damage does not apply to a garrote. Your garroted opponent must make a concentration check (DC 20 + your CMB + level of the spell he’s casting) to cast a spell with a verbal component, use a command word item, or use any magic requiring speech. You gain the following additional option when grappling with a garrote.<br>" +
            "<br>" +
            "Choke: You cut off your target’s air supply so he has to hold his breath (see Suffocation, and the Swim skill for additional information). Any round you do not maintain the choke, your opponent can take a breath and restart when he has to begin making Constitution checks.<br>" +
            "<br>" +
            "Weapon Feature(s): choke", 1),
    HAMMER_GNOME_HOOKED("Hammer, gnome hooked","Exotic","Two-Handed",20,"6/1d4","8/1d6", 20,new int[]{3,4},0,6, "Bludgeoning or Piercing", "double, trip","CRB", "A gnome hooked hammer is a double weapon—an ingenious tool with a hammer head at one end of its haft and a long, curved pick at the other.<br>" +
            "<br>" +
            "Description: The hammer's blunt head is a bludgeoning weapon that deals 1d6 points of damage (crit ×3). Its hook is a piercing weapon that deals 1d4 points of damage (crit ×4). You can use either head as the primary weapon.<br>" +
            "<br>" +
            "Racial Weapon: Gnomes treat hooked hammers as martial weapons.<br>" +
            "<br>" +
            "Weapon Feature(s): double, trip", 1),
    KAMA_DOUBLE_CHAINED("Kama, double-chained","Exotic","Two-Handed",8,"1d4/1d4","1d6/1d6", 20,new int[]{2},0,4, "Slashing", "double, monk, reach, trip","UC", "This weapon comprises a pair of kama connected with an 8-foot length of chain.<br>" +
            "<br>" +
            "Benefit: The wielder can attack as if armed with a single kama in each hand or extend the chain to make a single reach attack. By swinging the rope, the wielder can whip the kama about to disarm or trip opponents. Furthermore, if one of the weapons is dropped, the wielder can retrieve as a free action by pulling on the chain.", 1),
    KATANA_DOUBLE_WALKING_STICK("Katana, double walking stick","Exotic","Two-Handed",50,"4/1d4","6/1d6", 20,new int[]{3},0,6, "Bludgeoning", "double","UC", "This single case conceals a pair of matched fighting swords perfectly balanced to be wielded as a pair. Despite their name, the blades more closely resemble the shorter wakizashi.<br>" +
            "<br>" +
            "Benefit: When drawn, the blades use the statistics listed on the table. When the blades are concealed in their case, this weapon can be used as a quarterstaff.", 1),
    KUSARIGAMA_SICKLE_AND_CHAIN("Kusarigama (sickle and chain)","Exotic","Two-Handed",12,"2/1d4","3/1d6", 20,new int[]{2},0,3, "Slashing or Bludgeoning", "double, monk, reach, trip, grapple","UC", "This weapon has a single sickle held in the off-hand attached by 10 feet of fine chain to a weighted metal ball.<br>" +
            "<br>" +
            "Benefit: The sickle is used to make trips, jabs, and blocks while the ball is whipped around at high speeds and then smashed into the opponent.", 1),
    KYOKETSU_SHOGE("Kyoketsu shoge","Exotic","Two-Handed",6,"1d3","1d4", 20,new int[]{2},20,1, "Slashing or Piercing", "disarm, grapple, monk, reach","UC", "This weapon consists of a foot-long double-edged blade, with another smaller, curved hook-blade sticking out the side like a rooster’s spur. The blade is strung to a large iron hoop with 10-foot length of rope.<br>" +
            "<br>" +
            "Benefit: The blade can be used as an off-hand melee weapon or thrown like a dagger, while the rope and circlet can be whipped around and swung at opponents as a bludgeoning reach weapon.", 1),
    MANCATCHER("Mancatcher","Exotic","Two-Handed",15,"1","1d2", 20,new int[]{2},0,10, "Piercing", "grapple, reach, see text","APG", "This polearm consists of two curved metal bands that close around a target when you attack, allowing you to bind an opponent.<br>" +
            "<br>" +
            "Benefit: A mancatcher is built to capture a creature of a particular size category (such as Small or Medium) and doesn’t work on creatures of the wrong size. Make a touch attack to hit an opponent and a combat maneuver check to grapple him (without the –4 penalty for not having two hands free); success means you and the target are grappled, but you do not move into the same space. Once the target is grappled, you can perform a move or damage grapple action against him.<br>" +
            "<br>" +
            "The mancatcher has hardness 10 and 5 hit points; it requires a DC 26 Strength check to break it. If you drop the mancatcher, the target can free himself as a standard action.<br>" +
            "<br>" +
            "Weapon Feature(s): reach, grapple", 1),
    METEOR_HAMMER("Meteor hammer","Exotic","Two-Handed",10,"1d6","1d8", 20,new int[]{2},0,10, "Bludgeoning", "reach, trip","UC", "This weapon consists of one or two spherical weights attached by a 10-foot chain. You whirl the weights and wrap them around an opponent’s body.<br>" +
            "<br>" +
            "Benefit: If you succeed at a trip attempt with a meteor hammer, you can drag your opponent 5 feet closer to you rather than knocking her prone.<br>" +
            "<br>" +
            "You may use this weapon in two different ways:<br>" +
            "<br>" +
            "Meteor: In meteor mode you use it as a double weapon.<br>" +
            "Fortress: In fortress mode you cannot use it as a double weapon but gain reach and a +1 shield bonus to AC.<br>" +
            "Switching between these two modes is a free action decided at the start of your turn.", 1),
    PISTON_MAUL("Piston maul","Exotic","Two-Handed",70,"1d8","1d10", 20,new int[]{2},0,15, "Bludgeoning", "see text","GoG", "An alchemically-fired piston in the head of this two-handed hammer strikes targets with astounding force.<br>" +
            "<br>" +
            "Benefit: Successful sunder attacks made with a piston maul deal an additional +4 points of damage. A piston maul requires a thunderstone to function; otherwise you treat it as a greatclub. Inserting a thunderstone into the weapon’s compartment is a standard action, and powers the weapon for 24 hours, after which the thunderstone is consumed.", 1),
    RIPSAW_GLAIVE("Ripsaw glaive","Exotic","Two-Handed",30,"1d8","1d10", 20,new int[]{3},0,12, "Slashing", "reach, see text","GoG", "The blade of this glaive is serrated and mounted on an axle with a heavy cord wrapped around it.<br>" +
            "<br>" +
            "Benefit: A heavy cord is wrapped around the axle; when pulled (a move action), the blade spins rapidly for a number of rounds equal to your Strength bonus. While the blade is spinning, it deals +2 damage; otherwise, treat this weapon as a glaive. Re-wrapping the cord around the spinning mechanism is a full-round action that provokes an attack of opportunity.", 1),
    SCARF_BLADED("Scarf, bladed","Exotic","Two-Handed",12,"1d4","1d6", 20,new int[]{2},0,2, "Slashing", "disarm, trip","ISWG", "If you are proficient with a bladed scarf, you deal 1d6 points of slashing damage to any creature that makes a successful grapple check against you.<br>" +
            "<br>" +
            "You can use the Weapon Finesse feat to apply your Dexterity modifier instead of your Strength modifier on attack rolls with a bladed scarf sized for you, even though it isn’t a light weapon.<br>" +
            "<br>" +
            "The skill required in using such scarves effectively and not revealing their deadly nature makes them exotic weapons. If you are proficient with a bladed scarf, you deal 1d4 points of slashing damage to any creature that makes a successful grapple check against you while you wield the scarf. ", 1),
    SPEAR_TOTEM("Spear, totem","Exotic","Two-Handed",25,"1d8","1d10", 20,new int[]{3},10,6, "Piercing or Slashing", "see text","CRB", "The shaft of this traditional Sklar-Quah spear is carved with sacred symbols, and its wide head is drilled with cunning holes that create a loud whistling when the weapon is hurled or used in combat — by turning the spear so that the wind blows over its holes in different orientations, or by varying the speed at which it is swung, a wielder can create mournful dirges.<br>" +
            "<br>" +
            "Description: If the user is trained in the spear’s use, a totem spear can be used by bards to create bardic music effects using Perform (wind instrument). The spear itself has a strong, flexible shaft, and in the hands of one trained in its use, grants a +2 circumstance bonus on Acrobatics checks. The spear’s relatively wide head allows it to be used as a slashing weapon, swung side to side, or as a piercing weapon in a more traditional spear-fighting technique.<br>" +
            "<br>" +
            "Weapon Feature(s): Piercing (P) or Slashing (S)", 1),
    SWORD_SEVEN_BRANCHED("Sword, seven-branched","Exotic","Two-Handed",50,"1d8","1d10", 20,new int[]{3},0,7, "Slashing", "disarm, monk","UC", "This unusual sword has a straight 2-foot-long blade with six shorter L-shaped blades protruding, three on each side in a staggered pattern.<br>" +
            "<br>" +
            "Benefit: The shorter blades can be used to snag opponents’ clothing or armor, or can target weapons in order to disarm them. To snag armor or clothing, the attacker makes a trip attempt. If successful, the victim doesn’t fall prone, but instead is snagged and stumbles forward, leaving the victim flat-footed for the remainder of the round.", 1),
    SWORD_TWO_BLADED("Sword, two-bladed","Exotic","Two-Handed",100,"1d6/1d6","1d8/1d8", 19,new int[]{2},0,10, "Slashing", "double","CRB", "A two-bladed sword is a double weapon—twin blades extend from either side of a central, short haft, allowing the wielder to attack with graceful but deadly flourishes.<br>" +
            "<br>" +
            "Weapon Feature(s): double", 1),
    TETSUBO("Tetsubo","Exotic","Two-Handed",20,"1d8","1d10", 20,new int[]{4},0,10, "Bludgeoning", "","UC", "", 1),
    URGROSH_DWARVEN("Urgrosh, dwarven","Exotic","Two-Handed",50,"6/1d4","8/1d6", 20,new int[]{3},0,12, "Piercing or Slashing", "brace, double","CRB", "A slight improvement over the great club, this weapon consists of a long, slender length whose upper half is shod with a thick sheet of studded iron. The iron gives added weight and strength to the club, while the studs are designed to crack helmets and armor.", 1),
    BOLA("Bola","Exotic","Ranged",5,"1d3","1d4", 20,new int[]{2},10,2, "Bludgeoning", "nonlethal, trip","CRB", "A bolas is a pair of weights, connected by a thin rope or cord. <br>" +
            "<br>" +
            "Benefit: You can use a bolas to make a ranged trip attack against an opponent. You can't be tripped during your own trip attempt when using a bolas.<br>" +
            "<br>" +
            "Weapon Feature(s): trip (ranged)", 1),
    BOLA_SHOANTI("Bola, Shoanti","Exotic","Ranged",15,"1d3","1d4", 20,new int[]{2},10,2, "Bludgeoning and Piercing", "trip","ISWG", "A Shoanti bolas is similar to normal a bolas in all but two respects. The first is that the Shoanti create these not to injure and knock the target out, as most bolas are, but to kill. The second is the unique holes in the weights allow them to give a wail when spun overhead.", 1),
    BOOMERANG("Boomerang","Exotic","Ranged",3,"1d4","1d6", 20,new int[]{2},30,3, "Bludgeoning", "","APG", "The boomerang is primarily a hunting tool, but it is not uncommon for these versatile thrown weapons to be carried into battle. A boomerang is made of wood and is flat, with a long haft, a pronounced forward curve, and a sharp backward bend at the head.<br>" +
            "<br>" +
            "Note: A thrown boomerang does not fly in a returning path; returning boomerangs are solely recreational.", 1),
    BOW_THORN("Bow, thorn","Exotic","Ranged",50,"1d4","1d6", 20,new int[]{3},40,2, "Piercing", "","AA", "This polished rosewood bow is studded with thorns and tiny flowers.<br>" +
            "<br>" +
            "Description: Treat a thorn bow as a shortbow.", 1),
    CHAKRAM_CRYSTAL("Chakram, crystal","Exotic","Ranged",20,"1d4","1d6", 18,new int[]{2},0,2, "Slashing", "","CHR", "Shaped and carved from quartz or stranger subterranean crystals, these circular throwing discs have jagged razor-sharp edges.<br>" +
            "<br>" +
            "Benefit: When a crystal chakram strikes a foe, the weapon shatters into tiny sharp fragments; if it misses, there is a 50% chance the chakram shatters when it hits the ground or another solid object; otherwise it can be retrieved and used again.<br>" +
            "<br>" +
            "Special: A crystal chakram is treated as ammunition for the purpose of creating magic weapons.", 1),
    CROSSBOW_DOUBLE("Crossbow, double","Exotic","Ranged",300,"1d6","1d8", 19,new int[]{2},80,18, "Piercing", "","APG", "This heavy weapon fires a pair of iron-tipped bolts with a single squeeze of the trigger.<br>" +
            "<br>" +
            "Benefit: Make one attack roll. If the attack hits, the target takes damage from both bolts. Critical hits, sneak attack damage, and other precision-based damage only apply to the first bolt.<br>" +
            "<br>" +
            "Drawback: Due to its size and weight, you take a –4 penalty on your attack roll if you’re proficient with it, or –8 if you’re not.<br>" +
            "<br>" +
            "Load: Loading one bolt is a standard action; the Rapid Reload feat reduces this to a move action. Crossbow Mastery allows you to reload both bolts as a single move action. ", 1),
    CROSSBOW_HAND("Crossbow, hand","Exotic","Ranged",100,"1d3","1d4", 19,new int[]{2},30,2, "Piercing", "","CRB", "Load: Loading a hand crossbow is a move action that provokes attacks of opportunity.<br>" +
            "<br>" +
            "Note: You can draw a hand crossbow back by hand. You can shoot, but not load, a hand crossbow with one hand at no penalty. You can shoot a hand crossbow with each hand, but you take a penalty on attack rolls as if attacking with two light weapons.", 1),
    CROSSBOW_LAUNCHING("Crossbow, launching","Exotic","Ranged",75," "," ", 20,new int[]{},30,8, "", "see text","AA", "This stubby-looking crossbow has a cup-like attachment rather than a groove for a bolt.<br>" +
            "<br>" +
            "Benefit: A launching crossbow is designed to launch splash weapons.<br>" +
            "<br>" +
            "Load: Full-round action that provokes attacks of opportunity.", 1),
    CROSSBOW_REPEATING("Crossbow, repeating","Exotic","Ranged",250,"1d6","1d8", 19,new int[]{2},80,6, "Piercing", "","CRB", "Load: As long as it holds bolts, you can reload it by pulling the reloading lever (a free action). Loading a new case of 5 bolts is a full-round action that provokes attacks of opportunity.<br>" +
            "<br>" +
            "Note: The repeating crossbow (whether heavy or light) holds 5 crossbow bolts. You can fire a repeating crossbow with one hand or fire a repeating crossbow in each hand in the same manner as you would a normal crossbow of the same size. However, you must fire the weapon with two hands in order to use the reloading lever, and you must use two hands to load a new case of bolts.", 1),
    CROSSBOW_REPEATING_HEAVY("Crossbow, repeating heavy","Exotic","Ranged",400,"1d8","1d10", 19,new int[]{2},120,12, "Piercing", "","CRB", "Load: As long as it holds bolts, you can reload it by pulling the reloading lever (a free action). Loading a new case of 5 bolts is a full-round action that provokes attacks of opportunity.<br>" +
            "<br>" +
            "Note: The repeating crossbow (whether heavy or light) holds 5 crossbow bolts. You can fire a repeating crossbow with one hand or fire a repeating crossbow in each hand in the same manner as you would a normal crossbow of the same size. However, you must fire the weapon with two hands in order to use the reloading lever, and you must use two hands to load a new case of bolts.", 1),
    FLASK_THROWER("Flask Thrower","Exotic","Ranged",25," "," ", 20,new int[]{},20,4, "", "see text","GoG", "This weapon resembles a halfling sling staff, except that the cradle at the end is designed to hold and hurl flasks as well as stones or bullets.<br>" +
            "<br>" +
            "Benefit: A flask thrower significantly extends the range of thrown substances that deal splash damage, such as acid, alchemist’s fire, or holy water, as well as that of tools such as tanglefoot bags, thunderstones, or caltrops.", 1),
    LASSO("Lasso","Exotic","Ranged",1," "," ", 20,new int[]{},0,5, "", "see text","APG", "This thrown weapon is a length of rope with a simple open knot on one end.<br>" +
            "<br>" +
            "Benefit: A lasso allows you to entangle a foe like you would using a net. An entangled creature can slip free with a DC 15 Escape Artist check as a full-round action. The lasso has 2 hit points and AC 10. It requires a DC 23 Strength check to break it. The concentration DC to cast a spell while entangled with a lasso is 10 + the spell level being cast. <br>" +
            "<br>" +
            "Special: On a successful hit, the lasso tightens; to use it again you must spend a standard action sliding the knot to enlarge the loop.", 10),
    NET("Net","Exotic","Ranged",20," "," ", 20,new int[]{},10,6, "", "","CRB", "A net is used to entangle enemies.<br>" +
            "<br>" +
            "Benefit: When you throw a net, you make a ranged touch attack against your target. A net's maximum range is 10 feet. If you hit, the target is entangled. An entangled creature takes a –2 penalty on attack rolls and a –4 penalty on Dexterity, can move at only half speed, and cannot charge or run. If you control the trailing rope by succeeding on an opposed Strength check while holding it, the entangled creature can move only within the limits that the rope allows. If the entangled creature attempts to cast a spell, it must make a concentration check with a DC of 15 + the spell's level or be unable to cast the spell.<br>" +
            "<br>" +
            "An entangled creature can escape with a DC 20 Escape Artist check (a full-round action). The net has 5 hit points and can be burst with a DC 25 Strength check (also a full-round action). A net is useful only against creatures within one size category of you.<br>" +
            "<br>" +
            "A net must be folded to be thrown effectively. The first time you throw your net in a fight, you make a normal ranged touch attack roll. After the net is unfolded, you take a –4 penalty on attack rolls with it. It takes 2 rounds for a proficient user to fold a net and twice that long for a non-proficient one to do so.", 1),
    ROPE_DART("Rope dart","Exotic","Ranged",1,"1d3","1d4", 20,new int[]{2},20,0, "Piercing", "blocking, distracting, monk","UC", "This deceptively complex weapon appears as nothing more than a 12-foot rope with a 6-inch-long, conical metal spike.<br>" +
            "<br>" +
            "Benefit: Similar to a meteor hammer, a rope dart can be whirled at great speeds, then aimed to strike and pierce opponents with great reach. Once it strikes, the wielder can quickly retrieve the weapon with a tug of the rope.", 1),
    SHIELD_THROWING("Shield, throwing","Exotic","Ranged",+50,"1d4","1d6", 20,new int[]{2},20,0, "Bludgeoning", "performance, trip","UC", "Benefit: This shield is designed for throwing and has specially designed straps allowing you to unclasp and throw it as a free action. Tower shields cannot be throwing shields. Neither a shield’s enhancement bonus to AC nor its shield spikes apply on your attack or damage rolls.", 1),
    SHRILLSHAFT_JAVELIN("Shrillshaft javelin","Exotic","Ranged",35,"1d4","1d6", 20,new int[]{2},30,3, "Piercing", "see text","GoG", "This single-use javelin bears a thunderstone in its haft, just behind the weapon’s head.<br>" +
            "<br>" +
            "Benefit: If you hit with one of these javelins, the target takes javelin damage as normal and is the center of the thunderstone’s effect. If you miss, roll to see where the javelin lands (as if determining a miss with a splash weapon); that square becomes the center of the thunderstone’s effect.", 1),
    SLING_GLOVE("Sling glove","Exotic","Ranged",5,"1d3","1d4", 20,new int[]{2},50,2, "Bludgeoning", "","AA", "This curved, scooped-shaped, 2-foot-long wicker basket attaches to your wrist, allowing you to throw fist-sized stones at great speed merely by whipping your arm forward.<br>" +
            "<br>" +
            "Action: Loading a sling glove is a free action that does not provoke an attack of opportunity so long as you have a free hand. <br>" +
            "<br>" +
            "Drawback: You take –4 penalty when throwing a stone at an adjacent target and cannot use the weapon to attack creatures in your space.", 1),
    SLING_STAFF_HALFLING("Sling staff, halfling","Exotic","Ranged",20,"1d6","1d8", 20,new int[]{3},80,3, "Bludgeoning", "","CRB", "Made from a specially designed sling attached to a short club, a halfling sling staff can be used by a proficient wielder to devastating effect.<br>" +
            "<br>" +
            "Description: Your Strength modifier applies to damage rolls when you use a halfling sling staff just as it does for thrown weapons. You can fire, but not load, a halfling sling staff with one hand. You can hurl ordinary stones with a halfling sling staff, but stones are not as dense or as round as bullets. Thus, such an attack deals damage as if the weapon were designed for a creature one size category smaller than you and you take a –1 penalty on attack rolls. A halfling sling staff can be used as a simple weapon that deals bludgeoning damage equal to that of a club of its size.<br>" +
            "<br>" +
            "Action: Loading a halfling sling staff is a move action that requires two hands and provokes attacks of opportunity.<br>" +
            "<br>" +
            "Racial Specialty: Halflings treat halfling sling staves as martial weapons.", 1),
    SLING_DOUBLE("Sling, double","Exotic","Ranged",10,"1d3","1d4", 20,new int[]{2},50,1, "Bludgeoning", "double, see text","HoG", "At first glance resembling a baton-like stick with a sling dangling from each end, this weapon requires extraordinary skill, or halfling acrobatics, to use to full effect.<br>" +
            "<br>" +
            "Benefit: You can use a double sling as a normal sling, or use the second end to make one additional ranged attack each round. You take the normal penalties for fighting with two weapons when you use both ends of a double sling (as if it were a double weapon); the Two- Weapon Fighting feat reduces these penalties as normal. Reloading one end of a double sling is a move action ( just like a normal sling), so unless you have an ability or feat (such as Ammo Drop) that allows you to quickly reload a sling, you cannot normally make multiple attacks per round for several consecutive rounds with this weapon.<br>" +
            "<br>" +
            "You can hurl ordinary stones with a double sling, but stones are not as dense or as round as bullets. Thus, such an attack deals damage as if the weapon were designed for a creature one size category smaller than you, and you take a –1 penalty on attack rolls.", 1),
    SLING_STITCHED("Sling, stitched","Exotic","Ranged",0,"1d4","1d6", 20,new int[]{2},0,1, "Bludgeoning", "disarm, trip","HoG", "Technically not a unique kind of weapon, a stitched sling is a sling, staff sling, or double sling whose cup is sewn closed around the ammunition, creating a weak sort of light flail. the ammunition sewn into the sling is irrelevant to the type and amount of damage it causes. A stitched sling cannot be used to fire ammunition unless the thread or cord holding the cup closed is cut open (a full-round action that provokes attacks of opportunity).", 1),
    CROSSBOW_BOLT_HEAVY_LIGHT_HAND("Crossbow bolt, heavy/light/hand","Exotic","Ammunition",1," "," ", 20,new int[]{},0,1, "", "","CRB", "Benefit: Bolts come in a case or quiver that holds 10 bolts (or 5 for a repeating crossbow).<br>" +
            "<br>" +
            "Special: A crossbow bolt used as a melee weapon is treated as a light improvised weapon (–4 penalty on attack rolls) and deals damage as a dagger of its size (crit ×2).", 10),
    CROSSBOW_BOLT_REPEATING_HEAVY_LIGHT("Crossbow bolt, repeating, heavy/light","Exotic","Ammunition",1," "," ", 20,new int[]{},0,1, "", "","CRB", "Benefit: Bolts come in a case or quiver that holds 10 bolts (or 5 for a repeating crossbow).<br>" +
            "<br>" +
            "Special: A crossbow bolt used as a melee weapon is treated as a light improvised weapon (–4 penalty on attack rolls) and deals damage as a dagger of its size (crit ×2).", 5),
    LITTLE_STARSTONES("Little starstones","Exotic","Ammunition",1,"1","1", 20,new int[]{},0,2, "Bludgeoning", "nonlethal","HoG", "Though they are technically sling ammunition, these thread- or cloth-wrapped pebbles are mainly used for signaling or celebration rather than battle, as they barely hit hard enough to sting. When soaked in oil or strong alcohol, they burn brightly for 1 round, illuminating an area like a candle and creating brief streaks of light as they fly through the air. They generally aren’t hot enough and burn out too quickly to ignite combustibles.", 200),
    SHARPSTONES("Sharpstones","Exotic","Ammunition",1,"1d3","1d4", 20,new int[]{},0,5, "Piercing or Slashing", "","HoG", "A thin layer of baked clay covers the spikes and jagged ridges covering this specially designed bullet. A proficient user knows how to crack the clay (a free action) so that it peels off from either the spikes or ridges when fired, dealing either piercing or slashing damage.", 10),
    SHURIKEN("Shuriken","Exotic","Ammunition",1,"1","1d2", 20,new int[]{2},10,0.5, "Piercing", "monk","CRB", "A shuriken is a small piece of metal with sharpened edges, designed for throwing.<br>" +
            "<br>" +
            "Benefit: Although they are thrown weapons, shuriken are treated as ammunition for the purposes of drawing them, crafting masterwork or otherwise special versions of them, and what happens to them after they are thrown.<br>" +
            "<br>" +
            "Drawback: A shuriken can't be used as a melee weapon.<br>" +
            "<br>" +
            "Traits: ammunition, monk", 5),
    SOFTSTONES("Softstones","Exotic","Ammunition",1," "," ", 20,new int[]{},0,4, "Bludgeoning", "nonlethal","HoG", "These tight bundles of elastic fibers deal nonlethal damage when fired from a sling.", 100),
    SPONGESTONES("Spongestones","Exotic","Ammunition",10," "," ", 20,new int[]{},0,2, "Piercing", "","HoG", "These bullets are actually made from a porous stone or heavy wood that absorbs liquids and shatters on impact.<br>" +
            "<br>" +
            "Soakstones are often used to deliver poison or burning oil. A flask of oil completely saturates 10 soakstones. When ignited (a free action if fire is available), a burning, oil-soaked soakstone deals +1d2 fire damage and can ignite combustible materials (such as a thatched roof ). Allowing a soakstone to burn in a sling’s cup for more than 1d3 rounds gives the sling the broken condition.", 10),
    THORN("Thorn","Exotic","Ammunition",1," "," ", 20,new int[]{},0,1, "", "","W1", "These small arrows are tipped with a wicked rose thorn and fletched with lacquered rose petals.", 20);

    private final String name;
    private final String type;
    private final String subtype;
    private final int cost;
    private final String sDMG;
    private final String mDMG;
    private final int minThreatRoll;
    private final int[] critMultiplier;
    private final int range;
    private final double weight;
    private final String damageType;
    private final String special;
    private final String source;
    private final String description;
    private final int amount;

    WeaponEnum(String name, String type, String subtype, int cost, String sDMG, String mDMG, int minThreatRoll, int[] critMultiplier, int range, double weight, String damageType, String special, String source, String description, int amount) {
        this.name = name;
        this.type = type;
        this.subtype = subtype;
        this.cost = cost;
        this.sDMG = sDMG;
        this.mDMG = mDMG;
        this.minThreatRoll = minThreatRoll;
        this.critMultiplier = critMultiplier;
        this.range = range;
        this.weight = weight;
        this.damageType = damageType;
        this.special = special;
        this.source = source;
        this.description = description;
        this.amount = amount;
    }

    public String toString() {
        return name +  (amount > 1 ? " (" + amount + ")" : "");
    }

    public int getMaxDex(){
        return -1;
    }

    public int getACPen(){
        return 0;
    }

    public int[] cost(){
        return new int[]{0,cost,0,0};
    }

    public int getACBoost(){
        return 0;
    }

    public double weight(){
        return weight;
    }

    public int speedChange(int initialSpeed){
        return initialSpeed;
    }

    public String getFormattedDetails(){
        String toReturn = toString() + "<br>";
        toReturn += "Damage: Small = " + sDMG + " &nbsp; &nbsp; &nbsp; &nbsp; Medium = " + mDMG + " <br> Damage type: " + damageType + "<br>";
        String critString = "Critical multipliers: ";

        for(int i : critMultiplier) critString += "x" + i + "/";
        critString = critString.substring(0,critString.length() - 1);
        critString += " (" + minThreatRoll + "-20)";
        toReturn += critString + "<br>";

        if(range != 0) toReturn += "Range: " + range + " ft.<br>";
        toReturn += "Weight: " + weight + "lbs.<br>";
        toReturn += "Special: " + special + "<br>";
        toReturn += cost + " gold for " + amount + "<br>";
        toReturn += "<br>";
        toReturn += description;
        toReturn += "<br>" + "Source: " + source;

        return toReturn;
    }

    public String getInventoryLine(){
        return name;
    }

    public int getPurchaseAmount(){
        return amount;
    }

    public String getItemName(){
        return name;
    }

    public String source(){
        return source;
    }

    public String type(){
        return type;
    }

    public String subtype(){
        return subtype;
    }

    public String sDMG(){
        return sDMG;
    }

    public String mDMG(){
        return mDMG;
    }

    public int minThreatRoll(){
        return minThreatRoll;
    }

    public int[] critMultiplier(){
        return critMultiplier;
    }

    public int range(){
        return range;
    }

    public String damageType(){
        return damageType;
    }

    public String special(){
        return special;
    }

    public URL getIcon(){
        if(subtype.contains("Ammunition")){
            return WeaponEnum.class.getResource("/src/pictures/itemIcons/S_Bow11.png");
        }
        if(subtype.contains("Ranged") && name.toLowerCase().contains("bow")){
            return WeaponEnum.class.getResource("/src/pictures/itemIcons/Bow.png");
        }
        if(subtype.toLowerCase().contains("unarmed")){
            return WeaponEnum.class.getResource("/src/pictures/itemIcons/MagicGauntlet.png");
        }
        if(damageType.toLowerCase().contains("bludgeoning")){
            return WeaponEnum.class.getResource("/src/pictures/itemIcons/W_Mace004.png");
        }
        if(damageType.toLowerCase().contains("piercing")){
            return WeaponEnum.class.getResource("/src/pictures/itemIcons/Spear.png");
        }
        if(damageType.toLowerCase().contains("slashing")){
            return WeaponEnum.class.getResource("/src/pictures/itemIcons/SlashingSword.png");
        }
        return WeaponEnum.class.getResource("/src/pictures/itemIcons/SlashingSword.png");

        //This needs to be broken down more - the weapon icons won't always fit well with the weapon.
    }
}