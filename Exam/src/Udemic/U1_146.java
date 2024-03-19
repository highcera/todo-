package Udemic;

public class U1_146 {
    public static void main(String... args) {
        int x = 10;
        int y = 20;
        int z = 30;
        if (x + y % z > (x + (-y) * (-z))) {
            System.out.println(x + y + z);
        }
        // System.out.println(x + y % z);      // 30
        // System.out.println(x + (y % z));    // 30
        // System.out.println(x + (20 % 30));  // 30
        // System.out.println(x + 20);         // 30
        // System.out.println(10 + 20);        // 30
        // System.out.println(30);             // 30
 
        // System.out.println(x + (-y) * (-z));  // 610
        // System.out.println(x + (-20 * -30));  // 610
        // System.out.println(x + 600);          // 610
        // System.out.println(10 + 600);         // 610
        // System.out.println(610);              // 610
    }
}
