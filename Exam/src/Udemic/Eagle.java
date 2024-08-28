package Udemic;

interface U2_Q2132 {  // CanFly
    // public void fly() {}  // Abstract method cannot have a body
    public void fly();
}
// final class Bird {  // Cannot be final
class Bird {
    // public int fly(int speed) {}
    public int fly(int speed) { return 0; }
}
public class Eagle extends Bird implements CanFly {
    public void fly() {}
}