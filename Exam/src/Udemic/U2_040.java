package Udemic;

public class U2_040 { // ForTest
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        for (int i : array) {
        }
        for (int i = 0; i < 1; i++) {
        }
        for (;;) {}  // Infinite loop, but works
 
        // for (; i < 1; i++) {}  // cannot find symbol
 
        // for (i = 0; i < 1) {}  // java: ';' expected
    }
}
