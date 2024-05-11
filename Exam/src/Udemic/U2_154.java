package Udemic;

class A {
    String str;
    A() {}
    // private String run() {
    protected void run() {
        System.out.println(this.str);
        // return this.str += "!";
    }
}

class U2_154 extends A {  // B
    U2_154(String str) {
        this.str = str;
    }
    private void doStuff() {
        run();
    }
    public static void main (String [] args) {
        new U2_154("Hello").doStuff();
    }
}