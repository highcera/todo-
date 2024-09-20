package Udemic;

interface Z {}
public class U2_Q2120 implements Z {
    public String toString() {
        return "X";
    }
    public static void main(String[] args) {
        Y myY = new Y();
        U2_Q2120 myX = myY;
        Z myZ = myX;
        System.out.print(myX);     // Y
        System.out.print((Y)myX);  // Y
        System.out.print(myZ);     // Y
    }
}
class Y extends U2_Q2120 {
    public String toString() {
        return "Y";
    }
}