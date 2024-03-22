package Udemic;

public class U3_032 {
    static int start = 2;
    final int end;
    public U3_032(int x) {
        x = 4;
        end = x;
    }
    public void fly(int distance) {
        System.out.print(end-start + " ");  // 2
        System.out.print(distance);         // 5
    }
    public static void main(String... start) {
        new U3_032(10).fly(5);
    }
}
