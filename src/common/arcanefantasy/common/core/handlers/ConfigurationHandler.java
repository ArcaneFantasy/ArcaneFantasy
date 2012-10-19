/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.core.handlers;

import arcanefantasy.common.lib.BlockIds;

import net.minecraftforge.common.Configuration;

import java.io.File;

import static arcanefantasy.common.block.BlockManager.*;
import static arcanefantasy.common.item.ItemManager.*;
import arcanefantasy.common.lib.ItemIds;

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

    /**
     * Initialize the handler with the config file.
     *
     * @param  configFile  file to be used for configs
     */
    public static void init(final File configFile) {
        config = new Configuration(configFile);
        config.load();

        // Block Ids
        BlockIds.BLOCK_ORE_GEM   = config
                .getOrCreateBlockIdProperty(NAME_ORE_GEM, BlockIds.BLOCK_ORE_GEM)
                .getInt(BlockIds.BLOCK_ORE_GEM);
        BlockIds.BLOCK_ORE_METAL = config
                .getOrCreateBlockIdProperty(NAME_ORE_METAL, BlockIds.BLOCK_ORE_METAL)
                .getInt(BlockIds.BLOCK_ORE_METAL);
        BlockIds.BLOCK_STONE     = config
                .getOrCreateBlockIdProperty(NAME_AF_STONE, BlockIds.BLOCK_STONE)
                .getInt(BlockIds.BLOCK_STONE);

        // Item Ids
        ItemIds.ITEM_GEM         = config
                .getOrCreateIntProperty(NAME_GEM, CATEGORY_ITEM, ItemIds.ITEM_GEM)
                .getInt(ItemIds.ITEM_GEM);
        ItemIds.ITEM_METAL       = config
                .getOrCreateIntProperty(NAME_METAL, CATEGORY_ITEM, ItemIds.ITEM_METAL)
                .getInt(ItemIds.ITEM_METAL);
        ItemIds.ITEM_SLATE_FLAKE = config
                .getOrCreateIntProperty(NAME_SLATEF, CATEGORY_ITEM, ItemIds.ITEM_SLATE_FLAKE)
                .getInt(ItemIds.ITEM_SLATE_FLAKE);
        ItemIds.ITEM_CHALK       = config
                .getOrCreateIntProperty(NAME_CHALK, CATEGORY_ITEM, ItemIds.ITEM_CHALK)
                .getInt(ItemIds.ITEM_CHALK);
        ItemIds.ITEM_SALT        = config
                .getOrCreateIntProperty(NAME_SALT, CATEGORY_ITEM, ItemIds.ITEM_SALT)
                .getInt(ItemIds.ITEM_SALT);
        ItemIds.ITEM_SWORD       = config
                .getOrCreateIntProperty(NAME_SWORD, CATEGORY_ITEM, ItemIds.ITEM_SWORD)
                .getInt(ItemIds.ITEM_SWORD);
        config.save();

    }
}
