package Udemic;

public class U1_Q1034 {
    public static void main(String[] args) {
        double[] darr = {11, 22.0, 'a', 33.0f};
        for (double e : darr) {
            e = e + 10;
            System.out.print(e + " ");
            // 21.0 32.0 107.0 43.0 
        }
    }
}
