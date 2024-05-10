package Udemic;

public class U5_112 {
    public static void main(String[] fruits) {
        String fruit1 = new String("apple");
        String fruit2 = new String("orange");
        String fruit3 = new String("pear");
        fruit3 = fruit1;
        fruit2 = fruit3;
        fruit1 = fruit2;
        System.out.println(fruit1);  // apple
        System.out.println(fruit2);  // apple
        System.out.println(fruit3);  // apple
    }
}
// All three references point to the String apple.
// This makes the other two String objects eligible for garbage collection.