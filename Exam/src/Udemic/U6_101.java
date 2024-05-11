package Udemic;

public class U6_101 {  //  Q {
    String str = "null";
    int a = 12;
    U6_101(String String) {
        str = String;
    }
    U6_101(int a) {
        this.a = a;
    }
    void println() {
        System.out.print(str + " " + a + " ");
    }
    public static void main(String[] args) {
        new U6_101("Hi!").println();  // Hi! 12 
        new U6_101(123).println();    // null 123 
    }
}