package Udemic;
// Q1060
import java.util.Arrays;
public class U1_Q1060 {
    public static void main(String[] args) {
        int[][] array = {{0}, {0,1}, {0,2,4}, {0,3,6,9}, {0,4,8,12,16}};
        System.out.println(array[4][1]);     // 4
        // System.out.println(array[1][4]);  // ArrayIndexOutOfBoundsException
        System.out.println(Arrays.deepToString(array));
        // [[0], [0, 1], [0, 2, 4], [0, 3, 6, 9], [0, 4, 8, 12, 16]]
    }
}