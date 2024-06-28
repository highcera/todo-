package Udemic;

public class U3_Q3049 {
    public static void main(String[] args) {
        int meal = 5;
        int tip = 2;
        int total = meal + (meal > 6 ? ++tip : --tip);
        System.out.println(tip);  // 1
    }
}
