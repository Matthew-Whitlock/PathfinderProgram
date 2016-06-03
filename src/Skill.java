package src;

import src.Character;
import java.util.*;

public enum Skill{
	
	ACROBATICS(new String[]{Character.BBN,Character.BRD,Character.GUN,Character.MNK,Character.ROG},true,true,Character.DEX,"Acrobatics","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-acrobatics"),
	APPRAISE(new String[]{Character.ALC,Character.BRD,Character.CLR,Character.ROG,Character.SOR},true,false,Character.INT,"Appraise","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-appraise"),
	BLUFF(new String[]{Character.BRD,Character.CAV,Character.GUN,Character.INQ,Character.ROG,Character.SOR},true,false,Character.CHA,"Bluff","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-bluff"),
	CLIMB(new String[]{Character.BBN,Character.BRD,Character.CAV,Character.DRD,Character.FTR,Character.GUN,Character.INQ,Character.MAG,Character.MNK,Character.RGR,Character.ROG},true,true,Character.STR,"Climb","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-climb"),
	CRAFT(new String[]{Character.ALC,Character.BBN,Character.BRD,Character.CAV,Character.CLR,Character.DRD,Character.FTR,Character.GUN,Character.INQ,Character.MAG,Character.MNK,Character.ORA,Character.PAL,Character.RGR,Character.ROG,Character.SOR,Character.SUM,Character.WIT,Character.WIZ},true,false,Character.INT,"Craft","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-craft"),
	DIPLOMACY(new String[]{Character.BRD,Character.CAV,Character.CLR,Character.INQ,Character.ORA,Character.PAL,Character.ROG},true,false,Character.CHA,"Diplomacy","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-diplomacy"),
	DIABLE_DEVICE(new String[]{Character.ALC,Character.ROG},false,true,Character.DEX,"Disable Device","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-disable-device"),
	DISGUISE(new String[]{Character.BRD,Character.INQ,Character.ROG},true,false,Character.CHA,"Disguise","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-disguise"),
	ESCAPE_ARTIST(new String[]{Character.BRD,Character.MNK,Character.ROG},true,true,Character.DEX,"Escape Artist","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-escape-artist"),
	FLY(new String[]{Character.ALC,Character.DRD,Character.MAG,Character.SOR,Character.SUM,Character.WIT,Character.WIZ},true,true,Character.DEX,"Fly","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-fly"),
	HANDLE_ANIMAL(new String[]{Character.BBN,Character.CAV,Character.DRD,Character.FTR,Character.GUN,Character.PAL,Character.RGR,Character.SUM},false,false,Character.CHA,"Handle Animal","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-handle-animal"),
	HEAL(new String[]{Character.ALC,Character.CLR,Character.DRD,Character.GUN,Character.INQ,Character.ORA,Character.PAL,Character.RGR,Character.WIT},true,false,Character.WIS,"Heal","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-heal"),
	INTIMIDATE(new String[]{Character.BBN,Character.BRD,Character.CAV,Character.FTR,Character.GUN,Character.INQ,Character.MAG,Character.MNK,Character.RGR,Character.ROG,Character.SOR,Character.WIT},true,false,Character.CHA,"Intimidate","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-intimidate"),
	KNOWLEDGE_ARCANA(new String[]{Character.ALC,Character.BRD,Character.CLR,Character.INQ,Character.MAG,Character.SOR,Character.SUM,Character.WIT,Character.WIZ},false,false,Character.INT,"Knowledge (Arcana)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_DUNGEONEERING(new String[]{Character.BRD,Character.FTR,Character.INQ,Character.MAG,Character.RGR,Character.ROG,Character.SUM,Character.WIZ},false,false,Character.INT,"Knowledge (Dungeoneering)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_ENGINEERING(new String[]{Character.BRD,Character.FTR,Character.GUN,Character.SUM,Character.WIZ},false,false,Character.INT,"Knowledge (Engineering)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_GEOGRAPHY(new String[]{Character.BRD,Character.DRD,Character.RGR,Character.SUM,Character.WIZ},false,false,Character.INT,"Knowledge (Geography)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_HISTORY(new String[]{Character.BRD,Character.CLR,Character.RGR,Character.SUM,Character.WIZ},false,false,Character.INT,"Knowledge (History)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_LOCAL(new String[]{Character.BRD,Character.GUN,Character.ROG,Character.SUM,Character.WIZ},false,false,Character.INT,"Knowledge (Local)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_NATURE(new String[]{Character.ALC,Character.BBN,Character.BRD,Character.DRD,Character.INQ,Character.RGR,Character.SUM,Character.WIT,Character.WIZ},false,false,Character.INT,"Knowledge (Nature)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_NOBILITY(new String[]{Character.BRD,Character.CLR,Character.PAL,Character.SUM,Character.WIZ},false,false,Character.INT,"Knowledge (Nobility)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_PLANES(new String[]{Character.BRD,Character.CLR,Character.INQ,Character.MAG,Character.ORA,Character.SUM,Character.WIT,Character.WIZ},false,false,Character.INT,"Knowledge (Planes)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	KNOWLEDGE_RELIGION(new String[]{Character.BRD,Character.CLR,Character.INQ,Character.MNK,Character.ORA,Character.PAL,Character.SUM,Character.WIZ},false,false,Character.INT,"Knowledge (Religion)","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-knowledge"),
	LINQUISTICS(new String[]{Character.BRD,Character.CLR,Character.ROG,Character.SUM,Character.WIZ},false,false,Character.INT,"Linguistics","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-linguistics"),
	PERCEPTION(new String[]{Character.ALC,Character.BBN,Character.BRD,Character.DRD,Character.GUN,Character.INQ,Character.MNK,Character.RGR,Character.ROG},true,false,Character.WIS,"Perception","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-perception"),
	PERFORM(new String[]{Character.BRD,Character.MNK,Character.ROG},true,false,Character.CHA,"Perform","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-perform"),
	PROFESSION(new String[]{Character.ALC,Character.BRD,Character.CAV,Character.CLR,Character.DRD,Character.FTR,Character.GUN,Character.INQ,Character.MAG,Character.MNK,Character.ORA,Character.PAL,Character.RGR,Character.ROG,Character.SOR,Character.SUM,Character.WIT,Character.WIZ},false,false,Character.WIS,"Profession","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-profession"),
	RIDE(new String[]{Character.BBN,Character.CAV,Character.DRD,Character.FTR,Character.GUN,Character.INQ,Character.MAG,Character.MNK,Character.PAL,Character.RGR,Character.SUM},true,true,Character.DEX,"Ride","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-ride"),
	SENSE_MOTIVE(new String[]{Character.BRD,Character.CAV,Character.CLR,Character.INQ,Character.MNK,Character.ORA,Character.PAL,Character.ROG},true,false,Character.WIS,"Sense Motive","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-sense-motive"),
	SLEIGHT_OF_HAND(new String[]{Character.ALC,Character.BRD,Character.GUN,Character.ROG},false,true,Character.DEX,"Sleight of Hand","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-sleight-of-hand"),
	SPELLCRAFT(new String[]{Character.ALC,Character.BRD,Character.CLR,Character.DRD,Character.INQ,Character.MAG,Character.ORA,Character.PAL,Character.RGR,Character.SOR,Character.SUM,Character.WIT,Character.WIZ},false,false,Character.INT,"Spellcraft","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-spellcraft"),
	STEALTH(new String[]{Character.BRD,Character.INQ,Character.MNK,Character.RGR,Character.ROG},true,true,Character.STR,"Stealth","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-stealth"),
	SURVIVAL(new String[]{Character.ALC,Character.BBN,Character.DRD,Character.FTR,Character.GUN,Character.INQ,Character.RGR},true,false,Character.WIS,"Survival","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-survival"),
	SWIM(new String[]{Character.BBN,Character.CAV,Character.DRD,Character.FTR,Character.GUN,Character.INQ,Character.MAG,Character.MNK,Character.RGR,Character.ROG},true,true,Character.STR,"Swim","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-swim"),
	USE_MAGIC_DEVICE(new String[]{Character.ALC,Character.BRD,Character.MAG,Character.ROG,Character.SOR,Character.SUM,Character.WIT},false,false,Character.CHA,"Use Magic Device","http://www.d20pfsrd.com/extras/community-creations/richard-s-lab/alternative-rules/fast-play-skills-reference/fast-play-skill-use-magic-device");
	
	private final String[] classes;
	private final boolean untrainedSkill;
	private final boolean hasACPenalty;
	private final String abilityMod;
	private final String name;
	private final String urlText;
	
	Skill(String[] classSkills,boolean untrained,boolean acPen,String ability,String name,String website){
		classes = classSkills;
		untrainedSkill = untrained;
		hasACPenalty = acPen;
		abilityMod = ability;
		this.name = name;
		urlText = website;
	}
	
	public boolean skillOfClass(String className){
		boolean toReturn = false;
		for(String name : classes){
			if(name.equalsIgnoreCase(className)) toReturn = true;
		}
		return toReturn;
	}
	
	public ArrayList<Skill> getClassSkills(String className){
		ArrayList<Skill> skills = new ArrayList<Skill>();
		for(Skill skill : Skill.values()){
			if(skill.skillOfClass(className)) skills.add(skill);
		}
		return skills;
	}
	
	public boolean hasACPenalty(){
		return hasACPenalty;
	}
	
	public boolean isUntrained(){
		return untrainedSkill;
	}
	
	public String getAbilityMod(){
		return abilityMod;
	}
	
	public String toString(){
		return name;
	}
	
	public String getURL(){
		return urlText;
	}
	
}