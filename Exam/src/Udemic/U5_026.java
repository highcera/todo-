package Udemic;

public class U5_026 {
    static int[][] game;
    public static void main(String[] args) {
        game[3][3] = 6;
        Object[] obj = game;
        // game[3][3] = "X";
        // incompatible types: String cannot be converted to int
        System.out.println(game[3][3]);
    }
}
