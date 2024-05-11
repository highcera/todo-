package Udemic;

public class U3_146 {
    public static void main(String[] args) {
        int value = 33;
        if (value >= 0) {
            if (value != 0)
                System.out.print("The ");  // The
            else
                System.out.print("quick ");
 
            if (value < 10)
                System.out.print("brown ");
            else if (value > 30)
                System.out.print("fox ");  // fox
            else if (value < 50)
                System.out.print("jumps ");
            else if (value < 10)
                System.out.print("over ");
            else
                System.out.print("The ");
 
            if (value > 10)
                System.out.print("lazy ");  // lazy
        } else {
            System.out.print("dog ");
        }
        System.out.println( "..." );  // ...
    }
}
