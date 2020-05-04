package Basis;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomString {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public static void timestampinmillis() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long string = timestamp.getTime();

        //return number of milliseconds since January 1, 1970, 00:00:00 GMT
        System.out.println(string);

    }

        /*
        public static void timestamp() {

                //method 2 - via Date

                Date date = new Date();
                long timestamp = date.getTime();

                System.out.println(timestamp);
        }

         */



}