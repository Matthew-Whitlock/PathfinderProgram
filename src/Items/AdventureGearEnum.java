package src.items;

import java.io.Serializable;
import java.net.URL;

/**
 * Created by Matthew on 6/19/2016.
 */
public enum AdventureGearEnum implements Serializable, Item{

    BATHTUB_COLLAPSIBLE("Bathtub, collapsible", "Comfort and Shelter", 0, 15, 0, 0, 20, 1, "", "PRG:UE", "After 10 minutes of assembly, this collection of wooden slats provides support for a cylindrical watertight canvas cloth. It can hold enough water to allow 1 Medium creature to bathe in comfort without any of the risks that might come from entering lakes, rivers, or other bodies of water.");
    /*BEDROLL(),
    BLANKET(),
    CHAIR_FOLDING(),
    COT(),
    HAMMOCK(),
    SOAP(),
    TENT_SMALL(),
    TENT_MEDIUM(),
    TENT_LARGE(),
    TENT_PAVILION(),
    TENT_HANGING(),

    FISHHOOK("Fishhook", "Hunting and Fishing", 0, 0, 1, 0, 0, 1, "", "PRG:UE", "This metal hook is little more than a stiff, bent needle."),
    NET_BELL(),
    NETTING_CAMOUFLAGE(),
    NET_FISHING(),
    SCENT_CLOAK(),
    TRAP_BEAR(),

    AIR_BLADDER("Air Bladder", "Misc. Outdoors Gear", 0, 0, 1, 0, 0.5, 1, "", "PRG:UE", "Used by swimmers for longer dives, this bladder is similar to a waterskin, but is relatively airtight. If inflated, it holds enough air to sustain a Medium creature for 1 round or a Small creature for 2 rounds."),
    ANIMAL_GLUE(),
    BELL(),
    BUOY_COMMON(),
    BUOY_SUPERIOR(),
    COMPASS(),
    HEATSTONE(),
    MAP(),
    MIRROR_SMALL_STEEL(),
    ROPE_HEMP("Rope, Hemp", "Misc. Outdoors Gear", 0, 1, 0, 0, 0.2, 50, "ft.", "PRG:UE", "The DC to escape hemp rope bonds is equal to 20 + the CMB of the creature that tied the bonds. Ropes do not need to make a check every round to maintain the pin. If the DC to escape is higher than 20 + the tying creatures CMB, the tied up creature cannot escape from the bonds, even with a natural 20 on the check. This rope has 2 hit points and can be burst with a DC 23 Strength check. Price 1 gp; Weight 10 lbs.\n" +
            "\n" +
            "FYI: The Equipment Trick feat provides a number of options for using this item in combat." ),
    ROPE_BLOODVINE(),
    ROPE_SILK(),
    ROPE_SPIDERS_SILK(),
    STAR_CHARTS(),
    STRING_TWINE(),
    HORN_POWDER(),
    HORN_SIGNAL(),
    WHISTLE_BEAST(),
    WHISTLE_SIGNAL(),
    WHISTLE_SILENT(),

    CANDLE("Candle", "Illumination", 0, 0, 0, 1, 0, 1, "", "PRG:UE", "A candle dimly illuminates a small area, increasing the light level in a 5-foot radius by one step (darkness becomes dim light and dim light becomes normal light). A candle cannot increase the light level above normal light. A candle burns for 1 hour."),
    CANDLE_HELMET(),
    CANDLE_INSECTBADE(),
    CANDLE_LAMP(),
    CANDLESTICK(),
    DARKFLARE(),
    FIREWOOD(),
    LAMP(),
    LAMP_CELESTIAL(),
    LANTERN_BULLSEYE(),
    LANTERN_DARKLIGHT(),
    LANTERN_HOODED(),
    LANTERN_MINERS(),
    LANTERN_WATERPROOF(),
    MOONROD(),
    SUNROD(),
    THURIBLE(),
    TORCH(),
    TORCH_EVERBURNING(),

    ABSINTHE_GLASS("Absinthe Glass", "Alcohol", 0, 3, 0, 0, 0, 1, "", "PRG:UE", "This green alcoholic drink, made from wormwood, is rumored to enhance creativity, which makes it a favored beverage of artists and eccentrics."),
    ABSINTHE_BOTTLE(),
    ALE_BULK(),
    ALE(),
    ALE_DWARVEN_STOUT(),
    ALE_LUGLURCH_BULK(),
    ALE_LUGLURCH(),
    APPLEJACK_BULK(),
    APPLEJACK(),
    BAIJIU(),
    BUFO(),
    CAUIM(),
    GODSBREW(),
    GROG_MUG(),
    GROG_CUP(),
    KUMIS(),
    MEAD(),
    MEAD_BULK(),
    MEAD_LINNORM(),
    PULQUE(),
    RUMBOOZLE(),
    TEPACHE(),
    WHISKEY_DRAGON_PUNCH(),
    WHISKEY_OLDLAW(),
    WINE_COMMON(),
    WINE_FINE(),
    WINE_SEALORD(),

    COFFE_COMMON("Common Coffee", "Beverage", 0, 0, 0, 1, 0.5, 1, "", "PPC:AA", "This drink is brewed by pouring boiling water through crushed, roasted coffee beans. A very strong form is potent enough to reduce the penalties from the fatigued condition from –2 to –1 for 1 hour.\n" +
            "\n" +
            "The listed prices are for a tavern or restaurant in an average city."),
    COFFEE_EXOTIC(),
    KAHVE(),
    MILK(),
    MILK_POWDERED(),
    TEA(),
    TEA_CEREMONIAL(),
    TONIC_MEDICINAL(),

    BREAD("Bread", "Food", 0, 0, 0, 2, 0.5, 1, "", "PRG:CRB", "The listed prices are for one loaf in a tavern or restaurant in an average city."),
    CAVIAR(),
    CHEESE(),
    CHOCOLATE(),
    FORTUNE_COOKIE(),
    HAGGIS(),
    HONEY(),
    ICE_CREAM(),
    MAPLE_SYRUP(),
    MEAL_BANQUET(),
    MEAL_GOOD(),
    MEAL_COMMON(),
    MEAL_POOR(),
    MEAT(),
    MEAT_STREET(),
    RATIONS_TRAIL(),
    RATIONS_DWARVEN_TRAIL(),
    RATIONS_ELVEN_TRAIL(),
    RATIONS_GNOME_TRAIL(),
    RATIONS_HALFLING_TRAIL(),
    RATIONS_ORC_TRAIL(),
    RATIONS_WANDERMEAL(),
    TRAVEL_CAKE_MIX(),
    YOGURT(),

    LODGINGS_DESTITUTE("Lodgings, Destitute", "Lodgings", 0, 0, 0, 0, 0, 1, "", "PRG:CRB", "An adventurer's primary source of income is treasure, and his primary purchases are tools and items he needs to continue adventuring—spell components, weapons, magic items, potions, and the like. Yet what about things like food? Rent? Taxes? Bribes? Idle purchases?\n" +
            "\n" +
            "You can certainly handle these minor expenditures in detail during play, but tracking every time a PC pays for a room, buys water, or pays a gate tax can swiftly become obnoxious and tiresome. If you're not really into tracking these minor costs of living, you can choose to simply ignore these small payments. A more realistic and easier-to-use method is to have PCs pay a recurring cost of living tax. At the start of every game month, a PC must pay an amount of gold equal to the lifestyle bracket he wishes to live in—if he can't afford his desired bracket, he drops down to the first one he can afford.\n" +
            "\n" +
            "Destitute (0 gp/month): The PC is homeless and lives in the wilderness or on the streets. A destitute character must track every purchase, and may need to resort to Survival checks or theft to feed himself."),
    LODGINGS_POOR(),
    LODINGS_AVERAGE(),
    LODGINGS_WEALTHTY(),
    LODGINGS_EXTRAVAGANT();*/

    private final String name;
    private final String type;
    private final int platinum;
    private final int gold;
    private final int silver;
    private final int copper;
    private final double weight;
    private final int amount;
    private final String unit;
    private final String source;
    private final String description;

    AdventureGearEnum(String name, String type, int platinum, int gold, int silver, int copper, double weight, int amount, String unit, String source, String description){
        this.name = name;
        this.type = type;
        this.platinum = platinum;
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
        this.weight = weight;
        this.amount = amount;
        this.unit = unit;
        this.source = source;
        this.description = description;
    }

    public int speedChange(int previousSpeed){
        return previousSpeed;
    }

    public int getACPen(){
        return 0;
    }

    public int getMaxDex(){
        return -1;
    }

    public int getACBoost(){
        return 0;
    }

    public int[] cost(){
        return new int[]{platinum, gold, silver, copper};
    }

    public double weight(){
        return weight;
    }

    public String getInventoryLine(){
        return name;
    }

    public int getPurchaseAmount(){
        return amount;
    }

    public String toString(){
        return name + " (" + type + ")";
    }

    public String getFormattedDetails(){
        String toReturn = toString() + (amount > 1 ? " (" + amount + ")" : "") + "<br>";

        toReturn += "Cost: ";
        boolean hasAnything = false;
        if(platinum > 0){
            hasAnything = true;
            toReturn += platinum + " Platinum ";
        }
        if( gold > 0 ){
            hasAnything = true;
            toReturn += gold + " Gold";
        }
        if( silver > 0){
            hasAnything = true;
            toReturn += silver + " Silver";
        }
        if( copper > 0 ){
            hasAnything = true;
            toReturn += copper + " Copper";
        }
        if(!hasAnything) toReturn += "0 ";

        toReturn = toReturn.substring(0, toReturn.length() - 1);
        if(amount > 1) toReturn += " per " + amount;
        if(!unit.equals("")) toReturn += " (" + unit + ")";
        toReturn += "<br>";

        toReturn += "Weight: " + weight + "<br>";
        toReturn += "<br><br>";
        toReturn += description + "<br>" + "Source: " + source;

        return toReturn;
    }

    public String getItemName(){
        return name;
    }

    public String type(){
        return type;
    }

    public String source(){
        return source;
    }

    public URL getIcon(){
        if(type.equals("Food")){
            return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/I_C_Bread.png");
        }
        if(type.equals("Beverage")){
            return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/BeverageGlass.png");
        }
        if(type.equals("Alcohol")){
            return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/AlcoholicGlass.png");
        }
        if(type.equals("Comfort and Shelter")){
            return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/Chair.png");
        }
        if(type.equals("Hunting and Fishing")){
            return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/FishingPole.png");
        }
        if(type.equals("Misc. Outdoors Gear")){
            return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/Compass.png");
        }
        if(type.equals("Illumination")){
            return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/Candles.png");
        }
        if(type.equals("Lodgings")){
            return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/I_Key01.png");
        }

        return AdventureGearEnum.class.getResource("/src/pictures/ItemIcons/SwordShieldImageIcon.png");
    }
}
