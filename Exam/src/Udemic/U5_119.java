package Udemic;

public class U5_119 {
    public static void main(String[] args) {
        try {
            int x = 1 / 0;
        } catch (Throwable t) {
            System.out.println(t);
            // java.lang.ArithmeticException: / by zero
        }
    }
}
