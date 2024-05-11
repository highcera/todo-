package Udemic;

public class U6_082 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Duke");
        System.out.println(sb.insert(0, "Hello "));
        // Hello Duke
        // System.out.println(sb.append(0, "Hello "));
        // System.out.println(sb.add(0, "Hello "));
        // System.out.println(sb.set(0, "Hello "));
    }
}
