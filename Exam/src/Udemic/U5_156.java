package Udemic;

class A {
    public int x = 17;
    A() {};
    A(int z) {
        System.out.println("A");
    }
}

class B extends A{
    int y;
    B() {
        y = super.x + 4;
    }
    B(int z) {
        super(z);
    }
}

public class U5_156 {  // App
    public static void main(String[] args) {
        B b1 = new B();
        System.out.println(b1.y);  // 21
        // B b2 = new B(23);          // A
    }
}

// The super() : to call a constructor in the parent class
// super : used to reference a member of the parent class
// this() : to call a constructor in the current class
// this : used to reference a member of the current class