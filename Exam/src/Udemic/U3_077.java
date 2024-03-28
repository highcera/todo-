package Udemic;

public class U3_077 { // parse
    String input = "0123";                                   // Line p1
    public void parseMe(String str) {
        int output = 0;
        try {
            String input = str;                              // Line p2
            output = Integer.parseInt(input);
        } catch (IllegalArgumentException iae) {
            System.out.println("Wrong argument!");
        }
        System.out.println(
                "input: " + input + ", output: " + output);  // Line p3
        // input: 0123, output: 2013
    }
    public static void main(String[] args) {
        U3_077 p = new U3_077();
        p.parseMe("2013");
    }
}
