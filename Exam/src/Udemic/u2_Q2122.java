package Udemic;

public class u2_Q2122 { // SampleClass
    public static void main(String[] args) {
        u2_Q2122 sc, scA, scB;
        sc = new u2_Q2122();
        scA = new SampleClassA();
        scB = new SampleClassB();
        System.out.println("Hash is : " +
                sc.getHash() + ", " + scA.getHash() + ", " +
                scB.getHash());
    }
    public int getHash() {
        return 111111;
    }
}
class SampleClassA extends u2_Q2122 {
    // public long getHash() {
    public int getHash() {
        return 44444444;
    }
}
class SampleClassB extends u2_Q2122 {
    // public long getHash() {
    public int getHash() {
        return 999999999;
    }
}
