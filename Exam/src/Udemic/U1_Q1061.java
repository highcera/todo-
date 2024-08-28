package Udemic;

public class U1_Q1061 {
    public static void main(String[] args) {
        String[] cartoons = {"tom", "jerry", "micky", "tom"};
        int counter = 0;
        if ("tom".equals(cartoons[0])) {
            counter++;
        } else if ("tom".equals(cartoons[1])) {
            counter++;
        } else if ("tom".equals(cartoons[2])) {
            counter++;
        } else if ("tom".equals(cartoons[3])) {
            counter++;
        }
        System.out.println(counter);  // 1
    }
}
