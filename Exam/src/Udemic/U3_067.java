package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U3_067 {
     public static void main(String[] args) {
        List<Integer> pennies = new ArrayList<>();
        pennies.add(3);
        pennies.add(2);
        pennies.add(1);
        pennies.remove(2);
        System.out.println(pennies);  // [3, 2]
    }
}
