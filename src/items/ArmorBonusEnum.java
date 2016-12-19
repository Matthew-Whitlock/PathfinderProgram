package src.items;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Matthew on 12/15/2016.
 */
public enum ArmorBonusEnum {

    BENEVOLENT("Benevolent", 2000, 1, new boolean[]{true,true,true}, "<div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 bonus<br></p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor best serves a wearer who focuses on assisting and protecting his allies.</p><p>Benevolent armor is usually decorated with motifs of prosperity, plenty, and generosity, such as helping hands, cornucopias, and flourishing plants. When the wearer of a suit of benevolent armor uses the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Aid-Another\">aid another</a> action to give an ally a bonus to AC against an opponent's next attack, he also adds the benevolent armor's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to the ally's AC.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/aid\" style=\"font-style:italic\">aid</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div>"),
    POISON_RESISTANT("Poison-Resistant", 2250, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +2,250 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A suit of armor or shield with this special ability grants the wearer a +3 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Resistance-Bonus\">resistance bonus</a> on saving throws against <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/poison\">poison</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/n/neutralize-poison\" style=\"font-style:italic\">neutralize poison</a>; <b>Cost</b> +1,125 gp</p>\n" +
            "</div></div></td>"),
    BALANCED("Balanced", 0, 1, new boolean[]{true,true,false}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n"+
                     "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n"+
                     "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n"+
                     "<p>This armor pushes back against anything that threatens to knock its wearer to the ground. The wearer gains a +4 bonus to his <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">Combat Maneuver Defense</a> against <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuvers</a> made to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Overrun\">overrun</a> or <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Trip\">trip</a> and on <a href=\"http://www.d20pfsrd.com/skills/acrobatics\">Acrobatics</a> check made to maintain balance. Dropping <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Prone\">prone</a> while wearing balanced armor is a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Move-Actions\">move action</a> instead of a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>. The balanced ability can be applied to light or medium armors, but not heavy armors or shields.</p>\n"+
                     "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n"+
                     "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cat-s-grace\" style=\"font-style:italic\">cat's grace</a>; <b>Cost</b> +1 bonus</p>\n"+
                     "</div></div></td>"),
    BITER("Biter", 0, 1, new boolean[]{true,true,true}, "<div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor exudes an exceptionally vile and bitter taste whenever something bites or swallows a creature that is wearing it. Any creature that grapples the wearer with a bite attack (or any other attack using the mouth) must succeed at a DC 14 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> save to avoid immediately ending the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Grapple\">grapple</a>.</p>\n" +
            "<p>If the wearer is swallowed whole, the swallowing creature must succeed at a DC 14 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> save at the start of each turn that the armored victim remains alive inside of the creature or become <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Nauseated\">nauseated</a> for 1 round. The creature may vomit up the victim as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Standard-Actions\">standard action</a>. This is a <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/poison\">poison</a> effect.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/stinking-cloud\" style=\"font-style:italic\">stinking cloud</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div>"),
    BOLSTERING("Bolstering", 0, 1, new boolean[]{false,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Enchantment\">enchantment</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Anytime the wearer of bolstering armor damages a creature with a melee or ranged attack, he gains a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on saving throws against that creature's abilities until the start of his next turn. The bolstering ability can be applied to medium armor, heavy armor, light shields, heavy shields, and tower shields, but not light armor or bucklers.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/h/heroism\" style=\"font-style:italic\">heroism</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    BRAWLING("Brawling", 0, 1, new boolean[]{true,false,false}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>The wearer of brawling armor gains a +2 bonus on unarmed attack and damage rolls, including <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> checks made to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Grapple\">grapple</a>. Her unarmed strikes count as magic weapons for the purpose of bypassing <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Damage-Reduction\">damage reduction</a>. These bonuses do not apply to <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Natural-Attacks\">natural weapons</a>. This special ability does not prevent the wearer's unarmed strikes from provoking <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Attacks-of-Opportunity\">attacks of opportunity</a> or make the wearer's unarmed strikes count as armed attacks. The brawling ability can be applied only to light armor.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bull-s-strength\" style=\"font-style:italic\">bull's strength</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CHAMPION("Champion", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor special ability works only for good creatures with the challenge ability (such as <a href=\"http://www.d20pfsrd.com/classes/base-classes/cavalier\">cavaliers</a>) or the <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin#TOC-Smite-Evil-Su-\">smite evil</a> ability (such as <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin\">paladins</a>, <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/templates/half-celestial\">half-celestials</a>, and creatures with the <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/templates/celestial-creature-cr-special\">celestial creature</a> template). A wearer with one of these abilities gains a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Sacred-Bonus\">sacred bonus</a> to AC against attacks from the chosen opponent.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/p/protection-from-evil\" style=\"font-style:italic\">protection from evil</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    DASTARD("Dastard", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor special ability works only for evil creatures with the challenge ability (such as <a href=\"http://www.d20pfsrd.com/classes/base-classes/cavalier\">cavaliers</a>) or the <a href=\"http://www.d20pfsrd.com/classes/alternate-classes/antipaladin#TOC-Smite-Good-Su-\">smite good</a> ability (such as <a href=\"http://www.d20pfsrd.com/classes/alternate-classes/antipaladin\">antipaladins</a>, <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/templates/half-fiend\">half-fiends</a>, and creatures with the <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/templates/fiendish\">fiendish creature</a> template). A wearer with one of these abilities gains a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Profane-Bonus\">profane bonus</a> to AC against attacks from the chosen opponent.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/p/protection-from-good\" style=\"font-style:italic\">protection from good</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    DEATHLESS("Deathless", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor protects its wearer from harmful negative and positive energy, including channeled energy. The armor absorbs the first 10 points of positive or negative energy damage per attack that the wearer would normally take. The wearer has a 25% chance to ignore <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative levels</a> from any attack. Deathless armor does not block <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration-Healing\">healing</a> of any kind and does not protect against positive or negative energy effects that do not deal damage or bestow <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative levels</a>. The deathless ability can be applied to armor of any sort, but not shields.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/death-ward\" style=\"font-style:italic\">death ward</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    DEFIANT("Defiant", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 8th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor and shields with this special ability excel at blocking the attacks of certain types of creatures, similar to a <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bane\" style=\"font-style:italic\">bane</a> weapon's excelling against certain foes. Against the designated foe, the item's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to AC is +2 better than its actual bonus and provides <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a> 2/— against attacks from that foe. This increase in <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> applies only to the armor or shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>, not to temporary bonuses (such as the <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/magic-vestment\" style=\"font-style:italic\">magic vestment</a> spell). To randomly determine the armor or shield's designated foe, use the table for the <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bane\" style=\"font-style:italic\">bane</a> weapon special ability (page 136).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/summon-monster\" style=\"font-style:italic\">summon monster I</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    FORTIFICATION_LIGHT("Fortification (light)", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor or shield produces a magical force that protects vital areas of the wearer more effectively. When a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is scored on the wearer, there is a chance that the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is negated and damage is instead rolled normally. The chance is 25% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">light fortification</a>, 50% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">moderate fortification</a>, and 75% for heavy fortification.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/limited-wish\" style=\"font-style:italic\">limited wish</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/miracle\" style=\"font-style:italic\">miracle</a>; <b>Cost</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "</div></div></td>"),
    GRINDING("Grinding", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield or suit of armor with this special ability is covered with jagged burrs and razor-sharp serrations that saw and grind whenever the wearer is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Grappled\">grappled</a> or <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Entangled\">entangled</a>. Any creature succeeding at a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Grapple\">grapple</a> <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> check against the wearer takes damage equal to the armor or shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> (with each successful check) as the barbs and blades bite into it. This special ability counts as armor spikes for the purpose of making attacks on the wearer's turn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/k/keen-edge\" style=\"font-style:italic\">keen edge</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    IMPERVIOUS("Impervious", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield or suit of armor with this special ability is especially hardy. It gains double its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to <a href=\"http://www.d20pfsrd.com/equipment---final/damaging-objects#TOC-Hardness\">hardness</a> and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a> (instead of just the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>), its break DC increases by double its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>, and it gains a bonus on saving throws against direct attacks (such as a <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/aberrations/rust-monster\">rust monster's</a> rust ability) equal to its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fabricate\" style=\"font-style:italic\">fabricate</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/make-whole\" style=\"font-style:italic\">make whole</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    MIRRORED("Mirrored", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 8th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>The polished surface of a mirrored shield or armor gleams and shines, and can be used as an ordinary mirror. Furthermore, it aids in battling creatures with <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Gaze-Su-\">gaze</a> attacks. If the wearer averts his eyes, he can roll the miss chance twice, selecting the better result. The wearer can deal <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> or other precision-based damage to the target even though it has <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Concealment\">concealment</a> against him. This provides no benefit if the wearer closes his eyes, wears a blindfold, or otherwise can't see the target at all. The mirrored armor or shield also adds it <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to the wearer's <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch</a> AC against rays. it. This special ability may only be added to metallic armor or shields.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/spell-turning\" style=\"font-style:italic\">spell turning</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    SPELL_STORING("Spell Storing", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 12th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor allows a spellcaster to store a single <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch</a> spell of up to 3rd level in it. Anytime a creature hits the wearer with a melee attack or melee <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch attack</a>, the armor can cast the spell on that creature as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Immediate-Actions\"><strike>swift</strike> immediate action</a> if the wearer desires. Once the spell has been cast from the armor, a spellcaster can cast any other targeted <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch</a> spell of up to 3rd level into it. The armor magically imparts to the wielder the name of the spell currently stored within it.</p><p>A randomly rolled suit of <i>spell storing</i> armor has a 50% chance to have a spell stored in it already. <i>Spell storing</i> armor emits a strong aura of the <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a> school, plus the aura of the stored spell.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, creator must be a caster of at least 12th level; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    STANCHING("Stanching", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A stanching suit of armor helps stop the flow of blood from the wearer's wounds, automatically tightening like a tourniquet in the appropriate places while also magically reducing the severity of the wound. Stanching armor reduces hit point damage, <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Ability-Score-Damage\">ability damage</a>, or <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Ability-Drain\">ability drain</a> by an amount equal to its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> if the damage or drain was from a <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bleed\" style=\"font-style:italic\">bleed</a> effect. The wearer also adds the armor's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Constitution-Con-\">Constitution</a> checks to become <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Stable\">stable</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Stable\">stabilize</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cure-critical-wounds\" style=\"font-style:italic\">cure critical wounds</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">lesser restoration</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    WARDING("Warding", 0, 1, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 12th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Once per day as an <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Immediate-Actions\">immediate action</a>, the wearer of warding armor can <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Activate-Magic-Item\">activate</a> it to end all active challenge, <a href=\"http://www.d20pfsrd.com/classes/base-classes/inquisitor#TOC-Judgment-Su-\">judgment</a>, and <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin#TOC-Smite-Evil-Su-\">smite</a> abilities affecting her. This does not prevent opponents from selecting her as a target for these abilities in the future. As a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a>, the wearer can expend one of her own challenge, <a href=\"http://www.d20pfsrd.com/classes/base-classes/inquisitor#TOC-Judgment-Su-\">judgment</a>, or <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin#TOC-Smite-Evil-Su-\">smite</a> abilities to refresh the armor's ability to end these attacks.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/atonement\" style=\"font-style:italic\">atonement</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    GLAMERED("Glamered", 2700, 2, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Illusion\">illusion</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +2,700 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Upon command, a suit of <i>glamered</i> armor changes shape and appearance to assume the form of a normal set of clothing. The armor retains all its properties (including weight) when it is so disguised. Only a <a href=\"http://www.d20pfsrd.com/magic/all-spells/t/true-seeing\" style=\"font-style:italic\">true seeing</a> spell or similar magic reveals the true nature of the armor when it is disguised.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/disguise-self\" style=\"font-style:italic\">disguise self</a>; <b>Cost</b> +1,350 gp</p>\n" +
            "</div></div></td>"),
    JOUSTING("Jousting", 3750, 2, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +3,750 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor helps its wearer remain mounted and in control of his mount. The wearer gains a +5 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/ride\">Ride</a> skill checks.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, creator must have 5 ranks in <a href=\"http://www.d20pfsrd.com/skills/ride\">Ride</a>; <b>Cost</b> +1,875 gp</p>\n" +
            "</div></div></td>"),
    SHADOW("Shadow", 3750, 2, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Illusion\">illusion</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +3,750 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor blurs the wearer whenever she tries to hide, while also dampening the sound around her, granting a +5 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/stealth\">Stealth</a> checks. The armor's armor check penalty still applies normally.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/invisibility\" style=\"font-style:italic\">invisibility</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/silence\" style=\"font-style:italic\">silence</a>; <b>Cost</b> +1,875 gp</p>\n" +
            "</div></div></td>"),
    SLICK("Slick", 3750, 2, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 4th; <b>Weight</b> —; <b>Price</b> +3,750 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Slick armor seems coated at all times with a slightly greasy oil. It provides a +5 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on its wearer's <a href=\"http://www.d20pfsrd.com/skills/escape-artist\">Escape Artist</a> checks. The armor's armor check penalty still applies normally.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/g/grease\" style=\"font-style:italic\">grease</a>; <b>Cost</b> +1,875 gp</p>\n" +
            "</div></div></td>"),
    EXPEDITIOUS("Expeditious", 4000, 2, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +4,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Three times per day as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a>, the wearer of expeditious armor can summon a burst of speed and gain a +10-foot <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> on all modes of movement for 1 round. This ability can be applied to any kind of armor, but not shields.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/expeditious-retreat\" style=\"font-style:italic\">expeditious retreat</a>; <b>Cost</b> 2,000 gp</p>\n" +
            "</div></div></td>"),
    CREEPING("Creeping", 5000, 2, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Illusion\">illusion</a> and <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +5,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A suit of creeping armor is made to keep the wearer's movement covert. The armor's armor check penalty does not apply to the wearer's <a href=\"http://www.d20pfsrd.com/skills/stealth\">Stealth</a> checks. Once per day, the wearer can speak a command word to grant himself a bonus on <a href=\"http://www.d20pfsrd.com/skills/stealth\">Stealth</a> checks equal to the armor's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> for 1 minute.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cat-s-grace\" style=\"font-style:italic\">cat's grace</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/invisibility\" style=\"font-style:italic\">invisibility</a>; <b>Cost</b> +2,500 gp</p>\n" +
            "</div></div></td>"),
    RALLYING("Rallying", 5000, 2, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +5,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor or shield is brightly polished, and its mirror-bright surface is magically endowed with the ability to bring comfort to the wearer's companions. Allies within 30 feet of the wearer gain a +4 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> on saving throws against fear effects. If the wearer has an ability that grants a <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> on saving throws against fear (such as a <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin\">paladin's</a> aura of courage, a <a href=\"http://www.d20pfsrd.com/classes/core-classes/bard\">bard's</a> <a href=\"http://www.d20pfsrd.com/classes/core-classes/bard#TOC-Countersong-Su-\">countersong</a>, or a <a href=\"http://www.d20pfsrd.com/classes/base-classes/cavalier\">cavalier's</a> banner ability), the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> increases to +6.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/remove-fear\" style=\"font-style:italic\">remove fear</a>; <b>Cost</b> +2,500 gp</p>\n" +
            "</div></div></td>"),
    SPELL_RESISTANCE_13("Spell Resistance (13)", 0, 2, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability grants the armor or shield's wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a> while the armor or shield is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a>; <b>Cost</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "</div></div></td>"),
    ADHESIVE("Adhesive", 7000, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +7,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>On command, the hands and feet of this armor's wearer become incredibly sticky, granting her a climb speed of 20 feet. The stickiness grants the wearer a +2 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> on <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> checks made to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Disarm\">disarm</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Grapple\">grapple</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reposition\">reposition</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Steal\">steal</a>, or <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Trip\">trip</a> when the wearer is using a <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Natural-Attacks\">natural weapon</a> or <a href=\"http://www.d20pfsrd.com/equipment---final/weapons/weapon-descriptions/strike-unarmed\">unarmed strike</a> to attempt the maneuver. The wearer can gain these benefits for 10 rounds per day. These rounds need not be consecutive, but they must be spent in 1-round intervals. Ending the effect is a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>. Adhesive cannot be placed on armor with any version of the slick special ability.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bull-s-strength\" style=\"font-style:italic\">bull's strength</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/spider-climb\" style=\"font-style:italic\">spider climb</a>; <b>Cost</b> +3,500 gp</p>\n" +
            "</div></div></td>"),
    HOSTELING("Hosteling", 7500, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 9th; <b>Weight</b> —; <b>Price</b> +7,500 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A suit of armor or shield with this special ability hides living <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animals</a> within its iconography to keep it safe. The wearer can speak a command word to magically store an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> to which he is bonded, such as an <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid/animal-companions\">animal companion</a>, a <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard#TOC-Arcane-Bond-Ex-or-Sp-\">familiar</a>, or mount. The stored <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> appears as a symbol emblazoned upon the armor or shield, either one that <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/aberrations/mimic\">mimics</a> the appearance of the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> or that is more symbolic and abstract.</p>\n" +
            "<p>While stored, the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> is sleeping and provides the wearer no benefit (such as a <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard#TOC-Arcane-Bond-Ex-or-Sp-\">familiar's</a> skill bonus). The size of <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> that can be stored depends on the type of armor or shield. A suit of light armor, medium armor, or a light shield or heavy shield can store one <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> up to the wearer's size. A suit of heavy armor or a tower shield can store one <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> up to one size category larger than the wearer. A second command word releases the stored <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> from the hosteling armor or shield. A released <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> immediately awakens, appears in a space adjacent to the wearer, and can take actions on the round it appears.</p>\n" +
            "<p>Because the stored <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> is sleeping rather than in suspended animation (or even hibernating), it ages and gets hungry at the normal rate while stored. A hosteling armor or shield automatically releases a stored <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> 24 hours after it was stored inside.</p>\n" +
            "<p>This armor special ability still works on bonded <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Magical-Beast\">magical beasts</a> that were once <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animals</a>, but not <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Outsider\">outsiders</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Ooze\">oozes</a>, or other exotic companion creatures.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/secret-chest\" style=\"font-style:italic\">secret chest</a>; <b>Cost</b> 3,750 gp</p>\n" +
            "</div></div></td>"),
    RADIANT("Radiant", 7500, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 6th; <b>Weight</b> —; <b>Price</b> +7,500 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor and shields with the radiant special ability shine as brightly as a torch when worn. This radiance can be suppressed or resumed on command. Designs usually feature bright colors and a brilliant sheen even when not illuminated. Once per day, the wearer can command the armor or shield to brighten to the strength of a <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/daylight\" style=\"font-style:italic\">daylight</a> spell for 1 hour or until commanded to dim.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/daylight\" style=\"font-style:italic\">daylight</a>; <b>Cost</b> +3,750 gp</p>\n" +
            "</div></div></td>"),
    DELVING("Delving", 10000, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +10,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor with this special ability grants the wearer a <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Burrow-Ex-\">burrow</a> speed of 10 feet. This speed allows the wearer to tunnel through any type of soil, including rocky soil, but not actual solid stone. This special ability does not give the wearer the ability to breathe underground, so he must hold his breath or use other magic that provides air or allows him to breathe. The wearer gains a +4 bonus on all saving throws against landslides, avalanches, tunnel collapses, and similar effects.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/soften-earth-and-stone\" style=\"font-style:italic\">soften earth and stone</a>; <b>Cost</b> +5,000 gp</p>\n" +
            "</div></div></td>"),
    PUTRID("Putrid", 10000, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +10,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Putrid armor gives off a revolting, stomach-twisting stench. Each living creatures within 10 feet of the wearer must succeed at a DC 14 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> save or be <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Sickened\">sickened</a> for 5 rounds. This is a <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/poison\">poison</a> effect. Creatures that successfully save cannot be affected by the same armor's <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Stench-Ex-\">stench</a> for 24 hours. Creatures with the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Stench-Ex-\">stench</a> universal monster ability or <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Immunity-Ex-or-Su-\">immunity</a> to <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/poison\">poison</a> are unaffected. The wearer of putrid armor is immune to his own <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Stench-Ex-\">stench</a>, but not to <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Stench-Ex-\">stench</a>-based effects from other sources. The <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Stench-Ex-\">stench</a> can be suppressed or resumed on command, but it takes 1 minute for an active stench to dissipate. Dissipation time increases to 10 minutes in a closed area or if no wind is blowing, and decreases to 3 rounds in moderate wind or 1 round in strong wind.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/stinking-cloud\" style=\"font-style:italic\">stinking cloud</a>; <b>Cost</b> +5,000 gp</p>\n" +
            "</div></div></td>"),
    FORTIFICATION_MODERATE("Fortification (moderate)", 0, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor or shield produces a magical force that protects vital areas of the wearer more effectively. When a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is scored on the wearer, there is a chance that the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is negated and damage is instead rolled normally. The chance is 25% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">light fortification</a>, 50% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">moderate fortification</a>, and 75% for heavy fortification.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/limited-wish\" style=\"font-style:italic\">limited wish</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/miracle\" style=\"font-style:italic\">miracle</a>; <b>Cost</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "</div></div></td>"),
    GHOST_TOUCH("Ghost Touch", 0, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> +3 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor or shield seems almost translucent. Both its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> and its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Armor-Bonus\">armor bonus</a> count against the attacks of corporeal and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creatures. It can be picked up, moved, and worn by corporeal and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creatures alike. <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Incorporeal-Ex-\">Incorporeal</a> creatures gain the armor's or shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> against both corporeal and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> attacks, and they can still pass freely through solid objects.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/etherealness\" style=\"font-style:italic\">etherealness</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    INVULNERABILITY("Invulnerability", 0, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong varies; <b>CL</b> 18th; <b>Weight</b> —; <b>Price</b> +3 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor grants the wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Damage-Reduction\">damage reduction</a> 5/magic. Invulnerable armor emits a strong aura of <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a> (and <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a> if <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/miracle\" style=\"font-style:italic\">miracle</a> is used).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/stoneskin\" style=\"font-style:italic\">stoneskin</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/w/wish\" style=\"font-style:italic\">wish</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/miracle\" style=\"font-style:italic\">miracle</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    SPELL_RESISTANCE_15("Spell Resistance (15)", 0, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability grants the armor or shield's wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a> while the armor or shield is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a>; <b>Cost</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "</div></div></td>"),
    TITANIC("Titanic", 0, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +3 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A suit of armor with the titanic ability is almost comically oversized, though the effect is superficial and the interior fits a creature normally, with no adjustments necessary. A creature wearing titanic armor is considered one size category larger for the purpose of using or being affected by special attacks that depend on size, such as <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Swallow-Whole-Ex-\">swallow whole</a> and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Trample-Ex-\">trample</a>. Once per day on command, the wearer can increase her size as if using <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/enlarge-person\" style=\"font-style:italic\">enlarge person</a> (even if the wearer is not <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Humanoid\">humanoid</a>) for 1 minute. In addition, once per minute as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a> the wearer can add the armor's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to a single <a href=\"http://www.d20pfsrd.com/basics-ability-scores/ability-scores#TOC-Strength-Str-\">Strength</a> check or <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> check, or to her <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuver-Defense\">CMD</a> against a single <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a>. Because of its great bulk, the armor check penalty of titanic armor is increased by an amount equal to its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/enlarge-person\" style=\"font-style:italic\">enlarge person</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    WILD("Wild", 0, 3, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 9th; <b>Weight</b> —; <b>Price</b> +3 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor with this special ability usually appears to be made from magically hardened <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> pelt. The wearer of a suit of armor or a shield with this ability preserves his <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Armor-Bonus\">armor bonus</a> (and any <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>) while in a <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid#TOC-Wild-Shape-Su-\">wild shape</a>. Armor and shields with this ability usually appear to be covered in leaf patterns. While the wearer is in a <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid#TOC-Wild-Shape-Su-\">wild shape</a>, the armor cannot be seen.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/baleful-polymorph\" style=\"font-style:italic\">baleful polymorph</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    HARMONIZING("Harmonizing", 15000, 4, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Illusion\">illusion</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +15,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Every step taken in harmonizing armor produces a symphony of sounds. The armor harmonizes with music played, lyrics sung, and words spoken by its wearer, creating a pleasant counter-melody. Its wearer gains a +5 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/perform\">Perform</a> checks, but takes a –5 penalty on <a href=\"http://www.d20pfsrd.com/skills/stealth\">Stealth</a> checks. The wearer can be silent only if he takes no physical actions. The armor also amplifies harmful sounds, and the wearer gains <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Vulnerabilities-Ex-or-Su-\">vulnerability</a> to sonic energy damage (sonic energy attacks deal an additional 50% damage to the wearer).</p>\n" +
            "<p>If the wearer has the <a href=\"http://www.d20pfsrd.com/classes/core-classes/bard#TOC-Bardic-Performance\">bardic performance</a> class feature, the harmonizing armor causes bonuses and penalties from performances that have an audible component to continue for 1 round after the wearer ceases performing. Beginning a new <a href=\"http://www.d20pfsrd.com/classes/core-classes/bard#TOC-Bardic-Performance\">bardic performance</a> ends the effects of the previous performance immediately. This ability does not stack with the lingering Performance feat.</p>\n" +
            "<p>The harmonizing ability can be applied to any armor, but not shields.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/major-image\" style=\"font-style:italic\">major image</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/bard#TOC-Bardic-Performance\">bardic performance</a>; <b>Cost</b> +7,500 gp</p>\n" +
            "</div></div></td>"),
    SHADOW_IMPROVED("Shadow, improved", 15000, 4, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Illusion\">illusion</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +15,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-armor/magic-armor-and-shield-special-abilities/shadow\">shadow</a></i>, except it grants a +10 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/stealth\">Stealth</a> checks.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/invisibility\" style=\"font-style:italic\">invisibility</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/silence\" style=\"font-style:italic\">silence</a>; <b>Cost</b> +7,500 gp</p>\n" +
            "</div></div></td>"),
    SLICK_IMPROVED("Slick, improved", 15000, 4, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +15,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-armor/magic-armor-and-shield-special-abilities/slick\">slick</a></i>, except it grants a +10 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/escape-artist\">Escape Artist</a> checks.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/g/grease\" style=\"font-style:italic\">grease</a>; <b>Cost</b> +7,500 gp</p>\n" +
            "</div></div></td>"),
    ENERGY_RESISTANCE("Energy Resistance", 18000, 4, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 3rd; <b>Weight</b> —; <b>Price</b> +18,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A suit of armor or a shield with this special ability protects against one type of energy (acid, cold, electricity, fire, or sonic) and is designed with patterns depicting the element it protects against. The armor absorbs the first 10 points of energy damage per attack that the wearer would normally take (similar to the <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a> spell).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a>; <b>Cost</b> +9,000 gp</p>\n" +
            "</div></div></td>"),
    MARTYRING("Martyring", 18000, 4, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 9th; <b>Weight</b> —; <b>Price</b> +18,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor allows the wearer to capitalize on her own injuries to heal her allies. Once per day as an <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Immediate-Actions\">immediate action</a>, when an enemy confirms a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> against someone wearing martyring armor, the wearer can heal up to nine allies within 30 feet as if using the <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cure-light-wounds\" style=\"font-style:italic\">mass cure light wounds</a> spell (1d8+9 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a> each). This special ability cannot be placed on armor that possesses an ability that reduces the chance of or negates a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> (such as the <i>fortification</i> special ability).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/cure-light-wounds\" style=\"font-style:italic\">mass cure light wounds</a>; <b>Cost</b> +9,000 gp</p>\n" +
            "</div></div></td>"),
    SPELL_RESISTANCE_17("Spell Resistance (17)", 0, 4, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability grants the armor or shield's wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a> while the armor or shield is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a>; <b>Cost</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "</div></div></td>"),
    RIGHTEOUS("Righteous", 27000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +27,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor with this special ability is often engraved or enameled with religious symbols. Once per day on command, the wearer can invoke an effect, as per the spell <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>, lasting for 10 rounds. <i>Righteous</i> armor is always aligned toward good (positive energy), for the effects of <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>. <i>Righteous</i> armor bestows one permanent <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any evil creature attempting to wear it. The <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the armor is worn and disappears when it is removed. This <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including by <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the armor is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>; <b>Cost</b> +13,500 gp</p>\n" +
            "</div></div></td>"),
    UNBOUND("Unbound", 27000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +27,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor with this special ability is often engraved or enameled with chaotic religious symbols. Once per day on command, the wearer can invoke an effect as per the spell <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>, except the wearer gains <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a> 5/<a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Lawful\">lawful</a> instead of <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/evil or <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/good. This effect lasts for 10 rounds. Unbound armor bestows one permanent <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Lawful\">lawful</a> creature attempting to wear it. The <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the armor is worn and disappears when it is removed. This <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including by <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the armor is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>, creator must be <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Chaotic\">chaotic</a>; <b>Cost</b> +13,500 gp</p>\n" +
            "</div></div></td>"),
    UNRIGHTEOUS("Unrighteous", 27000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +27,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor is often sculpted with unholy symbols.</p><p>Once per day on command, the wearer can invoke an effect, as per the spell <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>, lasting for 10 rounds. <i>Unrighteous</i> armor is always aligned toward evil (negative energy), for the effects of <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>. <i>Unrighteous</i> armor bestows one permanent <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any good creature attempting to wear it. The <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the armor is worn and disappears when it is removed. This <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including by <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the armor is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>; <b>Cost</b> +13,500 gp</p>\n" +
            "</div></div></td>"),
    VIGILANT("Vigilant", 27000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +27,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor with this special ability is often engraved or enameled with lawful religious symbols.</p><p>Once per day on command, the wearer can invoke an effect, as per the spell <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>, except the wearer gains <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a> 5/<a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Chaotic\">chaotic</a> instead of <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/evil or <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a>/good. This lasts for 10 rounds. Vigilant armor bestows one permanent <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> on any <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Chaotic\">chaotic</a> creature attempting to wear it. The <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> remains as long as the armor is worn and disappears when it is removed. This <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Drain-and-Negative-Levels\">negative level</a> cannot be overcome in any way (including by <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/restoration\" style=\"font-style:italic\">restoration</a> spells) while the armor is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/righteous-might\" style=\"font-style:italic\">righteous might</a>, creator must be <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Lawful\">lawful</a>; <b>Cost</b> +13,500 gp</p>\n" +
            "</div></div></td>"),
    DETERMINATION("Determination", 30000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +30,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield or armor with the determination special ability provides the ability to fight on even in the face of seemingly impossible odds. Once per day, when the owner reaches 0 or fewer <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a>, the item automatically provides a <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/breath-of-life\" style=\"font-style:italic\">breath of life</a> spell.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/breath-of-life\" style=\"font-style:italic\">breath of life</a>; <b>Cost</b> +15,000 gp</p>\n" +
            "</div></div></td>"),
    SHADOW_GREATER("Shadow, greater", 33750, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Illusion\">illusion</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> +33,750 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-armor/magic-armor-and-shield-special-abilities/shadow\">shadow</a></i>, except it grants a +15 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/stealth\">Stealth</a> checks.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/i/invisibility\" style=\"font-style:italic\">invisibility</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/silence\" style=\"font-style:italic\">silence</a>; <b>Cost</b> +16,875 gp</p>\n" +
            "</div></div></td>"),
    SLICK_GREATER("Slick, greater", 33750, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> +33,750 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-armor/magic-armor-and-shield-special-abilities/slick\">slick</a></i>, except it grants a +15 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Competence-Bonus\">competence bonus</a> on <a href=\"http://www.d20pfsrd.com/skills/escape-artist\">Escape Artist</a> checks.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/g/grease\" style=\"font-style:italic\">grease</a>; <b>Cost</b> +16,875 gp</p>\n" +
            "</div></div></td>"),
    ENERGY_RESISTANCE_IMPROVED("Energy Resistance, improved", 42000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +42,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-armor/magic-armor-and-shield-special-abilities/energy-resistance\">energy resistance</a></i>, except it absorbs the first 20 points of energy damage per attack.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a>; <b>Cost</b> +21,000 gp</p>\n" +
            "</div></div></td>"),
    ETHEREALNESS("Etherealness", 49000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> +49,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>On command, this ability allows the wearer of the armor to become ethereal (as the <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/ethereal-jaunt\" style=\"font-style:italic\">ethereal jaunt</a> spell) once per day. The character can remain ethereal for as long as desired, but once he returns to normal, he cannot become ethereal again that day.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/ethereal-jaunt\" style=\"font-style:italic\">ethereal jaunt</a>; <b>Cost</b> +24,500 gp</p>\n" +
            "</div></div></td>"),
    UNDEAD_CONTROLLING("Undead Controlling", 49000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> +49,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">Undead</a> controlling armor and shields often have skeletal or other grisly decorations or flourishes to their decor. They let the user control up to 26 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Hit-Dice-HD-\">Hit Dice</a> of <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> per day, as the <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/control-undead\" style=\"font-style:italic\">control undead</a> spell. At dawn each day, the wearer loses control of any <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> still under his sway. Armor or a shield with this ability appears to be made of bone; this feature is entirely decorative and has no other effect on the armor.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/control-undead\" style=\"font-style:italic\">control undead</a>; <b>Cost</b> +24,500 gp</p>\n" +
            "</div></div></td>"),
    ENERGY_RESISTANCE_GREATER("Energy Resistance, greater", 66000, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 11th; <b>Weight</b> —; <b>Price</b> +66,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-armor/magic-armor-and-shield-special-abilities/energy-resistance\">energy resistance</a></i>, except it absorbs the first 30 points of energy damage per attack.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a>; <b>Cost</b> +33,000 gp</p>\n" +
            "</div></div></td>"),
    FORTIFICATION_HEAVY("Fortification (heavy)", 0, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor or shield produces a magical force that protects vital areas of the wearer more effectively. When a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is scored on the wearer, there is a chance that the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is negated and damage is instead rolled normally. The chance is 25% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">light fortification</a>, 50% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">moderate fortification</a>, and 75% for heavy fortification.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/limited-wish\" style=\"font-style:italic\">limited wish</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/miracle\" style=\"font-style:italic\">miracle</a>; <b>Cost</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "</div></div></td>"),
    SPELL_RESISTANCE_19("Spell Resistance (19)", 0, 5, new boolean[]{true,true,true}, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability grants the armor or shield's wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a> while the armor or shield is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a>; <b>Cost</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "</div></div></td>");


    private final String NAME;
    private final int PRICE_INCREASE;
    private final int ABILITY_COST;
    private final String DESCRIPTION;
    private final boolean[] ALLOWED_TYPES;

    public static final ArmorBonusEnum[][] bonusTiers = new ArmorBonusEnum[][]{
            {ENERGY_RESISTANCE, ENERGY_RESISTANCE_IMPROVED, ENERGY_RESISTANCE_GREATER},
            {SHADOW, SHADOW_IMPROVED, SHADOW_GREATER},
            {SLICK, SLICK_IMPROVED, SLICK_GREATER},
            {SPELL_RESISTANCE_13, SPELL_RESISTANCE_15, SPELL_RESISTANCE_17, SPELL_RESISTANCE_19},
            {FORTIFICATION_LIGHT, FORTIFICATION_MODERATE, FORTIFICATION_HEAVY}};

    public static final ArmorBonusEnum[][] cancelling = new ArmorBonusEnum[][]{
            {ADHESIVE, SLICK, SLICK_IMPROVED, SLICK_GREATER},
            {MARTYRING, FORTIFICATION_LIGHT, FORTIFICATION_MODERATE, FORTIFICATION_HEAVY}
    };

    ArmorBonusEnum(String name, int priceIncrease, int abilityCost, boolean[] allowedTypes, String description){
        this.NAME = name;
        this.PRICE_INCREASE = priceIncrease;
        this.ABILITY_COST = abilityCost;
        this.ALLOWED_TYPES = allowedTypes;
        this.DESCRIPTION = description;
    }

    public static void applyRandomBonuses(GenItem baseItem, int tier){
        if(!(baseItem.baseItem() instanceof ArmorEnum)) return;

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

    private static void getMinorBonuses(GenItem base, List<ArmorBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(ArmorBonusEnum bonus : currentBonuses) if(bonus.PRICE_INCREASE == 0) currentBonusValue += bonus.ABILITY_COST;

        if(percentage <= 80) giveEnhancement(1, base);
        else if(percentage <= 87) {
            if(currentBonusValue > 8)
                giveEnhancement(1, base);
            else
                giveEnhancement(2, base);
        }
        else if(percentage <= 91) {
            makeSpecific(ItemUtil.MINOR, base);
            currentBonuses.clear();
        }
        else {
            rollForSpecialAbility(base, currentBonuses, ItemUtil.MINOR);

            currentBonusValue = 0;
            for(ArmorBonusEnum bonus : currentBonuses) if(bonus.PRICE_INCREASE == 0) currentBonusValue += bonus.ABILITY_COST;

            if(currentBonusValue == 9){
                giveEnhancement(1, base);
                return;
            }

            getMinorBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void getMediumBonuses(GenItem base, List<ArmorBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(ArmorBonusEnum bonus : currentBonuses) if(bonus.PRICE_INCREASE == 0) currentBonusValue += bonus.ABILITY_COST;

        if(percentage <= 10) giveEnhancement(1, base);
        else if(percentage <= 30) {
            if(currentBonusValue > 8)
                giveEnhancement(1, base);
            else
                giveEnhancement(2, base);
        }
        else if(percentage <= 50)
            if(currentBonusValue > 7)
                getMediumBonuses(base, currentBonuses);
            else
                giveEnhancement(3, base);
        else if(percentage <= 57)
            if(currentBonusValue > 6)
                getMediumBonuses(base, currentBonuses);
            else
                giveEnhancement(4, base);
        else if(percentage <= 63) {
            makeSpecific(ItemUtil.MEDIUM, base);
            currentBonuses.clear();
        }
        else {
            rollForSpecialAbility(base, currentBonuses, ItemUtil.MEDIUM);

            currentBonusValue = 0;
            for(ArmorBonusEnum bonus : currentBonuses) if(bonus.PRICE_INCREASE == 0) currentBonusValue += bonus.ABILITY_COST;

            if(currentBonusValue == 9){
                giveEnhancement(1, base);
                return;
            }

            getMediumBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void getMajorBonuses(GenItem base, List<ArmorBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(ArmorBonusEnum bonus : currentBonuses) if(bonus.PRICE_INCREASE == 0) currentBonusValue += bonus.ABILITY_COST;

        if(percentage <= 16) giveEnhancement(3, base);
        else if(percentage <= 38) {
            if(currentBonusValue > 6)
                giveEnhancement(3, base);
            else
                giveEnhancement(4, base);
        }
        else if(percentage <= 57)
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
            for(ArmorBonusEnum bonus : currentBonuses) if(bonus.PRICE_INCREASE == 0) currentBonusValue += bonus.ABILITY_COST;

            if(currentBonusValue == 7){
                giveEnhancement(3, base);
                return;
            }

            getMajorBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void applySpecialAbilities(GenItem base, List<ArmorBonusEnum> currentBonuses){

        //First make it a Set to remove duplicates.
        ArrayList<ArmorBonusEnum> copy = new ArrayList<>(new HashSet<>(currentBonuses));

        //Now clean up the list the rest of the way by removing conflicting enchantments.
        for(int i = copy.size() - 1; i > -1; i++){

            boolean removedCurrent = false;

            ArmorBonusEnum current = copy.get(i);

            //Check for higher/lower tiered versions of the same enchantment
            for(int j = 0; j < bonusTiers.length; j++){
                for(int k = 0; k < bonusTiers[j].length; k++){

                    if(bonusTiers[j][k] == current){

                        for(ArmorBonusEnum toCheck : copy){

                            if(toCheck == current) continue;

                            for(int l = 0; l < bonusTiers[j].length; l++){

                                if(toCheck == bonusTiers[j][l]){

                                    if(l > k) {
                                        currentBonuses.remove(current);
                                        removedCurrent = true;
                                    }
                                    else currentBonuses.remove(toCheck);

                                }
                                if(removedCurrent) break;

                            }

                            if(removedCurrent) break;
                        }

                    }

                    if(removedCurrent) break;
                }
                if(removedCurrent) break;
            }

            //Check for conflicting enchantments
            for(int j = 0; j < cancelling.length; j++){
                for(int k = 0; k < cancelling[j].length; k++){

                    if(cancelling[j][k] == current){

                        for(ArmorBonusEnum toCheck : cancelling[j]){
                            if(toCheck == current) continue;
                            if(currentBonuses.contains(toCheck)){
                                currentBonuses.remove(current);
                                removedCurrent = true;
                                break;
                            }
                        }
                    }

                    if(removedCurrent) break;
                }
                if(removedCurrent) break;
            }

            if(removedCurrent) copy.remove(i);
        }

        //Now actually apply the enchantments
        //Enhancement bonus should already be applied.
        for(ArmorBonusEnum enchantment : currentBonuses){
            base.newName = base.getItemName() + ", " + enchantment.getNAME();
            base.newDescription = base.getFormattedDetails() + "\n\n" + enchantment.getDESCRIPTION();
        }

        int[] increasedCost = new int[]{0, 1000, 4000, 9000, 16000, 25000, 36000, 49000, 64000, 81000, 100000};
        int costIncrease = 150; //For masterwork

        int currentBonusValue = Integer.parseInt("" + base.getItemName().charAt(base.getItemName().indexOf("+") + 1));
        for(ArmorBonusEnum bonus : currentBonuses){
            if(bonus.PRICE_INCREASE == 0){
                currentBonusValue += bonus.ABILITY_COST;
            } else {
                costIncrease += bonus.PRICE_INCREASE;
            }
        }

        costIncrease += increasedCost[currentBonusValue];
        base.newCost = new int[]{base.cost()[0], base.cost()[1] + costIncrease, base.cost()[2], base.cost()[3]};
    }

    private static void makeSpecific(int tier, GenItem base){
        int percentage = rollPercent();

        if(tier == ItemUtil.MINOR){
            if(percentage <= 50) ItemUtil.duplicate(ItemUtil.getItem("Mithral Shirt"), base);
            else if(percentage <= 80) ItemUtil.duplicate(ItemUtil.getItem("Dragonhide plate"), base);
            else ItemUtil.duplicate(ItemUtil.getItem("Elven Chain"), base);
        }
        if(tier == ItemUtil.MEDIUM){
            if(percentage <= 25) ItemUtil.duplicate(ItemUtil.getItem("Mithral Shirt"), base);
            else if(percentage <= 45) ItemUtil.duplicate(ItemUtil.getItem("Dragonhide Plate"), base);
            else if(percentage <= 57) ItemUtil.duplicate(ItemUtil.getItem("Elven Chain"), base);
            else if(percentage <= 67) ItemUtil.duplicate(ItemUtil.getItem("Rhino Hide"), base);
            else if(percentage <= 82) ItemUtil.duplicate(ItemUtil.getItem("Adamantine breastplate"), base);
            else if(percentage <= 97) ItemUtil.duplicate(ItemUtil.getItem("Dwarven Plate"), base);
            else ItemUtil.duplicate(ItemUtil.getItem("Banded mail of luck"), base);
        }
        if(tier == ItemUtil.MAJOR){
            if(percentage <= 10) ItemUtil.duplicate(ItemUtil.getItem("Adamantine Breastplate"), base);
            else if(percentage <= 20) ItemUtil.duplicate(ItemUtil.getItem("Dwarven Plate"), base);
            else if(percentage <= 32) ItemUtil.duplicate(ItemUtil.getItem("Banded mail of luck"), base);
            else if(percentage <= 50) ItemUtil.duplicate(ItemUtil.getItem("Celestial Armor"), base);
            else if(percentage <= 60) ItemUtil.duplicate(ItemUtil.getItem("Plate Armor of the Deep"), base);
            else if(percentage <= 75) ItemUtil.duplicate(ItemUtil.getItem("Breastplate of Command"), base);
            else if(percentage <= 90) ItemUtil.duplicate(ItemUtil.getItem("Mithral full plate of speed"), base);
            else ItemUtil.duplicate(ItemUtil.getItem("Demon Armor"), base);
        }
    }

    private static void rollForSpecialAbility(GenItem item, List<ArmorBonusEnum> current, int tier){
        int percentage = rollPercent();

        int bonusValue = 0;
        for(ArmorBonusEnum bonus : current) bonusValue += bonus.ABILITY_COST;
        if(bonusValue > 8) return;

        if(tier == ItemUtil.MINOR){
            if(percentage <= 52) current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
            else if(percentage <= 96) {
                if(bonusValue > 7){
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    return;
                }
                current.add(getRandomBonusOfTier(2, (ArmorEnum)item.baseItem()));
            }
            else if(percentage <= 99){
                if(bonusValue > 6){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                current.add(getRandomBonusOfTier(3, (ArmorEnum)item.baseItem()));
            } else {
                if(bonusValue > 6){
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    if(bonusValue > 7) return;
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    return;
                }
                rollForSpecialAbility(item, current, tier);
                rollForSpecialAbility(item, current, tier);
            }
        } else if(tier == ItemUtil.MEDIUM){
            if(percentage <= 25) current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
            else if(percentage <= 57) {
                if(bonusValue > 7){
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    return;
                }
                current.add(getRandomBonusOfTier(2, (ArmorEnum)item.baseItem()));
            }
            else if(percentage <= 95){
                if(bonusValue > 6){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                current.add(getRandomBonusOfTier(3, (ArmorEnum)item.baseItem()));
            } else if(percentage <= 99){
                if(bonusValue > 5){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                current.add(getRandomBonusOfTier(4, (ArmorEnum)item.baseItem()));
            } else {
                if(bonusValue > 6){
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    if(bonusValue > 7) return;
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    return;
                }
                rollForSpecialAbility(item, current, tier);
                rollForSpecialAbility(item, current, tier);
            }
        } else if(tier == ItemUtil.MAJOR){
            if(bonusValue >= 7) return;
            if(percentage <= 10) current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
            else if(percentage <= 25) {
                if(bonusValue > 5){
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    return;
                }
                current.add(getRandomBonusOfTier(2, (ArmorEnum)item.baseItem()));
            }
            else if(percentage <= 56){
                if(bonusValue > 4){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                current.add(getRandomBonusOfTier(3, (ArmorEnum)item.baseItem()));
            } else if(percentage <= 86){
                if(bonusValue > 3){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                current.add(getRandomBonusOfTier(4, (ArmorEnum)item.baseItem()));
            } else if(percentage <= 99){
                if(bonusValue > 2){
                    rollForSpecialAbility(item, current, tier);
                    return;
                }
                current.add(getRandomBonusOfTier(5, (ArmorEnum)item.baseItem()));
            } else {
                if(bonusValue > 4){
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    if(bonusValue > 5) return;
                    current.add(getRandomBonusOfTier(1, (ArmorEnum)item.baseItem()));
                    return;
                }
                rollForSpecialAbility(item, current, tier);
                rollForSpecialAbility(item, current, tier);
            }
        }
    }

    private static ArmorBonusEnum getRandomBonusOfTier(int bonusValue, ArmorEnum base){
        ArrayList<ArmorBonusEnum> correctBonus = new ArrayList<>();
        correctBonus.addAll(Arrays.asList(values()).stream().filter(bonus -> bonus.ABILITY_COST == bonusValue).collect(Collectors.toList()));

        ArmorBonusEnum toTest = correctBonus.get((int)(Math.random() * correctBonus.size()));
        int armorType = -1;
        if(base.type().equalsIgnoreCase("light armor")) armorType = 0;
        if(base.type().equalsIgnoreCase("Medium Armor")) armorType = 1;
        if(base.type().equalsIgnoreCase("Heavy Armor")) armorType = 2;

        if(!toTest.ALLOWED_TYPES[armorType]) return getRandomBonusOfTier(bonusValue, base);
        return toTest;
    }

    private static int rollPercent(){
        return (int)(Math.random() * 100) + 1;
    }

    private static void giveEnhancement(int enhancement, GenItem base){
        base.newName = base.getItemName() + " +" + enhancement;
    }

    public int getCOST(){
        return PRICE_INCREASE;
    }

    public int bonusValue(){
        return ABILITY_COST;
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
