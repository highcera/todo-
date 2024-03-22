package Udemic;

public class U3_047 {
    static int[] a = {1, 2, 3, 4};
    int[] b = {5, 6, 7, 8};
    public static void main(String[] args) {
        U3_047 t1 = new U3_047(), t2 = new U3_047();
        t1.a[3] = 10;
        t1.b[3] = 20;
        t2.a[3] = 30;
        t2.b[3] = 40;
        System.out.println (
                t1.a[3] + " " +  // 30
                t1.b[3] + " " +  // 20
                t2.a[3] + " " +  // 30
                t2.b[3]);        // 40
    }
}
