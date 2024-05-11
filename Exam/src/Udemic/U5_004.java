package Udemic;

public class U5_004 {
    static void m(int[] i) {
        i[0] += 7;
        System.out.println(System.identityHashCode(i));
        // e.g. 1263157244 (same number)
    }
    public static void main(String[] args) {
        int[] j = new int[1];
        j[0] = 12;
        System.out.println(System.identityHashCode(j));
        // e.g. 1263157244
        m(j);
        System.out.println(j[0]);  // 19
    }
}

// class X {
//     static void m(StringBuilder sb1) {
//       sb1.append("er");
//     }
//     public static void main(String[] args) {
//       StringBuilder sb2 = new StringBuilder("moth");
//       m(sb2);
//       System.out.println(sb2);
//     }
//   }
  