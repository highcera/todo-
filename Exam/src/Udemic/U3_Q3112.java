package Udemic;

public class U3_Q3112 extends U3_Q3112_1 { // Derived
    public static void main(String[] args) {
        U3_Q3112_1 obj = new U3_Q3112();
        obj.run();        // Line 1
        // obj.run(1);    // Line 2
        // obj.run(1.0);  // Line 3
        // obj.run("1");  // Line 4
 
        //It works, the reference type is also Derived:
        U3_Q3112 obj2 = new U3_Q3112();
        obj2.run();        // 0
        obj2.run(1);    // 1
    }
}
