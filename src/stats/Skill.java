package src.stats;

import src.Character;

import java.util.HashSet;
import java.util.Set;

/**
 * @author VestOfHolding
 * @since 6/2/2016.
 */
public class Skill{
	
	public final SkillEnum skillEnum;
	private boolean isClassSkill = false;
	private int nRanks = 0;
	private int miscMod = 0;
	private String subType = null;
	private Character me;
	
	public Skill(Character me, SkillEnum skillEnum) {
		this.me = me;
        this.skillEnum = skillEnum;
    }

    public Skill(Character me, SkillEnum skillEnum, boolean isClassSkill) {
		this.me = me;
        this.skillEnum = skillEnum;
        this.isClassSkill = isClassSkill;
    }
	
	public Skill(Character me, SkillEnum skillEnum, String subType){
		this.me = me;
		this.skillEnum = skillEnum;
		this.subType = subType;
	}
	
	public Skill(Character me, SkillEnum skillEnum, boolean isClassSkill, String subType){
		this.me = me;
		this.skillEnum = skillEnum;
        this.isClassSkill = isClassSkill;
		this.subType = subType;
	}

    public Skill(Character me, SkillEnum skillEnum, boolean isClassSkill, int nRanks, int miscMod, String subType) {
		this.me = me;
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
        return skillEnum.toString();
    }

    public boolean canBeUntrained() {
        return skillEnum.isUntrained();
    }

    public boolean doesACPApply() {
        return skillEnum.doesACPApply();
    }

    public AbilityScoreEnum getKeyAbility() {
        return skillEnum.getKeyAbility();
    }
	
	public String getURL(){
		return skillEnum.getURL();
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

        result += nRanks + miscMod + me.getAbilityMod(getKeyAbility());

        if(doesACPApply()) result += me.getACPen();
		
        return result;
    }

    @Override
    public String toString() {
        return getName() + (subType != null ? " (" + subType + ")" : "");
    }
	
}