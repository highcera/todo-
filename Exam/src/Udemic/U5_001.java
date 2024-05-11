package Udemic;

interface CanHop {}
class BrazilianHornedFrog extends U5_001 {}
class TurtleFrog extends U5_001 {}
 
public class U5_001 implements CanHop {  // Frog
    
    public static void main(String[] args) {
        
        U5_001 frog1 = new TurtleFrog();
        CanHop frog2 = new TurtleFrog();
        Object frog3 = new TurtleFrog();
        TurtleFrog frog4 = new TurtleFrog();
 
        // incompatible types:
        // BrazilianHornedFrog frog5 = new TurtleFrog();
        // Long frog6 = new TurtleFrog();
    }
}