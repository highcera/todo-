package Udemic;

public class X {  // U5_030
    // private X() {}
    public X() {}
    void one() {}
}

public class U5_030 extends X {  // Y
    private U5_030() {
        super();
    }
    public static void main(String[] args) {
        U5_030 test = new U5_030();
        test.one();
    }
}