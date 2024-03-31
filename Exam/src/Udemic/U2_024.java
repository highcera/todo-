package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U2_024 {
      public static void main(String[] args) {
        List<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('b');
        chars.set(1, 'c');
        chars.remove(0);
        // System.out.print(chars.length());
        // cannot find symbol method length()
        System.out.print(chars.size());  // 1
    }
}
