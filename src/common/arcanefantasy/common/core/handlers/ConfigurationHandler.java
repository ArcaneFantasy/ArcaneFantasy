/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.core.handlers;

import net.minecraftforge.common.Configuration;

import java.io.File;

import static arcanefantasy.common.core.managers.BlockManager.*;
import static arcanefantasy.common.core.managers.ItemManager.*;
import static arcanefantasy.common.lib.BlockIds.*;
import static arcanefantasy.common.lib.ItemIds.*;


/**
 * Loads config file.
 *
 * @author  HMPerson1
 */
public class ConfigurationHandler {

    /**
     * The standard Forge config implementation.
     */
    private static Configuration config;

    private ConfigurationHandler() { }

    /**
     * Initialize the handler with the config file.
     *
     * @param  configFile  file to be used for configs
     */
    public static void init(final File configFile) {
        config = new Configuration(configFile);
        config.load();

        // Block Ids
        ID_BLOCK_ORE_GEM   = config.getBlock(NAME_ORE_GEM, ID_BLOCK_ORE_GEM)
                                   .getInt(ID_BLOCK_ORE_GEM);
        ID_BLOCK_ORE_METAL = config.getBlock(NAME_ORE_METAL, ID_BLOCK_ORE_METAL)
                                   .getInt(ID_BLOCK_ORE_METAL);
        ID_BLOCK_STONE     = config.getBlock(NAME_STONE, ID_BLOCK_STONE).getInt(ID_BLOCK_STONE);

        // Item Ids
        ID_ITEM_GEM    = config.getItem(NAME_GEM, ID_ITEM_GEM).getInt(ID_ITEM_GEM);
        ID_ITEM_METAL  = config.getItem(NAME_METAL, ID_ITEM_METAL).getInt(ID_ITEM_METAL);
        ID_ITEM_SLATEF = config.getItem(NAME_SLATEF, ID_ITEM_SLATEF).getInt(ID_ITEM_SLATEF);
        ID_ITEM_CHALK  = config.getItem(NAME_CHALK, ID_ITEM_CHALK).getInt(ID_ITEM_CHALK);
        ID_ITEM_SALT   = config.getItem(NAME_SALT, ID_ITEM_SALT).getInt(ID_ITEM_SALT);

        configArray(ID_ITEM_AXE, NAME_AXE);
        configArray(ID_ITEM_HOE, NAME_HOE);
        configArray(ID_ITEM_PICKAXE, NAME_PICKAXE);
        configArray(ID_ITEM_SPADE, NAME_SPADE);
        configArray(ID_ITEM_SWORD, NAME_SWORD);

        config.save();
    }

    /**
     * Configures all the id's in the given array.
     *
     * @param  ids   the array to configure
     * @param  name  the value of name
     */

    private static void configArray(final int[] ids, final String name) {
        int i = 0;

        for (final int id : ids) {
            ids[i] = config.getItem(name + i, id).getInt(id);
            ++i;
        }
    }
}
