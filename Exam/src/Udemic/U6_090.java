package Udemic;

import java.util.ArrayList;
import java.util.List;

interface Contract {}
class Super implements Contract {}
class Sub extends Super {}
 
public class U6_090 {  // Ref
    public static void main(String[] args) {
        List objs = new ArrayList();
        Contract c1 = new Super();
        Contract c2 = new Sub();             // Line n1
        Super s1 = new Sub();
        objs.add(c1);
        objs.add(c2);
        objs.add(s1);                        // Line n2
        for(Object itm: objs) {
            System.out.println(itm.getClass().getSimpleName());
            // Super
            // Sub
            // Sub
        }
    }
}