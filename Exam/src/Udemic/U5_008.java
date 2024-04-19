package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U5_008 {
    public static void main(String[] args) {
        List<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('b');
        chars.set(1, 'c');
        chars.remove(0);
        System.out.println(chars.size() + " " + chars.contains('b'));
        // 1 false
        System.out.println(chars);  // [c]
    }
}
