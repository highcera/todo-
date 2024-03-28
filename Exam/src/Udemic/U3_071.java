package Udemic;

public class U3_071 { // Cat
    public String name;
    public void parseName() {
        System.out.print("1");               // Line 2
        try {
            System.out.print("2");           // Line 6
            int x = Integer.parseInt(name);  // Line 7
            System.out.print("3");
        } catch (NullPointerException e) {
            System.out.print("4");
        }
        System.out.print("5");
    }
    public static void main(String[] args) {
        U3_071 leo = new U3_071();
        leo.name = "Leo";
        leo.parseName();
        System.out.print("6");
    }
}
