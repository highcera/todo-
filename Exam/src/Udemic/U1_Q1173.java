package Udemic;

import java.util.function.Predicate;

public class U1_Q1173 {
    public static void main(String[] args) {
        Predicate<String> pred1 = s -> false;
        Predicate<String> pred2 = (s) -> false;
        // Predicate<String> pred3 = String s -> false;
        Predicate<String> pred4 = (String s) -> false;
    }
}
