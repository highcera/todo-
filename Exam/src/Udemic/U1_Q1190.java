package Udemic;

import java.util.Arrays;
import java.util.List;

public class U1_Q1190 {
    public static void main(String[] args) {
        String[] names = {"Tom", "Dick", "Harry"};

        // cannot find symbol:
        // List<String> list = names.asList();
        List<String> list = Arrays.asList(names);

        list.set(0, "Sue");
        System.out.println(names[0]);
    }
}
