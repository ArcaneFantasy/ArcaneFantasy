/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.lib;

import com.google.common.base.Predicate;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

import java.util.*;

import arcaneFantasy.common.entity.mob.EntityRapace;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * Helper for delegating an IWorldGenerator to a WorldGenerator.
 *
 * @author HMPerson1
 */
public class WorldGeneratorDelegate implements IWorldGenerator {

    /**
     * The generator to delegate to.
     */
    private final WorldGenerator generator;
    /**
     * The levels that this generator should NOT generate things in. <br />
     * (i.e. ores shouldn't generate in the Nether)
     */
    private final int[] nonGenLevels;
    /**
     * The Predicate for determining if a given biome is eligible.
     */
    private final Predicate<? super BiomeGenBase> biomes;
    /**
     * Minimum y level to gen.
     */
    private final int yMin;
    /**
     * Maximum y level to gen.
     */
    private final int yMax;
    /**
     * How frequent we should try to gen.
     */
    private final int freq;
    /**
     * The chance that a ore will generate per chunk.
     */
    private final double spawnChance;

    /**
     *
     *
     * @param gen the world generator to delegate calls to
     * @param yMin the minimum y-coordinate to generate in
     * @param yMax the maximum y-coordinate to generate in
     * @param biomes the predicate determining which biomes to generate in
     * @param freq the number of attempts made for the block to generate in
     * @param chance the chance that a given chunk will be generated in
     * @param levels the levels that this should NOT generate in
     */
    public WorldGeneratorDelegate(WorldGenerator gen, int yMin, int yMax, Predicate<? super BiomeGenBase> biomes, int freq, double chance, int... levels) {
        generator = gen;
        nonGenLevels = levels;
        this.yMin = yMin;
        this.yMax = yMax;
        this.biomes = biomes;
        this.freq = freq;
        this.spawnChance = chance;
    }

    // This will be called HUNDREDS of times so it needs to be very, very fast.
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        // iterate through every element to see if any of them are the same
        // as the one we're in 
        for (int level : nonGenLevels) {
            if (world.provider.worldType == level) {
                // don't do anything if we're generating in a dimention
                // that we shouldn't generate in (i.e. nether)
                return;
            }
        }

        // random test:
        if (random.nextDouble() > spawnChance) {
            // must pass the random test before generating
            return;
        }
        // do the biome check last, as its the most computationally expensive
        if (!checkBiomes(world, chunkX, chunkZ, biomes)) {
            return;
        }

        // cache coords
        final int x = chunkX * 16;
        final int z = chunkZ * 16;
        // ONLY after all that, can we begin to generate the actual ore veins
        for (int i = 0; i < freq; i++) {
            generator.generate(world, random,
                               x + random.nextInt(16),
                               yMin + random.nextInt(yMax - yMin),
                               z + random.nextInt(16));

        }
        EntityRapace entityRapace = new EntityRapace(world);
        entityRapace.setPosition(x, 100, z);
        world.spawnEntityInWorld(entityRapace);
    }

    /**
     * Checks whether this chunk has the biomes required by the ore.
     *
     * @param world the world we're generating for
     * @param chunkX the chunk-x that we're generating for
     * @param chunkZ the chunk-y that we're generating for
     * @param biomes the biome predicate
     * @return whether or not to generate in this chunk
     */
    private static boolean checkBiomes(World world, int chunkX, int chunkZ, Predicate<? super BiomeGenBase> biomes) {
        byte[] biomeArr = world.getChunkFromChunkCoords(chunkX, chunkZ).getBiomeArray();
        for (byte b : biomeArr) {
            if (biomes.apply(BiomeGenBase.biomeList[b])) {
                // if just one matches, the whole chunk is eligible
                return true;
            }
        }
        // if none match, return false
        return false;
    }
}
