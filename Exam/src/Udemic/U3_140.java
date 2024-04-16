package Udemic;

interface Jumpable {}
class Animal {}
class U3_140 extends Animal implements Jumpable {  // Lion
    public static void main(String[] args) {
        Animal var2 = new Animal();
        Jumpable var5 = new U3_140();
 
        // A normal interface can not be intantiated:
        // Jumpable var1 = new Jumpable();
 
        // The subclass can not be the reference type:
        // Lion var3 = new Animal();
 
        // Animal doesn't implement the interfave Jumpable:
        // Jumpable var4 = new Animal();
        // Jumpable var6 = (Jumpable)(new Animal());
    }
}