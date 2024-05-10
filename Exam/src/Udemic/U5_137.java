package Udemic;

public class U5_137 {
    public static void main(String[] args) {
        System.out.println("Result: " + 2 + 3 + 5);    // Result: 235
        System.out.println(("Result: " + 2) + 3 + 5);  // Result: 235
        System.out.println("Result: 2" + 3 + 5);       // Result: 235
        System.out.println(("Result: 2" + 3) + 5);     // Result: 235
        System.out.println("Result: 23" + 5);          // Result: 235
        System.out.println("Result: 235");             // Result: 235

        System.out.println("Result: " + 2 + 3 * 5);    // Result: 215
        System.out.println("Result: " + 2 + (3 * 5));  // Result: 215
        System.out.println("Result: " + 2 + 15);       // Result: 215
        System.out.println(("Result: " + 2) + 15);     // Result: 215
        System.out.println("Result: 2" + 15);          // Result: 215
        System.out.println("Result: 215");             // Result: 215
    }
}
