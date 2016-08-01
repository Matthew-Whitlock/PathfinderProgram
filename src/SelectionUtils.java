package src;

import src.classes.CharacterClass;
import src.feats.Feat;
import src.feats.FeatCellRenderer;
import src.feats.Feats;
import src.items.*;
import src.spells.Spell;
import src.spells.SpellCellRenderer;
import src.spells.Spells;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private static int[] indices;

    public static int[] searchItems(List<Item> items, JFrame parent){
        JDialog searchDialog = new JDialog(parent, "Item Search");
        JPanel parentPanel = new JPanel(new GridBagLayout());

        AtomicBoolean selected = new AtomicBoolean(false);

        ArrayList<Item> results = new ArrayList<>();
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
        searchConstraintsParent.add(magicItemScroll, MAGIC_PANEL);

        //Set up parent panel
        JComboBox<String> searchType = new JComboBox<>(PANEL_NAMES);
        searchType.addActionListener(e -> searchConstraintsLayout.show(searchConstraintsParent, (String) searchType.getSelectedItem()));
        searchType.setSelectedIndex(0);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        parentPanel.add(new JLabel("Search these items as: "));
        c.gridx = 1;
        c.weightx = 1;
        parentPanel.add(searchType, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0;
        c.weightx = 1;
        c.gridwidth = 2;
        parentPanel.add(searchConstraintsParent, c);
        c.weighty = 1;

        JList<Item> resultsList = new JList<>();
        resultsList.setCellRenderer(new ItemCellRenderer(false));

        resultsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    Item.showItemDetails(results.get(index));
                }
            }
        });

        JScrollPane resultsScroll = new JScrollPane(resultsList){
            public void paintComponent(Graphics g){
                resultsList.setListData(results.toArray(new Item[results.size()]));
            }
        };

        c.gridy = 2;
        parentPanel.add(resultsScroll, c);

        JButton select = new JButton("Select chosen spell(s)");
        select.addActionListener(e -> selected.set(true));
        c.weighty = 0;
        c.gridy = 3;
        parentPanel.add(select, c);

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

        for(Item item : ItemUtil.getItems()){
            itemNames.add(item.getItemName());

            if(item instanceof WeaponEnum){
                WeaponEnum weapon = (WeaponEnum)item;
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
            } else if(item instanceof ArmorEnum){
                ArmorEnum armor = (ArmorEnum)item;
                armorNames.add(armor.getItemName());
                armorTypes.add(armor.type());
            } else if(item instanceof MagicItem){
                MagicItem magic = (MagicItem)item;
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
            } else if(item instanceof AdventureGearEnum){
                AdventureGearEnum gear = (AdventureGearEnum)item;
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

            ArrayList<Item> intermediary = new ArrayList<>();

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
            for(Item item : items){
                if(item instanceof WeaponEnum) intermediary.add((WeaponEnum)item);
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
            results.addAll(intermediary);
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
            for(Item item : items){
                if(item instanceof ArmorEnum) intermediary.add((ArmorEnum)item);
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

            results.addAll(intermediary);
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
        magicItemSearch.add(new JLabel("Crafting Prereqs: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Crafting Item Reqs: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Weight (lbs): "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Base Item: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Caster Level: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Is Alive: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Intelligence: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Wisdom: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Communication: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Has Sense: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Has Scaling: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Group: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Source: "), c);
        c.gridx = 2;
        c.gridy = 10;
        magicItemSearch.add(new JLabel("Charisma: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Ego: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Alignment: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Has Power: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Language: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Scaling: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Slot: "), c);
        c.gridy++;
        magicItemSearch.add(new JLabel("Description Contains: "), c);

        AutofillTextArea magicName = new AutofillTextArea(magicNames, 5);
        JTextField magicAura = new JTextField();
        JComboBox<String> magicAuraStrength = new JComboBox<>(new Vector<>(magicAuraStrengthSet));
        NumberInequalityField magicCost = new NumberInequalityField();
        NumberInequalityField magicCraftingCost = new NumberInequalityField();
        JTextField magicCraftingPrereqs = new JTextField();
        JTextField magicCraftingItemReqs = new JTextField();
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
        JComboBox<String> magicCommunication = new JComboBox<>(new Vector<>(magicCommunicationSet));
        JComboBox<String> magicPowers = new JComboBox<>(new Vector<>(magicPowerSet));
        JComboBox<String> magicSenses = new JComboBox<>(new Vector<>(magicSensesSet));
        JTextField magicLanguage = new JTextField();
        magicLanguage.setEditable(false);
        JComboBox<String> magicScaling = new JComboBox<>(new Vector<>(magicScalingSet));
        JComboBox<String> magicGroup = new JComboBox<>(new Vector<>(magicGroupSet));
        JComboBox<String> magicSlot = new JComboBox<>(new Vector<>(magicSlotSet));
        JComboBox<String> magicSource = new JComboBox<>(new Vector<>(magicSourceSet));
        magicSource.setEditable(true);
        JTextField magicDesc = new JTextField();

        AtomicBoolean isAlive = new AtomicBoolean(false);
        AtomicBoolean hasScaling = new AtomicBoolean(false);
        AtomicBoolean mythic = new AtomicBoolean(false);
        AtomicBoolean legendaryWeapon = new AtomicBoolean(false);
        AtomicBoolean illusion = new AtomicBoolean(false);
        AtomicBoolean universal = new AtomicBoolean(false);
        AtomicBoolean minorArtifact = new AtomicBoolean(false);
        AtomicBoolean majorArtifact = new AtomicBoolean(false);
        AtomicBoolean abjuration = new AtomicBoolean(false);
        AtomicBoolean conjuration = new AtomicBoolean(false);
        AtomicBoolean divination = new AtomicBoolean(false);
        AtomicBoolean enchantment = new AtomicBoolean(false);
        AtomicBoolean evocation = new AtomicBoolean(false);
        AtomicBoolean necromancy = new AtomicBoolean(false);
        AtomicBoolean transmutation = new AtomicBoolean(false);

        JCheckBox isAliveBox = new JCheckBox();
        isAliveBox.addActionListener(e -> {
            isAlive.set(!isAlive.get());
            magicCha.setEditable(isAlive.get());
            magicInt.setEditable(isAlive.get());
            magicEgo.setEditable(isAlive.get());
            magicWis.setEditable(isAlive.get());
            magicAlignment.setEditable(isAlive.get());
            magicCommunication.setEditable(isAlive.get());
            magicPowers.setEditable(isAlive.get());
            magicSenses.setEditable(isAlive.get());
            magicLanguage.setEditable(isAlive.get());
        });
        JCheckBox hasScalingBox = new JCheckBox();
        hasScalingBox.addActionListener(e -> {
            hasScaling.set(!hasScaling.get());
            magicScaling.setEditable(hasScaling.get());
        });
        JCheckBox mythicBox = new JCheckBox();
        mythicBox.addActionListener(e -> mythic.set(!mythic.get()));
        JCheckBox legendaryWeaponBox = new JCheckBox();
        legendaryWeaponBox.addActionListener(e -> legendaryWeapon.set(!legendaryWeapon.get()));
        JCheckBox illusionBox = new JCheckBox();
        illusionBox.addActionListener(e -> illusion.set(!illusion.get()));
        JCheckBox universalBox = new JCheckBox();
        universalBox.addActionListener(e -> universal.set(!universal.get()));
        JCheckBox minorArtifactBox = new JCheckBox();
        minorArtifactBox.addActionListener(e -> minorArtifact.set(!minorArtifact.get()));
        JCheckBox majorArtifactBox = new JCheckBox();
        majorArtifactBox.addActionListener(e -> majorArtifact.set(!majorArtifact.get()));
        JCheckBox abjurationBox = new JCheckBox();
        abjurationBox.addActionListener(e -> abjuration.set(!abjuration.get()));
        JCheckBox conjurationBox = new JCheckBox();
        conjurationBox.addActionListener(e -> conjuration.set(!conjuration.get()));
        JCheckBox divinationBox = new JCheckBox();
        divinationBox.addActionListener(e -> divination.set(!divination.get()));
        JCheckBox enchantmentBox = new JCheckBox();
        enchantmentBox.addActionListener(e -> enchantment.set(!enchantment.get()));
        JCheckBox evocationBox = new JCheckBox();
        evocationBox.addActionListener(e -> evocation.set(!evocation.get()));
        JCheckBox necromancyBox = new JCheckBox();
        necromancyBox.addActionListener(e -> necromancy.set(!necromancy.get()));
        JCheckBox transmutationBox = new JCheckBox();
        transmutationBox.addActionListener(e -> transmutation.set(!transmutation.get()));

        JPanel magicBoolPanel = new JPanel(new GridBagLayout());
        JScrollPane magicBoolScroll = new JScrollPane(magicBoolPanel);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
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

        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 10;
        c.fill = GridBagConstraints.BOTH;
        magicBoolScroll.setPreferredSize(magicBoolScroll.getMinimumSize());
        magicItemSearch.add(magicBoolScroll, c);

        c.weightx = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
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
        magicItemSearch.add(magicCraftingPrereqs, c);
        c.gridy++;
        magicItemSearch.add(magicCraftingItemReqs, c);
        c.gridy++;
        magicItemSearch.add(magicWeight, c);
        c.gridy++;
        magicItemSearch.add(magicBaseItem, c);
        c.gridy++;
        magicItemSearch.add(magicCasterLevel, c);
        c.gridy++;
        magicItemSearch.add(isAliveBox, c);
        c.gridy++;
        magicItemSearch.add(magicInt, c);
        c.gridy++;
        magicItemSearch.add(magicWis, c);
        c.gridy++;
        magicItemSearch.add(magicCommunication, c);
        c.gridy++;
        magicItemSearch.add(magicSenses, c);
        c.gridy++;
        magicItemSearch.add(hasScalingBox, c);
        c.gridy++;
        magicItemSearch.add(magicGroup, c);
        c.gridy++;
        magicItemSearch.add(magicSource, c);
        c.gridy = 10;
        c.gridx = 3;
        magicItemSearch.add(magicCha, c);
        c.gridy++;
        magicItemSearch.add(magicEgo, c);
        c.gridy++;
        magicItemSearch.add(magicAlignment, c);
        c.gridy++;
        magicItemSearch.add(magicPowers, c);
        c.gridy++;
        magicItemSearch.add(magicLanguage, c);
        c.gridy++;
        magicItemSearch.add(magicScaling, c);
        c.gridy++;
        magicItemSearch.add(magicSlot, c);
        c.gridy++;
        magicItemSearch.add(magicDesc, c);

        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 4;
        JButton magicSearch = new JButton("Search with these values");
        magicItemSearch.add(magicSearch, c);

        magicItemSearch.setPreferredSize(new Dimension(0, magicItemSearch.getPreferredSize().height));

        magicSearch.addActionListener(e -> {
            results.clear();

            ArrayList<MagicItem> intermediary = new ArrayList<>();
            for(Item item : items){
                if(item instanceof MagicItem) intermediary.add((MagicItem) item);
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
            if(!magicCraftingPrereqs.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.craftingRequirements.toLowerCase().contains(magicCraftingPrereqs.getText().toLowerCase())).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(!magicCraftingItemReqs.getText().equals("")){
                temp.addAll(intermediary.stream().filter(item -> item.magicItemRequirements.toLowerCase().contains(magicCraftingItemReqs.getText().toLowerCase())).collect(Collectors.toList()));
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
            if(isAlive.get()){
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
            }
            if(hasScaling.get()){
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
            if(mythic.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.mythic).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(legendaryWeapon.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.legendaryWeapon).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(illusion.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.illusion).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(universal.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.universal).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(minorArtifact.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.minorArtifact).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(majorArtifact.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.majorArtifact).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(abjuration.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.abjuration).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(conjuration.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.conjuration).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(divination.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.divination).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(enchantment.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.enchantment).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(evocation.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.evocation).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(necromancy.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.necromancy).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            if(transmutation.get()) {
                temp.addAll(intermediary.stream().filter(item -> item.transmutation).collect(Collectors.toList()));
                intermediary.clear();
                intermediary.addAll(temp);
                temp.clear();
            }
            results.addAll(intermediary);
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
            for(Item item : items){
                if(item instanceof AdventureGearEnum) intermediary.add((AdventureGearEnum) item);
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

            results.addAll(intermediary);
            resultsScroll.repaint();
        });


        //End making individual search panels

        searchDialog.add(parentPanel);
        searchDialog.setSize(500,600);
        searchDialog.setLocationRelativeTo(null);
        searchDialog.setVisible(true);

        while(!selected.get()){}

        ArrayList<Item> itemsSelected = new ArrayList<>();
        int[] indices = resultsList.getSelectedIndices();
        for(int i : indices) itemsSelected.add(results.get(i));
        int[] toReturn = new int[itemsSelected.size()];
        int index = 0;
        for(int i = 0; i < items.size(); i++){
            if(itemsSelected.contains(items.get(i))){
                toReturn[index] = i;
                index++;
            }
        }

        searchDialog.dispose();

        return toReturn;
    }

    public static List<GenItem> chooseItemFromList(List<Item> itemChoices, String title){
        AtomicBoolean indexSet = new AtomicBoolean(false);
        JFrame itemChooseFrame = new JFrame(title);
        JPanel panel = new JPanel(new BorderLayout());
        itemChooseFrame.add(panel);
        JList<Item> list = new JList<>(itemChoices.toArray(new Item[itemChoices.size()]));
        list.setCellRenderer(new ItemCellRenderer(false));

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    Item.showItemDetails(itemChoices.get(index));
                }
            }
        });

        JScrollPane scrollList = new JScrollPane(list);
        panel.add(scrollList,BorderLayout.CENTER);
        JButton choose = new JButton("Choose selected item(s)");
        choose.addActionListener(e -> {
            if(list.getSelectedIndex() > -1){
                indices = list.getSelectedIndices();
                indexSet.set(true);
            }
        });
        panel.add(choose, BorderLayout.SOUTH);

        JButton searchButton = new JButton("Search these items");
        searchButton.addActionListener(e ->{
            (new Thread(){
                public void run(){
                    int[] indexes = searchItems(itemChoices, itemChooseFrame);
                    int[] current = list.getSelectedIndices();
                    int[] newSet;
                    if(current.length > 0) {
                        newSet = new int[indexes.length + current.length];
                        for (int i = 0; i < current.length; i++) newSet[i] += current[i];
                        for (int i = current.length; i < newSet.length; i++) {
                            newSet[i] = indexes[i - current.length];
                        }
                    } else newSet = indexes;

                    list.setSelectedIndices(newSet);
                }
            }).start();
        });

        JButton customItem = new JButton("Choose custom item");
        customItem.addActionListener(e -> {
            JDialog customItemDialog = new JDialog(itemChooseFrame, "Choose a custom item");
            customItemDialog.setSize(340,80);
            JPanel customFeatPanel = new JPanel();
            customItemDialog.add(customFeatPanel);
            JButton create = new JButton("Create a new item");
            JButton load = new JButton("Load an existing item");
            customFeatPanel.add(create);
            customFeatPanel.add(load);
            create.addActionListener(evt -> {
                customItemDialog.dispose();
                (new Thread(){
                    public void run(){
                        Item item = Item.createNewItem(itemChooseFrame);
                        if(item != null){
                            itemChoices.add(item);
                            int[] current = list.getSelectedIndices();
                            int[] newIndices = new int[current.length + 1];
                            for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                            newIndices[newIndices.length - 1] = itemChoices.size() - 1;
                            list.setListData(itemChoices.toArray(new Item[itemChoices.size()]));
                            list.setSelectedIndices(newIndices);
                        }
                    }
                }).start();
            });

            load.addActionListener(evt -> {
                customItemDialog.dispose();
                JFileChooser loadChooser = new JFileChooser();
                int returned = loadChooser.showOpenDialog(itemChooseFrame);
                if(returned == JFileChooser.APPROVE_OPTION){
                    Item item = null;
                    try{
                        FileInputStream fileIn = new FileInputStream(loadChooser.getSelectedFile());
                        ObjectInputStream objIn = new ObjectInputStream(fileIn);
                        item = (Item)(objIn.readObject());

                    } catch (FileNotFoundException ex){
                        Pathfinder.showError("Could not load file","You may not have permissions to access the file.\nRun this in command for more details.");
                        ex.printStackTrace();
                    } catch (IOException ex){
                        Pathfinder.showError("Unknown IO Exception","Run this in command for more details.");
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex){
                        Pathfinder.showError("Not an item","It doesn't seem that there's an item saved in that file.\nThe file may be corrupt.");
                    } catch (ClassCastException ex){
                        Pathfinder.showError("Not an item", "It appears this is some other kind of Java object.");
                    }
                    if(item != null){
                        itemChoices.add(item);
                        int[] current = list.getSelectedIndices();
                        int[] newIndices = new int[current.length + 1];
                        for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                        newIndices[newIndices.length - 1] = itemChoices.size() - 1;
                        list.setListData(itemChoices.toArray(new Item[itemChoices.size()]));
                        list.setSelectedIndices(newIndices);
                    }
                }
            });
            customItemDialog.setVisible(true);
        });
        JPanel top = new JPanel(new BorderLayout());
        top.add(searchButton, BorderLayout.CENTER);
        top.add(customItem, BorderLayout.WEST);
        panel.add(top, BorderLayout.NORTH);

        itemChooseFrame.setSize(340, ((20+itemChoices.size()*10) < 600 ? (20+itemChoices.size()*15) : 600));
        itemChooseFrame.setLocationRelativeTo(null);
        itemChooseFrame.setVisible(true);

        while(!indexSet.get()){}
        itemChooseFrame.dispose();
        ArrayList<GenItem> toReturn = new ArrayList<>();
        for(int i : indices) toReturn.add( itemChoices.get(i) instanceof GenItem ? (GenItem)itemChoices.get(i) : new GenItem(itemChoices.get(i)) );
        return toReturn;
    }

    public static int[] searchSpells(List<Spell> spells, JFrame parent){
        JDialog searchDialog = new JDialog(parent, "Spell Search");
        AtomicBoolean selected = new AtomicBoolean(false);
        AtomicBoolean needsMythic = new AtomicBoolean(false);
        AtomicBoolean needsAugment = new AtomicBoolean(false);

        ArrayList<Spell> results = new ArrayList<>();
        results.addAll(spells);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel name = new JLabel("Name: ");
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel subschool = new JLabel("Subschool: ");
        subschool.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel descriptor = new JLabel("Descriptor: ");
        descriptor.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel classLabel = new JLabel("Class: ");
        classLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel level = new JLabel("Level: ");
        level.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel bloodline = new JLabel("Bloodline");
        bloodline.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel bloodlineLevel = new JLabel("Level: ");
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

        JComboBox<String> subschoolField = new JComboBox<>();
        subschoolField.addItem("");
        subschoolField.setPreferredSize(new Dimension(146, 25));
        subschoolField.setEditable(true);
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
        ArrayList<String> subschoolDone = new ArrayList<>();
        subschoolDone.add("");
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
            if(!subschoolDone.contains(spell.subschool.toLowerCase())){
                subschoolField.addItem(spell.subschool);
                subschoolDone.add(spell.subschool.toLowerCase());
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

        JTextField levelField = new JTextField();
        JTextField bloodlineLevelField = new JTextField();
        JCheckBox hasMythicBox = new JCheckBox();
        JCheckBox hasAugmentBox = new JCheckBox();
        JTextField descriptionContainsField = new JTextField();

        c.weighty = 0;
        c.weightx = 0;
        c.fill = GridBagConstraints.BOTH;
        panel.add(name, c);
        c.gridy = 1;
        panel.add(subschool, c);
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
        panel.add(subschoolField, c);
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
        panel.add(hasAugmentBox, c);
        c.gridy = 3;
        panel.add(levelField, c);
        c.gridy = 4;
        panel.add(bloodlineLevelField, c);
        c.gridy = 5;
        panel.add(hasMythicBox, c);

        JButton searchButton = new JButton("Search with these values");
        c.gridy = 7;
        c.gridx = 0;
        c.gridwidth = 4;
        panel.add(searchButton, c);


        JList<Spell> resultsList = new JList<>();
        resultsList.setCellRenderer(new SpellCellRenderer());

        resultsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    Spells.showSpellDetails(results.get(index));
                }
            }
        });

        JScrollPane resultsScroll = new JScrollPane(resultsList){
            public void paintComponent(Graphics g){
                resultsList.setListData(results.toArray(new Spell[results.size()]));
            }
        };
        c.gridy++;
        c.weightx = 1;
        c.weighty = 1;
        panel.add(resultsScroll, c);

        JButton select = new JButton("Select chosen spell(s)");
        c.gridy++;
        c.weighty = 0;
        panel.add(select, c);

        select.addActionListener(e -> selected.set(true));

        searchDialog.add(panel);
        searchDialog.setSize(500,600);
        searchDialog.setLocationRelativeTo(null);
        searchDialog.setVisible(true);

        hasAugmentBox.addActionListener(e -> needsAugment.set(!needsAugment.get()));
        hasMythicBox.addActionListener(e -> needsMythic.set(!needsMythic.get()));


        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                results.clear();
                results.addAll(spells);

                ArrayList<Spell> intermediary = new ArrayList<>();

                if(!nameField.getText().equals("")){
                    intermediary.addAll(results.stream().filter(spell -> spell.name.toLowerCase().contains(nameField.getText().toLowerCase())).collect(Collectors.toList()));
                    results.clear();
                    results.addAll(intermediary);
                    intermediary.clear();
                }
                if(!((String)subschoolField.getSelectedItem()).equals("")){
                    intermediary.addAll(results.stream().filter(spell -> spell.subschool.toLowerCase().contains(((String)subschoolField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
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
                    if(!levelField.getText().trim().equals("")){
                        intermediary.addAll(results.stream().filter(spell -> Spells.spellLevelFor(classField.getText(), spell) == Integer.parseInt(levelField.getText())).collect(Collectors.toList()));
                        results.clear();
                        results.addAll(intermediary);
                        intermediary.clear();
                    }
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
                    if(!bloodlineLevelField.getText().trim().equals("")) {
                        intermediary.addAll(results.stream().filter(spell -> spell.bloodlineLevels.get(((String)bloodlineField.getSelectedItem())) == Integer.parseInt(bloodlineLevelField.getText())).collect(Collectors.toList()));
                        results.clear();
                        results.addAll(intermediary);
                        intermediary.clear();
                    }
                }
                if(!((String)domainField.getSelectedItem()).equals("")) {
                    intermediary.addAll(results.stream().filter(spell -> spell.hasDomain && spell.domain.toLowerCase().contains(((String)domainField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                    results.clear();
                    results.addAll(intermediary);
                    intermediary.clear();
                }
                if(needsAugment.get()) {
                    intermediary.addAll(results.stream().filter(spell -> spell.hasAugment).collect(Collectors.toList()));
                    results.clear();
                    results.addAll(intermediary);
                    intermediary.clear();
                }
                if(needsMythic.get()) {
                    intermediary.addAll(results.stream().filter(spell -> spell.hasMythic).collect(Collectors.toList()));
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
            }
        });


        while(!selected.get()){}

        ArrayList<Spell> spellsSelected = new ArrayList<>();
        int[] indices = resultsList.getSelectedIndices();
        for(int i : indices) spellsSelected.add(results.get(i));
        int[] toReturn = new int[spellsSelected.size()];
        int index = 0;
        for(int i = 0; i < spells.size(); i++){
            if(spellsSelected.contains(spells.get(i))){
                toReturn[index] = i;
                index++;
            }
        }

        searchDialog.dispose();

        return toReturn;
    }

    public static int[] searchFeats(List<Feat> feats, JFrame parent){
        JDialog searchDialog = new JDialog(parent, "Feat Search");

        AtomicBoolean selected = new AtomicBoolean(false);
        AtomicBoolean needsTeamwork = new AtomicBoolean(false);
        AtomicBoolean needsCritical = new AtomicBoolean(false);
        AtomicBoolean needsGrit = new AtomicBoolean(false);
        AtomicBoolean needsStyle = new AtomicBoolean(false);
        AtomicBoolean needsPerformance = new AtomicBoolean(false);
        AtomicBoolean needsRacial = new AtomicBoolean(false);
        AtomicBoolean needsCompanionFamiliar = new AtomicBoolean(false);
        AtomicBoolean needsCanDoMultiple = new AtomicBoolean(false);
        AtomicBoolean needsPanache = new AtomicBoolean(false);
        AtomicBoolean needsBetrayal = new AtomicBoolean(false);
        AtomicBoolean needsTargeting = new AtomicBoolean(false);
        AtomicBoolean needsEsoteric = new AtomicBoolean(false);
        AtomicBoolean needsStare = new AtomicBoolean(false);
        AtomicBoolean needsWeaponMastery = new AtomicBoolean(false);
        AtomicBoolean needsItemMastery = new AtomicBoolean(false);
        AtomicBoolean needsArmorMastery = new AtomicBoolean(false);
        AtomicBoolean needsShieldMastery = new AtomicBoolean(false);

        ArrayList<Feat> results = new ArrayList<>();
        results.addAll(feats);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel name = new JLabel("Name: ");
        name.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel type = new JLabel("Type: ");
        type.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel subType = new JLabel("Sub-type: ");
        subType.setBorder(BorderFactory.createLineBorder(Color.black));
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

        JTextField fullTextField = new JTextField();

        JComboBox<String> raceNameField = new JComboBox<>();
        JComboBox<String> subtypeField = new JComboBox<>();
        JComboBox<String> typeField = new JComboBox<>();
        raceNameField.setEditable(true);
        subtypeField.setEditable(true);
        typeField.setEditable(true);
        typeField.addItem("");
        ArrayList<String> alreadyAddedRace = new ArrayList<>();
        ArrayList<String> alreadyAddedType = new ArrayList<>();
        ArrayList<String> alreadyAddedSubtype = new ArrayList<>();
        ArrayList<String> featNames = new ArrayList<>();
        for(Feat feat : Feats.getFeats()){
            featNames.add(feat.name);
            String[] names;
            if(feat.raceName.contains(",")) names = feat.raceName.split(",");
            else names = feat.raceName.split("\\|");
            for(String race : names){
                String toCheck = race.trim();
                if(!alreadyAddedRace.contains(toCheck.toLowerCase())){
                    raceNameField.addItem(toCheck);
                    alreadyAddedRace.add(toCheck.toLowerCase());
                }
            }
            if(!alreadyAddedType.contains(feat.type.toLowerCase())){
                alreadyAddedType.add(feat.type.toLowerCase());
                typeField.addItem(feat.type);
            }
            if(!alreadyAddedSubtype.contains(feat.subType.toLowerCase())){
                alreadyAddedSubtype.add(feat.subType.toLowerCase());
                subtypeField.addItem(feat.subType);
            }
        }

        AutofillTextArea nameField = new AutofillTextArea(featNames, 5);


        JCheckBox racialBox = new JCheckBox();
        JCheckBox teamworkBox = new JCheckBox();
        JCheckBox criticalBox = new JCheckBox();
        JCheckBox gritBox = new JCheckBox();
        JCheckBox styleBox = new JCheckBox();
        JCheckBox performanceBox = new JCheckBox();
        JCheckBox companionFamiliarBox = new JCheckBox();
        JCheckBox canDoMultipleBox = new JCheckBox();
        JCheckBox panacheBox = new JCheckBox();
        JCheckBox betrayalBox = new JCheckBox();
        JCheckBox targetingBox = new JCheckBox();
        JCheckBox esotericBox = new JCheckBox();
        JCheckBox stareBox = new JCheckBox();
        JCheckBox weaponMasteryBox = new JCheckBox();
        JCheckBox itemMasteryBox = new JCheckBox();
        JCheckBox armorMasteryBox = new JCheckBox();
        JCheckBox shieldMasteryBox = new JCheckBox();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0;
        c.weighty = 0;
        c.gridy = 0;
        c.gridx = 0;
        panel.add(name, c);
        c.gridy = 1;
        panel.add(type,c);
        c.gridy = 2;
        panel.add(subType, c);
        c.gridy = 3;
        panel.add(containsText, c);
        c.gridy = 4;
        panel.add(racial, c);
        c.gridx = 2;
        panel.add(raceName, c);
        c.weightx = 1;
        c.gridy = 0;
        c.gridx = 1;
        panel.add(nameField, c);
        c.gridy = 1;
        panel.add(typeField, c);
        c.gridy = 2;
        panel.add(subtypeField, c);
        c.gridy = 3;
        panel.add(fullTextField, c);
        c.gridy = 4;
        panel.add(racialBox, c);
        c.gridx = 3;
        panel.add(raceNameField, c);

        JPanel inner = new JPanel(new GridBagLayout());
        JScrollPane scroll = new JScrollPane(inner);
        scroll.setPreferredSize(new Dimension(0,0));
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 4;
        c.weightx = 1;
        c.weighty = 0;
        panel.add(scroll, c);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        inner.add(teamwork, c);
        c.gridy = 1;
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

        racialBox.addActionListener(e -> needsRacial.set(!needsRacial.get()));
        teamworkBox.addActionListener(e -> needsTeamwork.set(!needsTeamwork.get()));
        criticalBox.addActionListener(e -> needsCritical.set(!needsCritical.get()));
        gritBox.addActionListener(e -> needsGrit.set(!needsGrit.get()));
        styleBox.addActionListener(e -> needsStyle.set(!needsStyle.get()));
        performanceBox.addActionListener(e -> needsPerformance.set(!needsPerformance.get()));
        companionFamiliarBox.addActionListener(e -> needsCompanionFamiliar.set(!needsCompanionFamiliar.get()));
        canDoMultipleBox.addActionListener(e -> needsCanDoMultiple.set(!needsCanDoMultiple.get()));
        panacheBox.addActionListener(e -> needsPanache.set(!needsPanache.get()));
        betrayalBox.addActionListener(e -> needsBetrayal.set(!needsBetrayal.get()));
        targetingBox.addActionListener(e -> needsTargeting.set(!needsTargeting.get()));
        esotericBox.addActionListener(e -> needsEsoteric.set(!needsEsoteric.get()));
        stareBox.addActionListener(e -> needsStare.set(!needsStare.get()));
        weaponMasteryBox.addActionListener(e -> needsWeaponMastery.set(!needsWeaponMastery.get()));
        itemMasteryBox.addActionListener(e -> needsItemMastery.set(!needsItemMastery.get()));
        armorMasteryBox.addActionListener(e -> needsArmorMastery.set(!needsArmorMastery.get()));
        shieldMasteryBox.addActionListener(e -> needsShieldMastery.set(!needsShieldMastery.get()));


        JButton searchButton = new JButton("Search with these values");
        c.gridy = 7;
        c.gridx = 0;
        c.gridwidth = 4;
        panel.add(searchButton, c);


        JList<Feat> resultsList = new JList<>();
        resultsList.setCellRenderer(new FeatCellRenderer());

        resultsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    Feats.showFeatDetails(results.get(index));
                }
            }
        });

        JScrollPane resultsScroll = new JScrollPane(resultsList){
            public void paintComponent(Graphics g){
                resultsList.setListData(results.toArray(new Feat[results.size()]));
            }
        };
        c.gridy++;
        c.weightx = 1;
        c.weighty = 1;
        panel.add(resultsScroll, c);

        JButton select = new JButton("Select chosen feat(s)");
        c.gridy++;
        c.weighty = 0;
        panel.add(select, c);

        select.addActionListener(e -> selected.set(true));


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
            if(!((String)typeField.getSelectedItem()).equals("")){
                intermediary.addAll(results.stream().filter(feat -> feat.type.toLowerCase().contains(((String)typeField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(!((String)subtypeField.getSelectedItem()).equals("")){
                intermediary.addAll(results.stream().filter(feat -> feat.subType.toLowerCase().contains(((String)subtypeField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
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
            if(needsRacial.get()){
                intermediary.addAll(results.stream().filter(feat -> feat.racial).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
                if(!((String)raceNameField.getSelectedItem()).trim().equals("")) {
                    intermediary.addAll(results.stream().filter(feat -> feat.raceName.toLowerCase().contains(((String)raceNameField.getSelectedItem()).toLowerCase())).collect(Collectors.toList()));
                    results.clear();
                    results.addAll(intermediary);
                    intermediary.clear();
                }
            }
            if(needsTeamwork.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.teamwork).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsCritical.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.critical).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsGrit.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.grit).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsStyle.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.style).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsPerformance.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.performance).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsCompanionFamiliar.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.companionOrFamiliar).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsCanDoMultiple.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.canDoMultiple).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsPanache.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.panache).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsBetrayal.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.betrayal).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsTargeting.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.targeting).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsEsoteric.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.esoteric).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsStare.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.stare).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsWeaponMastery.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.weaponMastery).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsItemMastery.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.itemMastery).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsArmorMastery.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.armorMastery).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }
            if(needsShieldMastery.get()) {
                intermediary.addAll(results.stream().filter(feat -> feat.shieldMastery).collect(Collectors.toList()));
                results.clear();
                results.addAll(intermediary);
                intermediary.clear();
            }

            resultsScroll.repaint();
        });

        searchDialog.add(panel);
        searchDialog.setSize(500,600);
        searchDialog.setLocationRelativeTo(null);
        searchDialog.setVisible(true);

        while(!selected.get()){}

        ArrayList<Feat> spellsSelected = new ArrayList<>();
        int[] indices = resultsList.getSelectedIndices();
        for(int i : indices) spellsSelected.add(results.get(i));
        int[] toReturn = new int[spellsSelected.size()];
        int index = 0;
        for(int i = 0; i < feats.size(); i++){
            if(spellsSelected.contains(feats.get(i))){
                toReturn[index] = i;
                index++;
            }
        }

        searchDialog.dispose();

        return toReturn;
    }

    public static List<Spell> chooseSpellFromList(List<Spell> spellChoices, String title, int maxPicks){
        AtomicBoolean indexSet = new AtomicBoolean(false);
        String[] choices = new String[spellChoices.size()];
        for(int i = 0; i < choices.length; i++) choices[i] = spellChoices.get(i).toString();
        JFrame spellChooseFrame = new JFrame(title);
        JPanel panel = new JPanel(new BorderLayout());
        spellChooseFrame.add(panel);
        JList<Spell> list = new JList<>(spellChoices.toArray(new Spell[spellChoices.size()]));
        list.setCellRenderer(new SpellCellRenderer());

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    Spells.showSpellDetails(spellChoices.get(index));
                }
            }
        });

        JScrollPane scrollList = new JScrollPane(list);
        panel.add(scrollList,BorderLayout.CENTER);
        JButton choose = new JButton("Learn selected spell(s)");
        choose.addActionListener(e -> {
            if(list.getSelectedIndex() > -1){
                if(maxPicks == -1 || list.getSelectedIndices().length == maxPicks || (list.getSelectedIndices().length < maxPicks && Pathfinder.askYesNo("You have only selected " + list.getSelectedIndices().length + " of " + maxPicks + " spells. Continue?")) || (list.getSelectedIndices().length > maxPicks && Pathfinder.askYesNo("You have selected too many spells. Continue anyway?"))) {
                    indices = list.getSelectedIndices();
                    indexSet.set(true);
                }
            }
        });
        panel.add(choose, BorderLayout.SOUTH);

        JButton searchButton = new JButton("Search these spells");
        searchButton.addActionListener(e ->{
            (new Thread(){
                public void run(){
                    int[] indexes = searchSpells(spellChoices, spellChooseFrame);
                    int[] current = list.getSelectedIndices();
                    int[] newSet;
                    if(current.length > 0) {
                        newSet = new int[indexes.length + current.length];
                        for (int i = 0; i < current.length; i++) newSet[i] += current[i];
                        for (int i = current.length; i < newSet.length; i++) {
                            newSet[i] = indexes[i - current.length];
                        }
                    } else newSet = indexes;

                    list.setSelectedIndices(newSet);
                }
            }).start();
        });

        JButton customSpell = new JButton("Choose custom spell");
        customSpell.addActionListener(e -> {
            JDialog customFeatDialog = new JDialog(spellChooseFrame, "Choose a custom spell");
            customFeatDialog.setSize(340,80);
            JPanel customFeatPanel = new JPanel();
            customFeatDialog.add(customFeatPanel);
            JButton create = new JButton("Create a new spell");
            JButton load = new JButton("Load an existing spell");
            customFeatPanel.add(create);
            customFeatPanel.add(load);
            create.addActionListener(evt -> {
                customFeatDialog.dispose();
                (new Thread(){
                    public void run(){
                        Spell spell = Spells.createNewSpell(spellChooseFrame);
                        if(spell != null){
                            spellChoices.add(spell);
                            int[] current = list.getSelectedIndices();
                            int[] newIndices = new int[current.length + 1];
                            for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                            newIndices[newIndices.length - 1] = spellChoices.size() - 1;
                            list.setListData(spellChoices.toArray(new Spell[spellChoices.size()]));
                            list.setSelectedIndices(newIndices);
                        }
                    }
                }).start();
            });

            load.addActionListener(evt -> {
                customFeatDialog.dispose();
                JFileChooser loadChooser = new JFileChooser();
                int returned = loadChooser.showOpenDialog(spellChooseFrame);
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
                        spellChoices.add(spell);
                        int[] current = list.getSelectedIndices();
                        int[] newIndices = new int[current.length + 1];
                        for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                        newIndices[newIndices.length - 1] = spellChoices.size() - 1;
                        list.setListData(spellChoices.toArray(new Spell[spellChoices.size()]));
                        list.setSelectedIndices(newIndices);
                    }
                }
            });
            customFeatDialog.setVisible(true);
        });
        JPanel top = new JPanel(new BorderLayout());
        top.add(searchButton, BorderLayout.CENTER);
        top.add(customSpell, BorderLayout.WEST);
        panel.add(top, BorderLayout.NORTH);

        spellChooseFrame.setSize(340, ((20+spellChoices.size()*10) < 600 ? (20+spellChoices.size()*15) : 600));
        spellChooseFrame.setLocationRelativeTo(null);
        spellChooseFrame.setVisible(true);

        while(!indexSet.get()){}
        spellChooseFrame.dispose();
        ArrayList<Spell> toReturn = new ArrayList<>();
        for(int i : indices) toReturn.add(spellChoices.get(i));
        return toReturn;
    }

    public static List<Feat> chooseFeatFromList(List<Feat> featChoices, String title, int maxPicks){
        AtomicBoolean indexSet = new AtomicBoolean(false);
        JFrame featChooseFrame = new JFrame(title);
        JPanel panel = new JPanel(new BorderLayout());
        featChooseFrame.add(panel);
        JList<Feat> list = new JList<>(featChoices.toArray(new Feat[featChoices.size()]));
        list.setCellRenderer(new FeatCellRenderer());

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() > 1) {
                    int index = list.locationToIndex(evt.getPoint());
                    Feats.showFeatDetails(featChoices.get(index));
                }
            }
        });

        JScrollPane scrollList = new JScrollPane(list);
        panel.add(scrollList,BorderLayout.CENTER);
        JButton choose = new JButton("Learn selected feat");
        choose.addActionListener(e -> {
            if(list.getSelectedIndices().length > 0){
                if(maxPicks == -1 || list.getSelectedIndices().length == maxPicks || (list.getSelectedIndices().length < maxPicks && Pathfinder.askYesNo("You have only selected " + list.getSelectedIndices().length + " of " + maxPicks + " spells. Continue?")) || (list.getSelectedIndices().length > maxPicks && Pathfinder.askYesNo("You have selected too many spells. Continue anyway?"))) {
                    indices = list.getSelectedIndices();
                    indexSet.set(true);
                }
            }
        });
        panel.add(choose, BorderLayout.SOUTH);


        JButton searchButton = new JButton("Search these feats");
        searchButton.addActionListener(e ->{
            (new Thread(){
                public void run(){
                    int[] indexes = searchFeats(featChoices, featChooseFrame);
                    int[] current = list.getSelectedIndices();
                    int[] newSet;
                    if(current.length > 0) {
                        newSet = new int[indexes.length + current.length];
                        for (int i = 0; i < current.length; i++) newSet[i] += current[i];
                        for (int i = current.length; i < newSet.length; i++) {
                            newSet[i] = indexes[i - current.length];
                        }
                    } else newSet = indexes;

                    list.setSelectedIndices(newSet);
                }
            }).start();
        });

        JButton customFeat = new JButton("Choose custom feat");
        customFeat.addActionListener(e -> {
            JDialog customFeatDialog = new JDialog(featChooseFrame, "Choose a custom feat");
            customFeatDialog.setSize(320,80);
            JPanel customFeatPanel = new JPanel();
            customFeatDialog.add(customFeatPanel);
            JButton create = new JButton("Create a new feat");
            JButton load = new JButton("Load an existing feat");
            customFeatPanel.add(create);
            customFeatPanel.add(load);
            create.addActionListener(evt -> {
                customFeatDialog.dispose();
                (new Thread(){
                    public void run(){
                        Feat feat = Feats.createNewFeat(featChooseFrame);
                        if(feat != null){
                            featChoices.add(feat);
                            int[] current = list.getSelectedIndices();
                            int[] newIndices = new int[current.length + 1];
                            for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                            newIndices[newIndices.length - 1] = featChoices.size() - 1;
                            list.setListData(featChoices.toArray(new Feat[featChoices.size()]));
                            list.setSelectedIndices(newIndices);
                        }
                    }
                }).start();
            });

            load.addActionListener(evt -> {
                customFeatDialog.dispose();
                JFileChooser loadChooser = new JFileChooser();
                int returned = loadChooser.showOpenDialog(featChooseFrame);
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
                        Pathfinder.showError("Not a feat","It seems this is some other type of Java object.");
                    }
                    if(feat != null){
                        featChoices.add(feat);
                        int[] current = list.getSelectedIndices();
                        int[] newIndices = new int[current.length + 1];
                        for(int i = 0; i < current.length; i++) newIndices[i] = current[i];
                        newIndices[newIndices.length - 1] = featChoices.size() - 1;
                        list.setListData(featChoices.toArray(new Feat[featChoices.size()]));
                        list.setSelectedIndices(newIndices);
                    }
                }
            });
            customFeatDialog.setVisible(true);
        });
        JPanel top = new JPanel(new BorderLayout());
        top.add(searchButton, BorderLayout.CENTER);
        top.add(customFeat, BorderLayout.WEST);
        panel.add(top, BorderLayout.NORTH);


        featChooseFrame.setSize(320, ((60+featChoices.size()*20) < 600 ? (20+featChoices.size()*15) : 600));
        featChooseFrame.setLocationRelativeTo(null);
        featChooseFrame.setVisible(true);

        while(!indexSet.get()){}
        indexSet.set(false);
        featChooseFrame.dispose();
        ArrayList<Feat> toReturn = new ArrayList<>();
        for(int i : indices) toReturn.add(featChoices.get(i));
        return toReturn;
    }

    public static void chooseClassToLevel(Character me, Component characterDisplay){

        String[] classNames = CharacterClass.getClassNames();

        for(CharacterClass charClass : me.classes){
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
}