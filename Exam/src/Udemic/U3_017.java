package Udemic;

public class U3_017 {
    public static void main(String[] args) {
        for (int row = 4; row > 0; row--) {  // 4, 3, 2, 1
            int col = row;
            while (col <= 4) {
                System.out.print(col);
                // 4
                // 34
                // 234
                // 1234
                col++;
            }
            System.out.println();
        }
    }
}
