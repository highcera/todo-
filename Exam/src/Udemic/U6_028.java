package Udemic;

public class U6_028 {
    public static void main(String[] args) {
        int ctr = 10;
        char[] arrC1 = new char[]{'P','a','u','l'};
        char[] arrC2 = {'H','a','r','r','y'};
        for (char c1 : arrC1) {
            for (char c2 : arrC2) {
                if (c2 == 'a') break;
                ++ctr;
                    System.out.printf("C1: %c C2: %c ctr: %d \n", c1,c2,ctr);
            }
        }
        System.out.println(ctr);  // 14
        // ctr = 10;
        // for (char c1 : arrC1)
        //     for (char c2 : arrC2) {
        //         if (c2 == 'a') break;
        //         ++ctr;
        //         System.out.printf("C1: %c C2: %c ctr: %d \n", c1,c2,ctr);
        //     }
        // System.out.println(ctr);  // 14
        // ctr = 10;
        // for (char c1 : arrC1)
        //     for (char c2 : arrC2)
        //         if (c2 == 'a') break;
        // ++ctr;
        // System.out.printf("C1: %c C2: %c ctr: %d \n", c1,c2,ctr);
        // System.out.println(ctr);  // 11

        // ctr = 10;
        // for (char c1 : arrC1) { 
        //     for (char c2 : arrC2) {
        //         if (c2 == 'a') continue;
        //         ++ctr;
        //         System.out.printf("C1: %c C2: %c ctr: %d \n", c1,c2,ctr);
        //     }
        // }
        // System.out.println(ctr);  // 26
    }
}
