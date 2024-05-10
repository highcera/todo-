package Udemic;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class U5_116 {  // HowLong {
    public static void main(String[] args) {
        LocalDate newYears = LocalDate.of(2017, 1, 1);
        Period period = Period.ofDays(1);
        System.out.println(newYears);
        System.out.println(period);
        DateTimeFormatter format =
            DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.print(format.format(newYears.minus(period)));
        // 12-31-2016
    }

}
