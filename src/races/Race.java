package src.races;

import src.feats.Feat;
import src.stats.AbilityScoreEnum;

import java.net.URL;
import java.util.Map;

public interface Race{
	String[] notes();
	Map<AbilityScoreEnum, Integer> abilityScoreChanges();
	Feat[] bonusFeats();
	String getName();
	URL getDefaultRaceImageLocation();
	String getDescription();
}