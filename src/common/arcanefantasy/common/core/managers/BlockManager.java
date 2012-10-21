/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.core.managers;

import arcanefantasy.common.block.BlockAFOreGem;
import arcanefantasy.common.block.BlockAFOreMetal;
import arcanefantasy.common.block.BlockAFStone;
import arcanefantasy.common.block.ItemDamageValuedBlock;
import arcanefantasy.common.core.managers.ItemManager;
import arcanefantasy.common.item.ItemAFGem;
import arcanefantasy.common.item.ItemAFMetal;
import arcanefantasy.common.lib.WorldGen.Ore;
import arcanefantasy.common.lib.WorldGeneratorDelegate;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.src.Block;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.ItemStack;
import net.minecraft.src.WorldGenMinable;

import net.minecraftforge.common.MinecraftForge;

import static arcanefantasy.common.lib.BlockIds.*;


/**
 * DOCUMENT ME!
 *
 * @author  HMPerson1
 */
@SuppressWarnings("PublicField" /* NOI18N */)
public class BlockManager {

    /* Block name constants */
    public static final String NAME_AF_STONE  = "afStone"  /* NOI18N */;
    public static final String NAME_ORE_METAL = "oreMetal" /* NOI18N */;
    public static final String NAME_ORE_GEM   = "oreGem"   /* NOI18N */;

    /* Block instances */
    public static Block oreGem;
    public static Block oreMetal;
    public static Block stone;

    private BlockManager() { }

    /**
     * Registers blocks and their natural spawns.
     */
    public static void init() {
//J-
        // add blocks
        oreGem   = new BlockAFOreGem(BLOCK_ORE_GEM, 0)
                .setStepSound(Block.soundStoneFootstep)
                .setHardness(3)
                .setResistance(5)
                .setBlockName(NAME_ORE_GEM);
        oreMetal = new BlockAFOreMetal(BLOCK_ORE_METAL, 2)
                .setStepSound(Block.soundStoneFootstep)
                .setHardness(3)
                .setResistance(5)
                .setBlockName(NAME_ORE_METAL);
        stone    = new BlockAFStone(BLOCK_STONE, 16)
                .setStepSound(Block.soundStoneFootstep)
                .setHardness(3)
                .setResistance(5)
                .setBlockName(NAME_AF_STONE);
//J+
        MinecraftForge.setBlockHarvestLevel(oreGem, "pickaxe" /* NOI18N */, 3); // diamond pick
        MinecraftForge.setBlockHarvestLevel(oreMetal, "pickaxe" /* NOI18N */, 2); // iron
        MinecraftForge.setBlockHarvestLevel(stone, "pickaxe" /* NOI18N */, 1); // stone

        // register the blocks so the game will recognize them
        GameRegistry.registerBlock(oreGem, ItemDamageValuedBlock.class);
        GameRegistry.registerBlock(oreMetal, ItemDamageValuedBlock.class);
        GameRegistry.registerBlock(stone, ItemDamageValuedBlock.class);

        // add ALL the names
        // TODO: I18N
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
     * Registers ore generators for world gen.
     */
    private static void registerGen() {
        int i = 0;

        for (final Ore ore : Ore.GEMS) {
            GameRegistry.registerWorldGenerator(
                createGenerator(oreGem.blockID, i, ore));
            ++i;
        }

        i = 0;

        for (final Ore ore : Ore.METALS) {
            GameRegistry.registerWorldGenerator(
                createGenerator(oreMetal.blockID, i, ore));
            ++i;
        }

        i = 0;

        for (final Ore ore : Ore.STONES) {
            GameRegistry.registerWorldGenerator(
                createGenerator(stone.blockID, i, ore));
            ++i;
        }
    }

    /**
     * Helper for making a IWorldGenerator.
     *
     * @param   id    block id to generate
     * @param   meta  block metadata to generate
     * @param   ore   the Ore that will be generated
     *
     * @return  a IWorldGenerator to the specified specifications
     */
    private static IWorldGenerator createGenerator(final int id, final int meta, final Ore ore) {
        return new WorldGeneratorDelegate(
                new WorldGenMinable(id, meta, ore.orePerVein),
                ore.minSpawnHeight,
                ore.maxSpawnHeight,
                ore.biomes,
                ore.spawnRate,
                ore.spawnChance,
                ore.nonGenLevels);
    }
}
