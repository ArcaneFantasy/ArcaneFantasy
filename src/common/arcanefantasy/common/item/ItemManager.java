/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.item;

import arcanefantasy.common.block.BlockManager;
import arcanefantasy.common.lib.ItemIds;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.src.CraftingManager;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

import java.util.Locale;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
@SuppressWarnings("PublicField" /* NOI18N */)
public class ItemManager {

    /* Item name constants */
    public static final String NAME_GEM    = "gem";
    public static final String NAME_METAL  = "metal";
    public static final String NAME_SLATEF = "slatef";
    public static final String NAME_CHALK  = "chalk";
    public static final String NAME_SALT   = "salt";
    public static final String NAME_SWORD  = "swords";

    /* Item instances */
    public static Item          gem;
    public static Item          metal;
    public static Item          slateFlake;
    public static Item          chalk;
    public static Item          salt;
    public static ItemAFSword[] swords = new ItemAFSword[EnumAFToolMaterial.values().length];

    private ItemManager() { }

    /**
     * Initializes items.
     */
    public static void init() {
//J-
        // add the items
        gem        = new ItemAFGem(ItemIds.ITEM_GEM)
                .setIconCoord(0, 0)
                .setItemName(NAME_GEM)
                .setTabToDisplayOn(CreativeTabs.tabMaterials);
        metal      = new ItemAFMetal(ItemIds.ITEM_METAL)
                .setIconCoord(2, 0)
                .setItemName(NAME_METAL)
                .setTabToDisplayOn(CreativeTabs.tabMaterials);
        slateFlake = new ItemAFSlateFlake(ItemIds.ITEM_SLATE_FLAKE)
                .setIconCoord(1, 3)
                .setItemName(NAME_SLATEF)
                .setTabToDisplayOn(CreativeTabs.tabMaterials);
        chalk      = new ItemAFChalk(ItemIds.ITEM_CHALK)
                .setIconCoord(0, 2)
                .setItemName(NAME_CHALK)
                .setTabToDisplayOn(CreativeTabs.tabMaterials);
        salt       = new ItemAFSalt(ItemIds.ITEM_SALT)
                .setIconCoord(0, 3)
                .setItemName(NAME_SALT)
                .setTabToDisplayOn(CreativeTabs.tabMaterials);
//J+
        int i = 0;

        for (final EnumAFToolMaterial material : EnumAFToolMaterial.values()) {

            // easier to loop than to go through EVERY SINGLE SWORD
            final String name = material.name().toLowerCase(Locale.US);
            swords[i] = (ItemAFSword) new ItemAFSword(ItemIds.ITEM_SWORD + i, material)
                    .setIconCoord(i, 1).setItemName("sword." /* NOI18N */ + name)
                    .setTabToDisplayOn(CreativeTabs.tabCombat);

            // while we're in here, we might as well add the names
            LanguageRegistry.addName(
                swords[i],
                new StringBuilder().append(name.substring(0, 1).toUpperCase(Locale.US))
                                   .append(name.substring(1))
                                   .append(" Sword")
                                   .toString());
            ++i;
        }

        // add ALL the names
        LanguageRegistry.addName(new ItemStack(gem, 1, 0), "Quartz");
        LanguageRegistry.addName(new ItemStack(gem, 1, 1), "Amethyst");
        LanguageRegistry.addName(new ItemStack(metal, 1, 0), "Copper Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 1), "Pyrite Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 2), "Magneze Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 3), "Silver Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 4), "Magilith Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 5), "Dragon Bone Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 6), "Platinum Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 7), "Paladinium Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 8), "Firium Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 9), "Glacium Ingot");
        LanguageRegistry.addName(new ItemStack(metal, 1, 10), "Foudrium Ingot");
        LanguageRegistry.addName(new ItemStack(slateFlake, 1, 0), "Slate Flake");
        LanguageRegistry.addName(new ItemStack(slateFlake, 1, 1), "Slate Double-flake");
        LanguageRegistry.addName(new ItemStack(salt, 1, 0), "Salt");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 0), "Black Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 1), "Red Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 2), "Green Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 3), "Brown Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 4), "Blue Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 5), "Purple Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 6), "Cyan Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 7), "Light Gray Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 8), "Gray Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 9), "Pink Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 10), "Lime Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 11), "Yellow Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 12), "Light Blue Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 13), "Magenta Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 14), "Orange Chalk");
        LanguageRegistry.addName(new ItemStack(chalk, 1, 15), "White Chalk");
    }
}
