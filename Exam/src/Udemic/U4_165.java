package Udemic;

class Parent {
    Parent() {
        System.out.println("Parent");
    }
}
class Child extends Parent {
    Child() {
        super();
        System.out.println("Child");
    }
}
public class U4_165 {
    public static void main(String[] args) {
        Parent p = null;
        Child c = null;
        p = (Child) new Child();
        p = new Child();
        // c = (Child) new Parent();  // ClassCastException
        c = new Child(); p = c;
 
        // c = new Parent();
        // p = new Parent(); c = p;
    }
}