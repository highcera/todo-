package Udemic;
// Always compare two strings with the equals() method.
public class U1_162 {
    public static void main(String[] args) {
        String h1 = "Bob";
        String h2 = new String("Bob");
        if(h1.equals(h2)) System.out.println("Equal");  // Equal
    }
}
