package Udemic;

public class U3_142 {
    public static void main(String[] args) {
        int[] lst = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int sum = 0;
        for (int frnt = 0, rear = lst.length - 1; frnt < 5 && rear >= 5; frnt++, rear--) {
            sum = sum + lst[frnt] + lst[rear];
            System.out.println(frnt + ":" + rear);
        }
        System.out.println(sum);  // 20
    }
}
