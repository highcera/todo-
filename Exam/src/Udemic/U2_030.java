package Udemic;

public class U2_030 {
    public static void main(String[] args) {
        StringBuilder line = new StringBuilder("-");
        StringBuilder anotherLine = line.append("-");
        System.out.print(line == anotherLine);  // true
        System.out.print(" ");
        System.out.print(line.length());        // 2
    }
}
