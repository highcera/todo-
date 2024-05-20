package Udemic;

class DragonException extends Exception {}
public class U5_166 {  // Lair
    public void openDrawbridge() throws Exception {            // Line r1
        try {
            throw new Exception("This Exception");
        } catch (RuntimeException e) {
            throw new DragonException();                       // Line r2
        } finally {
            throw new RuntimeException("Or maybe this one");
        }
    }
    public static void main(String[] moat) throws Exception {
        new U5_166().openDrawbridge();                           // Line r3
    }
}