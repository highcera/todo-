package Udemic;

public class U3_042 {
    public static void main(String[] dribble) {
        try {
            System.out.print(1);  // 1
            throw new ClassCastException();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.print(2);
        } catch (Throwable ex) {
            System.out.print(3);  // 3
        } finally {
            System.out.print(4);  // 4
        }
        System.out.print(5);      // 5
    }
}
