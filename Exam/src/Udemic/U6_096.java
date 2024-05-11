package Udemic;

interface I { }
public class U6_096 implements I {  // Parent
    // @Override
    public String toString() { return "P "; }
    public static void main(String[] args) {
        Child c = new Child();
        U6_096 p = c;
        I inter = p;
        System.out.print(p);         // C
        System.out.print((Child)p);  // C
        System.out.print(inter);     // C
    }
}
class Child extends U6_096 {
    // @Override
    public String toString() { return "C "; }
}