package Udemic;

public class U3_048 {
    public static void main(String[] args) {
        String s1 = "java";
        StringBuilder s2 = new StringBuilder("java");
        // incomparable types:
        // if (s1 == s2)
            System.out.print("1");
        if (s1.equals(s2))
            System.out.print("2");
    }
}
