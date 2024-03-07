package Udemic;


interface DoInterface {
    void method1(int n1);                       // Line 1
}

class DoClass implements DoInterface {
    public DoClass(int p1) { }
    public void method1 (int p1) { }            // Line 2
    // private void method2 (int p1) { }        // Line 3
    public void method2 (int p1) { }            // Line 3
}

public class U1_052 {
    public static void main(String[] args) {
        // DoInterface doi = new DoClass(100);  // Line 4
        DoClass doi = new DoClass(100);         // Line 4
        doi.method1(100);
        doi.method2(200);
    }
}