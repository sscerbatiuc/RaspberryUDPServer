package io;

import org.junit.Test;
import udp.protocol.Message;

import static org.junit.Assert.*;

/**
 * Contains the test methods related to the message
 * being sent from the client to the server
 * @author sscerbatiuc
 */
public class MessageTest {

    /**
     * Tests if the message received from the client is
     * parsed correctly into a <code>Message</code> object
     */
    @Test
    public void parseMessage(){

        String messageString1 = new String("H 0|L 0|P 0");
        String messageString2 = new String("H 0|L 0|P 1");
        String messageString3 = new String("H 0|L 1|P 0");
        String messageString4 = new String("H 1|L 0|P 0");
        String messageString5 = new String("H 1|L 0|P 1");
        String messageString6 = new String("H 1|L 1|P 0");
        String messageString7 = new String("H 1|L 1|P 1");

        Message msg1 = Message.parse(messageString1);
        Message msg2 = Message.parse(messageString2);
        Message msg3 = Message.parse(messageString3);
        Message msg4 = Message.parse(messageString4);
        Message msg5 = Message.parse(messageString5);
        Message msg6 = Message.parse(messageString6);
        Message msg7 = Message.parse(messageString7);

    }
}
