package src.stats;

import static src.stats.AbilityScoreEnum.*;

/**
 * @author VestOfHolding
 * @since 6/2/2016.
 */
public enum SkillEnum {
    ACROBATICS("Acrobatics", true, DEX),
    APPRAISE("Appraise", true, INT),
    BLUFF("Bluff", true, CHA),
    CLIMB("Climb", true, STR),
    CRAFT("Craft", true, INT),
    DIPLOMACY("Diplomacy", true, CHA),
    DISABLE_DEVICE("Disable Device", false, DEX),
    KNOW_ARCANA("Knowledge (Arcana)", false, INT),
    KNOW_DUNGEON("Knowledge (Dungeoneering)", false, INT),
    PERFORM("Perform", true, CHA),
    PROFESSION("Profession", false,WIS);

    private String fullName;

    //Whether or not a skill can be used when a player has put zero ranks in the skill
    private boolean canBeUntrained;

    //The ability score that adds its modifier to the skill total
    private AbilityScoreEnum keyAbility;

    SkillEnum(String fullName, boolean canBeUntrained, AbilityScoreEnum keyAbility) {
        this.fullName = fullName;
        this.canBeUntrained = canBeUntrained;
        this.keyAbility = keyAbility;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean canBeUntrained() {
        return canBeUntrained;
    }

    public boolean isDoesACPApply() {
        //Armor Check Penalty applies only to skills that are DEX or STR based
        return keyAbility == AbilityScoreEnum.STR || keyAbility == DEX;
    }

    public AbilityScoreEnum getKeyAbility() {
        return keyAbility;
    }

    public boolean hasSubTypes() {
        //These skills can have subtypes, such as Craft (weapons) or Profession (Chef) that can be whatever
        // the player wants, though there is a list of the most common for each.
        return this == CRAFT || this == PERFORM || this == PROFESSION;
    }
}