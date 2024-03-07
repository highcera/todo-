package Udemic;

public class U1_60 {
    static void m(int i) {
        i += 7;
        System.out.println(i);  // 19
    }
    public static void main(String[] args) {
        int j = 12;
        m(j);
        System.out.println(j);  // 12
    }
}
