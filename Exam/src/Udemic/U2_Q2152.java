package Udemic;

public class U2_Q2152 {
    public static void main(String... teams) {
        int score = 1;
        try {
            // int score = 1;
            System.out.print(score++);
        } catch (Throwable t) {
            System.out.print(score++);
        } finally {
            System.out.print(score++);
        }
        System.out.print(score++);
    }
}
