package Udemic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class U4_010 {
 public static void main(String[] args) {
        // LocalDateTime.of(2016,6,13);
        // no suitable method found for of(int,int,int)
 
        // LocalDate ld = new LocalDate(2016,6,13);
        // LocalDate(int,int,int) has private access
        // in java.time.LocalDate
 
        LocalDate.of(2016, Month.JUNE, 30);
 
        LocalDateTime.of(2016,06,13,14,15);
 
        LocalTime.now().format(DateTimeFormatter.ISO_DATE);
        // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: Year
    }
}
