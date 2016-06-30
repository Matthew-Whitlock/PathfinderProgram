package src.classes;

import src.Character;
import src.spells.Spell;
import src.spells.Spells;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Matthew on 6/29/2016.
 */
public class SpellCaster extends CharacterClass{

    public ArrayList<Spell> knownSpells = new ArrayList<>();
    public HashMap<Spell, Integer> preppedSpells = new HashMap<>();
    public int[] spellsCastToday = new int[10];
    public int[] modifiedSpellsPerDay = new int[10];
    public int arcaneUsed = 0;
    public int arcanePoolMod = 0;

    public SpellCaster(Character me, String name){
        super(me, name);
    }

    public void modifySpellsPerDay(int level, int newValue){
        modifiedSpellsPerDay[level] += newValue - getSpellsPerDay()[level];
    }

    public int[] getSpellsPerDay(){
        return new int[]{0,0,0,0,0,0,0,0,0};
    }

    public int getSpellLevel(Spell spell){
        return Spells.spellLevelFor(name, spell);
    }

    public int getArcanePool(){
        return arcanePoolMod;
    }

    public void setArcanePool(int newValue){
        arcanePoolMod = newValue;
    }
}
