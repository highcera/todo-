package Udemic;

import java.util.ArrayList;
import java.util.List;

class Alpha {
    public String doStuff(String msg) {
        return msg;
    }
}
class Beta extends Alpha {
    public String doStuff(String msg) {
        return msg.replace('a', 'e');
    }
}
class Gamma extends Beta {
    public String doStuff(String msg) {
        return msg.substring(2);
    }
}
public class U5_042 {  // App
    public static void main(String[] args) {
        List<Alpha> strs = new ArrayList<>();
        strs.add(new Alpha());  // Java
        strs.add(new Beta());   // Jeve
        strs.add(new Gamma());  // va
        for (Alpha t : strs) {
            System.out.println(t.doStuff("Java"));
        }
    }
}