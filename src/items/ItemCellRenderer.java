package src.items;

import src.Pathfinder;
import src.Character;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by Matthew on 7/19/2016.
 */
public class ItemCellRenderer extends JLabel implements ListCellRenderer<Item> {
    private boolean isInventory;
    private Character me;
    private JTextField amount;

    public ItemCellRenderer(boolean isInventory){
        this.isInventory = isInventory;
    }

    public ItemCellRenderer(boolean isInventory, Character me){
        this.isInventory = isInventory;
        this.me = me;
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

        JPanel toReturn = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        toReturn.add(this, c);

        if(me != null){
            if(isInventory){
                amount = new JTextField(me.inventory.containsKey(item) ? Integer.toString(me.inventory.get(item)) : "0");
                amount.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        try{
                            me.inventory.put((GenItem)item, Integer.parseInt(amount.getText()));
                        } catch (NumberFormatException ex){

                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        try{
                            me.inventory.put((GenItem)item, Integer.parseInt(amount.getText()));
                        } catch (NumberFormatException ex){

                        }
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {}
                });
            } else {
                amount = new JTextField(Integer.toString(me.equipped.get(item)));
                amount.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        try{
                            me.equipped.put((GenItem)item, Integer.parseInt(amount.getText()));
                        } catch (NumberFormatException ex){

                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        try{
                            me.equipped.put((GenItem)item, Integer.parseInt(amount.getText()));
                        } catch (NumberFormatException ex){

                        }
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {}
                });
            }

            c.gridx = 1;
            c.weightx = 0;
            c.ipadx = 20;
            amount.setHorizontalAlignment(SwingConstants.RIGHT);

            toReturn.add(amount, c);
        }

        return toReturn;
    }

    private boolean isInt(String str){
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
