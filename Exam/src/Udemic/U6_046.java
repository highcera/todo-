package Udemic;

interface A {}
class U6_046 implements A {  // B 
    @Override
    public String toString() { return "Hello from B!"; }
    public static void main(String[] args) {
        C objC = new C();  // Here the object type C is determined.
        U6_046 objB = objC;
        A objA = objB;  // Here the reference type A is determined.
        System.out.println(objA);  // Hello from C!
    }
}
class C extends U6_046 {
    @Override
    public String toString() { return "Hello from C!"; }
}