package Udemic;

interface Source {
    void flipSwitch() throws Exception;
}

public class U2_069 implements Source { // LightBulb
    public void flipSwitch() {
        try {
            // throws new RuntimeException("Circuit Break!");
            // java: illegal start of expression
            throw new RuntimeException("Circuit Break!");
        } finally {
            System.out.print("Flipped!");
        }
    }
    public static void main(String... electricity) throws Throwable {
        final Source bulb = new U2_069();
        bulb.flipSwitch();
    }
}