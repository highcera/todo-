package Udemic;

interface Beverage {}
class Coffee implements Beverage {}
class U4_101 extends Coffee {  // Java
    public static void main(String[] args) {
        Beverage obj1 = new Coffee();
        Beverage obj2 = new U4_101();
        Coffee obj3 = new U4_101();
        // Beverage obj4 = new Beverage();
        // java: ....Beverage is abstract; cannot be instantiated
        // Coffee obj = new Beverage();
        // java: ....Beverage is abstract; cannot be instantiated
        // U4_101 obj = new Coffee();
        // java: incompatible types:
        // ...Coffee cannot be converted to ...Java
    }
}