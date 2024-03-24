package Udemic;

public class U1_161 { // init order : declaration > instance initializer > constructor 
    public String first = "instance";  // Line 2
    public U1_161() {
        first = "constructor";
    }
    { first = "block"; }               // Line 6
    public void print() {
        System.out.println(first);     // constructor
    }
    public static void main(String... args) {
        new U1_161().print();
    }
}
