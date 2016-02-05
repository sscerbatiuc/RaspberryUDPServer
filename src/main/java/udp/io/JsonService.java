package udp.io;

import com.google.gson.JsonObject;
import udp.helper.Constants;
import udp.helper.TimeHelper;
import udp.protocol.Message;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles I/O operations for a JSON file
 */
public class JsonService implements Recordable {

    private static JsonService instance;
    private String filePath;
    public static final boolean APPEND_TEXT = true;

    private JsonObject object;
    private FileWriter fileWriter;



    // --------------- GETTERS & SETTERS ---------------

    public JsonObject getObject() {
        return object;
    }

    public void setObject(JsonObject object) {
        this.object = object;
    }

    //----------------- INITIALISATION ------------------
    /**
     * CONSTRUCTOR
     * @param jsonFilePath String
     */
    private JsonService(String jsonFilePath) throws IOException{
        this.filePath = jsonFilePath;

    }

    /**
     * SINGLETON METHOD
     * @return
     * @throws IOException
     */
    public static JsonService getInstance(){
        try {
            if(instance == null) { instance = new JsonService(Constants.LOCAL_JSON_LOG_FILE_PATH);}
            return instance;
        } catch (IOException ex) {

            return null;
        }
    }
    //------------------------------------------------------

    /**
     * Retrieves the content of the JSON log file
     * @param filePath
     * @return
     */
    public String readFromJson(String filePath) {
        //TODO - implement JSON reading
        return null;
    }

    /**
     * Writes the JSON to file
     * @param message Message
     * @return boolean <code>true</code> - success;
     *                 <code>false</code> - failure
     */
    public boolean writeToJson(Message message){

        try {
            //TODO - test object instantiation
            object = new JsonObject();
            this.fileWriter = new FileWriter(filePath, APPEND_TEXT);
            object.addProperty("time:", TimeHelper.getCurrentTime());
            object.addProperty("lightSensor: ", (message.getLightSensor() == Constants.SENSOR_OFF ? "off" : "on"));
            object.addProperty("pirSensor: ",(message.getPirSensorVal() == Constants.SENSOR_OFF ? "off" : "on"));
            fileWriter.write(object.toString());
            fileWriter.flush();
            fileWriter.close();
            return true;

        } catch (IOException exception) {

            return false;
        }
    }
}
