package Udemic;

class One {
    public One() {
        System.out.print("1 ");
    }
}
class Two extends One {
    public Two() {                             // Line t1
        // super();
        System.out.print("2 ");
    }
}
class U6_037 extends Two {  // Three
    public U6_037() {                           // Line t2
        // super();
        System.out.print("3 ");
    }
    public static void main(String[] args) {
        U6_037 obj = new U6_037();  // 1 2 3
    }
}