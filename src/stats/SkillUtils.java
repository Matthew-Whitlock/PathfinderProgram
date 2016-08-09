package src.stats;

import java.awt.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import src.Character;
import src.Pathfinder;

import javax.swing.*;

/**
 * @author VestOfHolding
 * @since 6/2/2016.
 */
public class SkillUtils {
	
	public static ArrayList<Skill> createInitialSkillList(Character me) {
		ArrayList<Skill> skillList = new ArrayList<>();
		
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

    public static int maxRanksIn(SkillEnum skillToFind, Character me){
        int maxRanks = 0;
        for(Skill skill : me.skillsList){
            if(skill.skillEnum == skillToFind && skill.getnRanks() > maxRanks) maxRanks = skill.getnRanks();
        }
        return maxRanks;
    }

    public static SkillEnum getSkillEnum(String skillToFind){
        SkillEnum toReturn = null;

        for(SkillEnum skill : SkillEnum.values()) if(skill.name().equalsIgnoreCase(skillToFind)) toReturn = skill;

        return toReturn;
    }

    public static boolean characterHasSkill(SkillEnum skill, Character me){
        for(Skill charSkill : me.skillsList) if(charSkill.skillEnum == skill) return true;
        return false;
    }

    public static boolean characterHasSkill(SkillEnum skill, String subskill, Character me){
        for(Skill charSkill : me.skillsList) if(charSkill.skillEnum == skill && charSkill.hasSubType() && charSkill.getSubType().equalsIgnoreCase(subskill)) return true;
        return false;
    }

    public static Skill addSkillSubtype(Character me){
        JDialog addSkillFrame = new JDialog(Pathfinder.FRAME, "Choose a skill to add");
        addSkillFrame.setSize(300,160);
        addSkillFrame.setLocationRelativeTo(Pathfinder.FRAME);

        ArrayList<SkillEnum> skillsWithSubtypes = new ArrayList<>();
        for(SkillEnum skill : SkillEnum.values())
            if(skill.hasSubTypes())
                skillsWithSubtypes.add(skill);

        String[] model = new String[skillsWithSubtypes.size()];
        for(int i = 0; i < model.length; i++) model[i] = skillsWithSubtypes.get(i).toString();

        JList<String> list = new JList<>(model);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(list, BorderLayout.CENTER);

        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(80,25));

        JPanel upperPanel = new JPanel(new FlowLayout());

        JLabel skillSelected = new JLabel();

        list.addListSelectionListener(e -> {
            skillSelected.setText(skillsWithSubtypes.get(list.getSelectedIndex()).toString() + " (");
        });
        list.setSelectedIndex(0);

        upperPanel.add(skillSelected);

        upperPanel.add(field);

        upperPanel.add(new JLabel(")"));

        panel.add(upperPanel, BorderLayout.NORTH);

        JButton chooser = new JButton("Make this sub-skill");

        panel.add(chooser,BorderLayout.SOUTH);

        AtomicBoolean confirmed = new AtomicBoolean(false);
        chooser.addActionListener(e -> {
            if(field.getText().equals("")) Pathfinder.showError("Invalid option","You must write a subtype");
            else confirmed.set(true);
        });

        addSkillFrame.add(panel);
        addSkillFrame.setVisible(true);

        while(!confirmed.get()){}

        addSkillFrame.dispose();
        return SkillUtils.getSkill(skillsWithSubtypes.get(list.getSelectedIndex()),me,field.getText());
    }
}