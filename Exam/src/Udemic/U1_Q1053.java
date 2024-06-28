package Udemic;

public class U1_Q1053 {
    public static int runTest() {
        return 0;
    }
    public static void main (String[] args) {
        // if (runTest()) {
        // incompatible types:
        // int cannot be converted to boolean
        if (runTest() != 0) {
            System.out.print("It works");
        }
        System.out.print("!");
    }
}
