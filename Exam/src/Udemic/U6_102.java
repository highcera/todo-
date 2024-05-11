package Udemic;

public class U6_102 {
    static void dispResult(int[] num) {
        try {
            System.out.println(num[1] / (num[1] - num[2]));
        } catch (ArithmeticException e) {
            System.out.println("First exception");
        }
        System.out.println("Done");
    }
    public static void main(String[] args) {
        try {
            int[] arr = {100, 100};
            dispResult(arr);
        } catch (IllegalArgumentException e) {
            System.err.println("Second exception");
        } catch (Exception e) {
            System.out.println("Third exception");  // Third exception
            System.out.println(e);  // ArrayIndexOutOfBoundsException
        }
    }
}
