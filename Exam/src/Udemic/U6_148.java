package Udemic;

public class U6_148 {
    public static void main(String[] args) {
 
        int arr[][] = new int[1][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 10;
            }
        }
        System.out.println(arr[0][0]);  // 10
        System.out.println(arr[0][1]);  // 10
        System.out.println(arr[0][2]);  // 10
    }
}
