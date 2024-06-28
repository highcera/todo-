package Udemic;

public class U1_Q1149 {
    public static void main(String[] args) {
 
        StringBuilder sb1 = new StringBuilder("Duke");
        String str1 = sb1.toString();
 
        // String str2 = "Duke";
        // System.out.println(str1 == str2);  // false
 
        // String str1 = str2;  // variable str1 is already defined
 
        // String str2 = sb1.toString();
        // System.out.println(str1 == str2);  // false
 
        String str2 = str1;
        System.out.println(str1 == str2);  // true
    }
}
