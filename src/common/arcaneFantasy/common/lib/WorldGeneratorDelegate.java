/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.lib;

import com.google.common.collect.Sets;
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
     * The list of biomes to generate in (or null for all biomes)
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

            this.biomes = Collections.unmodifiableSet(new HashSet<Integer>());

            // box the ints into Integers
            Integer[] tmp = new Integer[biomes.length];
            System.arraycopy(biomes, 0, tmp, 0, biomes.length);

            // add all the Integers to the Set
            this.biomes.addAll(Arrays.asList(tmp));
        } else {
            this.biomes = null;
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        // random test:
        if (random.nextDouble() > spawnChance) {
            // must pass the random test before generating
            return;
        }
        // iterate through every element to see if any of them are the same
        // as the one we're in 
        for (int level : nonGenLevels) {
            if (world.provider.worldType == level) {
                // don't do anything if we're generating in a dimention
                // that we shouldn't generate in (i.e. nether)
                return;
            }
        }
        // do the biome check last, as its the most computationally expensive
        if (biomes != null) {
            // null means ignore biomes
            // get all the biomes
            byte[] tmp = world.getChunkFromChunkCoords(chunkX, chunkZ).getBiomeArray();

            // box bytes to Integers
            Integer[] tmp2 = new Integer[tmp.length];
            System.arraycopy(tmp, 0, tmp2, 0, tmp.length);

            // most chunks will have at most 3 biomes, so set init capacity to 3
            // resizing is a HUGE performance issue
            Set<Integer> chunkBiomes = new HashSet<Integer>(3);
            // add all the elements from the array
            chunkBiomes.addAll(Arrays.asList(tmp2));

            // FINALLY now check if there are biomes in common
            if (Sets.intersection(biomes, chunkBiomes).isEmpty()) {
                // if there are no biomes in common between the ones in this chunk
                // and the ones we generate in, just skip it
                return;
            }
        }
        // ONLY after all that, can we begin to generate the actual ore veins
        for (int i = 0; i < freq; i++) {
            generator.generate(world, random,
                               (chunkX * 16) + random.nextInt(16),
                               yMin + random.nextInt(yMax - yMin),
                               (chunkZ * 16) + random.nextInt(16));

        }
    }
}
