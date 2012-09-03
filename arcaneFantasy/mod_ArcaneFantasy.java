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

	
//                      Type      String Name                 Type                   ID         Class                            Extra Info  
	public static final Item      Stringname =         new ItemItemType            (1201, Example.example             , 5, 0).setItemName("ItemName");	
	public static final Block
	
@Override	
public void load() {
		
		
// Config
ArcaneFantasyConfig.InitliazeConfig("ArcaneFantasy");
	

// Register Block      Block Name
ModLoader.registerBlock(ExampleBlock);

// Add Names      String Name              Ingame Name
ModLoader.addName(Stringname,             "NameOfObject");
		
// Add Recipies
ModLoader.addRecipe(new ItemStack(Stringname, 1), new Object []{ " + ",   " X ",  "   ",   '+', Item.example, 'X',Block.example           });
ModLoader.addRecipe(new ItemStack(Stringname, 1), new Object []{ " + ",   " X ",  "   ",   '+', Item.example, 'X',Block.example           });		
}
}