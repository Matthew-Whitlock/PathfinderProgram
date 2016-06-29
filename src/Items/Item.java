package src.items;

/**
 * Created by Matthew on 6/16/2016.
 */
public interface Item {
    int getMaxDex();
    int getACPen();
    int getACBoost();
    int[] cost();
    double weight();
    int speedChange(int initialSpeed);
    int getPurchaseAmount();
    String getItemName();

    String getFormattedDetails();
    String getInventoryLine();
}
