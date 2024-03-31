package Udemic;

public class U2_009 {
    // public static void main(String[] args) {
    //     int[] arr = {1, 2, 3, 4, 5};
    //     for (int i=0; i < arr.length; i++) {
    //         System.out.print(arr[i] + " ");  // 1 2 3 4 5
    //     }
    //     System.out.println();
    //     for (int i=arr.length-1; i >= 0; i--) {
    //         System.out.print(arr[i] + " ");  // 5 4 3 2 1 
    //     }
    // }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
