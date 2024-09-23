package Udemic;

public class U2_Q2179 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1");  // earth
        sb.append("2");                             // water
        sb.append("3");                             // air
        sb.append("4");                             // fire
        sb.replace(4,4,"Leeloo");
        System.out.println(sb);  // 1234Leeloo
    }
}
