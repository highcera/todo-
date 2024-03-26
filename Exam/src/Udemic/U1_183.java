package Udemic;

public class U1_183 {
    // private static final String monday; // 선언 시 set or in a static initialization block
    String tuesday;
    // final static wednesday = 3;
    final protected int thursday = 4;
    public static void main(String[] args) {
        U1_183 week = new U1_183();
        System.out.println(week.tuesday);  // null
        System.out.println(week.thursday);  // 4
    }
}
