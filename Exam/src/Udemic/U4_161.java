package Udemic;

class Parent {
    private boolean inherited = true;
    public boolean isInherited(){ return inherited; }
}
class U4_161 extends Parent {  // Child
    public static void main(String[] args) {
        System.out.println(new U4_161().isInherited()); // true
    }
}