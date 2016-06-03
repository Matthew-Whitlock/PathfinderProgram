package src.stats;

import java.util.*;

/**
 * @author VestOfHolding
 * @since 6/2/2016.
 */
public class SkillUtils {

    public static Map<SkillEnum, Skill> createInitialSkillMap() {
        Map<SkillEnum, Skill> skillMap = new HashMap<>();

        for (SkillEnum skillEnum : SkillEnum.values()) {
            skillMap.put(skillEnum, new Skill(skillEnum));
        }

        return skillMap;
    }

    public static void applyClassSkills(Set<SkillEnum> classSkills, Map<SkillEnum, Skill> playerSkills){
        for (SkillEnum classSkill : classSkills) {
            Skill playerSkill = playerSkills.get(classSkill);

            playerSkill.setClassSkill(true);
        }
    }
}
