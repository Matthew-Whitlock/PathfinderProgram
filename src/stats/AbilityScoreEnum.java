package src.stats;

/**
 * @author VestOfHolding
 * @since 6/2/2016.
 */
public enum AbilityScoreEnum {
    STR("Strength"),
    DEX("Dexterity"),
    CON("Constitution"),
    INT("Intelligence"),
    WIS("Wisdom"),
    CHA("Charisma");

    private String fullName;

    AbilityScoreEnum(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
} 