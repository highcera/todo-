package Udemic;

public class U4_039 {
    int test;
    // int a = 10;
    final int a = 10;
    int run(){ return 42; }
    void switchMe(){
        switch ( run() ) {}  // Line 1
        switch ( test  ) {   // Line 2
            case a:          // Line 3
            default:
        }
    }
    public static void main(String[] args) {
        U4_039 sm = new U4_039();
        sm.switchMe();
    }
}
