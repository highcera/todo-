package Udemic;

interface Flier {
    public void takeOff();
    public void land();
}
class Plane implements Flier {  // Line 1
                                         // Line 2
    public void land() { }
}
class Boeing747 extends Plane {          // Line 3
// abstract class Boeing747 extends Plane {
//public void takeOff() { }            // Line 4
    public void land() { }
}

public class U1_Q1139 {
    public static void main(String[] args) {
        new Plane();
    }
}
