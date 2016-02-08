package udp.helper;

/**
 * This class contains the
 */
public class Constants {

    //----------- LOG FILE CONSTANTS ------------------
    // These paths are appended to the current user home directory
    public final static String JSON_FILE_PATH = "/Desktop/Arduino/messages.json";
    public final static String TXT_LOG_FILE_PATH = "/Desktop/Arduino/log.txt";

    //----------- FileWriter CONSTANTS ---------------
    public static final boolean APPEND_TEXT = true;
    public static final boolean OVERWRITE_TEXT = false;

    // ---------- SERVER CONSTANTS --------------------
    public static final int SERVER_PORT;

    // ---------  SENSOR GENERAL STATES ---------------
    public static final int SENSOR_ON;
    public static final int SENSOR_OFF;

    // ---------- INITIALISATION BLOCK ----------------
    static {
        SENSOR_ON    = 1;
        SENSOR_OFF   = 0;
        SERVER_PORT  = 9876;
    }

}
