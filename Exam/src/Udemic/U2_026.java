package Udemic;

class Painter {
    int age = 20;
    Painter() {
    }
    Painter(int age) {
        this.age = age;
    }
}
public class U2_026 extends Painter { // Picasso
    int age;
    U2_026() {
        super();                              // Line p1
        // this(90);                          // Line p2
    }
    U2_026(int age) { this.age = age; }      // Line p3
    public String toString() {
        return super.age + " : " + this.age;
    }
    public static void main(String[] args) {
        // code fragment goes in here

        Painter p = new U2_026();
        System.out.println(p);
    }
}
