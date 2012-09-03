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
	
//                      Type      String Name                 Type                       ID                 Extra Info  
	public static final Block     UnNamedOre        =         new BlockUnnamedOre      (1201);
	public static final Block     ExampleBlock      =         new BlockExampleBlock    (1202);
	public static final Item      helmetMagic       =        (new ItemMagicArmor       (1203, armorMAGIC, 5, 0)).setIconCoord(0, 6).setItemName("helmetTitanium");
    public static final Item      plateMagic        =        (new ItemMagicArmor       (1204, armorMAGIC, 5, 1)).setIconCoord(0, 7).setItemName("chestplateTitanium");
    public static final Item      legsMagic         =        (new ItemMagicArmor       (1205, armorMAGIC, 5, 2)).setIconCoord(0, 8).setItemName("leggingsTitanium");
    public static final Item      bootsMagic        =        (new ItemMagicArmor       (1206, armorMAGIC, 5, 3)).setIconCoord(0, 9).setItemName("bootsTitanium");
@Override	
public void load() {
		
MinecraftForgeClient.preloadTexture("/ArcaneFantasy/gui/items.png");
	
		
// Config
ArcaneFantasyConfig.InitliazeConfig("ArcaneFantasy");
	

// Register Block      Block Name
ModLoader.registerBlock(ExampleBlock);

// Add Names      String Name               Ingame Name
ModLoader.addName(UnNamedOre,              "Unnamed ore");
ModLoader.addName(ExampleBlock,            "This is an example block");
ModLoader.addName(helmetMagic,            "Magic Helmet");
ModLoader.addName(plateMagic,            "Magic Chestplate");
ModLoader.addName(legsMagic,            "Magic Leggings");
ModLoader.addName(bootsMagic,            "Magic Boots");

// Add Recipies
ModLoader.addRecipe(new ItemStack(ExampleBlock, 1), new Object []{ " + ",   " X ",  "   ",   '+', Item.stick, 'X',Block.dirt           });

}
}