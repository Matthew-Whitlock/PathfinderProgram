package src;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import src.spells.*;
import src.stats.*;
import java.util.ArrayList;

public class CharacterDisplay extends JPanel{
	private Character me;
	private GridBagLayout topLayout = new GridBagLayout();
	private JLabel race;
	private JLabel name;
	private JLabel picture;
	private JLabel charClass;
	private JTextField backgroundJob;
	private JTextField alignment;
	private JTextArea physicalDesc;
	private JScrollPane physDescScroll;
	private JScrollPane charBackgroundScroll;
	private JTextArea charBackground;
	private JButton savePhysDesc;
	private JLabel totalHPLabel;
	private JButton saveBackground;
	private JTextField totalHPField;
	private JTextField currentHPField;
	private JLabel level;
	private JButton levelUp;
	private JButton attackButton;
	private SkillBox skillBox;
	private JScrollPane skillBoxScroll;
	private JTextField strField;
	private JTextField conField;
	private JTextField wisField;
	private JTextField intField;
	private JTextField chaField;
	private JTextField dexField;
	private JTextField babField;
	private JTextField acField;
	private JTextField touchACField;
	private JTextField fortSaveField;
	private JTextField willSaveField;
	private JTextField refSaveField;
	private JTextField meleeModifierField;
	private JTextField rangedModifierField;
	private NoteBox noteBox;
	private FeatBox featBox;
	private InventoryBox inventoryBox;
	private EquippedBox equippedBox;
	private CoinBox coinBox;
	private KnownSpellBox knownSpellBox;

	public CharacterDisplay(Character me){
		this.me = me;
		setLayout(topLayout);
		GridBagConstraints c = new GridBagConstraints();
		name = new JLabel(me.name);
		c.gridwidth = 6;
		add(name, c);
		c.fill = GridBagConstraints.BOTH;
		picture = new JLabel(new ImageIcon(me.getImageLocation()));
		c.weighty = 1;
		c.weightx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 10;
		add(picture, c);
		
		race = new JLabel(me.charRace.toString());
		c.fill = GridBagConstraints.NONE;
		c.weighty = 0;
		c.gridx = 2;
		c.gridheight = 1;
		add(race, c);
		
		charClass = new JLabel(me.charClass.toString());
		c.gridx = 4;
		add(charClass, c);
		
		backgroundJob = new JTextField();
		backgroundJob.setText(me.job != null ? me.job : "Background job");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		add(backgroundJob, c);
		
		alignment = new JTextField();
		alignment.setText(me.alignment != null ? me.alignment : "Alignment");
		c.gridx = 4;
		add(alignment, c);
		
		physicalDesc = new JTextArea();
		physicalDesc.setLineWrap(true);
		physicalDesc.setText(me.physDesc != null ? me.physDesc : "Physical Description");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 4;
		c.gridheight = 2;
		physDescScroll = new JScrollPane(physicalDesc);
		add(physDescScroll, c);
		
		savePhysDesc = new JButton("Update");
		c.gridheight = 1;
		c.weighty = 0;
		c.gridy = 5;
		add(savePhysDesc,c);
		
		charBackground = new JTextArea();
		charBackground.setLineWrap(true);
		charBackground.setText(me.background != null ? me.background : "Character background");
		charBackgroundScroll = new JScrollPane(charBackground);
		c.gridy = 6;
		c.weighty = 1;
		c.gridheight = 4;
		add(charBackgroundScroll, c);
		
		saveBackground = new JButton("Update");
		c.gridheight = 1;
		c.gridy = 10;
		c.weighty = 0;
		add(saveBackground,c);
		
		
		c.gridy = 11;
		c.gridx = 0;
		c.gridwidth = 6;
		c.gridheight = 1;
		add(new JSeparator(), c);
		
		totalHPLabel = new JLabel("Total HP:");
		c.gridy = 12;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.001;
		c.weighty = 0;
		add(totalHPLabel,c);
		
		totalHPField = new JTextField();
		totalHPField.setText(Integer.toString(me.totalHP));
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 13;
		add(totalHPField, c);
		
		c.gridy = 12;
		c.gridx = 1;
		add(new JLabel("Current HP"),c);
		
		currentHPField = new JTextField(Integer.toString(me.currentHP));
		c.gridy = 13;
		add(currentHPField, c);
		
		level = new JLabel("Level: " + me.level);
		c.weightx = 0;
		c.gridy = 12;
		c.gridx = 2;
		add(level,c);
		
		levelUp = new JButton("Level up!");
		levelUp.addActionListener(e -> {
			new Thread(() -> me.levelUp()).start();
			repaint();
		});
		c.gridy = 13;
		add(levelUp,c);
		
		attackButton = new JButton("Roll to attack!");
		c.weightx = 0;
		c.weighty = 0;
		c.gridy = 12;
		c.gridx = 3;
		c.gridheight = 2;
		add(attackButton, c);
		
		skillBox = new SkillBox();
		skillBoxScroll = new JScrollPane(skillBox);
		c.gridx = 4;
		c.gridheight = 10;
		c.weightx = 1;
		c.weighty = 1;
		add(skillBoxScroll, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.gridx = 0;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.gridy = 14;
		c.weighty = 0;
		add(new JLabel("Character Stats"), c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 1;
		c.weightx = 0.25;
		c.gridy = 15;
		c.weighty = 0.0000001;
		JLabel tempReference = new JLabel("Str");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 16;
		tempReference = new JLabel("Dex");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 17;
		tempReference = new JLabel("Con");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 18;
		tempReference = new JLabel("Int");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 19;
		tempReference = new JLabel("Wis");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 20;
		tempReference = new JLabel("Cha");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 21;
		tempReference = new JLabel("BAB");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		strField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.STR)));
		strField.addActionListener(e -> {
			me.abilities.put(AbilityScoreEnum.STR, new Integer(strField.getText()));
			repaint();
		});
		c.weightx = 0.25;
		c.gridy = 15;
		c.gridx = 1;
		add(strField,c);
		
		dexField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.DEX)));
		dexField.addActionListener(e -> {
			me.abilities.put(AbilityScoreEnum.DEX, new Integer(dexField.getText()));
			repaint();
		});
		c.gridy = 16;
		add(dexField,c);
		
		conField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.CON)));
		conField.addActionListener(e -> {
			me.abilities.put(AbilityScoreEnum.CON, new Integer(conField.getText()));
			repaint();
		});
		c.gridy = 17;
		add(conField,c);
		
		intField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.INT)));
		intField.addActionListener(e -> {
			me.abilities.put(AbilityScoreEnum.INT, new Integer(intField.getText()));
			repaint();
		});
		c.gridy = 18;
		add(intField,c);
		
		wisField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.WIS)));
		wisField.addActionListener(e -> {
			me.abilities.put(AbilityScoreEnum.WIS, new Integer(wisField.getText()));
			repaint();
		});
		c.gridy = 19;
		add(wisField,c);
		
		chaField = new JTextField(Integer.toString(me.abilities.get(AbilityScoreEnum.CHA)));
		chaField.addActionListener(e -> {
			me.abilities.put(AbilityScoreEnum.CHA, new Integer(chaField.getText()));
			repaint();
		});
		c.gridy = 20;
		add(chaField,c);
		
		babField = new JTextField(Integer.toString(me.getBAB()));
		babField.addActionListener(e -> {
			me.setBAB(Integer.parseInt(babField.getText()));
			repaint();
		});
		c.gridy = 21;
		add(babField,c);
		
		c.gridx = 2;
		c.gridy = 14;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.NONE;
		add(new JLabel("Combat Stats"), c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.gridy = 15;
		tempReference = new JLabel("AC");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 16;
		tempReference = new JLabel("Touch AC");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 17;
		tempReference = new JLabel("Fortitude Save");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 18;
		tempReference = new JLabel("Will Save");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 19;
		tempReference = new JLabel("Reflex Save");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 20;
		tempReference = new JLabel("Melee Modifier");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridy = 21;
		tempReference = new JLabel("Ranged Modifier");
		tempReference.setBorder(BorderFactory.createLineBorder(Color.black));
		add(tempReference, c);
		
		c.gridx = 3;
		c.weightx = 0.25;
		c.gridy = 15;
		acField = new JTextField(Integer.toString(me.getAC()));
		add(acField,c);
		
		c.gridy = 16;
		touchACField = new JTextField(Integer.toString(me.getTouchAC()));
		add(touchACField,c);
		
		c.gridy = 17;
		fortSaveField = new JTextField(Integer.toString(me.getFortSave()));
		add(fortSaveField,c);
		
		c.gridy = 18;
		willSaveField = new JTextField(Integer.toString(me.getWillSave()));
		add(willSaveField,c);
		
		c.gridy = 19;
		refSaveField = new JTextField(Integer.toString(me.getRefSave()));
		add(refSaveField,c);
		
		c.gridy = 20;
		meleeModifierField = new JTextField(Integer.toString(me.getMeleeModifier()));
		add(meleeModifierField,c);
		
		c.gridy = 21;
		rangedModifierField = new JTextField(Integer.toString(me.getRangedModifier()));
		add(rangedModifierField,c);
		
		noteBox = new NoteBox();
		c.gridy = 0;
		c.gridx = 6;
		c.weightx = 0.2;
		c.weighty = 1;
		c.gridheight = 11;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		add(noteBox, c);
		
		featBox = new FeatBox();
		c.gridy = 11;
		add(featBox, c);
		
		inventoryBox = new InventoryBox(this);
		c.gridy = 0;
		c.gridx = 8;
		c.gridheight = 12;
		add(inventoryBox, c);
		
		equippedBox = new EquippedBox(this);
		c.gridy = 12;
		c.gridheight = 7;
		add(equippedBox, c);
		
		coinBox = new CoinBox();
		c.gridy = 19;
		c.gridheight = 3;
		c.weighty = 0;
		add(coinBox, c);
		
		knownSpellBox = new KnownSpellBox();
		c.gridx = 10;
		c.gridy = 0;
		c.weighty = 1;
		c.gridheight = 11;
		add(knownSpellBox, c);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		totalHPField.setText(Integer.toString(me.totalHP));
		level.setText("Level: " + me.level);
		strField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.STR)));
		dexField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.DEX)));
		conField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.CON)));
		intField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.INT)));
		wisField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.WIS)));
		chaField.setText(Integer.toString(me.abilities.get(AbilityScoreEnum.CHA)));
		babField.setText(Integer.toString(me.getBAB()));
		acField.setText(Integer.toString(me.getAC()));
		touchACField.setText(Integer.toString(me.getTouchAC()));
		fortSaveField.setText(Integer.toString(me.getFortSave()));
		willSaveField.setText(Integer.toString(me.getWillSave()));
		refSaveField.setText(Integer.toString(me.getRefSave()));
		meleeModifierField.setText(Integer.toString(me.getMeleeModifier()));
		rangedModifierField.setText(Integer.toString(me.getRangedModifier()));
		skillBox.updateTextFields();
	}
	
	private class SkillBox extends JPanel{
		private ArrayList<JTextField> fields = new ArrayList<JTextField>();
		public SkillBox(){
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
				name = new JLabel(skill.toString());
				name.setBorder(border);
				
				name.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if (evt.getClickCount() > 1) {
							Pathfinder.showWebPage(skill.getURL());
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
			updateTextFields();
		}
		public void updateTextFields(){
			for(JTextField field : fields) field.setText("Filler for override");
		}
		public void addNewSkill(){
			//Setup system for adding skill subtypes.
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
				repaint();});
			
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
			listContainer = new JList<String>(model);
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
				Pathfinder.popupDialog(me.currentFeats.get(i).name, me.currentFeats.get(i).inDepthDescription);
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
	
	private class KnownSpellBox extends JPanel{
		
		private JList<String> listContainer;
		private JButton removalButton = new JButton("Remove Selected Spell(s)");
		private JButton forceNewSpells = new JButton("Force a new Spell");
		private JButton getSpellDetails = new JButton("Get Spell Details");
		private JScrollPane listScroll;
		
		public KnownSpellBox(){
			setLayout(new GridBagLayout());
			String[] model = new String[me.knownSpells.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.knownSpells.get(i).toString();
			listContainer = new JList<String>(model);
			
			listContainer.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					JList list = (JList)evt.getSource();
					if (evt.getClickCount() > 1) {
						int index = list.locationToIndex(evt.getPoint());
						Pathfinder.showSpellDetails(me.knownSpells.get(index));
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
			forceNewSpells.addActionListener(e -> {
				new Thread(() -> {
					me.knownSpells.add(Pathfinder.chooseSpellFromList(Spells.getSpells(), "Choose the spell to add"));
					repaint();
					}).start();
			});
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
				me.knownSpells.remove(indices[i]);
			}
			String[] model = new String[me.knownSpells.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.knownSpells.get(i).toString();
			listContainer.setListData(model);
		}
		
		public void showDetails(int[] indices){
			for(int i : indices){
				Pathfinder.showSpellDetails(me.knownSpells.get(i));
			}
		}
		
		public void paintComponent(Graphics g){
			//If you experience weird GUI problems remove this.
			super.paintComponent(g);
			String[] model = new String[me.knownSpells.size()];
			for(int i = 0; i < model.length; i++) model[i] = me.knownSpells.get(i).toString();
			listContainer.setListData(model);
		}
	}
}