package Udemic;

interface Sphere {
    default String getName() { return "Unknown"; }
}

abstract class Planet {
    abstract String getName();
}

public class U3_Q3130 extends Planet implements Sphere { 
// public class Mars extends Sphere implements Planet {
// java: class, interface, or enum expected
    public U3_Q3130() {
        super();
    }
    public String getName() { return "U3_061"; }
    public static void main(final String[] probe) {
        System.out.print(((Planet)new U3_Q3130()).getName());
    }
}
