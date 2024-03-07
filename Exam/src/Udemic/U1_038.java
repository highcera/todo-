package Udemic;

public class U1_038 {
    public static void main(String[] args) {
        String a = "B ";
        a = a.concat("U ");
        System.out.println(a);  // B U
        String b = "L ";
        a = a.concat(b);
        System.out.println(a);  // B U L 
        a.replace('U', 'A');
        // a = a.replace('U', 'A');
        a = a.concat(b);
        System.out.println(a);  // B U L L
    }
}
