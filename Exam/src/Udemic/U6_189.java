package Udemic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class U6_189 {
public static void main(String[] args) {
        LocalDate date = LocalDate.parse(
            "2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
            date.plusDays(2);
            // date = date.plusDays(2);
        
        // cannot find symbol method plusHours(int)
        // date.plusHours(3);
        
        System.out.println(date.getYear() + " " +
                           date.getMonth() + " " + date.getDayOfMonth());
    }
}
