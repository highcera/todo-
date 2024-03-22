package Udemic;

public class U3_052 {
    public static void main(String[] args) {
        int i = 25;
        int j = i++ + 1;
        System.out.println(j);  // 26
        System.out.println(i);  // 26
        if (j % 5 == 0) {
            System.out.println(j + " is divisible by 5");
        } else {
            System.out.println(j + " is not divisible by 5");
            // 26 is not divisible by 5
        }
        System.out.println("Done");  // Done
    }
}
