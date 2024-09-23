package Udemic;

public class U2_Q2054Q2054 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("1Z0-808");
        String str1 = sb1.toString();
        // String str2 = new String(str1);  // false
        // String str2 = sb1.toString();    // false
        // String str2 = "1Z0-808";         // false
        String str2 = str1;  // true
        System.out.print(str1 == str2);
    }
}
