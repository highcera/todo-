package Udemic;

public class U5_015 {
    public static void main(String[] args) {
        System.out.print("a");                     // Line 13
        try {
            System.out.print("b");                 // Line 15
            throw new IllegalArgumentException();  // Line 16
        } catch (IllegalArgumentException e) {     // Line 17
            System.out.print("c");                 // Line 18
            throw new RuntimeException("1");       // Line 19
        } catch (RuntimeException e) {
            System.out.print("d");
            throw new RuntimeException("2");
        } finally {
            System.out.print("e");            // e
            throw new RuntimeException("3");  // RuntimeException
        }
    }
}
