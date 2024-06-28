package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U1_Q1185 {
     public static void main(String[] args) {
        List<Integer> ages = new ArrayList<>();
        ages.add(16);
        ages.add(null);
        
        for (int i = 0; i < ages.size(); i++) System.out.print(ages.get(i));
        // 16null
        for (int i : ages) System.out.println(i);
        // 16 NullPointerException
     }
}
