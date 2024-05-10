package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U5_113 {  // MutatisMutandis {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new StringBuilder(""));
        list.add("");
        for (Object e : list)
            if (e instanceof StringBuilder)
                ((StringBuilder)e).append("OK");
            else ((String)e).concat("OK");
        System.out.println(list);  // [OK, ]
    }

}
