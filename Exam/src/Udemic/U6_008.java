package Udemic;

public class U6_008 {  //Laptop {
    public void start() {
        try {
            System.out.print("Starting up ");   // Line 4
            throw new Exception();              // Line 5
        } catch (Exception e) {                 // Line 6
            System.out.print("Problem ");       // Line 7
            System.exit(0);                     // Line 8
        } finally {
            System.out.print("Shutting down ");
        }
    }
    public static void main(String[] args) {
        new U6_008().start();
    }
}
 // The finally block does not execute because the JVM is no longer running.