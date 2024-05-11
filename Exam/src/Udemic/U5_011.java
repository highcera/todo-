package Udemic;

public class U5_011 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder(256);
        System.out.println(sb1.capacity());  // 256
 
        // StringBuilder sb2 = StringBuilder.setLength(256);
        // non-static method setLength(int) cannot
        // be referenced from a static context
 
        // StringBuilder sb3 = StringBuilder.setCapacity(256);
        // cannot find symbol
 
        // StringBuilder sb4 = new StringBuilder(new String(256));
        // no suitable constructor found for String(int)
    }
}
