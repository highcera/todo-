package Udemic;

// Which two items are fields?

public class U4_077 {  // Vars {
    int j, k;
    public static void main(String[] args) {
      new U4_077().doStuff();
    }
    void doStuff() {
      int x = 1;
      doStuff2();
      System.out.println("x");
    }
    void doStuff2() {
      int y = 2;
      System.out.println("y");
      for (int z = 0; z < 3; z++) {
        System.out.println("z");
        System.out.println("y");
      }
    }
}
