package Udemic;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class U3_Q3186 {
    public static void main(String[] args) {
        System.out.println(LocalDate.of(2015, 4, 1));
        // 2015-04-01
 
        System.out.println(LocalDate.of(2015, Month.APRIL, 1));
        // 2015-04-01
 
        System.out.println(LocalDate.of(2015, 3, 1));
        // 2015-03-01
 
        // System.out.println(new LocalDate(2015, 3, 1));
        // LocalDate(int,int,int) has private access in ... LocalDate
 
        // System.out.println(new LocalDate(2015, 4, 1));
        // LocalDate(int,int,int) has private access in ... LocalDate
 
        System.out.println(LocalDate.of(2015, Calendar.APRIL, 1));
        // 2015-03-01
    }
}
