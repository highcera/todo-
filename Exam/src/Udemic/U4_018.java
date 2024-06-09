package Udemic;

public class U4_018 {
    public static void main(String[] args) {
        int value = 22;
        if (value >= 0) {
            if (value != 0)
                System.out.print("My ");      // My
            else System.out.print("girl ");
            if (value < 10)
                System.out.print("wove ");
            if (value > 20)
                System.out.print("six ");     // six
            else if (value < 30)
                System.out.print("dozen ");
            else if (value < 10)
                System.out.print("plaid ");
            else
                System.out.print("jackets ");
            if (value > 10) {
                System.out.print("before ");  // before
            } else {
                System.out.print("she ");
            }
            System.out.print("quit.");        // quit.
        }
    }
}
