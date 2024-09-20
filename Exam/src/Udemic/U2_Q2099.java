package Udemic;

class Cake {
    int model;
    String flavor;
    Cake() {
        model = 0;
        flavor = "Unknown";
    }
}
 
public class U2_Q2099 {  // Test
    public static void main(String[] args) {
        Cake c = new Cake();
        bake1(c);
        System.out.println(System.identityHashCode(c));
        // e.g. 1163157884
        System.out.println(c.model + " " + c.flavor);
        // 1200 Strawberry
        bake2(c);
        System.out.println(c.model + " " + c.flavor);
        // 1230 Chocolate
    }
    public static Cake bake1(Cake c) {
        System.out.println(System.identityHashCode(c));
        // e.g. 1163157884 (same number)
        c.flavor = "Strawberry";
        c.model = 1200;
        return c;
    }
    public static void bake2(Cake c) {
        System.out.println(System.identityHashCode(c));
        // e.g. 1163157884 (same number)
        c.flavor = "Chocolate";
        c.model = 1230;
        // return;
    }
}