package Udemic;

public class U2_Q2163 {
    static int run(){
        int a = Math.random() > 0.5 ? 1 : 0;
        // System.out.println(a);
        try {
            return 1/a ;                   // Line X
        }
        catch(ArithmeticException ae){
            return 666;                       // Line XX
        }
        finally {
            // return 42;                     // Line XXX
        }
        // return 123;                           // Line XXXX
    }
    public static void main(String[] args) {
        System.out.println(run());
    }
}
