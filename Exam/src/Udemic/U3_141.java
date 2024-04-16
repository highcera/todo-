package Udemic;

public class U3_141 {
    public static void main(String[] args) {
        int a = 19;
        boolean bool1 = false, bool2 = true;
 
        bool1 = ( 1.5 != (float) 1.5 ) || ( bool1 = true );
        bool1 = ( false ) || ( bool1 = true );
        bool1 = ( false ) || ( true );
        bool1 = ( true );
 
        bool2 = ( ++a == a++ ) && ( !bool1 );
        System.out.println(++a == a++);        // true
        bool2 = ( true ) && ( !bool1 );
        bool2 = ( true ) && ( false );
        bool2 = ( false );
 
        System.out.println("bool1:"+ bool1 + ", bool2:" + bool2);
        // bool1:true, bool2:false
    }
}
