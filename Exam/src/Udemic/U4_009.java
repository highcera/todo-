package Udemic;

interface HasTail { int getTailLength(); }
abstract class Puma implements HasTail {
    // protected int getTailLength() { return 4; }    // Line 3
    public int getTailLength() { return 4; }          // Line 3
}
 
public class U4_009 extends Puma {              // Cougar        // Line 5
    public static void main(String[] args) {
        // Puma puma = new Puma();                    // Line 7
        Puma puma = new U4_009();                     // Line 7
        System.out.println(puma.getTailLength());
    }
 
    public int getTailLength(int length) {return 2;}  // Line 11
}
// Line 5 doesn't work, when Line 3 says protected