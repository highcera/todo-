package Udemic;

class A { }
class B extends A { }

public class U1_042 {
    public static void main(String[] args) {
        A[] a1 = {};
        A[] a2 = a1;
        B[] b = {};
        a1 = b;               // Line t1
        // b = (B[]) a1;      // Line t2
        // b = a1;            // Line t2
        // java: incompatible types: ....A[] cannot be converted to ....B[]
        b = (B[]) a2;         // Line t3  // ClassCastException
    }
}

