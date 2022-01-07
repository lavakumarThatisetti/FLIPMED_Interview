package util;

import java.time.LocalTime;

public class Utils {

    public static LocalTime convertStringToTime(String str){
        String[] time = str.split(":");
        return LocalTime.of(Integer.parseInt(time[0]),Integer.parseInt(time[1]));
    }
}
