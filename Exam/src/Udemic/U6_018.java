package Udemic;

public class U6_018 {  // Rematerialize {
    public static void main(String[] input) {
        int dog = 11;
        int cat = 3;
        int partA = dog / cat;
        int partB = dog % cat;
        int newDog = partB + partA * cat;
        System.out.print(newDog);  // 11
    }
}
