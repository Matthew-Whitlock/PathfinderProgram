package src.items;

import src.Pathfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Matthew on 6/16/2016.
 */
public interface Item {
    int getMaxDex();
    int getACPen();
    int getACBoost();
    int[] cost();
    double weight();
    int speedChange(int initialSpeed);
    int getPurchaseAmount();
    String getItemName();

    String getFormattedDetails();
    String getInventoryLine();
    URL getIcon();

    static GenItem createNewItem(JFrame parent){
        AtomicBoolean itemMade = new AtomicBoolean(false);
        AtomicBoolean closed = new AtomicBoolean(false);
        JDialog itemCreator = new JDialog(parent, "Create a new Item");
        JPanel panel = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new GridBagLayout());
        JPanel bottom = new JPanel(new BorderLayout());
        JPanel middle = new JPanel(new BorderLayout());
        itemCreator.add(panel);
        panel.add(top, BorderLayout.NORTH);
        panel.add(bottom, BorderLayout.SOUTH);
        panel.add(middle, BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.weighty = 0;
        top.add(new JLabel("Name: "), c);
        JTextField name = new JTextField();
        c.gridx = 1;
        c.weightx = 1;
        c.gridwidth = 3;
        top.add(name, c);

        c.gridwidth = 1;
        c.gridy = 1;
        c.gridx = 0;
        c.weightx = 0;
        top.add(new JLabel("Platinum: "), c);
        c.gridy = 2;
        top.add(new JLabel("Gold"), c);
        c.gridx = 2;
        top.add(new JLabel("Copper: "), c);
        c.gridy = 1;
        top.add(new JLabel("Silver: "), c);
        c.weightx = 1;
        c.gridx = 1;
        JTextField platinum = new JTextField("0");
        JTextField gold = new JTextField("0");
        JTextField silver = new JTextField("0");
        JTextField copper = new JTextField("0");
        top.add(platinum, c);
        c.gridy = 2;
        top.add(gold, c);
        c.gridx = 3;
        top.add(copper, c);
        c.gridx = 1;
        top.add(silver, c);

        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0;
        top.add(new JLabel("Amount per purchase: "), c);

        JTextField amount = new JTextField("1");
        c.weightx = 1;
        c.gridx = 1;
        top.add(amount, c);

        c.gridx = 2;
        c.weightx = 0;
        top.add(new JLabel(" Weight: "), c);

        JTextField weight = new JTextField("0.0");
        c.gridx = 3;
        c.weightx = 1;
        top.add(weight, c);

        middle.add(new JLabel("Item details (supports HTML formatting): "), BorderLayout.NORTH);


        JTextArea description = new JTextArea();
        JScrollPane descScroll = new JScrollPane(description);
        middle.add(descScroll, BorderLayout.CENTER);

        JButton add = new JButton("Add this item");
        JButton addAndSave = new JButton("Add and save this item");

        bottom.add(addAndSave, BorderLayout.EAST);
        bottom.add(add, BorderLayout.CENTER);

        add.addActionListener(e -> {
            if(!(name.getText().equals(""))){
                itemMade.set(true);
            } else {
                Pathfinder.showError("Not enough details","You must write an item name.");
            }
        });

        addAndSave.addActionListener(e -> {
            if(!(name.getText().equals(""))){
                Item item = new GenItem(name.getText(), description.getText(), new int[]{Integer.parseInt(platinum.getText()),Integer.parseInt(gold.getText()),Integer.parseInt(silver.getText()),Integer.parseInt(copper.getText())}, Integer.parseInt(amount.getText()), Double.parseDouble(weight.getText()));
                JFileChooser saver = new JFileChooser();
                int returned = saver.showSaveDialog(itemCreator);
                if(returned == JFileChooser.APPROVE_OPTION){
                    try{
                        FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
                        ObjectOutputStream out= new ObjectOutputStream(fileOut);
                        out.writeObject(item);
                        itemMade.set(true);
                    } catch (FileNotFoundException ex){
                        Pathfinder.showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
                        ex.printStackTrace();
                    } catch (IOException ex){
                        Pathfinder.showError("Unknown Exception","The file could not be saved.\nRun this in command for more information.");
                        ex.printStackTrace();
                    }
                }
            } else {
                Pathfinder.showError("Not enough details","You must write an item name.");
            }
        });

        itemCreator.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed.set(true);
                itemMade.set(true);
            }
        });

        itemCreator.setSize(350,400);
        itemCreator.setLocationRelativeTo(Pathfinder.FRAME);
        itemCreator.setVisible(true);

        while(!itemMade.get()){}

        itemCreator.dispose();

        if(closed.get()) return null;
        return new GenItem(name.getText(), description.getText(), new int[]{Integer.parseInt(platinum.getText()),Integer.parseInt(gold.getText()),Integer.parseInt(silver.getText()),Integer.parseInt(copper.getText())}, Integer.parseInt(amount.getText()), Double.parseDouble(weight.getText()));
    }

    static void showItemDetails(Item item){
        JFrame detailsFrame = new JFrame(item.toString());
        detailsFrame.setSize(450,550);
        JPanel detailsPanel = new JPanel(new BorderLayout());
        JEditorPane text = new JEditorPane("text/html","<html>" + item.getFormattedDetails() + "</html>");
        text.setEditable(false);
        JScrollPane scrollingText = new JScrollPane(text);
        scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        detailsFrame.add(detailsPanel);
        detailsPanel.add(scrollingText);
        detailsFrame.setLocationRelativeTo(Pathfinder.FRAME);
        detailsFrame.setVisible(true);
    }
}