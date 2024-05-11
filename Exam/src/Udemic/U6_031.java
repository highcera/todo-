package Udemic;

public class U6_031 {
    public static void call(int count, String me, String... data) {}
    public static void main(String[] args) {
        call(2,"home", new String[] {"Game", "29.99"});
        // method call cannot be applied to given types:
        // call(5);
        // call(9,"me",10,"Al");
        // incompatible types:
        // call("answering","service");
    }
}
