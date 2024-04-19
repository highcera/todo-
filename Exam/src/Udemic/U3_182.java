package Udemic;

abstract class Duck {
    protected int count;
    public abstract int getDuckies();
}
public class U3_182 extends Duck {  // Ducklings
    private int age;
    public U3_182(int age) { this.age = age; }
    public int getDuckies() { return this.age/count; }
    // ArithmeticException
    public static void main(String[] pondInfo) {
        Duck itQuacks = new U3_182(5);
        System.out.print(itQuacks.getDuckies());
    }
}