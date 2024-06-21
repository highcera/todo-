package Udemic;

import java.util.function.Predicate;

public class U4_058 {
    public static void main(String[] args) {
        Predicate<StringBuilder> p1 = (StringBuilder b) -> {return true;};
        Predicate<StringBuilder> p2 = (StringBuilder b) -> true;
    }
}
