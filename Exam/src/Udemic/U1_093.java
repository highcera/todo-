package Udemic;

class MyException extends RuntimeException {}

public class U1_093 {
    static void run() {                        // Line 3
        try {
            throw Math.random() > 0.5
                    ? new MyException()
                    : new RuntimeException();
        }
        catch (RuntimeException rte) {
            System.out.print("B");             // B
        }
    }
    public static void main(String[] args) {
        try {
            run();
        }
        catch (MyException me) {
            System.out.print("A");
        }
    }
}
