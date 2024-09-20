package Udemic;

import java.util.ArrayList;
import java.util.List;

class Patient {
    String name;
    public Patient(String name) {
        this.name = name;
    }
}
public class U2_Q2167 {
    public static void main(String[] args) {
        List ps = new ArrayList();
        Patient p2 = new Patient("Mike");
        ps.add(p2);
 
        int f1 = ps.indexOf(new Patient("Mike"));
        System.out.println(f1);  // -1
 
        Patient p = new Patient("Mike");
        int f2 = ps.indexOf(p);
        System.out.println(f2);  // -1
 
        int f = ps.indexOf(p2);
        System.out.println(f);  // 0
 
        if(f >= 0) {
            System.out.print("Mike found");
        }
    }
}