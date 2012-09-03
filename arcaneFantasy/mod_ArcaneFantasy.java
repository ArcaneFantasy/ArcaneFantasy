package arcaneFantasy;

import net.minecraft.src.forge.MinecraftForgeClient;
import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.forge.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.forge.EnumHelper;
import java.io.File;

public class mod_ArcaneFantasy extends NetworkMod  {
	public String getVersion() { return "Arcane Fantasy Beta 0.1"; }


	static EnumArmorMaterial armorMAGIC = EnumHelper.addArmorMaterial("MAGIC", 29, new int[] {2, 7, 5, 3}, 9);
	
//                      Type      String Name                           Type                        ID                                  Extra Info  
	public static final Block     CuivreOre             =         new BlockCuivreOre              (1199);
	public static final Block     ArdoiseOre            =         new BlockArdoiseOre             (1200);
	public static final Block     PaladiniumOre         =         new BlockPaladiniumOre          (1201);
	public static final Block     FiriumOre             =         new BlockFiriumOre              (1202);
	public static final Item      helmetMagic           =        (new ItemMagicArmor              (1203, armorMAGIC, 5, 0))   .setIconCoord(0, 6).setItemName("helmetTitanium");
    public static final Item      plateMagic            =        (new ItemMagicArmor              (1204, armorMAGIC, 5, 1))   .setIconCoord(0, 7).setItemName("chestplateTitanium");
    public static final Item      legsMagic             =        (new ItemMagicArmor              (1205, armorMAGIC, 5, 2))   .setIconCoord(0, 8).setItemName("leggingsTitanium");
    public static final Item      bootsMagic            =        (new ItemMagicArmor              (1206, armorMAGIC, 5, 3))   .setIconCoord(0, 9).setItemName("bootsTitanium");
    public static final Block     PyriteOre             =         new BlockPyriteOre              (1207);
    public static final Block     CristalDeRoche        =         new BlockCristalDeRoche         (1208);
    public static final Block     Sel                   =         new BlockSel                    (1209);
    public static final Block     MagnezeOre            =         new BlockMagnezeOre             (1210);
    public static final Block     Marbre                =         new BlockMarbre                 (1211);
    public static final Block     ArgentOre             =         new BlockArgentOre              (1212);
    public static final Block     MagilithOre           =         new BlockMagilithOre            (1213);
    public static final Block     Améthiste             =         new BlockAméthiste              (1214);
    public static final Block     RochesMagmatique      =         new BlockRochesMagmatique       (1215);
    public static final Block     OsFociliséDeDragon    =         new BlockOsFociliséDeDragon     (1216);
    public static final Block     PlatineOre            =         new BlockPlatineOre             (1217);
    public static final Block     GlaciumOre            =         new BlockGlaciumOre             (1218);
    public static final Block     FoudriumOre           =         new BlockFoudriumOre            (1219);
    
@Override	
public void load() {
		
MinecraftForgeClient.preloadTexture("/ArcaneFantasy/gui/items.png");
	
		
// Config
ArcaneFantasyConfig.InitliazeConfig("ArcaneFantasy");
	

// Register Block      Block Name
ModLoader.registerBlock(FiriumOre);
ModLoader.registerBlock(CuivreOre);
ModLoader.registerBlock(ArdoiseOre);
ModLoader.registerBlock(PaladiniumOre);
ModLoader.registerBlock(PyriteOre);
ModLoader.registerBlock(CristalDeRoche);
ModLoader.registerBlock(Sel);
ModLoader.registerBlock(MagnezeOre);
ModLoader.registerBlock(Marbre);
ModLoader.registerBlock(ArgentOre);
ModLoader.registerBlock(MagilithOre);
ModLoader.registerBlock(Améthiste);
ModLoader.registerBlock(RochesMagmatique);
ModLoader.registerBlock(OsFociliséDeDragon);
ModLoader.registerBlock(PlatineOre);
ModLoader.registerBlock(GlaciumOre);
ModLoader.registerBlock(FoudriumOre);

// Add Names      String Name               Ingame Name
ModLoader.addName(CuivreOre,              "Cuivre Ore");
ModLoader.addName(ArdoiseOre,             "Ardoise Ore");
ModLoader.addName(PaladiniumOre,          "Paladinium Ore");
ModLoader.addName(FiriumOre,              "Firium Ore");
ModLoader.addName(helmetMagic,            "Magic Helmet");
ModLoader.addName(plateMagic,             "Magic Chestplate");
ModLoader.addName(legsMagic,              "Magic Leggings");
ModLoader.addName(bootsMagic,             "Magic Boots");
ModLoader.addName(PyriteOre,              "Pyrite Ore");
ModLoader.addName(CristalDeRoche,         "Cristal De Roche");
ModLoader.addName(Sel,                    "Sel");
ModLoader.addName(MagnezeOre,             "Magneze Ore");
ModLoader.addName(Marbre,                 "Marbre");
ModLoader.addName(ArgentOre,              "Argent Ore");
ModLoader.addName(MagilithOre,            "Magilith Ore");
ModLoader.addName(Améthiste,              "Améthiste");
ModLoader.addName(RochesMagmatique,       "Roches Magmatique");
ModLoader.addName(OsFociliséDeDragon,     "Os Focilisé De Dragon");
ModLoader.addName(PlatineOre,             "Platine Ore");
ModLoader.addName(GlaciumOre,             "Glacium Ore");
ModLoader.addName(FoudriumOre,            "Foudrium Ore");

// Add Recipies
//ModLoader.addRecipe(new ItemStack(ExampleObject,1),          new Object []{ "X+X",   "+ +",  "X+X",   '+', Block.example         , 'X',Item.example                  });
//ModLoader.addRecipe(new ItemStack(ExampleObject,1),          new Object []{ "X+X",   "+ +",  "X+X",   '+', Block.example         , 'X',Item.example                  });
//ModLoader.addRecipe(new ItemStack(ExampleObject,1),          new Object []{ "X+X",   "+ +",  "X+X",   '+', Block.example         , 'X',Item.example                  });
}
}