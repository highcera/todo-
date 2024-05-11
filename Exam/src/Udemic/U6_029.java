package Udemic;

public class U6_029 {  // Test
    public static void main(String[] args) {
        U6_029 ts = new U6_029();
        System.out.print(isAvailable + " ");
        isAvailable = ts.doStuff();
        System.out.println(isAvailable);
      }
      public static boolean doStuff() {
        return !isAvailable;
      }
      static boolean isAvailable = false;
}
