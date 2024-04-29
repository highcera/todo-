package Udemic;

import java.util.ArrayList;

public class U5_017 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("SE");
        list.add("EE");
        list.add("ME");
        list.add("SE");
        list.add("EE");
        list.remove("SE");
        System.out.println("Values are : " + list);
        // Values are : [EE, ME, SE, EE]
    }
}
