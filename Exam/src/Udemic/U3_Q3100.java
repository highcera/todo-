package Udemic;

public class U3_Q3100 {
    void x(int i) {
        System.out.println("one");
      }
      void x(String s) {
        System.out.println("two");
      }
      void x(double d) {
        System.out.println("three");
      }
      public static void main(String[] args) {
        new U3_Q3100().x(4.0);
      }
}
