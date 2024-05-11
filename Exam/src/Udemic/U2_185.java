package Udemic;

import java.util.ArrayList;

public class U2_185 {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        for (Object a : arrList) {System.out.println(a);}  // 1
        int[] arr = {1};
        for (Object a : arr) {System.out.println(a);}  // 1
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Hello");
        // java: for-each not applicable to expression type:
        // for (Object s : strBuilder) {System.out.println(s);}
    }
}
