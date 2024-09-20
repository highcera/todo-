package Udemic;

class Base {
    // Works and is properly encapsulated:
    private int num1;
    public int getNum1() { return num1; }
    public void setNum1(int num1) { this.num1 = num1; }
 
    // Works and is properly encapsulated:
    protected int num2;
    public int getNum2() { return num2; }
    public void setNum2(int num2) { this.num2 = num2; }
 
    // Works but is not properly encapsulated:
    public int num3;
    protected int getNum3() { return num3; }
    protected void setNum3(int num3) { this.num3 = num3; }
}
public class U2_Q2097 extends Base {  // Derived
    public static void main(String[] args) {
        U2_Q2097 obj = new U2_Q2097();
 
        obj.setNum1(3);
        System.out.println("Square = " +
            obj.getNum1() * obj.getNum1());
        // Square = 9
 
        obj.setNum2(3);
        System.out.println("Square = " +
            obj.getNum2() * obj.getNum2());
        // Square = 9
 
        obj.setNum3(3);
        System.out.println("Square = " +
            obj.getNum3() * obj.getNum3());
        // Square = 9
    }
}