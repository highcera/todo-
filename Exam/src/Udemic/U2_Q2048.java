package Udemic;

public class U2_Q2048 {  // Transportation
    public static String travel(int distance) {
        // return distance<1000 ? "train" : 10;
        return distance<1000 ? "train" : "10";
    }
    public static void main(String[] answer) {
        System.out.print(travel(500));
    }
}
