package Udemic;

public class U1_080 {
    public static void main(String[] args) {
        int x = 0;
        String s = null;
        // incomparable types:
        // if(x == s) System.out.println("Success");  // Line 5
        if(String.valueOf(x) == s) System.out.println("Success");
        else System.out.println("Failure");
    }
}
