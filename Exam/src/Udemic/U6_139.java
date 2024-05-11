package Udemic;

class Twins {
    int age;
    Twins(int age) {
        this.age = age;
    }
}
class U6_139 {  // Test
    public static void main (String[] args) {
        Twins t1 = new Twins(23);
        Twins t2 = new Twins(23);
        if (t1 == t2) {
            System.out.println("Identical");
        } else {
            System.out.println("Dissimilar");
            // Dissimilar
        }
        if (t1.equals(t2)) {
            System.out.println("Identical");
        } else {
            System.out.println("Dissimilar");
            // Dissimilar
        System.out.println(t1+" "+t2);
        }
    }
}