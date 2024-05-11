package Udemic;

public class U6_097 {
    static boolean test() {
        System.out.println("Test");
        return true;
    }
    public static void main(String[] args) {
        if (false && test()) {            // NO OUTPUT
            System.out.println("Hello");  // NO OUTPUT
        }
        System.out.println("---");
 
        if (false & test()) {             // Test
            System.out.println("Hello");  // NO OUTPUT
        }
    }
}
