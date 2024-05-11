package Udemic;

public class U5_131 {
    public static void main(String[] args) {
        System.out.println(args[0]);  // 12345
        int num = Integer.parseInt(args[1]);
        System.out.println("Number is : " + num);
        // ArrayIndexOutOfBoundsException
    }
}


// javac Test.java
// java Test 12345