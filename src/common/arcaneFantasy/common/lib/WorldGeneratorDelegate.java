/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.lib;

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
     * @param freq the number of attempts made for the block to generate in
     * @param chance the chance that a given chunk will be generated in
     * @param levels the levels that this should NOT generate in
     */
    public WorldGeneratorDelegate(WorldGenerator gen, int yMin, int yMax, int freq, double chance, int... levels) {
        generator = gen;
        nonGenLevels = levels;
        this.yMin = yMin;
        this.yMax = yMax;
        this.freq = freq;
        this.spawnChance = chance;

    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (random.nextDouble() > spawnChance) {
            // must pass the random chance test before generating
            return;
        }
        for (int l : nonGenLevels) {
            if (world.provider.worldType == l) {
                // don't do anything if we're generating in a dimention
                // that we shouldn't generate in (i.e. nether)
                return;
            }
        }

        for (int i = 0; i < freq; i++) {
            generator.generate(world, random,
                               (chunkX * 16) + random.nextInt(16),
                               yMin + random.nextInt(yMax - yMin),
                               (chunkZ * 16) + random.nextInt(16));

        }
    }
}
