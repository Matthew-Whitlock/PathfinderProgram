package src.classes;

import src.Character;
import src.spells.Spell;
import src.spells.Spells;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Matthew on 6/29/2016.
 */
public class SpellCaster extends CharacterClass implements Serializable{

    public ArrayList<Spell> knownSpells = new ArrayList<>();
    public HashMap<Spell, Integer> preppedSpells = new HashMap<>();
    public int[] spellsCastToday = new int[10];
    public int[] modifiedSpellsPerDay = new int[10];
    public int arcaneUsed = 0;
    public int arcanePoolMod = 0;
    public String overrideLevelClass;

    public SpellCaster(Character me, String name){
        super(me, name);
    }

    public void modifySpellsPerDay(int level, int newValue){
        modifiedSpellsPerDay[level] += newValue - getSpellsPerDay()[level];
    }

    public int[] getSpellsPerDay(){
        return modifiedSpellsPerDay;
    }

    public int getSpellLevel(Spell spell){
        return Spells.spellLevelFor(overrideLevelClass == null ? name : overrideLevelClass, spell);
    }

    public int getArcanePool(){
        return arcanePoolMod;
    }

    public void setArcanePool(int newValue){
        arcanePoolMod = newValue;
    }
}