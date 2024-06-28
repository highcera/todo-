package Udemic;

public class U1_084 {
    public static void main(String[] args) {
        Object obj = new Integer(3);
        String str = (String) obj;  // ClassCastException
        System.out.println(str);
    }
}
