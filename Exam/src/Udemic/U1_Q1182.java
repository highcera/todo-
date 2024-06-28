package Udemic;

public class U1_Q1182 {
    public static void main (String[] args) {
        Object obj = null;
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        System.out.println(sb.length());          // 4
        System.out.println(sb);                   // null
        System.out.println(String.valueOf(obj));  // null
    }
}
