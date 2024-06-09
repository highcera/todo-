package Udemic;

class X {
    X() {}
    // private void one() { }
    protected void one() {}
}

public class U4_168 extends X {  // Y
    U4_168() {}
    private void two() {one();}
    public static void main(String[] args) {
        new U4_168().two();
    }
}