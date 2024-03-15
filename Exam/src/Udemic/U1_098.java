package Udemic;

public class U1_098 {
    public void play() {
        System.out.print("play-");
    }
    public void finalizer() {
        System.out.print("clean-");
    }
    public static void main(String[] fun) {
        U1_098 car = new U1_098();
        car.play();  // play-
        System.gc();
        U1_098 doll = new U1_098();
        doll.play();  // play-
    }
}
