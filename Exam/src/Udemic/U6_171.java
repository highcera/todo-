package Udemic;

public class U6_171 {
    public static void main(String[] args) {
        final Object exception = new Exception();
        final Exception data = (RuntimeException) exception;
        // ClassCastException
        System.out.print(data);
    }
}
