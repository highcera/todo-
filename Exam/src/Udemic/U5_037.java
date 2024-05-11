package Udemic;

public class U5_037 {  // Sleep {
    public static void snore() {
        try {
            String sheep[] = new String[3];
            System.out.print(sheep[3]);
        } catch (RuntimeException e) {
            System.out.print("Awake!");
        } finally {
            throw new Exception();              // Line 11
            // java: unreported exception java.lang.Exception;
            // must be caught or declared to be thrown
        }
    }
    public static void main(String... sheep) {  // Line 14
        new U5_037().snore();                    // Line 15
    }

}
