package Udemic;

public class U6_132 {

    public static void main(String[] args) {
        System.out.print("a");      // a
        try {
            System.out.print("b");  // b
            throw new IllegalArgumentException();
        } catch (RuntimeException e) {
            System.out.println("c");  // c
            // System.out.println(e);
        } finally {
            System.out.print("d");  // d
        }
        System.out.print("e");      // e
    }
}
