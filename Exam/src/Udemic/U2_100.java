package Udemic;

class Caller {
    private void init() {
        System.out.println("Initialized");
    }
    public void start() {
        init();
        System.out.println("Started");
    }
}
 
public class U2_100 {
    public static void main(String[] args) {
        Caller c = new Caller();
        c.start();
        // c.init();  // 'init()' has private access ...
    }
}