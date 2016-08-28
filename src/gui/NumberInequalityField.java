package src.gui;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by Matthew on 8/1/2016.
 */
public class NumberInequalityField extends JPanel{
    public JFormattedTextField field;
    public JComboBox<String> inequality;

    public final int equalTo = 0;
    public final int greaterThan = 1;
    public final int lessThan = 2;

    public NumberInequalityField(){
        setLayout(new BorderLayout());
        field = new JFormattedTextField(NumberFormat.getIntegerInstance());
        inequality = new JComboBox<>(new String[]{"=",">","<"});
        inequality.setPreferredSize(new Dimension(40, inequality.getPreferredSize().height));
        add(field, BorderLayout.CENTER);
        add(inequality, BorderLayout.WEST);
    }

    public int getNumber(){
        return (int)((long)field.getValue());
    }

    public int getInequality(){
        String value = (String)inequality.getSelectedItem();
        if(value.equals("=")) return equalTo;
        if(value.equals(">")) return greaterThan;
        return lessThan;
    }

    public boolean numberSatisfies(int toCheck){
        int myNumber = getNumber();
        int modifier = getInequality();

        if(modifier == equalTo) return myNumber == toCheck;
        if(modifier == greaterThan) return toCheck > myNumber;
        return toCheck < myNumber;
    }

    public boolean numberSatisfies(double toCheck){
        int myNumber = getNumber();
        int modifier = getInequality();

        if(modifier == equalTo) return myNumber == toCheck;
        if(modifier == greaterThan) return toCheck > myNumber;
        return toCheck < myNumber;
    }

    public boolean isEmpty(){
        return field.getText().equals("") || field.getText().equals(" ");
    }

    public void setEditable(boolean value){
        field.setEditable(value);
    }
}
