package Udemic;

import java.util.Arrays;

public class U5_144 {
  public static void main(String[] args) {
        int[][] array2D = { {0,1,2}, {3,4,5,6} };
        System.out.print(array2D[0].length + " ");                // 3
        System.out.print(array2D[1].getClass().isArray() + " ");  // true
        System.out.println(array2D[0][1]);                        // 1
        
        System.out.println(Arrays.deepToString(array2D)); 
        // [[0, 1, 2], [3, 4, 5, 6]]
    }
}
