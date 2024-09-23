package Udemic;

public class U2_Q2119 {  // Order
    String value = "t";
    { value += "a"; }
    { value += "c"; }
    public U2_Q2119() {
        value += "b";
    }
    public U2_Q2119(String s) {
        value += s;
    }
    public static void main(String[] args) {
        U2_Q2119 order = new U2_Q2119("f");     // Line 12
        order = new U2_Q2119();              // Line 13
        System.out.println(order.value);  // tacb
    }
}