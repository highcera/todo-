package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U3_080 {
     public static void main(String[] args) {
        List<String> magazines = new ArrayList();
        magazines.add("Readers Digest");
        magazines.add("People");
        magazines.clear();
        magazines.add("The Economist");
        magazines.remove(1);
        // IndexOutOfBoundsException
        System.out.println(magazines.size());
    }
}
