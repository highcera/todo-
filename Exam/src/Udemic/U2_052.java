package Udemic;

public class U2_052 { // ScopeTest
    public static void main(String[] args) {
        doStuff();             // Line x1
        // int x1 = x2;        // Line x2  // cannot find symbol
        int x2 = j;            // Line x3
    }
    static void doStuff() {
        System.out.println(j); // Line x4
    }
    static int j;
}
