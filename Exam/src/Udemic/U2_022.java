package Udemic;

public class U2_022 {
    public static void main(String[] args) {
        int[] age = {20, 30, 40, 50, 60};
        for (int i = 0; i < age.length; i++) {
            System.out.print(age[i] + " ");  // 20
            if (age[i] == 40) {
                continue;
            }
            System.out.println("Processed");  // Processed
            break;
        }
    }
}
