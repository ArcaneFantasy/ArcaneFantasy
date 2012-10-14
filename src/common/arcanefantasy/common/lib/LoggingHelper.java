/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package arcanefantasy.common.lib;

import cpw.mods.fml.common.FMLLog;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


/**
 * Simplifies FML's logging system.
 *
 * @author  HMPerson1
 */
public class LoggingHelper {

    /**
     * The one and only FML Logger.
     */
    private static final Logger LOGGER = FMLLog.getLogger();

    /**
     * Instance of our helper class.
     */
    private static final PrintWriterToStringHelper PWTSH = new PrintWriterToStringHelper();

    /**
     * Logs a verbose statement. (Level.FINER)
     *
     * @param  format  Format string
     * @param  data    Arguments referenced by the format string
     */
    public static void v(String format, Object... data) {
        LOGGER.log(createLR(Level.FINER, String.format(format, data)));
    }

    /**
     * Logs a debug statement. (Level.FINE)
     *
     * @param  format  Format string
     * @param  data    Arguments referenced by the format string
     */
    public static void d(String format, Object... data) {
        LOGGER.log(createLR(Level.FINE, String.format(format, data)));
    }

    /**
     * Logs an informational statement. (Level.INFO)
     *
     * @param  format  Format string
     * @param  data    Arguments referenced by the format string
     */
    public static void i(String format, Object... data) {
        LOGGER.log(createLR(Level.INFO, String.format(format, data)));
    }

    /**
     * Logs an informational statement. (Level.INFO)
     *
     * @param  t  The {@code Throwable} to log
     */
    public static void i(Throwable t) {
        t.printStackTrace(PWTSH);
        LOGGER.log(createLR(Level.INFO, PWTSH.getString()));
    }

    /**
     * Logs a warning. (Level.WARNING)
     *
     * @param  format  Format string
     * @param  data    Arguments referenced by the format string
     */
    public static void w(String format, Object... data) {
        LOGGER.log(createLR(Level.WARNING, String.format(format, data)));
    }

    /**
     * Logs a warning. (Level.WARNING)
     *
     * @param  t  The {@code Throwable} to log
     */
    public static void w(Throwable t) {
        t.printStackTrace(PWTSH);
        LOGGER.log(createLR(Level.WARNING, PWTSH.getString()));
    }

    /**
     * Logs an error. (Level.SEVERE)
     *
     * @param  format  Format string
     * @param  data    Arguments referenced by the format string
     */
    public static void e(String format, Object... data) {
        LOGGER.log(createLR(Level.SEVERE, String.format(format, data)));
    }

    /**
     * Logs an error. (Level.SEVERE)
     *
     * @param  t  The {@code Throwable} to log
     */
    public static void e(Throwable t) {
        t.printStackTrace(PWTSH);
        LOGGER.log(createLR(Level.SEVERE, PWTSH.getString()));
    }

    /**
     * Creates a new LogRecord with the specified parameters.
     *
     * @param   level  A logging level value
     * @param   msg    The raw non-localized logging message
     *
     * @return  The newly constructed LogRecord
     */
    private static LogRecord createLR(Level level, String msg) {
        LogRecord ret = new LogRecord(level, msg);
        ret.setLoggerName(Reference.LOGGER_NAME);

        return ret;
    }

    //<editor-fold defaultstate="collapsed" desc="Way overy-complicated and exceptionally long helper class(s)">
    /**
     * Helper for getting a {@code Throwable} to write it's stack trace to a
     * string.
     */
    private static class PrintWriterToStringHelper extends PrintWriter {

        /**
         * Instance of our helper class.
         */
        private PWTSHHelper pwtshHelper;

        /**
         * Creates a new helper.
         */
        public PrintWriterToStringHelper() {
            super(new PWTSHHelper());
            pwtshHelper = (PWTSHHelper) super.out;
        }

        /**
         * Returns the concatenation of successive calls to print().
         *
         * @return  The concatenation of successive calls to print()
         */
        public String getString() {
            return pwtshHelper.getString();
        }

        /**
         * Clears the internal buffer.
         */
        public void clear() {
            pwtshHelper.clear();
        }

        /**
         * Helper for {@code PrintWriterToSringHelper}.
         */
        // Helper-class-ception FTW!
        private static class PWTSHHelper extends Writer {

            /**
             * Our buffer.
             */
            private StringBuilder strBuilder = new StringBuilder();

            /**
             * {@inheritDoc}
             *
             * @param   chars {@inheritDoc}
             * @param   i {@inheritDoc}
             * @param   i1 {@inheritDoc}
             *
             * @throws  IOException {@inheritDoc}
             */
            @Override
            public void write(char[] chars, int i, int i1) throws IOException {
                strBuilder.append(chars, i, i1);
            }

            /**
             * {@inheritDoc}
             *
             * @throws  IOException {@inheritDoc}
             */
            @Override
            public void flush() throws IOException {
            }

            /**
             * {@inheritDoc}
             *
             * @throws  IOException {@inheritDoc}
             */
            @Override
            public void close() throws IOException {
            }

            /**
             * Returns the concatenation of all successive calls to write().
             *
             * @return  The concatenation of all successive calls to write()
             */
            public String getString() {
                return strBuilder.toString();
            }

            /**
             * Clears the buffer all Strings were stored in.
             */
            public void clear() {
                strBuilder.replace(0, strBuilder.capacity(), "" /* NOI18N */);
            }
            /*
             * Yo dawg, I heard you liked helpers, so we put a helper in your
             * helper in your helper so it could help you help your helping!
             */
        }
    }
    //</editor-fold>
}
