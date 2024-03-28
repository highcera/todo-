package Udemic;

import java.util.Arrays;

public class U3_076 { // ArrayTest
        public static void main(String args[]){
        String[][][] array = new String[][][]
                {{{"a","b","c"},{"d","e","f"}}, {{"g"}, null},
                        {{"y"}}, {{"z", "Q1000_1999"}, {}}};
        System.out.println(Arrays.deepToString(array));
        // [
        //      [
        //          [a, b, c],
        //          [d, e, f]
        //      ],
        //      [
        //          [g],
        //          null
        //      ],
        //      [
        //          [y]
        //      ],
        //      [
        //          [z, Q1000_1999],
        //          []
        //      ]
        //  ]
        System.out.println(Arrays.toString(array[0][0]));  // [a, b, c]
        System.out.println(Arrays.toString(array[0][1]));  // [d, e, f]
        System.out.println(Arrays.toString(array[1][0]));  // [g]
        System.out.println(Arrays.toString(array[1][1]));  // null
        System.out.println(Arrays.toString(array[2][0]));  // [y]
        System.out.println(Arrays.toString(array[3][0]));  // [z, Q1000_1999]
        System.out.println(Arrays.toString(array[3][1]));  // []
    }
}
