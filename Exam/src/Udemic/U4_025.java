package Udemic;

public class U4_025 {  // Answer {
    public static void main(String[] args) {
        int a = 42;
        if (a++ == 42) {
            System.out.println(
              "The answer to Life, the Universe and everything is " + a);
              // The answer to Life, the Universe and everything is 43
        } else {
            System.out.println(
              "The answer to Life, the Universe and everything is " + ++a);
        }
    }

}
