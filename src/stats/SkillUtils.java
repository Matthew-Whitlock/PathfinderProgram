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

    public static void applyClassSkills(Set<SkillEnum> classSkills, Map<SkillEnum, Skill> playerSkills){
        for (SkillEnum classSkill : classSkills) {
            Skill playerSkill = playerSkills.get(classSkill);

            playerSkill.setClassSkill(true);
        }
    }
}