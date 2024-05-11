package Udemic;

// package beach;
public class U2_109 { // Sand
    public U2_109() {
        System.out.print("a");
    }
    public void Sand() {
        System.out.print("b");
    }
    public void run() {
        new U2_109();
        Sand();
    }
    public static void main(String... args) {
        new U2_109().run();  // aab
    }
}