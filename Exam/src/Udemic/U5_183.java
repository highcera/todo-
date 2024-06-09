package Udemic;

public class U5_183 {
    String str = "";
    static void pass(String str) {
        str.concat("Passed");        
    }
    // static String pass(String str) {
    //     // str.concat("Passed");
    //     str = str.concat("Passed");
    //     return str;
    // }
    public static void main(String[] args) {
        String str = "Failed ";
        pass(str);
        System.out.println(str);  // Failed 
    }
}
