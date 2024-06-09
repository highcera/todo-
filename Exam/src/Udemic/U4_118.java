package Udemic;

class W {
    W() {
        System.out.println("W");
    }
}
class Z extends W {
    // Z() { super(); }
}
 
public class U4_118 {  // App
    public static void main(String[] args) {
        Z z = new Z();  // A
    }
}
