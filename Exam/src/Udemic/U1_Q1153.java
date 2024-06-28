package Udemic;

public class U1_Q1153 {
    public void openDrawbridge() throws Exception {  // Line p1
        try {
            throw new Exception("Circle");
        } catch (Exception e) {
            System.out.print("Opening!");
        } finally {
            System.out.print("Walls");               // Line p2
        }
    }
    // public static void main(String[] moat) {
    public static void main(String[] moat) throws Exception {
        new U1_Q1153().openDrawbridge();             // Line p3
        // java: unreported exception java.lang.Exception;
        // must be caught or declared to be thrown
    }
}
