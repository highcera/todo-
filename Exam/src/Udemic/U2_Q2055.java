package Udemic;

public class U2_Q2055 {  
    // With the conditional operator there always
    // need to be as many colons as question marks.
    public static void main(String[] args) {
        int x = 10;
        int y = x--;
        int z = --y;
        int a = x++;
        // int b = x < y ? x < z ? x : y < z ? y : z;
        int b = x < y
                    // ? x < z
                        ? x
                        : y < z
                            ? y
                            : z;
        System.out.println(b);  // 9
        b = x < y
                ? x < z
                    ? x
                    : y < z
                        ? y
                        : z
                : y;
        System.out.println(b);  // 9
    }
}
