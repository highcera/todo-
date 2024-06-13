package Udemic;

interface Printable {}
// True: An abstract class can implement an interface:
abstract class A implements Printable {}
// True: An abstract class can be extended by a concrete class:
class B extends A {}
 
// False: An abstract class can be extended by an interface:
// interface Test extends A {}  // interface expected here
 
// False: An interface CANNOT be extended by another interface:
interface Test1 {}
interface Test2 extends Test1 {}
 
// False: An interface can be extended by an abstract class:
// abstract class M extends Printable {}  // no interface expected here
 
// False: An abstract class CANNOT be extended by an abstract class:
abstract class C extends A {}
 
public class U4_036 {
    public static void main(String[] args) {}
}