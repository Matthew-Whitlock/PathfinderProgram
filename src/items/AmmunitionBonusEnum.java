package src.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Matthew on 12/17/2016.
 */
public enum AmmunitionBonusEnum {
    BANE("Bane", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
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
    CONDUCTIVE("Conductive", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus; <b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>conductive</i> weapon is able to channel the energy of a <a href=\"http://www.d20pfsrd.com/magic#TOC-Spell-Like-Abilities-Sp-\">spell-like</a> or <a href=\"http://www.d20pfsrd.com/magic#TOC-Supernatural-Abilities-Su-\">supernatural</a> ability that relies on a melee or ranged <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch attack</a> to hit its target (such as from a <a href=\"http://www.d20pfsrd.com/classes/core-classes/cleric\">cleric's</a> domain granted power, <a href=\"http://www.d20pfsrd.com/classes/core-classes/sorcerer\">sorcerer's</a> <a href=\"http://www.d20pfsrd.com/classes/core-classes/sorcerer#TOC-Bloodline\">bloodline power</a>, <a href=\"http://www.d20pfsrd.com/classes/base-classes/oracle\">oracle's</a> mystery revelation, or <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard\">wizard's</a> arcane school power). When the wielder makes a successful attack of the appropriate type, he may choose to expend two uses of his magical ability to channel it through the weapon to the struck opponent, which suffers the effects of both the weapon attack and the special ability. (If the wielder has unlimited uses of a special ability, she may channel through the weapon every round.) For example, a <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin\">paladin</a> who strikes an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> opponent with her <i>conductive</i> <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/greatsword\">greatsword</a> can expend two uses of her <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin#TOC-Lay-On-Hands-Su-\">lay on hands</a> ability (a <a href=\"http://www.d20pfsrd.com/magic#TOC-Supernatural-Abilities-Su-\">supernatural</a> melee <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch attack</a>) to deal both <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/greatsword\">greatsword</a> damage and damage from one use of <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin#TOC-Lay-On-Hands-Su-\">lay on hands</a>. <br></p><p>A given character can use this weapon special ability only once per round (even if she has several <i>conductive</i> weapons), and the power works only with magical abilities of the same type as the weapon (melee or ranged).<br></p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/spectral-hand\" style=\"font-style:italic\">spectral hand</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CORROSIVE("Corrosive", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a <i>corrosive</i> weapon becomes slick with acid that deals an extra 1d6 points of acid damage on a successful hit. The acid does not harm the wielder. The effect remains until another command is given.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/acid-arrow\" style=\"font-style:italic\">acid arrow</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CRUEL("Cruel", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>When the wielder strikes a creature that is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Frightened\">frightened</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Shaken\">shaken</a>, or <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Panicked\">panicked</a> with a <i>cruel</i> weapon, that creature becomes <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Sickened\">sickened</a> for 1 round. When the wielder uses the weapon to knock <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Unconscious\">unconscious</a> or kill a creature, he gains 5 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Temporary-Hit-Points\">temporary hit points</a> that last for 10 minutes.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cause-fear\" style=\"font-style:italic\">cause fear</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/death-knell\" style=\"font-style:italic\">death knell</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CUNNING("Cunning", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus; <b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Divination\">divination</a>; <b>CL</b> 6th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability allows a weapon to find chinks in a foe's defenses using the wielder's knowledge of the target.</p><p>Whenever the weapon’s attack is a critical threat, the wielder gains a +4 bonus on the confirmation roll if she has 5 or more ranks in a <a href=\"http://www.d20pfsrd.com/skills/knowledge\">Knowledge</a> skill that would be used to identify the target’s creature type  (such as <a href=\"http://www.d20pfsrd.com/skills/knowledge\">Knowledge</a> [planes] for an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Outsider\">outsider</a> opponent), or a +6 bonus instead if she has 15 or more ranks.<br></p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/true-strike\" style=\"font-style:italic\">true strike</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    FLAMING("Flaming", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a <i>flaming</i> weapon is sheathed in fire that deals an extra 1d6 points of fire damage on a successful hit. The fire does not harm the wielder. The effect remains until another command is given.</p><h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a> <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-blade\" style=\"font-style:italic\">flame blade</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-strike\" style=\"font-style:italic\">flame strike</a>, or <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fireball\" style=\"font-style:italic\">fireball</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    FROST("Frost", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a <i>frost</i> weapon is sheathed in a terrible, icy cold that deals an extra 1d6 points of cold damage on a successful hit. The cold does not harm the wielder. The effect remains until another command is given.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/chill-metal\" style=\"font-style:italic\">chill metal</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/ice-storm\" style=\"font-style:italic\">ice storm</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    GHOST_TOUCH("Ghost Touch", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 9th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>ghost touch</i> weapon deals damage normally against <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creatures, regardless of its bonus. An <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creature's 50% reduction in damage from corporeal sources does not apply to attacks made against it with <i>ghost touch</i> weapons. The weapon can be picked up and moved by an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creature at any time. A manifesting <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/templates/ghost\">ghost</a> can wield the weapon against corporeal foes. Essentially, a <i>ghost touch</i> weapon counts as both corporeal or <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a>. </p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/p/plane-shift\" style=\"font-style:italic\">plane shift</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    LIMNING("Limning", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>When a <i>liming</i> weapon is wielded, a pale glow outlines it.</p><p>On a successful strike against a creature affected by a means of magical <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Concealment\">concealment</a>, the weapon outlines the creature in <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/faerie-fire\" style=\"font-style:italic\">faerie fire</a> (as the spell) for 1 round. Magical means of <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Concealment\">concealment</a> include <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/blur\" style=\"font-style:italic\">blur</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/displacement\" style=\"font-style:italic\">displacement</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/invisibility\" style=\"font-style:italic\">invisibility</a>, and similar effects, whether from a spell, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Spell-Like-Abilities-Sp-\">spell-like ability</a>, or <a href=\"http://www.d20pfsrd.com/magic#TOC-Supernatural-Abilities-Su-\">supernatural</a> means, but not those provided by <a href=\"http://www.d20pfsrd.com/magic#TOC-Extraordinary-Abilities-Ex-\">extraordinary abilities</a> . A <i>liming</i> weapon has no special effect against creatures merely hiding or concealed by non-magical means, or those hidden by environmental conditions (even magical) such as <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/darkness\" style=\"font-style:italic\">darkness</a> or fog.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/faerie-fire\" style=\"font-style:italic\">faerie fire</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    MERCIFUL("Merciful", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>merciful</i> weapon deals an extra 1d6 points of damage, but all damage it deals is <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Nonlethal-Damage\">nonlethal damage</a>. On command, the weapon suppresses this ability until told to resume it (allowing it to deal lethal damage, but without any bonus damage from this ability).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cure-light-wounds\" style=\"font-style:italic\">cure light wounds</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    PLANAR("Planar", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 9th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>planar</i> weapon is effective against all types of <a href=\"http://www.d20pfsrd.com/magic#TOC-Extradimensional-Spaces\">extradimensional</a> beings, able to pierce their <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Resistance\">resistance</a> to physical harm. When used to attack <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Outsider\">outsiders</a>, a <i>planar</i> weapon ignores 5 points of their <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/p/plane-shift\" style=\"font-style:italic\">plane shift</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    SEEKING("Seeking", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Divination\">divination</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on ranged weapons. A <i>seeking</i> weapon veers toward its target, negating any miss chances that would otherwise apply, such as from <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Concealment\">concealment</a>. The wielder still has to aim the weapon at the right square. Arrows mistakenly shot into an empty space, for example, do not veer and hit <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Invisible\">invisible</a> enemies, even if they are nearby.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/true-seeing\" style=\"font-style:italic\">true seeing</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    SHOCK("Shock", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 8th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a <i>shock</i> weapon is sheathed in crackling electricity that deals an extra 1d6 points of electricity damage on a successful hit. The electricity does not harm the wielder. The effect remains until another command is given.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/call-lightning\" style=\"font-style:italic\">call lightning</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/lightning-bolt\" style=\"font-style:italic\">lightning bolt</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    THUNDERING("Thundering", 1, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +1 bonus<br>\n" +
            "<b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 5th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>thundering</i> weapon creates a cacophonous roar like thunder whenever it strikes a target with a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The sonic energy does not harm the wielder. A <i>thundering</i> weapon deals an extra 1d8 points of sonic damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical multiplier is x3, add an extra 2d8 points of sonic damage instead, and if the multiplier is x4, add an extra 3d8 points of sonic damage. Subjects dealt critical hits by a <i>thundering</i> weapon must make a successful DC 14 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> save or be <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Deafened\">deafened</a> permanently.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/blindness-deafness\"><i>blindness/deafness</i></a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    ANARCHIC("Anarchic", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>anarchic</i> weapon is infused with the power of chaos. It makes the weapon chaotically aligned and thus bypasses the corresponding <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. It deals an extra 2d6 points of damage against all creatures of lawful <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Alignment\">alignment</a>. It bestows one permanent <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Lawful\">lawful</a> creature attempting to wield it. The <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the weapon is in hand and disappears when the weapon is no longer wielded. This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the weapon is wielded.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/chaos-hammer\" style=\"font-style:italic\">chaos hammer</a>, creator must be <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Chaotic\">chaotic</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    AXIOMATIC("Axiomatic", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>axiomatic</i> weapon is infused with lawful power. It makes the weapon law-aligned and thus bypasses the corresponding <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. It deals an extra 2d6 points of damage against chaotic creatures. It bestows one permanent <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any chaotic creature attempting to wield it. The <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the weapon is in hand and disappears when the weapon is no longer wielded. This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the weapon is wielded.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/o/order-s-wrath\" style=\"font-style:italic\">order's wrath</a>, creator must be lawful; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    CORROSIVE_BURST("Corrosive Burst", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>corrosive burst</i> weapon functions as a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/corrosive\"><i>corrosive</i></a> weapon that explodes with searing acid upon striking a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The acid does not harm the wielder. In addition to the extra acid damage from the <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/corrosive\">corrosive</a></i> special ability, a <i>corrosive burst</i> weapon deals an extra 1d10 points of acid damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical modifier is x3, add an extra 2d10 points of acid damage instead, and if the modifier is x4, add an extra 3d10 points.</p>\n" +
            "<p>Even if the <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/corrosive\">corrosive</a></i> ability is not active, the weapon still deals its extra acid damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/acid-arrow\" style=\"font-style:italic\">acid arrow</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    DESIGNATING_LESSER("Designating, Lesser", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on ranged weapons or ammunition. Each time a ranged weapon or ammunition with this ability hits a creature, its magic designates the target. Allies gain a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> on melee attack and melee damage rolls against the designated target for 1 round. Multiple successful shots fired at the same target do not increase the bonuses or their duration.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/instant-enemy\" style=\"font-style:italic\">instant enemy</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    FLAMING_BURST("Flaming Burst", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 12th; <b>Weight</b> —; <b>Price</b> +2 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming-burst\" style=\"font-style:italic\">flaming burst</a> weapon functions as a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\" style=\"font-style:italic\">flaming</a> weapon that also explodes with flame upon striking a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The fire does not harm the wielder. In addition to the extra fire damage from the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\" style=\"font-style:italic\">flaming</a> ability (see above), a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming-burst\" style=\"font-style:italic\">flaming burst</a> weapon deals an extra 1d10 points of fire damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical multiplier is x3, add an extra 2d10 points of fire damage instead, and if the multiplier is x4, add an extra 3d10 points of fire damage.</p>\n" +
            "<p>Even if the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\" style=\"font-style:italic\">flaming</a> ability is not active, the weapon still deals its extra fire damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a> and <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fireball\" style=\"font-style:italic\">fireball</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-blade\" style=\"font-style:italic\">flame blade</a>, or <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-strike\" style=\"font-style:italic\">flame strike</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    HOLY("Holy", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>holy</i> weapon is imbued with holy power. This power makes the weapon good-aligned and thus bypasses the corresponding <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. It deals an extra 2d6 points of damage against all creatures of evil <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Alignment\">alignment</a>. It bestows one permanent <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any evil creature attempting to wield it. The <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the weapon is in hand and disappears when the weapon is no longer wielded. This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including by <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the weapon is wielded.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/holy-smite\" style=\"font-style:italic\">holy smite</a>, creator must be good; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    ICY_BURST("Icy Burst", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>icy burst</i> weapon functions as a <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/frost\">frost</a></i> weapon that also explodes with frost upon striking a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The frost does not harm the wielder. In addition to the extra damage from the <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/frost\">frost</a></i> ability, an <i>icy burst</i> weapon deals an extra 1d10 points of cold damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical multiplier is x3, add an extra 2d10 points of cold damage instead, and if the multiplier is x4, add an extra 3d10 points.</p>\n" +
            "<p>Even if the <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/frost\">frost</a></i> ability is not active, the weapon still deals its extra cold damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/chill-metal\" style=\"font-style:italic\">chill metal</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/ice-storm\" style=\"font-style:italic\">ice storm</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    IGNITING("Igniting", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>igniting</i> weapon functions as a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\"><i>flaming</i></a> weapon that also causes the target to catch fire upon striking it with a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The target does not get a saving throw to avoid catching fire, but can make a save each round on its turn to put out the fire. The <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/flaming\"><i>flaming</i></a> ability must be active for the weapon to set enemies on fire.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-blade\" style=\"font-style:italic\">flame blade</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/flame-strike\" style=\"font-style:italic\">flame strike</a>, or <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fireball\" style=\"font-style:italic\">fireball</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    PHASE_LOCKING("Phase Locking", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>phase locking</i> weapon interferes with dimensional travel. A creature damaged by a <i>phase locking </i>weapon is affected as though by the <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dimensional-anchor\" style=\"font-style:italic\">dimensional anchor</a> spell for 1 round.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/dimensional-anchor\" style=\"font-style:italic\">dimensional anchor</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    SHOCKING_BURST("Shocking Burst", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 10th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>shocking burst</i> weapon functions as a <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/shock\"><i>shock</i></a> weapon that explodes with electricity upon striking a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. The electricity does not harm the wielder. In addition to the extra electricity damage from the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/shock\"><i>shock</i></a> ability, a <i>shocking burst</i> weapon deals an extra 1d10 points of electricity damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>. If the weapon's critical multiplier is x3, add an extra 2d10 points of electricity damage instead, and if the multiplier is x4, add an extra 3d10 points.</p>\n" +
            "<p>Even if the <a href=\"http://www.d20pfsrd.com/magic-items/magic-weapons/magic-weapon-special-abilities/shock\"><i>shock</i></a> ability is not active, the weapon still deals its extra electricity damage on a successful <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/call-lightning\" style=\"font-style:italic\">call lightning</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/lightning-bolt\" style=\"font-style:italic\">lightning bolt</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    UNHOLY("Unholy", 2, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +2 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>An <i>unholy</i> weapon is imbued with unholy power. This power makes the weapon evil-aligned and thus bypasses the corresponding <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Damage-Reduction\">damage reduction</a>. It deals an extra 2d6 points of damage against all creatures of good <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Alignment\">alignment</a>. It bestows one permanent <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any good creature attempting to wield it. The <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the weapon is in hand and disappears when the weapon is no longer wielded. This <a href=\"https://sites.google.com/site/pathfinderogc/gamemastering/special-abilities%20#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the weapon is wielded.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/u/unholy-blight\" style=\"font-style:italic\">unholy blight</a>, creator must be evil; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    BRILLIANT_ENERGY("Brilliant Energy", 4, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +4 bonus<br>\n" +
            "<b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 16th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A <i>brilliant energy</i> weapon has its significant portion transformed into light, although this does not modify the item's weight. It always gives off light as a torch (20-foot radius). A <i>brilliant energy</i> weapon ignores nonliving matter. Armor and shield bonuses to AC (including any enhancement bonuses to that armor) do not count against it because the weapon passes through armor. (<a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Dexterity-Dex-\">Dexterity</a>, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Bonus-Deflection-\">deflection</a>, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Dodge-Bonus\">dodge</a>, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Bonus-Natural-Armor-\">natural armor</a>, and other such bonuses still apply.) A <i>brilliant energy</i> weapon cannot harm <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Construct\">constructs</a>, or objects.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/g/gaseous-form\" style=\"font-style:italic\">gaseous form</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/continual-flame\" style=\"font-style:italic\">continual flame</a>; <b>Cost</b> +4 bonus</p>\n" +
            "</div></div></td>"),
    DESIGNATING_GREATER("Designating, Greater", 4, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Price</b> +4 bonus<br>\n" +
            "<b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 12th; <b>Weight</b> —</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability can only be placed on ranged weapons or ammunition. Each time a ranged weapon or ammunition with this ability hits a creature, its magic designates the target. Allies gain a +4 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> on melee <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attack-Roll\">attack rolls</a> and a +6 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> on melee damage rolls against the designated target for 1 round. Multiple successful shots fired at the same target do not increase the bonuses or their duration.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/instant-enemy\" style=\"font-style:italic\">instant enemy</a>; <b>Cost</b> +4 bonus</p>\n" +
            "</div></div></td>");

    private final String NAME;
    private final int BONUS;
    private final String DESCRIPTION;

    public static final AmmunitionBonusEnum[][] tiers = new AmmunitionBonusEnum[][]{
            {DESIGNATING_LESSER, DESIGNATING_GREATER},
            {FLAMING, IGNITING}};

    AmmunitionBonusEnum(String name, int bonus, String desc){
        NAME = name;
        BONUS = bonus;
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

    private static void getMinorBonuses(GenItem base, List<AmmunitionBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(AmmunitionBonusEnum bonus : currentBonuses) currentBonusValue += bonus.BONUS
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
            for(AmmunitionBonusEnum bonus : currentBonuses) currentBonusValue += bonus.BONUS
                    ;

            if(currentBonusValue == 9){
                giveEnhancement(1, base);
                return;
            }

            getMinorBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void getMediumBonuses(GenItem base, List<AmmunitionBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(AmmunitionBonusEnum bonus : currentBonuses) currentBonusValue += bonus.BONUS
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
            for(AmmunitionBonusEnum bonus : currentBonuses) currentBonusValue += bonus.BONUS
                    ;

            if(currentBonusValue == 9){
                giveEnhancement(1, base);
                return;
            }

            getMediumBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void getMajorBonuses(GenItem base, List<AmmunitionBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(AmmunitionBonusEnum bonus : currentBonuses) currentBonusValue += bonus.BONUS
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
            for(AmmunitionBonusEnum bonus : currentBonuses) currentBonusValue += bonus.BONUS
                    ;

            if(currentBonusValue == 7){
                giveEnhancement(3, base);
                return;
            }

            getMajorBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void applySpecialAbilities(GenItem base, List<AmmunitionBonusEnum> currentBonuses){

        //Check for glowing etc.
        int percentage = rollPercent();
        if(percentage <= 30){
            base.newDescription = base.getFormattedDetails() + "\n\nThe item sheds light (equivalent to a light spell.)";
        } else if(percentage <= 45){
            base.newDescription = base.getFormattedDetails() + "Something (a design, inscription, or the like) provides a clue to the weapon's function";
        }

        //Enhancement bonus should already be applied.
        for(AmmunitionBonusEnum enchantment : currentBonuses){
            base.newName = base.getItemName() + ", " + enchantment.getNAME();
            base.newDescription = base.getFormattedDetails() + "\n\n" + enchantment.getDESCRIPTION();
        }

        int[] increasedCost = new int[]{0, 2000, 8000, 18000, 32000, 50000, 72000, 98000, 128000, 162000, 200000};
        int costIncrease = 300; //For masterwork

        if(((WeaponEnum)base.itemBase).special().toLowerCase().contains("double")) costIncrease += 300;

        int currentBonusValue = Integer.parseInt("" + base.getItemName().charAt(base.getItemName().indexOf("+") + 1));
        for(AmmunitionBonusEnum bonus : currentBonuses){
            currentBonusValue += bonus.BONUS;
        }

        base.newAmount = 50;

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

    private static void rollForSpecialAbility(GenItem item, List<AmmunitionBonusEnum> current, int tier){
        int percentage = rollPercent();

        int bonusValue = 0;
        for(AmmunitionBonusEnum bonus : current) bonusValue += bonus.BONUS;
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
            else if(percentage <= 83) {
                if(bonusValue > 5){
                    getRandomBonusOfTier(1, (WeaponEnum)item.baseItem(), current);
                    return;
                }
                getRandomBonusOfTier(2, (WeaponEnum)item.baseItem(), current);
            } else if(percentage <= 90){
                if(bonusValue > 3){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                getRandomBonusOfTier(4, (WeaponEnum)item.baseItem(), current);
            } else {
                rollForSpecialAbility(item, current, tier);
                rollForSpecialAbility(item, current, tier);
            }
        }
    }

    private static void getRandomBonusOfTier(int bonusValue, WeaponEnum base, List<AmmunitionBonusEnum> current) {
        ArrayList<AmmunitionBonusEnum> correctBonus = new ArrayList<>();
        correctBonus.addAll(Arrays.asList(values()).stream().filter(bonus -> bonus.BONUS == bonusValue).collect(Collectors.toList()));

        AmmunitionBonusEnum toTest = correctBonus.get((int)(Math.random() * correctBonus.size()));

        if(toTest == FROST && current.contains(ICY_BURST)){
            getRandomBonusOfTier(bonusValue, base, current);
            return;
        }

        if(toTest == ICY_BURST && current.contains(FROST)){
            current.set(current.indexOf(FROST), ICY_BURST);
            return;
        }

        int checkTiers = -1;
        int toCheckIndex = -1;

        for(int i = 0; i < tiers.length; i++){
            for(AmmunitionBonusEnum ammunitionBonusEnum : tiers[i]){
                if(toTest == ammunitionBonusEnum) checkTiers = i;
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
