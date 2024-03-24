package Udemic;

class X {
    public void mX() {
        System.out.println("Xm1");
    }
}
 
class Y extends X {
    public void mX() {
        System.out.println("Xm2");
    }
    public void mY() {
        System.out.println("Ym");
    }
}

public class U1_151 {
    public static void main(String[] args) {
        X xRef = new Y();
        Y yRef = (Y) xRef;
        yRef.mY();  // Ym
        xRef.mX();  // Xm2
    }
}
