package Udemic;

public class U6_045 {  //  FieldInit {
    char c;
    boolean b;
    float f;
    void printAll() {
        System.out.println("c = " + c);  // c = 
        System.out.println("b = " + b);  // b = false
        System.out.println("f = " + f);  // f = 0.0
    }
    public static void main(String[] args) {
        U6_045 f = new U6_045();
        f.printAll();
    }
}
