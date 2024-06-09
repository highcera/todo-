package Udemic;

interface Run {
    default void walk() {
        System.out.print("Walking and running!");
    }
}
interface Jog {
    default void walk() {
        System.out.print("Walking and jogging!");
    }
}
public class U4_172 implements Run, Jog {  // Sprint
    public void walk() {
        System.out.print("Sprinting!");
    }
    public static void main(String[] args) {
        new U4_172().walk();  // Sprinting
    }
}