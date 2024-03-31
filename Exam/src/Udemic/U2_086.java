package Udemic;

public class U2_086 { // Penguin
    private double beakLength;
    public static void setBeakLength(U2_086 p, int b) {
        p.beakLength = b;
        // p['beakLength'] = b;
        // p[beakLength] = b;
    }
    public static void main(String[] args) {
        U2_086 test = new U2_086();
        setBeakLength(test, 15);
        System.out.println(test.beakLength);
    }
}
