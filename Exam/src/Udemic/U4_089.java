package Udemic;

public class U4_089 {
    public static void main(String[] args) {
        short a = 5;
        while (isValid(a)) {
            // System.out.print(a);          // Line 5
            System.out.print(a); a--;        // Line 5
        }
    }
    public static boolean isValid (int a) {
        return a-- > 0 ? true : false;       // Line 9
    }
}
