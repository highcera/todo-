package Udemic;

class Robot {
    static String weight = "A lot";
    /* default */
    double ageMonths = 5, ageDays = 2;
    private static boolean success = true;
    public void main(String[] args) {
        final String retries = "1";
        // P1
        // Class:
        System.out.println(weight);     // A lot
        System.out.println(success);    // true
        // Instance:
        System.out.println(ageMonths);  // 5.0
        System.out.println(ageDays);    // 2.0
        // Local:
        System.out.println(retries);    // 1
    }
}
public class U4_120 {
    public static void main(String[] args) {
        String[] arr = {"Hello", "World"};
        new Robot().main(arr);
    }
}