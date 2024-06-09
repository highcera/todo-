package Udemic;

public class U4_190 {  // Bicycle {
    String color = "red";
    private void printColor(String color) {
        color = "purple";
        System.out.print(color);  // purple
    }
    public static void main(String[] rider) {
        new U4_190().printColor("blue");
    }
}
