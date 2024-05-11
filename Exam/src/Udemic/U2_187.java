package Udemic;

public class U2_187 {  //  Parent {
    public static void main(String[] args){
        Child c = new Child();
        U2_187 p = new U2_187();
        p = c;
        System.out.println("parent: " + p.getClass());
        // parent: class test.Child
        System.out.println("child: " + c.getClass());
        // child: class test.Child
    }
}

class Child extends U2_187 {}