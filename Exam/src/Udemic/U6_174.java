package Udemic;

public class U6_174 {
    public static void main(String[] args) {
 
        boolean log3 = (5.0 != 6.0) && (4 != 5);  // true
        log3 = true && (4 != 5);                  // true
        log3 = true && true;                      // true
 
        boolean log4 = (4 != 4) || (4 == 4);  // true
        log4 = false || (4 == 4);             // true
        log4 = false || true;                 // true
        
        System.out.println("log3: " + log3 + "\nlog4: " + log4);
        // log3: true
        // log4: true
    }
}
