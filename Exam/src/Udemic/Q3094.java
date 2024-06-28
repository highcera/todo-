package Udemic;

public class Q3094 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        for (int e : arr) { System.out.println(e);}
        for (int i = 0; i < 0; i++) { System.out.println(i);}
        for (boolean b = true; b; b = !b) {System.out.println(b); }
        // for (;;) { }  // Infinite loop
        // java: variable i might not have been initialized:
        // for (int i; i < 4; i++) {}
    }
}
