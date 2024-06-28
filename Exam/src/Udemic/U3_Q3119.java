package Udemic;

public class U3_Q3119 {
    public static void main(String[] args) {}
    final String value1 = "1";
    static String value2 = "2";
    String value3 = "3";
    {
        value2 = "e";
        value3 = "f";
 
        // cannot assign a value to final variable value1:
        // value1 = "d";
    }
    static {
        value2 = "h";
 
        // non-static variable value1 cannot be referenced
        // from a static context:
        // value1 = "g";
        // value3 = "i";
    }
}
