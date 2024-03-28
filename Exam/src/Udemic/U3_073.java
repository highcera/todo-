package Udemic;

public class U3_073 {
    public static void main(String[] args) {
        int aVar = 9;
        if (aVar++ < 10) {
            System.out.println(aVar + " Hello World!");  // 10 Hello World!
        } else {
            System.out.println(aVar + " Hello Universe!");
        }
    }
}
