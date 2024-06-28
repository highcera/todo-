package Udemic;

import java.util.function.Predicate;

public class U1_Q1176 {
    public static void main(String[] args) {
        Predicate clear = c -> c.equals("clear");
        System.out.println(clear.test("pink"));  // false
        Object c1 = "pink";
        System.out.println(c1.equals("clear"));  // false
    }
}
