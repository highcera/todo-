package Udemic;

import java.util.Arrays;

public class U6_043 {
    public static void main(String[] args) {
        int numbers[];
        numbers = new int[2];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers = new int[4];
        System.out.println(Arrays.toString(numbers));  // [0, 0, 0, 0]
        numbers[2] = 30;
        numbers[3] = 40;
        for (int x : numbers) {
            System.out.print(" " + x);  // 0 0 30 40
        }
    }
}
