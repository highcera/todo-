package Udemic;

import java.util.function.Predicate;

public class U6_042 {  // Panda {
    int age;
    public static void main(String[] args) {
        U6_042 p1 = new U6_042();
        p1.age = 1;
        check(p1, p -> p.age < 5);
    }
    private static void check(U6_042 panda, Predicate<U6_042> pred) {
        String result = pred.test(panda) ? "match" : "not match";
        System.out.print(result);  // match
    }
}