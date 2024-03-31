package Udemic;

public class U2_062 {
    public static void main(String[] args) {
        short[] arr1;
        arr1 = new short[2];
        arr1[0] = 3;
        arr1[1] = 1;
        System.out.println(
            "FCB vs MU " + arr1[0] + " : " + arr1[1]);
        // FCB vs MU 3 : 1
 
        // long arr2[2];               // ']' expected
        // int arr3 = new int[2];      // incompatible types
        // byte[] new arr4 = byte[2];  // not a statement
    }
}
