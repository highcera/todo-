package Udemic; // orchestra

interface MusicCreator { public Number play(); }
abstract class StringInstrument { public Long play() {return 3L;} }

public class U3_Q3134 extends StringInstrument implements MusicCreator { // Violin
    public Long play() {
        return null;
    }
    public static void main(String[] args) {
        U3_Q3134 test = new U3_Q3134();
        System.out.println(test.play());
    }
}