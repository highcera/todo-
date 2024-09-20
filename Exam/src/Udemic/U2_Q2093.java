package Udemic;

public class U2_Q2093 {
    public static void main(String[] args) {
        for (int row = 3; row > 0; row--) {
            int column = row;
            while (column <= 3) {
                System.out.print(column);
                // 3
                // 23
                // 123
                column++;
            }
            System.out.println();
        }
    }
}
