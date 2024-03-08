package Udemic;

public class U1_063 {
    public static void main(String[] args) {
        String[] letters = {"a", "b", "c", "d", "e", "f"};
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i]);  // abcdef
        }
        System.out.println();
        for (int i = letters.length-1; i >= 0; i--) {
            System.out.print(letters[i]);  // fedcba
        }
        System.out.println();
        for (int i = 0; i < letters.length; i += 2) {
            System.out.print(letters[i]);  // ace
        }
        System.out.println();
        for (String letter : letters) {
            System.out.print(letter);  // abcdef
        }
        System.out.println();
    }
}
