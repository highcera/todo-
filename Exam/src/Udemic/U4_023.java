package Udemic;

public class U4_023 {  // Create {
    U4_023() {
        System.out.print("1 ");
    }
    // U4_023(int num) {
    //     System.out.print("2 ");  // 2
    // }
    U4_023(Integer num) {
        System.out.print("3 ");
    }
    U4_023(Object num) {
        System.out.print("4 ");  // 4
    }
    U4_023(int... nums) {
        System.out.print("5 ");
    }
    public static void main(String[] args) {
        new U4_023(100);
        new U4_023(100L);
    }

}
