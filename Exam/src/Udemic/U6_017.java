package Udemic;

public class U6_017 {
    public static void main(String[] args) {}
    public void ohNo() throws IOException {
        System.out.println("it's ok");
        // throw new Exception();  // unreported exception ...
        throw new IllegalArgumentException();
        throw new java.io.IOException();
        throw new RuntimeException();
    }
}
