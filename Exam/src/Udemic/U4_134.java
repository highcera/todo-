package Udemic;

public class U4_134 {  // Greetings {
    String str = "Hello!";
    U4_134(String str) {
        this.str = str;
    }
    void greet() {
        System.out.println(str);
    }
    public static void main(String[] args) {
        new U4_134("Hi!").greet();  // Hi!
    }

}
