package Udemic;

public class U1_Q1027 { // init order : declaration > instance initializer > constructor 
    public String first = "instance";  // Line 2
    public U1_Q1027() {
        first = "constructor";
    }
    { first = "block"; }               // Line 6
    public void print() {
        System.out.println(first);     // constructor
    }
    public static void main(String... args) {
        new U1_Q1027().print();
    }
}
