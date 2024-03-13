package Udemic;

public class U1_090 {
    public static void main(String[] args) {
        int x = 10, y = 5;
        boolean w = true, z = false;
        x = w ? y++ : y--;
        w = !z;
        System.out.print((x+y)+" "+(w ? 5 : 10));  // 11 5
    }
}
