package Udemic;

abstract class Programmer {
    protected void code1() { }        // Line 1
    protected void code2() { }        // Line 1
    abstract void debug();            // Line 2
}
class JavaCoder extends Programmer {
    // void code1() { }                // Line 3
    public void code1() { }
    protected void code2() { }
    protected void debug() { }        // Line 4
}

public class U6_085 {
    public static void main(String[] args) {
        new JavaCoder();
    }
}
