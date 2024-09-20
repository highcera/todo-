package Udemic;

public class U2_Q2031 { // Penguin
    private double beakLength;
    public static void setBeakLength(U2_Q2031 p, int b) {
        p.beakLength = b;
        // p['beakLength'] = b;
        // p[beakLength] = b;
    }
    public static void main(String[] args) {
        U2_Q2031 test = new U2_Q2031();
        setBeakLength(test, 15);
        System.out.println(test.beakLength);
    }
}
