package Udemic;

import java.util.Arrays;

public class U4_071 {  // App {
    public static void main(String[] args) {
        // int iArray[] = {65, 68, 69};  // C-style
        int[] iArray = {65, 68, 69};
        iArray[2] = iArray[0];
        System.out.println(Arrays.toString(iArray));  // [65, 68, 65]
        iArray[0] = iArray[1];
        System.out.println(Arrays.toString(iArray));  // [68, 68, 65]
        iArray[1] = iArray[2];
        for (int element : iArray) {
            System.out.print(element + " ");  // 68 65 65
        }
    }
}