package Udemic;

public class U2_126 {
    public static void main(String[] args) {}
}
 
abstract class Dress1 {
    public abstract double calculatePrice(Dress1 d);
    public void showDress(Dress1 d) {
        // some valid code
    }
}
 
abstract class Dress2 {
    // missing method body, or declare abstract:
    // public double calculatePrice(Dress2 d);
    // missing method body, or declare abstract:
    // public void showDress(Dress2 d);
}
 
abstract class Dress3 {
    // missing method body, or declare abstract:
    // public double calculatePrice(Dress3 d);
    public final void showDress(Dress3 d) {
        // some valid code
    }
}
 
abstract class Dress {
    // missing method body, or declare abstract:
    // public abstract double calculatePrice(Dress d) {
        // some valid code
    // }
    // missing method body, or declare abstract:
    // public abstract void showDress(Dress d) {
        // some valid code
    // }
}
