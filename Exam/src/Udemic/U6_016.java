package Udemic;

public class U6_016 {  // public class Toy {
    public void play() {
        System.out.print("play-");
    }
    public void finalize() {
        System.out.print("clean-");
    }
    public static void main(String[] args) {
        U6_016 car = new U6_016();
        car.play();
        System.gc();
        U6_016 doll = new U6_016();
        doll.play();
    }
}