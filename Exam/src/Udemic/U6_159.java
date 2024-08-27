package Udemic;

public class U_159 {
    public static void main(String[] args) {
        int[][] array = new int[2][];
        // int[][] array = new int[2][0];
 
        // int[][] array = null;           // NullPointerException
        // int[][] array = new int[2];     // incompatible types
        // int[][] array = new int[][4];   // ']' expected
        // int[][] array = new int[0][4];
        // ArrayIndexOutOfBoundsException
 
        array[0] = new int[2];
        array[0][0] = 1;
        array[0][1] = 2;
        array[1] = new int[3];
        array[1][0] = 10;
        array[1][1] = 20;
        array[1][2] = 30;
    }
}