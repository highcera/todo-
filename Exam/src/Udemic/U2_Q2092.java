package Udemic;

public class U2_Q2092 {  // Test
    public static void main(String[] args) {
        boolean b1, b2;
        int a = 0;

        // System.out.println(b1 = b2 = false);
        while (b1 = b2 = false) { }
        while (!!true) { break; }
        while (a == 0 ? false : true) { }
        while (new U2_Q2092().equals("?!")) { }
    }
}
