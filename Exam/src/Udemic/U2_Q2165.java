package Udemic;

public class U2_Q2165 {
    public static void main(String[] args) {
 
        StringBuilder sb1 = new StringBuilder("128");
        System.out.println(sb1.capacity());  // 19
 
        // StringBuilder sb2 = StringBuilder.setCapacity(128);  // cannot find symbol
 
        // StringBuilder sb3 = StringBuilder.getInstance(128);  // cannot find symbol
 
        StringBuilder sb4 = new StringBuilder(128);
        System.out.println(sb4.capacity());  // 128
    }
}
