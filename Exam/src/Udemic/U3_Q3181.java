package Udemic;

public class U3_Q3181 {  // TheMatrixReloaded {
    static void reload(StringBuilder sb) {
        sb.append(" Matrix");
        // sb.insert(" Reloaded", sb.length());
        sb.insert(sb.length(), " Reloaded");
    }
    public static void main (String[] args) {
        StringBuilder sb = new StringBuilder("The");
        reload(sb);
        System.out.println(sb);
    }

}
