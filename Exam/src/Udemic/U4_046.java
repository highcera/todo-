package Udemic;

import java.util.Arrays;

public class U4_046 {
  public static void main(String[] args) {
        String[] os = new String[] { "Mac", "Linux", "Windows" };
        Arrays.sort(os);
        System.out.println(Arrays.toString(os));  // [Linux, Mac, Windows]
        System.out.println(Arrays.binarySearch(os, "Mac"));  // 1
    }
}
