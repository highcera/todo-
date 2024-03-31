package Udemic;

public class U2_096 { // Quantity
    private boolean flag;
    public void show() {
      int qty = flag ? 1 : 100;
      System.out.print("How many? " + qty++);
    }
    public static void main (String[] args) {
      new U2_096().show();
    }
}
