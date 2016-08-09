package src.items;

import src.Pathfinder;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Matthew on 6/19/2016.
 */
public class ItemUtil {

    public static List<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();

        for(WeaponEnum item : WeaponEnum.values()) items.add(item);
        for(ArmorEnum item : ArmorEnum.values()) items.add(item);
        for(AdventureGearEnum item : AdventureGearEnum.values()) items.add(item);
        items.addAll(getMagicItems());

        return items;
    }

    public static List<MagicItem> getMagicItems(){
        BufferedReader input = new BufferedReader(new InputStreamReader(ItemUtil.class.getResourceAsStream("/src/databases/Items.txt")));

        ArrayList<MagicItem> magicItems = new ArrayList<>();

        if (input == null) {
            return magicItems;
        }

        MagicItem magicItem;

        try{
            String magicItemInputString = input.readLine();

            while((magicItemInputString = input.readLine()) != null){
                try{
                    magicItem = new MagicItem(magicItemInputString);
                    magicItems.add(magicItem);
                } catch(Exception e){
                    Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
                    e.printStackTrace();
                    System.out.println(Arrays.asList(magicItemInputString.split("\t")));
                }
            }
        }catch(Exception e){
            Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nSome magic items may not be shown.");
            e.printStackTrace();
            return Collections.emptyList();
        }

        return magicItems;

    }
}