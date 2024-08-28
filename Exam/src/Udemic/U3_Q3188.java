package Udemic;

public class Q3188 {
    public static void main(String[] args) {
        int total = 0;
        StringBuilder letters = new StringBuilder("abcdefg");
        total += letters.substring(1, 2).length();      // Line 6
        total += letters.substring(6, 6).length();      // Line 7
        // StringIndexOutOfBoundsException:
        // total += letters.substring(6, 5).length();   // Line 8
        System.out.println(total);
    }
}
