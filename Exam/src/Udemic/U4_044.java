package Udemic;

interface SpeakDialogue { default int talk() { return 7; } }
interface SingMonologue { default int talk() { return 5; } }
public class U4_044 implements SpeakDialogue, SingMonologue {  // Performance
    public int talk(String... x) {
        return x.length;
    }
    Performance needs to override int talk()
    public int talk() {
        return 23;
    }
    public static void main(String[] notes) {
        System.out.print(new U4_044().talk(notes));
    }
}