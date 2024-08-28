package Udemic;

abstract class Ball {
    protected final int size;
    public Ball(int size) {
        this.size = size;
    }
}
interface Equipment {}
public class U2_Q2131 extends Ball implements Equipment {  // SoccerBall
    public U2_Q2131() {
        super(5);
    }
    public Ball get() { return this; }
    public static void main(String[] passes) {
        Equipment equipment = (Equipment)(Ball)new U2_Q2131().get();
        System.out.print(((U2_Q2131)equipment).size);  // 5
    }
}
