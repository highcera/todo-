package Udemic;

public class U3_Q3115 {
    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd;                                 // Line 3
    }
    public static void main(String[] args) {
        int a = 15;
        int b = 10;
        U3_Q3115.addToInt(a, b);                        // Line 8
        System.out.println(a);  // 15
    }
}
