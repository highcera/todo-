package Udemic;

public class U1_Q1117 {
    public static int howMany(boolean b, boolean... b2) {
        return b2.length;
    }
    public static void main(String[] args) {
 
        System.out.println(howMany(true, true, true));      // 2
        System.out.println(howMany(true, new boolean[2]));  // 2
 
        System.out.println(howMany(true));                  // 0
 
        System.out.println(howMany(true, true));            // 1
 
        // method howMany in class App cannot be applied to given types:
        // howMany();
 
        // illegal start of expression:
        // howMany(true, {true});
        // howMany(true, {true, true});
 
        // This would works, but is not offered:
        System.out.println(howMany(true, new boolean[]{true, true}));
        // 2
    }
}
