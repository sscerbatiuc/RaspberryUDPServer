package io;

import static org.junit.Assert.*;
import org.junit.Test;
import udp.io.JsonService;


public class JsonServiceTest {

    /**
     * Checks if the assigned file path is a correct one
     */
    @Test
    public void testJsonFilePath(){

        String correctPath = "/home/stas/Desktop/Arduino/messages.io";
        JsonService jsonService = JsonService.getInstance();
        assertEquals(correctPath, jsonService.getFilePath());
    }
}
