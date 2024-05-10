package Udemic;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class U5_121 {
  public static void main(String[] args) {
        System.out.println(LocalDate.now().plus(Period.of(0,0,0)));
        // 2016-06-13
        System.out.println(LocalDate.of(2016, Month.JUNE, 13)
                .format(DateTimeFormatter.ISO_LOCAL_DATE));
        // 2016-06-13
        System.out.println(LocalDate.parse("2016-06-13",
                 DateTimeFormatter.ISO_DATE));
        // 2016-06-13
        System.out.println(LocalDate.parse("2024-05-05", DateTimeFormatter.ISO_DATE));
    }
}