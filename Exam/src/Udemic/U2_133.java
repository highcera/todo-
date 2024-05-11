package Udemic;

public class U2_133 {
    public void print(byte x) {
        System.out.print("byte");
    }
    public void print(int x) {
        System.out.print("int");
    }
    public void print(float x) {
        System.out.print("float");
    }
    public void print(Object x) {
        System.out.print("Object");
    }
    public static void main(String[] args) {
        U2_133 t = new U2_133();
        short s = 123;
        t.print(s);      // int
        t.print(true);   // boolean → Boolean (Autoboxing) → Object
        t.print(6.789);  // double → Double (Autoboxing) → Object
    }

}
