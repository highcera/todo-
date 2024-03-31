package Udemic;

public class U2_054 { // Puppy  
    public static int wag = 5;               // Line q1
    public void Puppy(int wag) {             // Line q2
        this.wag = wag;
    }
    public static void main(String[] tail) {
        // System.out.print(new U2_054(2).wag);  // Line q3
        System.out.print(new U2_054().wag);      // Line q3
    }   
}
