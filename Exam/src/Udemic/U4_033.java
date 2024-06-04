package Udemic;

class Parent{
    int a;
    public Parent(int a) {
        this.a = a;
    }
}
class U4_033 extends Parent {  // Child
    public static void main(String[] args) {}
    int b;
    public U4_033(int a, int b) {
        super(a);
        this.b = b;
    }
    // U4_033(int b) {this.a = b;}
    // U4_033() {}
    // U4_033(int a) {this.b = a;}

    U4_033(int c) {this(c = 1,c = 2);}
    // U4_033(int b) {super(Math.PI > Math.E ? 3 : 2);}
}
