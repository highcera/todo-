package Udemic;

public class U1_Q1053 {
    public static void main(String[] args) {
        int a = 0;
        System.out.println(a + a++ - a-- + " " + a);    // -1 0
        System.out.println((a + a++) - a-- + " " + a);  // -1 0
        a = 1;
        System.out.println(0 - a-- + " " + a);          // -1 0
        a = 1;
        System.out.println((0 - a--) + " " + a);        // -1 0
        a = 0;
        System.out.println((0 - 1) + " " + a);          // -1 0
        System.out.println(-1 + " " + a);               // -1 0
        System.out.println(-1 + " " + 0);               // -1 0
        System.out.println("-1 " + 0);                  // -1 0
        System.out.println("-1 0");                     // -1 0
    }
}
