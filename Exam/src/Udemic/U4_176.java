package Udemic;

class Pokemon {
    String name;
    Pokemon(){
        this("Undefined");                       // Line p1
    }
    Pokemon(String name) {
        this.name = name;
    }
}
class Pikachu extends Pokemon {
    String sound;
    Pikachu() {
        super("Pikachu");
        // this("Squeak squeak!");               // Line p2
        // java: call to this must be first statement in constructor
    }
    Pikachu(String sound) {
        this.sound = sound;
    }
    public String toString() {
        return super.name + " says " + this.sound;
    }
}
class U4_176 {  // Test
    public static void main(String[] args) {
        Pokemon p = new Pikachu();
        System.out.println(p);
    }
}
