package Udemic;

public class U6_137 {
    public static void main(String[] args) {
        String happy = " :) - (: ";
        String really = happy.trim();
        String question = happy.substring(1, happy.length() - 1);
        System.out.println(happy.length() - 1);
        System.out.println("|" + happy + "|" + "\n" + "|" + really + "|");
        System.out.println(really.equals(question));  // true
    }
}
