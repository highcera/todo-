package Udemic;

import java.util.Arrays;

public class u3_117 {
       public static void main(String[] args) {
 
        int[] array = {1, 2, 3, 4, 5};
        System.arraycopy(array, 2, array, 1, 2);
        System.out.println(array[1]);  // 3
        System.out.println(array[4]);  // 5
        System.out.println(Arrays.toString(array));  // [1, 3, 4, 4, 5]
 
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {0, 0, 0, 0, 0};
        System.arraycopy(arr1, 2, arr2, 1, 2);
        System.out.println(Arrays.toString(arr2));  // [0, 3, 4, 0, 0]
    }
}
