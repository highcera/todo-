package Udemic;

// class A {
//     public int x = 17;
//     A() {};
//     A(int z) {
//         System.out.println("A");
//     }
// }
// class B extends A{
//     int y;
//     B() {
//         y = super.x + 4;
//     }
//     B(int z) {
//         super(z);
//     }
// }
public class U4_156 {  // App 
    public static void main(String[] args) {
        B b1 = new B();
        System.out.println(b1.y);  // 21
        B b2 = new B(23);          // A
    }
}