package Udemic;

public class U6_140 {
    public static void main(String[] args) {
        String product = "Pen";
        product.toLowerCase();
        product.concat(" BOX".toLowerCase());
        // product = product.concat(" BOX".toLowerCase());
        // System.out.println(product);
        System.out.print(product.substring(4, 6));
        // StringIndexOutOfBoundsException
    }
}
