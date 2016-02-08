package udp.io;

import com.google.gson.JsonObject;
import udp.helper.Constants;
import udp.helper.FileHelper;
import udp.helper.TimeHelper;
import udp.protocol.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles the operation of recording all the received messages
 * to a JSON file. This file is used for mapping the received
 * messages information to the <code>Message</code> object itself.
 */
public class JsonService implements Recordable {



    private static JsonService instance;

    private String     filePath;
    private File       jsonFile;
    private FileWriter fileWriter;



    // --------------- GETTERS & SETTERS ---------------

    public String getFilePath() { return filePath; }

    public void setFilePath(String filePath) { this.filePath = filePath; }

    public File getJsonFile() { return jsonFile; }

    public void setJsonFile(File jsonFile) {  this.jsonFile = jsonFile;  }

    //----------------- INITIALISATION ------------------
    /**
     * CONSTRUCTOR
     * @param jsonFilePath String
     */
    private JsonService(String jsonFilePath) throws IOException{

        this.setFilePath(FileHelper.parseFilePath(jsonFilePath));
        this.setJsonFile(new File(this.getFilePath()));

    }

    /**
     * SINGLETON METHOD
     * @return JsonService
     * @throws IOException
     */
    public static JsonService getInstance(){
        try {
            if(instance == null) { instance = new JsonService(Constants.JSON_FILE_PATH);}
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
    public String readFromFile(String filePath) {
        //TODO - implement JSON reading
        return null;
    }

    /**
     * Writes the JSON to file
     * @param message Message
     * @return boolean <code>true</code> - success;
     *                 <code>false</code> - failure
     */
    public boolean writeToFile(String message){
        try {

            this.fileWriter = new FileWriter(filePath, Constants.APPEND_TEXT);
            fileWriter.write(message);
            fileWriter.flush();
            fileWriter.close();
            return true;

        } catch (IOException exception) {

            return false;
        }
    }

    /**
     * Appends a message to the existing JSON log file
     * @param message String
     * @return <code>true</code> in case of success;
     *         <code>false</code> in case of error
     */
    public boolean writeToJson(Message message){

        try {
            JsonObject object = new JsonObject();
            this.fileWriter = new FileWriter(this.getJsonFile(),Constants.APPEND_TEXT);
            object.addProperty("time:", TimeHelper.getCurrentTime());
            object.addProperty("lightSensor: ", (message.getLightSensorVal() == Constants.SENSOR_OFF ? "off" : "on"));
            object.addProperty("pirSensor: ",(message.getPirSensorVal() == false ? "off" : "on"));
            fileWriter.write(object.toString());
            fileWriter.flush();
            fileWriter.close();
            return true;

        } catch (IOException exception) {

            return false;
        }

    }

}
