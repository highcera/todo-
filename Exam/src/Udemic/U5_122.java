package Udemic;

import java.util.Arrays;

public class U5_122 {
    public static void main(String[] args) {
        int eArr1[] = {10, 23, 10, 2};
        int[] eArr2 = new int[10];
        int[] eArr3 = new int[] {};
        // When you write a number in the square brackets,
        // you can not also use the curly braces:
        // int[] eArr4 = new int[10] {};
        // int eArr5[] = new int[2] {10, 20};

        System.out.println(Arrays.toString(eArr1));
        System.out.println(Arrays.toString(eArr2));
        System.out.println(Arrays.toString(eArr3));
    }
}
