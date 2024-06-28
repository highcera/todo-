package Udemic;

public class U3_Q3048 {
    public static void main(String[] args) {
        String apples1 = "Fruit";
        String oranges1 = "Fruit";
        System.out.println(apples1 == oranges1);       // true
        System.out.println(apples1.equals(oranges1));  // true
 
        String apples2 = "We are Fruit";
        String oranges2 = "We are ";
        oranges2 += "Fruit";
        System.out.println(apples2.equals(oranges2));  // true
        System.out.println(apples2 == oranges2);       // false
    }
}
