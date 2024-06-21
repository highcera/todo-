package Udemic;

public class U4_076 {  // NameCheck {
    public static void main(String... data) {
        String john = "john";
        String jon = new String(john);
        System.out.print((john==jon)+" "+(john.equals(jon)));
        // false true
    }

}
