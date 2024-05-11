package Udemic;

public class U6_019 {
    public static void main(String[] args) {
        // switch works without default:
        int x = (int) (Math.random() * 2);
        switch (x) {
            case 0:
                System.out.println("Hello");
                break;
            case 1:
                System.out.println("World");
        }
 
        // default can be before case:
        int y = (int) (Math.random() * 2);
        switch (y) {
            default:
                System.out.println("Hello");
                break;
            case 1:
                System.out.println("World");
        }
 
        // default can be alone:
        int z = (int) (Math.random() * 2);
        switch (z) {
            default:
                System.out.println("Hello");
                break;
        }
    }
}
