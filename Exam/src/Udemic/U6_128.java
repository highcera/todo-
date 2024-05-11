package Udemic;

abstract class Car {
    static { System.out.print("1"); }
    public Car(String name) {
        super();
        System.out.print("2");
    }
    { System.out.print("3"); } }

public class U6_128 extends Car {  // BlueCar
    { System.out.print("4"); }
    public U6_128() {
        super("blue");
        System.out.print("5");
    }
    public static void main(String[] gears) {
        new U6_128();  // 13245
    }
}
