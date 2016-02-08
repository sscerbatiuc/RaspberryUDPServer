package udp.protocol;

public class Message {

    private boolean isHardBit;
    private String timeReceived;

    private int lightSensorVal;
    private boolean pirSensorVal;

    // ---------------- GETTERS & SETTERS --------------------

    public void setPirSensorVal(boolean pirSensorVal) {

        this.pirSensorVal = pirSensorVal;
    }

    public void setLightSensorVal(int lightSensorVal) {

        this.lightSensorVal = lightSensorVal;
    }

    public void setTimeReceived(String timeReceived) {

        this.timeReceived = timeReceived;
    }

    public void setHardBit(boolean hardBit) {

        isHardBit = hardBit;
    }

    public boolean getPirSensorVal() {

        return pirSensorVal;
    }

    public int getLightSensorVal() {

        return lightSensorVal;
    }

    public String getTimeReceived() {

        return timeReceived;
    }

    public boolean isHardBit() {

        return isHardBit;
    }

    // -------------------------------------------------------

    /**
     * Constructor without parameters
     */
    public Message(){

    }

    /**
     * CONSTRUCTOR
     * @param isHardBit boolean - Specifies if it is a control message from Arduino
     * @param pirSensorVal boolean - Value indicated by the PIR Sensor can be either 1 (movement present) or 0 (no movement)
     * @param lightSensorVal
     * @param timeReceived
     */
    public Message(boolean isHardBit, boolean pirSensorVal, int lightSensorVal, String timeReceived) {

        this.timeReceived = timeReceived;
        this.isHardBit = isHardBit;
        this.pirSensorVal = pirSensorVal;
        this.lightSensorVal = lightSensorVal;
    }

    /**
     * Returns the textual representation of a message
     * @Override
     * @return String
     */
    public String toString() {
        return "Message{" +
                "pirSensorVal=" + pirSensorVal +
                ", lightSensorVal=" + lightSensorVal +
                ", timeReceived='" + timeReceived + '}';
    }


    public static Message parse(String data){

        String[] splitMessage = data.split("|");
        Message message = new Message();

        return message;

    }

}
