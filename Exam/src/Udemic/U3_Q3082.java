package Udemic;

public class U3_Q3082 {
    public static void main(String[] args) {
        for (int ii = 0; ii < 3; ii++) {      // 0 - 1 - 2
            int count = 0;
            for (int jj = 3; jj > 0; jj--) {  // 3 - 2 - 1
                if (ii == jj) {
                    ++count;
                    break;
                }
            }
            System.out.println(count);
            // 0
            // 1
            // 1
            continue;
        }
    }
}
