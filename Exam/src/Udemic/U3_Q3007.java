package Udemic;

public class U3_Q3007 {
    private static int yesterday = 1;
    int tomorrow = 10;
    public static void main(String[] args) {
        U3_Q3007 tolls = new U3_Q3007();
        int today = 20, tomorrow = 40;                               // Line 6
        System.out.print(today + tolls.tomorrow + tolls.yesterday);  // Line 7
        // 31
    }
}
