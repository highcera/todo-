package Udemic;

abstract class Triangle {
    abstract String getDescription();
}
class RightTriangle extends Triangle {
    protected String getDescription() { return "rt"; }         // Line g1
}
// public abstract class IsoscelesRightTriangle extends RightTriangle {
// Line g2
public class U3_Q3129 extends RightTriangle {    // Line g2  IsoscelesRightTriangle
    public String getDescription() { return "irt"; }
    public static void main(String[] edges) {
        final Triangle shape = new U3_Q3129();   // Line g3
        // IsoscelesRightTriangle is abstract; cannot be instantiated
        System.out.print(shape.getDescription());
    }
}