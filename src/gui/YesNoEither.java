package src.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Matthew on 12/12/2016.
 */
public class YesNoEither extends JPanel {
    private boolean value = true;
    private boolean set = false;
    private ArrayList<ActionListener> listeners = new ArrayList<>();

    public YesNoEither(boolean showText){
        setLayout(new GridBagLayout());
        JRadioButton yes = new JRadioButton(showText ? "Yes" : "");
        JRadioButton either = new JRadioButton(showText ? "Either" : "");
        JRadioButton no = new JRadioButton(showText ? "No" : "");

        ButtonGroup group = new ButtonGroup();
        group.add(yes);
        group.add(either);
        group.add(no);

        yes.addActionListener(e -> {
            value = true;
            set = true;
            fireActionEvent();
        });

        either.addActionListener(e -> {
            set = false;
            fireActionEvent();
        });

        no.addActionListener(e -> {
            value = false;
            set = true;
            fireActionEvent();
        });

        either.setSelected(true);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        add(no, c);
        c.gridx++;
        add(either, c);
        c.gridx++;
        add(yes, c);
    }

    public boolean value(){
        return value;
    }

    public boolean notEither(){
        return set;
    }

    public synchronized void addActionListener(ActionListener l){
        listeners.add(l);
    }

    public synchronized void removeActionListener(ActionListener l){
        listeners.remove(l);
    }

    private synchronized void fireActionEvent(){
        ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null);
        for(ActionListener l : listeners)
            l.actionPerformed(e);
    }
}
