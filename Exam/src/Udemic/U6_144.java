package Udemic;

public class U6_144 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("World");
 
        sb.insert(0, "Hello ");
        System.out.println(sb);     // Hello World
 
        // sb.append(0, "Hello ");  // no suitable method found
 
        // sb.add(0, "Hello ");     // cannot find symbol
 
        // sb.set(0, "Hello ");     // cannot find symbol
    }
}
