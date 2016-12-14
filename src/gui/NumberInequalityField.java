package src.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collection;

/**
 * Created by Matthew on 8/1/2016.
 */
public class NumberInequalityField extends JPanel{
    public JFormattedTextField field;
    public JComboBox<String> inequality;

    public final int EQUAL_TO = 0;
    public final int GREATER_THAN = 1;
    public final int LESS_THAN = 2;

    public NumberInequalityField(){
        setLayout(new BorderLayout());
        field = new JFormattedTextField(NumberFormat.getIntegerInstance());
        field.setFocusLostBehavior(JFormattedTextField.PERSIST);
        inequality = new JComboBox<>(new String[]{"=",">","<"});
        inequality.setPreferredSize(new Dimension(40, inequality.getPreferredSize().height));
        add(field, BorderLayout.CENTER);
        add(inequality, BorderLayout.WEST);
    }

    //It was setting the caret at the beginning of the field, which is awkward and weird. This fixes it.
    @Override
    protected void processFocusEvent(FocusEvent e){
        super.processFocusEvent(e);
        if(e.getID() == FocusEvent.FOCUS_GAINED) field.setCaretPosition(field.getText().length());
    }

    public int getNumber(){

        try {
            field.commitEdit();
        } catch (ParseException e){
            e.printStackTrace();
        }

        return (int)((long)field.getValue());
    }

    public int getInequality(){
        String value = (String)inequality.getSelectedItem();
        if(value.equals("=")) return EQUAL_TO;
        if(value.equals(">")) return GREATER_THAN;
        return LESS_THAN;
    }

    public boolean numberSatisfies(int toCheck){
        int myNumber = getNumber();
        int modifier = getInequality();

        if(modifier == EQUAL_TO) return myNumber == toCheck;
        if(modifier == GREATER_THAN) return toCheck > myNumber;
        return toCheck < myNumber;
    }

    public boolean numberSatisfies(double toCheck){
        int myNumber = getNumber();
        int modifier = getInequality();

        if(modifier == EQUAL_TO) return myNumber == toCheck;
        if(modifier == GREATER_THAN) return toCheck > myNumber;
        return toCheck < myNumber;
    }

    public boolean anySatisfies(int[] toCheck){
        for(int i : toCheck){
            if(numberSatisfies(i)) return true;
        }
        return false;
    }

    public boolean anySatisfiesExcept(int[] toCheck, int toIgnore){
        for(int i : toCheck){
            if(i == toIgnore) continue;
            if(numberSatisfies(i)) return true;
        }
        return false;
    }

    public boolean anySatisfiesExcept(Collection<Integer> toCheck, int toIgnore){
        for(int i : toCheck){
            if(i == toIgnore) continue;
            if(numberSatisfies(i)) return true;
        }
        return false;
    }

    public boolean anySatisfies(Collection<Integer> toCheck){
        for(int i : toCheck){
            if(numberSatisfies(i)) return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return field.getText().equals("") || field.getText().equals(" ");
    }

    public void setEditable(boolean value){
        field.setEditable(value);
    }
}
