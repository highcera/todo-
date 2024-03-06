package Udemic;

import java.time.LocalDate;
import java.time.Month;

public class U1_032 {
    public static void main(String[] args) {
        // DateTimeException:
        LocalDate date = LocalDate.of(2018, Month.APRIL, 30); // 40 Invalid value for DayOfMonth- runtime exception
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }
}
