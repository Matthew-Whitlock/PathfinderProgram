package src.stats;

import java.util.*;

import src.Character;

/**
 * @author VestOfHolding
 * @since 6/2/2016.
 */
public class SkillUtils {

    public static Map<SkillEnum, Skill> createInitialSkillMap(Character me) {
        Map<SkillEnum, Skill> skillMap = new HashMap<>();

        for (SkillEnum skillEnum : SkillEnum.values()) {
            skillMap.put(skillEnum, new Skill(me, skillEnum));
        }

        return skillMap;
    }
	
	public static ArrayList<Skill> createInitialSkillList(Character me) {
		ArrayList<Skill> skillList = new ArrayList<Skill>();
		
		for(SkillEnum skillEnum : SkillEnum.values()) {
			if(!skillEnum.hasSubTypes()){
				skillList.add(new Skill(me, skillEnum));
			}
		}
		
		return skillList;
	}

    public static void applyClassSkills(Skill[] classSkills, Character me){
        for (Skill classSkill : classSkills) {

            Skill playerSkill;

            if(classSkill.hasSubType())
                playerSkill = getSkill(classSkill.skillEnum, me, classSkill.getSubType());
            else
                playerSkill = getSkill(classSkill.skillEnum, me);

            playerSkill.setClassSkill(true);
        }
    }



    public static Skill getSkill(SkillEnum skillToFind, Character me){
        for(Skill skill : me.skillsList){
            if(skill.skillEnum == skillToFind) return skill;
        }

        Skill toAdd = new Skill(me, skillToFind);
        me.skillsList.add(toAdd);

        return toAdd;
    }

    public static Skill getSkill(SkillEnum skillToFind, Character me, String subtype){
        for(Skill skill : me.skillsList){
            if(skill.skillEnum == skillToFind && skill.getSubType() != null && skill.getSubType().equals(subtype)) return skill;
        }

        Skill toAdd = new Skill(me, skillToFind, subtype);
        me.skillsList.add(toAdd);

        return toAdd;
    }
}