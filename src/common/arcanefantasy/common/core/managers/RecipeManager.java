/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.core.managers;


import arcanefantasy.common.block.*;
import arcanefantasy.common.item.*;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.src.Block;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ShapedRecipes;

import static arcanefantasy.common.core.managers.BlockManager.*;
import static arcanefantasy.common.core.managers.ItemManager.*;


/**
 * Manages recipes.
 *
 * @author  HMPerson1
 */
public class RecipeManager {
    private RecipeManager() { }

    /**
     * Adds all recipes.
     */
    public static void initRecipes() {
        initSmelting();
        initCrafting();
    }

    private static void initSmelting() {
        final FurnaceRecipes recipes = FurnaceRecipes.smelting();

        for (int i = 0; i < ItemAFGem.GEM_TYPES; ++i) {
            recipes.addSmelting(oreGem.blockID, i,
                                new ItemStack(gem, 1, i));
        }

        for (int i = 0; i < ItemAFMetal.METAL_TYPES; ++i) {
            recipes.addSmelting(oreMetal.blockID, i,
                                new ItemStack(metal, 1, i));
        }
    }

    private static void initCrafting() {

        // slate
        final ItemStack slateFx2 = new ItemStack(slateFlake, 1, 1);

        addShapelessRecipe(slateFx2, slateFlake, slateFlake);

        addRecipe(new ItemStack(stone, 1, 0),
                  new Object[][] {
                { slateFx2, slateFx2, slateFx2 },
                { slateFx2, slateFx2, slateFx2 },
                { slateFx2, slateFx2, slateFx2 }
            });


        // coloring chalk
        for (int i = 0; i < (ItemAFChalk.CHALK_TYPES - 1); i++) {

            // ^^^
            // don't allow bleaching of already white chalk
            addShapelessRecipe(new ItemStack(chalk, 1, i),
                               new ItemStack(Item.dyePowder, 1, i),
                               new ItemStack(chalk, 1, 15));

            addShapelessRecipe(new ItemStack(chalk, 2, i),
                               new ItemStack(Item.dyePowder, 1, i),
                               new ItemStack(chalk, 1, 15),
                               new ItemStack(chalk, 1, 15));
            // you can get 2 colorings for one dye
        }

        // swords
        for (final ItemAFSword sword : swords) {

            final ItemStack material = new ItemStack(
                    sword.toolMaterial.ingot ? metal.shiftedIndex : gem.shiftedIndex,
                    1,
                    sword.toolMaterial.materialMeta);

            addRecipe(new ItemStack(sword),
                      new Object[][] {
                    { material },
                    { material },
                    { Item.stick }
                });
        }
    }

    private static void addRecipe(final ItemStack out, final Object[][] recipe) {
        final int height = recipe.length;
        final int width  = recipe[0].length;

        // make sure the array is rectangular
        for (final Object[] rows : recipe) {

            if (rows.length != width) {
                throw new IllegalArgumentException();
            }

        }

        final ItemStack[] ret = new ItemStack[height * width];

        int i = 0;

        // fill ze array
        for (final Object[] row : recipe) {

            for (final Object element : row) {

                if (element instanceof Item) {
                    ret[i] = new ItemStack((Item) element);
                } else if (element instanceof Block) {
                    ret[i] = new ItemStack((Block) element);
                } else if (element instanceof ItemStack) {
                    ret[i] = (ItemStack) element;
                }

                ++i;
            }
        }

        GameRegistry.addRecipe(new ShapedRecipes(width, height, ret, out));
    }

    private static void addShapelessRecipe(final ItemStack out, final Object... recipe) {
        GameRegistry.addShapelessRecipe(out, recipe);
    }
}
