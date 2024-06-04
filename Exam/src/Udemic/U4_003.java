package Udemic;

public class U4_003 {  // Mouse {
    public String name;
    public void run() {
        System.out.print("1");              // Line 4
        try {
            System.out.print("2");          // Line 6
            name.toString();                // Line 7
            System.out.print("3");          // Line 8
        } catch (NullPointerException e) {  // Line 9
            System.out.print("4");          // Line 10
            throw e;                        // Line 11
        }
        System.out.print("5");              // Line 13
    }
    public static void main(String[] args) {
        U4_003 jerry = new U4_003();
        jerry.run();
        System.out.print("6");              // Line 18
    }
}