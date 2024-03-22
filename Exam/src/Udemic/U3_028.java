package Udemic;

public class U3_028 {
    public static void main(String[] args) {
        int[] xx = null;
        for (int ii: xx) {  // NullPointerException
            System.out.println(ii);
        }
    }
}
