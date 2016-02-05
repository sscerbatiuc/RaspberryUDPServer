package udp.io;

import udp.protocol.Message;

/**
 * Created by stas on 2/5/16.
 */
public interface Recordable {

    public String readFromJson(String filePath);
    public boolean writeToJson(Message msg);

}
