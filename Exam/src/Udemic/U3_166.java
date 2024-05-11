package Udemic;

public class U3_166 {
    public static void main(String[] args) {
        int[][] arr2D = {{0, 1, 2}, {3, 4, 5, 6}};
        System.out.print(arr2D[0].length + " ");                // 3
        System.out.print(arr2D[1].getClass().isArray() + " ");  // true
        System.out.print(arr2D[0][1]);                          // 1
    }
}
