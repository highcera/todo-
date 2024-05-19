package Udemic;

public class U6_176 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("red");
        sb.deleteCharAt(0);
        sb.delete(1, 2);
        System.out.println(sb);  // e
    }
}
