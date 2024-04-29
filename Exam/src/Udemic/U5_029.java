package Udemic;

public class U5_029 {  // TestField
    int x;  // 0
    int y;  // 0
    public void doStuff(int x, int y) {
        this.x = x;
        y = this.y;     // this.y stays 0
        // this.y = y;  // It should look like this
    }
    public void display() {
        System.out.print(x + " " + y + " : ");
    }
    public static void main(String[] args) {
        U5_029 m1 = new U5_029();
        m1.x = 100;
        m1.y = 200;
        U5_029 m2 = new U5_029();
        m2.doStuff(m1.x, m1.y);
        m1.display();  // 100 200 :
        m2.display();  // 100 0 :
    }
}
