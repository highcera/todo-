package Udemic;

public class u2_044 { // SampleClass
    public static void main(String[] args) {
        u2_044 sc, scA, scB;
        sc = new u2_044();
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
class SampleClassA extends u2_044 {
    // public long getHash() {
    public int getHash() {
        return 44444444;
    }
}
class SampleClassB extends u2_044 {
    // public long getHash() {
    public int getHash() {
        return 999999999;
    }
}
