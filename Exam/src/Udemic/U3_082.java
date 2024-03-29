package Udemic;

public class U3_082 { //StaticMethods
    static void one() {
        two();                    // Line 3
        U3_082.two();      // Line 4
        // three();               // Line 5
        // U3_082.four();  // Line 6
    }
    static void two() {}
    void three() {
        // one;                   // Line 10
        U3_082.two();      // Line 11
        four();                   // Line 12
        // U3_082.four();  // Line 13
    }
    void four() {}
    public static void main(String[] args) {}
}

