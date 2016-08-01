package src.races;

import src.feats.Feat;
import src.stats.AbilityScoreEnum;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matthew on 6/29/2016.
 */
public class GenericRace implements Race, Serializable{
    public String name;
    public String description;
    public HashMap<AbilityScoreEnum, Integer> abilityScoreChanges = new HashMap<>();

    public GenericRace(String name){
        this.name = name;
    }

    public GenericRace(String name, HashMap<AbilityScoreEnum, Integer> abilityScoreMods){
        this.name = name;
        abilityScoreChanges = abilityScoreMods;
    }

    public String getName(){
        return name;
    }

    public Feat[] bonusFeats(){
        return new Feat[0];
    }

    public String[] notes(){
        return new String[0];
    }

    public Map<AbilityScoreEnum, Integer> abilityScoreChanges(){
        return abilityScoreChanges;
    }

    public URL getDefaultRaceImageLocation(){
        return this.getClass().getResource("/src/pictures/RaceImages/Default.png");
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return name;
    }
}