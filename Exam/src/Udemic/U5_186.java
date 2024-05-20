package Udemic;

public class U5_186 {
    public static void main(String[] args) {
        // char[][] ticTacToe = new char[3, 3];               // Line r1
        char[][] ticTacToe = new char[3][3];                  // Line r1
        ticTacToe[1][3] = 'X';   //  0~2                      // Line r2
        ticTacToe[2][2] = 'X';   //  0~2
        ticTacToe[3][1] = 'X';   //  0~2
        System.out.println(ticTacToe.length + " in a row!");  // Line r3
    }
}
