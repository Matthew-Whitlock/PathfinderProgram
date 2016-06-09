package src.stats;

import src.stats.AbilityScoreEnum;

public enum SkillEnum{
	
	ACROBATICS(true,AbilityScoreEnum.DEX,"Acrobatics","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-acrobatics"),
	APPRAISE(true,AbilityScoreEnum.INT,"Appraise","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-appraise"),
	BLUFF(true,AbilityScoreEnum.CHA,"Bluff","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-bluff"),
	CLIMB(true,AbilityScoreEnum.STR,"Climb","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-climb"),
	CRAFT(true,AbilityScoreEnum.INT,"Craft","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-craft"),
	DIPLOMACY(true,AbilityScoreEnum.CHA,"Diplomacy","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-diplomacy"),
	DIABLE_DEVICE(false,AbilityScoreEnum.DEX,"Disable Device","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-disable-device"),
	DISGUISE(true,AbilityScoreEnum.CHA,"Disguise","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-disguise"),
	ESCAPE_ARTIST(true,AbilityScoreEnum.DEX,"Escape Artist","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-escape-artist"),
	FLY(true,AbilityScoreEnum.DEX,"Fly","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-fly"),
	HANDLE_ANIMAL(false,AbilityScoreEnum.CHA,"Handle Animal","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-handle-animal"),
	HEAL(true,AbilityScoreEnum.WIS,"Heal","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-heal"),
	INTIMIDATE(true,AbilityScoreEnum.CHA,"Intimidate","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-intimidate"),
	KNOWLEDGE(false,AbilityScoreEnum.INT,"Knowledge","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	LINQUISTICS(false,AbilityScoreEnum.INT,"Linguistics","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-linguistics"),
	PERCEPTION(true,AbilityScoreEnum.WIS,"Perception","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-perception"),
	PERFORM(true,AbilityScoreEnum.CHA,"Perform","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-perform"),
	PROFESSION(false,AbilityScoreEnum.WIS,"Profession","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-profession"),
	RIDE(true,AbilityScoreEnum.DEX,"Ride","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-ride"),
	SENSE_MOTIVE(true,AbilityScoreEnum.WIS,"Sense Motive","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-sense-motive"),
	SLEIGHT_OF_HAND(false,AbilityScoreEnum.DEX,"Sleight of Hand","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-sleight-of-hand"),
	SPELLCRAFT(false,AbilityScoreEnum.INT,"Spellcraft","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-spellcraft"),
	STEALTH(true,AbilityScoreEnum.STR,"Stealth","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-stealth"),
	SURVIVAL(true,AbilityScoreEnum.WIS,"Survival","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-survival"),
	SWIM(true,AbilityScoreEnum.STR,"Swim","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-swim"),
	USE_MAGIC_DEVICE(false,AbilityScoreEnum.CHA,"Use Magic Device","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-use-magic-device");
	
	private final boolean untrainedSkill;
	private final AbilityScoreEnum abilityMod;
	private final String name;
	private final String urlText;
	
	SkillEnum(boolean untrained, AbilityScoreEnum abilityMod, String name, String website){
		untrainedSkill = untrained;
		this.abilityMod = abilityMod;
		this.name = name;
		urlText = website;
	}
	
	public boolean doesACPApply(){
		return abilityMod == AbilityScoreEnum.DEX || abilityMod == AbilityScoreEnum.STR;
	}
	
	public boolean isUntrained(){
		return untrainedSkill;
	}
	
	public AbilityScoreEnum getKeyAbility(){
		return abilityMod;
	}
	
	public String toString(){
		return name;
	}
	
	public String getURL(){
		return urlText;
	}
	
	public boolean hasSubTypes(){
		return this == KNOWLEDGE || this == PROFESSION || this == CRAFT;
	}
	
}