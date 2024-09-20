package Udemic;

public class U2_Q2067 {
    public static void main(String[] args) {
        int[][] nums1 = new int[2][1];
        System.out.println(nums1[0][0]);  // 0
        System.out.println(nums1[1][0]);  // 0
 
        int[] nums2[] = new int[2][1];
        System.out.println(nums2[0][0]);  // 0
        System.out.println(nums2[1][0]);  // 0
 
        int[] nums3[] = new int[][] { { 0 }, { 0 } };
        System.out.println(nums3[0][0]);  // 0
        System.out.println(nums3[1][0]);  // 0
 
        int[] nums4[] = new int[][] { { 0, 0 } };
        System.out.println(nums4[0][0]);  // 0
        System.out.println(nums4[0][1]);  // 0
    }
}
