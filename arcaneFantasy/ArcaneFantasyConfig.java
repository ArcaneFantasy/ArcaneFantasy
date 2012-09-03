package arcaneFantasy;

import java.io.File;
import java.io.IOException;
 
import cpw.mods.fml.common.modloader.ModLoaderHelper;
 
import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;

public class ArcaneFantasyConfig {
	
	private static ArcaneFantasyConfig instance;
	
	private Configuration config;
	 

	private ArcaneFantasyConfig(String ArcaneFantasy)
	{
	 

		File configFile = new File(Minecraft.getMinecraftDir() + "/config/mod_" + ArcaneFantasy +".cfg");
	 
		
		if(!configFile.exists())
		{
			try
			{
				configFile.createNewFile();
			}
			catch(IOException e)
			{
				System.out.println("Could not create configuration file for " + ArcaneFantasy + ". Reason:");
				System.out.println(e);
				return;
			}
		}
	 
	
		config = new Configuration(configFile);
		config.load();
		
		
	}public static void InitliazeConfig(String ArcaneFantasy)
	{
		
		if(ArcaneFantasyConfig.instance != null)
		{
			return;
		}
	 
		
		ArcaneFantasyConfig.instance = new ArcaneFantasyConfig(ArcaneFantasy);
	}
	
	
	public static int GetBlockID(String BlockName, int DefaultID) throws Exception
	{
		if(ArcaneFantasyConfig.instance == null)
		{
			throw new Exception("Arcane Fantasy Config has not be initalized!");
		}
		return ArcaneFantasyConfig.instance.config.getOrCreateBlockIdProperty(BlockName + ".id", DefaultID).getInt();
	}
	
	public static int GetItemID(String ItemName, int DefaultValue) throws Exception
	{
		if(ArcaneFantasyConfig.instance == null)
		{
			throw new Exception("Arcane Fantasy Config has not be initalized!");
		}
		return ArcaneFantasyConfig.instance.config.getOrCreateIntProperty(ItemName + ".id", Configuration.CATEGORY_ITEM, DefaultValue).getInt();
	}
	
	public static void SaveConfig()
	{
		ArcaneFantasyConfig.instance.config.save();
	}

}
