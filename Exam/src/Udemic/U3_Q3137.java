package Udemic;

class U3_Q3137 {  // Parent
    public static void main(String[] args) {
        Child c = new Child();
        U3_Q3137 p = new U3_Q3137();
        p = c;
        System.out.print("p: " + p.getClass().getSimpleName() + ", ");
        // p: Child, 
        System.out.println("c: " + c.getClass().getSimpleName());
        // c: Child
    }
}
class Child extends U3_Q3137 {}