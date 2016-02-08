package udp.io;

import udp.helper.Constants;
import udp.helper.FileHelper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Logs all the information that is being generated
 */
public class LoggerService implements Recordable {

    private File   logFile;
    private String logFilePath;

    private static LoggerService instance;

    /**
     * CONSTRUCTOR
     */
    private LoggerService(String filePath) throws IOException{

        this.setLogFilePath(FileHelper.parseFilePath(filePath));
        this.setLogFile(new File(this.getLogFilePath()));

    }

    /**
     * Singleton method: makes sure there is only one instance
     * of the current class and creates it if necessary.
     * @return LoggerService
     */
    public static LoggerService getInstance() throws  IOException{
        if(instance == null){
            instance = new LoggerService(Constants.TXT_LOG_FILE_PATH);
        }
        return  instance;
    }


    //-------------- GETTERS & SETTERS ----------------------

    public File getLogFile() { return logFile; }

    public void setLogFile(File logFile) { this.logFile = logFile; }

    public String getLogFilePath() { return logFilePath;  }

    public void setLogFilePath(String logFilePath) { this.logFilePath = logFilePath; }


    //-------------------------------------------------------

    public String readFromFile(String filePath) {
        //TODO - implement reading from text log file
        return null;
    }

    /**
     * Writes the specified message to the log <code>File</code>
     * @param msg
     * @return
     */
    public boolean writeToFile(String msg) {

        try{
            FileWriter logFileWriter = new FileWriter(this.getLogFile(), Constants.APPEND_TEXT);
            logFileWriter.write(msg.toString());
            logFileWriter.flush();
            logFileWriter.close();
            return true;

        } catch(IOException ex){
            System.out.println("Couldn't write to text log file");
        }
        return false;

    }
}
