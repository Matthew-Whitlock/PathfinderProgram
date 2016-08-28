package src.items;

import src.Pathfinder;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matthew on 7/19/2016.
 */
public class ItemCellRenderer extends JLabel implements ListCellRenderer<Item> {
    private boolean isInventory;

    public ItemCellRenderer(boolean isInventory){
        this.isInventory = isInventory;
    }

    public Component getListCellRendererComponent(
            JList<? extends Item> list, Item item, int index, boolean isSelected, boolean cellHasFocus) {
        String s = isInventory ? item.getInventoryLine() : item.toString();
        setText(s);

        try{
            if(item.getIcon() != null){
                setIcon(new ImageIcon(item.getIcon()));
            }
        } catch(Exception e){
            Pathfinder.showError("Error","I couldn't load this Item image. It may be missing.\nRun in command for more details.");
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
