package Udemic;

public class U6_032 {  // Rope {
    public static void swing() {
        System.out.print("swing ");
    }
    public void climb() {
        System.out.println("climb ");
    }
    public static void play() {
        swing();
        // non-static method climb() cannot
        // be referenced from a static context:
        // climb();
    }
    public static void main(String[] args) {
        U6_032 rope = new U6_032();
        rope.play();   // swing 
        U6_032 rope2 = null;
        rope2.play();  // swing 
    }
}
