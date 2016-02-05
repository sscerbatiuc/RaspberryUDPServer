package udp.helper;

import java.util.Calendar;


public class TimeHelper {

    /**
     * Returns the current time (HH:MM:SS)
     * @return String time
     */
    public static String getCurrentTime() {

        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minutes = Calendar.getInstance().get(Calendar.MINUTE);
        int seconds = Calendar.getInstance().get(Calendar.SECOND);
        String currentTimeString = (hours < 10 ? "0" + hours : hours) + ":"
                                + (minutes < 10 ? "0" + minutes : minutes) + ":"
                                + (seconds < 10 ? "0" + seconds : seconds);
        return currentTimeString;
    }

    /**
     * Returns a textual representation of the current time.
     *
     * @return String currentTimeStamp - day + month + hours + minutes
     */
    public static String getCurrentTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_YEAR);

        String currentTimeStamp = String.valueOf(day) + String.valueOf(month)
                + String.valueOf(hours) + String.valueOf(minutes)
                + String.valueOf(seconds);

        return currentTimeStamp;

    }
}
