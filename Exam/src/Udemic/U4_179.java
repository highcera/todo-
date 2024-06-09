package Udemic;

public class U4_179 {
    public static void main(String[] args) {
        // StringBuilder sb = new StringBuilder("radical")
        //         .insert(sb.length(), "robots");
        // variable sb might not have been initialized
        StringBuilder sb = new StringBuilder("radical");
        sb.insert(sb.length(), "robots");
        System.out.println(sb);
    }
}
