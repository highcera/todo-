package Udemic;

public class U5_050 {  //  BirdSeed {
    private int numberBags;
    boolean call;
    public U5_050() {
        this(2); // Line 1
        call = false;
        // Line 2
    }
    public U5_050(int numberBags) {
        this.numberBags = numberBags;
    }
    public static void main(String[] args) {
        U5_050 seed = new U5_050();
        System.out.println(seed.numberBags);
    }

}
