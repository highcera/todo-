package Udemic;

public class U3_Q3014 {
    public static void main(String[] args) {
        doStuff();                            // Line 1
        // int x1 = x2;                       // Line 2
        // cannot find symbol
        int x2 = a;                           // Line 3
        System.out.println(x2); 
    }
    static void doStuff() {
        System.out.println(a);                // Line 4
    }
    static int a;
       
}

