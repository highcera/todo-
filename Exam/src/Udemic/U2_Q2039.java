package Udemic;

public class U2_Q2039 { // Fish
    public static void main(String[] args) {
        int numFish = 4;
        String fishType = "tuna";
        // Compile error: incompatible types:
        // int cannot be converted to java.lang.String:
        // String anotherFish = numFish + 1;
        String anotherFish = numFish + "1";
        System.out.println(anotherFish + " " + fishType);
        System.out.println(numFish + " " + 1);
    }
}