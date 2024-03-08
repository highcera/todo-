package Udemic;

public class U1_061 {
    private String material;
    // protected int strength;
    private int strength;
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public static void main(String[] args) {
        U1_061 test = new U1_061();
        test.setStrength(50);
        System.out.println(test.getStrength());
    }
}
