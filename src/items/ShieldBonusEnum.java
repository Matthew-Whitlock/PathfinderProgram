package src.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Matthew on 12/16/2016.
 */
enum ShieldBonusEnum {

    POISON_RESISTANT("Poison-resistant", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +2,250 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A suit of armor or shield with this special ability grants the wearer a +3 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Resistance-Bonus\">resistance bonus</a> on saving throws against <a href=\"http://www.d20pfsrd.com/gamemastering/afflictions/poison\">poison</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/n/neutralize-poison\" style=\"font-style:italic\">neutralize poison</a>; <b>Cost</b> +1,125 gp</p>\n" +
            "</div></div></td>"),
    ARROW_CATCHING("Arrow Catching", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 8th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield with this ability attracts ranged weapon attacks to it. It has a <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Deflection-Bonus\">deflection bonus</a> of +1 against ranged weapons because projectiles and thrown weapons veer toward it. Additionally, any projectile or thrown weapon aimed at a target within 5 feet of the shield's wearer diverts from its original target and targets the shield's bearer instead. If the wielder has total <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Cover\">cover</a> relative to the attacker, the projectile or thrown weapon is not diverted. Additionally, those attacking the wearer with ranged weapons ignore any miss chances that would normally apply. Projectiles and thrown weapons that have an <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> higher than the shield's base AC bonus are not diverted to the wearer (but the shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Deflection-Bonus\">deflection bonus</a> still applies against these weapons). The wielder can <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Activate-Magic-Item\">activate</a> or deactivate this ability with a command word.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/entropic-shield\" style=\"font-style:italic\">entropic shield</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    BASHING("Bashing", 2250, 0, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 8th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield with this special ability is designed to perform a shield bash. A bashing shield deals damage as if it were a bashing weapon of two size categories larger (a Medium light shield thus deals 1d6 points of damage and a Medium heavy shield deals 1d8 points of damage). The shield acts as a +1 weapon when used to bash. Only light and heavy shields can have this ability.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bull-s-strength\" style=\"font-style:italic\">bull's strength</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    BLINDING("Blinding", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield with this ability flashes with a brilliant light up to twice per day upon command of the wielder. Except for the wielder, anyone within 20 feet must make a successful DC 14 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reflex\">Reflex</a> save or be <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Blinded\">blinded</a> for 1d4 rounds.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/searing-light\" style=\"font-style:italic\">searing light</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    CLANGOROUS("Clangorous", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield with this ability rings loudly when struck in combat. As an <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Immediate-Actions\">immediate action</a> when the wearer is hit by an attack, the wearer can <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Activate-Magic-Item\">activate</a> the shield to create a deafening bang equivalent to a <a href=\"http://www.d20pfsrd.com/equipment---final/goods-and-services#TOC-Thunderstone\">thunderstone</a>. If the attack is a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a>, the wearer can instead create a <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/sound-burst\" style=\"font-style:italic\">sound burst</a> (<a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Fortitude\">Fortitude</a> DC 13 partial). The wearer decides the area for either effect, but must include the attacker in the area. Neither ability affects the wearer.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, blindness/deafness, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/sound-burst\" style=\"font-style:italic\">sound burst</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    DEFIANT("Defiant", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 8th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor and shields with this special ability excel at blocking the attacks of certain types of creatures, similar to a <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bane\" style=\"font-style:italic\">bane</a> weapon's excelling against certain foes. Against the designated foe, the item's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to AC is +2 better than its actual bonus and provides <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Damage-Reduction-Ex-or-Su-\">DR</a> 2/— against attacks from that foe. This increase in <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> applies only to the armor or shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>, not to temporary bonuses (such as the <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/magic-vestment\" style=\"font-style:italic\">magic vestment</a> spell). To randomly determine the armor or shield's designated foe, use the table for the <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/bane\" style=\"font-style:italic\">bane</a> weapon special ability (page 136).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/summon-monster\" style=\"font-style:italic\">summon monster I</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    FORTIFICATION_LIGHT("Fortification (light)", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor or shield produces a magical force that protects vital areas of the wearer more effectively. When a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is scored on the wearer, there is a chance that the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is negated and damage is instead rolled normally. The chance is 25% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">light fortification</a>, 50% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">moderate fortification</a>, and 75% for heavy fortification.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/limited-wish\" style=\"font-style:italic\">limited wish</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/miracle\" style=\"font-style:italic\">miracle</a>; <b>Cost</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "</div></div></td>"),
    GRINDING("Grinding", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield or suit of armor with this special ability is covered with jagged burrs and razor-sharp serrations that saw and grind whenever the wearer is <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Grappled\">grappled</a> or <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Entangled\">entangled</a>. Any creature succeeding at a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Grapple\">grapple</a> <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> check against the wearer takes damage equal to the armor or shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> (with each successful check) as the barbs and blades bite into it. This special ability counts as armor spikes for the purpose of making attacks on the wearer's turn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/k/keen-edge\" style=\"font-style:italic\">keen edge</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    IMPERVIOUS("Impervious", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield or suit of armor with this special ability is especially hardy. It gains double its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to <a href=\"http://www.d20pfsrd.com/equipment---final/damaging-objects#TOC-Hardness\">hardness</a> and <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a> (instead of just the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>), its break DC increases by double its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>, and it gains a bonus on saving throws against direct attacks (such as a <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/aberrations/rust-monster\">rust monster's</a> rust ability) equal to its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/fabricate\" style=\"font-style:italic\">fabricate</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/make-whole\" style=\"font-style:italic\">make whole</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    MIRRORED("Mirrored", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 8th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>The polished surface of a mirrored shield or armor gleams and shines, and can be used as an ordinary mirror. Furthermore, it aids in battling creatures with <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Gaze-Su-\">gaze</a> attacks. If the wearer averts his eyes, he can roll the miss chance twice, selecting the better result. The wearer can deal <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> or other precision-based damage to the target even though it has <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Concealment\">concealment</a> against him. This provides no benefit if the wearer closes his eyes, wears a blindfold, or otherwise can't see the target at all. The mirrored armor or shield also adds it <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to the wearer's <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Touch-Attacks\">touch</a> AC against rays. it. This special ability may only be added to metallic armor or shields.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/spell-turning\" style=\"font-style:italic\">spell turning</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    RAMMING("Ramming", 2250, 0, false, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +1 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>These shields are sturdily built and often bear the device of a <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/animals/herd-animals/ram\">ram</a> or bull. When the wielder of a ramming shield makes a shield bash attack as part of a charge, the shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Armor-Class\">Armor Class</a> applies to the attack and damage rolls. This doesn't stack with any existing enhancement the shield has. If the attack hits, as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Swift-Actions\">swift action</a> the wielder can attempt a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Bull-Rush\">bull rush</a> <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> against that target, adding the +2 bonus for charging and the shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> to the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Combat-Maneuvers\">combat maneuver</a> check. Only shields that can make a shield bash attack can have the ramming ability.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/f/force-punch\" style=\"font-style:italic\">force punch</a>; <b>Cost</b> +1 bonus</p>\n" +
            "</div></div></td>"),
    RALLYING("Rallying", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +5,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor or shield is brightly polished, and its mirror-bright surface is magically endowed with the ability to bring comfort to the wearer's companions. Allies within 30 feet of the wearer gain a +4 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> on saving throws against fear effects. If the wearer has an ability that grants a <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> on saving throws against fear (such as a <a href=\"http://www.d20pfsrd.com/classes/core-classes/paladin\">paladin's</a> aura of courage, a <a href=\"http://www.d20pfsrd.com/classes/core-classes/bard\">bard's</a> <a href=\"http://www.d20pfsrd.com/classes/core-classes/bard#TOC-Countersong-Su-\">countersong</a>, or a <a href=\"http://www.d20pfsrd.com/classes/base-classes/cavalier\">cavalier's</a> banner ability), the <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Morale-Bonus\">morale bonus</a> increases to +6.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/remove-fear\" style=\"font-style:italic\">remove fear</a>; <b>Cost</b> +2,500 gp</p>\n" +
            "</div></div></td>"),
    WYRMSBREATH("Wyrmsbreath", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> 5,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield with this special ability is usually crafted with an open <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Dragon\">dragon's</a> mouth on the front. A shield with the wyrmsbreath special ability is keyed to one type of energy (acid, cold, electricity, or fire). The shield gains 1 charge for every 5 points of damage from the keyed energy type the wearer takes. On command, the bearer can expend 1 to 5 charges from the shield to have it create a <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Breath-Weapon-Su-\">breath weapon</a> in a 15 foot cone dealing 1d4 points of energy damage per charge expended (<a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reflex\">Reflex</a> DC 11 half). This damage is the same type as the shield's keyed energy type. A shield can store up to 5 charges at a time, and stored charges expire harmlessly after 24 hours. A shield cannot have more than one wyrmsbreath ability.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/burning-hands\" style=\"font-style:italic\">burning hands</a>; <b>Cost</b> +2,500 gp</p>\n" +
            "</div></div></td>"),
    ANIMATED("Animated", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 12th; <b>Weight</b> —; <b>Price</b> +2 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Move-Actions\">move action</a>, an animated shield can be loosed to defend its wielder on its own. For the following 4 rounds, the shield grants its bonus to the one who loosed it and then drops. While animated, the shield provides its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Shield-Bonus\">shield bonus</a> and the bonuses from all of the other shield special abilities it possesses, but it cannot take actions on its own, such as those provided by the bashing and blinding abilities. It can, however, use special abilities that do not require an action to function, such as arrow deflection and reflecting. While animated, a shield shares the same space as the activating character and accompanies the character who activated it, even if the character moves by magical means. A character with an animated shield still takes any penalties associated with shield use, such as armor check penalty, arcane spell failure chance, and nonproficiency. If the wielder who loosed it has an unoccupied hand, she can grasp it to end its animation as a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Free-Actions\">free action</a>. Once a shield has been retrieved, it cannot be animated again for at least 4 rounds. This special ability cannot be added to a tower shield.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/a/animate-objects\" style=\"font-style:italic\">animate objects</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    ARROW_DEFLECTION("Arrow Deflection", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 5th; <b>Weight</b> —; <b>Price</b> +2 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This shield protects the wielder as if he had the <a href=\"http://www.d20pfsrd.com/feats/combat-feats/deflect-arrows-combat\">Deflect Arrows</a> feat. Once per round when he would normally be struck by a ranged weapon, he can make a DC 20 <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Reflex\">Reflex</a> save. If the ranged weapon (or piece of ammunition) has an <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>, the DC increases by that amount. If he succeeds, the shield deflects the weapon. He must be aware of the attack and not <a href=\"http://www.d20pfsrd.com/gamemastering/conditions#TOC-Flat-Footed\">flat-footed</a>. Attempting to deflect a ranged weapon doesn't count as an action. Exceptional ranged weapons, such as boulders hurled by <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/humanoids/giants\">giants</a> or acid arrows, can't be deflected.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/shield\" style=\"font-style:italic\">shield</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    MERGING("Merging", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +2 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A merging shield can meld with a held one-handed or light weapon. The wearer chooses each round whether to attack with the weapon or defend with the shield. Melding or freeing the shield requires a command word. The shield must be worn to merge it with a weapon; reversing the melding means the shield is being worn again. While the shield is melded, the wearer can use that hand only to attack with the weapon or defend with the shield (and not to cast spells or manipulate objects, for example). Attack rolls with the weapon take a –2 penalty while merged with a light shield or a –4 penalty while merged with a heavy shield. If the wearer attacks with the merged weapon, she loses the shield's bonus to AC until the start of her next turn. A merged shield can't be used to shield bash. Only light and heavy shields can be merging shields.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/v/versatile-weapon\" style=\"font-style:italic\">versatile weapon</a>; <b>Cost</b> +2 bonus</p>\n" +
            "</div></div></td>"),
    SPELL_RESISTANCE_13("Spell Resistance (13)", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability grants the armor or shield's wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a> while the armor or shield is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a>; <b>Cost</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "</div></div></td>"),
    HOSTELING("Hosteling", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 9th; <b>Weight</b> —; <b>Price</b> +7,500 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A suit of armor or shield with this special ability hides living <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animals</a> within its iconography to keep it safe. The wearer can speak a command word to magically store an <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> to which he is bonded, such as an <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid/animal-companions\">animal companion</a>, a <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard#TOC-Arcane-Bond-Ex-or-Sp-\">familiar</a>, or mount. The stored <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> appears as a symbol emblazoned upon the armor or shield, either one that <a href=\"http://www.d20pfsrd.com/bestiary/monster-listings/aberrations/mimic\">mimics</a> the appearance of the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> or that is more symbolic and abstract.</p>\n" +
            "<p>While stored, the <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> is sleeping and provides the wearer no benefit (such as a <a href=\"http://www.d20pfsrd.com/classes/core-classes/wizard#TOC-Arcane-Bond-Ex-or-Sp-\">familiar's</a> skill bonus). The size of <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> that can be stored depends on the type of armor or shield. A suit of light armor, medium armor, or a light shield or heavy shield can store one <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> up to the wearer's size. A suit of heavy armor or a tower shield can store one <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> up to one size category larger than the wearer. A second command word releases the stored <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> from the hosteling armor or shield. A released <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> immediately awakens, appears in a space adjacent to the wearer, and can take actions on the round it appears.</p>\n" +
            "<p>Because the stored <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> is sleeping rather than in suspended animation (or even hibernating), it ages and gets hungry at the normal rate while stored. A hosteling armor or shield automatically releases a stored <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> 24 hours after it was stored inside.</p>\n" +
            "<p>This armor special ability still works on bonded <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Magical-Beast\">magical beasts</a> that were once <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animals</a>, but not <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Outsider\">outsiders</a>, <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Ooze\">oozes</a>, or other exotic companion creatures.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/secret-chest\" style=\"font-style:italic\">secret chest</a>; <b>Cost</b> 3,750 gp</p>\n" +
            "</div></div></td>"),
    RADIANT("Radiant", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Evocation\">evocation</a>; <b>CL</b> 6th; <b>Weight</b> —; <b>Price</b> +7,500 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor and shields with the radiant special ability shine as brightly as a torch when worn. This radiance can be suppressed or resumed on command. Designs usually feature bright colors and a brilliant sheen even when not illuminated. Once per day, the wearer can command the armor or shield to brighten to the strength of a <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/daylight\" style=\"font-style:italic\">daylight</a> spell for 1 hour or until commanded to dim.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/d/daylight\" style=\"font-style:italic\">daylight</a>; <b>Cost</b> +3,750 gp</p>\n" +
            "</div></div></td>"),
    FORTIFICATION_MODERATE("Fortification (moderate)", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor or shield produces a magical force that protects vital areas of the wearer more effectively. When a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is scored on the wearer, there is a chance that the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is negated and damage is instead rolled normally. The chance is 25% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">light fortification</a>, 50% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">moderate fortification</a>, and 75% for heavy fortification.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/limited-wish\" style=\"font-style:italic\">limited wish</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/miracle\" style=\"font-style:italic\">miracle</a>; <b>Cost</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "</div></div></td>"),
    GHOST_TOUCH("Ghost Touch", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> +3 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This armor or shield seems almost translucent. Both its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> and its <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Armor-Bonus\">armor bonus</a> count against the attacks of corporeal and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creatures. It can be picked up, moved, and worn by corporeal and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> creatures alike. <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Incorporeal-Ex-\">Incorporeal</a> creatures gain the armor's or shield's <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a> against both corporeal and <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Incorporeal\">incorporeal</a> attacks, and they can still pass freely through solid objects.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/e/etherealness\" style=\"font-style:italic\">etherealness</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    SPELL_RESISTANCE_15("Spell Resistance 15", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability grants the armor or shield's wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a> while the armor or shield is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a>; <b>Cost</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "</div></div></td>"),
    WILD("Wild", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Transmutation\">transmutation</a>; <b>CL</b> 9th; <b>Weight</b> —; <b>Price</b> +3 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>Armor with this special ability usually appears to be made from magically hardened <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Animal\">animal</a> pelt. The wearer of a suit of armor or a shield with this ability preserves his <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Armor-Bonus\">armor bonus</a> (and any <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Enhancement-Bonus\">enhancement bonus</a>) while in a <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid#TOC-Wild-Shape-Su-\">wild shape</a>. Armor and shields with this ability usually appear to be covered in leaf patterns. While the wearer is in a <a href=\"http://www.d20pfsrd.com/classes/core-classes/druid#TOC-Wild-Shape-Su-\">wild shape</a>, the armor cannot be seen.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/baleful-polymorph\" style=\"font-style:italic\">baleful polymorph</a>; <b>Cost</b> +3 bonus</p>\n" +
            "</div></div></td>"),
    ENERGY_RESISTANCE("Energy Resistance", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> faint <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 3rd; <b>Weight</b> —; <b>Price</b> +18,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A suit of armor or a shield with this special ability protects against one type of energy (acid, cold, electricity, fire, or sonic) and is designed with patterns depicting the element it protects against. The armor absorbs the first 10 points of energy damage per attack that the wearer would normally take (similar to the <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a> spell).</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a>; <b>Cost</b> +9,000 gp</p>\n" +
            "</div></div></td>"),
    SPELL_RESISTANCE_17("Spell Resistance (17)", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability grants the armor or shield's wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a> while the armor or shield is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a>; <b>Cost</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "</div></div></td>"),
    DETERMINATION("Determination", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Conjuration\">conjuration</a>; <b>CL</b> 10th; <b>Weight</b> —; <b>Price</b> +30,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>A shield or armor with the determination special ability provides the ability to fight on even in the face of seemingly impossible odds. Once per day, when the owner reaches 0 or fewer <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Hit-Points\">hit points</a>, the item automatically provides a <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/breath-of-life\" style=\"font-style:italic\">breath of life</a> spell.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/b/breath-of-life\" style=\"font-style:italic\">breath of life</a>; <b>Cost</b> +15,000 gp</p>\n" +
            "</div></div></td>"),
    ENERGY_RESISTANCE_IMPROVED("Energy Resistance Improved", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 7th; <b>Weight</b> —; <b>Price</b> +42,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-armor/magic-armor-and-shield-special-abilities/energy-resistance\">energy resistance</a></i>, except it absorbs the first 20 points of energy damage per attack.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a>; <b>Cost</b> +21,000 gp</p>\n" +
            "</div></div></td>"),
    UNDEAD_CONTROLLING("Undead Controlling", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Necromancy\">necromancy</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> +49,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">Undead</a> controlling armor and shields often have skeletal or other grisly decorations or flourishes to their decor. They let the user control up to 26 <a href=\"http://www.d20pfsrd.com/basics-ability-scores/glossary#TOC-Hit-Dice-HD-\">Hit Dice</a> of <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> per day, as the <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/control-undead\" style=\"font-style:italic\">control undead</a> spell. At dawn each day, the wearer loses control of any <a href=\"http://www.d20pfsrd.com/bestiary/rules-for-monsters/creature-types#TOC-Undead\">undead</a> still under his sway. Armor or a shield with this ability appears to be made of bone; this feature is entirely decorative and has no other effect on the armor.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/c/control-undead\" style=\"font-style:italic\">control undead</a>; <b>Cost</b> +24,500 gp</p>\n" +
            "</div></div></td>"),
    ENERGY_RESISTANCE_GREATER("Energy Resistance Greater", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> moderate <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 11th; <b>Weight</b> —; <b>Price</b> +66,000 gp</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>As <i><a href=\"http://www.d20pfsrd.com/magic-items/magic-armor/magic-armor-and-shield-special-abilities/energy-resistance\">energy resistance</a></i>, except it absorbs the first 30 points of energy damage per attack.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/r/resist-energy\" style=\"font-style:italic\">resist energy</a>; <b>Cost</b> +33,000 gp</p>\n" +
            "</div></div></td>"),
    FORTIFICATION_HEAVY("Fortification (heavy)", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 13th; <b>Weight</b> —; <b>Price</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This suit of armor or shield produces a magical force that protects vital areas of the wearer more effectively. When a <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is scored on the wearer, there is a chance that the <a href=\"http://www.d20pfsrd.com/gamemastering/combat#TOC-Critical-Hits\">critical hit</a> or <a href=\"http://www.d20pfsrd.com/classes/core-classes/rogue#TOC-Sneak-Attack\">sneak attack</a> is negated and damage is instead rolled normally. The chance is 25% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">light fortification</a>, 50% for <a href=\"http://www.d20pfsrd.com/magic-items/magic-armor#TOC-Fortification\" style=\"font-style:italic\">moderate fortification</a>, and 75% for heavy fortification.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/l/limited-wish\" style=\"font-style:italic\">limited wish</a> or <a href=\"http://www.d20pfsrd.com/magic/all-spells/m/miracle\" style=\"font-style:italic\">miracle</a>; <b>Cost</b> varies, <i>Light</i> +1 bonus, <i>Moderate</i> +3 bonus, <i>Heavy</i> +5 bonus</p>\n" +
            "</div></div></td>"),
    REFLECTING("Reflecting", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 14th; <b>Weight</b> —; <b>Price</b> +5 Bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This shield is as highly polished as a mirror, and its surface is completely reflective. Once per day, it can be called on to reflect a spell back at its caster exactly like the <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/spell-turning\" style=\"font-style:italic\">spell turning</a> spell.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/magic/all-spells/s/spell-turning\" style=\"font-style:italic\">spell turning</a>; <b>Cost</b> +5 bonus</p>\n" +
            "</div></div></td>"),
    SPELL_RESISTANCE_19("Spell Resistance (19)", 2250, 0, true, "<td class=\"sites-layout-tile sites-tile-name-content-1\"><div dir=\"ltr\"><div style=\"font-size:16px\">\n" +
            "<p><b>Aura</b> strong <a href=\"http://www.d20pfsrd.com/magic#TOC-Abjuration\">abjuration</a>; <b>CL</b> 15th; <b>Weight</b> —; <b>Price</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-DESCRIPTION\"></a>DESCRIPTION</h4>\n" +
            "<p>This special ability grants the armor or shield's wearer <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a> while the armor or shield is worn.</p>\n" +
            "<h4 style=\"border-top:1px solid;border-bottom:1px solid\"><a name=\"TOC-CONSTRUCTION-REQUIREMENTS\"></a>CONSTRUCTION REQUIREMENTS</h4>\n" +
            "<p><a href=\"http://www.d20pfsrd.com/feats/item-creation-feats/craft-magic-arms-and-armor-item-creation---final\">Craft Magic Arms and Armor</a>, <a href=\"http://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Spell-Resistance\">spell resistance</a>; <b>Cost</b> varies; Spell resistance 13 +2 bonus, Spell resistance 15 +3 bonus, Spell resistance 17 +4 bonus, Spell resistance 19 +5 bonus</p>\n" +
            "</div></div></td>");


    private final String NAME;
    private final int PRICE;
    private final int ABILITY_COST;
    private final boolean TOWER_CAN_USE;
    private final String DESC;

    public static final ShieldBonusEnum[][] bonusTiers = new ShieldBonusEnum[][]{
            {ENERGY_RESISTANCE, ENERGY_RESISTANCE_IMPROVED, ENERGY_RESISTANCE_GREATER},
            {SPELL_RESISTANCE_13, SPELL_RESISTANCE_15, SPELL_RESISTANCE_17, SPELL_RESISTANCE_19},
            {FORTIFICATION_LIGHT, FORTIFICATION_MODERATE, FORTIFICATION_HEAVY}};


    ShieldBonusEnum(String bonusName, int price, int abilityCost, boolean towerCanUse, String desc){
        NAME = bonusName;
        this.PRICE = price;
        this.ABILITY_COST = abilityCost;
        this.TOWER_CAN_USE = towerCanUse;
        this.DESC = desc;
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

    private static void getMinorBonuses(GenItem base, List<ShieldBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(ShieldBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.ABILITY_COST;
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
            for(ShieldBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.ABILITY_COST;
            if(currentBonusValue == 9){
                giveEnhancement(1, base);
                return;
            }

            getMinorBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void getMediumBonuses(GenItem base, List<ShieldBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(ShieldBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.ABILITY_COST;
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
            for(ShieldBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.ABILITY_COST;
            if(currentBonusValue == 9){
                giveEnhancement(1, base);
                return;
            }

            getMediumBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void getMajorBonuses(GenItem base, List<ShieldBonusEnum> currentBonuses){
        int percentage = rollPercent();

        boolean baseLevel = currentBonuses.size() == 0;

        int currentBonusValue = 0;
        for(ShieldBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.ABILITY_COST;
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
            for(ShieldBonusEnum bonus : currentBonuses) if(bonus.PRICE == 0) currentBonusValue += bonus.ABILITY_COST;
            if(currentBonusValue == 7){
                giveEnhancement(3, base);
                return;
            }

            getMajorBonuses(base, currentBonuses);
        }

        if(baseLevel) applySpecialAbilities(base,currentBonuses);
    }

    private static void applySpecialAbilities(GenItem base, List<ShieldBonusEnum> currentBonuses){

        //First make it a Set to remove duplicates.
        ArrayList<ShieldBonusEnum> copy = new ArrayList<>(new HashSet<>(currentBonuses));

        //Now clean up the list the rest of the way by removing conflicting enchantments.
        for(int i = copy.size() - 1; i > -1; i++){
            boolean removedCurrent = false;
            ShieldBonusEnum current = copy.get(i);

            //Check for higher/lower tiered versions of the same enchantment
            for(int j = 0; j < bonusTiers.length; j++){
                for(int k = 0; k < bonusTiers[j].length; k++){

                    if(bonusTiers[j][k] == current){

                        for(ShieldBonusEnum toCheck : copy){

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

            if(removedCurrent) copy.remove(i);
        }

        //Now actually apply the enchantments
        //Enhancement bonus should already be applied.
        for(ShieldBonusEnum enchantment : currentBonuses){
            base.newName = base.getItemName() + ", " + enchantment.getNAME();
            base.newDescription = base.getFormattedDetails() + "\n\n" + enchantment.getDESCRIPTION();
        }

        int[] increasedCost = new int[]{0, 1000, 4000, 9000, 16000, 25000, 36000, 49000, 64000, 81000, 100000};
        int costIncrease = 150; //For masterwork

        int currentBonusValue = Integer.parseInt("" + base.getItemName().charAt(base.getItemName().indexOf("+") + 1));
        for(ShieldBonusEnum bonus : currentBonuses){
            if(bonus.PRICE == 0){
                currentBonusValue += bonus.ABILITY_COST;
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
            if(percentage <= 30) ItemUtil.duplicate(ItemUtil.getItem("Darkwood buckler"), base);
           else if(percentage <= 80) ItemUtil.duplicate(ItemUtil.getItem("Darkwood Shield"), base);
            else if(percentage <= 95) ItemUtil.duplicate(ItemUtil.getItem("Mithral Heavy Shield"), base);
            else ItemUtil.duplicate(ItemUtil.getItem("Caster's Shield"), base);
        }
        if(tier == ItemUtil.MEDIUM){
            if(percentage <= 20) ItemUtil.duplicate(ItemUtil.getItem("Darkwood Buckler"), base);
            else if(percentage <= 45) ItemUtil.duplicate(ItemUtil.getItem("Darkwood Shield"), base);
            else if(percentage <= 70) ItemUtil.duplicate(ItemUtil.getItem("Mithral Heavy Shield"), base);
            else if(percentage <= 85) ItemUtil.duplicate(ItemUtil.getItem("Caster's Shield"), base);
            else if(percentage <= 90) ItemUtil.duplicate(ItemUtil.getItem("Spined Shield"), base);
            else if(percentage <= 95) ItemUtil.duplicate(ItemUtil.getItem("Lion's Shield"), base);
            else ItemUtil.duplicate(ItemUtil.getItem("Winged Shield"), base);
        }
        if(tier == ItemUtil.MAJOR){
            if(percentage <= 20) ItemUtil.duplicate(ItemUtil.getItem("Caster's Shield"), base);
            else if(percentage <= 40) ItemUtil.duplicate(ItemUtil.getItem("Spined Shield"), base);
            else if(percentage <= 60) ItemUtil.duplicate(ItemUtil.getItem("Lion's Shield"), base);
            else if(percentage <= 90) ItemUtil.duplicate(ItemUtil.getItem("Winged Shield"), base);
            else ItemUtil.duplicate(ItemUtil.getItem("Absorbing Shield"), base);
        }
    }

    private static void rollForSpecialAbility(GenItem item, List<ShieldBonusEnum> current, int tier){
        int percentage = rollPercent();

        int bonusValue = 0;
        for(ShieldBonusEnum bonus : current) bonusValue += bonus.ABILITY_COST;
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

    private static ShieldBonusEnum getRandomBonusOfTier(int bonusValue, ArmorEnum base){
        ArrayList<ShieldBonusEnum> correctBonus = new ArrayList<>();
        correctBonus.addAll(Arrays.asList(values()).stream().filter(bonus -> bonus.ABILITY_COST == bonusValue).collect(Collectors.toList()));

        ShieldBonusEnum toTest = correctBonus.get((int)(Math.random() * correctBonus.size()));

        if(!toTest.TOWER_CAN_USE && base.getItemName().toLowerCase().contains("tower")) return getRandomBonusOfTier(bonusValue, base);
        return toTest;
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
        return ABILITY_COST;
    }

    public String getDESCRIPTION(){
        String desc = "<h3 xmlns=\"http://www.w3.org/1999/xhtml\" id=\"sites-page-title-header\" style=\"\" align=\"left\">\n" +
                "<span id=\"sites-page-title\" dir=\"ltr\" tabindex=\"-1\" style=\"outline: none\">" + NAME + " </span>\n" +
                "</h3>";
        desc += DESC;
        return desc;
    }

    public String getNAME(){
        return NAME;
    }

}
