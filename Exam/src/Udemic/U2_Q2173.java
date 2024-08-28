package Udemic;

public class U2_Q2173 { // shoot
    interface Target {
        boolean needToAim(double angle);
    }
    static void prepare(double angle, Target t) {
        boolean ready = t.needToAim(angle);        // Line k1
        System.out.println(ready);  // true
    }
    public static void main(String[] args) {
        prepare(45, d -> d > 5 || d < -5);         // Line k2
    }
}
