package Udemic;

class Mid {
    public int findMid(int n1, int n2) {
        return (n1 + n2) / 2;
    }
}

public class U5_130 extends Mid {  //Calc
        public static void main(String[] args) {
        int n1 = 22, n2 = 2;
 
        U5_130 c = new U5_130();
        int n3a = c.findMid(n1, n2);
        System.out.println(n3a);  // 12
 
        Mid m1 = new U5_130();
        int n3b = m1.findMid(n1, n2);
        System.out.println(n3b);  // 12
 
        // int n3 = super.findMid(n1, n2);
        // non-static variable super
        // cannot be referenced from a static context
 
        // int n3 = U5_130.findMid(n1, n2);
        // non-static method findMid(int,int)
        // cannot be referenced from a static context
 
        // U5_130 c = new Mid();
        // incompatible types: Mid cannot be converted to Calc
        // int n3 = c.findMid(n1, n2);
    }
}
