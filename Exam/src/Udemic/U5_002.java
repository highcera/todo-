package Udemic;

public class U5_002 {
    public static void main(String[] args) {
        letters: for (char ch='a'; ch<='z'; ch++) {
            numbers: for (int n=0; n<=10; n++) {
                System.out.println(ch);
                break;
            }
        }
        letters: for (char ch='a'; ch<='z'; ch++) {
            numbers: for (int n=0; n<=10; n++) {
                System.out.println(ch);
                break numbers;
            }
        }
    }
}
