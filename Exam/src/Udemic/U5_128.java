package Udemic;

public class U5_128 {
    public static void main(String[] args) {
        String arr[][] = new String[2][2];
        arr[0][0] = "0";
        arr[0][1] = "1";
        arr[1][0] = "false";
        arr[1][1] = "true";
 
        for (int index = 0; index < 2;) {
            for (int idx = 0; idx < 2;) {
                System.out.println(arr[index][idx]);
                // 0 1 false true
                idx++;
            }
            index++;
        }
 
//        for (String c : integers) {      // cannot find symbol
//            for (String s : booleans) {  // cannot find symbol
//                System.out.println(s);
//            }
//        }
 
        for (int index = 0; index < 2; ++index) {
            for (int idx = 0; idx < index; ++idx) {
                System.out.println(arr[index][idx]);  // false
            }
        }
 
        for (int index = 1; index < 2; index++) {
            for (int idx = 1; idx < 2; idx++) {
                System.out.println(arr[index][idx]);  // true
            }
        }
    }
}
