package Udemic;

public class U1_Q1054 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Same");
        String str = "Same";
        // System.out.println(sb.equals(str));
        if (sb.equals(str)) {
            System.out.println("Same 1");
        } else if (sb.toString().equals(str)) {
            System.out.println("Same 2");       // Same 2
        } else {
            System.out.println("Different");
        }
    }
}