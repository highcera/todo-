package Udemic;

public class U4_107 {
    public static void main(String[] args) {
        doSomething();
    }
    private static void doSomething() {
        doSomethingElse();
    //    try {
    //        doSomethingElse();
    //    } catch (Exception e) {
    //        System.out.println(e);
    //    }
    }
    // private static void doSomethingElse() throws Exception {
    private static void doSomethingElse() {
        // throw new Exception();
        // unreported exception Exception
        // must be caught or declared to be thrown
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
