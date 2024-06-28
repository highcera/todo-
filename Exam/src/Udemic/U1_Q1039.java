package Udemic;

public class U1_Q1039 {
    public static void main(String[] args) {
        byte a = 40, b = 50;
 
        // incompatible types
        // byte sum = (byte) a + b;  // Line 4
 
        byte sum = (byte) (a + b);
 
        System.out.println(sum);
    }
}
