/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.item;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

import arcaneFantasy.common.lib.ItemIds;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 *
 * @author HMPerson1
 */
@SuppressWarnings("PublicField")
public class ItemManager {

    public static Item gem;
    public static Item metal;

    /**
     * Initializes items.
     */
    public static void init() {
        gem = new ItemModGem(ItemIds.ITEM_GEM).setIconCoord(0, 0)
                .setItemName("gem").setTabToDisplayOn(CreativeTabs.tabMaterials);
        metal = new ItemModMetal(ItemIds.ITEM_METAL).setIconCoord(1, 0)
                .setItemName("metal").setTabToDisplayOn(CreativeTabs.tabMaterials);

        LanguageRegistry.addName(new ItemStack(gem, 1, 0), "Crystal Gem");
        LanguageRegistry.addName(new ItemStack(gem, 1, 1), "Amethyst Gem");
        LanguageRegistry.addName(new ItemStack(metal, 1, 0), "Copper Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 1), "Pyrite Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 2), "Magneze Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 3), "Silver Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 4), "Magilith Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 5), "Dragon Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 6), "Platinum Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 7), "Paladinium Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 8), "Firium Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 9), "Glacium Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 10), "Foudrium Ingot");
    }

    /**
     * Registers item recipes.
     */
    public static void initRecipes() {
    }
}
