package Udemic;

import java.util.function.Predicate;

public class U2_190 {  // test
    public static void main(String[] args) {
        System.out.println(test(i -> i == 5));
        System.out.println(test((i) -> i == 5));
        System.out.println(test((i) -> {return i == 5;}));
        
        // System.out.println(Test((int i) -> i == 5));
        System.out.println(test((Integer i) -> i == 5));
        
        // System.out.println(Test((int i) -> {return i == 5;}));
        System.out.println(test((Integer i) -> {return i == 5;}));
        
        // System.out.println(Test(i -> {i == 5;}));
        System.out.println(test(i -> {return i == 5;}));
    }
    private static boolean test(Predicate<Integer> p) {
        return p.test(5);
    }
}
