package Udemic;

// class Problem implements RuntimeException {}
// java: interface expected here
class Problem extends RuntimeException {} // interface X

public class U1_097 extends Problem {
    public static void main(String uhOh[]) {
        try {
            throw new U1_097();
        } catch (U1_097 re) {
            System.out.print("Problem?");
        } catch (Problem e) {
            System.out.print("Handled");
        } finally {
            System.out.print("Fixed!");
        }
    }
}