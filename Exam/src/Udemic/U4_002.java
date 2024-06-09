package Udemic;

abstract class Parallelogram {
    private int getEqualSides() {return 0;}
}
abstract class Rectangle extends Parallelogram {
    // public static int getEqualSides() {return 2;}  // Line x1
    public int getEqualSides() {return 2;}  // Line x1
}
public final class U4_002 extends Rectangle {  // Square
    public int getEqualSides() {return 4;}            // Line x2
    // getEqualSides() in ...Square
    // cannot override getEqualSides() in ...Rectangle
    // overridden method is static
    public static void main(String[] corners) {
        final U4_002 myFigure = new U4_002();         // Line x3
        System.out.print(myFigure.getEqualSides());
    }
}