package Udemic;

import java.util.ArrayList;

public class u2_043 {
public static void main(String[] args) {
        ArrayList<String> someTypes = new ArrayList<>();
        someTypes.add("byte");
        someTypes.add("long");
        someTypes.add("int");
        System.out.println(someTypes.size());           // 3
        System.out.println(someTypes.get(2).length());  // 3
 
        // System.out.println(someTypes.capacity());
        // cannot find symbol capacity()
 
        // System.out.println(someTypes.length());
        // cannot find symbol length()
 
        // System.out.println(someTypes.get(2).size);
        // cannot find symbol size
 
        // System.out.println(someTypes.get(2).length);
        // cannot find symbol length
    }
}
