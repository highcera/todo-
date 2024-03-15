package Udemic;

public class U1_114 {
    public static void main(String[] args) {
        // int[] arr = new int[]{2013, 2014, 2015, 2016, 2015};
        int[] arr = {2013, 2014, 2015, 2016, 2015};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 2015) continue;
            count++;
        }
        System.out.println(count + " found!");  // 2 found!
    }
}
