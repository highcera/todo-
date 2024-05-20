package Udemic;

import java.util.function.Predicate;

public class U5_184 {  // Card
    public static void main(String[] s) {
        // java: incompatible types:
        // incompatible parameter types in lambda expression:
        // Predicate<String> pred = (Integer i) -> true;
        // Predicate<String> pred = (Object o) -> true;
        
        // java: variable s is already defined
        // in method main(java.lang.String[]):
        // Predicate<String> pred = (String s) -> true;
        // The following would compile:
        Predicate<String> pred = (String s1) -> true;
    }
}
