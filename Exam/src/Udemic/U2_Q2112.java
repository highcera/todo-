package Udemic;

public class U2_Q2112 {  // Production
    static int count = 0;
    int a = 0;
    public void rampUp() {
        while (a < 10) {
            a++;
            count++;
        }
    }
    public static void main(String[] args) {
        U2_Q2112 p1 = new U2_Q2112();
        U2_Q2112 p2 = new U2_Q2112();
        p1.rampUp();
        p2.rampUp();
        System.out.print("p1.count = " + p1.count + "," +
                         "p2.count = " + p2.count);
        // p1.count = 20, p2.count = 20
    }
}