package Udemic;

public class U3_Q3102 {
    static int i;
    int j;
    public static void main(String[] args) {
        U3_Q3102 x1 = new U3_Q3102();
        U3_Q3102 x2 = new U3_Q3102();
        x1.i = 3;
        x1.j = 4;
        x2.i = 5;
        x2.j = 6;
        System.out.println(
                x1.i + " " +    // 5
                x1.j + " " +    // 4
                x2.i + " " +    // 5
                x2.j            // 6
        );
    }
}
