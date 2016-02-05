package udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import udp.protocol.Message;
import udp.helper.*;

public class Server {

    private static Server instance;

    private DatagramSocket serverSocket;
    private byte[] receivedData;
    private byte[] responseData;

    // --------------- GETTERS & SETTERS ---------------

    public static void setInstance(Server instance) {
        Server.instance = instance;
    }

    public DatagramSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(DatagramSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public byte[] getReceivedData() {
        return receivedData;
    }

    public void setReceivedData(byte[] receivedData) {
        this.receivedData = receivedData;
    }

    public byte[] getResponseData() {
        return responseData;
    }

    public void setResponseData(byte[] responseData) {
        this.responseData = responseData;
    }

    // -------------------------------------------
    /**
     * CONSTRUCTOR
     */
    private Server() throws SocketException {

        System.out.println("Server Constructor");
            serverSocket = new DatagramSocket(Constants.SERVER_PORT);
            receivedData = new byte[100];
            responseData = new byte[100];

    }

    /**
     * Returns a single instance of UDP Server
     * @return Server
     */
    public static Server getInstance() throws SocketException {
        if(instance == null){
            instance = new Server();
            return  instance;
        } else {
            return instance;
        }
    }

    /**
     * Receives the data <code>DatagramPacket</code> from the client
     * and extracts the textual representation of the data
     * in the packet
     * @return
     */
    public Message receiveData(){
        try {
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            serverSocket.receive(receivedPacket);
            String receivedString = new String(receivedPacket.getData());
            System.out.println("Received data: " + receivedString);
            String[] splitMessage = receivedString.split("|");
            Message receivedMessage = new Message(Integer.parseInt(splitMessage[1]),
                    Integer.parseInt(splitMessage[3]),
                    TimeHelper.getCurrentTime());

            return receivedMessage;

        } catch (IOException ioEx) {
            return null;
        }
    }

    /**
     * Sends the message to a specified client
     * @param message <code>String</code>
     * @param clientAddress <code>InetAddress</code>
     * @param port <code>Integer</code>
     * @return boolean
     */
    public boolean respondToClient(String message, InetAddress clientAddress, int port){
        try {
            responseData = message.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, port);
            serverSocket.send(responsePacket);
            return true;
        } catch (SocketException sockEx){
            return false;

        } catch (IOException ioEx) {
            return false;
        }

    }

}
