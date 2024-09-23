package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U2_Q2178 {  // PrintNegative
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("-5");
        list.add("0");
        list.add("5");
        print(list, e -> e < 0);
    }
    public static void print(List<String> list, Predicate<Integer> p) {
         for (String num : list) {
             // if (p.Test(num)) System.out.println(num);  // cannot find symbol
         }
    }
}