package src.feats;

import src.Character;
import src.classes.AbyssalBloodline;
import src.races.Dwarf;
import src.stats.AbilityScoreEnum;

import java.util.HashMap;

/**
 * Created by Matthew on 6/5/2016.
 */
public class FeatDataGatherer {
    public static void main(String[] args){
        //for(Feat feat : Feats.getFeats()) System.out.println(feat + ": " + feat.prereqsAsString);

        /*HashMap<AbilityScoreEnum, Integer> abilityPoints = new HashMap<>();
        for(AbilityScoreEnum ability : AbilityScoreEnum.values()) abilityPoints.put(ability, 10);
        Character me = new Character("Testing", new Dwarf(), new AbyssalBloodline(), abilityPoints);

        Feat first = new Feat(Feats.getFeatByName("Skill Focus"),"Diplomacy");
        Feat second = new Feat(Feats.getFeatByName("Skill Focus"),"Test");
        me.currentFeats.add(first);
        me.currentFeats.add(second);
        me.currentFeats.add(Feats.getFeatByName("Tenacious Spell"));

        Feats.getFeats().stream().filter(feat -> Feats.characterMeetsAllPrereqs(feat, me))
                .forEach(feat -> System.out.println(feat + ": " + feat.prereqsAsString));*/
    }
}