package Udemic;

public class U2_098 {

}
class HasSoreThroatException extends Exception {}
class TiredException extends RuntimeException {}
interface Roar {
    void roar() throws HasSoreThroatException;
}
class U2_098 implements Roar { // Lion
 
    public static void main(String[] args) {}
 
    public void roar() {}
    // public void roar() throws HasSoreThroatException {}
    // public void roar() throws TiredException {}
    // public void roar() throws IllegalArgumentException {}
 
    // public void roar() throws Exception {} // ... overridden method does not throw Exception
}