package Udemic;

public class U6_119 {
    public static void main(String[] args) {
        int x = 353;
        int j = x++;
        switch (j) {
            case 317:
            // case 353:  // duplicate case label
            case 367:
                System.out.println("Is a prime number.");
            case 353:
            case 363:
                System.out.println("Is a palindrome.");
                break;
            default:
                System.out.println("Invalid value.");
        }
    }
}
