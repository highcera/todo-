package Udemic;

public class U3_187 {  // TestTry
    public static void main(String[] args) {
        StringBuilder message = new StringBuilder("hello java!");
        int pos = 0;
        try {
            // for (pos = 0; pos < 11; pos++) {  // runs without exception
            for (pos = 0; pos < 12; pos++) {
                switch(message.charAt(pos)) {
                    case 'a':
                    case 'b':
                    case 'c':
                        String uc = Character.toString(message.charAt(pos)).toUpperCase();
                        // System.out.println(uc);
                        message.replace(pos, pos+1, uc);
                        // System.out.println(message);
                }
            }
        } catch (Exception e) {
            System.out.println("Out of limits");  // Out of limits
            System.out.println(e);  // StringIndexOutOfBoundsException
        }
        System.out.println(message);  // hello jAvA!
    }
}