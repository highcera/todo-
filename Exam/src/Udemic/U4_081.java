package Udemic;

public class U4_081 {  // Lion {
    // public void roar(String roar1, StringBuilder roar2) {
    public String roar(String roar1) {
        String roar0 = null;

        roar0 = roar1.concat("!!!");
        // roar2.append("!!!");
        return roar0;
    }
    public static void main(String[] args) {
        String roar1 = "roar";
        StringBuilder roar2 = new StringBuilder("roar");
        // new U4_081().roar(roar1, roar2);
        roar1 = new U4_081().roar(roar1);
        // System.out.println(roar1 + " " + roar2);  // roar roar!!!
        System.out.println(roar1); 
    }
}
