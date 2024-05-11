package Udemic;

public class U3_151 {  // Loop
    public static void main(String[] args) {
        int i = 0, j = 4;
        int x = 3, y = 0, z = 5;
        for (i = 0; i < x; i++) {
            do {
                int k = 0;
                while (k < z) {
                    System.out.print(k + " ");
                    k++;
                }
                System.out.println("");
                j--;
            } while (y >= j);
            System.out.println("---------");
        }
    }
}
