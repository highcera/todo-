package Udemic;

public class U6_147 {
    public static void main(String[] args) {
        String b = "12";
        b += "3";
        // b.reverse();
        // cannot find symbol method reverse()
        System.out.println(b.toString());
        StringBuilder sb = new StringBuilder("12");
        sb.append("3");
        sb.reverse();
        System.out.println(sb);  // 321
    }
}
