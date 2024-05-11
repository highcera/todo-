package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U3_101 {
       public static void main(String[] args) {
        List<Integer> ages = new ArrayList<>();
        ages.add(Integer.parseInt("5"));
        ages.add(Integer.valueOf("6"));
        ages.add(7);
        ages.add(null);
        for (int age : ages) System.out.print(age);
        // 5
        // 6
        // 7
        // NullPointerException
    }
}
