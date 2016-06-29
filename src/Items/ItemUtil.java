package src.items;

import src.Pathfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        FileReader fileIn;
        BufferedReader input = null;

        try{
            File file = getMagicItemFilePath();

            if (file != null) {
                fileIn = new FileReader(file);
                input = new BufferedReader(fileIn);
            }
        }catch(IOException e){
            Pathfinder.showError("Error: Cannot access magic items","The items file is either not in the location expected, or I don't have permissions to access it.");
            return Collections.emptyList();
        }catch(Exception e){
            Pathfinder.showError("Error","Unspecified error. For more details run this from command line.");
            e.printStackTrace();
            return Collections.emptyList();
        }

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

    private static File getMagicItemFilePath(){
        URL url = ItemUtil.class.getResource("ItemUtil.class");
        File file;
        try{
            if(url.getProtocol().equals("jar")){
                url = new URL(url.getPath());
            }

            file = new File(url.getPath().split("!")[0].replace("%20", " "));
        }catch(Exception e){
            Pathfinder.showError("Error","Unspecified error. For more details run this from command line.\nCannot get correct path to Items.txt");
            return null;
        }

        if(file.toString().contains("src\\items\\ItemUtil.class"))
            file = new File(file.toString().substring(0, file.toString().indexOf("src\\items\\ItemUtil.class")) + "Resources\\Items.txt");
        else
            file = new File(file.toString().substring(0, file.toString().lastIndexOf("\\")) + "\\Resources\\Items.txt");

        return file;
    }
}
