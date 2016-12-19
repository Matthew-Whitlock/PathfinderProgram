package src.gui;

import src.Character;
import src.Pathfinder;
import src.classes.CharacterClass;
import src.feats.Feat;
import src.feats.FeatCellRenderer;
import src.feats.Feats;
import src.items.*;
import src.spells.Spell;
import src.spells.Spells;
import src.stats.Skill;
import src.stats.SkillUtils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * Created by Matthew on 6/30/2016.
 */
public class SelectionUtils {

    public static List<GenItem> searchItems(List<GenItem> items, Window parent, String title){
        JDialog searchDialog = new JDialog(parent, title);
        JPanel parentPanel = new JPanel(new GridBagLayout());

        AtomicBoolean selected = new AtomicBoolean(false);

        ArrayList<GenItem> results = new ArrayList<>();
        results.addAll(items);

        CardLayout searchConstraintsLayout = new CardLayout(){
            public Dimension preferredLayoutSize(Container parent) {
                Component current = findCurrentComponent(parent);
                if (current != null) {
                    Insets insets = parent.getInsets();
                    Dimension pref = current.getPreferredSize();
                    pref.width += insets.left + insets.right;
                    pref.height += insets.top + insets.bottom;
                    return pref;
                }
                return super.preferredLayoutSize(parent);
            }

            @Override
            public Dimension minimumLayoutSize(Container parent){
                Component current = findCurrentComponent(parent);
                if (current != null) {
                    Insets insets = parent.getInsets();
                    Dimension min = current.getMinimumSize();
                    min.width += insets.left + insets.right;
                    min.height += insets.top + insets.bottom;
                    return min;
                }
                return super.preferredLayoutSize(parent);
            }

            public Component findCurrentComponent(Container parent) {
                for (Component comp : parent.getComponents()) {
                    if (comp.isVisible()) {
                        return comp;
                    }
                }
                return null;
            }
        };

        JPanel searchConstraintsParent = new JPanel(searchConstraintsLayout);
        JPanel genItemSearch = new JPanel(new GridBagLayout());
        JPanel weaponSearch = new JPanel(new GridBagLayout());
        JPanel armorSearch = new JPanel(new GridBagLayout());
        JPanel adventureItemSearch = new JPanel(new GridBagLayout());
        JPanel magicItemSearch = new JPanel(new GridBagLayout());
        JScrollPane magicItemScroll = new JScrollPane(magicItemSearch);
        magicItemScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        magicItemScroll.setPreferredSize(new Dimension(0, 250));
        magicItemScroll.setMinimumSize(magicItemScroll.getPreferredSize());
        final String MAGIC_PANEL = "Magic Items";
        final String GEN_PANEL = "All Items";
        final String WEAPON_PANEL = "Base Weapons";
        final String ARMOR_PANEL = "Base Armor/Shields";
        final String ADVENTURE_PANEL = "Adventure Gear";
        final String[] PANEL_NAMES = new String[]{GEN_PANEL, WEAPON_PANEL, ARMOR_PANEL, MAGIC_PANEL, ADVENTURE_PANEL};
        searchConstraintsParent.add(genItemSearch, GEN_PANEL);
        searchConstraintsParent.add(weaponSearch, WEAPON_PANEL);
        searchConstraintsParent.add(armorSearch, ARMOR_PANEL);
        searchConstraintsParent.add(adventureItemSearch, ADVENTURE_PANEL);
        searchConstraintsParent.add(magicItemSearch, MAGIC_PANEL);

        //Set up parent panel
        JComboBox<String> searchType = new JComboBox<>(PANEL_NAMES);
        searchType.addActionListener(e -> searchConstraintsLayout.show(searchConstraintsParent, (String) searchType.getSelectedItem()));
        searchType.setSelectedIndex(0);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        parentPanel.add(new JLabel("Search these items as: "));
        c.gridx = 2;
        c.weightx = 1;
        parentPanel.add(searchType, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0;
        c.weightx = 1;
        c.gridwidth = 4;
        parentPanel.add(searchConstraintsParent, c);
        c.weighty = 1;

        JList<GenItem> resultsList = new JList<>();

        JScrollPane resultsScroll = new JScrollPane(resultsList){
            public void paintComponent(Graphics g){
                resultsList.setListData(results.toArray(new GenItem[results.size()]));
            }
        };

        resultsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    int length = items.size();
                    ItemUtil.showItemDetails(results.get(index), items, results, true, resultsScroll);
                    resultsScroll.repaint();
                }
            }
        });



        c.gridy = 2;
        parentPanel.add(resultsScroll, c);

        JButton select = new JButton("Select chosen item(s)");
        select.addActionListener(e -> selected.set(true));
        c.weighty = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.weightx = 1;
        parentPanel.add(select, c);

        c.gridwidth = 1;
        c.gridx = 2;
        c.weightx = 0.5;

        JButton load = new JButton("Load Item");
        parentPanel.add(load, c);
        load.addActionListener(e -> {
            JFileChooser loadChooser = new JFileChooser();
            int returned = loadChooser.showOpenDialog(searchDialog);
            if(returned == JFileChooser.APPROVE_OPTION){
                GenItem item = null;
                try{
                    FileInputStream fileIn = new FileInputStream(loadChooser.getSelectedFile());
                    ObjectInputStream objIn = new ObjectInputStream(fileIn);
                    item = (GenItem)(objIn.readObject());

                } catch (FileNotFoundException ex){
                    Pathfinder.showError("Could not load file","You may not have permissions to access the file.\nRun this in command for more details.");
                    ex.printStackTrace();
                } catch (IOException ex){
                    Pathfinder.showError("Unknown IO Exception","Run this in command for more details.");
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex){
                    Pathfinder.showError("Not an Item","It doesn't seem that there's an item saved in that file.\nThe file may be corrupt.");
                } catch (ClassCastException ex){
                    Pathfinder.showError("Not an Item", "It appears this is some other kind of Java object.");
                }
                if(item != null){
                    items.add(item);
                    results.add(item);
                    int[] current = resultsList.getSelectedIndices();
                    int[] newIndices = new int[current.length + 1];
                    for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                    newIndices[newIndices.length - 1] = results.size() - 1;
                    resultsList.setListData(results.toArray(new GenItem[items.size()]));
                    resultsList.setSelectedIndices(newIndices);

                    JScrollBar vertical = resultsScroll.getVerticalScrollBar();
                    vertical.setValue( vertical.getMaximum() );
                }
            }
        });


        c.gridx++;
        JButton create = new JButton("Create Item");
        parentPanel.add(create, c);
        create.addActionListener(e -> {
            (new Thread(){
                public void run(){
                    GenItem item = ItemUtil.createNewItem(searchDialog);
                    if(item != null){
                        items.add(item);
                        results.add(item);
                        int[] current = resultsList.getSelectedIndices();
                        int[] newIndices = new int[current.length + 1];
                        for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                        newIndices[newIndices.length - 1] = results.size() - 1;
                        resultsList.setListData(results.toArray(new GenItem[items.size()]));
                        resultsList.setSelectedIndices(newIndices);

                        JScrollBar vertical = resultsScroll.getVerticalScrollBar();
                        vertical.setValue( vertical.getMaximum() );
                    }
                }
            }).start();
        });



        //Start making individual search panels


        //Iterate through all items only once.
        HashSet<String> itemNames = new HashSet<>();

        HashSet<String> weaponNames = new HashSet<>();
        HashSet<String> weaponSources = new HashSet<>();
        weaponSources.add("");
        HashSet<String> weaponTypes = new HashSet<>();
        weaponTypes.add("");
        HashSet<String> weaponSubtypes = new HashSet<>();
        weaponSubtypes.add("");
        HashSet<String> damageTypes = new HashSet<>();
        damageTypes.add("");
        HashSet<String> weaponSpecials = new HashSet<>();
        weaponSpecials.add("");

        HashSet<String> armorNames = new HashSet<>();
        HashSet<String> armorTypes = new HashSet<>();
        armorTypes.add("");

        HashSet<String> magicNames = new HashSet<>();
        HashSet<String> magicAuraStrengthSet = new HashSet<>();
        magicAuraStrengthSet.add("");
        HashSet<String> magicAlignmentSet = new HashSet<>();
        magicAlignmentSet.add("");
        HashSet<String> magicCommunicationSet = new HashSet<>();
        magicCommunicationSet.add("");
        HashSet<String> magicScalingSet = new HashSet<>();
        magicScalingSet.add("");
        HashSet<String> magicGroupSet = new HashSet<>();
        magicGroupSet.add("");
        HashSet<String> magicSlotSet = new HashSet<>();
        magicSlotSet.add("");
        HashSet<String> magicSourceSet = new HashSet<>();
        magicSourceSet.add("");
        HashSet<String> magicPowerSet = new HashSet<>();
        magicPowerSet.add("");
        HashSet<String> magicSensesSet = new HashSet<>();
        magicSensesSet.add("");

        HashSet<String> gearNames = new HashSet<>();
        HashSet<String> gearTypes = new HashSet<>();
        gearTypes.add("");
        HashSet<String> gearSources = new HashSet<>();
        gearSources.add("");

        for(GenItem item : ItemUtil.getItems()){
            itemNames.add(item.getItemName());

            if(item.baseItem() instanceof WeaponEnum){
                WeaponEnum weapon = (WeaponEnum)item.baseItem();
                weaponNames.add(weapon.getItemName());
                weaponSources.add(weapon.source());
                weaponTypes.add(weapon.type());
                weaponSubtypes.add(weapon.subtype());
                String[] damageType = weapon.damageType().split(",");
                for(String s : damageType) {
                    String[] splitAgain = s.split(" or ");
                    for(String type : splitAgain){
                        String[] finalSplit = type.split(" and ");
                        for(String finalValue : finalSplit)
                            damageTypes.add(finalValue.trim());
                    }
                }
                String[] specials = weapon.special().split(",");
                for(String s : specials) weaponSpecials.add(s.trim().toLowerCase());
            } else if(item.baseItem() instanceof ArmorEnum){
                ArmorEnum armor = (ArmorEnum)item.baseItem();
                armorNames.add(armor.getItemName());
                armorTypes.add(armor.type());
            } else if(item.baseItem() instanceof MagicItem){
                MagicItem magic = (MagicItem)item.baseItem();
                magicNames.add(magic.getItemName());
                magicAuraStrengthSet.add(magic.auraStrength);
                magicAlignmentSet.add(magic.alignment);
                String[] communication = magic.senses.split(",|;|and");
                for(String s : communication)
                    magicCommunicationSet.add(s.trim());
                magicScalingSet.add(magic.scaling);
                String[] powers = magic.powers.split(",");
                for(String s : powers){
                    if(s.contains("(")) s = s.substring(0, s.indexOf("("));
                    magicPowerSet.add(s.replaceAll("[0-9]/day.", "").replace("[0-9]/day", "").trim());
                }
                String[] senses = magic.senses.split(",|;|and");
                for(String s : senses)
                    magicSensesSet.add(s.trim());
                magicGroupSet.add(magic.group);
                magicSlotSet.add(magic.slot);
                magicSourceSet.add(magic.source);
            } else if(item.baseItem() instanceof AdventureGearEnum){
                AdventureGearEnum gear = (AdventureGearEnum)item.baseItem();
                gearNames.add(gear.getItemName());
                gearTypes.add(gear.type());
                gearSources.add(gear.source());
            }
        }



        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.ipadx = 10;
        genItemSearch.add(new JLabel("Name: "), c);
        c.gridy = 1;
        genItemSearch.add(new JLabel("Cost (Gold only): "), c);
        c.gridy = 2;
        genItemSearch.add(new JLabel("Amount Per Purchase: "), c);
        c.gridy = 3;
        genItemSearch.add(new JLabel("Weight (lbs): "), c);
        c.gridy = 4;
        genItemSearch.add(new JLabel("Description Contains: "), c);

        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        AutofillTextArea genName = new AutofillTextArea(itemNames, 5);
        genItemSearch.add(genName, c);
        NumberInequalityField genCost = new NumberInequalityField();
        c.gridy = 1;
        genItemSearch.add(genCost, c);
        NumberInequalityField genAmount = new NumberInequalityField();
        c.gridy = 2;
        genItemSearch.add(genAmount, c);
        NumberInequalityField genWeight = new NumberInequalityField();
        c.gridy = 3;
        genItemSearch.add(genWeight, c);
        JTextField genDesc = new JTextField();
        c.gridy = 4;
        genItemSearch.add(genDesc, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        JButton genSearch = new JButton("Search with these values");
        genItemSearch.add(genSearch, c);

        genSearch.addActionListener(e -> {
            results.clear();
            results.addAll(items);

            ArrayList<GenItem> intermediary = new ArrayList<>();

            if(!genName.getText().equals("")){
                intermediary.addAll(results.stream().filter(item -> item.getItemName().toLowerCase().contains(genName.getText().toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!genCost.isEmpty()){
                intermediary.addAll(results.stream().filter(item -> genCost.numberSatisfies(item.cost()[1])).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!genAmount.isEmpty()){
                intermediary.addAll(results.stream().filter(item -> genAmount.numberSatisfies(item.getPurchaseAmount())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!genWeight.isEmpty()){
                intermediary.addAll(results.stream().filter(item -> genWeight.numberSatisfies(item.weight())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!genDesc.getText().equals("")){
                intermediary.addAll(results.stream().filter(item -> item.getItemName().toLowerCase().contains(genDesc.getText().toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            resultsScroll.repaint();
        });


        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 10;
        weaponSearch.add(new JLabel("Name: "), c);
        c.gridy = 1;
        weaponSearch.add(new JLabel("Cost (Gold): "), c);
        c.gridy = 2;
        weaponSearch.add(new JLabel("Weight (lbs): "), c);
        c.gridy = 3;
        weaponSearch.add(new JLabel("Weapon Type: "), c);
        c.gridy = 4;
        weaponSearch.add(new JLabel("Small DMG Roll: "), c);
        c.gridy = 5;
        weaponSearch.add(new JLabel("Min Crit Threat Roll:"), c);
        c.gridy = 6;
        weaponSearch.add(new JLabel("Damage Type: "), c);
        c.gridy = 7;
        weaponSearch.add(new JLabel("Description Contains: "), c);
        c.gridy = 0;
        c.gridx = 2;
        weaponSearch.add(new JLabel("Source: "), c);
        c.gridy = 1;
        weaponSearch.add(new JLabel("Amount per Purchase: "), c);
        c.gridy = 2;
        weaponSearch.add(new JLabel("Range (ft): "), c);
        c.gridy = 3;
        weaponSearch.add(new JLabel("Weapon Subtype: "), c);
        c.gridy = 4;
        weaponSearch.add(new JLabel("Medium DMG Roll: "), c);
        c.gridy = 5;
        weaponSearch.add(new JLabel("Crit Multiplier: "), c);
        c.gridy = 6;
        weaponSearch.add(new JLabel("Special: "), c);

        AutofillTextArea wepName = new AutofillTextArea(weaponNames, 5);
        JComboBox<String> wepSource = new JComboBox<>(new Vector<>(weaponSources));
        NumberInequalityField wepCost = new NumberInequalityField();
        NumberInequalityField wepAmount = new NumberInequalityField();
        NumberInequalityField wepWeight = new NumberInequalityField();
        NumberInequalityField wepRange = new NumberInequalityField();
        JComboBox<String> wepType = new JComboBox<>(new Vector<>(weaponTypes));
        JComboBox<String> wepSubtype = new JComboBox<>(new Vector<>(weaponSubtypes));
        JTextField wepSDMG = new JTextField();
        JTextField wepMDMG = new JTextField();
        JTextField wepMinThreat = new JTextField();
        NumberInequalityField wepCritMult = new NumberInequalityField();
        JComboBox<String> wepDMGType = new JComboBox<>(new Vector<>(damageTypes));
        JComboBox<String> wepSpecial = new JComboBox<>(new Vector<>(weaponSpecials));
        JTextField wepDesc = new JTextField();

        c.weightx = 1;
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 0;
        weaponSearch.add(wepName, c);
        c.gridy = 1;
        weaponSearch.add(wepCost, c);
        c.gridy = 2;
        weaponSearch.add(wepWeight, c);
        c.gridy = 3;
        weaponSearch.add(wepType, c);
        c.gridy = 4;
        weaponSearch.add(wepSDMG, c);
        c.gridy = 5;
        weaponSearch.add(wepMinThreat, c);
        c.gridy = 6;
        weaponSearch.add(wepDMGType, c);
        c.gridy = 0;
        c.gridx = 3;
        weaponSearch.add(wepSource, c);
        c.gridy = 1;
        weaponSearch.add(wepAmount, c);
        c.gridy = 2;
        weaponSearch.add(wepRange, c);
        c.gridy = 3;
        weaponSearch.add(wepSubtype, c);
        c.gridy = 4;
        weaponSearch.add(wepMDMG, c);
        c.gridy = 5;
        weaponSearch.add(wepCritMult, c);
        c.gridy = 6;
        weaponSearch.add(wepSpecial, c);
        c.gridy = 7;
        c.gridx = 1;
        c.gridwidth = 3;
        weaponSearch.add(wepDesc, c);

        JButton wepSearch = new JButton("Search with these values");
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 4;
        weaponSearch.add(wepSearch, c);
        wepSearch.addActionListener(e -> {
            results.clear();

            ArrayList<WeaponEnum> intermediary = new ArrayList<>();
            for(GenItem item : items){
                if(item.baseItem() instanceof WeaponEnum) intermediary.add((WeaponEnum)item.baseItem());
            }
            ArrayList<WeaponEnum> temp = new ArrayList<>();

            if(!wepName.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.getItemName().toLowerCase().contains(wepName.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)wepSource.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.source().toLowerCase().contains(((String)wepSource.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepCost.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> wepCost.numberSatisfies(item.cost()[1])).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepAmount.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> wepAmount.numberSatisfies(item.getPurchaseAmount())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepWeight.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> wepWeight.numberSatisfies(item.weight())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepRange.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> wepRange.numberSatisfies(item.range())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepMinThreat.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.minThreatRoll() == Integer.parseInt(wepMinThreat.getText())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepCritMult.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> wepCritMult.numberSatisfies(item.critMultiplier()[0])).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)wepType.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.type().toLowerCase().contains(((String)wepType.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)wepSubtype.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.subtype().toLowerCase().contains(((String)wepSubtype.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepSDMG.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.sDMG().toLowerCase().contains(wepSDMG.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepMDMG.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.mDMG().toLowerCase().contains(wepMDMG.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)wepDMGType.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.damageType().toLowerCase().contains(((String)wepDMGType.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)wepSpecial.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.special().toLowerCase().contains(((String)wepSpecial.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!wepDesc.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.getFormattedDetails().toLowerCase().contains(wepDesc.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            results.addAll(items.stream().filter(item -> intermediary.contains(item.baseItem())).collect(Collectors.toList()));
            resultsScroll.repaint();
        });

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 10;
        armorSearch.add(new JLabel("Name: "), c);
        c.gridy = 1;
        armorSearch.add(new JLabel("Cost (Gold): "), c);
        c.gridy = 2;
        armorSearch.add(new JLabel("Armor bonus: "), c);
        c.gridy = 3;
        armorSearch.add(new JLabel("Max Dex Modifier: "), c);
        c.gridy = 4;
        armorSearch.add(new JLabel("Speed change from 30: "), c);
        c.gridy = 5;
        armorSearch.add(new JLabel("Description Contains: "), c);
        c.gridx = 2;
        c.gridy = 0;
        armorSearch.add(new JLabel("Type: "), c);
        c.gridy = 1;
        armorSearch.add(new JLabel("Weight (lbs): "), c);
        c.gridy = 2;
        armorSearch.add(new JLabel("AC Penalty"), c);
        c.gridy = 3;
        armorSearch.add(new JLabel("Spell Fail Percentage: "), c);
        c.gridy = 4;
        armorSearch.add(new JLabel("Speed change from 20: "), c);

        AutofillTextArea armorName = new AutofillTextArea(armorNames, 5);
        JComboBox<String> armorType = new JComboBox<>(new Vector<>(armorTypes));
        armorType.setPreferredSize(new Dimension(0,armorType.getPreferredSize().height));
        NumberInequalityField armorCost = new NumberInequalityField();
        NumberInequalityField armorWeight = new NumberInequalityField();
        NumberInequalityField armorBonus = new NumberInequalityField();
        NumberInequalityField armorPenalty = new NumberInequalityField();
        NumberInequalityField armorMaxDex = new NumberInequalityField();
        NumberInequalityField armorSpellFail = new NumberInequalityField();
        NumberInequalityField armorSpeed30 = new NumberInequalityField();
        NumberInequalityField armorSpeed20 = new NumberInequalityField();
        JTextField armorDesc = new JTextField();

        c.ipadx = 0;
        c.gridy = 0;
        c.gridx = 1;
        c.weightx = 1;
        armorSearch.add(armorName, c);
        c.gridy = 1;
        armorSearch.add(armorCost, c);
        c.gridy = 2;
        armorSearch.add(armorBonus, c);
        c.gridy = 3;
        armorSearch.add(armorMaxDex, c);
        c.gridy = 4;
        armorSearch.add(armorSpeed30, c);
        c.gridy = 0;
        c.gridx = 3;
        armorSearch.add(armorType, c);
        c.gridy = 1;
        armorSearch.add(armorWeight, c);
        c.gridy = 2;
        armorSearch.add(armorPenalty, c);
        c.gridy = 3;
        armorSearch.add(armorSpellFail, c);
        c.gridy = 4;
        armorSearch.add(armorSpeed20, c);
        c.gridy = 5;
        c.gridx = 1;
        c.gridwidth = 3;
        armorSearch.add(armorDesc, c);

        JButton armorSearchButton = new JButton("Search with these values");
        c.gridy = 6;
        c.gridx = 0;
        c.gridwidth = 4;
        armorSearch.add(armorSearchButton, c);

        armorSearchButton.addActionListener(e -> {
            results.clear();

            ArrayList<ArmorEnum> intermediary = new ArrayList<>();
            for(GenItem item : items){
                if(item.baseItem() instanceof ArmorEnum) intermediary.add((ArmorEnum)item.baseItem());
            }
            ArrayList<ArmorEnum> temp = new ArrayList<>();

            if(!armorName.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.getItemName().toLowerCase().contains(armorName.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!armorType.getSelectedItem().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.type().toLowerCase().contains(((String)armorType.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!armorCost.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> armorCost.numberSatisfies(item.cost()[1])).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!armorWeight.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> armorWeight.numberSatisfies(item.weight())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!armorBonus.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> armorBonus.numberSatisfies(item.getACBoost())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!armorPenalty.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> armorPenalty.numberSatisfies(item.getACPen())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!armorMaxDex.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> armorMaxDex.numberSatisfies(item.getMaxDex())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!armorSpeed30.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> armorSpeed30.numberSatisfies(item.speedChange(30))).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!armorSpeed20.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> armorSpeed20.numberSatisfies(item.speedChange(20))).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }

            if(!armorDesc.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.getFormattedDetails().toLowerCase().contains(armorDesc.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }

            results.addAll(items.stream().filter(item -> intermediary.contains(item.baseItem())).collect(Collectors.toList()));
            resultsScroll.repaint();
        });

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 10;
        c.gridy = 0;

        magicItemSearch.add(new JLabel("Name: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Aura: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Aura Strength: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Cost (gold): "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Crafting Cost (gold): "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Weight (lbs): "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Base Item: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Caster Level: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Has Scaling: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Scaling: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Group: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Slot: "), c);
        c.gridy++;
        c.gridx = 2;
        c.gridy = 0;
        magicItemSearch.add(new JLabel("Is Alive: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Intelligence: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Wisdom: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Charisma: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Ego: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Alignment: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Communication: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Language: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Has Sense: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Has Power: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Source: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Description: "), c);

        AutofillTextArea magicName = new AutofillTextArea(magicNames, 5);
        JTextField magicAura = new JTextField();
        JComboBox<String> magicAuraStrength = new JComboBox<>(new Vector<>(magicAuraStrengthSet));
        magicAuraStrength.setMinimumSize(new Dimension(0, (int)magicAuraStrength.getMinimumSize().getHeight()));
        magicAuraStrength.setPreferredSize(new Dimension(0, (int)magicAuraStrength.getPreferredSize().getHeight()));
        NumberInequalityField magicCost = new NumberInequalityField();
        NumberInequalityField magicCraftingCost = new NumberInequalityField();
        NumberInequalityField magicWeight = new NumberInequalityField();
        JTextField magicBaseItem = new JTextField();
        NumberInequalityField magicCasterLevel = new NumberInequalityField();
        NumberInequalityField magicCha = new NumberInequalityField();
        magicCha.setEditable(false);
        NumberInequalityField magicInt = new NumberInequalityField();
        magicInt.setEditable(false);
        NumberInequalityField magicEgo = new NumberInequalityField();
        magicEgo.setEditable(false);
        NumberInequalityField magicWis = new NumberInequalityField();
        magicWis.setEditable(false);
        JComboBox<String> magicAlignment = new JComboBox<>(new Vector<>(magicAlignmentSet));
        magicAlignment.setMinimumSize(new Dimension(0, (int)magicAlignment.getMinimumSize().getHeight()));
        magicAlignment.setPreferredSize(new Dimension(0, (int)magicAlignment.getPreferredSize().getHeight()));
        JComboBox<String> magicCommunication = new JComboBox<>(new Vector<>(magicCommunicationSet));
        magicCommunication.setMinimumSize(new Dimension(0, (int)magicCommunication.getMinimumSize().getHeight()));
        magicCommunication.setPreferredSize(new Dimension(0, (int)magicCommunication.getPreferredSize().getHeight()));
        JComboBox<String> magicPowers = new JComboBox<>(new Vector<>(magicPowerSet));
        magicPowers.setMinimumSize(new Dimension(0, (int)magicPowers.getMinimumSize().getHeight()));
        magicPowers.setPreferredSize(new Dimension(0, (int)magicPowers.getPreferredSize().getHeight()));
        JComboBox<String> magicSenses = new JComboBox<>(new Vector<>(magicSensesSet));
        magicSenses.setMinimumSize(new Dimension(0, (int)magicSenses.getMinimumSize().getHeight()));
        magicSenses.setPreferredSize(new Dimension(0, (int)magicSenses.getPreferredSize().getHeight()));
        JTextField magicLanguage = new JTextField();
        magicLanguage.setEditable(false);
        JComboBox<String> magicScaling = new JComboBox<>(new Vector<>(magicScalingSet));
        magicScaling.setMinimumSize(new Dimension(0, (int)magicScaling.getMinimumSize().getHeight()));
        magicScaling.setPreferredSize(new Dimension(0, (int)magicScaling.getPreferredSize().getHeight()));
        JComboBox<String> magicGroup = new JComboBox<>(new Vector<>(magicGroupSet));
        magicGroup.setMinimumSize(new Dimension(0, (int)magicGroup.getMinimumSize().getHeight()));
        magicGroup.setPreferredSize(new Dimension(0, (int)magicGroup.getPreferredSize().getHeight()));
        JComboBox<String> magicSlot = new JComboBox<>(new Vector<>(magicSlotSet));
        magicSlot.setMinimumSize(new Dimension(0, (int)magicSlot.getMinimumSize().getHeight()));
        magicSlot.setPreferredSize(new Dimension(0, (int)magicSlot.getPreferredSize().getHeight()));
        JComboBox<String> magicSource = new JComboBox<>(new Vector<>(magicSourceSet));
        magicSource.setMinimumSize(new Dimension(0, (int)magicSource.getMinimumSize().getHeight()));
        magicSource.setPreferredSize(new Dimension(0, (int)magicSource.getPreferredSize().getHeight()));
        magicSource.setEditable(true);
        JTextField magicDesc = new JTextField();

        YesNoEither isAliveOptions = new YesNoEither(true);
        isAliveOptions.addActionListener( e -> {
            if(isAliveOptions.notEither() && isAliveOptions.value()){
                magicCha.setEditable(true);
                magicInt.setEditable(true);
                magicEgo.setEditable(true);
                magicWis.setEditable(true);
                magicAlignment.setEditable(true);
                magicCommunication.setEditable(true);
                magicPowers.setEditable(true);
                magicSenses.setEditable(true);
                magicLanguage.setEditable(true);
            } else {
                magicCha.setEditable(false);
                magicInt.setEditable(false);
                magicEgo.setEditable(false);
                magicWis.setEditable(false);
                magicAlignment.setEditable(false);
                magicCommunication.setEditable(false);
                magicPowers.setEditable(false);
                magicSenses.setEditable(false);
                magicLanguage.setEditable(false);
            }
        });


        YesNoEither hasScalingOptions = new YesNoEither(true);
        hasScalingOptions.addActionListener(e -> {
            magicScaling.setEditable(hasScalingOptions.notEither() && hasScalingOptions.value());
        });

        YesNoEither mythicBox = new YesNoEither(false);
        YesNoEither legendaryWeaponBox = new YesNoEither(false);
        YesNoEither illusionBox = new YesNoEither(false);
        YesNoEither universalBox = new YesNoEither(false);
        YesNoEither minorArtifactBox = new YesNoEither(false);
        YesNoEither majorArtifactBox = new YesNoEither(false);
        YesNoEither abjurationBox = new YesNoEither(false);
        YesNoEither conjurationBox = new YesNoEither(false);
        YesNoEither divinationBox = new YesNoEither(false);
        YesNoEither enchantmentBox = new YesNoEither(false);
        YesNoEither evocationBox = new YesNoEither(false);
        YesNoEither necromancyBox = new YesNoEither(false);
        YesNoEither transmutationBox = new YesNoEither(false);

        JPanel magicBoolPanel = new JPanel(new GridBagLayout());
        JScrollPane magicBoolScroll = new JScrollPane(magicBoolPanel);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.ipady = 1;
        magicBoolPanel.add(new JLabel("Mythic: "), c);
        c.gridy = 1;
        magicBoolPanel.add(new JLabel("Legendary Weapon: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Illusion: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Universal: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Minor Artifact: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Major Artifact: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Abjuration: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Conjuration: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Divination: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Enchantment: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Evocation: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Necromancy: "), c);
        c.gridy++;
        magicBoolPanel.add(new JLabel("Transmutation: "), c);
        c.gridy = 0;
        c.gridx = 1;
        c.weightx = 0;
        magicBoolPanel.add(mythicBox, c);
        c.gridy++;
        magicBoolPanel.add(legendaryWeaponBox, c);
        c.gridy++;
        magicBoolPanel.add(illusionBox, c);
        c.gridy++;
        magicBoolPanel.add(universalBox, c);
        c.gridy++;
        magicBoolPanel.add(minorArtifactBox, c);
        c.gridy++;
        magicBoolPanel.add(majorArtifactBox, c);
        c.gridy++;
        magicBoolPanel.add(abjurationBox, c);
        c.gridy++;
        magicBoolPanel.add(conjurationBox, c);
        c.gridy++;
        magicBoolPanel.add(divinationBox, c);
        c.gridy++;
        magicBoolPanel.add(enchantmentBox, c);
        c.gridy++;
        magicBoolPanel.add(evocationBox, c);
        c.gridy++;
        magicBoolPanel.add(necromancyBox, c);
        c.gridy++;
        magicBoolPanel.add(transmutationBox, c);

        c.gridx = 4;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 12;
        c.weightx = 0;
        c.weighty = 1;
        c.ipady = 0;
        c.fill = GridBagConstraints.BOTH;
        magicBoolScroll.setMinimumSize(new Dimension(200, 0));
        magicBoolScroll.setPreferredSize(magicBoolScroll.getMinimumSize());
        magicItemSearch.add(magicBoolScroll, c);

        c.weightx = 0.01;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        magicItemSearch.add(magicName, c);
        c.gridy++;
        magicItemSearch.add(magicAura, c);
        c.gridy++;
        magicItemSearch.add(magicAuraStrength, c);
        c.gridy++;
        magicItemSearch.add(magicCost, c);
        c.gridy++;
        magicItemSearch.add(magicCraftingCost, c);
        c.gridy++;
        magicItemSearch.add(magicWeight, c);
        c.gridy++;
        magicItemSearch.add(magicBaseItem, c);
        c.gridy++;
        magicItemSearch.add(magicCasterLevel, c);
        c.gridy++;
        magicItemSearch.add(hasScalingOptions, c);
        c.gridy++;
        magicItemSearch.add(magicScaling, c);
        c.gridy++;
        magicItemSearch.add(magicGroup, c);
        c.gridy++;
        magicItemSearch.add(magicSlot, c);
        c.gridy++;

        c.gridy = 0;
        c.gridx = 3;
        magicItemSearch.add(isAliveOptions, c);
        c.gridy++;
        magicItemSearch.add(magicInt, c);
        c.gridy++;
        magicItemSearch.add(magicWis, c);
        c.gridy++;
        magicItemSearch.add(magicCha, c);
        c.gridy++;
        magicItemSearch.add(magicEgo, c);
        c.gridy++;
        magicItemSearch.add(magicAlignment, c);
        c.gridy++;
        magicItemSearch.add(magicCommunication, c);
        c.gridy++;
        magicItemSearch.add(magicLanguage, c);
        c.gridy++;
        magicItemSearch.add(magicSenses, c);
        c.gridy++;
        magicItemSearch.add(magicPowers, c);
        c.gridy++;
        magicItemSearch.add(magicSource, c);
        c.gridy++;
        magicItemSearch.add(magicDesc, c);

        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 6;
        JButton magicSearch = new JButton("Search with these values");
        magicItemSearch.add(magicSearch, c);

        magicItemSearch.setPreferredSize(new Dimension(0, magicItemSearch.getPreferredSize().height));

        magicSearch.addActionListener(e -> {
            results.clear();

            ArrayList<MagicItem> intermediary = new ArrayList<>();
            for(GenItem item : items){
                if(item.baseItem() instanceof MagicItem) intermediary.add((MagicItem)item.baseItem());
            }
            ArrayList<MagicItem> temp = new ArrayList<>();

            if(!magicName.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.name.toLowerCase().contains(magicName.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!magicAura.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.aura.toLowerCase().contains(magicAura.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)magicAuraStrength.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.auraStrength.toLowerCase().contains(((String)magicAuraStrength.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!magicCost.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> magicCost.numberSatisfies(item.price)).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!magicCraftingCost.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> magicCraftingCost.numberSatisfies(item.craftingCost)).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!magicWeight.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> magicWeight.numberSatisfies(item.weight)).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!magicBaseItem.getText().equals("")){
                for(MagicItem item : intermediary){
                    for(String s : item.baseItems){
                        if(s.toLowerCase().contains(magicBaseItem.getText().toLowerCase()))
                            temp.add(item);
                    }
                }
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!magicCasterLevel.isEmpty()){
                temp.addAll(intermediary.stream().filter(item -> magicCasterLevel.numberSatisfies(item.casterLevel)).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(isAliveOptions.notEither()){
                if(isAliveOptions.value()){
                    temp.addAll(intermediary.stream().filter(item -> item.isLiving).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                    if(!magicCha.isEmpty()){
                        temp.addAll(intermediary.stream().filter(item -> magicCha.numberSatisfies(item.cha)).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                    if(!magicCasterLevel.isEmpty()){
                        temp.addAll(intermediary.stream().filter(item -> magicInt.numberSatisfies(item.intel)).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                    if(!magicEgo.isEmpty()){
                        temp.addAll(intermediary.stream().filter(item -> magicEgo.numberSatisfies(item.ego)).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                    if(!magicWis.isEmpty()){
                        temp.addAll(intermediary.stream().filter(item -> magicWis.numberSatisfies(item.wis)).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                    if(!magicAlignment.getSelectedItem().equals("")){
                        temp.addAll(intermediary.stream().filter(item -> item.alignment.toLowerCase().contains(((String)magicAlignment.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                    if(!magicCommunication.getSelectedItem().equals("")){
                        temp.addAll(intermediary.stream().filter(item -> item.communication.toLowerCase().contains(((String)magicCommunication.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                    if(!magicPowers.getSelectedItem().equals("")){
                        temp.addAll(intermediary.stream().filter(item -> item.powers.toLowerCase().contains(((String)magicPowers.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                    if(!magicSenses.getSelectedItem().equals("")){
                        temp.addAll(intermediary.stream().filter(item -> item.senses.toLowerCase().contains(((String)magicSenses.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                    if(!magicLanguage.getText().equals("")){
                        temp.addAll(intermediary.stream().filter(item -> item.languages.toLowerCase().contains(magicLanguage.getText().toLowerCase())).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                } else {
                    temp.addAll(intermediary.stream().filter(item -> (!(item.isLiving))).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                }
            }
            if(hasScalingOptions.notEither()){
                if(hasScalingOptions.value()){
                    temp.addAll(intermediary.stream().filter(item -> item.hasScaling).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                    if(!magicScaling.getSelectedItem().equals("")){
                        temp.addAll(intermediary.stream().filter(item -> item.scaling.toLowerCase().contains(((String)magicScaling.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                        intermediary.clear();
                        intermediary.addAll(temp);
                        temp.clear();
                    }
                } else {
                    temp.addAll(intermediary.stream().filter(item -> !item.hasScaling).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                }

            }
            if(!magicGroup.getSelectedItem().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.group.toLowerCase().contains(((String)magicGroup.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)magicSlot.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.slot.toLowerCase().contains(((String)magicSlot.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)magicSource.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.source.toLowerCase().contains(((String)magicSource.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!magicDesc.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.basicDescription.toLowerCase().contains(magicDesc.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(mythicBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.mythic == mythicBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(legendaryWeaponBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.legendaryWeapon == legendaryWeaponBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(illusionBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.illusion == illusionBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(universalBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.universal == universalBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(minorArtifactBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.minorArtifact == minorArtifactBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(majorArtifactBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.majorArtifact == majorArtifactBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(abjurationBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.abjuration == abjurationBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(conjurationBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.conjuration == conjurationBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(divinationBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.divination == divinationBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(enchantmentBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.enchantment == enchantmentBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(evocationBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.evocation == evocationBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(necromancyBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.necromancy == necromancyBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(transmutationBox.notEither()) {
                temp.addAll(intermediary.stream().filter(item -> item.transmutation == transmutationBox.value()).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            results.addAll(items.stream().filter(item -> intermediary.contains(item.baseItem())).collect(Collectors.toList()));
            resultsScroll.repaint();
        });

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.ipadx = 10;
        adventureItemSearch.add(new JLabel("Name: "), c);
        c.gridy++;
        adventureItemSearch.add(new JLabel("Platinum: "), c);
        c.gridy++;
        adventureItemSearch.add(new JLabel("Gold: "), c);
        c.gridy++;
        adventureItemSearch.add(new JLabel("Amount Per Purchase: "), c);
        c.gridy++;
        adventureItemSearch.add(new JLabel("Source: "), c);
        c.gridx = 2;
        c.gridy = 0;
        adventureItemSearch.add(new JLabel("Type: "), c);
        c.gridy++;
        adventureItemSearch.add(new JLabel("Silver: "), c);
        c.gridy++;
        adventureItemSearch.add(new JLabel("Copper: "), c);
        c.gridy++;
        adventureItemSearch.add(new JLabel("Weight: "), c);
        c.gridy++;
        adventureItemSearch.add(new JLabel("Description: "), c);

        AutofillTextArea adventureName = new AutofillTextArea(gearNames, 5);
        JComboBox<String> adventureType = new JComboBox<>(new Vector<>(gearTypes));
        adventureType.setPreferredSize(new Dimension(0, adventureType.getPreferredSize().height));
        NumberInequalityField adventurePlatinum = new NumberInequalityField();
        NumberInequalityField adventureGold = new NumberInequalityField();
        NumberInequalityField adventureSilver = new NumberInequalityField();
        NumberInequalityField adventureCopper = new NumberInequalityField();
        NumberInequalityField adventureWeight = new NumberInequalityField();
        NumberInequalityField adventureAmount = new NumberInequalityField();
        JComboBox<String> adventureSource = new JComboBox<>(new Vector<>(gearSources));
        adventureSource.setPreferredSize(new Dimension(0, adventureSource.getPreferredSize().height));
        JTextField adventureDescription = new JTextField();

        c.weightx = 1;
        c.gridy = 0;
        c.gridx = 1;
        adventureItemSearch.add(adventureName, c);
        c.gridy++;
        adventureItemSearch.add(adventurePlatinum, c);
        c.gridy++;
        adventureItemSearch.add(adventureGold, c);
        c.gridy++;
        adventureItemSearch.add(adventureAmount, c);
        c.gridy++;
        adventureItemSearch.add(adventureSource, c);
        c.gridy = 0;
        c.gridx = 3;
        adventureItemSearch.add(adventureType, c);
        c.gridy++;
        adventureItemSearch.add(adventureSilver, c);
        c.gridy++;
        adventureItemSearch.add(adventureCopper, c);
        c.gridy++;
        adventureItemSearch.add(adventureWeight, c);
        c.gridy++;
        adventureItemSearch.add(adventureDescription, c);

        JButton adventureSearch = new JButton("Search with these values");
        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 4;
        adventureItemSearch.add(adventureSearch, c);

        adventureSearch.addActionListener(e -> {
            results.clear();

            ArrayList<AdventureGearEnum> intermediary = new ArrayList<>();
            for(GenItem item : items){
                if(item.baseItem() instanceof AdventureGearEnum) intermediary.add((AdventureGearEnum)item.baseItem());
            }
            ArrayList<AdventureGearEnum> temp = new ArrayList<>();


            if(!adventureName.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.getItemName().toLowerCase().contains(adventureName.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)adventureType.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.type().toLowerCase().contains(((String)adventureType.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!((String)adventureSource.getSelectedItem()).equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.source().toLowerCase().contains(((String)adventureSource.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!adventureDescription.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.getFormattedDetails().toLowerCase().contains(adventureDescription.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!adventurePlatinum.isEmpty()){
                try {
                    temp.addAll(intermediary.stream().filter(item -> adventurePlatinum.numberSatisfies(item.cost()[0])).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                } catch (NumberFormatException ex){
                    Pathfinder.showError("Number Format Exception", "The value you entered for platinum is not a number.\nI'll ignore that field for now.");
                }
            }
            if(!adventureGold.isEmpty()){
                try{
                    temp.addAll(intermediary.stream().filter(item -> adventureGold.numberSatisfies(item.cost()[1])).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                } catch (NumberFormatException ex){
                    Pathfinder.showError("Number Format Exception", "The value you entered for gold is not a number.\nI'll ignore that field for now.");
                }
            }
            if(!adventureSilver.isEmpty()){
                try{
                    temp.addAll(intermediary.stream().filter(item -> adventureSilver.numberSatisfies(item.cost()[2])).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                } catch (NumberFormatException ex){
                    Pathfinder.showError("Number Format Exception", "The value you entered for silver is not a number.\nI'll ignore that field for now.");
                }
            }
            if(!adventureCopper.isEmpty()){
                try{
                    temp.addAll(intermediary.stream().filter(item -> adventureCopper.numberSatisfies(item.cost()[3])).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                } catch (NumberFormatException ex){
                    Pathfinder.showError("Number Format Exception", "The value you entered for copper is not a number.\nI'll ignore that field for now.");
                }
            }
            if(!adventureAmount.isEmpty()){
                try{
                    temp.addAll(intermediary.stream().filter(item -> adventureAmount.numberSatisfies(item.getPurchaseAmount())).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                } catch (NumberFormatException ex){
                    Pathfinder.showError("Number Format Exception", "The value you entered for amount per purchase is not a number.\nI'll ignore that field for now.");
                }
            }
            if(!adventureWeight.isEmpty()){
                try{
                    temp.addAll(intermediary.stream().filter(item -> adventureWeight.numberSatisfies(item.weight())).collect(Collectors.toList()));
                    intermediary.clear();
                    intermediary.addAll(temp);
                    temp.clear();
                } catch (NumberFormatException ex){
                    Pathfinder.showError("Number Format Exception", "The value you entered for weight is not a number.\nI'll ignore that field for now.");
                }
            }

            results.addAll(items.stream().filter(item -> intermediary.contains(item.baseItem())).collect(Collectors.toList()));
            resultsScroll.repaint();
        });


        //End making individual search panels

        searchDialog.add(parentPanel);
        searchDialog.setSize(750,700);
        searchDialog.setLocationRelativeTo(null);
        searchDialog.setVisible(true);

        while(!selected.get()){}

        ArrayList<GenItem> toReturn = new ArrayList<>();
        int[] indices = resultsList.getSelectedIndices();
        for(int i : indices) toReturn.add(results.get(i));

        searchDialog.dispose();

        return toReturn;
    }

    public static List<Spell> searchSpells(List<Spell> spells, Window parent, String title, int maxPicks){
        JDialog searchDialog = new JDialog(parent, title);
        AtomicBoolean selected = new AtomicBoolean(false);

        ArrayList<Spell> results = new ArrayList<>();
        results.addAll(spells);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel name = new JLabel("Name: ");
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel school = new JLabel("School: ");
        school.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel descriptor = new JLabel("Descriptor: ");
        descriptor.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel classLabel = new JLabel("Class: ");
        classLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel level = new JLabel("Level: ");
        level.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel bloodline = new JLabel("Bloodline");
        bloodline.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel bloodlineLevel = new JLabel("Bloodline Level: ");
        bloodlineLevel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel domain = new JLabel("Domain: ");
        domain.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel hasMythic = new JLabel("Has Mythic: ");
        hasMythic.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel deity = new JLabel("Deity: ");
        deity.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel hasAugment = new JLabel("Has Augment: ");
        hasAugment.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel descriptionContains = new JLabel("Description contains: ");
        descriptionContains.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel spellType = new JLabel("Spell type");
        spellType.setBorder(BorderFactory.createLineBorder(Color.black));

        JTextField classField = new JTextField();

        JComboBox<String> schoolfield = new JComboBox<>();
        schoolfield.addItem("");
        schoolfield.setPreferredSize(new Dimension(146, 25));
        schoolfield.setEditable(true);
        JComboBox<String> descriptorField = new JComboBox<>();
        descriptorField.addItem("");
        descriptorField.setPreferredSize(new Dimension(146, 25));
        descriptorField.setMinimumSize(new Dimension(146, 25));
        descriptorField.setEditable(true);
        JComboBox<String> bloodlineField = new JComboBox<>();
        bloodlineField.addItem("");
        bloodlineField.setPreferredSize(new Dimension(146, 25));
        bloodlineField.setEditable(true);
        JComboBox<String> domainField = new JComboBox<>();
        domainField.addItem("");
        domainField.setPreferredSize(new Dimension(146, 25));
        domainField.setEditable(true);
        JComboBox<String> deityField = new JComboBox<>();
        deityField.addItem("");
        deityField.setPreferredSize(new Dimension(146, 25));
        deityField.setEditable(true);
        JComboBox<String> typeField = new JComboBox<>();
        typeField.addItem("");
        typeField.setPreferredSize(new Dimension(146, 25));
        typeField.setEditable(true);
        for(String s : Spells.spellTypeNames) typeField.addItem(s);

        ArrayList<String> spellNames = new ArrayList<>();
        ArrayList<String> schoolDone = new ArrayList<>();
        schoolDone.add("");
        ArrayList<String> descriptorDone = new ArrayList<>();
        descriptorDone.add("");
        ArrayList<String> bloodlineDone = new ArrayList<>();
        bloodlineDone.add("");
        ArrayList<String> domainDone = new ArrayList<>();
        domainDone.add("");
        ArrayList<String> deityDone = new ArrayList<>();
        deityDone.add("");

        for(Spell spell : Spells.getSpells()){
            spellNames.add(spell.name);
            if(!schoolDone.contains(spell.school.toLowerCase())){
                schoolfield.addItem(spell.school);
                schoolDone.add(spell.school.toLowerCase());
            }
            for(String s : spell.descriptor.split(",")){
                s = s.trim();
                if(!descriptorDone.contains(s.toLowerCase())){
                    descriptorField.addItem(s);
                    descriptorDone.add(s.toLowerCase());
                }
            }
            for(String s : spell.bloodlineLevels.keySet()){
                if(!bloodlineDone.contains(s.trim().toLowerCase())){
                    bloodlineField.addItem(s.trim());
                    bloodlineDone.add(s.trim().toLowerCase());
                }
            }
            if(spell.hasDomain){
                for(String s : spell.domain.split(",")){
                    if(s.contains("(")) s = s.substring(0, s.indexOf("("));
                    s = s.trim();
                    if(!domainDone.contains(s.toLowerCase())){
                        domainDone.add(s.toLowerCase());
                        domainField.addItem(s);
                    }
                }
            }
            if(spell.hasDeity && !deityDone.contains(spell.deity.toLowerCase())){
                deityDone.add(spell.deity.toLowerCase());
                deityField.addItem(spell.deity);
            }
        }

        AutofillTextArea nameField = new AutofillTextArea(spellNames, 5);

        NumberInequalityField levelField = new NumberInequalityField();
        NumberInequalityField bloodlineLevelField = new NumberInequalityField();
        YesNoEither augment = new YesNoEither(true);
        YesNoEither mythic = new YesNoEither(true);
        JTextField descriptionContainsField = new JTextField();

        c.weighty = 0;
        c.weightx = 0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(name, c);
        c.gridy = 1;
        panel.add(school, c);
        c.gridy = 2;
        panel.add(descriptor, c);
        c.gridy = 3;
        panel.add(classLabel, c);
        c.gridy = 4;
        panel.add(bloodline, c);
        c.gridy = 5;
        panel.add(spellType, c);
        c.gridy = 6;
        panel.add(descriptionContains, c);

        c.gridy = 0;
        c.gridx = 2;
        panel.add(deity, c);
        c.gridy = 1;
        panel.add(domain, c);
        c.gridy = 2;
        panel.add(hasAugment, c);
        c.gridy = 3;
        panel.add(level, c);
        c.gridy = 4;
        panel.add(bloodlineLevel, c);
        c.gridy = 5;
        panel.add(hasMythic, c);

        c.gridy = 0;
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        panel.add(nameField, c);
        c.gridy = 1;
        panel.add(schoolfield, c);
        c.gridy = 2;
        panel.add(descriptorField, c);
        c.gridy = 3;
        panel.add(classField, c);
        c.gridy = 4;
        panel.add(bloodlineField, c);
        c.gridy = 5;
        panel.add(typeField, c);
        c.gridy = 6;
        c.gridwidth = 3;
        panel.add(descriptionContainsField, c);

        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 0;
        panel.add(deityField, c);
        c.gridy = 1;
        panel.add(domainField, c);
        c.gridy = 2;
        panel.add(augment, c);
        c.gridy = 3;
        panel.add(levelField, c);
        c.gridy = 4;
        panel.add(bloodlineLevelField, c);
        c.gridy = 5;
        panel.add(mythic, c);

        JButton searchButton = new JButton("Search with these values");
        c.gridy = 7;
        c.gridx = 0;
        c.gridwidth = 4;
        panel.add(searchButton, c);


        JList<Spell> resultsList = new JList<>();

        JScrollPane resultsScroll = new JScrollPane(resultsList){
            public void paintComponent(Graphics g){
                resultsList.setListData(results.toArray(new Spell[results.size()]));
            }
        };

        resultsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    Spells.showSpellDetails(results.get(index), results.get(index).name, spells, results, resultsScroll);
                }
            }
        });


        c.gridy++;
        c.weightx = 1;
        c.weighty = 1;
        panel.add(resultsScroll, c);

        JButton select = new JButton("Select chosen spell(s)");
        c.gridy++;
        c.weighty = 0;
        c.gridwidth = 2;
        panel.add(select, c);

        JButton create = new JButton("Create New");
        c.gridx = 2;
        c.gridwidth = 1;
        panel.add(create, c);

        JButton load = new JButton("Load Spell");
        c.gridx = 3;
        panel.add(load, c);

        load.addActionListener(e -> {
            JFileChooser loadChooser = new JFileChooser();
            int returned = loadChooser.showOpenDialog(searchDialog);
            if(returned == JFileChooser.APPROVE_OPTION){
                Spell spell = null;
                try{
                    FileInputStream fileIn = new FileInputStream(loadChooser.getSelectedFile());
                    ObjectInputStream objIn = new ObjectInputStream(fileIn);
                    spell = (Spell)(objIn.readObject());

                } catch (FileNotFoundException ex){
                    Pathfinder.showError("Could not load file","You may not have permissions to access the file.\nRun this in command for more details.");
                    ex.printStackTrace();
                } catch (IOException ex){
                    Pathfinder.showError("Unknown IO Exception","Run this in command for more details.");
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex){
                    Pathfinder.showError("Not a spell","It doesn't seem that there's a spell saved in that file.\nThe file may be corrupt.");
                } catch (ClassCastException ex){
                    Pathfinder.showError("Not a spell", "It appears this is some other kind of Java object.");
                }
                if(spell != null){
                    spells.add(spell);
                    results.add(spell);
                    int[] current = resultsList.getSelectedIndices();
                    int[] newIndices = new int[current.length + 1];
                    for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                    newIndices[newIndices.length - 1] = results.size() - 1;
                    resultsList.setListData(results.toArray(new Spell[results.size()]));
                    resultsScroll.repaint();
                    resultsList.setSelectedIndices(newIndices);

                    JScrollBar vertical = resultsScroll.getVerticalScrollBar();
                    vertical.setValue( vertical.getMaximum() );
                }
            }
        });

        create.addActionListener(e -> {
            (new Thread(){
                public void run(){
                    Spell spell = Spells.createNewSpell(searchDialog);
                    if(spell != null){
                        spells.add(spell);
                        results.add(spell);
                        int[] current = resultsList.getSelectedIndices();
                        int[] newIndices = new int[current.length + 1];
                        for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                        newIndices[newIndices.length - 1] = results.size() - 1;
                        resultsList.setListData(results.toArray(new Spell[results.size()]));
                        resultsScroll.repaint();
                        resultsList.setSelectedIndices(newIndices);

                        JScrollBar vertical = resultsScroll.getVerticalScrollBar();
                        vertical.setValue( vertical.getMaximum() );
                    }
                }
            }).start();
        });

        select.addActionListener(e -> {
            if(resultsList.getSelectedIndex() > -1){
                if(maxPicks == -1 || resultsList.getSelectedIndices().length == maxPicks || (resultsList.getSelectedIndices().length < maxPicks && Pathfinder.askYesNo("You have only selected " + resultsList.getSelectedIndices().length + " of " + maxPicks + " spells. Continue?")) || (resultsList.getSelectedIndices().length > maxPicks && Pathfinder.askYesNo("You have selected too many spells. Continue anyway?"))) {
                    selected.set(true);
                }
            }
        });

        searchDialog.add(panel);
        searchDialog.setSize(535,600);
        searchDialog.setLocationRelativeTo(null);
        searchDialog.setVisible(true);


        searchButton.addActionListener( e -> {
            results.clear();
            results.addAll(spells);

            ArrayList<Spell> intermediary = new ArrayList<>();

            if(!nameField.getText().equals("")){
                intermediary.addAll(results.stream().filter(spell -> spell.name.toLowerCase().contains(nameField.getText().toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!((String)schoolfield.getSelectedItem()).equals("")){
                intermediary.addAll(results.stream().filter(spell -> spell.school.toLowerCase().contains(((String)schoolfield.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!((String)descriptorField.getSelectedItem()).equals("")){
                intermediary.addAll(results.stream().filter(spell -> spell.descriptor.toLowerCase().contains(((String)descriptorField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!classField.getText().equals("")){
                intermediary.addAll(results.stream().filter(spell -> Spells.spellLevelFor(classField.getText(), spell) != -1).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
                if(!levelField.isEmpty()){
                    intermediary.addAll(results.stream().filter(spell -> levelField.numberSatisfies(Spells.spellLevelFor(classField.getText(), spell))).collect(Collectors.toList()));
                    results.clear();
                    results.addAll(intermediary);
                    intermediary.clear();
                }
            }
            if(!levelField.isEmpty()){
                intermediary.addAll(results.stream().filter(spell -> levelField.anySatisfiesExcept(spell.levelRequirements, -1)).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!((String)bloodlineField.getSelectedItem()).equals("")){
                intermediary.addAll(results.stream().filter(spell -> {
                    for(String key : spell.bloodlineLevels.keySet()){
                        if(((String)bloodlineField.getSelectedItem()).equalsIgnoreCase(key))
                            return true;
                    }
                    return false;
                }).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
                if(!bloodlineLevelField.isEmpty()) {
                    intermediary.addAll(results.stream().filter(spell -> bloodlineLevelField.numberSatisfies(spell.bloodlineLevels.get((String)bloodlineField.getSelectedItem()))).collect(Collectors.toList()));
                    results.clear();
                    results.addAll(intermediary);
                    intermediary.clear();
                }
            }
            if(!bloodlineLevelField.isEmpty()) {
                intermediary.addAll(results.stream().filter(spell -> bloodlineLevelField.anySatisfiesExcept(spell.bloodlineLevels.values(), -1)).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!((String)domainField.getSelectedItem()).equals("")) {
                intermediary.addAll(results.stream().filter(spell -> spell.hasDomain && spell.domain.toLowerCase().contains(((String)domainField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(augment.notEither()) {
                intermediary.addAll(results.stream().filter(spell -> spell.hasAugment == augment.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(mythic.notEither()) {
                intermediary.addAll(results.stream().filter(spell -> spell.hasMythic == mythic.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!((String)deityField.getSelectedItem()).equals("")) {
                intermediary.addAll(results.stream().filter(spell -> spell.hasDeity && spell.deity.toLowerCase().contains(((String)deityField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!((String)typeField.getSelectedItem()).equals("")) {
                intermediary.addAll(results.stream().filter(spell -> Spells.spellHasType(((String)typeField.getSelectedItem()), spell)).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!descriptionContainsField.getText().equals("")) {
                intermediary.addAll(results.stream().filter(spell -> spell.basicDescription.toLowerCase().contains(descriptionContainsField.getText().toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }

            resultsScroll.repaint();
        });


        while(!selected.get()){}

        ArrayList<Spell> spellsSelected = new ArrayList<>();
        int[] indices = resultsList.getSelectedIndices();
        for(int i : indices) spellsSelected.add(results.get(i));

        searchDialog.dispose();

        return spellsSelected;
    }

    public static List<Feat> searchFeats(List<Feat> feats, String title, int maxPicks, Window parent){
        JDialog searchDialog = new JDialog(parent, title);

        AtomicBoolean selected = new AtomicBoolean(false);

        ArrayList<Feat> results = new ArrayList<>();
        results.addAll(feats);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel name = new JLabel("Name: ");
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel source = new JLabel("Source: ");
        source.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel racial = new JLabel("Racial: ");
        racial.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel raceName = new JLabel("Race Name: ");
        raceName.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel teamwork = new JLabel("Teamwork: ");
        teamwork.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel critical = new JLabel("Critical: ");
        critical.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel grit = new JLabel("Grit: ");
        grit.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel style = new JLabel("Style: ");
        style.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel performance = new JLabel("Performance: ");
        performance.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel containsText = new JLabel("Contains text: ");
        containsText.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel companionFamiliar = new JLabel("Companion/Familiar: ");
        companionFamiliar.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel canDoMultiple = new JLabel("Can take multiple: ");
        canDoMultiple.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel panache = new JLabel("Panache: ");
        panache.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel betrayal = new JLabel("Betrayal: ");
        betrayal.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel targeting = new JLabel("Targeting: ");
        targeting.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel esoteric = new JLabel("Esoteric: ");
        esoteric.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel stare = new JLabel("Stare: ");
        stare.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel weaponMastery = new JLabel("Weapon mastery: ");
        weaponMastery.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel itemMastery = new JLabel("Item mastery: ");
        itemMastery.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel armorMastery = new JLabel("Armor mastery: ");
        armorMastery.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel shieldMastery = new JLabel("Shield mastery: ");
        shieldMastery.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel general = new JLabel("General: ");
        general.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel combat = new JLabel("Combat: ");
        combat.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel itemCreation = new JLabel("Item Creation: ");
        itemCreation.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel metamagic = new JLabel("Metamagic: ");
        metamagic.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel monster = new JLabel("Monster: ");
        monster.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel achievement = new JLabel("Achievement: ");
        achievement.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel story = new JLabel("Story: ");
        story.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel mythic = new JLabel("Mythic: ");
        mythic.setBorder(BorderFactory.createLineBorder(Color.black));


        JComboBox<String> raceNameField = new JComboBox<>();
        raceNameField.setEditable(true);
        ArrayList<String> alreadyAddedRace = new ArrayList<>();
        ArrayList<String> featNames = new ArrayList<>();
        for(Feat feat : Feats.getFeats()){
            featNames.add(feat.name);

            String[] races;
            if(feat.raceName.contains(",")) races = feat.raceName.split(",");
            else races = feat.raceName.split("\\|");
            for(String race : races){
                String toCheck = race.trim();
                if(!alreadyAddedRace.contains(toCheck.toLowerCase())){
                    raceNameField.addItem(toCheck);
                    alreadyAddedRace.add(toCheck.toLowerCase());
                }
            }
        }

        JTextField fullTextField = new JTextField();
        AutofillTextArea nameField = new AutofillTextArea(featNames, 5);
        JTextField sourceField = new JTextField();

        YesNoEither racialBox = new YesNoEither(true);
        YesNoEither generalBox = new YesNoEither(false);
        YesNoEither combatBox = new YesNoEither(false);
        YesNoEither itemCreationBox = new YesNoEither(false);
        YesNoEither metamagicBox = new YesNoEither(false);
        YesNoEither monsterBox = new YesNoEither(false);
        YesNoEither achievementBox = new YesNoEither(false);
        YesNoEither storyBox = new YesNoEither(false);
        YesNoEither mythicBox = new YesNoEither(false);
        YesNoEither teamworkBox = new YesNoEither(false);
        YesNoEither criticalBox = new YesNoEither(false);
        YesNoEither gritBox = new YesNoEither(false);
        YesNoEither styleBox = new YesNoEither(false);
        YesNoEither performanceBox = new YesNoEither(false);
        YesNoEither companionFamiliarBox = new YesNoEither(false);
        YesNoEither canDoMultipleBox = new YesNoEither(false);
        YesNoEither panacheBox = new YesNoEither(false);
        YesNoEither betrayalBox = new YesNoEither(false);
        YesNoEither targetingBox = new YesNoEither(false);
        YesNoEither esotericBox = new YesNoEither(false);
        YesNoEither stareBox = new YesNoEither(false);
        YesNoEither weaponMasteryBox = new YesNoEither(false);
        YesNoEither itemMasteryBox = new YesNoEither(false);
        YesNoEither armorMasteryBox = new YesNoEither(false);
        YesNoEither shieldMasteryBox = new YesNoEither(false);

        c.gridy = 0;
        c.weightx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        panel.add(name, c);
        c.gridy++;
        panel.add(containsText, c);
        c.gridy++;
        panel.add(source, c);
        c.gridy++;
        panel.add(racial, c);
        c.gridy++;
        panel.add(raceName, c);

        c.gridx = 1;
        c.weightx = 1;
        c.gridy = 0;
        panel.add(nameField, c);
        c.gridy++;
        panel.add(fullTextField, c);
        c.gridy++;
        panel.add(sourceField, c);
        c.gridy++;
        panel.add(racialBox, c);
        c.gridy++;
        panel.add(raceNameField, c);




        JPanel inner = new JPanel(new GridBagLayout());
        JScrollPane scroll = new JScrollPane(inner);
        scroll.setPreferredSize(new Dimension(210,0));
        scroll.setMinimumSize(new Dimension(210,0));
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 5;
        c.weightx = 0;
        c.weighty = 0;
        panel.add(scroll, c);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        inner.add(general, c);
        c.gridy++;
        inner.add(combat, c);
        c.gridy++;
        inner.add(itemCreation, c);
        c.gridy++;
        inner.add(metamagic, c);
        c.gridy++;
        inner.add(monster, c);
        c.gridy++;
        inner.add(achievement, c);
        c.gridy++;
        inner.add(story, c);
        c.gridy++;
        inner.add(mythic, c);
        c.gridy++;
        inner.add(teamwork, c);
        c.gridy++;
        inner.add(critical,c );
        c.gridy++;
        inner.add(grit, c);
        c.gridy++;
        inner.add(style, c);
        c.gridy++;
        inner.add(performance, c);
        c.gridy++;
        inner.add(companionFamiliar, c);
        c.gridy++;
        inner.add(canDoMultiple, c);
        c.gridy++;
        inner.add(panache, c);
        c.gridy++;
        inner.add(betrayal, c);
        c.gridy++;
        inner.add(targeting, c);
        c.gridy++;
        inner.add(esoteric, c);
        c.gridy++;
        inner.add(stare, c);
        c.gridy++;
        inner.add(weaponMastery, c);
        c.gridy++;
        inner.add(itemMastery, c);
        c.gridy++;
        inner.add(armorMastery, c);
        c.gridy++;
        inner.add(shieldMastery, c);
        c.gridy = 0;
        c.gridx = 1;
        c.weightx = 1;
        inner.add(generalBox, c);
        c.gridy++;
        inner.add(combatBox, c);
        c.gridy++;
        inner.add(itemCreationBox, c);
        c.gridy++;
        inner.add(metamagicBox, c);
        c.gridy++;
        inner.add(monsterBox, c);
        c.gridy++;
        inner.add(achievementBox, c);
        c.gridy++;
        inner.add(storyBox, c);
        c.gridy++;
        inner.add(mythicBox, c);
        c.gridy++;
        inner.add(teamworkBox, c);
        c.gridy++;
        inner.add(criticalBox, c);
        c.gridy++;
        inner.add(gritBox, c);
        c.gridy++;
        inner.add(styleBox, c);
        c.gridy++;
        inner.add(performanceBox, c);
        c.gridy++;
        inner.add(companionFamiliarBox, c);
        c.gridy++;
        inner.add(canDoMultipleBox, c);
        c.gridy++;
        inner.add(panacheBox, c);
        c.gridy++;
        inner.add(betrayalBox, c);
        c.gridy++;
        inner.add(targetingBox, c);
        c.gridy++;
        inner.add(esotericBox, c);
        c.gridy++;
        inner.add(stareBox, c);
        c.gridy++;
        inner.add(weaponMasteryBox, c);
        c.gridy++;
        inner.add(itemMasteryBox, c);
        c.gridy++;
        inner.add(armorMasteryBox, c);
        c.gridy++;
        inner.add(shieldMasteryBox, c);

        JButton searchButton = new JButton("Search with these values");
        c.gridy = 7;
        c.gridx = 0;
        c.gridwidth = 4;
        panel.add(searchButton, c);


        JList<Feat> resultsList = new JList<>();

        JScrollPane resultsScroll = new JScrollPane(resultsList){
            public void paintComponent(Graphics g){
                resultsList.setListData(results.toArray(new Feat[results.size()]));
            }
        };

        resultsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    Feats.showFeatDetails(results.get(index), results.get(index).name, results, feats, resultsScroll);
                }
            }
        });

        c.gridy++;
        c.weightx = 1;
        c.weighty = 1;
        panel.add(resultsScroll, c);

        JButton select = new JButton("Select chosen feat(s)");
        c.gridy++;
        c.weighty = 0;
        c.gridwidth = 2;
        panel.add(select, c);

        JButton create = new JButton("Create new");
        c.gridx = 2;
        c.gridwidth = 1;
        panel.add(create, c);

        JButton load = new JButton("Load Feat");
        c.gridx = 3;
        panel.add(load, c);

        create.addActionListener(e -> {
            (new Thread(){
                public void run(){
                    Feat feat = Feats.createNewFeat(searchDialog);
                    if(feat != null){
                        feats.add(feat);
                        results.add(feat);
                        int[] current = resultsList.getSelectedIndices();
                        int[] newIndices = new int[current.length + 1];
                        for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                        newIndices[newIndices.length - 1] = results.size() - 1;
                        resultsList.setListData(results.toArray(new Feat[results.size()]));
                        resultsScroll.repaint();
                        resultsList.setSelectedIndices(newIndices);

                        JScrollBar vertical = resultsScroll.getVerticalScrollBar();
                        vertical.setValue( vertical.getMaximum() );
                    }
                }
            }).start();
        });

        load.addActionListener(e -> {
            JFileChooser loadChooser = new JFileChooser();
            int returned = loadChooser.showOpenDialog(searchDialog);
            if(returned == JFileChooser.APPROVE_OPTION){
                Feat feat = null;
                try{
                    FileInputStream fileIn = new FileInputStream(loadChooser.getSelectedFile());
                    ObjectInputStream objIn = new ObjectInputStream(fileIn);
                    feat = (Feat)(objIn.readObject());

                } catch (FileNotFoundException ex){
                    Pathfinder.showError("Could not load file","You may not have permissions to access the file.\nRun this in command for more details.");
                    ex.printStackTrace();
                } catch (IOException ex){
                    Pathfinder.showError("Unknown IO Exception","Run this in command for more details.");
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex){
                    Pathfinder.showError("Not a feat","It doesn't seem that there's a feat saved in that file.\nThe file may be corrupt.");
                } catch (ClassCastException ex){
                    Pathfinder.showError("Not a feat", "It appears this is some other kind of Java object.");
                }
                if(feat != null){
                    feats.add(feat);
                    results.add(feat);
                    int[] current = resultsList.getSelectedIndices();
                    int[] newIndices = new int[current.length + 1];
                    for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                    newIndices[newIndices.length - 1] = results.size() - 1;
                    resultsList.setListData(results.toArray(new Feat[results.size()]));
                    resultsScroll.repaint();
                    resultsList.setSelectedIndices(newIndices);

                    JScrollBar vertical = resultsScroll.getVerticalScrollBar();
                    vertical.setValue( vertical.getMaximum() );
                }
            }
        });

        select.addActionListener(e -> {
            if(resultsList.getSelectedIndices().length > 0){
                if(maxPicks == -1 || resultsList.getSelectedIndices().length == maxPicks || (resultsList.getSelectedIndices().length < maxPicks && Pathfinder.askYesNo("You have only selected " + resultsList.getSelectedIndices().length + " of " + maxPicks + " spells. Continue?")) || (resultsList.getSelectedIndices().length > maxPicks && Pathfinder.askYesNo("You have selected too many spells. Continue anyway?"))) {
                    selected.set(true);
                }
            }
        });


        searchButton.addActionListener(e -> {
            results.clear();
            results.addAll(feats);

            ArrayList<Feat> intermediary = new ArrayList<>();

            if(!nameField.getText().equals("")){
                intermediary.addAll(results.stream().filter(feat -> feat.name.toLowerCase().contains(nameField.getText().toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!fullTextField.getText().equals("")){
                intermediary.addAll(results.stream().filter(feat -> feat.fullText.toLowerCase().contains(fullTextField.getText().toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!sourceField.getText().equals("")){
                intermediary.addAll(results.stream().filter(feat -> feat.source.toLowerCase().contains(sourceField.getText().toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(racialBox.notEither()){
                intermediary.addAll(results.stream().filter(feat -> feat.racial == racialBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
                if(!((String)raceNameField.getSelectedItem()).trim().equals("") && racialBox.value()) {
                    intermediary.addAll(results.stream().filter(feat -> feat.raceName.toLowerCase().contains(((String)raceNameField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                    results.clear();
                    results.addAll(intermediary);
                    intermediary.clear();
                }
            }
            if(generalBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains("general") == generalBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(combatBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains("combat") == combatBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(itemCreationBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains("item creation") == itemCreationBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(metamagicBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains("metamagic") == metamagicBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(monsterBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains("monster") == monsterBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(achievementBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains("achievement") == achievementBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(storyBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains("story") == storyBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(mythicBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains("mythic") == mythicBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(teamworkBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.teamwork == teamworkBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(criticalBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.critical == criticalBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(gritBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.grit == gritBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(styleBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.style == styleBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(performanceBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.performance == performanceBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(companionFamiliarBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.companionOrFamiliar == companionFamiliarBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(canDoMultipleBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.canDoMultiple == canDoMultipleBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(panacheBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.panache == panacheBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(betrayalBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.betrayal == betrayalBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(targetingBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.targeting == targetingBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(esotericBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.esoteric == esotericBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(stareBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.stare == stareBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(weaponMasteryBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.weaponMastery == weaponMasteryBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(itemMasteryBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.itemMastery == itemMasteryBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(armorMasteryBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.armorMastery == armorMasteryBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(shieldMasteryBox.notEither()) {
                intermediary.addAll(results.stream().filter(feat -> feat.shieldMastery == shieldMasteryBox.value()).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }

            resultsScroll.repaint();
        });

        searchDialog.add(panel);
        searchDialog.setSize(460,600);
        searchDialog.setLocationRelativeTo(null);
        searchDialog.setVisible(true);

        while(!selected.get()){}

        ArrayList<Feat> featsSelected = new ArrayList<>();
        for(int i : resultsList.getSelectedIndices()) featsSelected.add(results.get(i));

        searchDialog.dispose();

        return featsSelected;
    }

    public static void chooseClassToLevel(Character me, Component characterDisplay){

        String[] classNames = CharacterClass.getClassNames();

        for(CharacterClass charClass : me.classes){
            if(charClass.name.equalsIgnoreCase("spells")) continue;
            boolean containsClass = false;
            for(int i = 0; i < classNames.length; i++){
                if(charClass.toString().toLowerCase().contains(classNames[i].toLowerCase())) {
                    containsClass = true;
                    classNames[i] = charClass.toString() + " Level " + charClass.level;
                    break;
                }
            }
            if(!containsClass){
                classNames = Arrays.copyOf(classNames, classNames.length + 1);
                classNames[classNames.length - 1] = charClass.name + " Level " + charClass.level;
            }
        }

        JFrame classChooserFrame = new JFrame("Choose the class to level");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JComboBox<String> options = new JComboBox<>(classNames);
        options.setEditable(true);
        JButton confirm = new JButton("Confirm");
        classChooserFrame.add(panel);

        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        panel.add(new JLabel("Level up the class "),c);
        c.gridx = 1;
        c.weightx = 1;
        panel.add(options);
        c.gridx = 2;
        c.weightx = 0;
        panel.add(new JLabel("? "), c);
        c.gridx = 3;
        c.weightx = 0;
        panel.add(confirm, c);

        confirm.addActionListener(e -> {

            String chosenClass = (String)(options.getSelectedItem());
            if(chosenClass.contains(" Level ")) chosenClass = chosenClass.substring(0,chosenClass.indexOf(" Level "));

            if(CharacterClass.getClassInstanceOf(chosenClass,me) != null){
                new Thread(() -> me.levelUp(CharacterClass.getClassInstanceOf(((String)(options.getSelectedItem())).contains(" Level ") ? ((String)(options.getSelectedItem())).substring(0, ((String)(options.getSelectedItem())).indexOf(" Level ")) : ((String)(options.getSelectedItem())),me))).start();
                classChooserFrame.dispose();
                characterDisplay.repaint();
            } else {
                options.setModel(new DefaultComboBoxModel<String>(CharacterClass.getSubclassesOf(chosenClass)));
            }

        });

        classChooserFrame.setSize(400,60);
        classChooserFrame.setLocationRelativeTo(null);
        classChooserFrame.setVisible(true);
    }

    public static void chooseSkillRanks(Character me, int ranksToApply){
        JDialog skillChooser = new JDialog(Pathfinder.FRAME, "Apply skill ranks");
        skillChooser.setSize(500, 500);
        skillChooser.setLocationRelativeTo(Pathfinder.FRAME);
        skillChooser.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        JScrollPane scroll = new JScrollPane(panel);
        skillChooser.add(scroll, BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridwidth = 3;
        c.gridy = 0;
        panel.add(new JLabel("Points Available: " + ranksToApply), c);

        c.gridwidth = 3;
        c.gridx = 3;
        panel.add(new JLabel("Points used: "), c);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.gridx = 6;
        JTextField pointsUsed = new JTextField("0");
        pointsUsed.setEditable(false);
        panel.add(pointsUsed, c);

        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        JLabel name = new JLabel("Name");
        Border border = BorderFactory.createLineBorder(Color.black);
        name.setBorder(border);
        panel.add(name,c);
        c.gridx = 2;
        c.gridwidth = 1;
        JLabel total = new JLabel("Current Total");
        total.setBorder(border);
        panel.add(total, c);
        c.gridx = 3;
        JLabel misc = new JLabel("Misc");
        misc.setBorder(border);
        panel.add(misc, c);
        c.gridx = 4;
        JLabel ranks = new JLabel("Current Ranks");
        ranks.setBorder(border);
        panel.add(ranks, c);
        c.gridx = 5;
        JLabel classSkill = new JLabel("Class");
        classSkill.setBorder(border);
        panel.add(classSkill, c);
        c.gridx = 6;
        JLabel newRanks = new JLabel("New Ranks");
        newRanks.setBorder(border);
        panel.add(newRanks, c);

        HashMap<Skill, SpinnerNumberModel> models = new HashMap<>();
        c.ipady = 7;

        for(Skill skill : me.skillsList){
            c.gridy++;
            c.gridwidth = 2;
            c.gridx = 0;
            name = new JLabel(skill.canBeUntrained() ? skill.toString() : skill.toString() + "*");
            name.setBorder(border);

            name.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getClickCount() > 1) {
                        Pathfinder.showWebPage(skill.getURL(), skill.toString());
                    }
                }
            });
            name.setToolTipText("Double click this for more information.");

            panel.add(name,c);

            c.gridx = 2;
            c.gridwidth = 1;
            JTextField totalField = new JTextField(Integer.toString(skill.calculateTotalSkillMod()));
            totalField.setEditable(false);
            panel.add(totalField, c);

            c.gridx = 3;
            JTextField miscField = new JTextField(Integer.toString(skill.getMiscMod()));
            miscField.setEditable(false);
            panel.add(miscField, c);

            c.gridx = 4;
            JTextField ranksField = new JTextField(Integer.toString(skill.getnRanks()));
            ranksField.setEditable(false);
            panel.add(ranksField, c);

            c.gridx = 5;
            JTextField classField = new JTextField(skill.isClassSkill() ? "Y" : "N");
            classField.setEditable(false);
            panel.add(classField, c);

            c.gridx = 6;
            SpinnerNumberModel model = new SpinnerNumberModel(0, 0, Math.min(ranksToApply, me.getTotalLevel() - skill.getnRanks()), 1);
            models.put(skill, model);
            JSpinner spinner = new JSpinner(model);
            model.addChangeListener(new ChangeListener() {
                private int previousValue = 0;
                @Override
                public void stateChanged(ChangeEvent e) {
                    pointsUsed.setText(Integer.toString(Integer.parseInt(pointsUsed.getText()) + (int)model.getNumber() - previousValue));
                    previousValue = (int)model.getNumber();
                }
            });
            panel.add(spinner, c);
        }

        c.ipady = 0;

        JButton confirm = new JButton("Confirm these values");

        JButton addSkill = new JButton("Add a skill subtype");
        addSkill.addActionListener(e -> {
            new Thread(){
                public void run(){
                    Skill skill = SkillUtils.addSkillSubtype(me);

                    c.gridy--;
                    c.gridwidth = 2;
                    c.gridx = 0;
                    JLabel skillName = new JLabel(skill.canBeUntrained() ? skill.toString() : skill.toString() + "*");
                    skillName.setBorder(border);

                    skillName.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent evt) {
                            if (evt.getClickCount() > 1) {
                                Pathfinder.showWebPage(skill.getURL(), skill.toString());
                            }
                        }
                    });
                    skillName.setToolTipText("Double click this for more information.");

                    panel.add(skillName,c);

                    c.gridx = 2;
                    c.gridwidth = 1;
                    JTextField totalField = new JTextField(){
                        public void setText(String s){
                            super.setText(Integer.toString(skill.calculateTotalSkillMod()));
                        }
                    };
                    totalField.setEditable(false);
                    panel.add(totalField, c);

                    c.gridx = 3;
                    JTextField miscField = new JTextField(){
                        public void setText(String s){
                            super.setText(Integer.toString(skill.getMiscMod()));
                        }
                    };
                    miscField.setEditable(false);
                    panel.add(miscField, c);

                    c.gridx = 4;
                    JTextField ranksField = new JTextField(){
                        public void setText(String s){
                            super.setText(Integer.toString(skill.getnRanks()));
                        }
                    };
                    ranksField.setEditable(false);
                    panel.add(ranksField, c);

                    c.gridx = 5;
                    JTextField classField = new JTextField(){
                        public void setText(String s){
                            super.setText(skill.isClassSkill() ? "Y" : "N");
                        }
                    };
                    classField.setEditable(false);
                    panel.add(classField, c);

                    c.gridx = 6;
                    SpinnerNumberModel model = new SpinnerNumberModel(0, 0, Math.min(ranksToApply, me.getTotalLevel() - skill.getnRanks()), 1);
                    models.put(skill, model);
                    JSpinner spinner = new JSpinner(model);
                    model.addChangeListener(new ChangeListener() {
                        private int previousValue = 0;
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            pointsUsed.setText(Integer.toString(Integer.parseInt(pointsUsed.getText()) + (int)model.getNumber() - previousValue));
                            previousValue = (int)model.getNumber();
                        }
                    });
                    panel.add(spinner, c);

                    c.gridy++;
                    c.gridx = 0;
                    c.gridwidth = 7;
                    panel.add(addSkill, c);

                    c.gridy++;
                    panel.add(confirm, c);
                    skillChooser.revalidate();
                    skillChooser.repaint();
                }
            }.start();
        });
        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 7;
        panel.add(addSkill, c);

        c.gridy++;
        confirm.addActionListener(e -> {
            for(Skill skill : models.keySet()){
                if((int)models.get(skill).getNumber() == 0) continue;
                skill.setnRanks(skill.getnRanks() + (int)models.get(skill).getNumber());
            }
            skillChooser.dispose();
        });
        panel.add(confirm, c);

        skillChooser.setVisible(true);
    }
}