package Udemic;

public class U3_096 {
    public static String play(int toy, int age) {
        final String game;
        if (toy < 2)
            // game = age > 1 ? 1 : 10;        // p1
            game = "Test";
        else
            game = age > 3 ? "Ball" : "Swim";  // p2
        return game;
    }
 
    public static void main(String[] variables) {
        // System.out.print(play(5,2));
        System.out.print(play(1,2));
    }
}
