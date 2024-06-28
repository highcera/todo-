package Udemic;

import java.util.function.Predicate;

public class U3_Q3170 {  // Op 
    public static void main(String... args) {
        int a = 0;
        int b = 100;
        Predicate<Integer> compare = (var) -> var++ == 10;
        // if (!b++ > 100 && compare.test(a)) {
        if (b++ > 100 && compare.test(a)) {
            System.out.println(a + b);
        }
    }

}
