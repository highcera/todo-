package Udemic;

class Element {
    public String name;
    public int electrons;
 
    public Element(String name, int electrons) {
        this.name = name;
        this.electrons = electrons;
    }
}
public class U5_140 {
    public static void main(String[] args) {
        Element[] AlkaliMetals = {
                new Element("Lithium", 3),
                new Element("Sodium", 11),
                new Element("Potassium", 19),
                new Element("Rubidium", 37),
                new Element("Caesium", 55),
                new Element("Francium", 87),
        };
        System.out.println("Group:\t\t\t" + AlkaliMetals);
        // Group:                [Lperiodictable.Element;@2a139a55
        System.out.println("Element:\t\t" + AlkaliMetals[3]);
        // Element:              periodictable.Element@15db9742
        System.out.println("Number of electrons:\t" + 
                            AlkaliMetals[3].electrons);
        // Number of electrons:  37
    }
}