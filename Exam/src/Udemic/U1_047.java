package Udemic;

public class U1_047 {
    public static void main(String[] args) {
        String friend = "Alice";
        switch(friend) {
            case "Alice":
                System.out.println("Hi Alice!");
                // Hi Alice!
            case "Bob":
                System.out.println("Hi Bob!");
                // Hi Bob!
                break;
            case "Carol":
                System.out.println("Hi Carol!");
                break;
            default:
                System.out.println("Hello stranger!");
        }
    }
}
