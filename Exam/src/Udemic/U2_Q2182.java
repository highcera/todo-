package Udemic;

public class U2_Q2182 {
    public static void main (String[] args) {
        String str = null;
        StringBuilder sb = new StringBuilder(str += str);
        System.out.println(sb);         
        System.out.println(sb.capacity());    // nullnull
        System.out.println(sb.length());
        // sb.delete(0, sb.length());
        sb.setLength(0);
        System.out.println(sb);  
        System.out.println(sb.capacity());  // 24
    }
}
