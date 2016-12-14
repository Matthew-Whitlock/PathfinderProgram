package src.classes;

import java.io.Serializable;

import src.Character;
import src.Pathfinder;
import src.gui.SelectionUtils;
import src.feats.Feats;
import src.stats.Skill;
import src.stats.SkillEnum;
import src.stats.SkillUtils;

/**
 * Created by Matthew on 6/30/2016.
 */
public class UnchainedRogue extends CharacterClass implements Serializable{

    public UnchainedRogue(Character me){
        super(me, "Unchained Rogue");
        hitDiePerLevel = "d8";
        skillRanksMod = 8;
    }

    public void levelUp(){
        super.levelUp();

        if(level%2 == 1){
            me.currentFeats.addAll(SelectionUtils.searchFeats(Feats.getAvailableFeats(me), "Choose a feat!", 1, Pathfinder.FRAME));
        }

        if(level == 1){
            Skill[] classSkills = new Skill[]{new Skill(me, SkillEnum.ACROBATICS),new Skill(me, SkillEnum.APPRAISE),new Skill(me, SkillEnum.BLUFF),new Skill(me, SkillEnum.CLIMB),
                    new Skill(me, SkillEnum.DIPLOMACY),new Skill(me, SkillEnum.DISABLE_DEVICE),new Skill(me, SkillEnum.DISGUISE),new Skill(me, SkillEnum.ESCAPE_ARTIST),
                    new Skill(me,SkillEnum.INTIMIDATE), new Skill(me,SkillEnum.KNOWLEDGE, "Local"), new Skill(me,SkillEnum.KNOWLEDGE, "Dungeoneering"),
                    new Skill(me,SkillEnum.LINQUISTICS),new Skill(me,SkillEnum.PERCEPTION),new Skill(me,SkillEnum.PERFORM),new Skill(me,SkillEnum.SENSE_MOTIVE),
                    new Skill(me, SkillEnum.SLEIGHT_OF_HAND),new Skill(me, SkillEnum.STEALTH),new Skill(me, SkillEnum.SWIM),new Skill(me, SkillEnum.USE_MAGIC_DEVICE)};
            SkillUtils.applyClassSkills(classSkills, me);

            if(Feats.getFeatByName("Weapon Finesse") != null && !Feats.characterHasFeat("Weapon Finesse", me))
                me.currentFeats.add(Feats.getFeatByName("Weapon Finesse"));

            me.miscAbilities.put("Rogue Weapon and Armor Proficiency", "Rogues are proficient with all simple weapons, plus the hand crossbow, rapier, sap, short sword, and shortbow. They are proficient with light armor, but not with shields.");
            me.miscAbilities.put("Sneak Attack", "If a rogue can catch an opponent when he is unable to defend himself effectively from her attack, she can strike a vital spot for extra damage.<br>" +
                    "<br>" +
                    "The rogue's attack deals extra damage anytime her target would be denied a Dexterity bonus to AC (whether the target actually has a Dexterity bonus or not), or when the rogue flanks her target. This extra damage is 1d6 at 1st level, and increases by 1d6 every 2 rogue levels thereafter. Ranged attacks can count as sneak attacks only if the target is within 30 feet. This additional damage is precision damage and is not multiplied on a critical hit.<br>" +
                    "<br>" +
                    "With a weapon that deals nonlethal damage (such as a sap, unarmed strike, or whip), a rogue can make a sneak attack that deals nonlethal damage instead of lethal damage. She cannot use a weapon that deals lethal damage to deal nonlethal damage in a sneak attack—not even with the usual –4 penalty.<br>" +
                    "<br>" +
                    "The rogue must be able to see the target well enough to pick out a vital spot and must be able to reach such a spot. A rogue cannot sneak attack while striking a creature with total concealment.");
            me.miscAbilities.put("Trapfinding", "A rogue adds 1/2 her level on Perception checks to locate taps on Disable Device checks (minimum +1). A rogue can use Disable Device to disarm magic traps.");
            me.miscAbilities.put("Finesse Training", "At 1st level, a rogue gains Weapon Finesse as a bonus feat. In addition, starting at 3rd level, she can select any one type of weapon that can be used with Weapon Finesse (such as rapiers or daggers). Once this choice is made, it cannot be changed. Whenever she makes a successful melee attack with the selected weapon, she adds her Dexterity modifier instead of her Strength modifier to the damage roll. If any effect would prevent the rogue from adding her Strength modifier to the damage roll, she does not add her Dexterity modifier. The rogue can select a second weapon at 11th level and a third at 19th level.");
        }
        if(level == 2){
            me.miscAbilities.put("Evasion (Ex)","At 2nd level, a rogue can avoid even magical and unusual attacks with great agility. If she succeeds at a Reflex saving throw against an attack that normally deals half damage on a successful save, she instead takes no damage. Evasion can be used only if the rogue is wearing light armor or no armor. A helpless rogue does not gain the benefit of evasion.");
        }
        if(level < 10 && level%2 == 0 && Pathfinder.askYesNo("You get a Rogue Talent! Would you like me to pull up the rogue talents online?")){
            Pathfinder.showWebPage("http://www.d20pfsrd.com/classes/unchained-classes/rogue-unchained/rogue-talents","Unchained Rogue Talents");
        }
        if(level == 3) me.miscAbilities.put("Danger Sense", "At 3rd level, a rogue gains a +1 bonus on Reflex saves to avoid traps and a +1 dodge bonus to AC against attacks made by traps. In addition, she gains a +1 bonus on Perception checks to avoid being surprised by a foe. These bonuses increase by 1 every 3 rogue levels thereafter (to a maximum of +6 at 18th level). This ability counts as trap sense for the purpose of any feat or class prerequisite, and can be replaced by any archetype class feature that replaces trap sense. The bonuses gained from this ability stack with those gained from trap sense (from another class).");
        if(level%4 == 0){
            Pathfinder.popupDialog("Ability Score increases!","Choose two different ability scores and give both of them a +1!\n" +
                    "If the ability is Int, and your modifier goes up, add skill ranks to skills equal to your current level.\n" +
                    "If the ability is Con, and your modifier goes up, add your current level value to your total health.");
        }
        if(level == 4){
            me.miscAbilities.put("Debilitating Injury (Ex)", "At 4th level, whenever a rogue deals sneak attack damage to a foe, she can also debilitate the target of her attack, causing it to take a penalty for 1 round (this is in addition to any penalty caused by a rogue talent or other special ability). The rogue can choose to apply any one of the following penalties when the damage is dealt.<br>" +
                    "<br>" +
                    "Bewildered: The target becomes bewildered, taking a –2 penalty to AC. The target takes an additional –2 penalty to AC against all attacks made by the rogue. At 10th level and 16th level, the penalty to AC against attacks made by the rogue increases by –2 (to a total maximum of –8).<br>" +
                    "<br>" +
                    "Disoriented: The target takes a –2 penalty on attack rolls. In addition, the target takes an additional –2 penalty on all attack rolls it makes against the rogue. At 10th level and 16th level, the penalty on attack rolls made against the rogue increases by –2 (to a total maximum of –8).<br>" +
                    "<br>" +
                    "Hampered: All of the target's speeds are reduced by half (to a minimum of 5 feet). In addition, the target cannot take a 5-foot step.<br>" +
                    "<br>" +
                    "These penalties do not stack with themselves, but additional attacks that deal sneak attack damage extend the duration by 1 round. A creature cannot suffer from more than one penalty from this ability at a time. If a new penalty is applied, the old penalty immediately ends. Any form of healing applied to a target suffering from one of these penalties also removes the penalty.");
            if(!me.miscAbilities.containsKey("Uncanny Dodge (Ex)"))
                me.miscAbilities.put("Uncanny Dodge (Ex)","At 4th level, a rogue can react to danger before her senses would normally allow her to do so. She cannot be caught flat-footed, nor does she lose her Dexterity bonus to AC if the attacker is invisible. She still loses her Dexterity bonus to AC if immobilized. A rogue with this ability can still lose her Dexterity bonus to AC if an opponent successfully uses the feint action against her.<br>" +
                    "<br>" +
                    "If a rogue already has uncanny dodge from a different class, she automatically gains improved uncanny dodge (see below) instead.");
            else me.miscAbilities.put("Improved Uncanny Dodge (Ex)","At 8th level, a rogue can no longer be flanked.<br>" +
                    "<br>" +
                    "This defense denies another rogue the ability to sneak attack the character by flanking her, unless the attacker has at least four more rogue levels than the target does.<br>" +
                    "<br>" +
                    "If a character already has uncanny dodge from another class, the levels from the classes that grant uncanny dodge stack to determine the minimum rogue level required to flank the character.");

            if(level == 5) me.miscAbilities.put("Rogue's Edge (Ex)", "At 5th level, a rogue has mastered a single skill beyond that skill's normal boundaries, gaining results that others can only dream about. She gains the skill unlock powers for that skill as appropriate for her number of ranks in that skill. At 10th, 15th, and 20th levels, she chooses an additional skill and gains skill unlock powers for that skill as well.");
            if(level == 8) me.miscAbilities.put("Improved Uncanny Dodge (Ex)","At 8th level, a rogue can no longer be flanked.<br>" +
                    "<br>" +
                    "This defense denies another rogue the ability to sneak attack the character by flanking her, unless the attacker has at least four more rogue levels than the target does.<br>" +
                    "<br>" +
                    "If a character already has uncanny dodge from another class, the levels from the classes that grant uncanny dodge stack to determine the minimum rogue level required to flank the character.");
            if(level > 9 && level%2 == 0){
                if(Pathfinder.askYesNo("You get an advanced rogue talent! Would you like me to pull these up on the web?"))
                    Pathfinder.showWebPage("Advanced Rodue Talents","http://www.d20pfsrd.com/classes/unchained-classes/rogue-unchained/rogue-talents-advanced");
            }
            if(level == 20) me.miscAbilities.put("Master Strike (Ex)","At 20th level, an rogue becomes incredibly deadly when dealing sneak attack damage. Each time the rogue deals sneak attack damage, she can choose one of the following three effects: the target can be put to sleep for 1d4 hours, paralyzed for 2d6 rounds, or slain. Regardless of the effect chosen, the target can attempt a Fortitude save to negate the additional effect. The DC of this save is equal to 10 + 1/2 the rogue's level + the rogue's Dexterity modifier. Once a creature has been the target of a master strike, regardless of whether or not the save is successful, that creature is immune to that rogue's master strike for 24 hours. Creatures that are immune to sneak attack damage are also immune to this ability.");
        }
    }

    public int[] getBAB(){
        int[][] bab = new int[][]{{0},{0},{1},{2},{3},{3},{4},{5},{6,1},{6,1},{7,2},{8,3},{9,4},{9,4},{10,5},{11,6,1},{12,7,2},{12,7,2},{13,8,3},{14,9,4},{15,10,5}};
        return bab[level];
    }

    public int getBaseFortSave(){
        return level/3;
    }

    public int getBaseRefSave(){
        return 2 + level/2;
    }

    public int getBaseWillSave(){
        return level/3;
    }

}