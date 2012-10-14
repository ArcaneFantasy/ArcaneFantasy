/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common;

import arcanefantasy.common.block.BlockManager;
import arcanefantasy.common.core.CommonProxy;
import arcanefantasy.common.core.handlers.ConfigurationHandler;
import arcanefantasy.common.entity.EntityManager;
import arcanefantasy.common.item.ItemManager;
import arcanefantasy.common.lib.Reference;
import arcanefantasy.common.network.PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
// TODO: Someone please help with javadocs
@Mod(
    modid   = Reference.MOD_ID,
    name    = Reference.MOD_NAME,
    version = Reference.VERSION
)
@NetworkMod(
    clientSideRequired = true,
    serverSideRequired = true,
    channels           = { Reference.CHANNEL_NAME },
    packetHandler      = PacketHandler.class
)
public class ArcaneFantasy {

    /**
     * The one and only instance of this mod. (Will be automatically filled by
     * FML)
     */
    @Mod.Instance
    @SuppressWarnings("PublicField" /* NOI18N */)
    public static ArcaneFantasy               instance;

    /**
     * The proxy. This will be set (by Forge) to different classes depending on
     * whether this is running on a server or client.
     */
    @SidedProxy(
        clientSide = "arcaneFantasy.client.core.ClientProxy" /* NOI18N */,
        serverSide = "arcaneFantaxy.common.core.CommonProxy" /* NOI18N */
    )
    @SuppressWarnings("PublicField"                          /* NOI18N */)
    public static CommonProxy proxy;

    /**
     * Called by FML as soon as we're loaded.
     *
     * @param  evt  DOCUMENT ME!
     */
    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent evt) {

        // Initialize config
        ConfigurationHandler.init(evt.getSuggestedConfigurationFile());

        // Register stuff
        proxy.registerClientHandlers();
    }

    /**
     * DOCUMENT ME!
     *
     * @param  evt  DOCUMENT ME!
     */
    @Mod.Init
    public void init(FMLInitializationEvent evt) {

        // Load texture files
        proxy.preloadTextures();

        // Init entities
        EntityManager.init();

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
     * @param  evt  DOCUMENT ME!
     */
    @Mod.PostInit
    public void postInit(FMLPostInitializationEvent evt) {
        // TODO: Plugins??
    }
}
