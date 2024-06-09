package Udemic;

interface Jump {}
class Animal implements Jump {}
public class U4_124 {
    public static void main(String[] args) {
        Jump[] eJump3 = new Jump[10];
        // The implemented interface can be the reference type:
        Jump eJump1[] = {null, new Animal()};
        Jump[] eJump4 = new Animal[87];
        // There are no parentheses between the class name
        // and the square brackets:
        // Jump[] eJump2 = new Animal()[22];
        // Jump[] eJump5 = new Jump()[12];
    }
}