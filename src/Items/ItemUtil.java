package src.items;

import src.Pathfinder;
import src.gui.SelectionUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * Created by Matthew on 6/19/2016.
 */
public class ItemUtil {
    public static List<GenItem> getItems(){
        ArrayList<GenItem> items = new ArrayList<>();
        items.addAll(getBaseItems().stream().map(item -> new GenItem(item)).collect(Collectors.toList()));
        return items;
    }

    public static List<Item> getBaseItems(){
        ArrayList<Item> items = new ArrayList<>();

        for(WeaponEnum item : WeaponEnum.values()) items.add(item);
        for(ArmorEnum item : ArmorEnum.values()) items.add(item);
        for(AdventureGearEnum item : AdventureGearEnum.values()) items.add(item);
        items.addAll(getMagicItems());

        return items;
    }

    public static List<MagicItem> getMagicItems(){
        BufferedReader input = new BufferedReader(new InputStreamReader(ItemUtil.class.getResourceAsStream("/src/databases/Items.txt")));

        ArrayList<MagicItem> magicItems = new ArrayList<>();

        if (input == null) {
            return magicItems;
        }

        MagicItem magicItem;

        try{
            String magicItemInputString = input.readLine();

            while((magicItemInputString = input.readLine()) != null){
                try{
                    magicItem = new MagicItem(magicItemInputString);
                    magicItems.add(magicItem);
                } catch(Exception e){
                    Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
                    e.printStackTrace();
                    System.out.println(Arrays.asList(magicItemInputString.split("\t")));
                }
            }
        }catch(Exception e){
            Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nSome magic items may not be shown.");
            e.printStackTrace();
            return Collections.emptyList();
        }

        return magicItems;

    }

    public static GenItem createNewItem(Window parent){
        AtomicBoolean itemMade = new AtomicBoolean(false);
        AtomicBoolean closed = new AtomicBoolean(false);

        JDialog itemCreator = new JDialog(parent, "Create a new Item");
        JPanel panel = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new GridBagLayout());
        JPanel bottom = new JPanel(new GridBagLayout());
        JPanel middle = new JPanel(new BorderLayout());
        itemCreator.add(panel);
        panel.add(top, BorderLayout.NORTH);
        panel.add(bottom, BorderLayout.SOUTH);
        panel.add(middle, BorderLayout.CENTER);


        //Top section

        //Format for HTML to get it to auto-format that single line into proper HTML format, then format back to plain text to enable HTML editing.
        JEditorPane description = new JEditorPane();
        description.setContentType("text/plain");

        JTextField copper = new JTextField("0");
        JTextField gold = new JTextField("0");
        JTextField acMod = new JTextField("0");
        JTextField acPen = new JTextField("0");
        JTextField maxDex = new JTextField("-1");
        JTextField amount = new JTextField("1");
        JTextField name = new JTextField();
        JTextField weight = new JTextField("0");

        JLabel image = new JLabel();
        int imageWidth = 40;
        int imageHeight = 40;
        StringBuilder imageLocation = new StringBuilder();
        try{
            image.setIcon(new ImageIcon(ImageIO.read(ItemUtil.class.getResource("/src/pictures/RaceImages/Default.png")).getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
        } catch (IOException e){
            image.setMinimumSize(new Dimension(imageWidth, imageHeight));
            image.setPreferredSize(new Dimension(imageWidth, imageHeight));
        }

        JButton changeImage = new JButton("Change Image");
        changeImage.setMinimumSize(new Dimension(0, (int)changeImage.getMinimumSize().getHeight()));
        changeImage.setPreferredSize(new Dimension(0, (int)changeImage.getPreferredSize().getHeight()));
        changeImage.addActionListener(e -> {
            String newFile = Pathfinder.getImageOverrideLocation();
            if(!newFile.equals("")) {
                imageLocation.setLength(0);
                imageLocation.append(newFile);
            }
            try{
                File file = new File(imageLocation.toString());
                image.setIcon(new ImageIcon(ImageIO.read(file).getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
            } catch (IOException ex){
                image.setMinimumSize(new Dimension(imageWidth, imageHeight));
                image.setPreferredSize(new Dimension(imageWidth, imageHeight));
                imageLocation.setLength(0);
                Pathfinder.showError("IO Exception", "Could not load specified image");
            }
        });

        List<Item> allItems = getBaseItems();
        List<GenItem> allGenItems = allItems.stream().map(item -> new GenItem(item)).collect(Collectors.toList());
        JComboBox<Item> baseItems = new JComboBox<>(new Vector<>(allItems));
        baseItems.setMinimumSize(new Dimension(50, (int)baseItems.getMinimumSize().getHeight()));
        baseItems.setPreferredSize(new Dimension(50, (int)baseItems.getPreferredSize().getHeight()));
        baseItems.setToolTipText("This is what your item will search as.");
        baseItems.addActionListener(e -> {
            Item baseItem = ((Item)baseItems.getSelectedItem());

            if(imageLocation.length() == 0){
                try{
                    image.setIcon(new ImageIcon(ImageIO.read(baseItem.getIcon()).getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
                } catch (IOException ex){
                    image.setMinimumSize(new Dimension(imageWidth, imageHeight));
                    image.setPreferredSize(new Dimension(imageWidth, imageHeight));
                }
            }

            name.setText( baseItem.getItemName() );
            acPen.setText( Integer.toString(baseItem.getACPen()) );
            acMod.setText( Integer.toString(baseItem.getACBoost()) );
            maxDex.setText( Integer.toString(baseItem.getMaxDex()) );
            amount.setText( Integer.toString(baseItem.getPurchaseAmount()) );
            weight.setText( Double.toString(baseItem.weight()) );
            gold.setText( Integer.toString(baseItem.cost()[0]*10 + baseItem.cost()[1]) );
            copper.setText( Integer.toString(baseItem.cost()[2]*10 + baseItem.cost()[3]) );


            //Format for HTML to get it to auto-format that single line into proper HTML format, then format back to plain text to enable HTML editing.
            description.setContentType("text/html");
            description.setText(baseItem.getFormattedDetails());
            String tempString = description.getText();
            description.setContentType("text/plain");
            description.setText(tempString);
            description.setCaretPosition(0);
        });

        JButton search = new JButton("Search for Base Item");
        search.setMinimumSize(new Dimension(0, (int)search.getMinimumSize().getHeight()));
        search.setPreferredSize(new Dimension(0, (int)search.getPreferredSize().getHeight()));
        search.addActionListener(e -> {
            new Thread(){
                public void run(){
                    List<GenItem> returned = (SelectionUtils.searchItems(allGenItems, itemCreator, "Search for Base Item"));
                    if(returned.size() > 0){
                        Item baseItem = returned.get(0).baseItem();
                        if(baseItem != null) baseItems.setSelectedItem(baseItem);
                        itemCreator.repaint();
                    }
                }
            }.start();
        });

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 0;
        top.add(baseItems, c);

        c.gridwidth = 1;
        c.gridx = 3;
        top.add(search, c);

        c.gridy++;
        top.add(name, c);
        c.gridy++;
        top.add(acPen, c);
        c.gridy++;
        top.add(acMod, c);
        c.gridy++;
        top.add(maxDex, c);
        c.gridy++;
        c.gridx = 1;
        top.add(amount, c);
        c.gridx = 3;
        top.add(weight, c);
        c.gridy++;
        top.add(copper, c);
        c.gridx = 1;
        top.add(gold, c);

        c.weightx = 0;
        c.gridy = 0;
        c.gridx = 0;
        JLabel baseItemLabel = new JLabel("Base Item: ");
        baseItemLabel.setToolTipText("This is what your item will search as.");
        top.add(baseItemLabel, c);
        c.gridx = 2;
        c.gridy++;
        top.add(new JLabel("Name: "), c);
        c.gridy++;
        top.add(new JLabel("AC Penalty: "), c);
        c.gridy++;
        top.add(new JLabel("AC Bonus: "), c);
        c.gridy++;
        top.add(new JLabel("Max Dex Mod: "), c);
        c.gridy++;
        top.add(new JLabel("Weight: "), c);
        c.gridx = 0;
        top.add(new JLabel("Purchase Amt: "), c);
        c.gridy++;
        top.add(new JLabel("Gold: "), c);
        c.gridx = 2;
        top.add(new JLabel("Copper: "), c);

        c.gridy = 1;
        c.gridx = 0;
        c.gridheight = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.NONE;
        top.add(image, c);

        c.gridheight = 1;
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        top.add(changeImage, c);

        //Middle section
        middle.add(new JLabel("Item details (supports HTML formatting): "), BorderLayout.NORTH);


        JScrollPane descScroll = new JScrollPane(description);
        middle.add(descScroll, BorderLayout.CENTER);

        JButton add = new JButton("Add this item");
        JButton addAndSave = new JButton("Add and save this item");

        add.setMinimumSize(new Dimension(20, (int)add.getMinimumSize().getHeight()));
        add.setPreferredSize(new Dimension(20, (int)add.getPreferredSize().getHeight()));
        addAndSave.setMinimumSize(new Dimension(20, (int)addAndSave.getMinimumSize().getHeight()));
        addAndSave.setPreferredSize(new Dimension(20, (int)addAndSave.getPreferredSize().getHeight()));

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;

        c.gridx = 0;
        bottom.add(add, c);
        c.gridx = 1;
        bottom.add(addAndSave, c);

        add.addActionListener(e -> {

            Item baseItem = (Item)baseItems.getSelectedItem();

            if(name.getText().length() < 1){
                Pathfinder.showError("Invalid Name", "Items must have a name.");
                return;
            }

            try{
                int acPenalty = Integer.parseInt(acPen.getText());
            } catch (NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for AC Penalty is not a number.");
                return;
            }

            try{
                int acBonus = Integer.parseInt(acMod.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for AC Bonus is not a number.");
                return;
            }

            try{
                int maxDexterity = Integer.parseInt(maxDex.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Max Dex Mod is not a number.");
                return;
            }

            try{
                int amountPer = Integer.parseInt(amount.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Purchase Amount is not a number.");
                return;
            }

            try{
                double weightValue = Double.parseDouble(weight.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Weight is not a number.");
                return;
            }

            try{
                int goldCost = Integer.parseInt(gold.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Gold Cost is not a number.");
                return;
            }

            try{
                int copperCost = Integer.parseInt(copper.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Copper Cost is not a number.");
                return;
            }

            try{
                URL imageURL = imageLocation.length() > 0 ? new URL(imageLocation.toString()) : baseItem.getIcon();
            } catch (MalformedURLException ex){
                Pathfinder.showError("Malformed URL Exception", "Error saving image location with item.");
                return;
            }

            itemMade.set(true);
        });

        addAndSave.addActionListener(e -> {

            Item baseItem = (Item)baseItems.getSelectedItem();

            String nameValue = name.getText();
            if(nameValue.length() < 1){
                Pathfinder.showError("Invalid Name", "Items must have a name.");
                return;
            }

            int acPenalty = 0;
            try{
                acPenalty = Integer.parseInt(acPen.getText());
            } catch (NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for AC Penalty is not a number.");
                return;
            }

            int acBonus = 0;
            try{
                acBonus = Integer.parseInt(acMod.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for AC Bonus is not a number.");
                return;
            }

            int maxDexterity = -1;
            try{
                maxDexterity = Integer.parseInt(maxDex.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Max Dex Mod is not a number.");
                return;
            }

            int amountPer = 1;
            try{
                amountPer = Integer.parseInt(amount.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Purchase Amount is not a number.");
                return;
            }

            double weightValue = 0;
            try{
                weightValue = Double.parseDouble(weight.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Weight is not a number.");
                return;
            }

            int goldCost = 0;
            try{
                goldCost = Integer.parseInt(gold.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Gold Cost is not a number.");
                return;
            }

            int copperCost = 0;
            try{
                copperCost = Integer.parseInt(copper.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Copper Cost is not a number.");
                return;
            }

            URL imageURL = null;
            try{
                imageURL = imageLocation.length() > 0 ? new URL(imageLocation.toString()) : baseItem.getIcon();
            } catch (MalformedURLException ex){
                Pathfinder.showError("Malformed URL Exception", "Error saving image location with item.");
                return;
            }


            GenItem item = null;
            //public GenItem(Item item, String name, int acPenalty, int acBonus, int maxDex, int amountPerPurchase, double weight, int[] cost, String description, URL image)
            if(baseItem != null){
                item = new GenItem(baseItem, nameValue, acPenalty, acBonus, maxDexterity, amountPer, weightValue, new int[]{0, goldCost, 0, copperCost}, description.getText(), imageURL);
            } else {
                item = new GenItem(nameValue, acPenalty, acBonus, maxDexterity, amountPer, weightValue, new int[]{0, goldCost, 0, copperCost}, description.getText(), imageURL);
            }


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
        });

        itemCreator.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed.set(true);
                itemMade.set(true);
            }
        });

        itemCreator.setSize(500,400);
        itemCreator.setLocationRelativeTo(Pathfinder.FRAME);
        itemCreator.setVisible(true);

        while(!itemMade.get()){}

        itemCreator.dispose();

        if(closed.get()) return null;

        Item baseItem = (Item)baseItems.getSelectedItem();
        String nameValue = name.getText();
        int acPenalty = Integer.parseInt(acPen.getText());
        int acBonus = Integer.parseInt(acMod.getText());
        int maxDexterity = Integer.parseInt(maxDex.getText());
        int amountPer = Integer.parseInt(amount.getText());
        double weightValue = Double.parseDouble(weight.getText());
        int goldCost = Integer.parseInt(gold.getText());
        int copperCost = Integer.parseInt(copper.getText());
        URL imageURL = null;
        try{
            imageURL = imageLocation.length() > 0 ? new URL(imageLocation.toString()) : baseItem.getIcon();
        } catch (MalformedURLException ex){

        }


        GenItem item = null;
        //public GenItem(Item item, String name, int acPenalty, int acBonus, int maxDex, int amountPerPurchase, double weight, int[] cost, String description, URL image)
        if(baseItem != null){
            item = new GenItem(baseItem, nameValue, acPenalty, acBonus, maxDexterity, amountPer, weightValue, new int[]{0, goldCost, 0, copperCost}, description.getText(), imageURL);
        } else {
            item = new GenItem(nameValue, acPenalty, acBonus, maxDexterity, amountPer, weightValue, new int[]{0, goldCost, 0, copperCost}, description.getText(), imageURL);
        }

        return item;
    }

    public static void showItemDetails(Item item, List<GenItem> collection1, List<GenItem> collection2, boolean replace, JComponent toRepaint){
        JFrame detailsFrame = new JFrame(item.toString());
        detailsFrame.setSize(450,550);

        JPanel detailsPanel = new JPanel(new BorderLayout());

        JEditorPane text = new JEditorPane("text/html","<html>" + item.getFormattedDetails() + "</html>");
        text.setEditable(false);
        text.setCaretPosition(0);

        JScrollPane scrollingText = new JScrollPane(text);
        scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton edit = new JButton("Edit this item");
        edit.addActionListener(e -> {
            new Thread(){
                public void run(){
                    detailsFrame.setEnabled(false);
                    GenItem newItem = editItem(item instanceof GenItem ? (GenItem)item : new GenItem(item), detailsFrame);
                    if(newItem != null){
                        if(replace) {
                            collection1.set(collection1.indexOf(item), newItem);
                            if(collection2 != null) collection2.set(collection2.indexOf(item), newItem);
                        }
                        else {
                            collection1.add(newItem);
                            if(collection2 != null) collection2.add(newItem);
                        }


                        if(toRepaint != null) toRepaint.repaint();

                        detailsFrame.dispose();
                        showItemDetails(newItem, collection1, collection2, replace, toRepaint);
                    } else {
                        detailsFrame.setEnabled(true);
                    }
                }
            }.start();
        });

        detailsPanel.add(scrollingText, BorderLayout.CENTER);
        detailsPanel.add(edit, BorderLayout.SOUTH);

        detailsFrame.add(detailsPanel);
        detailsFrame.setLocationRelativeTo(Pathfinder.FRAME);
        detailsFrame.setVisible(true);
    }

    public static void showItemDetails(Item item, src.Character me, boolean equipped, JComponent toRepaint){
        JFrame detailsFrame = new JFrame(item.toString());
        detailsFrame.setSize(450,550);

        JPanel detailsPanel = new JPanel(new BorderLayout());

        JEditorPane text = new JEditorPane("text/html","<html>" + item.getFormattedDetails() + "</html>");
        text.setEditable(false);

        JScrollPane scrollingText = new JScrollPane(text);
        scrollingText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton edit = new JButton("Edit this item");
        edit.addActionListener(e -> {
            new Thread(){
                public void run(){
                    detailsFrame.setEnabled(false);
                    GenItem newItem = editItem(item instanceof GenItem ? (GenItem)item : new GenItem(item), detailsFrame);
                    if(newItem != null){
                        if(equipped){
                            me.equipped.put(newItem, me.equipped.get(item));
                            me.equipped.remove(item);
                        } else {
                            me.inventory.put(newItem, me.inventory.get(item));
                            me.inventory.remove(item);
                        }

                        if(toRepaint != null) toRepaint.repaint();

                        detailsFrame.dispose();
                        showItemDetails(newItem, me, equipped, toRepaint);
                    } else {
                        detailsFrame.setEnabled(true);
                    }
                }
            }.start();
        });

        detailsPanel.add(scrollingText, BorderLayout.CENTER);
        detailsPanel.add(edit, BorderLayout.SOUTH);

        detailsFrame.add(detailsPanel);
        detailsFrame.setLocationRelativeTo(Pathfinder.FRAME);
        detailsFrame.setVisible(true);
    }

    public static GenItem editItem(GenItem item, Window parent){
        AtomicBoolean itemMade = new AtomicBoolean(false);
        AtomicBoolean closed = new AtomicBoolean(false);

        JDialog itemCreator = new JDialog(parent, "Edit Item");
        JPanel panel = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new GridBagLayout());
        JPanel bottom = new JPanel(new GridBagLayout());
        JPanel middle = new JPanel(new BorderLayout());
        itemCreator.add(panel);
        panel.add(top, BorderLayout.NORTH);
        panel.add(bottom, BorderLayout.SOUTH);
        panel.add(middle, BorderLayout.CENTER);


        //Top section


        //Format for HTML to get it to auto-format that single line into proper HTML format, then format back to plain text to enable HTML editing.
        JEditorPane description = new JEditorPane();
        description.setContentType("text/html");
        description.setText(item.getFormattedDetails());
        description.setCaretPosition(0);
        String tempString = description.getText();
        description.setContentType("text/plain");
        description.setText(tempString);

        JTextField copper = new JTextField(Integer.toString(item.cost()[3] + item.cost()[2]*10));
        JTextField gold = new JTextField(Integer.toString(item.cost()[1] + item.cost()[0]*10));
        JTextField acMod = new JTextField(Integer.toString(item.getACBoost()));
        JTextField acPen = new JTextField(Integer.toString(item.getACPen()));
        JTextField maxDex = new JTextField(Integer.toString(item.getMaxDex()));
        JTextField amount = new JTextField(Integer.toString(item.getPurchaseAmount()));
        JTextField name = new JTextField(item.getItemName());
        JTextField weight = new JTextField(Double.toString(item.weight()));

        JLabel image = new JLabel();
        int imageWidth = 40;
        int imageHeight = 40;
        StringBuilder imageLocation = new StringBuilder();
        try{
            image.setIcon(new ImageIcon(ImageIO.read(item.getIcon()).getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
        } catch (IOException e){
            image.setMinimumSize(new Dimension(imageWidth, imageHeight));
            image.setPreferredSize(new Dimension(imageWidth, imageHeight));
        }
        JButton changeImage = new JButton("Change Image");
        changeImage.setMinimumSize(new Dimension(0, (int)changeImage.getMinimumSize().getHeight()));
        changeImage.setPreferredSize(new Dimension(0, (int)changeImage.getPreferredSize().getHeight()));
        changeImage.addActionListener(e -> {
            String newFile = Pathfinder.getImageOverrideLocation();
            if(!newFile.equals("")) {
                imageLocation.setLength(0);
                imageLocation.append(newFile);
            }
            try{
                File file = new File(imageLocation.toString());
                image.setIcon(new ImageIcon(ImageIO.read(file).getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
            } catch (IOException ex){
                image.setMinimumSize(new Dimension(imageWidth, imageHeight));
                image.setPreferredSize(new Dimension(imageWidth, imageHeight));
                imageLocation.setLength(0);
                Pathfinder.showError("IO Exception", "Could not load specified image");
            }
        });

        List<Item> allItems = getBaseItems();
        JComboBox<Item> baseItems = new JComboBox<>(new Vector<>(allItems));
        baseItems.setMinimumSize(new Dimension(50, (int)baseItems.getMinimumSize().getHeight()));
        baseItems.setPreferredSize(new Dimension(50, (int)baseItems.getPreferredSize().getHeight()));
        baseItems.setToolTipText("This is what your item will search as.");
        baseItems.setSelectedItem(item.baseItem());
        baseItems.addActionListener(e -> {
            baseItems.setSelectedItem(item.baseItem());
        });

        JButton search = new JButton("Search for Base Item");
        search.setMinimumSize(new Dimension(0, (int)search.getMinimumSize().getHeight()));
        search.setPreferredSize(new Dimension(0, (int)search.getPreferredSize().getHeight()));
        search.setEnabled(false);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 0;
        top.add(baseItems, c);

        c.gridwidth = 1;
        c.gridx = 3;
        top.add(search, c);

        c.gridy++;
        top.add(name, c);
        c.gridy++;
        top.add(acPen, c);
        c.gridy++;
        top.add(acMod, c);
        c.gridy++;
        top.add(maxDex, c);
        c.gridy++;
        c.gridx = 1;
        top.add(amount, c);
        c.gridx = 3;
        top.add(weight, c);
        c.gridy++;
        top.add(copper, c);
        c.gridx = 1;
        top.add(gold, c);

        c.weightx = 0;
        c.gridy = 0;
        c.gridx = 0;
        JLabel baseItemLabel = new JLabel("Base Item: ");
        baseItemLabel.setToolTipText("This is what your item will search as.");
        top.add(baseItemLabel, c);
        c.gridx = 2;
        c.gridy++;
        top.add(new JLabel("Name: "), c);
        c.gridy++;
        top.add(new JLabel("AC Penalty: "), c);
        c.gridy++;
        top.add(new JLabel("AC Bonus: "), c);
        c.gridy++;
        top.add(new JLabel("Max Dex Mod: "), c);
        c.gridy++;
        top.add(new JLabel("Weight: "), c);
        c.gridx = 0;
        top.add(new JLabel("Purchase Amt: "), c);
        c.gridy++;
        top.add(new JLabel("Gold: "), c);
        c.gridx = 2;
        top.add(new JLabel("Copper: "), c);

        c.gridy = 1;
        c.gridx = 0;
        c.gridheight = 3;
        c.gridwidth = 2;
        c.weightx = 1;
        c.fill = GridBagConstraints.NONE;
        top.add(image, c);

        c.gridheight = 1;
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        top.add(changeImage, c);

        //Middle section
        middle.add(new JLabel("Item details (supports HTML formatting): "), BorderLayout.NORTH);


        JScrollPane descScroll = new JScrollPane(description);
        middle.add(descScroll, BorderLayout.CENTER);

        JButton add = new JButton("Save");
        JButton addAndSave = new JButton("Save and save to file");

        add.setMinimumSize(new Dimension(20, (int)add.getMinimumSize().getHeight()));
        add.setPreferredSize(new Dimension(20, (int)add.getPreferredSize().getHeight()));
        addAndSave.setMinimumSize(new Dimension(20, (int)addAndSave.getMinimumSize().getHeight()));
        addAndSave.setPreferredSize(new Dimension(20, (int)addAndSave.getPreferredSize().getHeight()));

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;

        c.gridx = 0;
        bottom.add(add, c);
        c.gridx = 1;
        bottom.add(addAndSave, c);


        add.addActionListener(e -> {

            Item baseItem = (Item)baseItems.getSelectedItem();

            if(name.getText().length() < 1){
                Pathfinder.showError("Invalid Name", "Items must have a name.");
                return;
            }

            try{
                int acPenalty = Integer.parseInt(acPen.getText());
            } catch (NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for AC Penalty is not a number.");
                return;
            }

            try{
                int acBonus = Integer.parseInt(acMod.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for AC Bonus is not a number.");
                return;
            }

            try{
                int maxDexterity = Integer.parseInt(maxDex.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Max Dex Mod is not a number.");
                return;
            }

            try{
                int amountPer = Integer.parseInt(amount.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Purchase Amount is not a number.");
                return;
            }

            try{
                double weightValue = Double.parseDouble(weight.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Weight is not a number.");
                return;
            }

            try{
                int goldCost = Integer.parseInt(gold.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Gold Cost is not a number.");
                return;
            }

            try{
                int copperCost = Integer.parseInt(copper.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Copper Cost is not a number.");
                return;
            }

            try{
                URL imageURL = imageLocation.length() > 0 ? new URL(imageLocation.toString()) : baseItem.getIcon();
            } catch (MalformedURLException ex){
                Pathfinder.showError("Malformed URL Exception", "Error saving image location with item.");
                return;
            }

            itemMade.set(true);
        });

        addAndSave.addActionListener(e -> {

            Item baseItem = (Item)baseItems.getSelectedItem();

            String nameValue = name.getText();
            if(nameValue.length() < 1){
                Pathfinder.showError("Invalid Name", "Items must have a name.");
                return;
            }

            int acPenalty = 0;
            try{
                acPenalty = Integer.parseInt(acPen.getText());
            } catch (NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for AC Penalty is not a number.");
                return;
            }

            int acBonus = 0;
            try{
                acBonus = Integer.parseInt(acMod.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for AC Bonus is not a number.");
                return;
            }

            int maxDexterity = -1;
            try{
                maxDexterity = Integer.parseInt(maxDex.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Max Dex Mod is not a number.");
                return;
            }

            int amountPer = 1;
            try{
                amountPer = Integer.parseInt(amount.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Purchase Amount is not a number.");
                return;
            }

            double weightValue = 0;
            try{
                weightValue = Double.parseDouble(weight.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Weight is not a number.");
                return;
            }

            int goldCost = 0;
            try{
                goldCost = Integer.parseInt(gold.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Gold Cost is not a number.");
                return;
            }

            int copperCost = 0;
            try{
                copperCost = Integer.parseInt(copper.getText());
            } catch(NumberFormatException ex){
                Pathfinder.showError("Number Format Exception", "The value for Copper Cost is not a number.");
                return;
            }

            URL imageURL = null;
            try{
                imageURL = imageLocation.length() > 0 ? new URL(imageLocation.toString()) : baseItem.getIcon();
            } catch (MalformedURLException ex){
                Pathfinder.showError("Malformed URL Exception", "Error saving image location with item.");
                return;
            }


            GenItem temp = null;
            //public GenItem(Item item, String name, int acPenalty, int acBonus, int maxDex, int amountPerPurchase, double weight, int[] cost, String description, URL image)
            if(baseItem != null){
                temp = new GenItem(baseItem, nameValue, acPenalty, acBonus, maxDexterity, amountPer, weightValue, new int[]{0, goldCost, 0, copperCost}, description.getText(), imageURL);
            } else {
                temp = new GenItem(nameValue, acPenalty, acBonus, maxDexterity, amountPer, weightValue, new int[]{0, goldCost, 0, copperCost}, description.getText(), imageURL);
            }


            JFileChooser saver = new JFileChooser();
            int returned = saver.showSaveDialog(itemCreator);


            if(returned == JFileChooser.APPROVE_OPTION){
                try{
                    FileOutputStream fileOut = new FileOutputStream(saver.getSelectedFile());
                    ObjectOutputStream out= new ObjectOutputStream(fileOut);
                    out.writeObject(temp);
                    itemMade.set(true);
                } catch (FileNotFoundException ex){
                    Pathfinder.showError("File Not Found","The file cannot be saved to this location.\nYou either do not have permissions to save to this location, or the filename is invalid.");
                    ex.printStackTrace();
                } catch (IOException ex){
                    Pathfinder.showError("Unknown Exception","The file could not be saved.\nRun this in command for more information.");
                    ex.printStackTrace();
                }
            }
        });

        itemCreator.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closed.set(true);
                itemMade.set(true);
            }
        });

        itemCreator.setSize(500,400);
        itemCreator.setLocationRelativeTo(Pathfinder.FRAME);
        itemCreator.setVisible(true);

        while(!itemMade.get()){}

        itemCreator.dispose();

        if(closed.get()) return null;

        Item baseItem = (Item)baseItems.getSelectedItem();
        String nameValue = name.getText();
        int acPenalty = Integer.parseInt(acPen.getText());
        int acBonus = Integer.parseInt(acMod.getText());
        int maxDexterity = Integer.parseInt(maxDex.getText());
        int amountPer = Integer.parseInt(amount.getText());
        double weightValue = Double.parseDouble(weight.getText());
        int goldCost = Integer.parseInt(gold.getText());
        int copperCost = Integer.parseInt(copper.getText());
        URL imageURL = null;
        try{
            imageURL = imageLocation.length() > 0 ? new URL(imageLocation.toString()) : baseItem.getIcon();
        } catch (MalformedURLException ex){

        }


        GenItem toReturn = null;
        //public GenItem(Item item, String name, int acPenalty, int acBonus, int maxDex, int amountPerPurchase, double weight, int[] cost, String description, URL image)
        if(baseItem != null){
            toReturn = new GenItem(baseItem, nameValue, acPenalty, acBonus, maxDexterity, amountPer, weightValue, new int[]{0, goldCost, 0, copperCost}, description.getText(), imageURL);
        } else {
            toReturn = new GenItem(nameValue, acPenalty, acBonus, maxDexterity, amountPer, weightValue, new int[]{0, goldCost, 0, copperCost}, description.getText(), imageURL);
        }

        return toReturn;
    }
}