package src.feats;

import src.Pathfinder;
import src.items.Item;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 7/20/2016.
 */
public class FeatCellRenderer extends JLabel implements ListCellRenderer<Feat>{
    public Component getListCellRendererComponent(
            JList<? extends Feat> list, Feat feat, int index, boolean isSelected, boolean cellHasFocus) {
        setText(feat.toString());

        try{
            if(Feats.getIcon(feat) != null){
                setIcon(new ImageIcon(Feats.getIcon(feat)));
            }
        } catch(Exception e){
            Pathfinder.showError("Error","I couldn't load this Feat image. It may be missing.\nRun in command for more details.");
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
