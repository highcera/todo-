package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U6_117 {
    public static void main(String[] args) {
        int count = 10;
        List<Character> chars = new ArrayList<>();
        do {
            chars.add('a');
            for (Character x : chars)
                count -=1;
            System.out.println(chars.toString() + count);
            // [a]9
            // [a, a]7
            // [a, a, a]4
            // [a, a, a, a]0
        } while (count > 0);
        System.out.println(chars.size());  // 4
    }
}
