package Udemic;

abstract class Car1 {
    protected abstract void accelerate();
}
 
abstract class Car2 {
    // missing method body, or declare abstract:
    // protected void accelerate();
}
 
interface Car3 {
    // modifier protected not allowed here:
    // protected abstract void accelerate();
}
 
abstract class Car4 {
    // missing method body, or declare abstract:
    // protected final void accelerate();
}
 
abstract class Car5 {
    // abstract methods cannot have a body:
    // protected abstract void accelerate() {
        // More a car can do
    // }
}
 
public class U5_027 {  // Cars
    public static void main(String[] args) {}
}