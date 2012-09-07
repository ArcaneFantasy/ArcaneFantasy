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

    public static class Ore {

        // None of our ores should spawn in the nether or end
        public static final int[] NON_GEN_LEVELS = {1, -1};

        public static class Gem {

            public static class Crystal {

                public static final int MAX_SPAWN_HEIGHT = 128;
                public static final int MIN_SPAWN_HEIGHT = 0;
                public static final int ORE_PER_VEIN = 20;
                public static final int SPAWN_RATE = 10;
            }

            public static class Amethyst {

                public static final int MAX_SPAWN_HEIGHT = 16;
                public static final int MIN_SPAWN_HEIGHT = 0;
                public static final int ORE_PER_VEIN = 8;
                public static final int SPAWN_RATE = 2;
            }
        }
    }
}
