package Udemic;

import java.util.Arrays;
import java.util.List;

public class U3_085 {
     public static void main(String[] args) {
        List<String> bottles = Arrays.asList("glass", "plastic");
        // for (int type = 0; type < bottles.size(); )
        //     System.out.print(bottles.get(type) + ",");
        //     // break; // inifinte
       
        for (int type = 0; type < bottles.size(); type++)
            System.out.print(bottles.get(type) + ",");
            // break;

        // for (int type = 0; type < bottles.size(); ) {
        //     System.out.print(bottles.get(type) + ",");
        //     break;
        // }
        System.out.print("end");
    }
}
