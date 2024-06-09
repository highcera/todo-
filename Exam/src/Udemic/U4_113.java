package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U4_113 {
   public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        // list.add(7);                            // Line 09
        // no suitable method found for add(int)
        for(String s : list) System.out.print(s);  // Line 10
    }
}
