package Udemic;

public class U5_177 {
    public static void main(String[] args) {
        int i = 1;
        do {
            if (i % 2 == 0) continue;
            if (i == 5) break;
            System.out.print(i + "\t");
        } while (true);
    }
}
// Prints 1 infinite time