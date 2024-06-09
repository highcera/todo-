package Udemic;

public class U4_104 {
    public static void main(String[] args) {
        System.out.println(2 + 4 * 9 - 3);   // 35
        System.out.println(2 + 36 - 3);      // 35
        System.out.println(38 - 3);          // 35
        System.out.println(35);              // 35
 
        System.out.println((2 + 4) * 9 - 3); // 51 (highest)
        System.out.println(6 * 9 - 3);       // 51 (highest)
        System.out.println(54 - 3);          // 51 (highest)
        System.out.println(51);              // 51 (highest)
 
        System.out.println(2 + (4 * 9) - 3); // 35
        System.out.println(2 + 36 - 3);      // 35
        System.out.println(38 - 3);          // 35
        System.out.println(35);              // 35
 
        System.out.println(2 + 4 * (9 - 3)); // 26
        System.out.println(2 + 4 * 6);       // 26
        System.out.println(2 + 24);          // 26
        System.out.println(26);              // 26
 
        System.out.println((2 + 4 * 9) - 3); // 35
        System.out.println((2 + 36) - 3);    // 35
        System.out.println(38 - 3);          // 35
        System.out.println(35);              // 35
    }
}
