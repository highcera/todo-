package Udemic;

class U6_145 {  // X
    static void m(String s1) {
        System.out.println(System.identityHashCode(s1));
        // e.g. 1163157884 (same number)
        s1 = "acting";
        System.out.println(System.identityHashCode(s1));
        // e.g. 1956725890 (different number)
    }
    public static void main(String[] args) {
        String s2 = "action";
        System.out.println(System.identityHashCode(s2));
        // e.g. 1163157884
        m(s2);
        System.out.println(s2);  // action
    }
}