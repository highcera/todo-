package Udemic;

public class U2_027 {
    public static void main(String[] args) {
        int x = 1, y = 15;            // Line 3
        // while x < 10               // Line 4
        // while (x < 10) 
        //     y--;
        //     x++;                      // Line 4
        while (x < 10) {
            y--;
            x++;
        }               // Line 4
        
        System.out.println(x+", "+y);
    }
}
