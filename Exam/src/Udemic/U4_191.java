package Udemic;

public class U4_191 {
    public static void main(String[] args) {
        String str1 = "My String";
        String str2 = new String("My String");
 
        System.out.println(str1.equals(str2));  // true
        System.out.println(str1.toString());
        System.out.println(str2.toString());
        System.out.println(str1.toString() == str2.toString());  // false
        System.out.println(str1 == str2);       // false
        System.out.println(str1 = str2);        // My String
    }
}
