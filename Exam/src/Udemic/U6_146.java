package Udemic;

public class U6_146 {  // Football
    public static Long getScore(Long timeRemaining) {
        return 2*timeRemaining;                 // Line m1
    }
    public static void main(String[] refs) {
        // final int startTime = 4;
        final long startTime = 4;
        System.out.print(getScore(startTime));  // Line m2
    }
}
