package Udemic;

public class U4_133 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        for (int e : array) {
            if (e < 1) {
                continue;
            }
            System.out.print(e);  // 12345
            // if (e == 2 || e == 3) {
            //     continue;
            // }
        }
    }
}
