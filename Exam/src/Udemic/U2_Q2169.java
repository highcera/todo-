package Udemic;

public class U2_Q2169 {
    public static void main(String[] args) {
        System.out.println("Hello".substring(0));  // Hello
    }
    private String add(String s1, String s2) {
        return s1.concat(s2);
    }
    String subtract(String first, String second) {
        return first.concat(second.substring(0));
    }
}
