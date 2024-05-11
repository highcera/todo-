package Udemic;

public class U6_114 {
    final static int a1 = 0;
    final static Integer i1 = 1;
    public static void main(String[] args) {
        int x = -123;
        StringBuilder str = new StringBuilder("Java");
        switch (x) {
            case -123: str.append("S");
            case a1:   str.append("E");       // Line 1
            // case i1:   str.append("8");    // Line 2
            // constant expression required
        }
        System.out.println(str);
    }
}
