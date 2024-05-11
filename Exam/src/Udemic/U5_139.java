package Udemic;

public class U5_139 {
    public static void main(String[] args) {
        String[] colors = {"red", "blue", "green", "yellow", "maroon", "cyan"};
        for (String c: colors) {
            if (c.length() != 4) {
                continue;
            }
            System.out.print(c + ", ");  // blue, cyan,
        }
        System.out.println();
 
        for (String c: colors) {
            if (c.length() <= 4) {
                continue;
            }
            System.out.print(c + ", ");  // green, yellow, maroon,
        }
        System.out.println();
        
        for (String c: colors) {
            if (c.length() != 4) {
                System.out.print(c + ", ");
                // red, green, yellow, maroon,
                continue;
            }
        }
 
        // for (String c: String[] colors) {}  // '.class' expected
    }
}
