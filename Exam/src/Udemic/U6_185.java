package Udemic;

public class U6_185 {
 public static void main(String[] args) {
        letters: for (char ch='a'; ch<='z'; ch++) {
            numbers: for (int n=0; n<=10; n++) {
                System.out.println(ch);
                continue letters;
            }
        }
    }
}
