package Udemic;

public class U2_071 {
    public static void main(String[] args) {
        int ax = 10, az = 30;
        int aw = 1, ay = 1;
        try {
            aw = ax % 2;
            aw = 10 % 2;
            System.out.println(aw);  // 0
            ay = az / aw;
        } catch (ArithmeticException e1) {
            System.out.println("Invalid Divisor");
            // Invalid Divisor.
        } catch (Exception e2) {
            aw = 1;
            System.out.println("Divisor changed");
        }
        ay = az / aw;                                     // line 14
        System.out.println("Successful Division " + ay);
    }
}
