package Udemic;

public class U6_015 {  // Sales {
    public static void main(String[] args) {
        int salesPhone = 1;
        System.out.println(salesPhone++ +
                         ++salesPhone + ++salesPhone);  // 8
        System.out.println(1 + 3 + 4);                  // 8
        salesPhone = 1;
        int result = salesPhone++ + ++salesPhone;
        System.out.println(result);                     // 4
        System.out.println(salesPhone);                 // 3
        System.out.println(result + ++salesPhone);      // 8
    }
}