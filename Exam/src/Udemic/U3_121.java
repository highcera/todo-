package Udemic;

public class U3_121 { // Book
    String title;
    boolean secondHand;
    double price;
    U3_121() {
        // Line b1
        // this.title = new String("Gone with the Wind");
        // this.secondHand = new Boolean(false);
        // this.price = new Double(9.5);
    }
    public String toString(){
        return title + ", new: " + !secondHand + ", price: " + price;
    }
    public static void main(String[] args) {
        U3_121 b = new U3_121();
        // Line b2
        b.title = "Gone with the Wind";
        b.secondHand = false;
        b.price = 9.5;
        System.out.print(b);
    }
}