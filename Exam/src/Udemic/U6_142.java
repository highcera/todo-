package Udemic;

public class U6_142 {
    public static void main(String officials[]) {
        try {
          System.out.print('A');
          throw new RuntimeException("Out of bounds!");
        } catch (ArrayIndexOutOfBoundsException aioobe) {
          System.out.print('B');
          throw aioobe;
        } finally {
          System.out.print('C');
        }
      }
}
