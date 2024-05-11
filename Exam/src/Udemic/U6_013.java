package Udemic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class U6_013 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 4, -1, 5);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Integer array[] = list.toArray(new Integer[4]);
        System.out.println(array[0]);  // -1
    }
}
// List<Integer> list = Arrays.asList(10, 4, -1, 5);