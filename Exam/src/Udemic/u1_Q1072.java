package Udemic;

import java.util.Arrays;

public class u1_Q1072 {
    public static void main(String[] args) {
        int[][] arr;
        arr = new int[2][];
        arr[0] = new int[3];
        arr[1] = new int[4];
        System.out.println(Arrays.deepToString(arr));
        // [[0, 0, 0], [0, 0, 0, 0]]
        
        // Methods of the class Object:
        System.out.println(arr.toString());   // e.g. [[I@4554617c
        System.out.println(arr.hashCode());   // e.g. 1163157884
        System.out.println(arr.equals(arr));  // true
        System.out.println(arr.getClass());   // class [[I
    }
}
