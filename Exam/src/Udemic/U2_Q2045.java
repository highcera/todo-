package Udemic;

public class U2_Q2045 {
    public static void main(String[] args) {
        int x = (int) (Math.random() * 2);
        switch (x) {
            case 0:
                System.out.println("Hello");
                // continue;  // continue outside of loop
                // exit;      // not a statement
                // goto;      // illegal start of expression
                break;
            case 1:
                System.out.println("World");
        }
    }
}
