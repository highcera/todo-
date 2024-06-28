package Udemic;

import java.util.ArrayList;

public class U3_Q3172 {
    public static void main(String[] args) {
        secret1(new StringBuilder());
        secret2(new ArrayList<String>());
    }
    public static void secret1(StringBuilder mystery) {
        mystery.append("metal");
        String str = mystery.substring(0, 1);
        int num = mystery.length();
        System.out.println(str);  // m
        System.out.println(num);  // 5
    }
    public static void secret2(ArrayList<String> mystery) {
        mystery.add("metal");
        String str = mystery.get(0);
        int num = mystery.size();
        System.out.println(str);  // metal
        System.out.println(num);  // 1
    }
}
