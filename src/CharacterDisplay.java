package src;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

import src.classes.CharacterClass;
import src.spells.*;
import src.stats.*;
import java.util.ArrayList;

public class CharacterDisplay extends JTabbedPane{
	private Character me;
	private ArrayList<CharacterClass> currentCasters = new ArrayList<>();

	public CharacterDisplay(Character me){
		this.me = me;

		GridBagLayout topLayout = new GridBagLayout();
		JPanel genPan = new JPanel(topLayout);
		GridBagConstraints c = new GridBagConstraints();
		JLabel name = new JLabel(me.name);
		c.gridwidth = 6;
		genPan.add(name, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel picture = new JLabel(new ImageIcon(me.getImageLocation()));
		c.weightx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 7;
		genPan.add(picture, c);

		JLabel race = new JLabel(me.race.toString());
		c.fill = GridBagConstraints.NONE;
		c.weightx = 1;
		c.gridx = 2;
		c.gridwidth = 2;
		c.gridheight = 1;
		genPan.add(race, c);

		JLabel charClass = new JLabel(me.getCharacterClassesAsString());
		c.gridx = 4;
		genPan.add(charClass, c);

		JTextField backgroundJob = new JTextField();
		backgroundJob.setText(me.job != null ? me.job : "Background job");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		genPan.add(backgroundJob, c);

		JTextField alignment = new JTextField();
		alignment.setText(me.alignment != null ? me.alignment : "Alignment");
		c.gridx = 4;
		genPan.add(alignment, c);

		JTextArea physicalDesc = new JTextArea();
		physicalDesc.setLineWrap(true);
		physicalDesc.setText(me.physDesc != null ? me.physDesc : "Physical Description");
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.weighty = 0.0000001;
		c.gridy = 3;
		c.gridwidth = 4;
		c.gridheight = 1;
		JScrollPane physDescScroll = new JScrollPane(physicalDesc);
		genPan.add(physDescScroll, c);

		JButton savePhysDesc = new JButton("Update");
		c.gridheight = 1;
		c.weighty = 0;
		c.gridy = 4;
		genPan.add(savePhysDesc,c);

		JLabel classesLabel = new JLabel("Your current classes");
		c.gridy = 5;
		c.fill = GridBagConstraints.NONE;
		genPan.add(classesLabel,c);


		ClassesBox classesBox = new ClassesBox();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridy = 6;
		c.gridheight = 2;
		c.weighty = 0.00000001;
		genPan.add(classesBox, c);


		JTextArea charBackground = new JTextArea();
		charBackground.setLineWrap(true);
		charBackground.setText(me.background != null ? me.background : "Character background");
		JScrollPane charBackgroundScroll = new JScrollPane(charBackground);
		c.gridx = 0;
		c.gridwidth = 6;
		c.gridy = 8;
		c.weighty = 1;
		c.gridheight = 4;
		genPan.add(charBackgroundScroll, c);

		JButton saveBackground = new JButton("Update");
		c.gridheight = 1;
		c.gridy = 13;
		c.weighty = 0;
		genPan.add(saveBackground,c);

		addTab("General",null, genPan,"Your character's general information.");

		addTab("Stats", null, new StatsTab(), "Your character's stats");

		addTab("Inventory",null,new InventoryTab(this),"Your inventory");

		addTab("Abilities/Feats", null, new AbilityTab(), "Your feats, notes, and misc abilities.");

		for(CharacterClass toCheck : me.classes){
			if(toCheck.isCaster){
				addTab(toCheck.toString(), null, new SpellCasterTab(toCheck), "Spell information for this class");
				currentCasters.add(toCheck);
			}
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		for(CharacterClass toCheck : me.classes){
			if(toCheck.isCaster && !currentCasters.contains(toCheck)){
				addTab(toCheck.toString(), null, new SpellCasterTab(toCheck), "Spell information for this class");
				currentCasters.add(toCheck);
			}
		}

	}

	private class StatsTab extends JPanel{
		private JTextField totalHPField;
		JTextField currentHPField;
		JTextField tempHPField;
		JTextField nonlethalField;
		private JLabel level;

		private AbilitiesBox abilitiesBox;
		private SkillBox skillBox;
		private CombatStatBox combatStatBox;

		private CurrentEffectsBox effectsBox;

		public StatsTab(){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			JPanel topPanel = new JPanel(new GridBagLayout());

			JLabel totalHPLabel = new JLabel("Total HP:");
			c.gridy = 0;
			c.fill = GridBagConstraints.BOTH;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.weightx = 0.00001;
			c.weighty = 0;
			c.ipadx = 10;
			topPanel.add(totalHPLabel,c);

			totalHPField = new JTextField();
			totalHPField.setText(Integer.toString(me.totalHP));
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.weightx = 1;
			topPanel.add(totalHPField, c);

			c.weightx = 0.00001;
			c.gridy = 1;
			c.gridx = 0;
			topPanel.add(new JLabel("Current HP:"),c);

			c.ipadx = 0;
			currentHPField = new JTextField(Integer.toString(me.currentHP));
			c.weightx = 1;
			c.gridx = 1;
			topPanel.add(currentHPField, c);

			JLabel tempHP = new JLabel("Temp HP:");
			c.weightx = 0.00001;
			c.ipadx = 10;
			c.gridx = 2;
			c.gridy = 0;
			topPanel.add(tempHP, c);

			JLabel nonlethal = new JLabel("Nonlethal DMG:");
			c.gridy = 1;
			topPanel.add(nonlethal, c);

			tempHPField = new JTextField(Integer.toString(me.tempHP));
			c.weightx = 1;
			c.ipadx = 0;
			c.gridx = 3;
			c.gridy = 0;
			topPanel.add(tempHPField, c);

			nonlethalField = new JTextField(Integer.toString(me.nonlethalDamage));
			c.gridy = 1;
			topPanel.add(nonlethalField, c);

			level = new JLabel("Level: " + me.getTotalLevel());
			c.weightx = 0.00001;
			c.gridy = 0;
			c.gridx = 4;
			topPanel.add(level,c);

			JButton levelUp = new JButton("Level up!");
			levelUp.addActionListener(e -> {
				chooseLevelUp();
			});
			c.gridy = 1;
			topPanel.add(levelUp,c);

			JButton attackButton = new JButton("Roll to attack!");
			c.weighty = 0;
			c.gridy = 0;
			c.gridx = 5;
			c.gridheight = 2;
			topPanel.add(attackButton, c);

			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0;
			c.weightx = 1;
			c.weighty = 0;
			c.gridwidth = 6;
			c.gridheight = 2;
			add(topPanel, c);


			abilitiesBox = new AbilitiesBox(this);
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 4;
			c.gridheight = 7;
			c.weighty = 0;
			c.weightx = 1;
			c.fill = GridBagConstraints.BOTH;
			add(abilitiesBox, c);

			skillBox = new SkillBox();
			JScrollPane skillBoxScroll = new JScrollPane(skillBox);
			c.gridx = 0;
			c.gridy = 9;
			c.gridheight = 10;
			c.gridwidth = 4;
			c.weightx = 1;
			c.weighty = 1;
			add(skillBoxScroll, c);

			combatStatBox = new CombatStatBox();
			c.gridx = 4;
			c.gridwidth = 2;
			c.gridheight = 7;
			c.gridy = 2;
			c.weighty = 0;
			c.weightx = 0.5;
			add(combatStatBox, c);

			effectsBox = new CurrentEffectsBox();
			c.gridy = 9;
			c.gridx = 4;
			c.weighty = 1;
			c.gridwidth = 2;
			c.gridheight = 10;
			c.weightx = 0.5;
			add(effectsBox, c);
		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			totalHPField.setText(Integer.toString(me.totalHP));
			level.setText("Level: " + me.getTotalLevel());
			currentHPField.setText(Integer.toString(me.currentHP));
			tempHPField.setText(Integer.toString(me.tempHP));
			nonlethalField.setText(Integer.toString(me.nonlethalDamage));
			skillBox.updateTextFields();
		}

		public void chooseLevelUp(){
			//New thread -> Choose class to level, then run levelup
		}
	}

	private class CombatStatBox extends JPanel{
		private JTextField acField;
		private JTextField touchACField;
		private JTextField fortSaveField;
		private JTextField willSaveField;
		private JTextField refSaveField;
		private JTextField meleeModifierField;
		private JTextField rangedModifierField;
		private JTextField cmbField;
		private JTextField cmdField;
		private JTextField babField;

		public CombatStatBox(){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			c.weighty = 1;
			c.weightx = 1;
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 2;
			c.gridheight = 1;
			c.fill = GridBagConstraints.NONE;
			add(new JLabel("Combat Stats"), c);

			c.fill = GridBagConstraints.BOTH;
			c.gridwidth = 1;
			c.gridy = 1;
			JLabel tempReference = new JLabel("AC");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 2;
			tempReference = new JLabel("Touch AC");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 3;
			tempReference = new JLabel("Fortitude Save");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 4;
			tempReference = new JLabel("Will Save");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 5;
			tempReference = new JLabel("Reflex Save");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 6;
			tempReference = new JLabel("Melee Modifier");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 7;
			tempReference = new JLabel("Ranged Modifier");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 8;
			tempReference = new JLabel("CMB");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 9;
			tempReference = new JLabel("CMD");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 10;
			tempReference = new JLabel("BAB");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridx = 1;
			c.gridy = 1;
			acField = new JTextField(Integer.toString(me.getAC()));
			acField.addActionListener(e -> me.setAC(Integer.parseInt(acField.getText())));
			add(acField,c);

			c.gridy = 2;
			touchACField = new JTextField(Integer.toString(me.getTouchAC()));
			touchACField.addActionListener(e -> me.setTouchAC(Integer.parseInt(touchACField.getText())));
			add(touchACField,c);

			c.gridy = 3;
			fortSaveField = new JTextField(Integer.toString(me.getFortSave()));
			fortSaveField.addActionListener(e -> me.setFortSave(Integer.parseInt(fortSaveField.getText())));
			add(fortSaveField,c);

			c.gridy = 4;
			willSaveField = new JTextField(Integer.toString(me.getWillSave()));
			willSaveField.addActionListener(e -> me.setWillSave(Integer.parseInt(willSaveField.getText())));
			add(willSaveField,c);

			c.gridy = 5;
			refSaveField = new JTextField(Integer.toString(me.getRefSave()));
			refSaveField.addActionListener(e -> me.setRefSave(Integer.parseInt(refSaveField.getText())));
			add(refSaveField,c);

			c.gridy = 6;
			meleeModifierField = new JTextField(Integer.toString(me.getMeleeModifier()));
			meleeModifierField.addActionListener(e -> me.setMeleeModifier(Integer.parseInt(meleeModifierField.getText())));
			add(meleeModifierField,c);

			c.gridy = 7;
			rangedModifierField = new JTextField(Integer.toString(me.getRangedModifier()));
			rangedModifierField.addActionListener(e -> me.setRangedModifier(Integer.parseInt(rangedModifierField.getText())));
			add(rangedModifierField,c);

			c.gridy = 8;
			cmbField = new JTextField(Integer.toString(me.getCMB()));
			cmbField.addActionListener(e -> me.setCMB(Integer.parseInt(cmbField.getText())));
			add(cmbField, c);

			c.gridy = 9;
			cmdField = new JTextField(Integer.toString(me.getCMD()));
			cmdField.addActionListener(e -> me.setCMD(Integer.parseInt(cmdField.getText())));
			add(cmdField, c);

			babField = new JTextField(me.getBABAsString());
			babField.addActionListener(e -> {
				me.setBAB(babField.getText());
				repaint();
			});
			c.gridy = 10;
			add(babField,c);
		}

		public void paintComponent(Graphics g){
			babField.setText(me.getBABAsString());
			acField.setText(Integer.toString(me.getAC()));
			touchACField.setText(Integer.toString(me.getTouchAC()));
			fortSaveField.setText(Integer.toString(me.getFortSave()));
			willSaveField.setText(Integer.toString(me.getWillSave()));
			refSaveField.setText(Integer.toString(me.getRefSave()));
			meleeModifierField.setText(Integer.toString(me.getMeleeModifier()));
			rangedModifierField.setText(Integer.toString(me.getRangedModifier()));
			cmbField.setText(Integer.toString(me.getCMB()));
			cmdField.setText(Integer.toString(me.getCMD()));
		}

	}

	private class AbilitiesBox extends JPanel{
		private JTextField strField;
		private JTextField conField;
		private JTextField wisField;
		private JTextField intField;
		private JTextField chaField;
		private JTextField dexField;
		private JTextField tempSTRField;
		private JTextField tempCONField;
		private JTextField tempWISField;
		private JTextField tempINTField;
		private JTextField tempCHAField;
		private JTextField tempDEXField;
		private JLabel chaMod;
		private JLabel strMod;
		private JLabel conMod;
		private JLabel wisMod;
		private JLabel intMod;
		private JLabel dexMod;

		StatsTab parent;
		public AbilitiesBox(StatsTab parent){
			this.parent = parent;

			setLayout(new GridBagLayout());

			GridBagConstraints c = new GridBagConstraints();

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.gridx = 0;
			c.gridheight = 1;
			c.gridy = 0;
			c.weighty = 1;
			c.gridwidth = 1;
			//c.ipadx = 10;
			add(new JLabel("Abilities"), c);

			c.gridx = 1;
			add(new JLabel("Base"),c);

			c.gridx = 2;
			add(new JLabel("Misc"),c);

			c.gridx = 3;
			add(new JLabel("Modifier"),c);

			c.fill = GridBagConstraints.BOTH;
			c.weighty = 1;
			c.ipadx = 0;
			c.gridwidth = 1;
			c.gridy = 1;
			c.gridx = 0;
			JLabel tempReference = new JLabel("Str");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 2;
			tempReference = new JLabel("Dex");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 3;
			tempReference = new JLabel("Con");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 4;
			tempReference = new JLabel("Int");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 5;
			tempReference = new JLabel("Wis");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);

			c.gridy = 6;
			tempReference = new JLabel("Cha");
			tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
			add(tempReference, c);


			strField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.STR)));
			strField.addActionListener(e -> {
				me.abilities.put(AbilityScoreEnum.STR, new Integer(strField.getText()));
				parent.repaint();
			});
			c.gridy = 1;
			c.gridx = 1;
			add(strField,c);

			dexField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.DEX)));
			dexField.addActionListener(e -> {
				me.abilities.put(AbilityScoreEnum.DEX, new Integer(dexField.getText()));
				parent.repaint();
			});
			c.gridy = 2;
			add(dexField,c);

			conField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.CON)));
			conField.addActionListener(e -> {
				me.abilities.put(AbilityScoreEnum.CON, new Integer(conField.getText()));
				parent.repaint();
			});
			c.gridy = 3;
			add(conField,c);

			intField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.INT)));
			intField.addActionListener(e -> {
				me.abilities.put(AbilityScoreEnum.INT, new Integer(intField.getText()));
				parent.repaint();
			});
			c.gridy = 4;
			add(intField,c);

			wisField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.WIS)));
			wisField.addActionListener(e -> {
				me.abilities.put(AbilityScoreEnum.WIS, new Integer(wisField.getText()));
				parent.repaint();
			});
			c.gridy = 5;
			add(wisField,c);

			chaField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.CHA)));
			chaField.addActionListener(e -> {
				me.abilities.put(AbilityScoreEnum.CHA, new Integer(chaField.getText()));
				parent.repaint();
			});
			c.gridy = 6;
			add(chaField,c);

			tempSTRField = new JTextField(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.STR)));
			tempSTRField.addActionListener(e -> {
				me.tempAbilities.put(AbilityScoreEnum.STR, new Integer(tempSTRField.getText()));
				parent.repaint();
			});
			c.gridy = 1;
			c.gridx = 2;
			add(tempSTRField,c);

			tempDEXField = new JTextField(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.DEX)));
			tempDEXField.addActionListener(e -> {
				me.tempAbilities.put(AbilityScoreEnum.DEX, new Integer(tempDEXField.getText()));
				parent.repaint();
			});
			c.gridy = 2;
			add(tempDEXField,c);

			tempCONField = new JTextField(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.CON)));
			tempCONField.addActionListener(e -> {
				me.tempAbilities.put(AbilityScoreEnum.CON, new Integer(tempCONField.getText()));
				parent.repaint();
			});
			c.gridy = 3;
			add(tempCONField,c);

			tempINTField = new JTextField(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.INT)));
			tempINTField.addActionListener(e -> {
				me.tempAbilities.put(AbilityScoreEnum.INT, new Integer(tempINTField.getText()));
				parent.repaint();
			});
			c.gridy = 4;
			add(tempINTField,c);

			tempWISField = new JTextField(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.WIS)));
			tempWISField.addActionListener(e -> {
				me.tempAbilities.put(AbilityScoreEnum.WIS, new Integer(tempWISField.getText()));
				parent.repaint();
			});
			c.gridy = 5;
			add(tempWISField,c);

			tempCHAField = new JTextField(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.CHA)));
			tempCHAField.addActionListener(e -> {
				me.tempAbilities.put(AbilityScoreEnum.CHA, new Integer(tempCHAField.getText()));
				parent.repaint();
			});
			c.gridy = 6;
			add(tempCHAField,c);

			strMod = new JLabel(Integer.toString(me.getAbilityMod(AbilityScoreEnum.STR)));
			strMod.setBorder(BorderFactory.createLineBorder(Color.black));
			c.gridx = 3;
			c.gridy = 1;
			add(strMod, c);

			dexMod = new JLabel(Integer.toString(me.getAbilityMod(AbilityScoreEnum.DEX)));
			dexMod.setBorder(BorderFactory.createLineBorder(Color.black));
			c.gridy = 2;
			add(dexMod, c);

			conMod = new JLabel(Integer.toString(me.getAbilityMod(AbilityScoreEnum.CON)));
			conMod.setBorder(BorderFactory.createLineBorder(Color.black));
			c.gridy = 3;
			add(conMod, c);

			intMod = new JLabel(Integer.toString(me.getAbilityMod(AbilityScoreEnum.INT)));
			intMod.setBorder(BorderFactory.createLineBorder(Color.black));
			c.gridy = 4;
			add(intMod, c);

			wisMod = new JLabel(Integer.toString(me.getAbilityMod(AbilityScoreEnum.WIS)));
			wisMod.setBorder(BorderFactory.createLineBorder(Color.black));
			c.gridy = 5;
			add(wisMod, c);

			chaMod = new JLabel(Integer.toString(me.getAbilityMod(AbilityScoreEnum.CHA)));
			chaMod.setBorder(BorderFactory.createLineBorder(Color.black));
			c.gridy = 6;
			add(chaMod, c);

		}

		public void paintComponent(Graphics g){
			strField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.STR)));
			dexField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.DEX)));
			conField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.CON)));
			intField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.INT)));
			wisField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.WIS)));
			chaField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.CHA)));
			tempSTRField.setText(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.STR)));
			tempDEXField.setText(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.DEX)));
			tempCONField.setText(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.CON)));
			tempINTField.setText(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.INT)));
			tempWISField.setText(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.WIS)));
			tempCHAField.setText(Integer.toString(me.tempAbilities.get(AbilityScoreEnum.CHA)));
			strMod.setText(Integer.toString(me.getAbilityMod(AbilityScoreEnum.STR)));
			dexMod.setText(Integer.toString(me.getAbilityMod(AbilityScoreEnum.DEX)));
			conMod.setText(Integer.toString(me.getAbilityMod(AbilityScoreEnum.CON)));
			intMod.setText(Integer.toString(me.getAbilityMod(AbilityScoreEnum.INT)));
			wisMod.setText(Integer.toString(me.getAbilityMod(AbilityScoreEnum.WIS)));
			chaMod.setText(Integer.toString(me.getAbilityMod(AbilityScoreEnum.CHA)));
		}
	}

	private class CurrentEffectsBox extends JPanel{
		private JPanel insidePanel;
		public CurrentEffectsBox(){
			setLayout(new BorderLayout());
			insidePanel = new JPanel(new GridBagLayout());
			JScrollPane effectsHolder = new JScrollPane(insidePanel);
			JPanel bottomPanel = new JPanel(new BorderLayout());

			JPanel topPanel = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.weightx = 1;
			c.fill = GridBagConstraints.NONE;
			topPanel.add(new JLabel("Current Status Effects"), c);
			c.gridy = 1;
			c.fill = GridBagConstraints.BOTH;
			topPanel.add(new JSeparator(SwingConstants.HORIZONTAL), c);
			add(topPanel, BorderLayout.NORTH);

			JButton progressRound = new JButton("Progress a round");
			JButton addEffect = new JButton("Add an effect");
			addEffect.addActionListener(e -> addEffect());

			bottomPanel.add(progressRound, BorderLayout.WEST);
			progressRound.addActionListener(e -> incrementRound());

			bottomPanel.add(addEffect, BorderLayout.EAST);

			setupStuff();

			add(effectsHolder,BorderLayout.CENTER);
			add(bottomPanel, BorderLayout.SOUTH);
		}
		public void setupStuff(){
			GridBagConstraints c = new GridBagConstraints();
			for(String effect : me.effects.keySet()){
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = 0;
				c.gridwidth = 5;
				c.weightx = 1;
				JLabel effectLabel = new JLabel(effect);
				effectLabel.setBorder(BorderFactory.createLineBorder(Color.black));
				insidePanel.add(effectLabel, c);

				c.weightx = 0;
				JTextField effectTime = new JTextField(Integer.toString(me.effects.get(effect)));
				effectTime.addActionListener(e -> {
					me.effects.put(effect,Integer.parseInt(effectTime.getText()));
				});
				c.gridx = 5;
				c.gridwidth = 1;
				insidePanel.add(effectTime, c);
			}
		}

		public void incrementRound(){

			for(String effect : me.effects.keySet())
				if(me.effects.get(effect) > 0) me.effects.put(effect, me.effects.get(effect) - 1);


			ArrayList<String> toRemove = new ArrayList<String>();
			for(String effect : me.effects.keySet())
				if(me.effects.get(effect) == 0) toRemove.add(effect);


			for(String effect : toRemove)
				me.effects.remove(effect);

			insidePanel.removeAll();
			setupStuff();
			revalidate();
			repaint();
		}

		public void addEffect(){
			JFrame addEffectFrame = new JFrame("Add an Effect");
			JPanel panel = new JPanel();
			addEffectFrame.add(panel);

			JLabel first = new JLabel("Add this effect: \"");
			panel.add(first);

			JTextField effectDesc = new JTextField();
			effectDesc.setPreferredSize(new Dimension(160,25));
			panel.add(effectDesc);

			panel.add(new JLabel("\" for "));

			JTextField effectTime = new JTextField();
			effectTime.setPreferredSize(new Dimension(35,25));
			panel.add(effectTime);

			panel.add(new JLabel(" rounds?"));

			JButton choose = new JButton("Confirm");
			choose.addActionListener(e -> {
				me.effects.put(effectDesc.getText(), Integer.parseInt(effectTime.getText()));
				addEffectFrame.dispose();
				insidePanel.removeAll();
				setupStuff();
				revalidate();
				repaint();
			});
			panel.add(choose);

			addEffectFrame.setSize(600,80);
			addEffectFrame.setVisible(true);
		}
	}

	private class InventoryTab extends JPanel{
		public InventoryTab(CharacterDisplay parent){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.gridheight = 10;
			c.weighty = 1;
			c.weightx = 1;
			add(new InventoryBox(parent),c);

			c.gridheight = 7;
			c.gridx = 1;
			add(new EquippedBox(parent), c);

			c.weighty = 0;
			c.gridy = 7;
			c.gridheight = 3;
			add(new CoinBox(),c);
		}
	}

	public class AbilityTab extends JPanel{
		public AbilityTab(){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			ClassAbilitiesBox classAbilitiesBox = new ClassAbilitiesBox();
			c.weightx = 1;
			c.weighty = 1;
			c.fill = GridBagConstraints.BOTH;
			add(classAbilitiesBox, c);

			FeatBox featBox = new FeatBox();
			c.gridy = 1;
			add(featBox, c);

			NoteBox noteBox = new NoteBox();
			c.gridx = 1;
			c.gridy = 0;
			c.gridheight = 2;
			add(noteBox, c);
		}
	}

	private class ClassAbilitiesBox extends JPanel{
		private JList<String> listContainer;
		private JTextField addNoteField = new JTextField();
		private JButton removalButton = new JButton("Remove Selected Abilities");
		private JScrollPane listScroll;

		public ClassAbilitiesBox(){
			setLayout(new GridBagLayout());
			addNoteField.setText("Add an ability here");
			addNoteField.addActionListener(e -> {
				me.miscAbilities.add(addNoteField.getText());
				addNoteField.setText("");
				repaint();
			});
			addNoteField.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					addNoteField.selectAll();
				}
			});

			String[] model = new String[me.miscAbilities.size()];
			model = me.miscAbilities.toArray(model);
			listContainer = new JList<>(model);
			removalButton.addActionListener(e -> remove(listContainer.getSelectedIndices()));
			listScroll = new JScrollPane(listContainer);
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.gridwidth = 3;
			c.weighty = 0;
			add(addNoteField, c);
			c.weighty = 1;
			c.weightx = 1;
			c.gridy = 1;
			c.gridheight = 9;
			add(listScroll, c);
			c.weightx = 0;
			c.weighty = 0;
			c.gridy = 10;
			add(removalButton, c);
		}

		public void remove(int[] indices){
			//Go backward to avoid shifting indices of the next ones to remove;
			for(int i = indices.length - 1; i >= 0; i--){
				me.miscAbilities.remove(indices[i]);
			}
			String[] model = new String[me.miscAbilities.size()];
			model = me.miscAbilities.toArray(model);
			listContainer.setListData(model);
		}

		public void paintComponent(Graphics g){
			//If you experience weird GUI problems remove this.
			super.paintComponent(g);
			String[] model = new String[me.miscAbilities.size()];
			model = me.miscAbilities.toArray(model);
			listContainer.setListData(model);
		}
	}
	
	private class SkillBox extends JPanel{
		private ArrayList<JTextField> fields = new ArrayList<>();
		private int numberOfCurrentSkills = 0;

		public SkillBox(){
			updateTextFields();
		}

		public void updateTextFields(){
			if(me.skillsList.size() == numberOfCurrentSkills)
				for(JTextField field : fields) field.setText("Filler for override");
			else{
				numberOfCurrentSkills = me.skillsList.size();
				removeAll();
				fields.clear();
				setupFields();
				revalidate();
				for(JTextField field : fields) field.setText("Filler for override");
			}
		}

		public void setupFields(){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.weightx = 1;
			c.gridwidth = 2;
			c.fill = GridBagConstraints.BOTH;
			JLabel name = new JLabel("Name");
			Border border = BorderFactory.createLineBorder(Color.black);
			name.setBorder(border);
			add(name,c);
			c.gridx = 2;
			c.gridwidth = 1;
			JLabel total = new JLabel("Total");
			total.setBorder(border);
			add(total, c);
			c.gridx = 3;
			JLabel misc = new JLabel("Misc");
			misc.setBorder(border);
			add(misc, c);
			c.gridx = 4;
			JLabel ranks = new JLabel("Ranks");
			ranks.setBorder(border);
			add(ranks, c);
			c.gridx = 5;
			JLabel classSkill = new JLabel("Class");
			classSkill.setBorder(border);
			add(classSkill, c);
			c.gridy++;
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

				add(name,c);

				c.gridx = 2;
				c.gridwidth = 1;
				JTextField totalField = new JTextField(){
					public void setText(String s){
						super.setText(Integer.toString(skill.calculateTotalSkillMod()));
					}
				};
				totalField.setEditable(false);
				add(totalField, c);
				fields.add(totalField);

				c.gridx = 3;
				JTextField miscField = new JTextField(){
					public void setText(String s){
						super.setText(Integer.toString(skill.getMiscMod()));
					}
				};
				miscField.addActionListener(e -> {
					skill.setMiscMod(Integer.parseInt(miscField.getText()));
					updateTextFields();
				});
				add(miscField, c);
				fields.add(miscField);

				c.gridx = 4;
				JTextField ranksField = new JTextField(){
					public void setText(String s){
						super.setText(Integer.toString(skill.getnRanks()));
					}
				};
				ranksField.addActionListener(e -> {
					skill.setnRanks(Integer.parseInt(ranksField.getText()));
					updateTextFields();
				});
				add(ranksField, c);
				fields.add(ranksField);

				c.gridx = 5;
				JTextField classField = new JTextField(){
					public void setText(String s){
						super.setText(skill.isClassSkill() ? "Y" : "N");
					}
				};
				classField.addActionListener(e -> {
					String value = classField.getText();
					if(value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("Yes")){
						skill.setClassSkill(true);
					} else if(value.equalsIgnoreCase("N") || value.equalsIgnoreCase("No")){
						skill.setClassSkill(false);
					}
					updateTextFields();
				});
				add(classField, c);
				fields.add(classField);
			}
			JButton addSkill = new JButton("Add a skill subtype");
			addSkill.addActionListener(e -> {
				addSkill();
				updateTextFields();
			});
			c.gridy++;
			c.gridx = 0;
			c.gridwidth = 6;
			add(addSkill, c);
		}
		public void addSkill(){
			(new Thread(){
				public void run(){
					JFrame addSkillFrame = new JFrame("Choose a skill to add");
					addSkillFrame.setSize(300,200);

					ArrayList<SkillEnum> skillsWithSubtypes = new ArrayList<>();
					for(SkillEnum skill : SkillEnum.values())
						if(skill.hasSubTypes())
							skillsWithSubtypes.add(skill);

					String[] model = new String[skillsWithSubtypes.size()];
					for(int i = 0; i < model.length; i++) model[i] = skillsWithSubtypes.get(i).toString();

					JList<String> list = new JList<>(model);

					list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

					JPanel panel = new JPanel(new BorderLayout());

					panel.add(list, BorderLayout.CENTER);

					JTextField field = new JTextField();
					field.setPreferredSize(new Dimension(80,25));

					JPanel upperPanel = new JPanel(new FlowLayout());

					JLabel skillSelected = new JLabel();

					list.addListSelectionListener(e -> {
						skillSelected.setText(skillsWithSubtypes.get(list.getSelectedIndex()).toString() + " (");
					});

					upperPanel.add(skillSelected);

					upperPanel.add(field);

					upperPanel.add(new JLabel(")"));

					panel.add(upperPanel, BorderLayout.NORTH);

					JButton chooser = new JButton("Make this sub-skill");

					panel.add(chooser,BorderLayout.SOUTH);

					chooser.addActionListener(e -> {
						if(field.getText().equals("")) Pathfinder.showError("Invalid option","You must write a subtype");
						else{
							SkillUtils.getSkill(skillsWithSubtypes.get(list.getSelectedIndex()),me,field.getText());
							addSkillFrame.dispose();
						}
					});

					addSkillFrame.add(panel);
					addSkillFrame.setVisible(true);
				}
			}).start();
		}
	}
	
	private class NoteBox extends JPanel{

		private JList<String> listContainer;
		private JTextField addNoteField = new JTextField();
		private JButton removalButton = new JButton("Remove Selected Note(s)");
		private JScrollPane listScroll;

		public NoteBox(){
			setLayout(new GridBagLayout());
			addNoteField.setText("Add a note here");
			addNoteField.addActionListener(e -> {
				me.notes.add(addNoteField.getText()); 
				addNoteField.setText("");
				repaint();
			});

			addNoteField.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					addNoteField.selectAll();
				}
			});
			
			String[] model = new String[me.notes.size()];
			model = me.notes.toArray(model);
			listContainer = new JList<>(model);
			removalButton.addActionListener(e -> remove(listContainer.getSelectedIndices()));
			listScroll = new JScrollPane(listContainer);
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.gridwidth = 3;
			c.weighty = 0;
			add(addNoteField, c);
			c.weighty = 1;
			c.weightx = 1;
			c.gridy = 1;
			c.gridheight = 9;
			add(listScroll, c);
			c.weightx = 0;
			c.weighty = 0;
			c.gridy = 10;
			add(removalButton, c);
		}
		
		public void remove(int[] indices){
			//Go backward to avoid shifting indices of the next ones to remove;
			for(int i = indices.length - 1; i >= 0; i--){
				me.notes.remove(indices[i]);
			}
			String[] model = new String[me.notes.size()];
			model = me.notes.toArray(model);
			listContainer.setListData(model);
		}
		
		public void paintComponent(Graphics g){
			//If you experience weird GUI problems remove this.
			super.paintComponent(g);
			String[] model = new String[me.notes.size()];
			model = me.notes.toArray(model);
			listContainer.setListData(model);
		}
	}
	
	private class FeatBox extends JPanel{
		
		private JList<String> listContainer;
		private JButton removalButton = new JButton("Remove Selected Feat(s)");
		private JButton forceNewFeats = new JButton("Force a new Feat");
		private JButton getFeatDetails = new JButton("Get Feat Details");
		private JScrollPane listScroll;
		
		public FeatBox(){
			setLayout(new GridBagLayout());
			String[] model = new String[me.currentFeats.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.currentFeats.get(i).toString();
			listContainer = new JList<>(model);

			listContainer.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					JList list = (JList)evt.getSource();
					if (evt.getClickCount() > 1) {
						int index = list.locationToIndex(evt.getPoint());
						Pathfinder.showFeatDetails(me.currentFeats.get(index));
					}
				}
			});

			removalButton.addActionListener(e -> remove(listContainer.getSelectedIndices()));
			listScroll = new JScrollPane(listContainer);
			GridBagConstraints c = new GridBagConstraints();
			getFeatDetails.addActionListener(e -> showDetails(listContainer.getSelectedIndices()));
			c.fill = GridBagConstraints.BOTH;
			c.gridheight = 1;
			c.weighty = 0;
			c.gridwidth = 1;
			c.gridy = 0;
			c.weightx = 1;
			add(forceNewFeats, c);
			c.gridx = 1;
			add(getFeatDetails, c);
			c.gridx = 0;
			c.weighty = 1;
			c.weightx = 1;
			c.gridwidth = 2;
			c.gridy = 1;
			c.gridheight = 9;
			add(listScroll, c);
			c.gridy = 10;
			c.gridx = 0;
			c.weighty = 0;
			c.gridwidth = 2;
			add(removalButton, c);
		}
		
		public void remove(int[] indices){
			//Go backward to avoid shifting indices of the next ones to remove;
			for(int i = indices.length - 1; i >= 0; i--){
				me.currentFeats.remove(indices[i]);
			}
			String[] model = new String[me.currentFeats.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.currentFeats.get(i).toString();
			listContainer.setListData(model);
		}
		
		public void showDetails(int[] indices){
			for(int i : indices){
				Pathfinder.popupDialog(me.currentFeats.get(i).name, me.currentFeats.get(i).fullText);
			}
		}
		
		public void paintComponent(Graphics g){
			//If you experience weird GUI problems remove this.
			super.paintComponent(g);
			String[] model = new String[me.currentFeats.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.currentFeats.get(i).toString();
			listContainer.setListData(model);
		}
	}
	
	private class InventoryBox extends JPanel{

		private JList<String> listContainer;
		private JButton removalButton = new JButton("Remove Selected Item(s)");
		private JButton addItemButton = new JButton("Add an Item");
		private JButton sellItemButton = new JButton("Sell Selected Item(s)");
		private JButton buyItemButton = new JButton("Buy an Item");
		private JButton equipItemButton = new JButton("Equip selected item(s)");
		private JScrollPane listScroll;
		private CharacterDisplay parent;

		public InventoryBox(CharacterDisplay parent){
			this.parent = parent;
			setLayout(new GridBagLayout());
			String[] model = new String[me.inventory.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.inventory.get(i).toString();
			listContainer = new JList<>(model);
			
			removalButton.addActionListener(e -> remove(listContainer.getSelectedIndices()));
			sellItemButton.addActionListener(e -> sell(listContainer.getSelectedIndices()));
			equipItemButton.addActionListener(e -> {
				me.equipItems(listContainer.getSelectedIndices());
				parent.repaint();
			});
			
			listScroll = new JScrollPane(listContainer);
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.weighty = 0;
			add(buyItemButton, c);
			c.gridx = 1;
			add(sellItemButton, c);
			c.gridx = 0;
			c.weighty = 1;
			c.gridy = 1;
			c.gridheight = 9;
			c.gridwidth = 2;
			add(listScroll, c);
			c.weighty = 0;
			c.gridheight = 1;
			c.gridy = 10;
			c.gridwidth = 1;
			add(addItemButton, c);
			c.gridx = 1;
			add(removalButton, c);
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 11;
			add(equipItemButton, c);
		}
		
		public void sell(int[] indices){
			for(int i = indices.length -1; i >= 0; i--){
				me.platinum += me.inventory.get(indices[i]).platinumValue;
				me.gold += me.inventory.get(indices[i]).goldValue;
				me.silver += me.inventory.get(indices[i]).silverValue;
				me.copper += me.inventory.get(indices[i]).copperValue;
			}
			remove(indices);
		}
		
		public void remove(int[] indices){
			//Go backward to avoid shifting indices of the next ones to remove;
			for(int i = indices.length - 1; i >= 0; i--){
				me.inventory.remove(indices[i]);
			}
			String[] model = new String[me.inventory.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.inventory.get(i).toString();
			listContainer.setListData(model);
			parent.repaint();
		}
		
		public void paintComponent(Graphics g){
			//If you experience weird GUI problems remove this.
			super.paintComponent(g);
			String[] model = new String[me.inventory.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.inventory.get(i).toString();
			listContainer.setListData(model);
		}
	}
	
	private class EquippedBox extends JPanel{

		private JList<String> listContainer;
		private JButton removalButton = new JButton("Unequip selected item(s)");
		private JScrollPane listScroll;
		private CharacterDisplay parent;

		public EquippedBox(CharacterDisplay parent){
			this.parent = parent;
			setLayout(new GridBagLayout());
			String[] model = new String[me.equipped.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.equipped.get(i).toString();
			listContainer = new JList<>(model);
			listScroll = new JScrollPane(listContainer);
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.weighty = 1;
			c.weightx = 1;
			c.gridheight = 6;
			add(listScroll, c);
			c.weightx = 0;
			c.weighty = 0;
			c.gridy = 6;
			c.gridheight = 1;
			add(removalButton, c);
			
			removalButton.addActionListener(e -> {
				me.unequipItems(listContainer.getSelectedIndices());
				parent.repaint();
			});
		}
		
		public void paintComponent(Graphics g){
			//If you experience weird GUI problems remove this.
			super.paintComponent(g);
			String[] model = new String[me.equipped.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.equipped.get(i).toString();
			listContainer.setListData(model);
		}
	}
	
	private class CoinBox extends JPanel{
		private JLabel top = new JLabel("Your coins:");
		private JLabel plat = new JLabel("Platinum:");
		private JLabel gold = new JLabel("Gold:");
		private JLabel silv = new JLabel("Silver");
		private JLabel copp = new JLabel("Copper:");
		private JTextField platField = new JTextField(Integer.toString(me.platinum));
		private JTextField goldField = new JTextField(Integer.toString(me.gold));
		private JTextField silvField = new JTextField(Integer.toString(me.silver));
		private JTextField coppField = new JTextField(Integer.toString(me.copper));
		
		public CoinBox(){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.NONE;
			c.gridwidth = 4;
			c.weightx = 1;
			add(top, c);
			
			c.gridwidth = 1;
			c.weightx = 0;
			c.gridy = 1;
			add(plat, c);
			c.gridy = 2;
			add(gold,c);
			c.gridx = 2;
			add(copp, c);
			c.gridy = 1;
			add(silv, c);
			
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.gridx = 1;
			add(platField, c);
			c.gridy = 2;
			add(goldField, c);
			c.gridx = 3;
			add(coppField, c);
			c.gridy = 1;
			add(silvField, c);
			
			platField.addActionListener(e -> me.platinum = Integer.parseInt(platField.getText()));
			goldField.addActionListener(e -> me.gold = Integer.parseInt(goldField.getText()));
			silvField.addActionListener(e -> me.silver = Integer.parseInt(silvField.getText()));
			coppField.addActionListener(e -> me.copper = Integer.parseInt(coppField.getText()));
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			platField.setText(Integer.toString(me.platinum));
			goldField.setText(Integer.toString(me.gold));
			silvField.setText(Integer.toString(me.silver));
			coppField.setText(Integer.toString(me.copper));
		}
	}

	private class SpellCasterTab extends JPanel{
		CharacterClass spellcaster;
		KnownSpellBox knownBox;
		PreppedSpellBox preppedBox;

		public SpellCasterTab(CharacterClass spellcaster){
			this.spellcaster = spellcaster;

			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			c.fill = GridBagConstraints.BOTH;

			knownBox = new KnownSpellBox(spellcaster);
			c.weightx = 1;
			c.weighty = 1;
			c.gridheight = 10;
			add(knownBox, c);

			JButton prepSpells = new JButton("Prepare selected spells");
			prepSpells.addActionListener(e -> prepareSpells(knownBox.getSelected()));
			c.gridheight = 1;
			c.weighty = 0;
			c.gridx = 1;
			add(prepSpells, c);

			preppedBox = new PreppedSpellBox(spellcaster);
			c.weighty = 1;
			c.gridheight = 6;
			c.gridy = 1;
			add(preppedBox, c);

			c.gridy = 7;
			c.gridheight = 3;
			add(new SpellsCastBox(spellcaster), c);
		}

		public void prepareSpells(int[] indices){
			for(int i : indices){
				if(spellcaster.preppedSpells.get(spellcaster.knownSpells.get(i)) != null){
					spellcaster.preppedSpells.put(spellcaster.knownSpells.get(i), spellcaster.preppedSpells.get(spellcaster.knownSpells.get(i)) + 1);
				} else {
					spellcaster.preppedSpells.put(spellcaster.knownSpells.get(i), 1);
				}
			}
			preppedBox.setupPreppedSpells();
			revalidate();
			repaint();
		}
	}
	
	private class KnownSpellBox extends JPanel{
		
		private JList<String> listContainer;
		private JButton removalButton = new JButton("Remove Selected Spell(s)");
		private JButton forceNewSpells = new JButton("Force a new Spell");
		private JButton getSpellDetails = new JButton("Get Spell Details");
		private JScrollPane listScroll;
		private CharacterClass spellcaster;
		
		public KnownSpellBox(CharacterClass spellcaster){
			this.spellcaster = spellcaster;
			setLayout(new GridBagLayout());
			String[] model = new String[spellcaster.knownSpells.size()];
			for(int i = 0; i < model.length; i++) model[i] = spellcaster.knownSpells.get(i).toString();
			listContainer = new JList<>(model);
			
			listContainer.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					JList list = (JList)evt.getSource();
					if (evt.getClickCount() > 1) {
						int index = list.locationToIndex(evt.getPoint());
						Pathfinder.showSpellDetails(spellcaster.knownSpells.get(index));
					}
				}
			});
			
			removalButton.addActionListener(e -> remove(listContainer.getSelectedIndices()));
			listScroll = new JScrollPane(listContainer);
			GridBagConstraints c = new GridBagConstraints();
			getSpellDetails.addActionListener(e -> showDetails(listContainer.getSelectedIndices()));
			c.fill = GridBagConstraints.BOTH;
			c.gridheight = 1;
			c.weighty = 0;
			c.gridwidth = 1;
			c.gridy = 0;
			c.weightx = 1;
			add(forceNewSpells, c);
			forceNewSpells.addActionListener(e -> new Thread(() -> {
                spellcaster.knownSpells.add(Pathfinder.chooseSpellFromList(Spells.getSpells(), "Choose the spell to add"));
                repaint();
                }).start());
			c.gridx = 1;
			add(getSpellDetails, c);
			c.gridx = 0;
			c.weighty = 1;
			c.weightx = 1;
			c.gridwidth = 2;
			c.gridy = 1;
			c.gridheight = 9;
			add(listScroll, c);
			c.gridy = 10;
			c.gridx = 0;
			c.weighty = 0;
			c.gridwidth = 2;
			add(removalButton, c);
		}
		
		public void remove(int[] indices){
			//Go backward to avoid shifting indices of the next ones to remove;
			for(int i = indices.length - 1; i >= 0; i--){
				spellcaster.knownSpells.remove(indices[i]);
			}
			String[] model = new String[spellcaster.knownSpells.size()];
			for(int i = 0; i < model.length; i++) model[i] = spellcaster.knownSpells.get(i).toString();
			listContainer.setListData(model);
		}
		
		public void showDetails(int[] indices){
			for(int i : indices){
				Pathfinder.showSpellDetails(spellcaster.knownSpells.get(i));
			}
		}

		public int[] getSelected(){
			return listContainer.getSelectedIndices();
		}
		
		public void paintComponent(Graphics g){
			//If you experience weird GUI problems remove this.
			super.paintComponent(g);
			String[] model = new String[spellcaster.knownSpells.size()];
			for(int i = 0; i < model.length; i++) model[i] = spellcaster.knownSpells.get(i).toString();
			listContainer.setListData(model);
		}
	}

	private class PreppedSpellBox extends JPanel{
		private JButton resetPreppedSpells = new JButton("Reset Prepped Spells");
		private CharacterClass spellcaster;
		private JScrollPane listScroll;
		private JPanel innerPanel;
		private JPanel topPanel;

		public PreppedSpellBox(CharacterClass spellcaster){
			this.spellcaster = spellcaster;
			setLayout(new BorderLayout());

			topPanel = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.weighty = 0;
			topPanel.add(new JLabel("Prepped Spells"), c);
			c.weightx = 0;
			c.gridx = 1;
			topPanel.add(new JLabel("# Prepped"), c);

			add(resetPreppedSpells, BorderLayout.SOUTH);

			resetPreppedSpells.addActionListener(e -> {
				spellcaster.preppedSpells.clear();
				setupPreppedSpells();
			});

			innerPanel = new JPanel(new GridBagLayout());
			listScroll = new JScrollPane(innerPanel);
			add(listScroll, BorderLayout.CENTER);
			add(topPanel, BorderLayout.NORTH);

			setupPreppedSpells();
		}

		public void setupPreppedSpells(){
			innerPanel.removeAll();

			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;

			for(Spell spell : spellcaster.preppedSpells.keySet()){
				c.weightx = 1;
				c.gridx = 0;
				JLabel spellName = new JLabel(spell.name);
				innerPanel.add(spellName,c);

				JButton cast = new JButton("Cast Spell");
				cast.addActionListener(e -> {
					spellcaster.preppedSpells.put(spell, spellcaster.preppedSpells.get(spell) -1);
					if(spellcaster.preppedSpells.get(spell) == 0) spellcaster.preppedSpells.remove(spell);
					setupPreppedSpells();
				});
				c.weightx = 0;
				c.gridx = 1;
				innerPanel.add(cast, c);

				JTextField prepped = new JTextField(Integer.toString(spellcaster.preppedSpells.get(spell)));
				prepped.addActionListener(e -> spellcaster.preppedSpells.put(spell, Integer.parseInt(prepped.getText())));
				c.gridx = 2;
				innerPanel.add(prepped, c);

				c.gridy++;
			}

			repaint();
		}

	}

	private class SpellsCastBox extends JScrollPane{
		private CharacterClass spellcaster;

		private JTextField levelOne = new JTextField();
		private JTextField levelTwo = new JTextField();
		private JTextField levelThree = new JTextField();
		private JTextField levelFour = new JTextField();
		private JTextField levelFive = new JTextField();
		private JTextField levelSix = new JTextField();
		private JTextField levelSeven = new JTextField();
		private JTextField levelEight = new JTextField();
		private JTextField levelNine = new JTextField();

		public SpellsCastBox(CharacterClass spellcaster){
			this.spellcaster = spellcaster;

			JPanel inner = new JPanel(new GridBagLayout());
			add(inner);

			GridBagConstraints c = new GridBagConstraints();

			c.fill = GridBagConstraints.BOTH;

			c.weighty = 0;
			c.weightx = 1;
			add(new JLabel("Level One Spells: "),c);
			c.gridy++;
			add(new JLabel("Level Two Spells: "));
			c.gridy++;
			add(new JLabel("Level Three Spells: "));
			c.gridy++;
			add(new JLabel("Level Four Spells: "));
			c.gridy++;
			add(new JLabel("Level Five Spells: "));
			c.gridy++;
			add(new JLabel("Level Six Spells: "));
			c.gridy++;
			add(new JLabel("Level Seven Spells: "));
			c.gridy++;
			add(new JLabel("Level Eight Spells: "));
			c.gridy++;
			add(new JLabel("Level Nine Spells: "));

			c.gridy = 0;
			c.gridx = 1;
			c.weightx = 0.5;
			add(levelOne, c);
			c.gridy++;
			add(levelTwo, c);
			c.gridy++;
			add(levelThree, c);
			c.gridy++;
			add(levelFour, c);
			c.gridy++;
			add(levelFive, c);
			c.gridy++;
			add(levelSix, c);
			c.gridy++;
			add(levelSeven, c);
			c.gridy++;
			add(levelEight, c);
			c.gridy++;
			add(levelNine, c);
		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			levelOne.setText(Integer.toString(spellcaster.spellsCastToday[0]));
			levelTwo.setText(Integer.toString(spellcaster.spellsCastToday[0]));
			levelThree.setText(Integer.toString(spellcaster.spellsCastToday[0]));
			levelFour.setText(Integer.toString(spellcaster.spellsCastToday[0]));
			levelFive.setText(Integer.toString(spellcaster.spellsCastToday[0]));
			levelSix.setText(Integer.toString(spellcaster.spellsCastToday[0]));
			levelSeven.setText(Integer.toString(spellcaster.spellsCastToday[0]));
			levelEight.setText(Integer.toString(spellcaster.spellsCastToday[0]));
			levelNine.setText(Integer.toString(spellcaster.spellsCastToday[0]));
		}
	}

	private class ClassesBox extends JPanel{
		private int currentClasses = 0;
		private JPanel panel;
		public ClassesBox(){
			panel = new JPanel(new GridBagLayout());
			JScrollPane scroll = new JScrollPane(panel);
			add(scroll);

			setupClasses();
		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(currentClasses != me.classes.size()){
				panel.removeAll();
				setupClasses();
			}
		}

		public void setupClasses(){
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.weighty = 1;
			for(CharacterClass charClass : me.classes){
				JLabel label = new JLabel("Level " + charClass.level + " " + charClass.toString());
				panel.add(label,c);
				c.gridy++;
				currentClasses++;
			}
		}
	}
}