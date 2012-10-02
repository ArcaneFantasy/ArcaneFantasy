/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcane_fantasy.common.block;

import net.minecraft.src.Block;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.ItemStack;
import net.minecraft.src.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;

import arcane_fantasy.common.item.ItemAFGem;
import arcane_fantasy.common.item.ItemAFMetal;
import arcane_fantasy.common.item.ItemManager;
import static arcane_fantasy.common.lib.BlockIds.*;
import arcane_fantasy.common.lib.WorldGen.Ore;
import arcane_fantasy.common.lib.WorldGeneratorDelegate;
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
    public static Block oreMetal;
    public static Block stone;

    /**
     * Registers blocks and their natural spawns.
     */
    public static void init() {
        // add blocks
        oreGem = new BlockAFOreGem(BLOCK_ORE_GEM, 0).setHardness(3).setResistance(5)
                .setStepSound(Block.soundStoneFootstep).setBlockName("oreGem");
        oreMetal = new BlockAFOreMetal(BLOCK_ORE_METAL, 2).setHardness(3).setResistance(5)
                .setStepSound(Block.soundStoneFootstep).setBlockName("oreMetal");
        stone = new BlockAFStone(BLOCK_STONE, 16).setHardness(3).setResistance(5)
                .setStepSound(Block.soundStoneFootstep).setBlockName("afStone");

        MinecraftForge.setBlockHarvestLevel(oreGem, "pickaxe", 3); // diamond pick
        MinecraftForge.setBlockHarvestLevel(oreMetal, "pickaxe", 2); // iron
        MinecraftForge.setBlockHarvestLevel(stone, "pickaxe", 1); // stone

        // register the blocks so the game will recognize them
        GameRegistry.registerBlock(oreGem, ItemDamageValuedBlock.class);
        GameRegistry.registerBlock(oreMetal, ItemDamageValuedBlock.class);
        GameRegistry.registerBlock(stone, ItemDamageValuedBlock.class);

        // add ALL the names 
        LanguageRegistry.addName(new ItemStack(oreGem, 1, 0), "Quartz Ore");
        LanguageRegistry.addName(new ItemStack(oreGem, 1, 1), "Amethyst Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 0), "Copper Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 1), "Pyrite Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 2), "Magneze Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 3), "Silver Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 4), "Magilith Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 5), "Dragon Bone Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 6), "Platinum Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 7), "Paladinium Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 8), "Firium Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 9), "Glacium Ore");
        LanguageRegistry.addName(new ItemStack(oreMetal, 1, 10), "Foudrium Ore");
        LanguageRegistry.addName(new ItemStack(stone, 1, 0), "Slate");
        LanguageRegistry.addName(new ItemStack(stone, 1, 1), "Salt");
        LanguageRegistry.addName(new ItemStack(stone, 1, 2), "Marble");
        LanguageRegistry.addName(new ItemStack(stone, 1, 3), "Magnitite");
        LanguageRegistry.addName(new ItemStack(stone, 1, 4), "Chalk");

        // register ore generators
        registerGen();
    }

    /**
     * Registers block recipes.
     */
    public static void initRecipes() {
        FurnaceRecipes recipes = FurnaceRecipes.smelting();
        for (int i = 0; i < ItemAFGem.GEM_TYPES; ++i) {
            recipes.addSmelting(oreGem.blockID, i, new ItemStack(ItemManager.gem, 1, i));
        }
        for (int i = 0; i < ItemAFMetal.METAL_TYPES; ++i) {
            recipes.addSmelting(oreMetal.blockID, i, new ItemStack(ItemManager.metal, 1, i));
        }
    }

    /**
     * Registers ore generators for world gen.
     */
    private static void registerGen() {
        int i = 0;
        for (Ore ore : Ore.GEMS) {
            GameRegistry.registerWorldGenerator(
                    createGenerator(oreGem.blockID, i, ore));
            ++i;
        }
        i = 0;
        for (Ore ore : Ore.METALS) {
            GameRegistry.registerWorldGenerator(
                    createGenerator(oreMetal.blockID, i, ore));
            ++i;
        }
        i = 0;
        for (Ore ore : Ore.STONES) {
            GameRegistry.registerWorldGenerator(
                    createGenerator(stone.blockID, i, ore));
            ++i;
        }
    }

    /**
     * Helper for making a IWorldGenerator.
     *
     * @param id block id to generate
     * @param meta block metadata to generate
     * @param ore the Ore that will be generated
     * @return a IWorldGenerator to the specified specifications
     */
    private static IWorldGenerator createGenerator(int id, int meta, Ore ore) {
        return new WorldGeneratorDelegate(
                new WorldGenMinable(id, meta, ore.orePerVein),
                ore.minSpawnHeight, ore.maxSpawnHeight, ore.biomes,
                ore.spawnRate, ore.spawnChance, ore.nonGenLevels);
    }
}
