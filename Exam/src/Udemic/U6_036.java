package Udemic;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class U6_036 {  // HowLong {
    public static void main(String[] args) {
        LocalDate newYears = LocalDate.of(2017, 1, 1);
        Period period = Period.ofDays(1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("mm-dd-yyyy");  // "MM-dd-yyyy"
        System.out.print(format.format(newYears.minus(period)));
        // UnsupportedTemporalTypeException
    }

}
