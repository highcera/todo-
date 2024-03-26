package Udemic;

class A {
    void mA() { System.out.print("aaa"); }
}
class B extends A {
    protected void mA() { System.out.print("AAA"); }
    void mB() { System.out.print("BBB"); }
}
class U2_005 {
    public static void main (String[] args) {
        final A ab = new B();
        B bb = (B) ab;                         // Line t1
        bb.mB();  // BBB
        ab.mA();  // AAA                       // Line t2
    }
}