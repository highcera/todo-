package Udemic;

public class U4_037 {  // PassByValue {
    private int a = 0;
    private int b = 0;
    public void run1(int a, int b) {
        a = a;
        b = b;
        System.out.println("a = " + this.a + ", b = " + this.b);
    }
    public void run2(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("a = " + this.a + ", b = " + this.b);
    }
    public static void main(String[] args) {
        U4_037 pbv = new U4_037();
        pbv.run1(1, 2);  // a = 0, b = 0
        pbv.run2(3, 4);  // a = 3, b = 4
    }
}