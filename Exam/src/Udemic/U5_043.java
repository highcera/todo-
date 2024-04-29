package Udemic;

public class U5_043 {  // Bond {
    private static int price = 5;
    public boolean sell() {
        if(price<10) {
            price++;
            return true;
        // } else if(price>=10) {
        } else {
            return false;
        }
    }
    public static void main(String[] cash) {
        new U5_043().sell();
        new U5_043().sell();
        new U5_043().sell();
        System.out.print(price);
    }

}
