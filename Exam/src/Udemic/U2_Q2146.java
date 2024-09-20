package Udemic;

public class U2_Q2146 {
    public static void main(String[] args) {
        doSomething();
        try {
            doSomething2();
        } catch (ArithmeticException e) {
            System.out.println(e);
            // java.lang.ArithmeticException: / by zero
        }
    }
    static void doSomething() {
        try {
            int x = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e); 
            // java.lang.ArithmeticException: / by zero
        }
    }
    static void doSomething2() throws ArithmeticException {
       int x = 1 / 0;
    }
}
