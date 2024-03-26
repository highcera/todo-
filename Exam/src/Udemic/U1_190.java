package Udemic;

public class U1_190 {
    public static String doMsg(char x) {
        return "Good Day!";
    }
    public static String doMsg(int y) {
        return "Good Luck!";
    }
    public static void main(String[] args) {
        char x = 8;
        System.out.println(x);         // Backspace character
        int z = '8';
        System.out.println(z);         // 56
        System.out.println(doMsg(x));  // Good Day!
        System.out.println(doMsg(z));  // Good Luck!
    }
}
