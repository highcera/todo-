package Udemic;

import java.util.Arrays;

public class U4_145 {
    public static void main(String[] args) {
        // The rows can have a different lenght.
        // At declaration the length of the second dimension
        // does not have to be specified.
        int[][] matrix = new int[2][];
        matrix[0] = new int[1];
        matrix[0][0] = 23;
        matrix[1] = new int[2];
        matrix[1][0] = 17;
        matrix[1][1] = 42;
        System.out.println(Arrays.deepToString(matrix)); 
    }
}
