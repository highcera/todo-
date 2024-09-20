package Udemic;

public class U2_Q2091 {
    public static void main(String[] args) {
        int i = 0;
        for(;;) {
            // if (i > 10) break; // if문 없으면 무한루프
            i++;
        }                               // Line 4
        if (i == Integer.MAX_VALUE)
        System.out.println("Done! " + ++i);
    }
}
