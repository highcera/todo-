package Udemic;

public class U1_Q1107 {
    // private static final String monday; // 선언 시 set or in a static initialization block
    String tuesday;
    // final static wednesday = 3;
    final protected int thursday = 4;
    public static void main(String[] args) {
        U1_Q1107 week = new U1_Q1107();
        System.out.println(week.tuesday);  // null
        System.out.println(week.thursday);  // 4
    }
}
