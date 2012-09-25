/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.core.handlers;

import net.minecraftforge.common.Configuration;

import java.io.*;

/**
 * Loads config file.
 *
 * @author HMPerson1
 */
public class ConfigurationHandler {

    /**
     * The standard Forge config implementation.
     */
    private static Configuration config;

    /**
     * Initialize the handler with the config file.
     *
     * @param configFile
     */
    public static void init(File configFile) {
        config = new Configuration(configFile);
        config.load();
    }
}
