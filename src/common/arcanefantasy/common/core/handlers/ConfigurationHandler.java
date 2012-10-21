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

import static net.minecraftforge.common.Configuration.*;


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
        ID_BLOCK_ORE_GEM   = config.getOrCreateBlockIdProperty(NAME_ORE_GEM, ID_BLOCK_ORE_GEM)
                                   .getInt(ID_BLOCK_ORE_GEM);
        ID_BLOCK_ORE_METAL = config.getOrCreateBlockIdProperty(NAME_ORE_METAL, ID_BLOCK_ORE_METAL)
                                   .getInt(ID_BLOCK_ORE_METAL);
        ID_BLOCK_STONE     = config.getOrCreateBlockIdProperty(NAME_STONE, ID_BLOCK_STONE)
                                   .getInt(ID_BLOCK_STONE);

        // Item Ids
        ID_ITEM_GEM    = config.getOrCreateIntProperty(NAME_GEM, CATEGORY_ITEM, ID_ITEM_GEM)
                               .getInt(ID_ITEM_GEM);
        ID_ITEM_METAL  = config.getOrCreateIntProperty(NAME_METAL, CATEGORY_ITEM, ID_ITEM_METAL)
                               .getInt(ID_ITEM_METAL);
        ID_ITEM_SLATEF = config.getOrCreateIntProperty(NAME_SLATEF, CATEGORY_ITEM, ID_ITEM_SLATEF)
                               .getInt(ID_ITEM_SLATEF);
        ID_ITEM_CHALK  = config.getOrCreateIntProperty(NAME_CHALK, CATEGORY_ITEM, ID_ITEM_CHALK)
                               .getInt(ID_ITEM_CHALK);
        ID_ITEM_SALT   = config.getOrCreateIntProperty(NAME_SALT, CATEGORY_ITEM, ID_ITEM_SALT)
                               .getInt(ID_ITEM_SALT);
        ID_ITEM_SWORD  = config.getOrCreateIntProperty(NAME_SWORD, CATEGORY_ITEM, ID_ITEM_SWORD)
                               .getInt(ID_ITEM_SWORD);

        config.save();

    }
}
