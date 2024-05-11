package Udemic;

class A{ }
class B { }
interface X { }
interface Y { }
 
class C1 extends A implements X {}
class C2 extends B implements X, Y {}
 
// class C3 implements Y extends B {}     // '{' expected
// class C4 extends A, B {}               // '{' expected
// class C5 implements X, Y extends B {}  // '{' expected
 
public class U6_081 {
    public static void main(String[] args) {}
}