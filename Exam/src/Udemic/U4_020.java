package Udemic;

class Mammal {
    public Mammal() {}
    public Mammal(int age) {
        System.out.print("Mammal");
    }
}
public class U4_020 extends Mammal {  // Platypus
    public U4_020() {
        // super();
        System.out.print("Platypus");         // Line 08
    }
    public static void main(String[] args) {
        new Mammal(5);
    }
}