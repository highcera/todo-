package Udemic;

public class U4_103 {
    public static void main(String[] args) {
        admission();
    }
    public static void admission() {
        int amount = 0b101;
        // int amount = 0xE;
        // double amount = 0xE;
 
        // int amount = 9L;  // incompatible types
 
        // illegal underscore:
        // int amount = 1_2_;
        // double amount = 1_2_.0_0;
 
        System.out.println(amount);
    }
}
