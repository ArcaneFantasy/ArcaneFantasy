/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common;

import arcaneFantasy.common.block.BlockManager;
import arcaneFantasy.common.core.CommonProxy;
import arcaneFantasy.common.core.handlers.ConfigurationHandler;
import arcaneFantasy.common.item.ItemManager;
import arcaneFantasy.common.lib.Reference;
import arcaneFantasy.common.network.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 *
 * @author HMPerson1
 */
// TODO: Someone please help with javadocs
@Mod(modid = Reference.MOD_ID,
     name = Reference.MOD_NAME,
     version = Reference.VERSION)
@NetworkMod(clientSideRequired = true,
            serverSideRequired = true,
            channels = {Reference.CHANNEL_NAME},
            packetHandler = PacketHandler.class)
public class ArcaneFantasy {

    /**
     * The one and only instance of this mod. (Will be automatically filled by
     * FML)
     */
    @Mod.Instance
    @SuppressWarnings("PublicField")
    public static ArcaneFantasy instance;
    /**
     * The proxy. This will be set (by Forge) to different classes depending on
     * whether this is running on a server or client.
     */
    @SidedProxy(clientSide = "arcaneFantasy.client.core.ClientProxy",
                serverSide = "arcaneFantaxy.common.core.CommonProxy")
    @SuppressWarnings("PublicField")
    public static CommonProxy proxy;

    /**
     * Called by FML as soon as we're loaded.
     *
     * @param evt
     */
    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent evt) {
        // Initialize config
        ConfigurationHandler.init(evt.getSuggestedConfigurationFile());

        // Register stuff
        proxy.registerClientHandlers();
    }

    /**
     *
     * @param evt
     */
    @Mod.Init
    public void init(FMLInitializationEvent evt) {
        // Load texture files
        proxy.preloadTextures();

        // Init blocks/spawns
        BlockManager.init();

        // Init items
        ItemManager.init();

        // Init recipes
        BlockManager.initRecipes();
        ItemManager.initRecipes();
        // Recipes use items/blocks, so all the items/blocks need to be
        // initialized before the recipes can be added
        System.gc(); // I think we've used enough objects by now...
    }

    /**
     * Called after all the mods have been initialized.
     *
     * @param evt
     */
    @Mod.PostInit
    public void postInit(FMLPostInitializationEvent evt) {
        // TODO: Plugins??
    }
}
