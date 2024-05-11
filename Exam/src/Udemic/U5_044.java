package Udemic;

class BigCat {
    void roar(int level) throw RuntimeException {        // Line m1
    // void roar(int level) throws RuntimeException {
        if(level < 3) throw new IllegalArgumentException("Incomplete");
        System.out.print("Roar!");
    }
}
public class U5_044 extends BigCat {  // Lion
    public void roar() {                                    // Line m2
        System.out.print("Roar!!!");
    }
    public static void main(String[] cubs) { 
        final BigCat kitty = new U5_044();  // Line m3
        kitty.roar(2);
    }
}