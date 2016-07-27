package src.classes;

import src.Character;
import src.Pathfinder;
import src.SelectionUtils;
import src.feats.Feat;
import src.feats.Feats;
import src.spells.Spell;
import src.spells.Spells;
import src.stats.AbilityScoreEnum;
import src.stats.Skill;
import src.stats.SkillEnum;
import src.stats.SkillUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Matthew on 6/29/2016.
 */
public class Magus extends SpellCaster implements Serializable{

    public Magus(Character me){
        super(me, "Magus");
        hitDiePerLevel = "d8";
        skillRanksMod = 2;
    }

    public int getArcanePool(){
        return (level < 2 ? 1 : level/2 + me.getAbilityMod(AbilityScoreEnum.INT)) + arcanePoolMod;
    }

    public void setArcanePool(int newValue){
        arcanePoolMod += newValue - getArcanePool();
    }

    public int[] getBAB(){
        int[][] bab = new int[][]{{0},{0},{1},{2},{3},{3},{4},{5},{6,1},{6,1},{7,2},{8,3},{9,4},{9,4},{10,5},{11,6,1},{12,7,2},{12,7,2},{13,8,3},{14,9,4},{15,10,5}};
        return bab[level];
    }

    public int getBaseFortSave(){
        return (level/2)+2;
    }

    public int getBaseRefSave(){
        return level/3;
    }

    public int getBaseWillSave(){
        return (level/2)+2;
    }

    public void levelUp(){
        super.levelUp();

        if(level%2 == 1){
            me.currentFeats.addAll(SelectionUtils.chooseFeatFromList(Feats.getAvailableFeats(me), "Choose a feat!", 1));
        }

        if(level == 1){
            me.miscAbilities.put("Arcane Pool (Su)", "At 1st level, the magus gains a reservoir of mystical arcane energy that he can draw upon to fuel his powers and enhance his weapon. This arcane pool has a number of points equal to 1/2 his magus level (minimum 1) + his Intelligence modifier. The pool refreshes once per day when the magus prepares his spells.<br>" +
                    "<br>" +
                    "At 1st level, a magus can expend 1 point from his arcane pool as a swift action to grant any weapon he is holding a +1 enhancement bonus for 1 minute. For every four levels beyond 1st, the weapon gains another +1 enhancement bonus, to a maximum of +5 at 17th level. These bonuses can be added to the weapon, stacking with existing weapon enhancement to a maximum of +5. Multiple uses of this ability do not stack with themselves.<br>" +
                    "<br>" +
                    "At 5th level, these bonuses can be used to add any of the following weapon properties: dancing, flaming, flaming burst, frost, icy burst, keen, shock, shocking burst, speed, or vorpal.<br>" +
                    "<br>" +
                    "Adding these properties consumes an amount of bonus equal to the property’s base price modifier. These properties are added to any the weapon already has, but duplicates do not stack. If the weapon is not magical, at least a +1 enhancement bonus must be added before any other properties can be added. These bonuses and properties are decided when the arcane pool point is spent and cannot be changed until the next time the magus uses this ability. These bonuses do not function if the weapon is wielded by anyone other than the magus.<br>" +
                    "<br>" +
                    "A magus can only enhance one weapon in this way at one time. If he uses this ability again, the first use immediately ends.");
            me.miscAbilities.put("Spell Combat (Ex)", "At 1st level, a magus learns to cast spells and wield his weapons at the same time. This functions much like two-weapon fighting, but the off-hand weapon is a spell that is being cast. To use this ability, the magus must have one hand free (even if the spell being cast does not have somatic components), while wielding a light or one-handed melee weapon in the other hand. As a full-round action, he can make all of his attacks with his melee weapon at a –2 penalty and can also cast any spell from the magus spell list with a casting time of 1 standard action (any attack roll made as part of this spell also takes this penalty). If he casts this spell defensively, he can decide to take an additional penalty on his attack rolls, up to his Intelligence bonus, and add the same amount as a circumstance bonus on his concentration check. If the check fails, the spell is wasted, but the attacks still take the penalty. A magus can choose to cast the spell first or make the weapon attacks first, but if he has more than one attack, he cannot cast the spell between weapon attacks.");

            Skill[] classSkills = new Skill[]{new Skill(me, SkillEnum.CLIMB),new Skill(me,SkillEnum.INTIMIDATE), new Skill(me,SkillEnum.FLY),
                    new Skill(me,SkillEnum.KNOWLEDGE, "Arcana"), new Skill(me,SkillEnum.KNOWLEDGE, "Dungeoneering"), new Skill(me,SkillEnum.KNOWLEDGE, "Planes"),
                    new Skill(me,SkillEnum.USE_MAGIC_DEVICE),new Skill(me,SkillEnum.RIDE),new Skill(me,SkillEnum.SPELLCRAFT),new Skill(me,SkillEnum.SWIM)};
            SkillUtils.applyClassSkills(classSkills, me);

            learnNewSpells(2 + me.getAbilityMod(AbilityScoreEnum.INT));
        } else{
            learnNewSpells(2);
        }
        if(level == 2){
            me.miscAbilities.put("Spellstrike", "At 2nd level, whenever a magus casts a spell with a range of “touch” from the magus spell list, he can deliver the spell through any weapon he is wielding as part of a melee attack. Instead of the free melee touch attack normally allowed to deliver the spell, a magus can make one free melee attack with his weapon (at his highest base attack bonus) as part of casting this spell. If successful, this melee attack deals its normal damage as well as the effects of the spell. If the magus makes this attack in concert with spell combat, this melee attack takes all the penalties accrued by spell combat melee attacks. This attack uses the weapon’s critical range (20, 19–20, or 18–20 and modified by the keen weapon property or similar effects), but the spell effect only deals ×2 damage on a successful critical hit, while the weapon damage uses its own critical modifier.");
        }

        if(level/3 > 0 && level%3 == 0)
            if(Pathfinder.askYesNo("Choose a magus arcana! Do you want me to pull up a list of magus arcana online?"))
                Pathfinder.showWebPage("http://www.d20pfsrd.com/classes/base-classes/magus/magus-arcana", "Magus Arcana");

        if(level%4 == 0){
            Pathfinder.popupDialog("Ability Score increases!","Choose two different ability scores and give both of them a +1!\n" +
                    "If the ability is Int, and your modifier goes up, add skill ranks to skills equal to your current level.\n" +
                    "If the ability is Con, and your modifier goes up, add your current level value to your total health.");
        }

        if(level == 4)me.miscAbilities.put("Spell Recall", "At 4th level, the magus learns to use his arcane pool to recall spells he has already cast. With a swift action he can recall any single magus spell that he has already prepared and cast that day by expending a number of points from his arcane pool equal to the spell’s level (minimum 1). The spell is prepared again, just as if it had not been cast.");

        if(level == 5 || (level - 5)%6 == 0){
            List<Feat> bonusFeats = Feats.getFeats().stream().filter(feat -> {
                return (feat.type.equalsIgnoreCase("Combat") || feat.type.equalsIgnoreCase("Item Creation") || feat.type.equalsIgnoreCase("metamagic"))
                && Feats.characterMeetsAllPrereqs(feat, me);
            }).collect(Collectors.toList());
            me.currentFeats.addAll(SelectionUtils.chooseFeatFromList(bonusFeats, "Choose a bonus feat!", 1));
        }

        if(level == 7){
            me.miscAbilities.put("Knowledge Pool", "At 7th level, when a magus prepares his magus spells, he can decide to expend 1 or more points from his arcane pool, up to his Intelligence bonus. For each point he expends, he can treat any one spell from the magus spell list as if it were in his spellbook and can prepare that spell as normal that day. If he does not cast spells prepared in this way before the next time he prepares spells, he loses those spells. He can also cast spells added in this way using his spell recall ability, but only until he prepares spells again.");
            me.miscAbilities.put("Medium Armor", "At 7th level, a magus gains proficiency with medium armor. A magus can cast magus spells while wearing medium armor without incurring the normal arcane spell failure chance. Like any other arcane spellcaster, a magus wearing heavy armor or using a shield incurs a chance of arcane spell failure if the spell in question has a somatic component.");
        }

        if(level == 8) me.miscAbilities.put("Improved Spell Combat", "At 8th level, the magus’s ability to cast spells and make melee attacks improves. When using the spell combat ability, the magus receives a +2 circumstance bonus on concentration checks, in addition to any bonus granted by taking an additional penalty on the attack roll.");
        if(level == 10) me.miscAbilities.put("Fighter Training", "Starting at 10th level, a magus counts 1/2 his total magus level as his fighter level for the purpose of qualifying for feats. If he has levels in fighter, these levels stack.");
        if(level == 1) me.miscAbilities.put("Improved Spell Recall (Su)", "At 11th level, the magus’s ability to recall spells using his arcane pool becomes more efficient. Whenever he recalls a spell with spell recall, he expends a number of points from his arcane pool equal to 1/2 the spell’s level (minimum 1). Furthermore, instead of recalling a used spell, as a swift action the magus can prepare a spell of the same level that he has in his spellbook. He does so by expending a number of points from his arcane pool equal to the spell’s level (minimum 1). The magus cannot apply metamagic feats to a spell prepared in this way. The magus does not need to reference his spellbook to prepare a spell in this way.");
        if(level == 13) me.miscAbilities.put("Heavy Armor", "At 13th level, a magus gains proficiency with heavy armor. A magus can cast magus spells while wearing heavy armor without incurring the normal arcane spell failure chance. Like any other arcane spellcaster, a magus using a shield incurs a chance of arcane spell failure if the spell in question has a somatic component.");
        if(level == 14)me.miscAbilities.put("Greater Spell Combat", "At 14th level, the magus gains the ability to seamlessly cast spells and make melee attacks. Whenever he uses the spell combat ability, his concentration check bonus equals double the amount of the attack penalty taken.");
        if(level == 16) me.miscAbilities.put("Counterstrike", "At 16th level, whenever an enemy within reach of the magus successfully casts a spell defensively, that enemy provokes an attack of opportunity from the magus after the spell is complete. This attack of opportunity cannot disrupt the spell.");

        if(level == 19){
            me.miscAbilities.put("Greater Spell Access (Su)", "At 19th level, the magus gains access to an expanded spell list. He learns and places 14 spells from the wizard’s spell list into his spellbook as magus spells of their wizard level. He gains two of each of the following wizard spells not on the magus spell list:<br>" +
                    "<br>" +
                    "0-level, 1st-level, 2nd-level, 3rd-level, 4th-level, 5th-level, and 6th-level.<br>" +
                    "<br>" +
                    "He can ignore the somatic component of these spells, casting them without the normal chance of spell failure.");
            List<Spell> bonusSpells = Spells.getSpells().stream().filter(spell -> Spells.spellLevelFor("Wizard", spell) > -1 && Spells.spellLevelFor("Magus", spell) > -1 && !knownSpells.contains(spell)).collect(Collectors.toList());
            knownSpells.addAll(SelectionUtils.chooseSpellFromList(bonusSpells,"Choose 14 Wizard/Magus spells to learn.", 14));
            for(int i = 0; i < 7; i++){
                Integer current = new Integer(i);
                bonusSpells = Spells.getSpells().stream().filter(spell -> Spells.spellLevelFor("Wizard", spell) == current && Spells.spellLevelFor("Magus", spell) == -1 && !knownSpells.contains(spell)).collect(Collectors.toList());
                knownSpells.addAll(SelectionUtils.chooseSpellFromList(bonusSpells,"Choose 2 level " + i + " spells from the wizard only list.", 2));
            }
        }

        if(level == 20){
            me.miscAbilities.put("True Magus", "At 20th level, the magus becomes a master of spells and combat. Whenever he uses his spell combat ability, he does not need to make a concentration check to cast the spell defensively. Whenever the magus uses spell combat and his spell targets the same creature as his melee attacks, he can choose to either increase the DC to resist the spell by +2, grant himself a +2 circumstance bonus on any checks made to overcome spell resistance, or grant himself a +2 circumstance bonus on all attack rolls made against the target during his turn.");
        }

    }

    public int[] getSpellsPerDay(){
        int[][] defaultSpellsPerDayByLevel = new int[][]{{0,0,0,0,0,0,0,0,0,0},{3,1,0,0,0,0,0,0,0,0},{4,2,0,0,0,0,0,0,0,0},{4,3,0,0,0,0,0,0,0,0},
                {4,3,1,0,0,0,0,0,0,0},{4,4,2,0,0,0,0,0,0,0},{5,4,3,0,0,0,0,0,0,0},{5,4,3,1,0,0,0,0,0,0},{5,4,4,2,0,0,0,0,0,0},
                {5,5,4,3,0,0,0,0,0,0},{5,5,4,3,1,0,0,0,0,0},{5,5,4,4,2,0,0,0,0,0},{5,5,5,4,3,0,0,0,0,0},{5,5,5,4,3,1,0,0,0,0},
                {5,5,5,4,4,2,0,0,0,0},{5,5,5,5,4,3,0,0,0,0},{5,5,5,5,4,3,1,0,0,0},{5,5,5,5,4,4,2,0,0,0},{5,5,5,5,5,4,3,0,0,0},
                {5,5,5,5,5,5,4,0,0,0},{5,5,5,5,5,5,5,0,0,0}};

        ArrayList<Integer> bonusSpells = new ArrayList<>();
        for(int i = 0; i < me.getAbilityMod(AbilityScoreEnum.INT); i++){
            bonusSpells.add(0, i/4 + 1);
        }
        bonusSpells.add(0,0);

        int[] toReturn = defaultSpellsPerDayByLevel[level < 20 ? level : 20];
        for(int i = 0; i < bonusSpells.size() && i < toReturn.length; i++){
            toReturn[i] += bonusSpells.get(i);
        }
        for(int i = 0; i < modifiedSpellsPerDay.length && i < toReturn.length; i++){
            toReturn[i] += modifiedSpellsPerDay[i];
        }

        return toReturn;
    }

    public void learnNewSpells(int amount){
        knownSpells.addAll(SelectionUtils.chooseSpellFromList(getAvailableSpells(), "Choose " + amount + " spells.", amount));
    }

    public List<Spell> getAvailableSpells(){
        int i;
        for(i = 0; i < getSpellsPerDay().length; i++){
            if(getSpellsPerDay()[i] == 0) break;
        }
        int tooHighLevel = i;

        return Spells.getSpells().stream().filter(spell ->{
            int level = Spells.spellLevelFor(name, spell);
            return level > -1 && level <= me.abilities.get(AbilityScoreEnum.INT) - 10 && level < tooHighLevel;
            }).collect(Collectors.toList());
    }
}