package Udemic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class U2_124 {
    public static void main(String[] args) {
        String date = LocalDate.parse("2016-07-13")
                .plusDays(31)
                .format(DateTimeFormatter.ISO_DATE_TIME);
                // UnsupportedTemporalTypeException:
                // Unsupported field: HourOfDay
        System.out.println(date);
    }

}
