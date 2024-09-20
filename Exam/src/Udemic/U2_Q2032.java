package Udemic;

// package beach;
public class U2_Q2032 { // Sand
    public U2_Q2032() {
        System.out.print("a");
    }
    public void Sand() {
        System.out.print("b");
    }
    public void run() {
        new U2_Q2032();
        Sand();
    }
    public static void main(String... args) {
        new U2_Q2032().run();  // aab
    }
}