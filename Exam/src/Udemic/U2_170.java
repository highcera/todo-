package Udemic;

class A {
    String name;
    A obj;
    A(String name){
        this.name = name;
    }
}
class B extends A {
    B(String name) {
        super(name);
    }
}
class U2_170 {  // Test
    public static void main(String[] args) {
        A aa = new A("AA");
        A ab = new B("AB");               // Line 18
        B bb = new B("BB");
        aa.obj = ab;
        ab.obj = bb;
        ab = bb;                          // Line 22
        bb = null;                        // Line 23
        ab = null;                        // Line 24
        
        System.out.println(aa.obj.name);  // AB
    }
}