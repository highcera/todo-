package Udemic;

class U6_186 {  // Test
    static int a;
    int b;
    U6_186(int a, int b) {
        this.a += a;
        this.b += b;
    }
    void modify(int a, int b) {
        // this(a, b);
        // call to this must be first statement in constructor
    }
    public static void main(String[] args) {
        U6_186 t1 = new U6_186(10, 20);
        U6_186 t2 = new U6_186(30, 40);
        t1.modify(10, 20);
        t2.modify(10, 20);
        System.out.println("a = " + U6_186.a + ", b = " + t2.b);
    }
}