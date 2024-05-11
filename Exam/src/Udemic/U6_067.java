package Udemic;

class Counter {
    private int i;
    public void count() {
        while (i <= 1) {
            for (int i = 0; i <= 4; ) {
                System.out.print(i + " ");
                // 0 1 2 3 4 0 1 2 3 4 
                i++;
            }
            i++;
        }
    }
}
public class U6_067 {  // Caller
    public static void main (String args[]) {
        new Counter().count();
    }
}