package Udemic;

import java.util.Arrays;

public class U6_104 {
    public static void main(String[] args) {
        int[][] array2D1 = { {0, 1 ,2, 4}, {5, 6} };
        System.out.println(Arrays.deepToString(array2D1));
        // [[0, 1, 2, 4], [5, 6]]
 
        int[] array = {0, 1};
        int [][][] array3D1 = new int[2][2][2];
        array3D1[0][0] = array;
        array3D1[0][1] = array;
        array3D1[1][0] = array;
        array3D1[1][1] = array;
        System.out.println(Arrays.deepToString(array3D1));
        // [[[0, 1], [0, 1]], [[0, 1], [0, 1]]]
 
        // One level too much:
        // int[][][] array3D2 = { {0, 1}, {2, 3}, {4, 5} };
        int[][] array3D2 = { {0, 1}, {2, 3}, {4, 5} };
 
        // One level too much:
        // int[][] array2D2 = {0, 1};
        int[] array2D2 = {0, 1};
 
        // The first level is not initialized:
        // int[][] array2D3 = new int[][2];
        int[][] array2D3 = new int[2][2];
        array2D3[0][0] = 1;
        array2D3[0][1] = 2;
        array2D3[1][0] = 3;
        array2D3[1][1] = 4;
    }
}
