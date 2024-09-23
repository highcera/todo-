package Udemic;

public class U2_Q2011 { // Keyboard
    // private boolean numLock = true;
    private static boolean numLock = true;
    static boolean capLock = false;
    public static void main(String... shortcuts) {
        // U2_048 t = new U2_048();
        // System.out.print(new U2_048().numLock + " " + capLock);
        System.out.print(numLock + " " + capLock);
        // non-static variable numLock cannot be referenced
        // from a static context
    }
}
