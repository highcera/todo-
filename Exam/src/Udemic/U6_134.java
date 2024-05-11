package Udemic;

public class U6_134 {  // varargs ...
    static void func(String... texte) {
        for (String text : texte) {
            System.out.print(text);
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        func("Peter");          // Peter
        func("Peter", "Paul");  // Peter Paul
        String[] namen = {"Peter", "Paul", "Mary"};
        func(namen);            // Peter Paul Mary
    }
}