/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.block;

import net.minecraft.src.Block;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.ItemStack;
import net.minecraft.src.WorldGenMinable;

import arcaneFantasy.common.item.ItemManager;
import static arcaneFantasy.common.lib.BlockIds.*;
import arcaneFantasy.common.lib.WorldGen;
import arcaneFantasy.common.lib.WorldGen.Ore.Gem.Amethyst;
import arcaneFantasy.common.lib.WorldGen.Ore.Gem.Crystal;
import arcaneFantasy.common.lib.WorldGeneratorDelegate;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 *
 * @author HMPerson1
 */
@SuppressWarnings("PublicField")
public class BlockManager {

    public static Block oreGem;

    /**
     * Registers blocks and their natural spawns.
     */
    public static void init() {
        oreGem = new BlockModOreGem(BLOCK_ORE_GEM, 0).setHardness(3).setResistance(5)
                .setStepSound(Block.soundStoneFootstep).setBlockName("oreGem");

        GameRegistry.registerBlock(oreGem, ItemDamageValuedBlock.class);

        LanguageRegistry.addName(new ItemStack(oreGem, 1, 0), "Crystal Ore");
        LanguageRegistry.addName(new ItemStack(oreGem, 1, 1), "Amethyst Ore");

        registerGen();
    }

    /**
     * Registers block recipes.
     */
    public static void initRecipes() {
        FurnaceRecipes recipes = FurnaceRecipes.smelting();
        recipes.addSmelting(oreGem.blockID, 0, new ItemStack(ItemManager.gem, 1, 0));
        recipes.addSmelting(oreGem.blockID, 1, new ItemStack(ItemManager.gem, 1, 1));
    }

    /**
     * Registers ore generators for world gen.
     */
    private static void registerGen() {
        GameRegistry.registerWorldGenerator(createGenerator(
                oreGem.blockID, 0, Crystal.ORE_PER_VEIN,
                Crystal.MIN_SPAWN_HEIGHT, Crystal.MAX_SPAWN_HEIGHT,
                Crystal.SPAWN_RATE, WorldGen.Ore.NON_GEN_LEVELS));
        GameRegistry.registerWorldGenerator(createGenerator(
                oreGem.blockID, 1, Amethyst.ORE_PER_VEIN,
                Amethyst.MIN_SPAWN_HEIGHT, Amethyst.MAX_SPAWN_HEIGHT,
                Amethyst.SPAWN_RATE, WorldGen.Ore.NON_GEN_LEVELS));
    }

    /**
     * Helper for making a IWorldGenerator.
     *
     * @param id block id to generate
     * @param meta block metadata to generate
     * @param veinSize size of the vein to generate
     * @param yMin minimum y level to generate
     * @param yMax maximum y level to generate
     * @param freq how many times the generator should attempt to generate
     * @param levels level to NOT generate
     * @return a IWorldGenerator to the specified specifications
     */
    private static IWorldGenerator createGenerator(int id, int meta, int veinSize,
                                                   int yMin, int yMax, int freq,
                                                   int... levels) {
        return new WorldGeneratorDelegate(
                new WorldGenMinable(id, meta, veinSize), yMin, yMax, freq, levels);
    }
}
