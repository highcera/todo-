package Udemic;

public class U1_Q1110 {
    public static void main(String[] args) {
        int a = 100;
        System.out.print(doubleValue(a));  // 200
        System.out.print(" : " + a);       //  : 100
    }
    static int doubleValue(int a){
        a = a * 2;
        return a;
    }
}
