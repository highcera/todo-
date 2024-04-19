package Udemic;

public class U5_003 {  // Choices {
    private boolean flag;
    private int number;
    public void show() {
        while (flag) {
            if (number % 2 == 0){
                number += 4;
                System.out.print(number + " ");
            } else {
                number *= 2;
                System.out.print(number + " ");
            }
            if (number > 16) break;
        }
    }
    public static void main (String[] args) {
        new U5_003().show();
    }
}
