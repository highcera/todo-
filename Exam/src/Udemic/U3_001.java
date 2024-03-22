package Udemic;

public class U3_001 {
    private int x = 0;
    private int y = 0;
    public static void main(String[] args) {
        U3_001 accApp = new U3_001();
        accApp.printThis(1, 2);
        accApp.printThat(3, 4);
    }
    public void printThis(int x, int y) {
        x = x;
        y = y;
        System.out.println("x: " + this.x + " y: " + this.y);
        // x: 0 y: 0
    }
    public void printThat(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("x: " + this.x + " y: " + this.y);
        // x: 3 y: 4
    }
}
