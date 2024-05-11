package Udemic;

public class U3_153 {
    public static void main(String[] args) {
 
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);  // Hello
 
        sb.delete(0, sb.length());
 
        System.out.println(sb);  // No output
 
        // sb.deleteAll();  // Cannot resolve method 'deleteAll' ...
        // sb.removeAll();  // Cannot resolve method 'removeAll' ...
        // sb.delete(0, sb.size());  // Cannot resolve method 'size' ...
    }
}
