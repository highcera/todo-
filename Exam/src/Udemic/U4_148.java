package Udemic;

public class U4_148 {
    // args needs to be an array
    //    public static void main(String args) {
    //        System.out.println(args[1]);
    //    }
    
        // ArrayIndexOutOfBoundsException: 2
    //    public static void main(String[] args) {
    //        System.out.println(args[2]);
    //    }
    
    public static void main(String[] args) {
        System.out.println(args);     // e.g. [Ljava.lang.String;@4554617c
        System.out.println(args[1]);  // goodbye
    }
}
