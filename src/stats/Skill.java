package src.stats;

import java.util.HashSet;
import java.util.Set;

/**
 * @author VestOfHolding
 * @since 6/2/2016.
 */
public class Skill {
    //The enum information behind this skill
    private SkillEnum skillEnum;

    private boolean isClassSkill;

    private int nRanks;

    private int miscMod;

    private String subType;

    public Skill(SkillEnum skillEnum) {
        this.skillEnum = skillEnum;
    }

    public Skill(SkillEnum skillEnum, boolean isClassSkill) {
        this.skillEnum = skillEnum;
        this.isClassSkill = isClassSkill;
    }

    public Skill(SkillEnum skillEnum, boolean isClassSkill, int nRanks, int miscMod, String subType) {
        this.skillEnum = skillEnum;
        this.isClassSkill = isClassSkill;
        this.nRanks = nRanks;
        this.miscMod = miscMod;
        this.subType = subType;
    }

    //Getters and setters for the class fields

    public boolean isClassSkill() {
        return isClassSkill;
    }

    public void setClassSkill(boolean classSkill) {
        isClassSkill = classSkill;
    }

    public int getnRanks() {
        return nRanks;
    }

    public void setnRanks(int nRanks) {
        this.nRanks = nRanks;
    }

    public int getMiscMod() {
        return miscMod;
    }

    public void setMiscMod(int miscMod) {
        this.miscMod = miscMod;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    //Getters for the information inside the enum

    public String getName() {
        return skillEnum.getFullName();
    }

    public boolean canBeUntrained() {
        return skillEnum.canBeUntrained();
    }

    public boolean doesACPApply() {
        return skillEnum.isDoesACPApply();
    }

    public AbilityScoreEnum getKeyAbility() {
        return skillEnum.getKeyAbility();
    }

    //Other methods

    /**
     * Given the appropriate ability modifier, and any currently active Armor Check Penalty
     * calculate the character's total mod for this skill
     *
     * @return The total mod for this skill
     */
    public int calculateTotalSkillMod() {
        int result = 0;

        if (isClassSkill && nRanks > 0) {
            result += 3;
        }

        result += nRanks + miscMod;

        //Add the appropriate modifier

        //Check that ACP applies to this skill and subtract if necessary

        return result;
    }

    @Override
    public String toString() {
        return getName() + (subType != null ? " (" + subType + ")" : "");
    }
}