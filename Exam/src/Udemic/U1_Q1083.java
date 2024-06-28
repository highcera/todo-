package Udemic;

import java.util.Arrays;
import java.util.List;

public class U1_Q1083 {
     public static void main(String[] args) {
        List<String> bottles = Arrays.asList("glass", "plastic");
        for (int type = 0; type < bottles.size();) {
            System.out.print(bottles.get(type) + ",");  // glass,
            break;
        }
        System.out.print("end");  // end
    }

}
