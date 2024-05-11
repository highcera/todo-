package Udemic;

public class U2_162 {  // Order
    String value = "t";
    { value += "a"; }
    { value += "c"; }
    public U2_162() {
        value += "b";
    }
    public U2_162(String s) {
        value += s;
    }
    public static void main(String[] args) {
        U2_162 order = new U2_162("f");     // Line 12
        order = new U2_162();              // Line 13
        System.out.println(order.value);  // tacb
    }
}