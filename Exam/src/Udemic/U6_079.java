package Udemic;

interface Nocturnal {
    default boolean isBlind() { return true; }
}
public class U6_079 implements Nocturnal { // Owl
    public boolean isBlind() { return false; }
    public static void main(String[] args) {
        Nocturnal nocturnal = (Nocturnal)new U6_079();
        System.out.println(nocturnal.isBlind());  // false
    }
}