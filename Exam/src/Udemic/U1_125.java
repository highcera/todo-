package Udemic;

public class U1_125 {
    public static void main(String[] args) {
        System.out.println("Result: " + 3 + 5);    // Result: 35
        System.out.println(("Result: " + 3) + 5);  // Result: 35
        System.out.println("Result: 3" + 5);       // Result: 35
        System.out.println("Result: 35");          // Result: 35
 
        System.out.println("Result: " + (3 + 5));  // Result: 8
        System.out.println("Result: " + 8);        // Result: 8
        System.out.println("Result: 8");           // Result: 8
    }
}
