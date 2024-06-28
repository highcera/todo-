package Udemic;

import java.util.Arrays;

public class U1_Q1168 {
    public static void main(String[] args) {
        try {
            String[] arr = new String[4];
            System.out.println(Arrays.toString(arr));
            // [null, null, null, null]
            arr[1] = "Unix";
            arr[2] = "Linux";
            arr[3] = "Solaris";
            for (String var : arr) {
                System.out.println(var + " ");
                // null
                // Unix
                // Linux
                // Solaris 
            }
        } catch (Exception e) {
            System.out.print(e.getClass());
        }
    }
}
