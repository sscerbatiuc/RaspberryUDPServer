package udp.helper;

/**
 * Created by stas on 2/5/16.
 */
public class Constants {

    //----------- LOG FILE CONSTANTS ------------------
    public final static String LOCAL_JSON_LOG_FILE_PATH = "/home/pi/log.json";

    // ---------- SERVER CONSTANTS --------------------
    public static final int SERVER_PORT;

    // ---------  SENSOR GENERAL STATES ---------------
    public static final int SENSOR_ON;
    public static final int SENSOR_OFF;

    // ---------- INITIALISATION BLOCK ----------------
    static {
        SENSOR_ON    = 1;
        SENSOR_OFF   = 0;
        SERVER_PORT      = 9876;
    }

}
