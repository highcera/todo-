package Udemic;

import java.util.ArrayList;

public class U3_110 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();  // Line a1
        list.add(1);                                // Line a2
        System.out.println(list.get(list.size()));  // Line a3
        // IndexOutOfBoundsException
    }
}
