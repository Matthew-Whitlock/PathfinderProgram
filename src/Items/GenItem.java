package src.items;

import java.io.Serializable;
import java.net.URL;
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
    public URL iconURL = null;

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
    public int newSpeedFromTwenty = NOT_SET;
    public int newSpeedFromThirty = NOT_SET;
    public URL newURL = null;


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

    public GenItem(String name, int acPenalty, int acBonus, int maxDex, int amountPerPurchase, double weight, int[] cost, String description, URL image){
        this.name = name;
        this.description = description;
        inventoryLine = name;
        attackMultiplier = new int[]{2};
        minCritThreat = 20;
        acPen = acPenalty;
        acBoost = acBonus;
        maxDEX = maxDex;
        this.cost = cost;
        this.amount = amountPerPurchase;
        speedFromThirty = 30;
        speedFromTwenty = 20;
        this.weight = weight;
        this.iconURL = image;

        backingType = GENERIC;
    }

    public GenItem(Item item, String name, int acPenalty, int acBonus, int maxDex, int amountPerPurchase, double weight, int[] cost, String description, URL image){
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

        this.newName = name;
        this.newACPen = acPenalty;
        this.newACBoost = acBonus;
        this.newMaxDex = maxDex;
        this.newAmount = amountPerPurchase;
        this.newWeight = weight;
        this.newCost = cost;
        this.newDescription = description;
        this.newInventoryLine = name;
        this.newURL = image;
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
        if(newDescription != null) return newDescription;
        if(backingType == GENERIC) return description;
        return itemBase.getFormattedDetails();
    }

    public String getInventoryLine(){
        if(newInventoryLine != null) return newInventoryLine;
        if(backingType == GENERIC) return inventoryLine;
        return itemBase.getInventoryLine();
    }

    public String toString(){

        if(newName != null)
            return newName + (newAmount == NOT_SET ?
                (backingType == GENERIC ?
                        ((amount != 1 ?
                                " (" + amount + ")"
                                : ""))
                        : (itemBase.getPurchaseAmount() != 1 ?
                                " (" + itemBase.getPurchaseAmount() + ")"
                                : ""))
                : (newAmount != 1 ?
                        (" (" + newAmount + ")")
                        : (""))) ;

        if(backingType == GENERIC){
            return name + (newAmount == NOT_SET ? (amount != 1 ? " (" + amount + ")" : "") : (newAmount != 1 ? " (" + newAmount + ")" : ""));
        }
        return itemBase.getItemName() + (newAmount == NOT_SET ? (itemBase.getPurchaseAmount() != 1 ? " (" + itemBase.getPurchaseAmount() + ")" : "") : newAmount != 1 ? " (" + newAmount + ")" : "");
    }

    public int getPurchaseAmount(){
        if(newAmount != NOT_SET) return newAmount;
        if(backingType != GENERIC){
            return itemBase.getPurchaseAmount();
        }
        return amount;
    }

    public URL getIcon(){
        if(newURL != null) return newURL;
        if(backingType != GENERIC) return itemBase.getIcon();
        return iconURL;
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
        newURL = null;
    }

    public Item baseItem(){
        return itemBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenItem genItem = (GenItem) o;

        if (backingType != genItem.backingType) return false;
        if (minCritThreat != genItem.minCritThreat) return false;
        if (acPen != genItem.acPen) return false;
        if (acBoost != genItem.acBoost) return false;
        if (maxDEX != genItem.maxDEX) return false;
        if (Double.compare(genItem.weight, weight) != 0) return false;
        if (amount != genItem.amount) return false;
        if (speedFromThirty != genItem.speedFromThirty) return false;
        if (speedFromTwenty != genItem.speedFromTwenty) return false;
        if (newMaxDex != genItem.newMaxDex) return false;
        if (newACPen != genItem.newACPen) return false;
        if (newACBoost != genItem.newACBoost) return false;
        if (newAmount != genItem.newAmount) return false;
        if (newMinCritThreat != genItem.newMinCritThreat) return false;
        if (Double.compare(genItem.newWeight, newWeight) != 0) return false;
        if (newSpeedFromTwenty != genItem.newSpeedFromTwenty) return false;
        if (newSpeedFromThirty != genItem.newSpeedFromThirty) return false;
        if (itemBase != null ? !itemBase.equals(genItem.itemBase) : genItem.itemBase != null) return false;
        if (name != null ? !name.equals(genItem.name) : genItem.name != null) return false;
        if (description != null ? !description.equals(genItem.description) : genItem.description != null) return false;
        if (inventoryLine != null ? !inventoryLine.equals(genItem.inventoryLine) : genItem.inventoryLine != null)
            return false;
        if (!Arrays.equals(attackMultiplier, genItem.attackMultiplier)) return false;
        if (!Arrays.equals(cost, genItem.cost)) return false;
        if (iconURL != null ? !iconURL.equals(genItem.iconURL) : genItem.iconURL != null) return false;
        if (newName != null ? !newName.equals(genItem.newName) : genItem.newName != null) return false;
        if (newDescription != null ? !newDescription.equals(genItem.newDescription) : genItem.newDescription != null)
            return false;
        if (newInventoryLine != null ? !newInventoryLine.equals(genItem.newInventoryLine) : genItem.newInventoryLine != null)
            return false;
        if (!Arrays.equals(newCost, genItem.newCost)) return false;
        if (!Arrays.equals(newAttackMultiplier, genItem.newAttackMultiplier)) return false;
        return newURL != null ? newURL.equals(genItem.newURL) : genItem.newURL == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = itemBase != null ? itemBase.hashCode() : 0;
        result = 31 * result + backingType;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (inventoryLine != null ? inventoryLine.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(attackMultiplier);
        result = 31 * result + minCritThreat;
        result = 31 * result + acPen;
        result = 31 * result + acBoost;
        result = 31 * result + maxDEX;
        result = 31 * result + Arrays.hashCode(cost);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + amount;
        result = 31 * result + speedFromThirty;
        result = 31 * result + speedFromTwenty;
        result = 31 * result + (iconURL != null ? iconURL.hashCode() : 0);
        result = 31 * result + (newName != null ? newName.hashCode() : 0);
        result = 31 * result + (newDescription != null ? newDescription.hashCode() : 0);
        result = 31 * result + (newInventoryLine != null ? newInventoryLine.hashCode() : 0);
        result = 31 * result + newMaxDex;
        result = 31 * result + newACPen;
        result = 31 * result + newACBoost;
        result = 31 * result + Arrays.hashCode(newCost);
        result = 31 * result + newAmount;
        result = 31 * result + Arrays.hashCode(newAttackMultiplier);
        result = 31 * result + newMinCritThreat;
        temp = Double.doubleToLongBits(newWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + newSpeedFromTwenty;
        result = 31 * result + newSpeedFromThirty;
        result = 31 * result + (newURL != null ? newURL.hashCode() : 0);
        return result;
    }

    public String getItemName(){
        if(newName != null) return newName;
        if(backingType == GENERIC) return name;
        return itemBase.getItemName();
    }
}