package Udemic;

public class U2_Q2125 extends Root { // Test
    public static void main(String[] args) {
      Root r = new U2_Q2125();
      System.out.println(r.method1());        // Line n1
      System.out.println(r.method2());        // Line n2
    }
  }
  class Root {
    private static final int MAX = 20000;
    private int method1() {
      int a = 100 + MAX;                      // Line n3
      return a;
    }
    protected int method2() {
      int a = 200 + MAX;                      // Line n4
      return a;
    }
  }