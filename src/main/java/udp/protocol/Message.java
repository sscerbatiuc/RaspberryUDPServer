package udp.protocol;

public class Message {

    private String time;
    private int lightSensor;
    private int pirSensorVal;

    // ---------------- GETTERS & SETTERS --------------------

    public void setPirSensorVal(int pirSensorVal) {  this.pirSensorVal = pirSensorVal;  }

    public void setLightSensor(int lightSensor) { this.lightSensor = lightSensor;  }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPirSensorVal() {
        return pirSensorVal;
    }

    public int getLightSensor() {
        return lightSensor;
    }

    public String getTime() {
        return time;
    }

    // -------------------------------------------------------

    /**
     * CONSTRUCTOR
     * @param pirSensorVal
     * @param lightSensorVal
     * @param timeReceived
     */
    public Message(int pirSensorVal, int lightSensorVal, String timeReceived) {
        this.pirSensorVal = pirSensorVal;
        this.lightSensor = lightSensorVal;
        this.time = timeReceived;
    }

    /**
     * Returns the textual representation of a message
     * @Override
     * @return String
     */
    public String toString() {
        return "Message{" +
                "pirSensorVal=" + pirSensorVal +
                ", lightSensor=" + lightSensor +
                ", time='" + time + '\'' +
                '}';
    }
}
