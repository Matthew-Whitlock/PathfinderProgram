package src.items;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Matthew on 6/17/2016.
 */
public class GenItem implements Item, Serializable{
    public final int GENERIC = -1;
    public final int ARMOR = 0;
    public final int WEAPON = 1;
    public final int MAGIC = 2;
    public final int OTHER = 3;

    public final int NOT_SET = -6516583;

    private Item itemBase;

    private int backingType;

    //For custom generic items only
    public String name;
    public String description;
    public String inventoryLine;
    public int[] attackMultiplier;
    public int minCritThreat;
    public int acPen;
    public int acBoost;
    public int maxDEX;
    public int[] cost;
    public double weight;
    public int amount;
    public int speedFromThirty;
    public int speedFromTwenty;

    //For player modifications
    public String newName;
    public String newDescription;
    public String newInventoryLine;
    public int newMaxDex = NOT_SET;
    public int newACPen = NOT_SET;
    public int newACBoost = NOT_SET;
    public int[] newCost = new int[]{NOT_SET};
    public int newAmount = NOT_SET;
    public int[] newAttackMultiplier = new int[]{NOT_SET};
    public int newMinCritThreat = NOT_SET;
    public double newWeight = NOT_SET;
    public int newSpeedFromTwenty;
    public int newSpeedFromThirty;


    public GenItem(Item item){
        itemBase = item;

        if(item instanceof ArmorEnum){
            backingType = ARMOR;
        } else if (item instanceof WeaponEnum){
            backingType = WEAPON;
        } else if (item instanceof MagicItem){
            backingType = MAGIC;
        }else {
            backingType = OTHER;
        }
    }

    public GenItem(String name, String description, int[] cost, int amount, double weight){
        this.name = name;
        this.description = description;
        inventoryLine = name;
        attackMultiplier = new int[]{2};
        minCritThreat = 20;
        acPen = 0;
        acBoost = 0;
        maxDEX = -1;
        this.cost = cost;
        this.amount = amount;
        speedFromThirty = 30;
        speedFromTwenty = 20;
        this.weight = weight;

        backingType = GENERIC;
    }

    public int getMaxDex(){
        if(newMaxDex != NOT_SET) return newMaxDex;
        if(backingType == GENERIC) return maxDEX;
        return itemBase.getMaxDex();
    }

    public int getACPen(){
        if(newACPen != NOT_SET) return newACPen;
        if(backingType == GENERIC) return acPen;
        return itemBase.getACPen();
    }

    public int getACBoost(){
        if(newACBoost != NOT_SET) return newACBoost;
        if(backingType == GENERIC) return acBoost;
        return itemBase.getACBoost();
    }

    public int[] cost(){
        if(newCost.length > 0 && newCost[0] != NOT_SET) return newCost;
        if(backingType == GENERIC) return cost;
        return itemBase.cost();
    }

    public double weight(){
        if(newWeight != NOT_SET) return newWeight;
        if(backingType == GENERIC) return weight;
        return itemBase.weight();
    }

    public int speedChange(int initialSpeed){

        if(backingType == GENERIC) {
            if(initialSpeed == 20) return (newSpeedFromTwenty != NOT_SET ? newSpeedFromTwenty : speedFromTwenty);
            if(initialSpeed == 30) return (newSpeedFromThirty != NOT_SET ? newSpeedFromThirty : speedFromThirty);

            return (int)(((30.0/(newSpeedFromThirty != NOT_SET ? newSpeedFromThirty : speedFromThirty) + 20.0/(newSpeedFromTwenty != NOT_SET ? newSpeedFromTwenty : speedFromTwenty))/2) * initialSpeed);
        }

        if(newSpeedFromTwenty != NOT_SET && newSpeedFromThirty != NOT_SET) return itemBase.speedChange(initialSpeed);

        if(initialSpeed == 20) return (newSpeedFromTwenty != NOT_SET ? newSpeedFromTwenty : itemBase.speedChange(20));
        if(initialSpeed == 30) return (newSpeedFromThirty != NOT_SET ? newSpeedFromThirty : itemBase.speedChange(30));

        return (int)(((30.0/(newSpeedFromThirty != NOT_SET ? newSpeedFromThirty : itemBase.speedChange(30)) + 20.0/(newSpeedFromTwenty != NOT_SET ? newSpeedFromTwenty : itemBase.speedChange(20)))/2) * initialSpeed);
    }

    public String getFormattedDetails(){
        if(newDescription != null) return null;
        if(backingType == GENERIC) return description;
        return itemBase.getFormattedDetails();
    }

    public String getInventoryLine(){
        if(newInventoryLine != null) return newInventoryLine;
        if(backingType == GENERIC) return inventoryLine;
        return itemBase.getInventoryLine();
    }

    public String toString(){
        if(newName != null) return newName;
        if(backingType == GENERIC){
            return name + (amount > 1 ? " (" + amount + ")" : "");
        }
        return itemBase.toString();
    }

    public int getPurchaseAmount(){
        if(newAmount != NOT_SET) return newAmount;
        if(backingType != GENERIC){
            return itemBase.getPurchaseAmount();
        }
        return amount;
    }

    public void resetAllCustomization(){
        newName = null;
        newDescription = null;
        newInventoryLine = null;
        newMaxDex = NOT_SET;
        newACPen = NOT_SET;
        newACBoost = NOT_SET;
        newCost = new int[]{NOT_SET};
        newAmount = NOT_SET;
        newAttackMultiplier = new int[]{NOT_SET};
        newMinCritThreat = NOT_SET;
        newWeight = NOT_SET;
        newSpeedFromTwenty = NOT_SET;
        newSpeedFromThirty = NOT_SET;
    }

    public boolean equals(GenItem toCompare){
        if(toCompare == null) return false;
        if(backingType != GENERIC)
            return backingType == toCompare.backingType && itemBase.equals(toCompare.itemBase) && newName.equals(toCompare.newName) && newDescription.equals(toCompare.newDescription) && newInventoryLine.equals(toCompare.newInventoryLine) &&
                    newMaxDex == toCompare.newMaxDex && newACPen == toCompare.newACPen && newACBoost == toCompare.newACBoost && newCost == toCompare.newCost && newAmount == toCompare.newAmount && Arrays.equals(newAttackMultiplier, toCompare.newAttackMultiplier) &&
                    newMinCritThreat == toCompare.newMinCritThreat && newWeight == toCompare.newWeight && newSpeedFromThirty == toCompare.newSpeedFromThirty && newSpeedFromTwenty == toCompare.newSpeedFromTwenty;
        else
            return backingType == toCompare.backingType && name.equals(toCompare.name) && description.equals(toCompare.description) && inventoryLine.equals(toCompare.inventoryLine) && Arrays.equals(attackMultiplier, toCompare.attackMultiplier) &&
                    minCritThreat == toCompare.minCritThreat && acPen == toCompare.acPen && acBoost == toCompare.acBoost && maxDEX == toCompare.maxDEX && Arrays.equals(cost, toCompare.cost) && weight == toCompare.weight &&
                    amount == toCompare.amount && speedFromThirty == toCompare.speedFromThirty && speedFromTwenty == toCompare.speedFromTwenty && newName.equals(toCompare.newName) && newDescription.equals(toCompare.newDescription) &&
                    newInventoryLine.equals(toCompare.newInventoryLine) && newMaxDex == toCompare.newMaxDex && newACPen == toCompare.newACPen && newACBoost == toCompare.newACBoost && newCost == toCompare.newCost && newAmount == toCompare.newAmount &&
                    Arrays.equals(newAttackMultiplier, toCompare.newAttackMultiplier) && newMinCritThreat == toCompare.newMinCritThreat && newWeight == toCompare.newWeight && newSpeedFromThirty == toCompare.newSpeedFromThirty &&
                    newSpeedFromTwenty == toCompare.newSpeedFromTwenty;
    }

    public int hashCode(){
        int hash;
        if(backingType != GENERIC){
            hash = 65179;
            hash += backingType;
            hash += itemBase != null ? itemBase.hashCode() : 0;
            hash += newName != null ? newName.hashCode() : 0;
            hash += newDescription != null ? newDescription.hashCode() : 0;
            hash += newInventoryLine != null ? newInventoryLine.hashCode() : 0;
            hash += newMaxDex;
            hash += newACPen;
            hash += newACBoost;
            for(int i : newCost) hash += i;
            hash += newAmount;
            for(int i : newAttackMultiplier) hash += i;
            hash += newMinCritThreat;
            hash += newWeight;
            hash += newSpeedFromThirty;
            hash += newSpeedFromTwenty;
        } else {
            hash = 65179;
            hash += backingType;
            hash += itemBase != null ? itemBase.hashCode() : 0;
            hash += newName != null ? newName.hashCode() : 0;
            hash += name != null ? name.hashCode() : 0;
            hash += newDescription != null ? newDescription.hashCode() : 0;
            hash += description != null ? description.hashCode() : 0;
            hash += newInventoryLine != null ? newInventoryLine.hashCode() : 0;
            hash += inventoryLine != null ? inventoryLine.hashCode() : 0;
            hash += newMaxDex == NOT_SET ? maxDEX : newMaxDex;
            hash += newACPen == NOT_SET ? acPen : newACPen;
            hash += newACBoost == NOT_SET ? acBoost : newACBoost;
            if(newCost[0] == NOT_SET)
                for(int i : cost) hash += i;
            else
                for(int i : newCost) hash += i;
            hash += newAmount == NOT_SET ? amount : newAmount;
            if(newAttackMultiplier[0] == NOT_SET)
                for(int i : attackMultiplier) hash += i;
            else
                for(int i : newAttackMultiplier) hash += i;
            hash += newMinCritThreat == NOT_SET ? minCritThreat : newMinCritThreat;
            hash += newWeight == NOT_SET ? weight : newWeight;
            hash += newSpeedFromThirty == NOT_SET ? speedFromThirty : newSpeedFromThirty;
            hash += newSpeedFromTwenty == NOT_SET ? speedFromTwenty : newSpeedFromTwenty;
        }

        return hash;
    }

    public String getItemName(){
        if(newName != null) return newName;
        if(backingType == GENERIC) return name;
        return itemBase.getItemName();
    }

}
