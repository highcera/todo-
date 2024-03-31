package Udemic;

public class U2_095 { // Jogger
    public static void main(String[] args) {
        U2_095 jogger = new Runner();
        FitnessBuff runner = new Runner();
 
        // jogger.move();                     // Line 07
        // cannot find symbol move()
 
        // (FitnessBuff)jogger.move();        // Line 08
        // not a statement
 
        ((FitnessBuff)jogger).move();         // Line 09
 
        runner.move();                        // Line 10
 
        // (FitnessBuff)runner.move();        // Line 11
        // not a statement
 
        ((FitnessBuff)runner).move();         // Line 12
    }
}

class Runner extends U2_095 implements FitnessBuff {
    public void move() { System.out.println("Make way!"); }
}
interface FitnessBuff { public void move(); }