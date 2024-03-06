package Udemic;

public class U1_015 {
    public static void main(String[] args) {
        int luck = 10;
        if ((luck>10 ? luck++ : --luck)<10) {
            System.out.print("Bear");           // Bear
        }                                       // Line 6
        if(luck<10) System.out.print("Shark");  // Shark
    }
}
