package Udemic;

class Alpha {
    int ns;
    static int s;
    Alpha (int ns) {
        if (s < ns) {
            s = ns;
            this.ns = ns;
        }
    }
    void doPrint() {
        System.out.println("ns = " + ns + " s = " + s);
    }
}
public class U3_093 {
    public static void main(String[] args) {
        Alpha ref1 = new Alpha(50);
        Alpha ref2 = new Alpha(125);
        Alpha ref3 = new Alpha(100);
        ref1.doPrint();  // ns = 50 s = 125
        ref2.doPrint();  // ns = 125 s = 125
        ref3.doPrint();  // ns = 0 s = 125
    }
}
