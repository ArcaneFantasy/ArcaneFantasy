/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcane_fantasy.common.core;

import cpw.mods.fml.common.network.IGuiHandler;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
public class CommonProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int          ID,
                                      EntityPlayer player,
                                      World        world,
                                      int          x,
                                      int          y,
                                      int          z) {

        // Not entirely sure what this does...
        return null;
    }

    @Override
    public Object getClientGuiElement(int          ID,
                                      EntityPlayer player,
                                      World        world,
                                      int          x,
                                      int          y,
                                      int          z) {

        // Not entirely sure what this does...
        return null;
    }


    /* *****Client Only Methods***** */

    /**
     * Registers the handlers on the client-side. (Does nothing server-side)
     */
    public void registerClientHandlers() {
    }

    /**
     * Pre-loads texture files. (Client-side only)
     */
    public void preloadTextures() {
    }
}
