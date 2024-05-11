package Udemic;

public class U6_129 {
    public static void main(String[] args){
        int[][] array2D = new int[3][4];
        System.out.println("Setting:");
        for (int a = 0; a < array2D.length; a++) {
            for (int b = 0; b < array2D[0].length; b++) {
                array2D[a][b] = a + b;
                System.out.println("[" + a + "][" + b + "]=" + 
                                   array2D[a][b]);
            }
        }
        System.out.println("Modifying:");
        for (int a = 0; a < array2D.length; a++) {
            for (int b = 0; b < array2D[0].length; b++) {
                array2D[a][b] = array2D[a][b] * 2;
                System.out.println("[" + a + "][" + b + "]=" +
                                   array2D[a][b]);
            }
        }
    }
}
