package Udemic;

import static java.lang.Double.parseDouble;

class U2_Q2035 { // Square
    final static float squareIt (String str) {
        // Line 5:
        // return (float) parseDouble(str) * parseDouble(str);
        return (float) (parseDouble(str) * parseDouble(str));
    }
    public static void main(String[] args) {
        // Line 8:
        System.out.println(new U2_Q2035().squareIt("2.0"));
    }
}
