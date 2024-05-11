package Udemic;

public class U5_012 {
    public static void main(String[] args) {
        boolean x = true, z = true;
        int y = 20;
        x = (y != 10) ^ (z = false);
        System.out.println(x+", "+y+", "+z);  // true, 20, false
    }
}
