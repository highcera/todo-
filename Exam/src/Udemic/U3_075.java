package Udemic;

public class U3_075 {
    public static void main(String[] args) {
        String str1 = "Hello world!";
        String str2 = new String("Hello world!");
        if (str1 == str2) System.out.println("Same");
        if (str1.equals(str2))
            System.out.println("More of the same");  // More of the same
    }
}
