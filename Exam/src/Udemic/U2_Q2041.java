package Udemic;

public class U2_Q2041 {
    public static void main(String[] args) {
        String color = "teal";
        switch(color){
            case "Red":
                System.out.println("Found Red");
            case "Blue":
                System.out.println("Found Blue");
                break;
            case "Teal":
                System.out.println("Found Teal");
                break;
            default:
                System.out.println("Found Default");
        }
    }
}
