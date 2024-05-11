package Udemic;

public class U2_123 {  // Loop
    private static int count;
    private static String[] stops = new String[] {
            "Washington", "Monroe", "Jackson", "LaSalle"
    };
    public static void main(String[] args) {
        while (count < stops.length) {
            if (stops[count++].length() < 8) {
                continue;
            }
        }
        System.out.println(count);  // 4
    }
}