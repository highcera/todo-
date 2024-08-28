package Udemic;

public class U2_Q2034 {  //  Parent {
    public static void main(String[] args){
        Child c = new Child();
        U2_Q2034 p = new U2_Q2034();
        p = c;
        System.out.println("parent: " + p.getClass());
        // parent: class test.Child
        System.out.println("child: " + c.getClass());
        // child: class test.Child
    }
}

class Child extends U2_Q2034 {}