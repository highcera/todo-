package Udemic;

public class U1_Q1080 {
    public static void main(String[] args) {
        for (int ctr = 2; ctr <= 30; ++ctr) {
            if (ctr % 7 != 0)
                // break;
                continue;
                if (ctr % 14 == 0)
                    System.out.println(ctr);  // 14 28
        }
    }
}
