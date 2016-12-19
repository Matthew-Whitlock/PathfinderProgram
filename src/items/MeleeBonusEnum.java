package src.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Matthew on 12/16/2016.
 */
public enum MeleeBonusEnum {

    IMPERVIOUS("Impervious", 3000, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +3,000 gp<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>impervious</i> weapon is warded from damage and decay. A metallic weapon cannot rust and a wooden weapon cannot rot or warp, even by magical or <a href=\"http://www.d20pfsrd.com/magic#TOC-Supernatural-Abilities-Su-\">supernatural</a> means. An <i>impervious</i> weapon gains double the normal bonus to its <a href=\"http://www.d20pfsrd.com/equipment---final/damaging-objects#TOC-Hardness\">hardness</a> and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a> for each point of its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>. The break DC for an <i>impervious</i> weapon and the wielder's <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> defense against <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Sunder\">sunder</a> maneuvers against the <i>impervious</i> weapon each gain a bonus equal to twice the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fabricate\" style=\"font-style:italic\">fabricate</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/make-whole\" style=\"font-style:italic\">make whole</a>; <b>Cost</b> +1,500 gp</p>\n" +
            "</div></div></td>"),
    GLAMERED("Glamered", 4000, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +4,000 gp<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Illusion\">illusion</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>glamered</i> weapon can be commanded to change its shape and appearance to assume the form of another object of similar size. The weapon retains all its properties (including weight) when so disguised but does not radiate magic. Only <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/true-seeing\" style=\"font-style:italic\">true seeing</a> or similar magic reveals the true nature of a <i>glamered</i> weapon while it is disguised. After a glamered weapon is used to attack, this special ability is suppressed for 1 minute.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/disguise-self\" style=\"font-style:italic\">disguise self</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/magic-aura\" style=\"font-style:italic\">magic aura</a>; <b>Cost</b> +2,000 gp</p>\n" +
            "</div></div></td>"),
    ALLYING("Allying", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>allying</i> weapon allows the wielder to transfer some or all of the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to one weapon being used by an ally of the wielder. The wielder must have line of sight to the intended ally. As a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>, at the start of her turn before using her weapon, the wielder chooses how to allocate her weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>. The bonus to the ally's weapon lasts until the <i>allying</i> weapon's wielder's next turn. The <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> from the <i>allying</i> weapon does not stack with the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> on the ally's weapon (if any).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/magic-weapon\" style=\"font-style:italic\">magic weapon</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    BANE("Bane", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>bane</i> weapon excels against certain foes. Against a designated foe, the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> is +2 better than its actual bonus. It also deals an extra 2d6 points of damage against such foes. To randomly determine a weapon's designated foe, roll on the following table.</p>\n" +
            "<table border=\"1\" bordercolor=\"#888888\" cellpadding=\"5\" style=\"border-color:rgb(136,136,136);border-width:1px;border-collapse:collapse\">\n" +
            "<tbody>\n" +
            "<tr style=\"background-color:rgb(207,226,243)\">\n" +
            "<th style=\"text-align:center\">d%</th>\n" +
            "<th style=\"text-align:center\">Designated Foe</th>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"text-align:center\">01—05</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Aberration\">Aberrations</a></td>\n" +
            "</tr>\n" +
            "<tr style=\"background-color:rgb(243,243,243)\">\n" +
            "<td style=\"text-align:center\">06—09</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">Animals</a></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"text-align:center\">10—16</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Construct\">Constructs</a></td>\n" +
            "</tr>\n" +
            "<tr style=\"background-color:rgb(243,243,243)\">\n" +
            "<td style=\"text-align:center\">17—22</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Dragon\">Dragons</a></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"text-align:center\">23—27</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Fey\">Fey</a></td>\n" +
            "</tr>\n" +
            "<tr style=\"background-color:rgb(243,243,243)\">\n" +
            "<td style=\"text-align:center\">28—60</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Humanoid\">Humanoids</a> (pick one subtype)</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"text-align:center\">61—65</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Magical-Beast\">Magical beasts</a></td>\n" +
            "</tr>\n" +
            "<tr style=\"background-color:rgb(243,243,243)\">\n" +
            "<td style=\"text-align:center\">66—70</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Monstrous-Humanoid\">Monstrous humanoids</a></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"text-align:center\">71—72</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Ooze\">Oozes</a></td>\n" +
            "</tr>\n" +
            "<tr style=\"background-color:rgb(243,243,243)\">\n" +
            "<td style=\"text-align:center\">73—88</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Outsider\">Outsiders</a> (pick one subtype)</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"text-align:center\">89—90</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Plant\">Plants</a></td>\n" +
            "</tr>\n" +
            "<tr style=\"background-color:rgb(243,243,243)\">\n" +
            "<td style=\"text-align:center\">91—98</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">Undead</a></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td style=\"text-align:center\">99—100</td>\n" +
            "<td><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Vermin\">Vermin</a></td>\n" +
            "</tr>\n" +
            "</tbody></table>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/summon-monster\" style=\"font-style:italic\">summon monster I</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    BENEVOLENT("Benevolent", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This ability can only be placed on a melee weapon.</p><p>When the wielder of a <i>benevolent</i> weapon uses the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Aid-Another\">aid another</a> action to grant an ally a bonus on <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attack-Roll\">attack rolls</a>, he increases the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Aid-Another\">aid another</a> bonus by the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> of the weapon.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/aid\" style=\"font-style:italic\">aid</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CALLED("Called", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 9th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>called</i> weapon can be teleported to the wielder's hand as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a> that does not provoke <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attacks-of-Opportunity\">attacks of opportunity</a>, even if the weapon is in the possession of another creature. This ability has a maximum range of 100 feet, and effects that block <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration-Teleportation\">teleportation</a> prevent the return of a <i>called</i> weapon. A <i>called</i> weapon must be in a creature's possession for at least 24 hours for this ability to function.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/teleport\" style=\"font-style:italic\">teleport</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CONDUCTIVE("Conductive", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus; <b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>conductive</i> weapon is able to channel the energy of a <a href=\"http://www.d20pfsrd.com/magic#TOC-Spell-Like-Abilities-Sp-\">spell-like</a> or <a href=\"http://www.d20pfsrd.com/magic#TOC-Supernatural-Abilities-Su-\">supernatural</a> ability that relies on a melee or ranged <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch attack</a> to hit its target (such as from a <a href=\"http://www.d20pfsrd.com/classes/core-classes/cleric\">cleric's</a> domain granted power, <a href=\"http://www.d20pfsrd.com/classes/core-classes/sorcerer\">sorcerer's</a> <a href=\"http://www.d20pfsrd.com/classes/core-classes/sorcerer#TOC-Bloodline\">bloodline power</a>, <a href=\"http://www.d20pfsrd.com/classes/base-classes/oracle\">oracle's</a> mystery revelation, or <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard\">wizard's</a> arcane school power). When the wielder makes a successful attack of the appropriate type, he may choose to expend two uses of his magical ability to channel it through the weapon to the struck opponent, which suffers the effects of both the weapon attack and the special ability. (If the wielder has unlimited uses of a special ability, she may channel through the weapon every round.) For example, a <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin\">paladin</a> who strikes an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> opponent with her <i>conductive</i> <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/greatsword\">greatsword</a> can expend two uses of her <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin#TOC-Lay-On-Hands-Su-\">lay on hands</a> ability (a <a href=\"http://www.d20pfsrd.com/magic#TOC-Supernatural-Abilities-Su-\">supernatural</a> melee <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch attack</a>) to deal both <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/greatsword\">greatsword</a> damage and damage from one use of <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin#TOC-Lay-On-Hands-Su-\">lay on hands</a>. <br></p><p>A given character can use this weapon special ability only once per round (even if she has several <i>conductive</i> weapons), and the power works only with magical abilities of the same type as the weapon (melee or ranged).<br></p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/spectral-hand\" style=\"font-style:italic\">spectral hand</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CORROSIVE("Corrosive", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a <i>corrosive</i> weapon becomes slick with acid that deals an extra 1d6 points of acid damage on a successful hit. The acid does not harm the wielder. The effect remains until another command is given.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/acid-arrow\" style=\"font-style:italic\">acid arrow</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    COUNTERING("Countering", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>countering</i> weapon gives its wielder a +2 bonus to his <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">combat maneuver defense</a> against <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuvers</a> made to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Disarm\">disarm</a> or <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Sunder\">sunder</a> this weapon. If the attempt fails, the wielder can immediately attempt the same maneuver against the opponent without provoking <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attacks-of-Opportunity\">attacks of opportunity</a>. The wielder never risks dropping his weapon with a failed <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Disarm\">disarm</a> <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> when counterattacking in this manner. This ability can be used even if the attacker is not within the wielder's reach. <i>Countering</i> can only be placed on melee weapons.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/combat-feats/combat-reflexes-combat\">Combat Reflexes</a>, <a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cat-s-grace\" style=\"font-style:italic\">cat's grace</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    COURAGEOUS("Courageous", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus; <b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 3rd; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be added to a melee weapon.</p><p>A <i>courageous</i> weapon fortifies the wielder's courage and morale in battle. The wielder gains a <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a>&nbsp;on saving throws against <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Fear\">fear</a> equal to the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>. In addition, any <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> the wielder gains from any other source is increased by half the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> (minimum 1).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/heroism\" style=\"font-style:italic\">heroism</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/remove-fear\" style=\"font-style:italic\">remove fear</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CRUEL("Cruel", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>When the wielder strikes a creature that is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Frightened\">frightened</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Shaken\">shaken</a>, or <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Panicked\">panicked</a> with a <i>cruel</i> weapon, that creature becomes <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Sickened\">sickened</a> for 1 round. When the wielder uses the weapon to knock <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Unconscious\">unconscious</a> or kill a creature, he gains 5 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Temporary-Hit-Points\">temporary hit points</a> that last for 10 minutes.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cause-fear\" style=\"font-style:italic\">cause fear</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/death-knell\" style=\"font-style:italic\">death knell</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CUNNING("Cunning", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus; <b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Divination\">divination</a>; <b>CL</b> 6th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability allows a weapon to find chinks in a foe's defenses using the wielder's knowledge of the target.</p><p>Whenever the weapon’s attack is a critical threat, the wielder gains a +4 bonus on the confirmation roll if she has 5 or more ranks in a <a href=\"http://www.d20pfsrd.com/skills/knowledge\">Knowledge</a> skill that would be used to identify the target’s creature type  (such as <a href=\"http://www.d20pfsrd.com/skills/knowledge\">Knowledge</a> [planes] for an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Outsider\">outsider</a> opponent), or a +6 bonus instead if she has 15 or more ranks.<br></p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/true-strike\" style=\"font-style:italic\">true strike</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    DEADLY("Deadly", 0, 1, new boolean[]{true, true, true}, true, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons that normally deal <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Nonlethal-Damage\">nonlethal damage</a>, such as whips and saps.</p><p>All damage a <i>deadly</i> weapon deals is normal (lethal) damage. A <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/whip\">whip</a> (or similar weapon that is not normally able to damage creatures with armor or <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Bonus-Natural-Armor-\">natural armor</a> bonuses) with this special ability deals damage even to creatures with armor or <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Bonus-Natural-Armor-\">natural armor</a>. On command, the weapon suppresses this ability until the wielder commands it to resume.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/inflict-light-wounds\" style=\"font-style:italic\">inflict light wounds</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    DEFENDING("Defending", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>defending</i> weapon allows the wielder to transfer some or all of the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to his AC as a bonus that stacks with all others. As a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>, the wielder chooses how to allocate the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> at the start of his turn before using the weapon, and the bonus to AC lasts until his next turn. This ability can only be placed on melee weapons.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/shield\" style=\"font-style:italic\">shield</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/shield-of-faith\" style=\"font-style:italic\">shield of faith</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    DISPELLING("Dispelling", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>dispelling</i> weapon functions like a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons#TOC-Spell-Storing\" style=\"font-style:italic\">spell storing</a> weapon, but it may only store <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-magic\" style=\"font-style:italic\">dispel magic</a>; however, the <a href=\"http://www.d20pfsrd.com/magic#TOC-Caster-Level\">caster level</a> check to dispel gains an additional bonus equal to the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>. This bonus also applies to a <a href=\"http://www.d20pfsrd.com/classes/base-classes/magus\">magus's</a> dispelling strike arcana or a <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian\">barbarian's</a> spell <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Sunder\">sunder</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo---rage-powers/sunder-enchantment-su\">sunder enchantment</a> <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> check.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-magic\" style=\"font-style:italic\">dispel magic</a>, creator must be a caster of at least 10th level; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    FLAMING("Flaming", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a <i>flaming</i> weapon is sheathed in fire that deals an extra 1d6 points of fire damage on a successful hit. The fire does not harm the wielder. The effect remains until another command is given.</p><h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a> <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-blade\" style=\"font-style:italic\">flame blade</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-strike\" style=\"font-style:italic\">flame strike</a>, or <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fireball\" style=\"font-style:italic\">fireball</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    FROST("Frost", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a <i>frost</i> weapon is sheathed in a terrible, icy cold that deals an extra 1d6 points of cold damage on a successful hit. The cold does not harm the wielder. The effect remains until another command is given.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/chill-metal\" style=\"font-style:italic\">chill metal</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/ice-storm\" style=\"font-style:italic\">ice storm</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    FURIOUS("Furious", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>furious</i> weapon serves as a focus for its wielder's anger. When the wielder is <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian#TOC-Rage-Ex-\">raging</a> or under the effect of a <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/rage\"><i>rage</i></a> spell, the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> is +2 better than normal. If the wielder has a <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian#TOC-Rage-Powers-Ex-\">rage power</a> that gives a skill bonus while <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian#TOC-Rage-Ex-\">raging</a> (such as <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo---rage-powers/raging-climber-ex\">raging climber</a>, <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo---rage-powers/raging-leaper-ex\">raging leaper</a>, or <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo---rage-powers/raging-swimmer-ex\">raging swimmer</a>), the wielder gains an <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to that skill whenever the weapon is wielded or held in her hand, even when she is not <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian#TOC-Rage-Ex-\">raging</a>. This bonus is equal to the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> of the weapon (and also includes the +2 if the wielder is <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian#TOC-Rage-Ex-\">raging</a>).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/rage\"><i>rage</i></a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    GHOST_TOUCH("Ghost Touch", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 9th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>ghost touch</i> weapon deals damage normally against <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creatures, regardless of its bonus. An <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creature's 50% reduction in damage from corporeal sources does not apply to attacks made against it with <i>ghost touch</i> weapons. The weapon can be picked up and moved by an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creature at any time. A manifesting <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/templates/ghost\">ghost</a> can wield the weapon against corporeal foes. Essentially, a <i>ghost touch</i> weapon counts as both corporeal or <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a>. </p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/p/plane-shift\" style=\"font-style:italic\">plane shift</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    GRAYFLAME("Grayflame", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 6th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This weapon responds to channeled positive and negative energy.</p><p>When the wielder spends a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a> to <a href=\"http://www.d20pfsrd.com/classes/core-classes/cleric#TOC-Channel-Energy-Su-\">channel energy</a> through the weapon, it ignites with a strange gray flame that sheds light as a torch, increases the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> by +1, and deals +1d6 damage (as the divine power from <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-strike\" style=\"font-style:italic\">flame strike</a>) to creatures struck by the weapon. This flame lasts for 1 round for every d6 of damage or healing the channeling normally provides. When charged with positive energy, the flame is a silvery gray, good creatures are immune to the weapon's extra damage, and the weapon counts as a good and silver weapon for the purpose of bypassing <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. When charged with negative energy, the flame is an ashen gray, evil creatures are immune to the weapon's extra damage, and the weapon counts as an evil and <a href=\"http://www.d20pfsrd.com/equipment---final/special-materials#TOC-Iron-Cold\">cold iron</a> weapon for the purpose of bypassing <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. This special ability can only be placed on melee weapons.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/feats/combat-feats/channel-smite-combat\">Channel Smite</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/align-weapon\" style=\"font-style:italic\">align weapon</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    GROUNDING("Grounding", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>grounding</i> weapon can safely touch electrically charged surfaces without harm to its wielder. When used against a creature of the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Air\">air</a> subtype, it deals an extra 1d6 points of damage. The wielder of a <i>grounding</i> weapon receives a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on saving throws against air- and electricity-based effects, and the weapon itself is immune to electricity damage.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/shocking-grasp\" style=\"font-style:italic\">shocking grasp</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    GUARDIAN("Guardian", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>guardian</i> weapon allows the wielder to transfer some or all of the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to his saving throws as a bonus that stacks with all others. As a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>, the wielder chooses how to allocate the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> at the start of his turn before using the weapon. The bonus on saving throws lasts until his next turn. Only the weapon's own <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> can be sacrificed, not any <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> provided by other effects such as a <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/magic-weapon\" style=\"font-style:italic\">greater magic weapon</a> spell. However, the total of such effects is still diminished by the amount allocated to improving saving throws.</p>\n" +
            "<p>If a weapon has both the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/defending\"><i>defending</i></a> and <i>guardian</i> abilities , allocating a single point of <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> increases either AC or saving throws, but not both.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Resistance\">resistance</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    HEARTSEEKER("Heartseeker", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>heartseeker</i> weapon is drawn unerringly toward beating hearts. A <i>heartseeker</i> weapon ignores the miss chance for <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Concealment\">concealment</a> against most living targets, though the attack must still target the proper square. This special ability does not apply against <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Aberration\">aberrations</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Ooze\">oozes</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Plant\">plants</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Outsider\">outsiders</a> with the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Elemental\">elemental</a> subtype, or any creature specifically noted to lack a heart.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/death-knell\" style=\"font-style:italic\">death knell</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    HUNSTMAN("Huntsman", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus; <b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Divination\">divination</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>huntsman</i> weapon helps its wielder locate and capture quarry.</p><p>When the weapon is held in hand, the wielder gains the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/survival\">Survival</a> checks made to track any creature the weapon has damaged in the past day. It also deals +1d6 points of damage to creatures the wielder has tracked with <a href=\"http://www.d20pfsrd.com/skills/survival\">Survival</a> in the past day.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/detect-animals-or-plants\" style=\"font-style:italic\">detect animals or plants</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    JURIST("Jurist", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 4th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>When an <a href=\"http://www.d20pfsrd.com/classes/base-classes/inquisitor\">inquisitor</a> wielder uses her <a href=\"http://www.d20pfsrd.com/classes/base-classes/inquisitor#TOC-Judgment-Su-\">judgment</a> class ability while wielding a <i>jurist</i> weapon, it grants her an <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> on her <a href=\"http://www.d20pfsrd.com/skills/perception\">Perception</a> checks and to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">CMD</a>. The bonus is +1 on the first round of her <a href=\"http://www.d20pfsrd.com/classes/base-classes/inquisitor#TOC-Judgment-Su-\">judgment</a>, and increases by +1 each round, to a maximum of +3 on the third and following rounds.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/o/owl-s-wisdom\"><i>owl's wisdom</i></a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    KEEN("Keen", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This ability doubles the threat range of a weapon. Only piercing or slashing melee weapons can be <i>keen</i>. If you roll this special ability randomly for an inappropriate weapon, reroll. This benefit doesn't stack with any other effects that expand the threat range of a weapon (such as the <a href=\"http://www.d20pfsrd.com/magic/all-spells/k/keen-edge\" style=\"font-style:italic\">keen edge</a> spell or the <a href=\"http://www.d20pfsrd.com/feats/combat-feats/improved-critical-combat-\">Improved Critical</a> feat).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/k/keen-edge\" style=\"font-style:italic\">keen edge</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    KI_FOCUS("Ki Focus", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can be placed only on melee weapons.</p><p>The magic weapon serves as a channel for the wielder's <i>ki</i>, allowing her to use her special <i>ki</i> attacks through the weapon as if they were unarmed attacks. These attacks include the <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk\">monk's</a> <i>ki</i> strike, <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk#TOC-Quivering-Palm-Su-\">quivering palm</a>, and the <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk#TOC-Stunning-Fist-Ex-\">Stunning Fist</a> feat (including any condition that the <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk\">monk</a> can apply using this feat).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, creator must be a <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk\">monk</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    LIMNING("Limning", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>When a <i>liming</i> weapon is wielded, a pale glow outlines it.</p><p>On a successful strike against a creature affected by a means of magical <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Concealment\">concealment</a>, the weapon outlines the creature in <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/faerie-fire\" style=\"font-style:italic\">faerie fire</a> (as the spell) for 1 round. Magical means of <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Concealment\">concealment</a> include <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/blur\" style=\"font-style:italic\">blur</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/displacement\" style=\"font-style:italic\">displacement</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/invisibility\" style=\"font-style:italic\">invisibility</a>, and similar effects, whether from a spell, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Spell-Like-Abilities-Sp-\">spell-like ability</a>, or <a href=\"http://www.d20pfsrd.com/magic#TOC-Supernatural-Abilities-Su-\">supernatural</a> means, but not those provided by <a href=\"http://www.d20pfsrd.com/magic#TOC-Extraordinary-Abilities-Ex-\">extraordinary abilities</a> . A <i>liming</i> weapon has no special effect against creatures merely hiding or concealed by non-magical means, or those hidden by environmental conditions (even magical) such as <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/darkness\" style=\"font-style:italic\">darkness</a> or fog.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/faerie-fire\" style=\"font-style:italic\">faerie fire</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    MENACING("Menacing", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Illusion\">illusion</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>menacing</i> weapon helps allies deal with <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Flanking\">flanked</a> foes. When the wielder is adjacent to a creature that is being <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Flanking\">flanked</a> by an ally, the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Flanking\">flanking</a> bonus on <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attack-Roll\">attack rolls</a> for all <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Flanking\">flanking</a> allies increases by +2. This ability works even if the wielder is not one of the characters <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Flanking\">flanking</a> the creature.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/p/phantasmal-killer\" style=\"font-style:italic\">phantasmal killer</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    MERCIFUL("Merciful", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>merciful</i> weapon deals an extra 1d6 points of damage, but all damage it deals is <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Nonlethal-Damage\">nonlethal damage</a>. On command, the weapon suppresses this ability until told to resume it (allowing it to deal lethal damage, but without any bonus damage from this ability).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cure-light-wounds\" style=\"font-style:italic\">cure light wounds</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    MIGHTY_CLEAVING("Mighty Cleaving", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>mighty cleaving</i> weapon allows a wielder using the <a href=\"http://www.d20pfsrd.com/feats/combat-feats/cleave-combat\">Cleave</a> feat to make one additional attack if the first attack hits, as long as the next foe is adjacent to the first and also within reach. This additional attack cannot be against the first foe.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/divine-power\" style=\"font-style:italic\">divine power</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    MIMETIC("Mimetic", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>Each time the wielder damages a creature using a <i>mimetic</i> weapon, he gains <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Resistance\">resistance</a> 10 to one energy type that the creature is resistant or immune to for 1 round (if the creature damaged has multiple types of <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Resistance\">resistance</a>, the wielder chooses one of those resistances to take). This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Resistance\">resistance</a> stacks with itself, to a maximum of 30 points of <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Resistance\">resistance</a> against a given energy type, but not with other sources of <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Resistance\">energy resistance</a>. The creature's own resistances and immunities are unaffected.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    NEUTRALIZING("Neutralizing", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>neutralizing</i> weapon thrust into up to 1 gallon of non-magical corrosive liquid transforms it into harmless water. When used against a creature of the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Earth\">earth</a> subtype, it deals an extra 1d6 points of damage. The wielder of a <i>neutralizing</i> weapon receives a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on saving throws against acid- and earth-based effects, and the weapon itself is immune to acid damage.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/p/purify-food-and-drink\" style=\"font-style:italic\">purify food and drink</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    OMINOUS("Ominous", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>An <i>ominous</i> weapon trails a shadowy haze behind every stroke, and moans a menacing dirge in battle. An <i>ominous</i> weapon adds its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/intimidate\">Intimidate</a> checks made by the wielder. In addition, when an <i>ominous</i> weapon confirms a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>, the target is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Shaken\">shaken</a> for 1 minute (DC 13 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Will\">Will</a> negates); if the weapon's critical multiplier is greater than x2, this condition lasts 1 additional minute per multiple over x2. A creature that gains the <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Shaken\">shaken</a> condition from an <i>ominous</i> weapon cannot gain that condition again from the same weapon for 24 hours.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/doom\" style=\"font-style:italic\">doom</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/scare\" style=\"font-style:italic\">scare</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    PLANAR("Planar", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 9th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>planar</i> weapon is effective against all types of <a href=\"http://www.d20pfsrd.com/magic#TOC-Extradimensional-Spaces\">extradimensional</a> beings, able to pierce their <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Resistance\">resistance</a> to physical harm. When used to attack <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Outsider\">outsiders</a>, a <i>planar</i> weapon ignores 5 points of their <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/p/plane-shift\" style=\"font-style:italic\">plane shift</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    QUENCHING("Quenching", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>quenching</i> weapon thrust into a non-magical fire of Medium size or smaller extinguishes it. When used against a creature of the fire subtype, it deals an extra 1d6 points of damage. The wielder of a <i>quenching</i> weapon receives a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on saving throws against fire-based effects, and the weapon itself is immune to fire damage.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/chill-metal\" style=\"font-style:italic\">chill metal</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    SEABORNE("Seaborne", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>seaborne</i> weapon functions easily in watery environments. With the weapon in hand, the wielder gains a bonus on <a href=\"http://www.d20pfsrd.com/skills/swim\">Swim</a> checks equal to twice the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>. In addition, the wielder does not take the normal penalties to attack and damage rolls imposed by being underwater, as if he were subject to the spell <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/freedom-of-movement\" style=\"font-style:italic\">freedom of movement</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/freedom-of-movement\" style=\"font-style:italic\">freedom of movement</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/touch-of-the-sea\"><i>touch of the sea</i></a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    SHOCK("Shock", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a <i>shock</i> weapon is sheathed in crackling electricity that deals an extra 1d6 points of electricity damage on a successful hit. The electricity does not harm the wielder. The effect remains until another command is given.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/call-lightning\" style=\"font-style:italic\">call lightning</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/lightning-bolt\" style=\"font-style:italic\">lightning bolt</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    SPELL_STORING("Spell Storing", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a> and varies; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>spell storing</i> weapon allows a spellcaster to store a single targeted spell of up to 3rd level in the weapon. (The spell must have a <a href=\"http://www.d20pfsrd.com/magic#TOC-Casting-Time\">casting time</a> of 1 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Standard-Actions\">standard action</a>.) Anytime the weapon strikes a creature and the creature takes damage from it, the weapon can immediately cast the spell on that creature as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a> if the wielder desires. (This special ability is an exception to the general rule that casting a spell from an item takes at least as long as casting that spell normally.) Once the spell has been cast from the weapon, a spellcaster can cast any other targeted spell of up to 3rd level into it. The weapon magically imparts to the wielder the name of the spell currently stored within it. A randomly rolled <i>spell storing</i> weapon has a 50% chance of having a spell stored in it already. This special ability can only be placed on melee weapons.</p>\n" +
            "<p>A <i>spell storing</i> weapon emits a strong aura of the <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a> school, plus the aura of the spell currently stored.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, creator must be a caster of at least 12th level; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    THAWING("Thawing", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A <i>thawing</i> weapon thrust into a non-magical frozen object of Medium size or smaller melts the ice from it. When used against a creature with the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Cold\">cold</a> subtype, it deals an extra 1d6 points of damage. The wielder of a <i>thawing</i> weapon receives a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on saving throws against ice-based effects, and the weapon itself is immune to cold damage.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/heat-metal\" style=\"font-style:italic\">heat metal</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    THROWING("Throwing", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>A melee weapon crafted with this ability gains a range increment of 10 feet and can be thrown by a wielder proficient in its normal use.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/magic-stone\" style=\"font-style:italic\">magic stone</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    THUNDERING("Thundering", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>thundering</i> weapon creates a cacophonous roar like thunder whenever it strikes a target with a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The sonic energy does not harm the wielder. A <i>thundering</i> weapon deals an extra 1d8 points of sonic damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical multiplier is x3, add an extra 2d8 points of sonic damage instead, and if the multiplier is x4, add an extra 3d8 points of sonic damage. Subjects dealt critical hits by a <i>thundering</i> weapon must make a successful DC 14 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> save or be <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Deafened\">deafened</a> permanently.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/blindness-deafness\"><i>blindness/deafness</i></a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    VALIANT("Valiant", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Divination\">divination</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>When a <a href=\"http://www.d20pfsrd.com/classes/base-classes/cavalier\">cavalier</a> wielding a <i>valiant</i> weapon targets a foe with his challenge ability, the <i>valiant</i> weapon deals an additional 1d6 points of damage against that foe. The wielder receives a +2 bonus on <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> checks made to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Disarm\">disarm</a> or <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Sunder\">sunder</a> a challenged foe's weapon as well as a +4 bonus to his <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">CMD</a> against <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Disarm\">disarm</a> and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Sunder\">sunder</a> attacks from that foe.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/true-strike\" style=\"font-style:italic\">true strike</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    VICIOUS("Vicious", 0, 1, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 9th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons.</p><p>When a <i>vicious</i> weapon strikes an opponent, it creates a flash of disruptive energy that resonates between the opponent and the wielder. This energy deals an extra 2d6 points of damage to the opponent and 1d6 points of damage to the wielder.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/enervation\" style=\"font-style:italic\">enervation</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    //+2
    ADVANCING("Advancing", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This ability can only be placed on melee weapons. Once per round, when the wielder damages a creature in melee with an advancing weapon, she can take a 5-foot step as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a> after the attack but before the end of her turn. This movement does not count against her ability to move or take a 5-foot step earlier or later in the round, though using this ability imposes a —2 penalty on all <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attack-Roll\">attack rolls</a> until the start of her next turn. This ability may not be used in conjunction with any other ability or effect that allows moving as part of an attack.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/feather-step\" style=\"font-style:italic\">feather step</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    ANARCHIC("Anarchic", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>anarchic</i> weapon is infused with the power of chaos. It makes the weapon chaotically aligned and thus bypasses the corresponding <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. It deals an extra 2d6 points of damage against all creatures of lawful <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Alignment\">alignment</a>. It bestows one permanent <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Lawful\">lawful</a> creature attempting to wield it. The <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the weapon is in hand and disappears when the weapon is no longer wielded. This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the weapon is wielded.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/chaos-hammer\" style=\"font-style:italic\">chaos hammer</a>, creator must be <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Chaotic\">chaotic</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    ANCHORING("Anchoring", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be added to a melee weapon or a thrown weapon. An anchoring weapon pins a target in place and prevents it from moving. As a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a>, the weapon can be fixed in place in a point in space, functioning as an immovable rod. This ability can also be used when the wielder hits a creature with a melee attack using an anchoring weapon. This anchors the target to the weapon, preventing it from moving away from the weapon. The target is not <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Entangled\">entangled</a> or <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Paralyzed\">paralyzed</a>; it simply cannot move from its location without first destroying the weapon or making a successful DC 30 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Strength-Str-\">Strength</a> check as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Full-Round-Actions\">full-round action</a> to move with the weapon up to 10 feet. An anchoring weapon remains motionless and cannot be used to attack while it is anchoring a creature. An anchoring weapon has no effect on amorphous creatures, including <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/outsiders/elemental\">elementals</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Ooze\">oozes</a>, and creatures in gaseous or liquid form. It also cannot anchor <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creatures unless the weapon also has the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons#TOC-Ghost-Touch\" style=\"font-style:italic\">ghost touch</a> special ability.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/levitate\" style=\"font-style:italic\">levitate</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    AXIOMATIC("Axiomatic", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><p><i><font size=\"3\"><br></font></i></p></div><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>axiomatic</i> weapon is infused with lawful power. It makes the weapon law-aligned and thus bypasses the corresponding <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. It deals an extra 2d6 points of damage against chaotic creatures. It bestows one permanent <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any chaotic creature attempting to wield it. The <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the weapon is in hand and disappears when the weapon is no longer wielded. This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the weapon is wielded.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/o/order-s-wrath\" style=\"font-style:italic\">order's wrath</a>, creator must be lawful; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div><div dir=\"ltr\"></div><div dir=\"ltr\"><div style=\"border-style:solid;border-width:thin;border-color:rgb(153,153,153);margin-top:10px\">\n" +
            "<div style=\"background-color:rgb(243,243,243);padding:5px;font-weight:bolder;font-size:14px\">Section 15: Copyright Notice</div>\n" +
            "<div style=\"padding:10px;font-size:12px;font-style:italic\">\n" +
            "<p><a href=\"http://www.amazon.com/gp/product/1601254490/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&amp;camp=1789&amp;creative=9325&amp;creativeASIN=1601254490&amp;linkCode=as2&amp;tag=httpwwwd20pfs-20\" target=\"_blank\">Pathfinder Roleplaying Game: Ultimate Equipment (OGL)</a> © 2012, Paizo Publishing, LLC; Authors: Dennis Baker, Jesse Benner, Benjamin Bruck, Ross Byers, Brian J. Cortijo, Ryan Costello, Mike Ferguson, Matt Goetz, Jim Groves, Tracy Hurley, Matt James, Jonathan H. Keith, Michael Kenway, Hal MacLean, Jason Nelson, Tork Shaw, Owen KC Stephens, Russ Taylor, and numerous RPG Superstar contributors</p>\n" +
            "</div>\n" +
            "</div></div></td>"),
    CORROSIVE_BURST("Corrosive Burst", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>corrosive burst</i> weapon functions as a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/corrosive\"><i>corrosive</i></a> weapon that explodes with searing acid upon striking a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The acid does not harm the wielder. In addition to the extra acid damage from the <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/corrosive\">corrosive</a></i> special ability, a <i>corrosive burst</i> weapon deals an extra 1d10 points of acid damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical modifier is x3, add an extra 2d10 points of acid damage instead, and if the modifier is x4, add an extra 3d10 points.</p>\n" +
            "<p>Even if the <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/corrosive\">corrosive</a></i> ability is not active, the weapon still deals its extra acid damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/acid-arrow\" style=\"font-style:italic\">acid arrow</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    DEFIANT("Defiant", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>defiant</i> weapon helps its wielder stay alive in desperate conditions. It stays in its wielder's hand even if she is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Panicked\">panicked</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Stunned\">stunned</a>, or <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Unconscious\">unconscious</a>. She adds the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> as a bonus on checks to <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Stable\">stabilize</a> when <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Dying\">dying</a> and on saving throws to end ongoing conditions such as <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/diseases\">disease</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/poison\">poison</a>, and <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/hold-person\" style=\"font-style:italic\">hold person</a>. If the wielder possesses <a href=\"http://www.d20pfsrd.com/feats/general-feats/heroic-defiance\">Heroic Defiance</a>, <a href=\"http://www.d20pfsrd.com/feats/general-feats/heroic-recovery\">Heroic Recovery</a>, <a href=\"http://www.d20pfsrd.com/feats/general-feats/improved-great-fortitude---final\">Improved Great Fortitude</a>, <a href=\"http://www.d20pfsrd.com/feats/general-feats/improved-iron-will---final\">Improved Iron Will</a>, or <a href=\"http://www.d20pfsrd.com/feats/general-feats/improved-lightning-reflexes---final\">Improved Lightning Reflexes</a>, she gains a number of additional daily uses equal to the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> that can be used on any of these feats.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/feats/general-feats/heroic-defiance\">Heroic Defiance</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/break-enchantment\"><i>break enchantment</i></a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/stabilize\" style=\"font-style:italic\">stabilize</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    DISPELLING_BURST("Dispelling Burst", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>dispelling burst</i> weapon functions like a <i>dispelling</i> weapon but may store <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-magic\" style=\"font-style:italic\">dispel magic</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-magic\" style=\"font-style:italic\">greater dispel magic</a>. In addition, these spells can be discharged as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a> when the wielder of a dispelling burst weapon confirms a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. When the wielder does so, the bonus to the check made to dispel (including from dispelling strike, spell <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Sunder\">sunder</a>, or <a href=\"http://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo---rage-powers/sunder-enchantment-su\">sunder enchantment</a>) increases by an amount equal to the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> or the weapon's critical multiplier (whichever is higher). </p>\n" +
            "<p>If a <i>dispelling burst</i> weapon confirms a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> while it is not currently storing a <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-magic\" style=\"font-style:italic\">dispel magic</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-magic\" style=\"font-style:italic\">greater dispel magic</a> spell, yet if the wielder has either spell prepared (or is a spontaneous caster able to cast either spell), she may cast either spell into the weapon as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a> and then immediately discharge it into the target as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-magic\" style=\"font-style:italic\">greater dispel magic</a>, creator must be a caster of at least 12th level; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    DISRUPTION("Disruption", 0, 2, new boolean[]{false, false, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 14th; <b>Weight</b> -</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>disruption</i> weapon is the bane of all <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a>. Any <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> creature struck in combat must succeed on a DC 14 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Will\">Will</a> save or be destroyed. A <i>disruption</i> weapon must be a bludgeoning melee weapon.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/heal\" style=\"font-style:italic\">heal</a>; <b>Cost</b> +2 bonus.\n" +
            "</p></div></div></td>"),
    FLAMING_BURST("Flaming Burst", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 12th; <b>Weight</b> —; <b>Price</b> +2 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming-burst\" style=\"font-style:italic\">flaming burst</a> weapon functions as a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\" style=\"font-style:italic\">flaming</a> weapon that also explodes with flame upon striking a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The fire does not harm the wielder. In addition to the extra fire damage from the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\" style=\"font-style:italic\">flaming</a> ability (see above), a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming-burst\" style=\"font-style:italic\">flaming burst</a> weapon deals an extra 1d10 points of fire damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical multiplier is x3, add an extra 2d10 points of fire damage instead, and if the multiplier is x4, add an extra 3d10 points of fire damage.</p>\n" +
            "<p>Even if the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\" style=\"font-style:italic\">flaming</a> ability is not active, the weapon still deals its extra fire damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a> and <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fireball\" style=\"font-style:italic\">fireball</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-blade\" style=\"font-style:italic\">flame blade</a>, or <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-strike\" style=\"font-style:italic\">flame strike</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    FURYBORN("Furyborn", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>furyborn</i> weapon draws power from the anger and frustration the wielder feels when battling foes that refuse to die. Each time the wielder damages an opponent with the weapon, its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> increases by +1 when making attacks against that opponent (to a maximum total <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> of +5). This extra <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> goes away if the opponent dies, the wielder uses the weapon to attack a different creature, or 1 hour passes.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/rage\"><i>rage</i></a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    GLORIOUS("Glorious", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>glorious</i> weapon glows with a dazzling light equal to a <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/daylight\" style=\"font-style:italic\">daylight</a> spell when drawn. The wielder cannot suppress this light, though it can be temporarily suppressed by any effect that can suppress <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/daylight\" style=\"font-style:italic\">daylight</a>. A glorious weapon flashes with light, and any creature the wielder attacks in melee is automatically <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Dazzled\">dazzled</a> until the beginning of the wielder's next turn. When a glorious weapon confirms a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>, the target is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Blinded\">blinded</a> until the beginning of the wielder's next turn (DC 14 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Will\">Will</a> negates); if the weapon's critical multiplier is greater than x2, this blindness lasts 1 additional round per multiple over x2. Only a melee weapon can have the <i>glorious</i> ability.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/blindness-deafness\"><i>blindness/deafness</i></a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/daylight\" style=\"font-style:italic\">daylight</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flare\" style=\"font-style:italic\">flare</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    HOLY("Holy", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>holy</i> weapon is imbued with holy power. This power makes the weapon good-aligned and thus bypasses the corresponding <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. It deals an extra 2d6 points of damage against all creatures of evil <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Alignment\">alignment</a>. It bestows one permanent <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any evil creature attempting to wield it. The <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the weapon is in hand and disappears when the weapon is no longer wielded. This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including by <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the weapon is wielded.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/holy-smite\" style=\"font-style:italic\">holy smite</a>, creator must be good; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    ICY_BURST("Icy Burst", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>icy burst</i> weapon functions as a <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/frost\">frost</a></i> weapon that also explodes with frost upon striking a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The frost does not harm the wielder. In addition to the extra damage from the <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/frost\">frost</a></i> ability, an <i>icy burst</i> weapon deals an extra 1d10 points of cold damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical multiplier is x3, add an extra 2d10 points of cold damage instead, and if the multiplier is x4, add an extra 3d10 points.</p>\n" +
            "<p>Even if the <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/frost\">frost</a></i> ability is not active, the weapon still deals its extra cold damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/chill-metal\" style=\"font-style:italic\">chill metal</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/ice-storm\" style=\"font-style:italic\">ice storm</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    IGNITING("Igniting", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>igniting</i> weapon functions as a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\"><i>flaming</i></a> weapon that also causes the target to catch fire upon striking it with a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The target does not get a saving throw to avoid catching fire, but can make a save each round on its turn to put out the fire. The <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\"><i>flaming</i></a> ability must be active for the weapon to set enemies on fire.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-blade\" style=\"font-style:italic\">flame blade</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-strike\" style=\"font-style:italic\">flame strike</a>, or <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fireball\" style=\"font-style:italic\">fireball</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    IMPACT("Impact", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 9th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons that are not light weapons. An <i>impact</i> weapon delivers a potent kinetic jolt when it strikes, dealing damage as if the weapon were one size category larger. In addition, any <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Bull-Rush\">bull rush</a> <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> the wielder attempts while wielding the weapon gains a bonus equal to the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>; this includes all <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Bull-Rush\">bull rush</a> attempts, not only those in which a weapon is used, such as <a href=\"http://www.d20pfsrd.com/feats/combat-feats/bull-rush-strike-combat\">Bull Rush Strike</a>, <a href=\"http://www.d20pfsrd.com/feats/combat-feats/shield-slam-combat---final\">Shield Slam</a>, or <a href=\"http://www.d20pfsrd.com/feats/combat-feats/unseat-combat---final\">Unseat</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bull-s-strength\" style=\"font-style:italic\">bull's strength</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/lead-blades\" style=\"font-style:italic\">lead blades</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/g/giant-form-i\"><i>giant form I</i></a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    INVIGORATING("Invigorating", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. After an attack with this weapon drops a living foe (kills it or drops it to negative <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a>), the weapon infuses its wielder with vigor. If its wielder is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Fatigued\">fatigued</a>, the weapon removes the <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Fatigued\">fatigue</a>. If <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Exhausted\">exhausted</a>, the wielder becomes <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Fatigued\">fatigued</a> instead. If neither <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Exhausted\">exhausted</a> nor <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Fatigued\">fatigued</a>, the wielder gains a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> on <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attack-Roll\">attack rolls</a> and a +10 foot <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to all modes of movement possessed until the end of the wielder's next turn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/g/good-hope\" style=\"font-style:italic\">good hope</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    KI_INTENSIFYING("Ki Intensifying", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>The weapon channels and amplifies the wielder's <i>ki</i>, allowing her to use her special <i>ki</i> attacks through the weapon as though they were unarmed attacks. These attacks include the <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk\">monk's</a> <i>ki</i> strike, <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk#TOC-Quivering-Palm-Su-\">quivering palm</a>, and the <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk#TOC-Stunning-Fist-Ex-\">Stunning Fist</a> feat. The save DC for <i>ki</i> abilities used through the weapon increases by half the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> of the weapon (minimum 1).</p>\n" +
            "<p>After a successful strike with a <i>ki intensifying</i> weapon, the wielder can spend 1 <i>ki</i> point as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a> to perform a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Bull-Rush\">bull rush</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Disarm\">disarm</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reposition\">reposition</a>, or <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Trip-Ex-\">trip</a> as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a> without provoking <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attacks-of-Opportunity\">attacks of opportunity</a>. Any bonuses or penalties applicable to the weapon attack also apply to this <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> check. The wielder cannot move from her space as a part of the chosen maneuver.</p>\n" +
            "<p>Only melee weapons can have the <i>ki intensifying</i> ability. It cannot be placed on an amulet of mighty fist or similar non-weapon item. Weapons with the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/ki-focus\"><i>ki focus</i></a> ability can be upgraded to be <i>ki intensifying</i>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, creator must be a <a href=\"http://www.d20pfsrd.com/classes/core-classes/monk\">monk</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    LIFESURGE("Lifesurge", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>lifesurge</i> weapon boosts and sustains the wielder's life energy while he is in the throes of combat. The wielder gains a bonus on saving throws against necromantic effects—including the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Ability-Score-Damage\">ability damage</a>, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Ability-Drain\">ability drain</a>, and <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">energy drain</a> powers of the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a>—equal to the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>. In addition, whenever the wielder receives <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Temporary-Hit-Points\">temporary hit points</a> from any source, he adds the weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to these <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Temporary-Hit-Points\">temporary hit points</a>; this does not stack for <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Temporary-Hit-Points\">temporary hit points</a> from multiple sources, and these points are lost if the <i>lifesurge</i> weapon is not being wielded.</p>\n" +
            "<p>In combat, the weapon's critical threat range is doubled against <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a>; this does not stack with the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons#TOC-Keen\" style=\"font-style:italic\">keen</a> special ability or <a href=\"http://www.d20pfsrd.com/feats/combat-feats/improved-critical-combat-\">Improved Critical</a>. Whenever a <i>lifesurge</i> weapon confirms a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> against an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> creature, it erupts with 1d8 points of positive energy (2d8 for weapons with a critical multiplier of x3, 3d8 if it is x4); the wielder may choose to deal this as damage to an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> target or to absorb half this amount as <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration-Healing\">healing</a>, with the remaining positive energy dissipating.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/feats/combat-feats/channel-smite-combat\">Channel Smite</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cure-serious-wounds\" style=\"font-style:italic\">cure serious wounds</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/death-ward\" style=\"font-style:italic\">death ward</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/disrupt-undead\"><i>disrupt undead</i></a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    NEGATING("Negating", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>negating</i> weapon briefly nullifies some forms of <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Damage-Reduction\">damage reduction</a> when it damages a creature. Whenever a <i>negating</i> weapon damages a foe with <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/<a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Chaotic\">chaotic</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/evil, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/good, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/<a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Lawful\">lawful</a>, or <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/magic, it reduces the value of that <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a> by 5 points for 1 round.</p><p>For example, a +1 <i>negating</i> <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/lance\">lance</a> hitting a creature with <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a> 10/good and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Lawful\">lawful</a> reduces the creature's <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a> to 5/good and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Lawful\">lawful</a>. If the creature has a component to its <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a> other than the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Alignment\">alignment</a> types listed above, that component is unaffected. Thus, if the +1 <i>negating</i> <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/lance\">lance</a> above hits a <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/outsiders/demon\">demon</a> with <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a> 10/good and <a href=\"http://www.d20pfsrd.com/equipment---final/special-materials#TOC-Iron-Cold\">cold iron</a>, it would leave the <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/outsiders/demon\">demon</a> with <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a> 10/<a href=\"http://www.d20pfsrd.com/equipment---final/special-materials#TOC-Iron-Cold\">cold iron</a> and 5/good for 1 round. The effects of multiple <i>negating</i> weapons (or multiple hits from the same weapon) do not stack. This ability can only be placed on melee weapons.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-chaos\" style=\"font-style:italic\">dispel chaos</a>, <i><a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-evil\">dispel evil</a></i>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-good\"><i>dispel good</i></a>, or <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dispel-law\"><i>dispel law</i></a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    PHASE_LOCKING("Phase Locking", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>phase locking</i> weapon interferes with dimensional travel. A creature damaged by a <i>phase locking </i>weapon is affected as though by the <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dimensional-anchor\" style=\"font-style:italic\">dimensional anchor</a> spell for 1 round.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dimensional-anchor\" style=\"font-style:italic\">dimensional anchor</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    SHOCKING_BURST("Shocking Burst", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>shocking burst</i> weapon functions as a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/shock\"><i>shock</i></a> weapon that explodes with electricity upon striking a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The electricity does not harm the wielder. In addition to the extra electricity damage from the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/shock\"><i>shock</i></a> ability, a <i>shocking burst</i> weapon deals an extra 1d10 points of electricity damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical multiplier is x3, add an extra 2d10 points of electricity damage instead, and if the multiplier is x4, add an extra 3d10 points.</p>\n" +
            "<p>Even if the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/shock\"><i>shock</i></a> ability is not active, the weapon still deals its extra electricity damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/call-lightning\" style=\"font-style:italic\">call lightning</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/lightning-bolt\" style=\"font-style:italic\">lightning bolt</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    STALKING("Stalking", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Divination\">divination</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>The longer the wielder of a <i>stalking</i> weapon studies a target, the more effective her strike. As a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Standard-Actions\">standard action</a>, a character wielding a <i>stalking</i> weapon can command it to study a creature within 60 feet. The wielder must have line of effect and line of sight to that target. When the wielder attacks the studied creature, on a successful hit the <i>stalking</i> weapon deals +1d6 points of bonus damage per consecutive round spent studying a target, up to a number of bonus dice equal to the <i>stalking</i> weapon's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>. This bonus damage is precision damage and only applies to the first successful hit against that creature.</p>\n" +
            "<p>If the wielder attacks a creature other than the studied creature, commands the weapon to study a different creature, or ends her turn more than 60 feet from the studied creature, the weapon loses all bonus damage dice against the previously studied creature.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/hunter-s-eye\" style=\"font-style:italic\">hunter's eye</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/true-strike\" style=\"font-style:italic\">true strike</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    UNHOLY("Unholy", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>unholy</i> weapon is imbued with unholy power. This power makes the weapon evil-aligned and thus bypasses the corresponding <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. It deals an extra 2d6 points of damage against all creatures of good <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Alignment\">alignment</a>. It bestows one permanent <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any good creature attempting to wield it. The <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the weapon is in hand and disappears when the weapon is no longer wielded. This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the weapon is wielded.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/u/unholy-blight\" style=\"font-style:italic\">unholy blight</a>, creator must be evil; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    WOUNDING("Wounding", 0, 2, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>wounding</i> weapon deals 1 point of <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Bleed\">bleed</a> damage when it hits a creature. Multiple hits from a <i>wounding</i> weapon increase the <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Bleed\">bleed</a> damage. Bleeding creatures take the <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Bleed\">bleed</a> damage at the start of their turns. Bleeding can be stopped by a successful DC 15 <a href=\"http://www.d20pfsrd.com/skills/heal\">Heal</a> check or through the application of any spell that cures hit point damage. A <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> does not multiply the <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Bleed\">bleed</a> damage. Creatures immune to critical hits are immune to the <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Bleed\">bleed</a> damage dealt by this weapon.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bleed\"><i>bleed</i></a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    //+3
    NULLIFYING("Nullifying", 0, 3, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +3 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>nullifying</i> weapon suppresses a creature's <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Spell-Resistance\">spell resistance</a> for a short amount of time. Anytime the weapon strikes a creature with <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Spell-Resistance\">spell resistance</a> and the creature takes damage from the weapon, the target's <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Spell-Resistance\">spell resistance</a> is reduced by 1 for 1 minute. On a confirmed <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>, its <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Spell-Resistance\">spell resistance</a> is instead reduced by an amount equal to the weapon's critical multiplier. Multiple hits from a <i>nullifying</i> weapon stack.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/antimagic-field\" style=\"font-style:italic\">antimagic field</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    REPOSITIONING("Repositioning", 0, 3, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +3 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>repositioning</i> weapon grants the wielder a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> on <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> checks to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reposition\">reposition</a> a foe. If the wielder confirms a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> with the weapon, he can attempt to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reposition\">reposition</a> his opponent as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>. These <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reposition\">reposition</a> attempts still provoke <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attacks-of-Opportunity\">attacks of opportunity</a> as normal. A weapon cannot have both the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/anchoring\"><i>anchoring</i></a> and <i>repositioning</i> special abilities .</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/telekinesis\" style=\"font-style:italic\">telekinesis</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    SPEED("Speed", 0, 3, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +3 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>When making a full-attack action, the wielder of a <i>speed</i> weapon may make one extra attack with it. The attack uses the wielder's full <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Base-Attack-Bonus-BAB-\">base attack bonus</a>, plus any modifiers appropriate to the situation. (This benefit is not cumulative with similar effects, such as a <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/haste\" style=\"font-style:italic\">haste</a> spell.)\n" +
            "</p><h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/haste\" style=\"font-style:italic\">haste</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    SPELL_STEALING("Spell Stealing", 0, 3, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +3 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Divination\">divination</a>; <b>CL</b> 13th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>spellstealing</i> weapon allows its wielder to siphon protective magic from a target and transfer it to herself. When the wielder rolls a critical threat against a target, she can forgo confirming the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> and instead automatically learn which spells or magical effects are active upon the target. The wielder may then make a <a href=\"http://www.d20pfsrd.com/magic#TOC-Caster-Level\">caster level</a> check to steal her choice of one of those effects, using the <i>spellstealing</i> weapon's <a href=\"http://www.d20pfsrd.com/magic#TOC-Caster-Level\">caster level</a> plus its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>, against a DC of 11 + the <a href=\"http://www.d20pfsrd.com/magic#TOC-Caster-Level\">caster level</a> of the effect. If the check succeeds, the target immediately loses the benefits of that effect and the wielder gains the effect for 1 minute (or until the effect expires, whichever comes first). If the <i>spellstealing</i> weapon has a critical multiplier greater than x2, the wielder may attempt to steal one additional spell effect per additional multiple beyond x2 (two effects for x3, and so on).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/arcane-sight\" style=\"font-style:italic\">greater arcane sight</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/limited-wish\" style=\"font-style:italic\">limited wish</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    //+4
    BRILLIANT_ENERGY("Brilliant Energy", 0, 4, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +4 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 16th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>brilliant energy</i> weapon has its significant portion transformed into light, although this does not modify the item's weight. It always gives off light as a torch (20-foot radius). A <i>brilliant energy</i> weapon ignores nonliving matter. Armor and shield bonuses to AC (including any enhancement bonuses to that armor) do not count against it because the weapon passes through armor. (<a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Dexterity-Dex-\">Dexterity</a>, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Bonus-Deflection-\">deflection</a>, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Dodge-Bonus\">dodge</a>, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Bonus-Natural-Armor-\">natural armor</a>, and other such bonuses still apply.) A <i>brilliant energy</i> weapon cannot harm <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Construct\">constructs</a>, or objects.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/g/gaseous-form\" style=\"font-style:italic\">gaseous form</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/continual-flame\" style=\"font-style:italic\">continual flame</a>; <b>Cost</b> +4 bonus</p>\n" +
            "</div></div></td>"),
    DANCING("Dancing", 0, 4, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +4 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 15th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Standard-Actions\">standard action</a>, a <i>dancing</i> weapon can be loosed to attack on its own. It fights for 4 rounds using the base <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attack-Bonus\">attack bonus</a> of the one who loosed it and then drops. While dancing, it cannot make <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attacks-of-Opportunity\">attacks of opportunity</a>, and the activating character it is not considered armed with the weapon. The weapon is considered wielded or attended by the activating character for all maneuvers and effects that target items. While <i>dancing</i>, the weapon shares the same space as the activating character and can attack adjacent foes (weapons with reach can attack opponents up to 10 feet away). The <i>dancing</i> weapon accompanies the activating character everywhere, whether she moves by physical or magical means. If the activating character has an unoccupied hand, she can grasp it while it is attacking on its own as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>; when so retrieved, the weapon can't dance (attack on its own) again for 4 rounds. This special ability can only be placed on melee weapons.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/animate-objects\" style=\"font-style:italic\">animate objects</a>; <b>Cost</b> +4 bonus</p>\n" +
            "</div></div></td>"),
    //+5
    VORPAL("Vorpal", 0, 5, new boolean[]{false, true, false}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +5 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a> and <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 18th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This potent and feared ability allows the weapon to sever the heads of those it strikes.</p><p>Upon a roll of <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Natural-20\">natural 20</a> (followed by a successful roll to confirm the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>), the weapon severs the opponent's head (if it has one) from its body. Some creatures, such as many <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Aberration\">aberrations</a> and all <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Ooze\">oozes</a>, have no heads. Others, such as <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/constructs/golem\">golems</a> and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> creatures other than <a href=\"https://sites.google.com/site/pathfinderogc/bestiary/monster-listings/templates/vampire/vampire\">vampires</a>, are not affected by the loss of their heads. Most other creatures, however, die when their heads are cut off. A <i>vorpal</i> weapon must be a slashing melee weapon. If you roll this special ability randomly for an inappropriate weapon, reroll.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/circle-of-death\" style=\"font-style:italic\">circle of death</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/k/keen-edge\" style=\"font-style:italic\">keen edge</a>; <b>Cost</b> +5 bonus</p>\n" +
            "</div></div></td>"),
    TRANSFORMATIVE("Transformative", 10000, 5, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +10,000 gp<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>transformative</i> weapon alters its shape at its wielder's command, becoming any other melee weapon of the same general shape and handedness; the weapon's categorization as simple, martial, or exotic is irrelevant. For example, a Medium <i>transformative</i> <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/longsword\">longsword</a> can take the shape of any other Medium one-handed melee weapon, such as a <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/scimitar\">scimitar</a>, <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/flail\">flail</a>, or <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/trident\">trident</a>, but not a Medium light or two-handed melee weapon (such as a Medium short sword or a Medium <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/greatsword\">greatsword</a>). It can even take the shape of comparable weapons of different size categories. For example, a Small <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/greatsword\">greatsword</a> is a two-handed slashing weapon for a Small character, but is a one-handed slashing weapon for a Medium character, which is very similar to a Medium <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/longsword\">longsword</a>; a Small <i>transformative</i> <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/greatsword\">greatsword</a> can thus become an actual Medium <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/longsword\">longsword</a>, usable by a Medium creature without the —2 penalty for using a weapon of the wrong size. The weapon retains all of its abilities , including enhancement bonuses and weapon special abilities , except those prohibited by its current shape. For example, a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/keen\"><i>keen</i></a> <i>transformative</i> weapon functions normally in the form of a piercing or slashing weapon, but cannot use the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/keen\"><i>keen</i></a> special ability when in the shape of a bludgeoning weapon. When unattended, the weapon reverts to its true shape.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/major-creation\" style=\"font-style:italic\">major creation</a>; <b>Cost</b> +5,000 gp</p>\n" +
            "</div></div></td>"),
    DUELING("Dueling", 14000, 5, new boolean[]{true, true, true}, true, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +14,000 gp<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on melee weapons. A <i>dueling</i> weapon (which must be a weapon that can be used with the <a href=\"http://www.d20pfsrd.com/feats/combat-feats/weapon-finesse-combat---final\">Weapon Finesse</a> feat) gives the wielder a +4 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> on <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Initiative\">initiative</a> checks, provided the weapon is drawn and in hand when the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Initiative\">Initiative</a> check is made. It provides a +2 bonus on <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Disarm\">disarm</a> checks and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Feint\">feint</a> checks, a +2 bonus to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">CMD</a> to resist <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Disarm\">disarm</a> attempts, and a +2 to the DC to perform a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Feint\">feint</a> against the wielder.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cat-s-grace\" style=\"font-style:italic\">cat's grace</a>; <b>Cost</b> +7,000 gp</p>\n" +
            "</div></div></td>");

    public static final MeleeBonusEnum[][] tiers = new MeleeBonusEnum[][]{
            {KI_FOCUS, KI_INTENSIFYING},
            {FLAMING, IGNITING}
    };
    public static final MeleeBonusEnum[][] incompatible = new MeleeBonusEnum[][]{
            {REPOSITIONING, ANCHORING}
    };

    private final String NAME;
    private final int BONUS;
    private final int PRICE;
    private final boolean[] ALLOWED_DAMAGE_TYPES; //Piercing, Slashing, Bludgeoning
    private final boolean CAN_BE_LIGHT;
    private final boolean MUST_BE_NONLETHAL;
    private final String DESCRIPTION;

    MeleeBonusEnum(String name, int price, int bonus, boolean[] allowedDamageTypes, boolean canBeLight, boolean mustBeNonlethal, String desc){
        NAME = name;
        PRICE = price;
        BONUS = bonus;
        ALLOWED_DAMAGE_TYPES = allowedDamageTypes;
        CAN_BE_LIGHT = canBeLight;
        MUST_BE_NONLETHAL = mustBeNonlethal;
        DESCRIPTION = desc;
    }

    public static void applyRandomBonuses(GenItem baseItem, int tier){
        if(!(baseItem.baseItem() instanceof WeaponEnum)) return;

        if(tier == ItemUtil.MINOR){
            getMinorBonuses(baseItem, new ArrayList<>());
        }

        if(tier == ItemUtil.MEDIUM){
            getMediumBonuses(baseItem, new ArrayList<>());
        }

        if(tier == ItemUtil.MAJOR){
            getMajorBonuses(baseItem, new ArrayList<>());
        }
    }

    private static void getMinorBonuses(GenItem base, List<MeleeBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(MeleeBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.BONUS
                ;

        if(percentage <= 70) giveEnhancement(1, base);
        else if(percentage <= 85) {
            if(currentBonusValue > 8)
                giveEnhancement(1, base);
            else
                giveEnhancement(2, base);
        }
        else if(percentage <= 90) {
            makeSpecific(ItemUtil.MINOR, base);
            currentBonuses.clear();
        }
        else {
            rollForSpecialAbility(base, currentBonuses, ItemUtil.MINOR);

            currentBonusValue = 0;
            for(MeleeBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.BONUS
                    ;

            if(currentBonusValue == 9){
                giveEnhancement(1, base);
                return;
            }

            getMinorBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void getMediumBonuses(GenItem base, List<MeleeBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(MeleeBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.BONUS
                ;

        if(percentage <= 10) giveEnhancement(1, base);
        else if(percentage <= 29) {
            if(currentBonusValue > 8)
                giveEnhancement(1, base);
            else
                giveEnhancement(2, base);
        }
        else if(percentage <= 58)
            if(currentBonusValue > 7)
                getMediumBonuses(base, currentBonuses);
            else
                giveEnhancement(3, base);
        else if(percentage <= 62)
            if(currentBonusValue > 6)
                getMediumBonuses(base, currentBonuses);
            else
                giveEnhancement(4, base);
        else if(percentage <= 68) {
            makeSpecific(ItemUtil.MEDIUM, base);
            currentBonuses.clear();
        }
        else {
            rollForSpecialAbility(base, currentBonuses, ItemUtil.MEDIUM);

            currentBonusValue = 0;
            for(MeleeBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.BONUS
                    ;

            if(currentBonusValue == 9){
                giveEnhancement(1, base);
                return;
            }

            getMediumBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void getMajorBonuses(GenItem base, List<MeleeBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(MeleeBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.BONUS
                ;

        if(percentage <= 20) giveEnhancement(3, base);
        else if(percentage <= 38) {
            if(currentBonusValue > 6)
                giveEnhancement(3, base);
            else
                giveEnhancement(4, base);
        }
        else if(percentage <= 49)
            if(currentBonusValue > 5)
                getMajorBonuses(base, currentBonuses);
            else
                giveEnhancement(5, base);
        else if(percentage <= 63) {
            makeSpecific(ItemUtil.MAJOR, base);
            currentBonuses.clear();
        } else {
            rollForSpecialAbility(base, currentBonuses, ItemUtil.MAJOR);

            currentBonusValue = 0;
            for(MeleeBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.BONUS
                    ;

            if(currentBonusValue == 7){
                giveEnhancement(3, base);
                return;
            }

            getMajorBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void applySpecialAbilities(GenItem base, List<MeleeBonusEnum> currentBonuses){

        //Check for glowing etc.
        int percentage = rollPercent();
        if(percentage <= 30){
            base.newDescription = base.getFormattedDetails() + "\n\nThe item sheds light (equivalent to a light spell.)";
        } else if(percentage <= 45){
            base.newDescription = base.getFormattedDetails() + "Something (a design, inscription, or the like) provides a clue to the weapon's function";
        }

        //Enhancement bonus should already be applied.
        for(MeleeBonusEnum enchantment : currentBonuses){
            base.newName = base.getItemName() + ", " + enchantment.getNAME();
            base.newDescription = base.getFormattedDetails() + "\n\n" + enchantment.getDESCRIPTION();
        }

        int[] increasedCost = new int[]{0, 2000, 8000, 18000, 32000, 50000, 72000, 98000, 128000, 162000, 200000};
        int costIncrease = 300; //For masterwork

        if(((WeaponEnum)base.itemBase).special().toLowerCase().contains("double")) costIncrease += 300;

        int currentBonusValue = Integer.parseInt("" + base.getItemName().charAt(base.getItemName().indexOf("+") + 1));
        for(MeleeBonusEnum bonus : currentBonuses){
            if(bonus.PRICE == 0){
                currentBonusValue += bonus.BONUS
                ;
            } else {
                costIncrease += bonus.PRICE;
            }
        }

        costIncrease += increasedCost[currentBonusValue];
        base.newCost = new int[]{base.cost()[0], base.cost()[1] + costIncrease, base.cost()[2], base.cost()[3]};
    }

    private static void makeSpecific(int tier, GenItem base){
        int percentage = rollPercent();

        if(tier == ItemUtil.MINOR){
            if(percentage <= 15) ItemUtil.duplicate(ItemUtil.getItem("Sleep Arrow"), base);
            else if(percentage <= 25) ItemUtil.duplicate(ItemUtil.getItem("Screaming Bolt"), base);
            else if(percentage <= 45) ItemUtil.duplicate(ItemUtil.getItem("Silver Dagger, Masterwork"), base);
            else if(percentage <= 65) ItemUtil.duplicate(ItemUtil.getItem("Javelin of Lightning"), base); //TODO add "Cold Iron longsword, masterwork" for this
            else if(percentage <= 75) ItemUtil.duplicate(ItemUtil.getItem("Javelin of Lightning"), base);
            else if(percentage <= 80) ItemUtil.duplicate(ItemUtil.getItem("Slaying Arrow"), base);
            else if(percentage <= 90) ItemUtil.duplicate(ItemUtil.getItem("Silver Dagger, Masterwork"), base); //TODO add "Adamantine Dagger" for this
            else ItemUtil.duplicate(ItemUtil.getItem("Lute of the Battle Ready"), base); //TODO add "Adamantine Battleaxe" for this
        }
        if(tier == ItemUtil.MEDIUM){
            if(percentage <= 9) ItemUtil.duplicate(ItemUtil.getItem("Javelin of Lightning"), base);
            else if(percentage <= 15) ItemUtil.duplicate(ItemUtil.getItem("Slaying Arrow"), base);
            else if(percentage <= 24) ItemUtil.duplicate(ItemUtil.getItem("Silver Dagger, Masterwork"), base); //TODO add "Adamantine Dagger" for this
            else if(percentage <= 33) ItemUtil.duplicate(ItemUtil.getItem("Lute of the Battle Ready"), base); //TODO add "Adamantine Battleaxe" for this
            else if(percentage <= 37) ItemUtil.duplicate(ItemUtil.getItem("Slaying Arrow, Greater"), base);
            else if(percentage <= 40) ItemUtil.duplicate(ItemUtil.getItem("Shatterspike"), base);
            else if(percentage <= 46) ItemUtil.duplicate(ItemUtil.getItem("Dagger of Venom"), base);
            else if(percentage <= 51) ItemUtil.duplicate(ItemUtil.getItem("Trident of Warning"), base);
            else if(percentage <= 57) ItemUtil.duplicate(ItemUtil.getItem("Assassin's Dagger"), base);
            else if(percentage <= 62) ItemUtil.duplicate(ItemUtil.getItem("Shifter's Sorrow"), base);
            else if(percentage <= 66) ItemUtil.duplicate(ItemUtil.getItem("Trident of Fish Command"), base);
            else if(percentage <= 74) ItemUtil.duplicate(ItemUtil.getItem("Flame Tongue"), base);
            else if(percentage <= 79) ItemUtil.duplicate(ItemUtil.getItem("Luck Blade 0 Wishes"), base);
            else if(percentage <= 86) ItemUtil.duplicate(ItemUtil.getItem("Sword of Sublety"), base);
            else if(percentage <= 91) ItemUtil.duplicate(ItemUtil.getItem("Sword of the Planes"), base);
            else if(percentage <= 95) ItemUtil.duplicate(ItemUtil.getItem("Nine Lives Stealer"), base);
            else if(percentage <= 98) ItemUtil.duplicate(ItemUtil.getItem("Oathbow"), base);
            else ItemUtil.duplicate(ItemUtil.getItem("Sword of Life Stealing"), base);
        }
        if(tier == ItemUtil.MAJOR){
            if(percentage <= 4) ItemUtil.duplicate(ItemUtil.getItem("Assassin's Dagger"), base);
            else if(percentage <= 7) ItemUtil.duplicate(ItemUtil.getItem("Shifter's Sorrow"), base);
            else if(percentage <= 9) ItemUtil.duplicate(ItemUtil.getItem("Trident of Fish Command"), base);
            else if(percentage <= 13) ItemUtil.duplicate(ItemUtil.getItem("Flame Tongue"), base);
            else if(percentage <= 17) ItemUtil.duplicate(ItemUtil.getItem("Luck Blade 0 Wishes"), base);
            else if(percentage <= 24) ItemUtil.duplicate(ItemUtil.getItem("Sword of Sublety"), base);
            else if(percentage <= 31) ItemUtil.duplicate(ItemUtil.getItem("Sword of the Planes"), base);
            else if(percentage <= 37) ItemUtil.duplicate(ItemUtil.getItem("Nine Lives Stealer"), base);
            else if(percentage <= 42) ItemUtil.duplicate(ItemUtil.getItem("Oathbow"), base);
            else if(percentage <= 46) ItemUtil.duplicate(ItemUtil.getItem("Sword of Life Stealing"), base);
            else if(percentage <= 51) ItemUtil.duplicate(ItemUtil.getItem("Mace of Terror"), base);
            else if(percentage <= 57) ItemUtil.duplicate(ItemUtil.getItem("Life-Drinker"), base);
            else if(percentage <= 62) ItemUtil.duplicate(ItemUtil.getItem("Sylvan Scimitar"), base);
            else if(percentage <= 67) ItemUtil.duplicate(ItemUtil.getItem("Rapier of Punching"), base);
            else if(percentage <= 73) ItemUtil.duplicate(ItemUtil.getItem("Sun Blade"), base);
            else if(percentage <= 79) ItemUtil.duplicate(ItemUtil.getItem("Frost Brand"), base);
            else if(percentage <= 84) ItemUtil.duplicate(ItemUtil.getItem("Dwarven Thrower"), base);
            else if(percentage <= 91) ItemUtil.duplicate(ItemUtil.getItem("Luck Blade 1 Wish"), base);
            else if(percentage <= 95) ItemUtil.duplicate(ItemUtil.getItem("Mace of Smiting"), base);
            else if(percentage <= 97) ItemUtil.duplicate(ItemUtil.getItem("Luck Blade 2 Wishes"), base);
            else if(percentage <= 99) ItemUtil.duplicate(ItemUtil.getItem("Holy Avenger"), base);
            else ItemUtil.duplicate(ItemUtil.getItem("Luck Blade 3 Wishes"), base);
        }
    }

    private static void rollForSpecialAbility(GenItem item, List<MeleeBonusEnum> current, int tier){
        int percentage = rollPercent();

        int bonusValue = 0;
        for(MeleeBonusEnum bonus : current) bonusValue += bonus.BONUS;
        if(bonusValue > 8) return;

        if(tier == ItemUtil.MINOR){
            if(percentage <= 99){
                getRandomBonusOfTier(1, (WeaponEnum)item.baseItem(), current);
            } else {
                rollForSpecialAbility(item, current, tier);
                rollForSpecialAbility(item, current, tier);
            }
        } else if(tier == ItemUtil.MEDIUM){
            if(percentage <= 69) getRandomBonusOfTier(1, (WeaponEnum)item.baseItem(), current);
            else if(percentage <= 95){
                if(bonusValue > 7){
                    getRandomBonusOfTier(1, (WeaponEnum)item.baseItem(), current);
                    return;
                }
                getRandomBonusOfTier(2, (WeaponEnum)item.baseItem(), current);
            } else {
                rollForSpecialAbility(item, current, tier);
                rollForSpecialAbility(item, current, tier);
            }
        } else if(tier == ItemUtil.MAJOR){
            if(bonusValue >= 7) return;
            if(percentage <= 36) getRandomBonusOfTier(1, (WeaponEnum)item.baseItem(), current);
            else if(percentage <= 78) {
                if(bonusValue > 5){
                    getRandomBonusOfTier(1, (WeaponEnum)item.baseItem(), current);
                    return;
                }
                getRandomBonusOfTier(2, (WeaponEnum)item.baseItem(), current);
            }
            else if(percentage <= 83){
                if(bonusValue > 4){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                getRandomBonusOfTier(3, (WeaponEnum)item.baseItem(), current);
            } else if(percentage <= 88){
                if(bonusValue > 3){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                getRandomBonusOfTier(4, (WeaponEnum)item.baseItem(), current);
            } else if(percentage <= 90){
                if(bonusValue > 2){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                getRandomBonusOfTier(5, (WeaponEnum)item.baseItem(), current);
            } else {
                rollForSpecialAbility(item, current, tier);
                rollForSpecialAbility(item, current, tier);
            }
        }
    }

    private static void getRandomBonusOfTier(int bonusValue, WeaponEnum base, List<MeleeBonusEnum> current){
        ArrayList<MeleeBonusEnum> correctBonus = new ArrayList<>();
        correctBonus.addAll(Arrays.asList(values()).stream().filter(bonus -> bonus.BONUS == bonusValue).collect(Collectors.toList()));

        MeleeBonusEnum toTest = correctBonus.get((int)(Math.random() * correctBonus.size()));

        if(toTest == FROST && current.contains(ICY_BURST)){
            getRandomBonusOfTier(bonusValue, base, current);
            return;
        }

        if(toTest == ICY_BURST && current.contains(FROST)){
            current.set(current.indexOf(FROST), ICY_BURST);
            return;
        }

        if(toTest.MUST_BE_NONLETHAL && !(base.special().toLowerCase().contains("nonlethal"))){
            getRandomBonusOfTier(bonusValue, base, current);
            return;
        }

        if(!(toTest.CAN_BE_LIGHT || !base.subtype().equalsIgnoreCase("light"))){
            getRandomBonusOfTier(bonusValue, base, current);
            return;
        }

        boolean correctDamageType = false;
        if(toTest.ALLOWED_DAMAGE_TYPES[0] && base.damageType().toLowerCase().contains("piercing")) correctDamageType = true;
        if(toTest.ALLOWED_DAMAGE_TYPES[1] && base.damageType().toLowerCase().contains("slashing")) correctDamageType = true;
        if(toTest.ALLOWED_DAMAGE_TYPES[2] && base.damageType().toLowerCase().contains("bludgeoning")) correctDamageType = true;

        if(!correctDamageType){
            getRandomBonusOfTier(bonusValue, base, current);
            return;
        }

        int checkTiers = -1;
        int toCheckIndex = -1;
        int checkIncompatible = -1;

        for(int i = 0; i < tiers.length; i++){
            for(MeleeBonusEnum meleeBonusEnum : tiers[i]){
                if(toTest == meleeBonusEnum) checkTiers = i;
            }
        }

        for(int i = 0; i < incompatible.length; i++){
            for(MeleeBonusEnum meleeBonusEnum : incompatible[i]){
                if(toTest == meleeBonusEnum) checkIncompatible = i;
            }
        }

        for(int i = 0; i < current.size(); i++){
            //Check for duplicate.
            if(toTest == current.get(i)){
                getRandomBonusOfTier(bonusValue, base, current);
                return;
            }

            //Check for burst effects
            if(current.get(i).NAME.toLowerCase().contains(toTest.NAME.toLowerCase()) && current.get(i).NAME.toLowerCase().contains("burst")) {
                getRandomBonusOfTier(bonusValue, base, current);
                return;
            }
            if(toTest.NAME.toLowerCase().contains(current.get(i).NAME.toLowerCase()) && toTest.NAME.toLowerCase().contains("burst")){
                current.set(i, toTest);
                return;
            }

            //Check tier if toCheck is on tier list.
            if(checkTiers != -1){
                int currentlyAddedIndex = -1;
                for(int j = 0; j < tiers[checkTiers].length; j++){
                    if(current.get(i) == tiers[checkTiers][j]){
                        currentlyAddedIndex = j;
                        break;
                    }
                }
                if(currentlyAddedIndex != -1){
                    if(currentlyAddedIndex < toCheckIndex){ //If toTest is better than the current bonus
                        current.set(currentlyAddedIndex, toTest);
                        return;
                    } else {
                        getRandomBonusOfTier(bonusValue, base, current);
                        return;
                    }
                }
            }

            //Check incompatibility is needed.
            for(MeleeBonusEnum currentBonus : current){
                if(Arrays.asList(incompatible[checkIncompatible]).contains(currentBonus)){
                    getRandomBonusOfTier(bonusValue, base, current);
                    return;
                }
            }
        }

        //All checks successful, add the bonus to the list.
        current.add(toTest);
    }

    private static int rollPercent(){
        return (int)(Math.random() * 100) + 1;
    }

    private static void giveEnhancement(int enhancement, GenItem base){
        base.newName = base.getItemName() + " +" + enhancement;
    }

    public int getCOST(){
        return PRICE;
    }

    public int bonusValue(){
        return BONUS;
    }

    public String getDESCRIPTION(){
        String desc = "<h3 xmlns=\"http://www.w3.org/1999/xhtml\" id=\"sites-page-title-header\" style=\"\" align=\"left\">\n" +
                "<span id=\"sites-page-title\" dir=\"ltr\" tabindex=\"-1\" style=\"outline: none\">" + NAME + " </span>\n" +
                "</h3>";
        desc += DESCRIPTION;
        return desc;
    }

    public String getNAME(){
        return NAME;
    }

}
