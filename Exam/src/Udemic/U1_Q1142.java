package Udemic;

// class Problem implements RuntimeException {}
// java: interface expected here
class Problem extends RuntimeException {} // interface X

public class U1_Q1142 extends Problem {
    public static void main(String uhOh[]) {
        try {
            throw new U1_Q1142();
        } catch (U1_Q1142 re) {
            System.out.print("Problem?");
        } catch (Problem e) {
            System.out.print("Handled");
        } finally {
            System.out.print("Fixed!");
        }
    }
}