package Udemic;

public class U5_021 {
    public static void main(String[] args) {
        System.out.println( 10 + 5 == 4 + 11);  // true
        System.out.println( 15 == 15);          // true
 
        // System.out.println( 10 + (5 == 4) + 11);
        // bad operand types for binary operator '+'
 
        System.out.println( "" + (5 <= 4) + "" );  // false
        System.out.println( "" + false + "" );     // false
        System.out.println( ("" + false) + "" );   // false
        System.out.println( "false" + "" );        // false
        System.out.println( "false" );             // false
 
        System.out.println( "" + 10 + 5 == 4 + 11 + "");    // false
        System.out.println( ("" + 10) + 5 == 4 + 11 + "");  // false
        System.out.println( "10" + 5 == 4 + 11 + "");       // false
        System.out.println( ("10" + 5) == 4 + 11 + "");     // false
        System.out.println( "105" == 4 + 11 + "");          // false
        System.out.println( "105" == (4 + 11) + "");        // false
        System.out.println( "105" == 15 + "");              // false
        System.out.println( "105" == (15 + ""));            // false
        System.out.println( "105" == "15");                 // false
        System.out.println( false );                        // false
    }
}
