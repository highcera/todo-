package Udemic;

class X {
    X() { }
    // private void one() { }
    protected void one() { }
}
public class U5_168 extends X {  // Y
    U5_168() { }
    private void two() { one(); }
    public static void main(String[] args) {
        new U5_168().two();
    }
}