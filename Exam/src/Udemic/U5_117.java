package Udemic;

public class U5_117 {  // Lang
    private String category = "procedural";
    public static void main(String[] args) {
        U5_117 obj1 = new U5_117();
        U5_117 obj2 = new U5_117();
        System.out.println(System.identityHashCode(obj1.category));
        // e.g. 1163157884
        System.out.println(System.identityHashCode(obj1.category));
        // e.g. 1163157884 (same number)
        if (obj1.category == obj2.category) {
            System.out.println("Equal");  // Equal
        } else {
            System.out.println("Not equal");
        }
        if (obj1.category.equals(obj2.category)) {
            System.out.println("Equal");  // Equal
        } else {
            System.out.println("Not equal");
        }
    }
}
// Both strings will point to the same object and therefore are equal to each other.