package Udemic;

public class U3_039 {
    public static void main(String[] args) {
        // This is not the only valid loop construct;
        // there exists another form of for loop constructor.
        // True
        int[] arr = {1, 2, 3};
        for (int a : arr) {
            System.out.println(a);
        }
        // When expr2 evaluates to false, the loop terminates.
        // It is evaluated before each iteration through the loop.
        // True
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        // The expression expr1 is optional.
        // False
        // The semicolon is part of the expression
        // and therefore the expression is not optional.
        // At least The semicolon has to be there.
        int j = 0;
        for (; j < 3; j++) {
            System.out.println(j);
        }
        // The expression expr3 must be present.
        // False
        for (int i = 0; i < 3; ) {
            System.out.println(i);
            i++;
        }
    }
}
