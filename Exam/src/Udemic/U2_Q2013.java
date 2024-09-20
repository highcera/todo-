package Udemic;

public class U2_Q2013 { // OpenSesame
    public static void main(String... args) {           // Line 1
        if (args[4].equals("password") ? false : true) {  // Line 2
            System.out.println("Access denied!");
        } else {
            System.out.println("Access granted!");
        }
    }
}
// javac OpenSesame.java
// java OpenSesame My voice is my password
