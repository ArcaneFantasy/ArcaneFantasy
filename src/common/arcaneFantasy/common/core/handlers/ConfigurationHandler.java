/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arcaneFantasy.common.core.handlers;

import java.io.*;

/**
 * Loads config file.
 *
 * @author HMPerson1
 */
public class ConfigurationHandler {

    /**
     * Initialize the handler with the config file.
     *
     * @param configFile
     */
    public static void init(File configFile) {
        BufferedInputStream in = null;
        try {
            // Make sure that there's actually a file there 
            // before we try to read it
            configFile.createNewFile();

            // configFile *WILL* exist by now; 
            // createNewFile() would have thrown an IOException had it failed
            if (configFile.canRead()) { // Make sure we are permitted to read this
                in = new BufferedInputStream(new FileInputStream(configFile));
            } else {
                // TODO: Log this
            }

            // TODO: How should we store this info?
            // java.util.Properties? java.util.HashMap?
        } catch (IOException ex) {
            // TODO: Log this
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    // TODO: Log this
                }
            }
        }
        
        
        // If we're down here, use the default (hard-coded?) properties 
    }
}
