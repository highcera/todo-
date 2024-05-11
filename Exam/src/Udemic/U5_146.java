package Udemic;

interface Climb {
    boolean isTooHigh(int height, int limit);
}
public class U5_146 {  // Climber
    public static void main(String[] args) {
        // int cannot be dereferenced:
        check((h, l) -> h.append(l).isEmpty(), 5);  // Line 07
    }
    private static void check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10))
            System.out.println("too high");
        else
            System.out.println("ok");
    }
}


public class U5_146 {

}
