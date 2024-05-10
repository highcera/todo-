package Udemic;

public class U5_102 {  // EJava {
    static String name;  // Line 2
    // cannot find symbol variable name
    // String name;      // Line 2
    public U5_102() {
        System.out.println(name);
    }
    void calc() {
        // String name;  // Line 7
        if (8 > 2) {
            System.out.println(name);
        }
    }
    public static void main(String... args) {
        // String name;  // Line 13
        System.out.println(name);  // null
    }

}
