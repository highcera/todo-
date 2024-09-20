package Udemic;

public class U2_Q2079 { // Calculator
    public static void main(String[] args) {
        int num = 5;
        int sum;
        // int sum = 0;
        do {
            sum += num;
            // sum = sum + num;
        } while ((num--) > 1);
        System.out.println("The sum is " + sum + ".");
    }

}
