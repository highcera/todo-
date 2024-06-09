package p3;

import p1.A;

public class B extends A {
    public static void main(String[] args) {
        A obj = new B();
        // B obj = new B();
        System.out.println("a = " + obj.a);     // public
        System.out.println("b = " + obj.b);  // protected
        // System.out.println("c = " + obj.c);  // "package"
        // System.out.println("d = " + obj.d);  // private
    }
}
