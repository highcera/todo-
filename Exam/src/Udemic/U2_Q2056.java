package Udemic;

public class U2_Q2056 { // Quantity
    private boolean flag;
    public void show() {
      int qty = flag ? 1 : 100;
      System.out.print("How many? " + qty++);
    }
    public static void main (String[] args) {
      new U2_Q2056().show();
    }
}
