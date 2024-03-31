package Udemic;

public class U2_091 {
    public static void main(String[] args) {
        String a = "";
        a += 2;                         // Line 14
        a += 'c';                       // Line 15
        a += false;                     // Line 16
        if (a == "2cfalse")             // Line 17
            System.out.println("==");   // Line 18
        if (a.equals("2cfalse"))
            System.out.println("equals");  // equals
    }
}
