package udp.server;

import udp.helper.TimeHelper;
import udp.io.JsonService;
import udp.protocol.Message;

import java.io.IOException;

public class Application {


    public static void main(String[] args) throws Exception {

        try {
            Server udpServer = Server.getInstance();
            JsonService jsonService = JsonService.getInstance();
            System.out.println("Server Started...OK");
            while(true){
                Message receivedMessage = udpServer.receiveData();
                if(receivedMessage != null){
                    System.out.println("Received Message: " + receivedMessage.toString());
                    if (jsonService != null) {
                        jsonService.writeToJson(receivedMessage);
//                        System.out.println(TimeHelper.getCurrentTime() + ": OK -> The message has been written to json file");
                    } else {
//                        System.out.println(TimeHelper.getCurrentTime() + ": ERROR -> There was an error writing to log file");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(TimeHelper.getCurrentTime() + ": ERROR (Application.java) " + ex.getMessage());

        }

        }

} // END OF CLASS
