package Udemic;

public class U1_153 {
    // int x(double d) {
    int x(int d) {
        System.out.println("one");
        return 0;
    }
    // String x(double d) {
    String x(String d) {
        System.out.println("two");
        return null;
    }
    double x(double d) {
        System.out.println("three");
        return 0.0;
    }
    public static void main(String[] args) {
        new U1_153().x(4.0);
    }
}
