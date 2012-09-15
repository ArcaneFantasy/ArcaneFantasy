/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.lib;

import com.google.common.collect.Sets;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

import java.util.*;

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
     * The list of biomes to generate in. (Or {@code null} for all biomes)
     */
    private final Set<Integer> biomes;
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
     * @param biomes the value of biomes
     * @param freq the number of attempts made for the block to generate in
     * @param chance the chance that a given chunk will be generated in
     * @param levels the levels that this should NOT generate in
     */
    public WorldGeneratorDelegate(WorldGenerator gen, int yMin, int yMax, int[] biomes, int freq, double chance, int... levels) {
        generator = gen;
        nonGenLevels = levels;
        this.yMin = yMin;
        this.yMax = yMax;
        this.freq = freq;
        this.spawnChance = chance;

        if (biomes != null) {
            // null means ignore biomes

            Set<Integer> tmp = new HashSet<Integer>();

            // add all the ints to the Set (boxing done automatically)
            tmp.addAll(Ints.asList(biomes));
            // make it unmodifiable and assign it
            this.biomes = Collections.unmodifiableSet(tmp);
        } else {
            this.biomes = null;
        }
    }

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
    }
    /**
     * A mutable Set for random temporary calculations.
     */
    // We do this so we don't have to make many, many temporary calulations.
    private static final HashSet<Integer> scratchSet = new HashSet<Integer>(4);

    /**
     * Checks whether this chunk has the biomes required by the ore.
     *
     * @param world the world we're generating for
     * @param chunkX the chunk-x that we're generating for
     * @param chunkZ the chunk-y that we're generating for
     * @param biomes the biomes allowed to be generated in
     * @return whether or not to generate in this chunk
     */
    private static boolean checkBiomes(World world, int chunkX, int chunkZ, Set<Integer> biomes) {
        if (biomes != null) {
            // null means ignore biomes

            // get all the biomes
            byte[] tmp = world.getChunkFromChunkCoords(chunkX, chunkZ).getBiomeArray();

            // clear our scratch set
            scratchSet.clear();

            // add all the elements from the array (and box the bytes)
            scratchSet.addAll(Ints.asList(byteArrToIntArr(tmp)));

            // now check if there are biomes in common
            if (Sets.intersection(scratchSet, biomes).isEmpty()) {
                // if there are no biomes in common between the two arrays
                return false;
            }
        }
        // oterwise do generate
        return true;
    }

    /**
     * Converts a byte array to an int array.
     *
     * @param arr a byte array
     * @return an int array with identically indexed identical values
     */
    // regular for loop with cached length was tested to be the fastest
    private static int[] byteArrToIntArr(byte[] arr) {
        int length = arr.length;
        int[] ret = new int[length];
        for (int i = 0; i < length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
