package Udemic;

class A {
    static { System.out.print("Hello from "); }
    static String name = "A";
}
class B extends A {
    static { System.out.print("B"); }
}
class C extends B {
    static { System.out.print("C"); }
}

public class U1_Q1115 {
    public static void main(String[] args){
        System.out.println(C.name);
        // Hello from A
    }
}
