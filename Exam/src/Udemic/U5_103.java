package Udemic;

public class U5_103 {  // Parser {
    String input = "2013";
    public void parseMe(String str) {
        int output = 0;
        try {
            String input = str;
            output = Integer.parseInt(input);
        } catch (IllegalArgumentException iae) {
            System.out.println("Wrong argument!");
        }
        System.out.println(
                "input: " + input + ", output: " + output
        );
        // input: 2013, output: 123
    }
    public static void main(String[] args) {
        U5_103 p = new U5_103();
        p.parseMe("0123");
    }

}
