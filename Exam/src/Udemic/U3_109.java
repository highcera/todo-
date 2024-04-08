package Udemic;

public class U3_109 {
    public static void main(String[] args) {
        String[][] matrix = new String[1][2];
        matrix[0][0] = "Don't think you are, know you are.";       // m1
        matrix[0][1] = "I'm trying to free your mind Neo";         // m2
        // ArrayIndexOutOfBoundsException:
        // matrix[1][0] = "Is all around you ";                       // m3
        // matrix[1][1] = "Why oh why didn't I take the BLUE pill?";  // m4
    }
}
