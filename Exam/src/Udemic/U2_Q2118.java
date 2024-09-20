package Udemic;

public class U2_Q2118 {
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
        U2_Q2118 t = new U2_Q2118();
        short s = 123;
        t.print(s);      // int
        t.print(true);   // boolean → Boolean (Autoboxing) → Object
        t.print(6.789);  // double → Double (Autoboxing) → Object
    }

}
