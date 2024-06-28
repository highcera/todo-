package Udemic;

class Ship {
    protected int weight = 3;
    private int height = 5;
 
    public int getWeight() { return weight; }
    public int getHeight() { return height; }
}
public class U1_Q1163 extends Ship {
    public int weight = 2;
    public int height = 4;
    public void printDetails() {
        // System.out.print(super.getWeight() + "," + super.height);
        System.out.print(super.getWeight() + "," + height);
    }
    public static final void main(String[] fuel) {
        new U1_Q1163().printDetails();
    }
}
