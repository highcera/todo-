package Udemic;

import java.util.Arrays;

public class U4_130 {
 public static void main(String[] args) {
        // String[] starr[] = new String[][] {  // Half C-style
        String[][] starr = new String[][] {
                {"X","","","X"},
                {"","X","",""},
                {"X","X","",""},
                {"","","X","X"}
        };
        System.out.println(Arrays.deepToString(starr));
        // [
        // [X,  ,  , X],
        // [ , X,  ,  ],
        // [X, X,  ,  ],
        // [ ,  , X, X]]
        starr[2][2] = "X";
        System.out.println(Arrays.deepToString(starr));
        // [
        // [X,  ,  , X],
        // [ , X,  ,  ],
        // [X, X, X,  ],
        // [ ,  , X, X]]
    }
}
