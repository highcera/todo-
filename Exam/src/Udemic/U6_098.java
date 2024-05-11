package Udemic;

public class U6_098 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        String exam = "1Z0";
        int code = 808;
 
        System.out.println(sb1.append("I’ll pass " + exam + "-" + code));
        // I’ll pass 1Z0-808
 
        StringBuilder sb2 = new StringBuilder();
        System.out.println(sb2.append("I’ll pass ").append(exam).append("-").append(code));
        // I’ll pass 1Z0-808
 
        StringBuilder sb3 = new StringBuilder();
        // System.out.println(sb3.insert("I’ll pass ").append(exam + "-" + code));
        // no suitable method found for insert
 
        StringBuilder sb4 = new StringBuilder();
        // System.out.println(sb4.insert("I’ll pass ").insert(exam).insert("-").insert(code));
        // no suitable method found for insert
    }
}
