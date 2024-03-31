package Udemic;

public class Parent {
    // Parent() {
    protected Parent() {
        System.out.println("Hello");
    }
}
 
package child;

import Udemic.Parent;

public class U2_014 extends Parent {
    private U2_014() { }
    public static void main (String[] args) {
        new U2_014();
    }
}