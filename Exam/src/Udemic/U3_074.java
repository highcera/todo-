package Udemic;

class Emp {
    Emp mgr = new Emp();  // StackOverflowError
}
class U3_074 { // Office
    public static void main(String args[]) {
        Emp e = null;
        e = new Emp();                          // Line 7
        e = null;                               // Line 8
    }                                           // Line 9
}