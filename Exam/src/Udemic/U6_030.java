package Udemic;

public class U6_030 {
    public static void main(String[] args) {
        String line = new String("-");
        String anotherLine = line.concat("-");
        System.out.print(line == anotherLine);  // false
        System.out.print(" ");
        System.out.println(line.length());      // 1
        System.out.println(line);               // -
        System.out.println(anotherLine);        // --
    }
}
