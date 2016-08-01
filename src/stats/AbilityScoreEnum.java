package src.stats;

import java.io.Serializable;

/**
 * @author VestOfHolding
 * @since 6/2/2016.
 */
public enum AbilityScoreEnum implements Serializable{
    STR("Strength","Str"),
    DEX("Dexterity","Dex"),
    CON("Constitution","Con"),
    INT("Intelligence","Int"),
    WIS("Wisdom","Wis"),
    CHA("Charisma","Cha");

    private String fullName;
    private String shortName;

    AbilityScoreEnum(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName(){
        return shortName;
    }
}