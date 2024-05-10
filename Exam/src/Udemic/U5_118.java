package Udemic;

public class U5_118 {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 4, 8, 16};
        for (int i : intArr) {
            System.out.print(i + " ");  // 1 2 4 8 16
        }
        System.out.println();
        for (int i=0; i < intArr.length; i++) {
            System.out.print(intArr[i] + " ");  // 1 2 4 8 16
        }
        System.out.println();
        for (int i : intArr) {
            // System.out.print(intArr[i] + " ");
            // ArrayIndexOutOfBoundsException
        }
        // for (int i=0 : intArr) {
        //     System.out.print(intArr[i] + " "); i++; }
        // java: ';' expected
        for (int i=0; i < intArr.length; i++) {
            System.out.print(i + " ");  // 0 1 2 3 4
        }
        System.out.println();
        // for (int i; i < intArr.length; i++) {
        //     System.out.print(intArr[i] + " "); }
        // java: variable i might not have been initialized
    }
}
