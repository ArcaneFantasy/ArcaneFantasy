/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.client.core;

import arcanefantasy.common.core.CommonProxy;
import arcanefantasy.common.lib.Reference;

import net.minecraftforge.client.MinecraftForgeClient;


/**
 * Client-side proxy.
 *
 * @author  HMPerson1
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerClientHandlers() {
        // TODO: Register sounds n' stuff...
    }

    @Override
    public void preloadTextures() {

        // Tell Minecraft that we'll be using these files
        MinecraftForgeClient.preloadTexture(Reference.SPRITE_SHEET_LOCATION +
                Reference.ITEM_SPRITE_SHEET);
        MinecraftForgeClient.preloadTexture(Reference.SPRITE_SHEET_LOCATION +
                Reference.BLOCK_SPRITE_SHEET);
    }
}
