/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.lib;

/**
 * Class that stores constants that relate to world generation.
 *
 * @author HMPerson1
 */
@SuppressWarnings("PublicInnerClass")
public class WorldGen {

    // None of our stuff should spawn in the nether or end
    public static final int[] NON_GEN_LEVELS = {1, -1};

    public static enum Ore {

        // TODO: More fine-tuning
        CRYSTAL(20, 0, 128, 10, NON_GEN_LEVELS),
        AMETHYST(8, 0, 16, 2, NON_GEN_LEVELS),
        COPPER(20, 0, 64, 10, NON_GEN_LEVELS),
        PYRITE(20, 0, 32, 10, NON_GEN_LEVELS),
        MAGNEZE(20, 0, 32, 10, NON_GEN_LEVELS),
        SILVER(20, 0, 32, 10, NON_GEN_LEVELS),
        MAGILITH(20, 0, 32, 10, NON_GEN_LEVELS),
        DRAGON(20, 0, 16, 10, NON_GEN_LEVELS),
        PLATINUM(20, 0, 16, 10, NON_GEN_LEVELS),
        PALADINIUM(20, 0, 16, 10, NON_GEN_LEVELS),
        FIRIUM(20, 0, 16, 10, NON_GEN_LEVELS),
        GLACIUM(20, 0, 16, 10, NON_GEN_LEVELS),
        FOUDIUM(20, 0, 16, 10, NON_GEN_LEVELS);
        public static final Ore[] GEMS = {CRYSTAL, AMETHYST};
        public static final Ore[] METALS = {
            COPPER, PYRITE, MAGNEZE, SILVER, MAGILITH, DRAGON,
            PLATINUM, PALADINIUM, FIRIUM, GLACIUM, FOUDIUM};
        public final int orePerVein;
        public final int minSpawnHeight;
        public final int maxSpawnHeight;
        public final int spawnRate;
        public final int[] nonGenLevels;

        private Ore(int orePerVein, int minSpawnHeight, int maxSpawnHeight, int spawnRate, int[] nonGenLevels) {
            this.orePerVein = orePerVein;
            this.minSpawnHeight = minSpawnHeight;
            this.maxSpawnHeight = maxSpawnHeight;
            this.spawnRate = spawnRate;
            this.nonGenLevels = nonGenLevels;
        }
    }
}
