package Udemic;

import java.util.Arrays;

public class U5_047 {
    public static void main(String[] args) {
        String[][] arra = new String[3][];
        arra[0] = new String[]{"rose", "lily"};
        arra[1] = new String[]{"apple", "cherry", "grapes"};
        arra[2] = new String[]{"beans", "carrot", "potato"};
 
        // Works fine:
        for (int i = 0; i < arra.length; i++) {
            for (int j = 0; j < arra[i].length; j++) {
                arra[i][j] = arra[i][j].toUpperCase();
            }
        }
 
        // ArrayIndexOutOfBoundsException,
        // because not all inner arrays have three elements:
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 4; j++) {
//                arra[i][j] = arra[i][j].toUpperCase();
//                // ArrayIndexOutOfBoundsException
//            }
//        }
 
        // Compile errors because of arra[][] & a[]
        // Would also not change the array,
        // because the enhanced for loop doesn't write back to the array:
//        // for (String a[] : arra[][]) {
//        for (String a[] : arra) {
//            // for (String x : a[]) {
//            for (String x : a) {
//                x = x.toUpperCase();
//            }
//        }
 
        // Compile error because of among other things
        // the wrong use of for:
//        for (int i : arra.length) {
//            for (String x : arra) {
//                arra[i].toUpperCase();
//            }
//        }
 
        System.out.println(Arrays.deepToString(arra));
        // [[ROSE, LILY], [APPLE, CHERRY, GRAPES],
        // [BEANS, CARROT, POTATO]]
    }
}
