package Udemic;

public class U4_135 {  // class X {
    static void m(int[] i) {
        i[0] += 7;
    }
    public static void main(String[] args) {
        int[] j = new int[1];
        j[0] = 12;
        m(j);
        System.out.println(j[0]);  // 19
    }
}
