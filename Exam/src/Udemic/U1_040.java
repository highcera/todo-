package Udemic;

public class U1_040 {
  static int a = 42;
    public static void main(String[] args) {
      U1_040 t = new U1_040();
        t.a++;
        U1_040.a++;
        t.a--;
        System.out.println(--t.a + " " + U1_040.a);
        // 42 42
    }
}
