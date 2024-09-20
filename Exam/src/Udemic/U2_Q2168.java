package Udemic;

public class U2_Q2168 {
    public static void main(String[] args) {
        String names[] = new String[3];
        names[0] = "Mary Brown";    // Marrown
        names[1] = "Nancy Red";     // string out of limits
        names[2] = "Jessy Orange";  // JesOran
        try {
            for(String n: names){
                try {
                    String pwd = n.substring(0, 3) + n.substring(6, 10);
                    System.out.println(pwd);
                }
                catch (StringIndexOutOfBoundsException sie){
                    System.out.println("string out of limits");
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException aie){
            System.out.println("array out of limits");
        }
    }
}
