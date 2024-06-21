package Udemic;

public class U4_059 {
    public static void main(String[] args) {
        int score = 80;
        boolean passed = !((score < 80) || (score >= 100));
        passed = !((80 < 80) || (80 >= 100));
        passed = !(false || (80 >= 100));
        passed = !(false || false);
        passed = !(false);
        passed = true;
        System.out.println(passed);  // true
    }
}
