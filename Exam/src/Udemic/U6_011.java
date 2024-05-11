package Udemic;

public class U6_011 {
    public static void main(String[] args) {
        try {
            if (Math.random() < 0.5) {
                int[] x = {1}; System.out.println(x[1]);
            } else {
                "Hello".charAt(5);
            }
        }
        catch (ArrayIndexOutOfBoundsException |
               StringIndexOutOfBoundsException e) {
                  e.printStackTrace();
        }
    }
}
