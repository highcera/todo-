package Udemic;

abstract class U3_Q3136 { // Tree
    private void grow() {
        System.out.println("Tree is growing");  // Tree is growing
    }
    public static void main(String[] args) {
        U3_Q3136 tree = new Oak();                 // Line 6
        tree.grow();
    }
}
 
class Oak extends U3_Q3136 {
    protected void grow() {                    // Line 11
        System.out.println("Oak is growing");
    }
}