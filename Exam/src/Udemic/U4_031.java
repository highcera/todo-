package Udemic;

import java.util.Arrays;

public class U4_031 {
    public static void main(String[] args) {
        try {
            String[][] names = {{"Andre", "Mike"}, null, {"Pedro"}};
            System.out.println(Arrays.deepToString(names));
            // [[Andre, Mike], null, [Pedro]]
            System.out.println (names[2][1].substring(0, 2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(1);
        }
    }
}
