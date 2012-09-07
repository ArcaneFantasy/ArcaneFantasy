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

    /**
     * Initializes items.
     */
    public static void init() {
        gem = new ItemModGem(ItemIds.ITEM_GEM).setIconCoord(0, 0)
                .setItemName("gem").setTabToDisplayOn(CreativeTabs.tabMaterials);

        LanguageRegistry.addName(new ItemStack(gem, 1, 0), "Crystal Gem");
        LanguageRegistry.addName(new ItemStack(gem, 1, 1), "Amethyst Gem");
    }

    /**
     * Registers item recipes.
     */
    public static void initRecipes() {
    }
}
