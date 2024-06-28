package Udemic;

public class U1_Q1028 {
    public void play() {
        System.out.print("play-");
    }
    public void finalizer() {
        System.out.print("clean-");
    }
    public static void main(String[] fun) {
        U1_Q1028 car = new U1_Q1028();
        car.play();  // play-
        System.gc();
        U1_Q1028 doll = new U1_Q1028();
        doll.play();  // play-
    }
}
