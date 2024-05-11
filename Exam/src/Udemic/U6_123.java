package Udemic;

public class U6_123 {  // CompareValues {
    public static void main(String[] args) {
        int x = 0;
        while (x++ < 10) {
            System.out.println(x);
        }    
        System.out.println(x);  // x =11                            // Line 4
        // String message = x > 10 ? "Greater than" : false; // Line 5
        String message =
            x > 10 ? "Greater than" : "Not greater than"; // Line 5
        System.out.println(message + "," + x);
    }

}
