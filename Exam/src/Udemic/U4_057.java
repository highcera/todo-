package Udemic;

abstract class Dog {
    public abstract void bark();
}
public class U4_057 extends Dog {  // Poodle
    public void bark() {
        System.out.println("Woof");
    }

    public static void main(String[] args) {
        U4_057 p = new U4_057();
        p.bark();
    }
}