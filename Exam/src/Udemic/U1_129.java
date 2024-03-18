package Udemic;

public class U1_129 {
    public static void main(String[] args) {
        boolean log1 = (1 < 9) && (1 > 5);
        log1 = true && false;
 
        boolean log2 = (3 == 4) || (3 == 3);
        log2 = false || true;
 
        System.out.println("log1: " + log1 + "\nlog2: " + log2);
        // log1: false
        // log2: true
    }
}
