package Udemic;

public class U6_020 {
    public static void main(String[] args) {
        String s = "Hello";
        String t = new String(s);
 
        if ("Hello".equals(s)) System.out.println("one");  // one
        if (t == s) System.out.println("two");
        if (t.equals(s)) System.out.println("three");      // three
        if ("Hello" == s) System.out.println("four");      // four
        if ("Hello" == t) System.out.println("five");
    }
}
