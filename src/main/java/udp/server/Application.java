package udp.server;

import udp.helper.TimeHelper;
import udp.io.JsonService;
import udp.io.LoggerService;
import udp.protocol.Message;

import java.io.IOException;

public class Application {


    public static void main(String[] args) throws Exception {

        try {
            Server udpServer = Server.getInstance();
            JsonService jsonService = JsonService.getInstance();
            LoggerService loggerService = LoggerService.getInstance();
            System.out.println(TimeHelper.getCurrentTime() + ": Server Started...OK");
            loggerService.writeToFile("\n" + TimeHelper.getCurrentTime() + ": OK -> SERVER STARTED SUCCESSFULLY \n");
            while(true){
                String receivedMessage = udpServer.receiveString();
                if(receivedMessage != null){
                    System.out.println(TimeHelper.getCurrentTime() + ": Received Message -> " + receivedMessage.toString());
                    if (loggerService != null) {
                        loggerService.writeToFile(receivedMessage + "\n");
                        jsonService.writeToJson(Message.parse(receivedMessage));
                    } else {
                        System.out.println(TimeHelper.getCurrentTime() + ": ERROR -> There was an error writing to log file");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(TimeHelper.getCurrentTime() + ": ERROR (Application.java) " + ex.getMessage());
        }
        }

} // END OF CLASS
