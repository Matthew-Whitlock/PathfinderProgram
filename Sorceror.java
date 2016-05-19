public class Sorceror extends CharacterClass{
	
	public Sorceror(){
		name = "Sorceror";
		hitDiePerLevel = "1d6";
		classSkills[Character.indexOfSkill("Appraise")] = true;
		classSkills[Character.indexOfSkill("Bluff")] = true;
		classSkills[Character.indexOfSkill("Fly")] = true;
		classSkills[Character.indexOfSkill("Intimidate")] = true;
		classSkills[Character.indexOfSkill("KN:Arcana")] = true;
		classSkills[Character.indexOfSkill("Profession")] = true;
		classSkills[Character.indexOfSkill("Spellcraft")] = true;
		classSkills[Character.indexOfSkill("Use Magic Device")] = true;
		classSkills[Character.indexOfSkill("Craft Alchemy")] = true;
		classSkills[Character.indexOfSkill("Craft Armor")] = true;
		classSkills[Character.indexOfSkill("Craft Bows")] = true;
		classSkills[Character.indexOfSkill("Craft Traps")] = true;
		classSkills[Character.indexOfSkill("Craft Weapons")] = true;
		classSkills[Character.indexOfSkill("Craft Generic")] = true;
	}
	
	public void levelUp(Character me){
		me.currentFeats.add(new EschewMaterials());
	}
	
	public String getClassSkillsAsString(){
		return "Temporary - fix this at getClassSkillsAsString() within Sorceror class file";
	}
	
	public int skillRanksAvailable(Character me){
		return 2 + (me.intel - 10)/2;
	}
	
	/*public abstract Spell bonusSpellAtLevel(int level);
	
	public abstract Feat[] getBonusFeatList(Character me);*/
}