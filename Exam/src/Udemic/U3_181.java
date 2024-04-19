package Udemic;

class U3_181 {
    public static void modify(int[] arr) {
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = arr[idx] + 1;
            System.out.print(arr[idx] + " ");
        }
    }
    public static void main (String[] args) {
        int[] arr = {10, 20, 30};
        for (int e : arr) {
            System.out.print(e + " ");  // 10 20 30
        }
        modify(arr);  // 11 21 31
        for (int e : arr) {
            System.out.print(e + " "); // 11 21 31
        }
    }
}