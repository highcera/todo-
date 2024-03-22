package Udemic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class U3_030 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2016, 6, 13);
        ld.plusMonths(6).format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(ld);  // 2016-06-13
    }
}
