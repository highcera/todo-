package Udemic;

import OCAJP.Exam.src.Base.A;

public class U4_122 extend A {  // class B extends A {
    public static void main(String[] args) {
        A obj = new U4_122();
        // B obj = new B();
        System.out.println("a = " + obj.a);     // public
        // System.out.println("b = " + obj.b);  // protected
        // System.out.println("c = " + obj.c);  // "package"
        // System.out.println("d = " + obj.d);  // private
    }
}