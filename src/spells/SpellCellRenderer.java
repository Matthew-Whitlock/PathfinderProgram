package src.spells;

import src.Pathfinder;
import src.classes.SpellCaster;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 7/20/2016.
 */
public class SpellCellRenderer extends JLabel implements ListCellRenderer<Spell>{
    private SpellCaster spellCaster = null;

    public SpellCellRenderer(){}

    public SpellCellRenderer(SpellCaster spellcaster){
        spellCaster = spellcaster;
    }

    public Component getListCellRendererComponent(JList<? extends Spell> list, Spell spell, int index, boolean isSelected, boolean cellHasFocus) {

        String s = "";
        if(spellCaster != null){
            s += "L" + spellCaster.getSpellLevel(spell) + ": " + spell.name;
        } else{
            s += spell.name + ": " + spell.shortDescription;
        }

        setText(s);

        try{
            if(Spells.getIcon(spell) != null){
                setIcon(new ImageIcon(Spells.getIcon(spell)));
            }
        } catch(Exception e){
            Pathfinder.showError("Error","I couldn't load this Spell image. It may be missing.\nRun in command for more details.");
            e.printStackTrace();
        }

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
}
