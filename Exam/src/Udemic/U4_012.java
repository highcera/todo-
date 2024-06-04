package Udemic;

public class U4_012 {  //  Test2 {
    int fvar;
    static int cvar;
    public static void main(String[] args) {
        U4_012 t = new U4_012();
 
        // this.fvar = 200;
        // non-static variable this cannot
        // be referenced from a static context
 
        // fvar = 200;
        // non-static variable fvar cannot
        // be referenced from a static context
 
        t.fvar = 200;
        cvar = 400;
 
        t.fvar = 200;
        t.cvar = 400;
        // Static member 'cvar' accessed via instance reference
    }

}
