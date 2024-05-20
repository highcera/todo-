package Udemic;

public class U5_176 {
    public static void main(String[] args) {
        // incompatible types:
        // java.lang.String cannot be converted to StringBuilder
        // StringBuilder b = "rumble";
        StringBuilder b = new StringBuilder("rumble");
        b.append(4).deleteCharAt(3).delete(3, b.length() - 1);
        System.out.println(b);
    }
}
