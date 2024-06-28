package Udemic;

public class U1_Q1113 {
  static int a = 42;
    public static void main(String[] args) {
      U1_Q1113 t = new U1_Q1113();
        t.a++;
        U1_Q1113.a++;
        t.a--;
        System.out.println(--t.a + " " + U1_Q1113.a);
        // 42 42
    }
}
