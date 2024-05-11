package Udemic;

interface Aquatic { 
    public default int getNumberOfGills(int input) { return 2; }
}
public class U6_021 implements Aquatic {  // ClownFish
    public String getNumberOfGills() { return "4"; }
    // public String getNumberOfGills(int input) { return "6"; }  // Line 6
    public int getNumberOfGills(int input) { return 6; }
    public static void main(String[] args) {
        System.out.println(new U6_021().getNumberOfGills(-1));
    }
}