package Udemic;

public class U5_142 {
    public static void main (String[] args) {
        int arr1[] = {1, 3, 5, 7, 9};
        int arr2[] = {0, 2, 4, 6};
        arr2 = arr1;
        for (int e : arr2) {
            System.out.print(e + " ");
            // 1 3 5 7 9 
        }
    }
}
