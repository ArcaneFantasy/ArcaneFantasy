package arcaneFantasy;

import net.minecraft.src.forge.NetworkMod;
import net.minecraft.src.forge.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import java.io.File;


public class mod_ArcaneFantasy extends NetworkMod  {
	public String getVersion() { return "Arcane Fantasy Beta 0.1"; }

	
//                      Type      String Name                 Type                       ID                 Extra Info  
	public static final Item      ExampleItem       =         new ItemExampleItem      (1200);
	public static final Block     UnNamedOre        =         new BlockUnnamedOre      (1201);
	public static final Block     ExampleBlock      =         new BlockExampleBlock    (1202)            .setLightValue(1F);
	
@Override	
public void load() {
		
		
// Config
ArcaneFantasyConfig.InitliazeConfig("ArcaneFantasy");
	

// Register Block      Block Name
ModLoader.registerBlock(ExampleBlock);

// Add Names      String Name               Ingame Name
ModLoader.addName(UnNamedOre,              "Unnamed ore");
ModLoader.addName(ExampleBlock,            "This is an example block");
ModLoader.addName(ExampleItem,             "This is an example item");

// Add Recipies
ModLoader.addRecipe(new ItemStack(ExampleBlock, 1), new Object []{ " + ",   " X ",  "   ",   '+', Item.example, 'X',Block.example           });
ModLoader.addRecipe(new ItemStack(ExampleItem , 1), new Object []{ " + ",   " X ",  "   ",   '+', Item.example, 'X',Block.example           });		
}
}