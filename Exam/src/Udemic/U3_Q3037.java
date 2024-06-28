package Udemic;

import java.util.Arrays;

public class U3_Q3037 {
     public static void main(String[] args) {
        String[][] astr = new String[2][];
        astr[0] = new String[2];
        astr[1] = new String[3];
        System.out.println(Arrays.deepToString(astr));
        // [[null, null], [null, null, null]]
        int a = 42;
        for (int i = 0; i < astr.length; i++) {
            for (int j = 0; j < astr.length; j++) {
                astr[i][j] = "" + a;
                a++;
            }
        }
        System.out.println(Arrays.deepToString(astr));
        // [[42, 43], [44, 45, null]]
        for (String[] e : astr) {
            for (String c : e) {
                System.out.print(c + " ");
                // 42 43
                // 44 45 null
            }
            System.out.println();
        }
 
        // To fill the whole array:
        a = 42;
        for (int i = 0; i < astr.length; i++) {
            for (int j = 0; j < astr[i].length; j++) {
                astr[i][j] = "" + a;
                a++;
            }
        }
        System.out.println(Arrays.deepToString(astr));
        // [[42, 43], [44, 45, 46]]
    }
}
