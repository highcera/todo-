package Udemic;

public class U2_Q2076 {
    public static void main(String[] args) {
        // int arr[] = {1, 2, 3};
        int[] arr = {1, 2, 3};
        for (int var : arr) {
            int i = 1;
            while (i <= var) {
                System.out.print(i++ + " ");  // 1 1 2 1 2 3 
            }
        }
    }
}
