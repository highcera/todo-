package Udemic;

interface Pet {}
class Dog implements Pet {}
public class U4_005 extends Dog {  // Beagle
    public static void main(String[] args) {
        
        // The interface can be the reference type:
        Pet a = new Dog();
        Pet e = new U4_005();
        
        // The superclass can be the reference type:
        Dog d = new U4_005();
        
        // You can not instantiate an interface
        // (unless its a functional interface):
        // Pet b = new Pet();
        // Dog f = new Pet();
        
        // The subclass cannot be the reference type:
        // Beagle c = new Dog();
    }
}