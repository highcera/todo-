package Udemic;

import java.util.Arrays;

public class U2_019 {
     public static void main(String[] args) {
        int[][] array2D1;
        array2D1 = new int[1][1];
        System.out.println(Arrays.deepToString(array2D1));
        // [[0]]
 
        int[] array2D2[];
        array2D2 = new int[1][1];
        System.out.println(Arrays.deepToString(array2D2));
         // [[0]]
 
        // int[2][2] array2D3;  // java: ']' expected
 
        int array2D4[];
        array2D4 = new int[1];
        System.out.println(Arrays.toString(array2D4));  // [0]
 
        int[][] array2D5[];
        array2D5 = new int[1][1][1];
        System.out.println(Arrays.deepToString(array2D5));
        // [[[0]]]
    }
}
