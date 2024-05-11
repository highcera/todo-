package Udemic;

class Television {
    // protected final void watch() {}  // Cannot be final to be overridden
    protected void watch() {}
}
public class U6_191 extends Television {  // LCD
    // Object watch() {}  // Needs the same return value (or a subclass)
    // void watch() {}    // Cannot be less open
    protected void watch() {}

    public static void main(String[] args) {
        
    }
}