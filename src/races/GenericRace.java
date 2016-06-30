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

    public GenericRace(String name){
        this.name = name;
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
        return new HashMap<AbilityScoreEnum, Integer>();
    }

    public URL getDefaultRaceImageLocation(){
        return this.getClass().getResource("/src/pictures/default.png");
    }
}
