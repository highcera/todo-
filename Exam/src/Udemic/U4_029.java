package Udemic;

public class U4_029 {
    public static void main(String[] args) {
        String myTestVariable = "Hello";
        System.out.println(myTestVariable.equals(null));  // false
    }
}
// if myTestVariable was null, then the code would still compile but throw a
// NullPointerException calling equals() at runtime

