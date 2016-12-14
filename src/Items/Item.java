package src.items;

import src.Pathfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

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
    URL getIcon();
}