package Udemic;

abstract class Book {
    protected static String material = "papyrus";
    public Book() {}
    public Book(String material) {this.material = material;}
}
public class U6_089 extends Book {  // Encyclopedia
    public static String material = "cellulose";
    public U6_089() {super();}
    public String getMaterial() {return super.material;}
    public static void main(String[] pages) {
        System.out.print(new U6_089().getMaterial());  // papyrus
    }
}