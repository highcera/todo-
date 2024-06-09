package Udemic;

import java.util.Arrays;

public class U4_111 {
 public static void main(String[] args) {
        String[] os = new String[] { "Mac", "Linux", "Windows" };
        Arrays.sort(os);
        System.out.println(Arrays.binarySearch(os, "RedHat"));  // -3
    }
}
