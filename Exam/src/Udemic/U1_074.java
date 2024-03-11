package Udemic;

public class U1_074 {
    int sum = 0;
    public void doCheck(int number) {
        if(number % 2 == 0){
            // break; case문에 사용
        } else {
            for (int i = 0; i < number; i++) {
                sum += 1;
            }
        }
    }
    public static void main(String[] args) {
        U1_074 obj = new U1_074();
        System.out.println("Red " + obj.sum);
        obj.doCheck(2);
        System.out.println("Orange " + obj.sum);
        obj.doCheck(3);
        System.out.println("Green " + obj.sum);
    }
}