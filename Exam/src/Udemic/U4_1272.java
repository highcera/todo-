package Udemic;

class Animal {
    // public void printKing() {               // Line 2
    void printKing() {                         // Line 2
        System.out.println("Lion");
    }
}
public class U4_1272 {  // Forest
    public static void main(String... args) {
        Animal anAnimal = new Animal();
        // anAnimal.printKing();            // Lion
        System.out.println(anAnimal);
        anAnimal.printKing();
    }
}