package Udemic;

abstract class Paint1 {
    abstract void m1();
    void m2() { System.out.print(" Red"); }
}
abstract class Paint2 extends Paint1 {
    public void m1() { System.out.print("Orange"); }
    protected void m2() { System.out.print(" Yellow"); }
    abstract void m3();
}
class U1_128 extends Paint2 {
    public void m1() { System.out.print("Green"); }     // Green
    protected void m2() { System.out.print(" Blue"); }  // Blue
    void m3() { System.out.print(" Purple"); }          // Purple

    public static void main (String[] args) {
        Paint2 p = new U1_128();
        p.m1();
        p.m2();
        p.m3();
    }
}