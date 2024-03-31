package Udemic;

public class U2_094 { // AreYouBob 
    public static void main(String[] unused) {
        String bob = new String("bob");
        String notBob = bob;
        System.out.print((bob==notBob)+" "+(bob.equals(notBob)));
        // true true
    }   
}
