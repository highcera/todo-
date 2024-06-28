package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U4_086 {  // Ref {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        String s2 = s1.toString();
        List<String> lst = new ArrayList<>();
        lst.add(s2);
        System.out.println(s1.getClass());   // ... StringBuilder
        System.out.println(s2.getClass());   // class java.lang.String
        System.out.println(lst.getClass());  // class java.util.ArrayList
    }

}
