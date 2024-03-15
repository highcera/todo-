package Udemic;

public class U1_104 {
    public void playMusic() {
        System.out.print("Play!");
    }
    // private static int playMusic() {  // method playMusic() is already defined
    //     System.out.print("Music!");
    // }
    public static void main(String[] tracks) {
        U1_104 play = new U1_104();
        play.playMusic();
        // new U1_104.playMusic();
    }
}
