package Udemic;

import java.util.function.Predicate;

class Season {
    String name;
}

public class U3_Q3169 {
    public static void main(String arguments[]) {
        Season season1 = new Season();
        season1.name = "Spring";
        Season season2 = new Season();
        season2.name = "Autumn";
        // Predicate<String> aSeason = (s) -> s == "Summer" ? season1.name : season2.name;
        // incompatible types: bad return type in lambda expression
        Predicate<String> aSeason = (s) -> s == "Summer";
        season1 = season2;
        System.out.println(season1.name);  // Autumn
        System.out.println(season2.name);  // Autumn
        System.out.println(aSeason.test(new String("Summer")));  // false
    }
}
