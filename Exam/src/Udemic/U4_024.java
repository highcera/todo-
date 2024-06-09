package Udemic;

class Base {
    int type = 0;                             // Line 1
    public void run(){};
}
class U4_024 extends Base{  // Derived
    public U4_024(){
        // int type = 10;                      // Line 2
        // type = 10;                          // Line 3
        this.type = 10;                        // Line 3
    }
    int type = 1;                              // Line 4
    public void run(){
        System.out.println("running type = " + this.type);
        // running type = 10
    }
    public static void main(String[] args){
        Base b = new U4_024();
        // b.run();
        System.out.println("type = " + b.type);  // type = 0
    }
}