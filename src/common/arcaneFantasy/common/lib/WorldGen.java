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
    public static final int[] ICY_BIOMES = {5, 10, 11, 12, 13, 19};

    public static enum Ore {

        // TODO: More fine-tuning
        CRYSTAL(15, 0, 128, null, 10, 0.2, NON_GEN_LEVELS),
        AMETHYST(7, 0, 16, null, 2, 0.2, NON_GEN_LEVELS),
        COPPER(8, 0, 64, null, 15, 0.2, NON_GEN_LEVELS),
        PYRITE(8, 0, 32, null, 3, 0.2, NON_GEN_LEVELS),
        MAGNEZE(8, 0, 32, null, 3, 0.2, NON_GEN_LEVELS),
        SILVER(8, 0, 32, null, 2, 0.2, NON_GEN_LEVELS),
        MAGILITH(8, 0, 32, null, 3, 0.2, NON_GEN_LEVELS),
        DRAGON(150, 0, 16, null, 1, 0.005, NON_GEN_LEVELS),
        PLATINUM(8, 0, 16, null, 2, 0.2, NON_GEN_LEVELS),
        PALADINIUM(8, 0, 16, null, 3, 0.2, NON_GEN_LEVELS),
        FIRIUM(7, 0, 16, null, 3, 0.04, NON_GEN_LEVELS),
        GLACIUM(7, 0, 16, ICY_BIOMES, 3, 0.04, NON_GEN_LEVELS),
        FOUDRIUM(7, 0, 16, null, 3, 0.04, NON_GEN_LEVELS),
        SLATE(50, 64, 128, null, 20, 0.06, NON_GEN_LEVELS),
        SALT(50, 32, 64, null, 20, 0.09, NON_GEN_LEVELS),
        MARBLE(100, 16, 64, null, 20, 0.04, NON_GEN_LEVELS),
        MAGNETITE(20, 0, 64, null, 20, 0.1, NON_GEN_LEVELS),
        CHALK(50, 32, 64, null, 20, 0.06, NON_GEN_LEVELS);
        public static final Ore[] GEMS = {
            CRYSTAL, AMETHYST
        };
        public static final Ore[] METALS = {
            COPPER, PYRITE, MAGNEZE, SILVER, MAGILITH, DRAGON,
            PLATINUM, PALADINIUM, FIRIUM, GLACIUM, FOUDRIUM
        };
        public static final Ore[] STONES = {
            SLATE, SALT, MARBLE, MAGNETITE, CHALK
        };
        public final int orePerVein;
        public final int minSpawnHeight;
        public final int maxSpawnHeight;
        public final int[] biomes;
        public final int spawnRate;
        public final double spawnChance;
        public final int[] nonGenLevels;

        private Ore(int orePerVein, int minSpawnHeight, int maxSpawnHeight, int[] biomes, int spawnRate, double spawnChance, int[] nonGenLevels) {
            this.orePerVein = orePerVein;
            this.minSpawnHeight = minSpawnHeight;
            this.maxSpawnHeight = maxSpawnHeight;
            this.biomes = biomes;
            this.spawnRate = spawnRate;
            this.spawnChance = spawnChance;
            this.nonGenLevels = nonGenLevels;
        }
    }
}
