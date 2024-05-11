package Udemic;

abstract class U5_106 {  // Whale
    // public abstract void dive() {};  // Line 2
    public abstract void dive();
    public static void main(String[] args) {
        U5_106 whale = new Orca();
        whale.dive();
    }
}
class Orca extends U5_106 {              // Line 8
    // public void dive(int depth) { System.out.println("Orca diving"); }  // Line 9
    public void dive() { System.out.println("Orca diving"); }
}