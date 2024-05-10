package Udemic;

public class U5_120 {
    public static void main(String[] args) {
        int i, j = 0;
        
        i = (3 * 2 + 4 + 5);
        i = ((3 * 2) + 4 + 5);
        i = (6 + 4 + 5);  // -> 15
 
        j = (3 * (2 + 4) + 5);
        j = (3 * 6 + 5);
        j = ((3 * 6) + 5);
        j = (18 + 5);  // -> 23
        
        System.out.println("i: " + i + "\nj: " + j);
        // i: 15
        // j: 23
    }
}
