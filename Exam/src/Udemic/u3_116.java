package Udemic;

public class u3_116 {
    public static void main(String[] args) {
        final String str = "String ";
        switch ( str.trim() + "!" ) {            // Line 1
            case "String " + "!":                // Line 2
                System.out.println("String !");
                break;
            case "String" + "!" :                // Line 3
                System.out.println("String!");
                // String!
                break;
        }
    }
}
