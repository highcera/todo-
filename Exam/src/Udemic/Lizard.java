package Udemic;

abstract class U4_131 {  // Reptile
    // public final void layEggs() {
    public void layEggs() {
        System.out.println("Reptile laying eggs");
    }
    public static void main(String[] args) {
        U4_131 reptile = new Lizard();
        reptile.layEggs();
    }
}
public class Lizard extends U4_131 {
    // layEggs() cannot override layEggs() in Reptile
    // overridden method is final
    public void layEggs() { System.out.println("Lizard laying eggs"); }
}