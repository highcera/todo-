package Udemic;

public class U6_010 {
    public static void main(String[] args) {
        int result = 8;
        // for: while (result > 7) {
        forLabel: while (result > 7) {
            result++;
            do {
                result--;
            } while (result > 5);
            // break for;
            break forLabel;
        }
        System.out.println(result);
    }
}
