package Udemic;

public class U5_171 {
    public static void main(String[] args) {
        // This will not have the value 50.
        // It will create a StringBuilder object with
        // an initial capacity to store 50 characters:
        StringBuilder sb1 = new StringBuilder(5*10);
        System.out.println(sb1);  // Keine Ausgabe
        // StringBuilder doesn't have the concat() method:
        // sb1.concat();  // cannot find symbol
        // Yip, the insert method can be used to insert a character,
        // number, or String
        // at the start or end or a specified position of a StringBuilder:
        sb1.insert(0, "Hello");
        sb1.insert(2, 7);
        sb1.insert(4, 'X');
        System.out.println(sb1);  // He7lXlo
    }
}
