package Udemic;

class Canine {}
class Dog extends Canine {}
class Wolf extends Canine {}
final class Husky extends Dog {}
public class U3_Q3133 { // Zoologist
    Canine animal;
    public final void setAnimal(Dog animal) { this.animal = animal; }
    public static void main(String[] furryFriends) {
        new U3_Q3133().setAnimal(new Dog());
        new U3_Q3133().setAnimal(new Husky());
        new U3_Q3133().setAnimal(null);
        // new U3_130().setAnimal(new Wolf());  // Required Dopg
  }
}