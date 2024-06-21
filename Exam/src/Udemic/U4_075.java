package Udemic;

public class U4_075 {
    public static void dancing() throws RuntimeException {
        try {
            throw new IllegalArgumentException();
        // } catch (Error) {  // java: <identifier> expected
        } catch (Throwable t) {
            System.out.print("Unable!");
        }
    }
    public static void main(String... count) throws RuntimeException {
        dancing();
    }
}
