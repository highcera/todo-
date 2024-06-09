package Udemic;

public class U4_011 {  // Remember {
    public static void think() throws Exception {                // Line 1
        try {
            throw new Exception();
        }
        catch (Exception e) {
            // System.out.println(e);
        }
        // java: 'try' without 'catch', 'finally' or resource declarations
    }
    public static void main(String... ideas) throws Exception {
        think();
    }
}
