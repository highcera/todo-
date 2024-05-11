package Udemic;

public class U5_104 {  // RocketScience {
    public static void main(String[] args) {
        int a = 0;
        while (a == a++) {
            a++;
            System.out.println(a); // 2 4 6 ...
            if (a>1000) break;  // 없으면 infinite loop
        }
    }

}
