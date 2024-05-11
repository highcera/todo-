package Udemic;

public class U6_078 {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int k = j += i / 5;
        k = j = j + (i / 5);
        j = j + (i / 5);
        j = 20 + (10 / 5);
        j = 20 + 2;
        j = 22;
        k = j;
        System.out.println(i +" : " + j + " : " + k);  // 10 : 22 : 22
 
        // The return value of an assignment is the assigned value:
        int z = 100;
        System.out.println(z = 200);  // 200
        System.out.println(z);        // 200
    }
}
