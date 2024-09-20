package Udemic;

import java.util.Arrays;
import java.util.List;

public class u2_Q2084 {
     public static void main(String[] args) {
        List<String> drinks = Arrays.asList("can", "cup");
        for (int container = 0;
            container < drinks.size(); container++)
                System.out.print(drinks.get(container) + ","); 
                // can,cup,
    }
}
