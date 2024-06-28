package Udemic;

public class U1_Q1170 {
    public static void main(String[] args) {
        Byte b1 = (byte)100;               // 1
        Integer i1 = (int)200;             // 2
 
        // The primitive int cannot
        // be cast to the Wrapper-Klass Long:
        // Long l1 = (long)300;            // 3
        long l1 = (long)300;               // 3
        Float f1 = (float)b1 + (int)l1;    // 4
 
        // The integer 300 cannot
        // be assigned to a String variable:
        // String s1 = 300;                // 5
        int s1 = 300;                      // 5
 
        // The comparison operator cannot
        // be applied to a String and an int:
        // if (s1 == (b1 + i1))            // 6
        if (s1 == (b1 + i1))               // 6
 
        // An int can not be cast to a String:
            // s1 = (String)500;           // 7
            s1 = 500;                      // 7
        else                               // 8
 
        // An int can not be assigned to a float variable:
            // f1 = (int)100;              // 9
            f1 = (float)100;               // 9
        System.out.println(s1 + ":" + f1); // 10
    }
}
