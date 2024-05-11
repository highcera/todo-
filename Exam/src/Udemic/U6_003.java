package Udemic;

class U6_003 {  // WhichOne
    public static void run(int x, int y) {
        System.out.println("working with int: " + (x + y));
    }
    public static void run(Integer x, Integer y) {
        System.out.println("working with Integer: " + (x + y));
    }
    public static void run(float x, float y) {
        System.out.println("working with float: " + (x + y));
    }
    public static void run(double x, double y) {
        System.out.println("working with double: " + (x + y));
    }
    public static void main(String[] args) {
        run(1, 2);  // working with int: 3
        run(1.0, 2.0);  // working with double: 3.0
        run(1.0F, 2.0F);  // working with float: 3.0
        Integer x = 1;
        Integer y = 2;
        run(x, y);  // working with Integer: 3
    }
}