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
        CRYSTAL(20, 0, 128, 10, 1, NON_GEN_LEVELS),
        AMETHYST(8, 0, 16, 2, 1, NON_GEN_LEVELS),
        COPPER(8, 0, 64, 15, 1, NON_GEN_LEVELS),
        PYRITE(8, 0, 32, 5, 1, NON_GEN_LEVELS),
        MAGNEZE(8, 0, 32, 3, 1, NON_GEN_LEVELS),
        SILVER(8, 0, 32, 3, 1, NON_GEN_LEVELS),
        MAGILITH(8, 0, 32, 3, 1, NON_GEN_LEVELS),
        DRAGON(50, 0, 16, 1, 0.05, NON_GEN_LEVELS),
        PLATINUM(8, 0, 16, 3, 1, NON_GEN_LEVELS),
        PALADINIUM(8, 0, 16, 3, 1, NON_GEN_LEVELS),
        FIRIUM(8, 0, 16, 3, 0.2, NON_GEN_LEVELS),
        GLACIUM(8, 0, 16, 3, 0.2, NON_GEN_LEVELS),
        FOUDIUM(8, 0, 16, 3, 0.2, NON_GEN_LEVELS),
        SLATE(50, 64, 128, 20, 0.3, NON_GEN_LEVELS),
        SALT(50, 32, 64, 20, 0.45, NON_GEN_LEVELS),
        MARBLE(100, 16, 64, 20, 0.2, NON_GEN_LEVELS),
        MAGNETITE(20, 0, 64, 20, 0.5, NON_GEN_LEVELS),
        CHALK(50, 32, 64, 20, 0.3, NON_GEN_LEVELS);
        public static final Ore[] GEMS = {
            CRYSTAL, AMETHYST
        };
        public static final Ore[] METALS = {
            COPPER, PYRITE, MAGNEZE, SILVER, MAGILITH, DRAGON,
            PLATINUM, PALADINIUM, FIRIUM, GLACIUM, FOUDIUM
        };
        public static final Ore[] STONES = {
            SLATE, SALT, MARBLE, MAGNETITE, CHALK
        };
        public final int orePerVein;
        public final int minSpawnHeight;
        public final int maxSpawnHeight;
        public final int spawnRate;
        public final double spawnChance;
        public final int[] nonGenLevels;

        private Ore(int orePerVein, int minSpawnHeight, int maxSpawnHeight, int spawnRate, double spawnChance, int[] nonGenLevels) {
            this.orePerVein = orePerVein;
            this.minSpawnHeight = minSpawnHeight;
            this.maxSpawnHeight = maxSpawnHeight;
            this.spawnRate = spawnRate;
            this.spawnChance = spawnChance;
            this.nonGenLevels = nonGenLevels;
        }
    }
}
