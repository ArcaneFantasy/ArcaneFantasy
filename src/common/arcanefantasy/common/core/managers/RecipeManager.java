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
    public static void init() {
        initSmelting();
        initCrafting();
    }

    private static void initSmelting() {
        final FurnaceRecipes recipes = FurnaceRecipes.smelting();

        for (int i = 0; i < ItemAFGem.GEM_TYPES; ++i) {
            recipes.addSmelting(oreGem.blockID, i,
                                new ItemStack(gem, 1, i),
                                1.0F);
        }

        for (int i = 0; i < ItemAFMetal.METAL_TYPES; ++i) {
            recipes.addSmelting(oreMetal.blockID, i,
                                new ItemStack(metal, 1, i),
                                0.7F);
        }
    }

    private static void initCrafting() {

        //<editor-fold defaultstate="collapsed" desc="Slate Recipes">
        // slate
        final ItemStack slateFx2 = new ItemStack(slateFlake, 1, 1);

        addShapelessRecipe(slateFx2, slateFlake, slateFlake);

        addRecipe(new ItemStack(stone, 1, 0),
                  new Object[][] {
                { slateFx2, slateFx2, slateFx2 },
                { slateFx2, slateFx2, slateFx2 },
                { slateFx2, slateFx2, slateFx2 }
            });
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Chalk Recipes">
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
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Tool Recipes">
        // axes
        for (final ItemAFAxe axe : axes) {
            final EnumAFToolMaterial tMaterial = axe.getMaterial();
            final ItemStack          material  = new ItemStack(
                    tMaterial.isIngot ? metal.shiftedIndex : gem.shiftedIndex,
                    1,
                    tMaterial.materialMeta);
            addRecipe(new ItemStack(axe),
                      new Object[][] {
                    { material, material },
                    { material, Item.stick },
                    { null, Item.stick }
                });
        }

        // hoes
        for (final ItemAFHoe hoe : hoes) {
            final EnumAFToolMaterial tMaterial = hoe.getMaterial();
            final ItemStack          material  = new ItemStack(
                    tMaterial.isIngot ? metal.shiftedIndex : gem.shiftedIndex,
                    1,
                    tMaterial.materialMeta);
            addRecipe(new ItemStack(hoe),
                      new Object[][] {
                    { material, material },
                    { null, Item.stick },
                    { null, Item.stick }
                });
        }

        // pickaxes
        for (final ItemAFPickaxe pickaxe : pickaxes) {
            final EnumAFToolMaterial tMaterial = pickaxe.getMaterial();
            final ItemStack          material  = new ItemStack(
                    tMaterial.isIngot ? metal.shiftedIndex : gem.shiftedIndex,
                    1,
                    tMaterial.materialMeta);
            addRecipe(new ItemStack(pickaxe),
                      new Object[][] {
                    { material, material, material },
                    { null, Item.stick, null },
                    { null, Item.stick, null }
                });
        }

        // spades
        for (final ItemAFSpade spade : spades) {
            final EnumAFToolMaterial tMaterial = spade.getMaterial();
            final ItemStack          material  = new ItemStack(
                    tMaterial.isIngot ? metal.shiftedIndex : gem.shiftedIndex,
                    1,
                    tMaterial.materialMeta);
            addRecipe(new ItemStack(spade),
                      new Object[][] {
                    { material },
                    { Item.stick },
                    { Item.stick }
                });
        }

        // swords
        for (final ItemAFSword sword : swords) {
            final EnumAFToolMaterial tMaterial = sword.getMaterial();
            final ItemStack          material  = new ItemStack(
                    tMaterial.isIngot ? metal.shiftedIndex : gem.shiftedIndex,
                    1,
                    tMaterial.materialMeta);
            addRecipe(new ItemStack(sword),
                      new Object[][] {
                    { material },
                    { material },
                    { Item.stick }
                });
        }
        //</editor-fold>
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
